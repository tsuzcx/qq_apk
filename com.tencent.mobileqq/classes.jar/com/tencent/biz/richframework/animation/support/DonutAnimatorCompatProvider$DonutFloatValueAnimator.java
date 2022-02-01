package com.tencent.biz.richframework.animation.support;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

class DonutAnimatorCompatProvider$DonutFloatValueAnimator
  implements ValueAnimatorCompat
{
  List<AnimatorListenerCompat> a = new ArrayList();
  List<AnimatorUpdateListenerCompat> b = new ArrayList();
  View c;
  private long d;
  private long e = 200L;
  private float f = 0.0F;
  private boolean g = false;
  private boolean h = false;
  private Runnable i = new DonutAnimatorCompatProvider.DonutFloatValueAnimator.1(this);
  
  private void a()
  {
    int j = this.b.size() - 1;
    while (j >= 0)
    {
      ((AnimatorUpdateListenerCompat)this.b.get(j)).a(this);
      j -= 1;
    }
  }
  
  private long b()
  {
    return this.c.getDrawingTime();
  }
  
  private void c()
  {
    int j = this.a.size() - 1;
    while (j >= 0)
    {
      ((AnimatorListenerCompat)this.a.get(j)).b(this);
      j -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.support.DonutAnimatorCompatProvider.DonutFloatValueAnimator
 * JD-Core Version:    0.7.0.1
 */