package com.tencent.biz.richframework.animation.support;

import android.os.Build.VERSION;
import android.view.View;

public final class AnimatorCompatHelper
{
  private static final AnimatorProvider a = new DonutAnimatorCompatProvider();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 12)
    {
      a = new HoneycombMr1AnimatorCompatProvider();
      return;
    }
  }
  
  public static void a(View paramView)
  {
    a.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.support.AnimatorCompatHelper
 * JD-Core Version:    0.7.0.1
 */