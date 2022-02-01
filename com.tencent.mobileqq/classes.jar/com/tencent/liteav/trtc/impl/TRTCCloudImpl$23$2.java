package com.tencent.liteav.trtc.impl;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.c.o;

class TRTCCloudImpl$23$2
  implements o
{
  TRTCCloudImpl$23$2(TRTCCloudImpl.23 param23) {}
  
  public void onTakePhotoComplete(Bitmap paramBitmap)
  {
    this.this$1.this$0.runOnListenerThread(new TRTCCloudImpl.23.2.1(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.23.2
 * JD-Core Version:    0.7.0.1
 */