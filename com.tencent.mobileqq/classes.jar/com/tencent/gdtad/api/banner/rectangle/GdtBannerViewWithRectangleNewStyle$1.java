package com.tencent.gdtad.api.banner.rectangle;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

class GdtBannerViewWithRectangleNewStyle$1
  extends ViewOutlineProvider
{
  GdtBannerViewWithRectangleNewStyle$1(GdtBannerViewWithRectangleNewStyle paramGdtBannerViewWithRectangleNewStyle, int paramInt1, int paramInt2) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    paramOutline.setRoundRect(0, 0, this.a, this.b, 8.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithRectangleNewStyle.1
 * JD-Core Version:    0.7.0.1
 */