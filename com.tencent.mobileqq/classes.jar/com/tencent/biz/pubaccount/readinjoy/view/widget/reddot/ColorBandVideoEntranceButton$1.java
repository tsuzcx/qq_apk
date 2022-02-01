package com.tencent.biz.pubaccount.readinjoy.view.widget.reddot;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;

class ColorBandVideoEntranceButton$1
  implements URLDrawableDownListener
{
  ColorBandVideoEntranceButton$1(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    ColorBandVideoEntranceButton.a(this.a, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton.1
 * JD-Core Version:    0.7.0.1
 */