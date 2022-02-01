package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

public class FadeInBitmapDisplayer
  implements BitmapDisplayer
{
  private final boolean animateFromDisk;
  private final boolean animateFromMemory;
  private final boolean animateFromNetwork;
  private final int durationMillis;
  
  public FadeInBitmapDisplayer(int paramInt)
  {
    this(paramInt, true, true, true);
  }
  
  public FadeInBitmapDisplayer(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.durationMillis = paramInt;
    this.animateFromNetwork = paramBoolean1;
    this.animateFromDisk = paramBoolean2;
    this.animateFromMemory = paramBoolean3;
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
  
  public void display(Bitmap paramBitmap, ImageAware paramImageAware, LoadedFrom paramLoadedFrom)
  {
    paramImageAware.setImageBitmap(paramBitmap);
    if (((this.animateFromNetwork) && (paramLoadedFrom == LoadedFrom.NETWORK)) || ((this.animateFromDisk) && (paramLoadedFrom == LoadedFrom.DISC_CACHE)) || ((this.animateFromMemory) && (paramLoadedFrom == LoadedFrom.MEMORY_CACHE))) {
      animate(paramImageAware.getWrappedView(), this.durationMillis);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer
 * JD-Core Version:    0.7.0.1
 */