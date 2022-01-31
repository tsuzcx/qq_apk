package com.samsung.android.sdk.camera.delegator;

import android.util.Log;
import com.samsung.android.sep.camera.SemCameraCaptureProcessor.CaptureCallback;
import java.nio.ByteBuffer;

class SemCameraCaptureProcessor10_1$SemCaptureCallBack
  extends SemCameraCaptureProcessor.CaptureCallback
{
  private SemCameraCaptureProcessor10_1$SemCaptureCallBack(SemCameraCaptureProcessor10_1 paramSemCameraCaptureProcessor10_1) {}
  
  public void onError(int paramInt)
  {
    Log.i(SemCameraCaptureProcessor10_1.access$100(), " SemCaptureCallBack onError!!! " + paramInt);
    if (SemCameraCaptureProcessor10_1.access$200(this.this$0) != null) {
      SemCameraCaptureProcessor10_1.access$200(this.this$0).onError(paramInt);
    }
  }
  
  public void onPictureAvailable(ByteBuffer paramByteBuffer)
  {
    Log.i(SemCameraCaptureProcessor10_1.access$100(), " SemCaptureCallBack onPictureAvailable!!! " + paramByteBuffer);
    if (SemCameraCaptureProcessor10_1.access$200(this.this$0) != null) {
      SemCameraCaptureProcessor10_1.access$200(this.this$0).onPictureAvailable(paramByteBuffer);
    }
  }
  
  public void onShutter()
  {
    if (SemCameraCaptureProcessor10_1.access$200(this.this$0) != null) {
      SemCameraCaptureProcessor10_1.access$200(this.this$0).onShutter();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.samsung.android.sdk.camera.delegator.SemCameraCaptureProcessor10_1.SemCaptureCallBack
 * JD-Core Version:    0.7.0.1
 */