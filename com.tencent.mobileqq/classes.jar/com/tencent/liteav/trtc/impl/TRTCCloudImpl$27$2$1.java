package com.tencent.liteav.trtc.impl;

import android.graphics.Bitmap;
import com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener;

class TRTCCloudImpl$27$2$1
  implements Runnable
{
  TRTCCloudImpl$27$2$1(TRTCCloudImpl.27.2 param2, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.this$2.this$1.val$listener != null) {
      this.this$2.this$1.val$listener.onSnapshotComplete(this.val$bitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.27.2.1
 * JD-Core Version:    0.7.0.1
 */