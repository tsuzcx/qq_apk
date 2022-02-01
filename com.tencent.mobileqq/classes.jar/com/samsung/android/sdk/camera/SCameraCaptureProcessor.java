package com.samsung.android.sdk.camera;

import android.content.Context;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Handler;
import android.util.Log;
import android.util.Size;
import com.samsung.android.sdk.camera.delegator.AbstractSemCamera;
import com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor;
import com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor.CaptureParameter;
import com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor.ProcessorParameter;
import com.samsung.android.sdk.camera.delegator.SemCameraCaptureProcessor10_1;
import com.samsung.android.sdk.camera.delegator.SemCameraCaptureProcessor10_2;
import com.samsung.android.sdk.camera.delegator.SemCameraCaptureProcessorDefault;
import com.samsung.android.sdk.camera.util.SsdkVersionCheck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SCameraCaptureProcessor
{
  private static final String CAMERA_ID_REAR_WIDE = "2";
  public static final int IMAGE_FORMAT_JPEG = 256;
  public static final int IMAGE_FORMAT_NV21 = 17;
  public static final SCameraCaptureProcessor.ProcessorParameter<Boolean> PARAMETER_ENABLE_FACE_BEAUTY = new SCameraCaptureProcessor.ProcessorParameter("beauty_parameter");
  public static final SCameraCaptureProcessor.ProcessorParameter<Integer> PARAMETER_IMAGE_FORMAT = new SCameraCaptureProcessor.ProcessorParameter("image_format");
  private static final String TAG = "SCameraCaptureProcessor";
  private static SCameraCaptureProcessor mSCameraCaptureProcessor;
  private volatile boolean isSCameraProcessorInitialized = false;
  private SCameraCaptureProcessor.CaptureCallback mAppCaptureCallback = null;
  private Handler mAppCaptureHandler;
  private CameraCaptureSession.CaptureCallback mAppPreviewCaptureCallback;
  private Context mContext;
  private List<SCameraCaptureProcessor.ProcessorParameter> mParameterList;
  private SCameraCaptureProcessor.PreviewCaptureCallback mPreviewCaptureCallback;
  private CaptureResult mPreviewCaptureResult;
  private AbstractSemCameraCaptureProcessor mSemCameraCaptureProcessor;
  private SCameraCaptureProcessor.SemCaptureCallBack mSemCaptureCallBack;
  
  private void checkIsSCameraProcessorInitialized()
  {
    if (this.isSCameraProcessorInitialized) {
      return;
    }
    Log.i(TAG, "checkIsSCameraProcessorInitialized: sdk not initialized");
    throw new IllegalStateException("SCameraCaptureProcessor not initialized");
  }
  
  public static SCameraCaptureProcessor getInstance()
  {
    try
    {
      if (mSCameraCaptureProcessor == null) {
        mSCameraCaptureProcessor = new SCameraCaptureProcessor();
      }
      SCameraCaptureProcessor localSCameraCaptureProcessor = mSCameraCaptureProcessor;
      return localSCameraCaptureProcessor;
    }
    finally {}
  }
  
  private AbstractSemCameraCaptureProcessor getSemCameraCaptureProcessor()
  {
    if ((this.mSemCameraCaptureProcessor != null) || (AbstractSemCamera.getSepPlatformVersion(this.mContext) >= 100100)) {}
    try
    {
      str = AbstractSemCamera.getSEPClientVersion();
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSemCameraCaptureProcessor semVersion : ");
      localStringBuilder.append(str);
      Log.i((String)localObject, localStringBuilder.toString());
      if (SsdkVersionCheck.compareVersion(str, "2.0.1") < 0) {
        break label114;
      }
      this.mSemCameraCaptureProcessor = new SemCameraCaptureProcessor10_2();
    }
    catch (Throwable localThrowable)
    {
      String str;
      Object localObject;
      label80:
      break label80;
    }
    Log.i(TAG, "getSemCameraCaptureProcessor semVersion : SEP_VERSION_10_1 in caught Error:");
    this.mSemCameraCaptureProcessor = new SemCameraCaptureProcessor10_1();
    break label114;
    this.mSemCameraCaptureProcessor = new SemCameraCaptureProcessorDefault();
    label114:
    str = TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getSemCameraCaptureProcessor  ");
    ((StringBuilder)localObject).append(this.mSemCameraCaptureProcessor);
    Log.i(str, ((StringBuilder)localObject).toString());
    return this.mSemCameraCaptureProcessor;
  }
  
  private List<AbstractSemCameraCaptureProcessor.CaptureParameter> getSemParameters(List<SCameraCaptureProcessor.CaptureParameter> paramList)
  {
    checkIsSCameraProcessorInitialized();
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SCameraCaptureProcessor.CaptureParameter localCaptureParameter = (SCameraCaptureProcessor.CaptureParameter)paramList.next();
      localArrayList.add(new AbstractSemCameraCaptureProcessor.CaptureParameter(SCameraCaptureProcessor.CaptureParameter.access$200(localCaptureParameter), SCameraCaptureProcessor.CaptureParameter.access$300(localCaptureParameter)));
    }
    return localArrayList;
  }
  
  public CaptureRequest buildCaptureRequest(CaptureRequest.Builder paramBuilder)
  {
    try
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("buildCaptureRequest  : builder ");
      localStringBuilder.append(paramBuilder);
      Log.i(str, localStringBuilder.toString());
      checkIsSCameraProcessorInitialized();
      paramBuilder = getSemCameraCaptureProcessor().buildCaptureRequest(paramBuilder);
      return paramBuilder;
    }
    finally
    {
      paramBuilder = finally;
      throw paramBuilder;
    }
  }
  
  public void capture(CameraCaptureSession paramCameraCaptureSession, SCameraCaptureProcessor.CaptureCallback paramCaptureCallback, Handler paramHandler, List<SCameraCaptureProcessor.CaptureParameter> paramList)
  {
    try
    {
      checkIsSCameraProcessorInitialized();
      this.mAppCaptureCallback = paramCaptureCallback;
      getSemCameraCaptureProcessor().capture(paramCameraCaptureSession, this.mPreviewCaptureResult, this.mSemCaptureCallBack, paramHandler, getSemParameters(paramList));
      return;
    }
    finally
    {
      paramCameraCaptureSession = finally;
      throw paramCameraCaptureSession;
    }
  }
  
  public CameraCaptureSession.CaptureCallback createCaptureCallback(CameraCaptureSession.CaptureCallback paramCaptureCallback, Handler paramHandler)
  {
    try
    {
      Log.i(TAG, "createCaptureCallback");
      checkIsSCameraProcessorInitialized();
      this.mAppPreviewCaptureCallback = paramCaptureCallback;
      this.mAppCaptureHandler = paramHandler;
      paramCaptureCallback = this.mPreviewCaptureCallback;
      return paramCaptureCallback;
    }
    finally
    {
      paramCaptureCallback = finally;
      throw paramCaptureCallback;
    }
  }
  
  public SessionConfiguration createSessionConfiguration(List<OutputConfiguration> paramList, CameraCaptureSession.StateCallback paramStateCallback, Handler paramHandler)
  {
    try
    {
      checkIsSCameraProcessorInitialized();
      paramList = getSemCameraCaptureProcessor().createSessionConfiguration(paramList, paramStateCallback, paramHandler);
      return paramList;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public CameraDevice.StateCallback createStateCallback(CameraDevice.StateCallback paramStateCallback, Handler paramHandler)
  {
    try
    {
      checkIsSCameraProcessorInitialized();
      paramStateCallback = getSemCameraCaptureProcessor().createStateCallback(paramStateCallback, paramHandler);
      return paramStateCallback;
    }
    finally
    {
      paramStateCallback = finally;
      throw paramStateCallback;
    }
  }
  
  public void deinitialize()
  {
    try
    {
      Log.i(TAG, "deinitialize");
      checkIsSCameraProcessorInitialized();
      getSemCameraCaptureProcessor().deinitialize();
      this.mAppCaptureCallback = null;
      this.mAppCaptureHandler = null;
      this.mPreviewCaptureResult = null;
      this.mAppPreviewCaptureCallback = null;
      this.mSemCaptureCallBack = null;
      this.mPreviewCaptureCallback = null;
      this.mParameterList = null;
      this.isSCameraProcessorInitialized = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<SCameraCaptureProcessor.ProcessorParameter> getAvailableParameters()
  {
    checkIsSCameraProcessorInitialized();
    Object localObject = getSemCameraCaptureProcessor().getAvailableParameters();
    if (this.mParameterList == null)
    {
      this.mParameterList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbstractSemCameraCaptureProcessor.ProcessorParameter localProcessorParameter = (AbstractSemCameraCaptureProcessor.ProcessorParameter)((Iterator)localObject).next();
        if (localProcessorParameter == AbstractSemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY) {
          this.mParameterList.add(PARAMETER_ENABLE_FACE_BEAUTY);
        } else if (localProcessorParameter == AbstractSemCameraCaptureProcessor.PARAMETER_IMAGE_FORMAT) {
          this.mParameterList.add(PARAMETER_IMAGE_FORMAT);
        }
      }
    }
    return Collections.unmodifiableList(this.mParameterList);
  }
  
  public <T> T getProcessorParameter(SCameraCaptureProcessor.ProcessorParameter<T> paramProcessorParameter)
  {
    try
    {
      if (paramProcessorParameter == PARAMETER_ENABLE_FACE_BEAUTY)
      {
        paramProcessorParameter = getSemCameraCaptureProcessor().getProcessorParameter(AbstractSemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY);
        return paramProcessorParameter;
      }
      if (paramProcessorParameter == PARAMETER_IMAGE_FORMAT)
      {
        paramProcessorParameter = getSemCameraCaptureProcessor().getProcessorParameter(AbstractSemCameraCaptureProcessor.PARAMETER_IMAGE_FORMAT);
        return paramProcessorParameter;
      }
      return null;
    }
    finally {}
  }
  
  public void initialize(Context paramContext, String paramString, Size paramSize)
  {
    String str;
    Object localObject;
    StringBuilder localStringBuilder;
    label153:
    try
    {
      str = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initialize: cameraId - ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", pictureSize - ");
      ((StringBuilder)localObject).append(paramSize);
      Log.i(str, ((StringBuilder)localObject).toString());
      int i = SCamera.getInstance().checkAvailability(paramContext);
      if (i != 0) {}
    }
    finally {}
    try
    {
      str = AbstractSemCamera.getSEPClientVersion();
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSemCameraCaptureProcessor semVersion : ");
      localStringBuilder.append(str);
      Log.i((String)localObject, localStringBuilder.toString());
      if ((SsdkVersionCheck.compareVersion(str, "2.0.2") == 0) && (paramString.equals("2"))) {
        throw new IllegalArgumentException("cameraId unsupported by SDK");
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      break label153;
    }
    this.mContext = paramContext;
    getSemCameraCaptureProcessor().initialize(paramContext, paramString, paramSize);
    this.mPreviewCaptureCallback = new SCameraCaptureProcessor.PreviewCaptureCallback(this, null);
    this.mSemCaptureCallBack = new SCameraCaptureProcessor.SemCaptureCallBack(this, null);
    this.isSCameraProcessorInitialized = true;
    return;
    throw new UnsupportedOperationException("CameraSdk not supported");
  }
  
  public boolean isInitialized()
  {
    try
    {
      boolean bool = this.isSCameraProcessorInitialized;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public <T> void setProcessorParameter(SCameraCaptureProcessor.ProcessorParameter<T> paramProcessorParameter, T paramT)
  {
    try
    {
      checkIsSCameraProcessorInitialized();
      if (paramProcessorParameter == PARAMETER_ENABLE_FACE_BEAUTY)
      {
        if ((paramT instanceof Boolean)) {
          getSemCameraCaptureProcessor().setProcessorParameter(AbstractSemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY, (Boolean)paramT);
        } else {
          throw new IllegalArgumentException("argument for PARAMETER_ENABLE_FACE_BEAUTY should be of type Boolean");
        }
      }
      else if (paramProcessorParameter == PARAMETER_IMAGE_FORMAT) {
        if ((paramT instanceof Integer)) {
          getSemCameraCaptureProcessor().setProcessorParameter(AbstractSemCameraCaptureProcessor.PARAMETER_IMAGE_FORMAT, (Integer)paramT);
        } else {
          throw new IllegalArgumentException("argument for PARAMETER_IMAGE_FORMAT should be of type Integer");
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samsung.android.sdk.camera.SCameraCaptureProcessor
 * JD-Core Version:    0.7.0.1
 */