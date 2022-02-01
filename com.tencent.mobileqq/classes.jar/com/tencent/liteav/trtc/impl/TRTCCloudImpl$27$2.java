package com.tencent.liteav.trtc.impl;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.opengl.p;

class TRTCCloudImpl$27$2
  implements p
{
  TRTCCloudImpl$27$2(TRTCCloudImpl.27 param27) {}
  
  public void onTakePhotoComplete(Bitmap paramBitmap)
  {
    this.this$1.this$0.runOnListenerThread(new TRTCCloudImpl.27.2.1(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.27.2
 * JD-Core Version:    0.7.0.1
 */