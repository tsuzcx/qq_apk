package com.tencent.avgame.gameroom.gamelist;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

public class GameListPageTransformer
  implements ViewPager.PageTransformer
{
  private static float a = 1.0F;
  
  public GameListPageTransformer(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a = 0.85F;
      return;
    }
    a = 1.0F;
  }
  
  public void transformPage(View paramView, float paramFloat)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    float f1 = j * (1.0F - a) / 2.0F;
    float f2 = i * (1.0F - a) / 2.0F;
    paramView.setScaleX(a);
    paramView.setScaleY(a);
    if (paramFloat < -1.0F)
    {
      paramView.setAlpha(0.7F);
      paramView.setTranslationX(f2 - f1 / 2.0F);
      return;
    }
    if (paramFloat <= 1.0F)
    {
      f1 = Math.max(a, 1.0F - Math.abs(paramFloat));
      f2 = j * (1.0F - f1) / 2.0F;
      float f3 = i * (1.0F - f1) / 2.0F;
      if (paramFloat < 0.0F) {
        paramView.setTranslationX(f3 - f2 / 2.0F);
      }
      for (;;)
      {
        paramView.setScaleX(f1);
        paramView.setScaleY(f1);
        paramView.setAlpha((f1 - a) / (1.0F - a) * 0.3F + 0.7F);
        return;
        paramView.setTranslationX(-f3 + f2 / 2.0F);
      }
    }
    paramView.setAlpha(0.7F);
    paramView.setTranslationX(-f2 + f1 / 2.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListPageTransformer
 * JD-Core Version:    0.7.0.1
 */