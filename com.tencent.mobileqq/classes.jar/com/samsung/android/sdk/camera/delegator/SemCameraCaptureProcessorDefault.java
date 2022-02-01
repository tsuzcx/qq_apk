package com.samsung.android.sdk.camera.delegator;

import android.content.Context;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Handler;
import android.util.Size;
import java.util.List;

public class SemCameraCaptureProcessorDefault
  extends AbstractSemCameraCaptureProcessor
{
  public CaptureRequest buildCaptureRequest(CaptureRequest.Builder paramBuilder)
  {
    throw new UnsupportedOperationException("SEP VERSION NOT SUPPORTED!!!");
  }
  
  public void capture(CameraCaptureSession paramCameraCaptureSession, CaptureResult paramCaptureResult, AbstractSemCameraCaptureProcessor.CaptureCallback paramCaptureCallback, Handler paramHandler, List<AbstractSemCameraCaptureProcessor.CaptureParameter> paramList)
  {
    throw new UnsupportedOperationException("SEP VERSION NOT SUPPORTED!!!");
  }
  
  public SessionConfiguration createSessionConfiguration(List<OutputConfiguration> paramList, CameraCaptureSession.StateCallback paramStateCallback, Handler paramHandler)
  {
    throw new UnsupportedOperationException("SEP VERSION NOT SUPPORTED!!!");
  }
  
  public CameraDevice.StateCallback createStateCallback(CameraDevice.StateCallback paramStateCallback, Handler paramHandler)
  {
    throw new UnsupportedOperationException("SEP VERSION NOT SUPPORTED!!!");
  }
  
  public void deinitialize()
  {
    throw new UnsupportedOperationException("SEP VERSION NOT SUPPORTED!!!");
  }
  
  public List<AbstractSemCameraCaptureProcessor.ProcessorParameter> getAvailableParameters()
  {
    throw new UnsupportedOperationException("SEP VERSION NOT SUPPORTED!!!");
  }
  
  public <T> T getProcessorParameter(AbstractSemCameraCaptureProcessor.ProcessorParameter<T> paramProcessorParameter)
  {
    throw new UnsupportedOperationException("SEP VERSION NOT SUPPORTED!!!");
  }
  
  public void initialize(Context paramContext, String paramString, Size paramSize)
  {
    throw new UnsupportedOperationException("SEP VERSION NOT SUPPORTED!!!");
  }
  
  public <T> void setProcessorParameter(AbstractSemCameraCaptureProcessor.ProcessorParameter<T> paramProcessorParameter, T paramT)
  {
    throw new UnsupportedOperationException("SEP VERSION NOT SUPPORTED!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.samsung.android.sdk.camera.delegator.SemCameraCaptureProcessorDefault
 * JD-Core Version:    0.7.0.1
 */