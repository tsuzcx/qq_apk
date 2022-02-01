package com.tencent.component.media.image.view;

import android.graphics.drawable.Drawable;
import android.view.animation.Animation;

class ExtendImageView$3
  implements Runnable
{
  ExtendImageView$3(ExtendImageView paramExtendImageView, Drawable paramDrawable, Animation paramAnimation) {}
  
  public void run()
  {
    ExtendImageView.access$200(this.this$0, this.val$fdrawable);
    Animation localAnimation = this.val$fin;
    if (localAnimation != null) {
      ExtendImageView.access$100(this.this$0, localAnimation, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.view.ExtendImageView.3
 * JD-Core Version:    0.7.0.1
 */