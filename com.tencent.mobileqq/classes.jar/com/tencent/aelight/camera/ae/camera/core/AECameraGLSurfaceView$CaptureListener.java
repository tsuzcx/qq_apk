package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;

public abstract interface AECameraGLSurfaceView$CaptureListener
{
  public static final int ERROR_CAPTURE_FRAME_OOM = 103;
  public static final int ERROR_ENCODE_ERROR = 104;
  public static final int ERROR_LOAD_MEDIAINFO_FAILED = 101;
  public static final int ERROR_STOP_WITHOUT_STARTED = 102;
  
  public abstract void onCaptureError(int paramInt);
  
  public abstract void onPhotoCaptured(AEPhotoCaptureResult paramAEPhotoCaptureResult);
  
  public abstract void onVideoCaptureStart();
  
  public abstract void onVideoCaptured(AEVideoCaptureResult paramAEVideoCaptureResult);
  
  public abstract void reportFirstFrameShown();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.CaptureListener
 * JD-Core Version:    0.7.0.1
 */