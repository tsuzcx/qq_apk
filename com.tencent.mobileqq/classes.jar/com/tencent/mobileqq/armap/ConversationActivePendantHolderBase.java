package com.tencent.mobileqq.armap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.portal.BaseAnimHolder;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.qphone.base.util.QLog;

public class ConversationActivePendantHolderBase
  extends BaseAnimHolder
{
  private Interpolator a;
  protected RectF k = new RectF();
  public int l = 0;
  public Context m;
  public View n;
  public int o = 2;
  public int p = 0;
  public long q = 0L;
  public long r = 1L;
  public int s = 0;
  public boolean t = false;
  public int u = 0;
  public int v = 0;
  
  public ConversationActivePendantHolderBase(View paramView)
  {
    this.n = paramView;
    this.m = paramView.getContext();
  }
  
  private void a()
  {
    b(this.l);
    this.t = false;
    this.q = -1L;
    this.r = 1L;
    this.o = 2;
  }
  
  private void a(long paramLong)
  {
    this.r = paramLong;
    this.q = AnimationUtils.currentAnimationTimeMillis();
    this.t = true;
  }
  
  public RectF a(int paramInt)
  {
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    this.l = paramInt2;
  }
  
  public void a(int paramInt, long paramLong)
  {
    int i = this.l;
    this.v = i;
    this.u = (i + paramInt);
    this.a = new DecelerateInterpolator();
    this.o = 1;
    a(paramLong);
  }
  
  public boolean a(Canvas paramCanvas)
  {
    e();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.s);
    b(paramCanvas);
    Drawable localDrawable = this.B;
    boolean bool2 = false;
    boolean bool1;
    if (localDrawable != null) {
      bool1 = super.a(paramCanvas);
    } else {
      bool1 = false;
    }
    c(paramCanvas);
    paramCanvas.restore();
    if ((this.t) || (bool1)) {
      bool2 = true;
    }
    return bool2;
  }
  
  public void b(int paramInt)
  {
    int i = paramInt;
    if (this.t) {
      i = (int)(paramInt + this.l * (this.D - 1.0F));
    }
    this.y = i;
  }
  
  protected void b(Canvas paramCanvas) {}
  
  public RectF c(int paramInt)
  {
    RectF localRectF = this.k;
    float f1 = this.x;
    float f2 = this.y;
    float f3 = paramInt;
    localRectF.set(f1 - 0.0F, f2 - 0.0F - f3, this.x + this.z + 0.0F, this.y + this.A + 0.0F - f3);
    return this.k;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConvActivePendantHolderBase", 2, "stopActiveSanHua stopAnimation");
    }
    super.c();
    a();
    this.D = 1.0F;
    this.C = 1.0F;
  }
  
  protected void c(Canvas paramCanvas) {}
  
  public void d() {}
  
  public void e()
  {
    if (!this.t) {
      return;
    }
    float f2 = (float)(AnimationUtils.currentAnimationTimeMillis() - this.q) * 1.0F / (float)this.r;
    Interpolator localInterpolator = this.a;
    float f1;
    if (localInterpolator != null) {
      f1 = localInterpolator.getInterpolation(f2);
    } else {
      f1 = f2;
    }
    int i = this.v;
    b((int)(i + (this.u - i) * f1));
    if (f2 > 0.99D)
    {
      i = this.o;
      if (i != 1)
      {
        if (i != 3)
        {
          a();
          return;
        }
        this.o = 2;
        return;
      }
      this.o = 3;
      f();
    }
  }
  
  public void f()
  {
    this.v = this.y;
    this.u = this.l;
    this.o = 3;
    this.a = new ConversationActivePendantHolderBase.BounceInterpolatorX(this);
    a(1500L);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConvActivePendantHolderBase", 2, "startActiveSanHua scale");
    }
    ValueAnimation localValueAnimation = new ValueAnimation(Float.valueOf(1.0F), Float.valueOf(1.1F), new ConversationActivePendantHolderBase.1(this));
    localValueAnimation.setDuration(500L);
    localValueAnimation.setRepeatCount(-1);
    localValueAnimation.setRepeatMode(2);
    a(localValueAnimation);
  }
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ConversationActivePendantHolderBase
 * JD-Core Version:    0.7.0.1
 */