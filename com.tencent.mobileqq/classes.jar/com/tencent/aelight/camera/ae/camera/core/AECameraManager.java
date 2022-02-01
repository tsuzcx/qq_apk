package com.tencent.aelight.camera.ae.camera.core;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.camera2.CameraCharacteristics;
import android.media.Image;
import android.media.Image.Plane;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings.System;
import android.util.SizeF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.RequiresApi;
import com.tencent.aelight.camera.ae.camera.AECaptureParam;
import com.tencent.aelight.camera.ae.perf.AELaunchRecorder;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker;
import com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker.DarkModeListener;
import com.tencent.mobileqq.videocodec.audio.AudioCapture;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqcamerakit.capture.CameraPreviewCallBack;
import com.tencent.qqcamerakit.capture.CameraProxy;
import com.tencent.qqcamerakit.capture.CameraProxy.PictureCallback;
import com.tencent.qqcamerakit.capture.CameraSize;
import com.tencent.qqcamerakit.capture.cameraextend.FocusOperator;
import com.tencent.qqcamerakit.capture.camerastrategy.CameraAPIStrategy;
import com.tencent.qqcamerakit.common.Observer;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class AECameraManager
  extends CameraPreviewCallBack
  implements Observer
{
  private static final int STATE_CLOSED = 0;
  private static final int STATE_OPENED = 2;
  private static final int STATE_OPEN_REQUESTING = 1;
  private static final int STATE_PREVIEWING = 4;
  private static final int STATE_PREVIEW_REQUESTING = 3;
  private static final String TAG = "AECameraManager";
  private int activityOrientation;
  private AECaptureParam aeCaptureParam;
  private AudioCapture audioCapture;
  private final Handler cameraManagerHandler;
  private int cameraPreviewHeight;
  private int cameraPreviewWidth;
  private final CameraProxy cameraProxy;
  private final AtomicInteger cameraState;
  private DarkModeChecker darkModeChecker;
  private boolean darkModeEnable;
  private int darkModeHeight;
  private DarkModeChecker.DarkModeListener darkModeListener;
  private int darkModeWidth;
  private View flashMask;
  private boolean flashSwitcher;
  private FocusOperator focusOperator;
  private boolean gotFirstPreviewData;
  private boolean isDynamicResolutionMode;
  private int lastBrightMode;
  private int lastBrightness;
  private AECameraManager.CameraManagerListener mListener;
  private Matrix mScreenToCameraMatrix;
  private boolean manualFocused;
  private boolean restoreBright;
  private int selectedCamera;
  
  public AECameraManager()
  {
    Object localObject = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(" ");
    localStringBuilder.append(Build.MODEL);
    this.cameraProxy = new CameraProxy((Context)localObject, null, "Google Pixel 4 XL".equals(localStringBuilder.toString()) ^ true);
    this.mScreenToCameraMatrix = new Matrix();
    this.activityOrientation = 0;
    this.isDynamicResolutionMode = false;
    this.manualFocused = false;
    this.flashSwitcher = false;
    this.restoreBright = false;
    this.selectedCamera = 1;
    this.cameraState = new AtomicInteger(0);
    this.gotFirstPreviewData = false;
    if (!CameraUtils.d()) {
      this.selectedCamera = 2;
    }
    localObject = new HandlerThread("AECameraManagerHandlerThread");
    ((HandlerThread)localObject).start();
    this.cameraManagerHandler = new Handler(((HandlerThread)localObject).getLooper());
  }
  
  private boolean isCameraCreated()
  {
    return this.cameraState.get() >= 1;
  }
  
  private boolean isCameraPreviewing()
  {
    return this.cameraState.get() >= 3;
  }
  
  private void onCameraSizeSelected(CameraSize paramCameraSize)
  {
    this.cameraPreviewWidth = paramCameraSize.b;
    this.cameraPreviewHeight = paramCameraSize.a;
    paramCameraSize = this.mListener;
    if (paramCameraSize != null) {
      paramCameraSize.onCameraPreviewSizeChanged(this.cameraPreviewWidth, this.cameraPreviewHeight);
    }
  }
  
  private void openCameraInternal(AECameraManager.CameraOpenCallback paramCameraOpenCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openCameraInternal---cameraCreated=");
    localStringBuilder.append(isCameraCreated());
    AEQLog.b("AECameraManager", localStringBuilder.toString());
    try
    {
      if (isCameraCreated())
      {
        AEQLog.d("AECameraManager", "openCameraInternal---camera already created, recreate camera without close camera first");
        return;
      }
      this.cameraProxy.a(this);
      this.cameraProxy.a(this.selectedCamera);
      this.cameraState.set(2);
      AEQLog.b("AECameraManager", "openCameraInternal---cameraCreated normally");
      if (this.audioCapture != null) {
        this.audioCapture.h();
      }
      com.tencent.mobileqq.activity.richmedia.FlowCameraConstant.a = this.selectedCamera;
      AELaunchRecorder.a().a("openCamera-end");
      return;
    }
    finally
    {
      if (paramCameraOpenCallback != null) {
        paramCameraOpenCallback.onOpenResult(this.selectedCamera, isCameraCreated());
      }
    }
  }
  
  private void realStartPreview(SurfaceTexture paramSurfaceTexture, Size paramSize)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("realStartPreview---ENTER, previewTexture=");
    localStringBuilder.append(paramSurfaceTexture);
    localStringBuilder.append(", previewSize=");
    localStringBuilder.append(paramSize);
    AEQLog.b("AECameraManager", localStringBuilder.toString());
    this.cameraState.set(3);
    this.aeCaptureParam.i(paramSize.a);
    this.aeCaptureParam.j(paramSize.b);
    this.cameraProxy.a(new CameraSize(paramSize.a, paramSize.b), new CameraSize(paramSize.a, paramSize.b), new CameraSize(paramSize.a, paramSize.b), 30);
    this.cameraProxy.a(paramSurfaceTexture, this);
    this.cameraState.set(4);
    paramSurfaceTexture = this.mListener;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.onCameraPreviewStarted();
    }
    AEQLog.b("AECameraManager", "realStartPreview---EXIT");
    AELaunchRecorder.a().a("startCameraPreview-end");
  }
  
  private void setAeCaptureParam(AECaptureParam paramAECaptureParam)
  {
    this.aeCaptureParam = paramAECaptureParam;
  }
  
  private void stopCameraInternal(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stopCameraInternal---ENTER, cameraCreated=");
    ((StringBuilder)localObject).append(isCameraCreated());
    ((StringBuilder)localObject).append(", forceStop=");
    ((StringBuilder)localObject).append(paramBoolean);
    AEQLog.b("AECameraManager", ((StringBuilder)localObject).toString());
    if ((!paramBoolean) && (!isCameraCreated()))
    {
      AEQLog.d("AECameraManager", "stopCameraInternal---EXIT, not created, do nothing");
      return;
    }
    this.cameraProxy.a(false);
    this.cameraProxy.b(false);
    this.cameraState.set(0);
    localObject = this.audioCapture;
    if (localObject != null) {
      ((AudioCapture)localObject).i();
    }
    this.cameraProxy.b(this);
    AEQLog.b("AECameraManager", "stopCameraInternal---EXIT, normally");
  }
  
  private void turnFrontFlash(Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.flashMask == null) {
        this.flashMask = new View(paramActivity);
      }
      this.flashMask.setBackgroundColor(-1);
      this.flashMask.setAlpha(0.7F);
      if (this.flashMask.getParent() != null) {
        ((ViewGroup)this.flashMask.getParent()).removeView(this.flashMask);
      }
      paramActivity.addContentView(this.flashMask, new ViewGroup.LayoutParams(-1, -1));
      try
      {
        this.lastBrightMode = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness_mode");
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness_mode", 0);
        this.lastBrightness = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness");
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness", 255);
        this.restoreBright = true;
        return;
      }
      catch (Exception paramActivity)
      {
        this.lastBrightMode = 1;
        this.lastBrightness = 100;
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.e("AECameraManager", 2, "turn FrontFlash Error ", paramActivity);
      paramActivity.printStackTrace();
    }
    else
    {
      if (this.restoreBright)
      {
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness", this.lastBrightness);
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness_mode", this.lastBrightMode);
        this.restoreBright = false;
      }
      paramActivity = this.flashMask;
      if ((paramActivity != null) && (paramActivity.getParent() != null)) {
        ((ViewGroup)this.flashMask.getParent()).removeView(this.flashMask);
      }
    }
  }
  
  public void cameraStopPreview()
  {
    this.cameraManagerHandler.post(new AECameraManager.6(this));
  }
  
  public void capturePhoto(File paramFile, int paramInt, CameraProxy.PictureCallback paramPictureCallback, Size paramSize)
  {
    this.cameraManagerHandler.post(new AECameraManager.7(this, paramSize, paramFile, paramPictureCallback));
  }
  
  public void changeCamera(int paramInt, AECameraManager.CameraOpenCallback paramCameraOpenCallback)
  {
    this.cameraManagerHandler.post(new AECameraManager.4(this, paramInt, paramCameraOpenCallback));
  }
  
  public int getActivityOrientation()
  {
    return this.activityOrientation;
  }
  
  public int getAnotherCamera()
  {
    return (this.selectedCamera + 1) % 2;
  }
  
  public String getDefaultFocusMode()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[@] getDefaultFocusMode: Build.MANUFACTURER=");
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append("VERSION.SDK_INT=");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      QLog.i("AECameraManager", 2, localStringBuilder.toString());
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
      int i = Build.VERSION.SDK_INT;
    }
    return "continuous-picture";
  }
  
  public float getHorizontalViewAngle()
  {
    Object localObject1 = this.cameraProxy.a();
    if ((Build.VERSION.SDK_INT >= 21) && ((localObject1 instanceof CameraCharacteristics)))
    {
      Object localObject2 = (CameraCharacteristics)localObject1;
      localObject1 = (SizeF)((CameraCharacteristics)localObject2).get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
      localObject2 = (float[])((CameraCharacteristics)localObject2).get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
      if ((localObject2 != null) && (localObject2.length > 0)) {
        return (float)(Math.atan(((SizeF)localObject1).getWidth() / (localObject2[0] * 2.0F)) * 2.0D * 180.0D / 3.141592653589793D);
      }
    }
    else if ((localObject1 instanceof Camera.Parameters))
    {
      return ((Camera.Parameters)localObject1).getHorizontalViewAngle();
    }
    return -1.0F;
  }
  
  public int getSelectedCamera()
  {
    return this.selectedCamera;
  }
  
  public void init(AECaptureParam paramAECaptureParam)
  {
    this.darkModeChecker = new DarkModeChecker();
    setAeCaptureParam(paramAECaptureParam);
    this.selectedCamera = paramAECaptureParam.g();
    if ((this.selectedCamera == 1) && (!CameraUtils.d())) {
      this.selectedCamera = 2;
    }
  }
  
  public boolean isFlashEnabled()
  {
    return this.flashSwitcher;
  }
  
  public boolean isFrontCamera()
  {
    return this.selectedCamera == 1;
  }
  
  public boolean isSupportCamera2()
  {
    return CameraAPIStrategy.a;
  }
  
  public void notify(int paramInt1, int paramInt2, String paramString, Object... paramVarArgs)
  {
    AELaunchRecorder localAELaunchRecorder = AELaunchRecorder.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【CameraProxy notify】eventId=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", args=");
    localStringBuilder.append(Arrays.toString(paramVarArgs));
    localAELaunchRecorder.a("AECameraManager", localStringBuilder.toString());
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 11) {
          return;
        }
        if ((paramVarArgs != null) && (paramVarArgs.length <= 0))
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("onDispatchThreadException---");
          paramVarArgs.append(paramInt1);
          paramVarArgs.append("errorMsg");
          paramVarArgs.append(paramString);
          AEQLog.d("AECameraManager", paramVarArgs.toString());
          return;
        }
        paramString = (Exception)paramVarArgs[0];
        if (paramString != null)
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("onDispatchThreadException---");
          paramVarArgs.append(paramString.getMessage());
          AEQLog.a("AECameraManager", paramVarArgs.toString(), paramString);
          return;
        }
        paramString = new StringBuilder();
        paramString.append("onDispatchThreadException---");
        paramString.append(paramInt1);
        AEQLog.d("AECameraManager", paramString.toString());
        return;
      }
      if ((paramVarArgs != null) && (paramVarArgs.length <= 0))
      {
        AEQLog.b("AECameraManager", "【Camera Open Success】EVENT_SET_CAMERA_PARAM");
        return;
      }
      if ((paramVarArgs[0] instanceof CameraSize))
      {
        onCameraSizeSelected((CameraSize)paramVarArgs[0]);
        paramString = this.mListener;
        if (paramString != null)
        {
          paramString.onCameraStarted(true, "");
          AEQLog.b("AECameraManager", "【Camera Open Success】EVENT_SET_CAMERA_PARAM");
        }
        if ((paramVarArgs.length >= 2) && ((paramVarArgs[1] instanceof CameraSize)))
        {
          paramString = (CameraSize)paramVarArgs[1];
          this.darkModeWidth = paramString.a;
          this.darkModeHeight = paramString.b;
        }
      }
      else if ((paramVarArgs[0] instanceof String))
      {
        paramString = this.mListener;
        if (paramString != null)
        {
          paramString.onCameraStarted(false, (String)paramVarArgs[0]);
          paramString = new StringBuilder();
          paramString.append("【Camera Open Error】EVENT_SET_CAMERA_PARAM:");
          paramString.append(paramVarArgs[0]);
          AEQLog.d("AECameraManager", paramString.toString());
        }
      }
    }
    else
    {
      if ((paramVarArgs != null) && (paramVarArgs.length <= 0))
      {
        AEQLog.d("AECameraManager", "【Camera Open Error】EVENT_CREATE_CAMERA:");
        return;
      }
      if ((paramVarArgs[0] instanceof String))
      {
        paramString = this.mListener;
        if (paramString != null)
        {
          paramString.onCameraStarted(false, (String)paramVarArgs[0]);
          paramString = new StringBuilder();
          paramString.append("【Camera Open Error】EVENT_CREATE_CAMERA:");
          paramString.append(paramVarArgs[0]);
          AEQLog.d("AECameraManager", paramString.toString());
        }
      }
    }
  }
  
  @RequiresApi(api=19)
  public void onPreviewFrame(Image paramImage)
  {
    super.onPreviewFrame(paramImage);
    if (!this.gotFirstPreviewData)
    {
      this.gotFirstPreviewData = true;
      AELaunchRecorder.a().a("onCameraPreviewFrameData");
    }
    paramImage = paramImage.getPlanes()[0].getBuffer();
    byte[] arrayOfByte = new byte[paramImage.remaining()];
    paramImage.get(arrayOfByte);
    if (this.darkModeEnable)
    {
      int m = this.cameraPreviewWidth;
      int n = this.cameraPreviewHeight;
      int i1 = this.darkModeWidth;
      int j = n;
      int i = m;
      if (i1 > 0)
      {
        int k = this.darkModeHeight;
        j = n;
        i = m;
        if (k > 0)
        {
          j = i1;
          i = k;
        }
      }
      this.darkModeChecker.a(arrayOfByte, i, j, this.darkModeListener);
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (!this.gotFirstPreviewData)
    {
      this.gotFirstPreviewData = true;
      AELaunchRecorder.a().a("onCameraPreviewFrameData");
    }
    if (this.darkModeEnable)
    {
      int m = this.cameraPreviewWidth;
      int n = this.cameraPreviewHeight;
      int i1 = this.darkModeWidth;
      int j = n;
      int i = m;
      if (i1 > 0)
      {
        int k = this.darkModeHeight;
        j = n;
        i = m;
        if (k > 0)
        {
          j = i1;
          i = k;
        }
      }
      this.darkModeChecker.a(paramArrayOfByte, i, j, this.darkModeListener);
    }
  }
  
  public void openCamera(AECameraManager.CameraOpenCallback paramCameraOpenCallback)
  {
    AELaunchRecorder.a().a("openCamera-begin");
    this.cameraManagerHandler.post(new AECameraManager.1(this, paramCameraOpenCallback));
  }
  
  public void refreshDarkModeTimer()
  {
    DarkModeChecker localDarkModeChecker = this.darkModeChecker;
    if (localDarkModeChecker != null) {
      localDarkModeChecker.a();
    }
  }
  
  public void requestCameraFocus(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.cameraManagerHandler.post(new AECameraManager.8(this, paramFloat1, paramFloat2, paramInt1, paramInt2));
  }
  
  public boolean requestFocusBeforeTakePicture()
  {
    return (this.flashSwitcher) && (!this.manualFocused);
  }
  
  public void setActivityOrientation(int paramInt)
  {
    this.activityOrientation = paramInt;
  }
  
  public void setAudioCapture(AudioCapture paramAudioCapture)
  {
    this.audioCapture = paramAudioCapture;
  }
  
  public void setCameraManagerListener(AECameraManager.CameraManagerListener paramCameraManagerListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("### setCameraManagerListener--- listener=");
    localStringBuilder.append(paramCameraManagerListener);
    AEQLog.b("AECameraManager", localStringBuilder.toString());
    this.mListener = paramCameraManagerListener;
  }
  
  public void setDarkModeChecker(DarkModeChecker paramDarkModeChecker)
  {
    this.darkModeChecker = paramDarkModeChecker;
  }
  
  public void setDarkModeEnable(boolean paramBoolean)
  {
    this.darkModeEnable = paramBoolean;
  }
  
  public void setDarkModeListener(DarkModeChecker.DarkModeListener paramDarkModeListener)
  {
    this.darkModeListener = paramDarkModeListener;
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.isDynamicResolutionMode = paramBoolean;
  }
  
  public void setFocusModeRecording()
  {
    this.cameraManagerHandler.post(new AECameraManager.11(this));
  }
  
  public void setFocusOperatorMatrix(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FocusOperator localFocusOperator = this.focusOperator;
    if (localFocusOperator != null) {
      this.mScreenToCameraMatrix = localFocusOperator.a(paramInt2, paramInt1, paramInt3, paramInt4, this.selectedCamera);
    }
  }
  
  public void setSelectedCamera(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1)) {
      return;
    }
    if ((paramInt == 1) && (!CameraUtils.d())) {
      return;
    }
    this.cameraManagerHandler.post(new AECameraManager.12(this, paramInt));
  }
  
  public void setZoom(int paramInt)
  {
    this.cameraManagerHandler.post(new AECameraManager.10(this, paramInt));
  }
  
  public void startCameraPreview(SurfaceTexture paramSurfaceTexture, Size paramSize)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startCameraPreview ENTER---previewTexture=");
    localStringBuilder.append(paramSurfaceTexture);
    localStringBuilder.append(", previewSize=");
    localStringBuilder.append(paramSize);
    AEQLog.b("AECameraManager", localStringBuilder.toString());
    if ((paramSurfaceTexture != null) && (paramSize != null))
    {
      if (Math.min(paramSize.a, paramSize.b) <= 0) {
        return;
      }
      AELaunchRecorder.a().a("startCameraPreview-begin");
      this.cameraManagerHandler.post(new AECameraManager.5(this, paramSurfaceTexture, paramSize));
    }
  }
  
  public void stopCamera(boolean paramBoolean)
  {
    this.cameraManagerHandler.post(new AECameraManager.2(this, paramBoolean));
  }
  
  public void stopRecordVideo()
  {
    this.cameraManagerHandler.post(new AECameraManager.9(this));
  }
  
  public void switchFlash(boolean paramBoolean)
  {
    this.flashSwitcher = paramBoolean;
  }
  
  public void toggleCamera(AECameraManager.CameraOpenCallback paramCameraOpenCallback)
  {
    if (!CameraUtils.d())
    {
      AEQLog.d("AECameraManager", "toggleCamera---front camera not exists, not support toggle");
      paramCameraOpenCallback.onOpenResult(this.selectedCamera, false);
      return;
    }
    this.cameraManagerHandler.post(new AECameraManager.3(this, paramCameraOpenCallback));
  }
  
  public void turnFlash(Activity paramActivity, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("turnFlash");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" selectedCamera ");
    localStringBuilder.append(this.selectedCamera);
    AEQLog.a("AECameraManager", localStringBuilder.toString());
    if (this.selectedCamera == 1)
    {
      turnFrontFlash(paramActivity, paramBoolean);
      return;
    }
    this.cameraProxy.c(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraManager
 * JD-Core Version:    0.7.0.1
 */