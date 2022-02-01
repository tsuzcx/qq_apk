package com.tencent.falco.base.libapi.imageloader;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class FadeInBitmapDisplayer
  implements BitmapDisplayer
{
  private final int durationMillis;
  
  public FadeInBitmapDisplayer(int paramInt)
  {
    this.durationMillis = paramInt;
  }
  
  public static void animate(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(paramInt);
      localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
      paramView.startAnimation(localAlphaAnimation);
    }
  }
  
  public void display(ImageView paramImageView, Bitmap paramBitmap)
  {
    paramImageView.setImageBitmap(paramBitmap);
    animate(paramImageView, this.durationMillis);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.imageloader.FadeInBitmapDisplayer
 * JD-Core Version:    0.7.0.1
 */