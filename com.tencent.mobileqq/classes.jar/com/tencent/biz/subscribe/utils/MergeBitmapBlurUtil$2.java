package com.tencent.biz.subscribe.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;

final class MergeBitmapBlurUtil$2
  implements Runnable
{
  MergeBitmapBlurUtil$2(Bitmap paramBitmap, ImageView paramImageView) {}
  
  public void run()
  {
    Bitmap localBitmap = this.a;
    if (localBitmap != null)
    {
      ImageView localImageView = this.b;
      if (localImageView != null) {
        localImageView.setImageBitmap(localBitmap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.MergeBitmapBlurUtil.2
 * JD-Core Version:    0.7.0.1
 */