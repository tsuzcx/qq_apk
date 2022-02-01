package com.google.android.material.tabs;

import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.animation.AnimationUtils;

class ElasticTabIndicatorInterpolator
  extends TabIndicatorInterpolator
{
  private static float a(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    double d = paramFloat;
    Double.isNaN(d);
    return (float)Math.sin(d * 3.141592653589793D / 2.0D);
  }
  
  private static float b(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    double d = paramFloat;
    Double.isNaN(d);
    return (float)(1.0D - Math.cos(d * 3.141592653589793D / 2.0D));
  }
  
  void a(TabLayout paramTabLayout, View paramView1, View paramView2, float paramFloat, @NonNull Drawable paramDrawable)
  {
    paramView1 = a(paramTabLayout, paramView1);
    paramTabLayout = a(paramTabLayout, paramView2);
    int i;
    if (paramView1.left < paramTabLayout.left) {
      i = 1;
    } else {
      i = 0;
    }
    float f1;
    float f2;
    if (i != 0)
    {
      f1 = b(paramFloat);
      f2 = a(paramFloat);
      paramFloat = f1;
      f1 = f2;
    }
    else
    {
      f2 = a(paramFloat);
      f1 = b(paramFloat);
      paramFloat = f2;
    }
    paramDrawable.setBounds(AnimationUtils.a((int)paramView1.left, (int)paramTabLayout.left, paramFloat), paramDrawable.getBounds().top, AnimationUtils.a((int)paramView1.right, (int)paramTabLayout.right, f1), paramDrawable.getBounds().bottom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.tabs.ElasticTabIndicatorInterpolator
 * JD-Core Version:    0.7.0.1
 */