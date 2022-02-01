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
  private static final String TAG = SCameraCaptureProcessor.class.getSimpleName();
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
    if (!this.isSCameraProcessorInitialized)
    {
      Log.i(TAG, "checkIsSCameraProcessorInitialized: sdk not initialized");
      throw new IllegalStateException("SCameraCaptureProcessor not initialized");
    }
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
    for (;;)
    {
      try
      {
        String str = AbstractSemCamera.getSEPClientVersion();
        Log.i(TAG, "getSemCameraCaptureProcessor semVersion : " + str);
        if (SsdkVersionCheck.compareVersion(str, "2.0.1") >= 0) {
          this.mSemCameraCaptureProcessor = new SemCameraCaptureProcessor10_2();
        }
        Log.i(TAG, "getSemCameraCaptureProcessor  " + this.mSemCameraCaptureProcessor);
        return this.mSemCameraCaptureProcessor;
      }
      catch (Throwable localThrowable)
      {
        Log.i(TAG, "getSemCameraCaptureProcessor semVersion : SEP_VERSION_10_1 in caught Error:");
        this.mSemCameraCaptureProcessor = new SemCameraCaptureProcessor10_1();
        continue;
      }
      this.mSemCameraCaptureProcessor = new SemCameraCaptureProcessorDefault();
    }
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
      Log.i(TAG, "buildCaptureRequest  : builder " + paramBuilder);
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
  
  /* Error */
  public <T> T getProcessorParameter(SCameraCaptureProcessor.ProcessorParameter<T> paramProcessorParameter)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getstatic 62	com/samsung/android/sdk/camera/SCameraCaptureProcessor:PARAMETER_ENABLE_FACE_BEAUTY	Lcom/samsung/android/sdk/camera/SCameraCaptureProcessor$ProcessorParameter;
    //   6: if_acmpne +18 -> 24
    //   9: aload_0
    //   10: invokespecial 206	com/samsung/android/sdk/camera/SCameraCaptureProcessor:getSemCameraCaptureProcessor	()Lcom/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor;
    //   13: getstatic 251	com/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor:PARAMETER_ENABLE_FACE_BEAUTY	Lcom/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor$ProcessorParameter;
    //   16: invokevirtual 264	com/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor:getProcessorParameter	(Lcom/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor$ProcessorParameter;)Ljava/lang/Object;
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: aload_1
    //   25: getstatic 66	com/samsung/android/sdk/camera/SCameraCaptureProcessor:PARAMETER_IMAGE_FORMAT	Lcom/samsung/android/sdk/camera/SCameraCaptureProcessor$ProcessorParameter;
    //   28: if_acmpne +17 -> 45
    //   31: aload_0
    //   32: invokespecial 206	com/samsung/android/sdk/camera/SCameraCaptureProcessor:getSemCameraCaptureProcessor	()Lcom/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor;
    //   35: getstatic 253	com/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor:PARAMETER_IMAGE_FORMAT	Lcom/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor$ProcessorParameter;
    //   38: invokevirtual 264	com/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor:getProcessorParameter	(Lcom/samsung/android/sdk/camera/delegator/AbstractSemCameraCaptureProcessor$ProcessorParameter;)Ljava/lang/Object;
    //   41: astore_1
    //   42: goto -22 -> 20
    //   45: aconst_null
    //   46: astore_1
    //   47: goto -27 -> 20
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	SCameraCaptureProcessor
    //   0	55	1	paramProcessorParameter	SCameraCaptureProcessor.ProcessorParameter<T>
    // Exception table:
    //   from	to	target	type
    //   2	20	50	finally
    //   24	42	50	finally
  }
  
  public void initialize(Context paramContext, String paramString, Size paramSize)
  {
    try
    {
      Log.i(TAG, "initialize: cameraId - " + paramString + ", pictureSize - " + paramSize);
      if (SCamera.getInstance().checkAvailability(paramContext) != 0) {
        throw new UnsupportedOperationException("CameraSdk not supported");
      }
    }
    finally {}
    try
    {
      String str = AbstractSemCamera.getSEPClientVersion();
      Log.i(TAG, "getSemCameraCaptureProcessor semVersion : " + str);
      if ((SsdkVersionCheck.compareVersion(str, "2.0.2") == 0) && (paramString.equals("2"))) {
        throw new IllegalArgumentException("cameraId unsupported by SDK");
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      this.mContext = paramContext;
      getSemCameraCaptureProcessor().initialize(paramContext, paramString, paramSize);
      this.mPreviewCaptureCallback = new SCameraCaptureProcessor.PreviewCaptureCallback(this, null);
      this.mSemCaptureCallBack = new SCameraCaptureProcessor.SemCaptureCallBack(this, null);
      this.isSCameraProcessorInitialized = true;
    }
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
    for (;;)
    {
      try
      {
        checkIsSCameraProcessorInitialized();
        if (paramProcessorParameter == PARAMETER_ENABLE_FACE_BEAUTY)
        {
          if ((paramT instanceof Boolean))
          {
            getSemCameraCaptureProcessor().setProcessorParameter(AbstractSemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY, (Boolean)paramT);
            return;
          }
          throw new IllegalArgumentException("argument for PARAMETER_ENABLE_FACE_BEAUTY should be of type Boolean");
        }
      }
      finally {}
      if (paramProcessorParameter == PARAMETER_IMAGE_FORMAT)
      {
        if (!(paramT instanceof Integer)) {
          break;
        }
        getSemCameraCaptureProcessor().setProcessorParameter(AbstractSemCameraCaptureProcessor.PARAMETER_IMAGE_FORMAT, (Integer)paramT);
      }
    }
    throw new IllegalArgumentException("argument for PARAMETER_IMAGE_FORMAT should be of type Integer");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samsung.android.sdk.camera.SCameraCaptureProcessor
 * JD-Core Version:    0.7.0.1
 */