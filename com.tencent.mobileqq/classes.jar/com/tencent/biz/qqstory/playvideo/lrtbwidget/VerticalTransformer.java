package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;
import com.tencent.biz.qqstory.support.logging.SLog;

public class VerticalTransformer
  implements ViewPager.PageTransformer
{
  public void transformPage(View paramView, float paramFloat)
  {
    paramView.setAlpha(1.0F);
    paramView.setScaleX(1.0F);
    paramView.setTranslationX(0.0F);
    paramView.setTranslationY(0.0F);
    SLog.a("VerticalTransformer", "transformPage position=%s, view=%s", Float.valueOf(paramFloat), paramView);
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if (paramFloat <= -1.0F) {}
    do
    {
      return;
      if (paramFloat <= 0.0F)
      {
        paramView.setTranslationX(i * -paramFloat);
        paramView.setTranslationY(j * paramFloat);
        return;
      }
    } while (paramFloat >= 1.0F);
    paramView.setTranslationX(i * -paramFloat);
    paramView.setTranslationY(j * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VerticalTransformer
 * JD-Core Version:    0.7.0.1
 */