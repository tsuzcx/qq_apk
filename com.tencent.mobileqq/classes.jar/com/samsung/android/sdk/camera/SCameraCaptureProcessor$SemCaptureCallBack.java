package com.samsung.android.sdk.camera;

import com.samsung.android.sdk.camera.delegator.AbstractSemCameraCaptureProcessor.CaptureCallback;
import java.nio.ByteBuffer;

class SCameraCaptureProcessor$SemCaptureCallBack
  extends AbstractSemCameraCaptureProcessor.CaptureCallback
{
  private SCameraCaptureProcessor$SemCaptureCallBack(SCameraCaptureProcessor paramSCameraCaptureProcessor) {}
  
  public void onError(int paramInt)
  {
    if (SCameraCaptureProcessor.access$700(this.this$0) != null) {
      SCameraCaptureProcessor.access$700(this.this$0).onError(paramInt);
    }
  }
  
  public void onPictureAvailable(ByteBuffer paramByteBuffer)
  {
    if (SCameraCaptureProcessor.access$700(this.this$0) != null) {
      SCameraCaptureProcessor.access$700(this.this$0).onPictureAvailable(paramByteBuffer);
    }
  }
  
  public void onShutter()
  {
    if (SCameraCaptureProcessor.access$700(this.this$0) != null) {
      SCameraCaptureProcessor.access$700(this.this$0).onShutter();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.samsung.android.sdk.camera.SCameraCaptureProcessor.SemCaptureCallBack
 * JD-Core Version:    0.7.0.1
 */