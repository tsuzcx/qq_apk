package com.tencent.biz.pubaccount.NativeAd.adapter;

import android.view.View;
import androidx.viewpager.widget.ViewPager.PageTransformer;

class VerticleViewPager$VerticalPageTransformer
  implements ViewPager.PageTransformer
{
  private VerticleViewPager$VerticalPageTransformer(VerticleViewPager paramVerticleViewPager) {}
  
  public void transformPage(View paramView, float paramFloat)
  {
    if (paramFloat < -1.0F)
    {
      paramView.setAlpha(0.0F);
      return;
    }
    if (paramFloat <= 1.0F)
    {
      paramView.setAlpha(1.0F);
      paramView.setTranslationX(paramView.getWidth() * -paramFloat);
      paramView.setTranslationY(paramFloat * paramView.getHeight());
      return;
    }
    paramView.setAlpha(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.adapter.VerticleViewPager.VerticalPageTransformer
 * JD-Core Version:    0.7.0.1
 */