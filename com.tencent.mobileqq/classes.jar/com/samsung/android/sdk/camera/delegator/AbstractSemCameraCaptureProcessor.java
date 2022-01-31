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

public abstract class AbstractSemCameraCaptureProcessor
{
  public static final AbstractSemCameraCaptureProcessor.ProcessorParameter<Boolean> PARAMETER_ENABLE_FACE_BEAUTY = new AbstractSemCameraCaptureProcessor.ProcessorParameter("beauty_parameter");
  public static final AbstractSemCameraCaptureProcessor.ProcessorParameter<Integer> PARAMETER_IMAGE_FORMAT = new AbstractSemCameraCaptureProcessor.ProcessorParameter("image_format");
  protected static final String TAG = AbstractSemCameraCaptureProcessor.class.getSimpleName();
  
  public abstract CaptureRequest buildCaptureRequest(CaptureRequest.Builder paramBuilder);
  
  public abstract void capture(CameraCaptureSession paramCameraCaptureSession, CaptureResult paramCaptureResult, AbstractSemCameraCaptureProcessor.CaptureCallback paramCaptureCallback, Handler paramHandler, List<AbstractSemCameraCaptureProcessor.CaptureParameter> paramList);
  
  public abstract SessionConfiguration createSessionConfiguration(List<OutputConfiguration> paramList, CameraCaptureSession.StateCallback paramStateCallback, Handler paramHandler);
  
  public abstract CameraDevice.StateCallback createStateCallback(CameraDevice.StateCallback paramStateCallback, Handler paramHandler);
  
  public abstract void deinitialize();
  
  public abstract List<AbstractSemCameraCaptureProcessor.ProcessorParameter> getAvailableParameters();
  
  public abstract <T> T getProcessorParameter(AbstractSemCameraCaptureProcessor.ProcessorParameter<T> paramProcessorParameter);
  
  public abstract void initialize(Context paramContext, String paramString, Size paramSize);
  
  public abstract <T> void setProcessorParameter(AbstractSemCameraCaptureProcessor.ProcessorParameter<T> paramProcessorParameter, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor
 * JD-Core Version:    0.7.0.1
 */