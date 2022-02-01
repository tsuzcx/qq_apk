package com.tencent.biz.qqcircle.transition;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import android.widget.Scroller;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;

class QCircleTransitionImageView$Transform
  implements Runnable
{
  boolean a;
  OverScroller b;
  Scroller c;
  Scroller d;
  QCircleTransitionImageView.ClipCalculate e;
  int f;
  int g;
  RectF h = new RectF();
  QCircleTransitionImageView.InterpolatorProxy i = new QCircleTransitionImageView.InterpolatorProxy(this.this$0, null);
  
  QCircleTransitionImageView$Transform(QCircleTransitionImageView paramQCircleTransitionImageView)
  {
    paramQCircleTransitionImageView = paramQCircleTransitionImageView.getContext();
    this.b = new OverScroller(paramQCircleTransitionImageView, this.i);
    this.c = new Scroller(paramQCircleTransitionImageView, this.i);
    this.d = new Scroller(paramQCircleTransitionImageView, this.i);
  }
  
  private void f()
  {
    QCircleTransitionImageView.k(this.this$0).reset();
    QCircleTransitionImageView.k(this.this$0).postTranslate(-QCircleTransitionImageView.l(this.this$0).left, -QCircleTransitionImageView.l(this.this$0).top);
    QCircleTransitionImageView.k(this.this$0).postTranslate(QCircleTransitionImageView.m(this.this$0).x, QCircleTransitionImageView.m(this.this$0).y);
    QCircleTransitionImageView.k(this.this$0).postTranslate(-QCircleTransitionImageView.n(this.this$0), -QCircleTransitionImageView.o(this.this$0));
    QCircleTransitionImageView.k(this.this$0).postScale(QCircleTransitionImageView.p(this.this$0), QCircleTransitionImageView.p(this.this$0), QCircleTransitionImageView.q(this.this$0).x, QCircleTransitionImageView.q(this.this$0).y);
    QCircleTransitionImageView.k(this.this$0).postTranslate(QCircleTransitionImageView.e(this.this$0), QCircleTransitionImageView.h(this.this$0));
    QCircleTransitionImageView.r(this.this$0);
  }
  
  private void g()
  {
    if (this.a) {
      this.this$0.post(this);
    }
  }
  
  void a()
  {
    this.a = true;
    g();
  }
  
  void a(float paramFloat1, float paramFloat2)
  {
    this.c.startScroll((int)(paramFloat1 * 10000.0F), 0, (int)((paramFloat2 - paramFloat1) * 10000.0F), 0, QCircleTransitionImageView.a(this.this$0));
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, QCircleTransitionImageView.ClipCalculate paramClipCalculate)
  {
    this.d.startScroll((int)(paramFloat1 * 10000.0F), (int)(paramFloat2 * 10000.0F), (int)(paramFloat3 * 10000.0F), (int)(paramFloat4 * 10000.0F), paramInt);
    this.e = paramClipCalculate;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f = 0;
    this.g = 0;
    this.b.startScroll(0, 0, paramInt3, paramInt4, QCircleTransitionImageView.a(this.this$0));
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.i.a(paramInterpolator);
  }
  
  boolean a(boolean paramBoolean)
  {
    if (this.b.computeScrollOffset())
    {
      int j = this.b.getCurrX();
      int k = this.f;
      int m = this.b.getCurrY();
      int n = this.g;
      QCircleTransitionImageView localQCircleTransitionImageView = this.this$0;
      QCircleTransitionImageView.a(localQCircleTransitionImageView, QCircleTransitionImageView.e(localQCircleTransitionImageView) + (j - k));
      localQCircleTransitionImageView = this.this$0;
      QCircleTransitionImageView.b(localQCircleTransitionImageView, QCircleTransitionImageView.h(localQCircleTransitionImageView) + (m - n));
      this.f = this.b.getCurrX();
      this.g = this.b.getCurrY();
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  void b()
  {
    this.this$0.removeCallbacks(this);
    this.c.abortAnimation();
    this.a = false;
  }
  
  boolean b(boolean paramBoolean)
  {
    if (this.c.computeScrollOffset())
    {
      QCircleTransitionImageView.a(this.this$0, this.c.getCurrX() / 10000.0F);
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  void c()
  {
    if (QCircleTransitionImageView.b(this.this$0) != null)
    {
      QCircleTransitionImageView.b(this.this$0).a();
      QCircleTransitionImageView.a(this.this$0, null);
    }
  }
  
  void d()
  {
    QCircleTransitionImageView localQCircleTransitionImageView;
    int j;
    if (QCircleTransitionImageView.c(this.this$0))
    {
      if (QCircleTransitionImageView.d(this.this$0).left > 0.0F)
      {
        localQCircleTransitionImageView = this.this$0;
        QCircleTransitionImageView.a(localQCircleTransitionImageView, (int)(QCircleTransitionImageView.e(localQCircleTransitionImageView) - QCircleTransitionImageView.d(this.this$0).left));
      }
      else if (QCircleTransitionImageView.d(this.this$0).right < QCircleTransitionImageView.f(this.this$0).width())
      {
        localQCircleTransitionImageView = this.this$0;
        QCircleTransitionImageView.a(localQCircleTransitionImageView, QCircleTransitionImageView.e(localQCircleTransitionImageView) - (int)(QCircleTransitionImageView.f(this.this$0).width() - QCircleTransitionImageView.d(this.this$0).right));
      }
      j = 1;
    }
    else
    {
      j = 0;
    }
    if (QCircleTransitionImageView.g(this.this$0))
    {
      if (QCircleTransitionImageView.d(this.this$0).top > 0.0F)
      {
        localQCircleTransitionImageView = this.this$0;
        QCircleTransitionImageView.b(localQCircleTransitionImageView, (int)(QCircleTransitionImageView.h(localQCircleTransitionImageView) - QCircleTransitionImageView.d(this.this$0).top));
      }
      else if (QCircleTransitionImageView.d(this.this$0).bottom < QCircleTransitionImageView.f(this.this$0).height())
      {
        localQCircleTransitionImageView = this.this$0;
        QCircleTransitionImageView.b(localQCircleTransitionImageView, QCircleTransitionImageView.h(localQCircleTransitionImageView) - (int)(QCircleTransitionImageView.f(this.this$0).height() - QCircleTransitionImageView.d(this.this$0).bottom));
      }
      j = 1;
    }
    if (j != 0) {
      f();
    }
  }
  
  void e()
  {
    if ((this.d.computeScrollOffset()) || (QCircleTransitionImageView.i(this.this$0) != null))
    {
      float f1 = this.d.getCurrX() / 10000.0F;
      float f2 = this.d.getCurrY() / 10000.0F;
      QCircleTransitionImageView.j(this.this$0).setScale(f1, f2, (QCircleTransitionImageView.d(this.this$0).left + QCircleTransitionImageView.d(this.this$0).right) / 2.0F, this.e.a());
      QCircleTransitionImageView.j(this.this$0).mapRect(this.h, QCircleTransitionImageView.d(this.this$0));
      RectF localRectF;
      if (f1 == 1.0F)
      {
        localRectF = this.h;
        localRectF.left = 0.0F;
        localRectF.right = ImmersiveUtils.b();
      }
      if (f2 == 1.0F)
      {
        localRectF = this.h;
        localRectF.top = 0.0F;
        localRectF.bottom = ImmersiveUtils.c();
      }
      QCircleTransitionImageView.a(this.this$0, this.h);
    }
  }
  
  public void run()
  {
    boolean bool = a(b(true));
    e();
    if (!bool)
    {
      f();
      g();
      return;
    }
    this.a = false;
    d();
    this.this$0.invalidate();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.transition.QCircleTransitionImageView.Transform
 * JD-Core Version:    0.7.0.1
 */