package com.tencent.live2.impl;

import android.graphics.Bitmap;
import com.tencent.live2.V2TXLivePusher;

class V2TXLivePusherImpl$20
  implements Runnable
{
  V2TXLivePusherImpl$20(V2TXLivePusherImpl paramV2TXLivePusherImpl, Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public void run()
  {
    V2TXLivePusherImpl.access$000(this.this$0).setWatermark(this.val$bitmap, this.val$x, this.val$y, this.val$scale);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePusherImpl.20
 * JD-Core Version:    0.7.0.1
 */