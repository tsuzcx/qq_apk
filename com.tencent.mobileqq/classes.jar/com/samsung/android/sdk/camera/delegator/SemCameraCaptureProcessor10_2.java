package com.samsung.android.sdk.camera.delegator;

import android.content.Context;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Handler;
import android.util.Log;
import android.util.Size;
import com.samsung.android.sep.camera.SemCameraCaptureProcessor;
import com.samsung.android.sep.camera.SemCameraCaptureProcessor.CaptureParameter;
import com.samsung.android.sep.camera.SemCameraCaptureProcessor.DynamicShotInfo;
import com.samsung.android.sep.camera.SemCameraCaptureProcessor.ProcessorParameter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SemCameraCaptureProcessor10_2
  extends AbstractSemCameraCaptureProcessor
{
  private static final String TAG = "SemCameraCaptureProcessor10_2";
  private CameraCharacteristics mCharacteristics;
  private List<AbstractSemCameraCaptureProcessor.ProcessorParameter> mParameterList;
  private AbstractSemCameraCaptureProcessor.CaptureCallback mSDKCaptureCallback = null;
  private SemCameraCaptureProcessor mSemCameraCaptureProcessor;
  private SemCameraCaptureProcessor10_2.SemCaptureCallBack mSemCaptureCallBack;
  
  private List<SemCameraCaptureProcessor.CaptureParameter> getSemParameters(List<AbstractSemCameraCaptureProcessor.CaptureParameter> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null)
    {
      Log.d(TAG, "getSemParameters: SemCaptureParametersSize: 0");
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (AbstractSemCameraCaptureProcessor.CaptureParameter)paramList.next();
      localArrayList.add(new SemCameraCaptureProcessor.CaptureParameter(((AbstractSemCameraCaptureProcessor.CaptureParameter)localObject).getKey(), ((AbstractSemCameraCaptureProcessor.CaptureParameter)localObject).getValue()));
    }
    paramList = TAG;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getSemParameters: SemCaptureParametersSize: ");
    ((StringBuilder)localObject).append(localArrayList.size());
    Log.d(paramList, ((StringBuilder)localObject).toString());
    return localArrayList;
  }
  
  private void setFaceDetectMode(CaptureRequest.Builder paramBuilder)
  {
    Object localObject = this.mCharacteristics;
    if (localObject != null)
    {
      localObject = (int[])((CameraCharacteristics)localObject).get(CameraCharacteristics.STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES);
      int n = localObject.length;
      int i = 0;
      int j = 0;
      int k = 0;
      while (i < n)
      {
        int i1 = localObject[i];
        int m;
        if (i1 == 2)
        {
          m = 1;
        }
        else
        {
          m = j;
          if (i1 == 1)
          {
            k = 1;
            m = j;
          }
        }
        i += 1;
        j = m;
      }
      if (j != 0)
      {
        paramBuilder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, Integer.valueOf(2));
        return;
      }
      if (k != 0) {
        paramBuilder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, Integer.valueOf(1));
      }
    }
  }
  
  public CaptureRequest buildCaptureRequest(CaptureRequest.Builder paramBuilder)
  {
    SemCameraCaptureProcessor localSemCameraCaptureProcessor = this.mSemCameraCaptureProcessor;
    if (localSemCameraCaptureProcessor != null) {
      return localSemCameraCaptureProcessor.buildCaptureRequest(paramBuilder);
    }
    return paramBuilder.build();
  }
  
  public void capture(CameraCaptureSession paramCameraCaptureSession, CaptureResult paramCaptureResult, AbstractSemCameraCaptureProcessor.CaptureCallback paramCaptureCallback, Handler paramHandler, List<AbstractSemCameraCaptureProcessor.CaptureParameter> paramList)
  {
    this.mSDKCaptureCallback = paramCaptureCallback;
    paramCaptureCallback = this.mSemCameraCaptureProcessor;
    if (paramCaptureCallback != null) {
      paramCaptureCallback.capture(paramCameraCaptureSession, new SemCameraCaptureProcessor.DynamicShotInfo(paramCaptureResult), this.mSemCaptureCallBack, paramHandler, getSemParameters(paramList));
    }
  }
  
  public SessionConfiguration createSessionConfiguration(List<OutputConfiguration> paramList, CameraCaptureSession.StateCallback paramStateCallback, Handler paramHandler)
  {
    if (this.mSemCameraCaptureProcessor != null)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createSessionConfiguration: outputConfigurations ");
      localStringBuilder.append(paramList);
      localStringBuilder.append("  stateCallback: ");
      localStringBuilder.append(paramStateCallback);
      Log.i(str, localStringBuilder.toString());
      return this.mSemCameraCaptureProcessor.createSessionConfiguration(paramList, paramStateCallback, paramHandler);
    }
    return null;
  }
  
  public CameraDevice.StateCallback createStateCallback(CameraDevice.StateCallback paramStateCallback, Handler paramHandler)
  {
    SemCameraCaptureProcessor localSemCameraCaptureProcessor = this.mSemCameraCaptureProcessor;
    if (localSemCameraCaptureProcessor != null) {
      return localSemCameraCaptureProcessor.createStateCallback(paramStateCallback, paramHandler);
    }
    return null;
  }
  
  public void deinitialize()
  {
    this.mSemCameraCaptureProcessor.deinitialize();
    this.mSDKCaptureCallback = null;
    this.mSemCaptureCallBack = null;
    this.mSemCameraCaptureProcessor = null;
    this.mCharacteristics = null;
  }
  
  public List<AbstractSemCameraCaptureProcessor.ProcessorParameter> getAvailableParameters()
  {
    Object localObject = this.mSemCameraCaptureProcessor.getAvailableParameters();
    if (this.mParameterList == null)
    {
      this.mParameterList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SemCameraCaptureProcessor.ProcessorParameter localProcessorParameter = (SemCameraCaptureProcessor.ProcessorParameter)((Iterator)localObject).next();
        if (localProcessorParameter == SemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY) {
          this.mParameterList.add(PARAMETER_ENABLE_FACE_BEAUTY);
        } else if (localProcessorParameter == SemCameraCaptureProcessor.PARAMETER_IMAGE_FORMAT) {
          this.mParameterList.add(PARAMETER_IMAGE_FORMAT);
        }
      }
    }
    return Collections.unmodifiableList(this.mParameterList);
  }
  
  public <T> T getProcessorParameter(AbstractSemCameraCaptureProcessor.ProcessorParameter<T> paramProcessorParameter)
  {
    if (paramProcessorParameter == PARAMETER_ENABLE_FACE_BEAUTY) {
      return this.mSemCameraCaptureProcessor.getProcessorParameter(SemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY);
    }
    if (paramProcessorParameter == PARAMETER_IMAGE_FORMAT) {
      return this.mSemCameraCaptureProcessor.getProcessorParameter(SemCameraCaptureProcessor.PARAMETER_IMAGE_FORMAT);
    }
    return null;
  }
  
  public void initialize(Context paramContext, String paramString, Size paramSize)
  {
    this.mSemCameraCaptureProcessor = SemCameraCaptureProcessor.getInstance();
    this.mSemCameraCaptureProcessor.initialize(paramContext, paramString, paramSize);
    this.mSemCaptureCallBack = new SemCameraCaptureProcessor10_2.SemCaptureCallBack(this, null);
    this.mCharacteristics = ((CameraManager)paramContext.getSystemService("camera")).getCameraCharacteristics(paramString);
  }
  
  public <T> void setProcessorParameter(AbstractSemCameraCaptureProcessor.ProcessorParameter<T> paramProcessorParameter, T paramT)
  {
    if (paramProcessorParameter == PARAMETER_ENABLE_FACE_BEAUTY)
    {
      this.mSemCameraCaptureProcessor.setProcessorParameter(SemCameraCaptureProcessor.PARAMETER_ENABLE_FACE_BEAUTY, (Boolean)paramT);
      return;
    }
    if (paramProcessorParameter == PARAMETER_IMAGE_FORMAT) {
      this.mSemCameraCaptureProcessor.setProcessorParameter(SemCameraCaptureProcessor.PARAMETER_IMAGE_FORMAT, (Integer)paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samsung.android.sdk.camera.delegator.SemCameraCaptureProcessor10_2
 * JD-Core Version:    0.7.0.1
 */