package com.tencent.gdtad.api.banner.rectangle;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

class GdtRoundRectURLImageView$1
  extends ViewOutlineProvider
{
  GdtRoundRectURLImageView$1(GdtRoundRectURLImageView paramGdtRoundRectURLImageView, int paramInt1, int paramInt2) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    paramOutline.setRoundRect(0, 0, this.a, this.b, GdtRoundRectURLImageView.a(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.rectangle.GdtRoundRectURLImageView.1
 * JD-Core Version:    0.7.0.1
 */