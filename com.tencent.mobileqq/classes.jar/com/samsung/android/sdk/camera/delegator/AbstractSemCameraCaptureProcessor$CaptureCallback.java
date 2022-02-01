package com.samsung.android.sdk.camera.delegator;

import java.nio.ByteBuffer;

public abstract class AbstractSemCameraCaptureProcessor$CaptureCallback
{
  public static final int ERROR_CAPTURE_FAILED = 1;
  public static final int ERROR_PROCESSING_FAILED = 2;
  
  public abstract void onError(int paramInt);
  
  public abstract void onPictureAvailable(ByteBuffer paramByteBuffer);
  
  public abstract void onShutter();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor.CaptureCallback
 * JD-Core Version:    0.7.0.1
 */