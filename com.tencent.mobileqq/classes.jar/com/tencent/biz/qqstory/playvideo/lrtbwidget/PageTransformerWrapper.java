package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.view.View;
import androidx.viewpager.widget.ViewPager.PageTransformer;

public class PageTransformerWrapper
  implements XViewPager.PageTransformer
{
  public final ViewPager.PageTransformer a;
  
  public PageTransformerWrapper(ViewPager.PageTransformer paramPageTransformer)
  {
    this.a = paramPageTransformer;
  }
  
  public void a(View paramView, float paramFloat)
  {
    this.a.transformPage(paramView, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.PageTransformerWrapper
 * JD-Core Version:    0.7.0.1
 */