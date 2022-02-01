package com.tencent.liteav.trtc.impl;

import android.graphics.Bitmap;
import com.tencent.liteav.beauty.TXBeautyManager;

class TRTCCloudImpl$67
  implements Runnable
{
  TRTCCloudImpl$67(TRTCCloudImpl paramTRTCCloudImpl, Bitmap paramBitmap) {}
  
  public void run()
  {
    this.this$0.apiLog("setFilter");
    this.this$0.getBeautyManager().setFilter(this.val$bmp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.67
 * JD-Core Version:    0.7.0.1
 */