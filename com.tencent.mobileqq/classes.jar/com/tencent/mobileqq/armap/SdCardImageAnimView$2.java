package com.tencent.mobileqq.armap;

import android.graphics.Bitmap;

class SdCardImageAnimView$2
  implements Runnable
{
  SdCardImageAnimView$2(SdCardImageAnimView paramSdCardImageAnimView) {}
  
  public void run()
  {
    if (SdCardImageAnimView.c(this.this$0) != null)
    {
      Bitmap localBitmap = SdCardImageAnimView.c(this.this$0).b(0);
      this.this$0.post(new SdCardImageAnimView.2.1(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SdCardImageAnimView.2
 * JD-Core Version:    0.7.0.1
 */