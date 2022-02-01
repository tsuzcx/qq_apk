package com.tencent.component.media.image.view;

import android.graphics.Bitmap;
import android.view.animation.Animation;

class ExtendImageView$2
  implements Runnable
{
  ExtendImageView$2(ExtendImageView paramExtendImageView, Bitmap paramBitmap, Animation paramAnimation) {}
  
  public void run()
  {
    ExtendImageView.access$000(this.this$0, this.val$fbm);
    Animation localAnimation = this.val$fin;
    if (localAnimation != null) {
      ExtendImageView.access$100(this.this$0, localAnimation, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.view.ExtendImageView.2
 * JD-Core Version:    0.7.0.1
 */