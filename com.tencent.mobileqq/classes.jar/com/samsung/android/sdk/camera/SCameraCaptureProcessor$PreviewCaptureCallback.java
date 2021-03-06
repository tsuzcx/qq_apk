package com.samsung.android.sdk.camera;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Log;
import android.view.Surface;

class SCameraCaptureProcessor$PreviewCaptureCallback
  extends CameraCaptureSession.CaptureCallback
{
  private SCameraCaptureProcessor$PreviewCaptureCallback(SCameraCaptureProcessor paramSCameraCaptureProcessor) {}
  
  public void onCaptureBufferLost(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, Surface paramSurface, long paramLong)
  {
    ??? = SCameraCaptureProcessor.access$600();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCaptureBufferLost: frameNumber ");
    localStringBuilder.append(paramLong);
    Log.i((String)???, localStringBuilder.toString());
    synchronized (this.this$0)
    {
      if (SCameraCaptureProcessor.access$500(this.this$0) != null) {
        SCameraCaptureProcessor.access$500(this.this$0).onCaptureBufferLost(paramCameraCaptureSession, paramCaptureRequest, paramSurface, paramLong);
      }
      return;
    }
  }
  
  public void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
  {
    SCameraCaptureProcessor.access$402(this.this$0, paramTotalCaptureResult);
    synchronized (this.this$0)
    {
      if (SCameraCaptureProcessor.access$500(this.this$0) != null) {
        SCameraCaptureProcessor.access$500(this.this$0).onCaptureCompleted(paramCameraCaptureSession, paramCaptureRequest, paramTotalCaptureResult);
      }
      return;
    }
  }
  
  public void onCaptureFailed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureFailure paramCaptureFailure)
  {
    ??? = SCameraCaptureProcessor.access$600();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCaptureFailed: failure ");
    localStringBuilder.append(paramCaptureFailure.getReason());
    localStringBuilder.append("  mAppPreviewCaptureCallback: ");
    localStringBuilder.append(SCameraCaptureProcessor.access$500(this.this$0));
    Log.i((String)???, localStringBuilder.toString());
    synchronized (this.this$0)
    {
      if (SCameraCaptureProcessor.access$500(this.this$0) != null) {
        SCameraCaptureProcessor.access$500(this.this$0).onCaptureFailed(paramCameraCaptureSession, paramCaptureRequest, paramCaptureFailure);
      }
      return;
    }
  }
  
  public void onCaptureProgressed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureResult paramCaptureResult)
  {
    synchronized (this.this$0)
    {
      if (SCameraCaptureProcessor.access$500(this.this$0) != null) {
        SCameraCaptureProcessor.access$500(this.this$0).onCaptureProgressed(paramCameraCaptureSession, paramCaptureRequest, paramCaptureResult);
      }
      return;
    }
  }
  
  public void onCaptureSequenceAborted(CameraCaptureSession paramCameraCaptureSession, int paramInt)
  {
    ??? = SCameraCaptureProcessor.access$600();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCaptureSequenceAborted: sequenceId ");
    localStringBuilder.append(paramInt);
    Log.i((String)???, localStringBuilder.toString());
    synchronized (this.this$0)
    {
      if (SCameraCaptureProcessor.access$500(this.this$0) != null) {
        SCameraCaptureProcessor.access$500(this.this$0).onCaptureSequenceAborted(paramCameraCaptureSession, paramInt);
      }
      return;
    }
  }
  
  public void onCaptureSequenceCompleted(CameraCaptureSession paramCameraCaptureSession, int paramInt, long paramLong)
  {
    synchronized (this.this$0)
    {
      if (SCameraCaptureProcessor.access$500(this.this$0) != null) {
        SCameraCaptureProcessor.access$500(this.this$0).onCaptureSequenceCompleted(paramCameraCaptureSession, paramInt, paramLong);
      }
      return;
    }
  }
  
  public void onCaptureStarted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, long paramLong1, long paramLong2)
  {
    synchronized (this.this$0)
    {
      if (SCameraCaptureProcessor.access$500(this.this$0) != null) {
        SCameraCaptureProcessor.access$500(this.this$0).onCaptureStarted(paramCameraCaptureSession, paramCaptureRequest, paramLong1, paramLong2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samsung.android.sdk.camera.SCameraCaptureProcessor.PreviewCaptureCallback
 * JD-Core Version:    0.7.0.1
 */