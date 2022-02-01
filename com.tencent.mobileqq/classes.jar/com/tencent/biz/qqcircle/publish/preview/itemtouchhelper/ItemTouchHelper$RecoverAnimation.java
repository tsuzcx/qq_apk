package com.tencent.biz.qqcircle.publish.preview.itemtouchhelper;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.widget.QCircleD8SafeAnimatorListener;

class ItemTouchHelper$RecoverAnimation
  extends QCircleD8SafeAnimatorListener
{
  private final ValueAnimator a;
  private float b;
  final float d;
  final float e;
  final float f;
  final float g;
  final RecyclerView.ViewHolder h;
  final int i;
  final int j;
  public boolean k;
  float l;
  float m;
  boolean n = false;
  boolean o = false;
  
  ItemTouchHelper$RecoverAnimation(ItemTouchHelper paramItemTouchHelper, RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.i = paramInt2;
    this.j = paramInt1;
    this.h = paramViewHolder;
    this.d = paramFloat1;
    this.e = paramFloat2;
    this.f = paramFloat3;
    this.g = paramFloat4;
    this.a = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.a.addUpdateListener(new ItemTouchHelper.RecoverAnimation.1(this, paramItemTouchHelper));
    this.a.setTarget(paramViewHolder.itemView);
    this.a.addListener(this);
    a(0.0F);
  }
  
  public void a()
  {
    this.h.setIsRecyclable(false);
    this.a.start();
  }
  
  public void a(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public void a(long paramLong)
  {
    this.a.setDuration(paramLong);
  }
  
  public void b()
  {
    this.a.cancel();
  }
  
  public void c()
  {
    float f1 = this.d;
    float f2 = this.f;
    if (f1 == f2) {
      this.l = this.h.itemView.getTranslationX();
    } else {
      this.l = (f1 + this.b * (f2 - f1));
    }
    f1 = this.e;
    f2 = this.g;
    if (f1 == f2)
    {
      this.m = this.h.itemView.getTranslationY();
      return;
    }
    this.m = (f1 + this.b * (f2 - f1));
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    a(1.0F);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.o) {
      this.h.setIsRecyclable(true);
    }
    this.o = true;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.itemtouchhelper.ItemTouchHelper.RecoverAnimation
 * JD-Core Version:    0.7.0.1
 */