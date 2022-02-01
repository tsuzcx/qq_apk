package com.bm.library;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import android.widget.Scroller;

class PhotoView$Transform
  implements Runnable
{
  boolean a;
  OverScroller b;
  OverScroller c;
  Scroller d;
  Scroller e;
  Scroller f;
  PhotoView.ClipCalculate g;
  int h;
  int i;
  int j;
  int k;
  RectF l = new RectF();
  PhotoView.InterpolatorProxy m = new PhotoView.InterpolatorProxy(this.this$0, null);
  
  PhotoView$Transform(PhotoView paramPhotoView)
  {
    paramPhotoView = paramPhotoView.getContext();
    this.b = new OverScroller(paramPhotoView, this.m);
    this.d = new Scroller(paramPhotoView, this.m);
    this.c = new OverScroller(paramPhotoView, this.m);
    this.e = new Scroller(paramPhotoView, this.m);
    this.f = new Scroller(paramPhotoView, this.m);
  }
  
  private void c()
  {
    PhotoView.d(this.this$0).reset();
    PhotoView.d(this.this$0).postTranslate(-PhotoView.A(this.this$0).left, -PhotoView.A(this.this$0).top);
    PhotoView.d(this.this$0).postTranslate(PhotoView.w(this.this$0).x, PhotoView.w(this.this$0).y);
    PhotoView.d(this.this$0).postTranslate(-PhotoView.B(this.this$0), -PhotoView.C(this.this$0));
    PhotoView.d(this.this$0).postRotate(PhotoView.c(this.this$0), PhotoView.w(this.this$0).x, PhotoView.w(this.this$0).y);
    PhotoView.d(this.this$0).postScale(PhotoView.f(this.this$0), PhotoView.f(this.this$0), PhotoView.v(this.this$0).x, PhotoView.v(this.this$0).y);
    PhotoView.d(this.this$0).postTranslate(PhotoView.q(this.this$0), PhotoView.u(this.this$0));
    PhotoView.g(this.this$0);
  }
  
  private void d()
  {
    if (this.a) {
      this.this$0.post(this);
    }
  }
  
  void a()
  {
    this.a = true;
    d();
  }
  
  void a(float paramFloat1, float paramFloat2)
  {
    this.d.startScroll((int)(paramFloat1 * 10000.0F), 0, (int)((paramFloat2 - paramFloat1) * 10000.0F), 0, PhotoView.E(this.this$0));
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, PhotoView.ClipCalculate paramClipCalculate)
  {
    this.e.startScroll((int)(paramFloat1 * 10000.0F), (int)(paramFloat2 * 10000.0F), (int)(paramFloat3 * 10000.0F), (int)(paramFloat4 * 10000.0F), paramInt);
    this.g = paramClipCalculate;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.f.startScroll(paramInt1, 0, paramInt2 - paramInt1, 0, PhotoView.E(this.this$0));
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.j = 0;
    this.k = 0;
    this.b.startScroll(0, 0, paramInt3, paramInt4, PhotoView.E(this.this$0));
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.m.a(paramInterpolator);
  }
  
  void b()
  {
    this.this$0.removeCallbacks(this);
    this.b.abortAnimation();
    this.d.abortAnimation();
    this.c.abortAnimation();
    this.f.abortAnimation();
    this.a = false;
  }
  
  void b(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < 0.0F) {
      n = 2147483647;
    } else {
      n = 0;
    }
    this.h = n;
    float f1;
    if (paramFloat1 > 0.0F) {
      f1 = Math.abs(PhotoView.o(this.this$0).left);
    } else {
      f1 = PhotoView.o(this.this$0).right - PhotoView.p(this.this$0).right;
    }
    int i1 = (int)f1;
    int n = i1;
    if (paramFloat1 < 0.0F) {
      n = 2147483647 - i1;
    }
    if (paramFloat1 < 0.0F) {
      i1 = n;
    } else {
      i1 = 0;
    }
    int i2;
    if (paramFloat1 < 0.0F) {
      i2 = 2147483647;
    } else {
      i2 = n;
    }
    int i5 = n;
    if (paramFloat1 < 0.0F) {
      i5 = 2147483647 - i1;
    }
    if (paramFloat2 < 0.0F) {
      n = 2147483647;
    } else {
      n = 0;
    }
    this.i = n;
    if (paramFloat2 > 0.0F) {
      f1 = Math.abs(PhotoView.o(this.this$0).top);
    } else {
      f1 = PhotoView.o(this.this$0).bottom - PhotoView.p(this.this$0).bottom;
    }
    int i3 = (int)f1;
    n = i3;
    if (paramFloat2 < 0.0F) {
      n = 2147483647 - i3;
    }
    if (paramFloat2 < 0.0F) {
      i3 = n;
    } else {
      i3 = 0;
    }
    int i4;
    if (paramFloat2 < 0.0F) {
      i4 = 2147483647;
    } else {
      i4 = n;
    }
    if (paramFloat2 < 0.0F) {
      n = 2147483647 - i3;
    }
    if (paramFloat1 == 0.0F)
    {
      i1 = 0;
      i2 = 0;
    }
    if (paramFloat2 == 0.0F)
    {
      i3 = 0;
      i4 = 0;
    }
    OverScroller localOverScroller = this.c;
    int i6 = this.h;
    int i7 = this.i;
    int i8 = (int)paramFloat1;
    int i9 = (int)paramFloat2;
    if (Math.abs(i5) < PhotoView.F(this.this$0) * 2) {
      i5 = 0;
    } else {
      i5 = PhotoView.F(this.this$0);
    }
    if (Math.abs(n) < PhotoView.F(this.this$0) * 2) {
      n = 0;
    } else {
      n = PhotoView.F(this.this$0);
    }
    localOverScroller.fling(i6, i7, i8, i9, i1, i2, i3, i4, i5, n);
  }
  
  public void run()
  {
    boolean bool = this.d.computeScrollOffset();
    int i1 = 1;
    int i2 = 0;
    if (bool)
    {
      PhotoView.c(this.this$0, this.d.getCurrX() / 10000.0F);
      n = 0;
    }
    else
    {
      n = 1;
    }
    int i3;
    int i4;
    int i5;
    PhotoView localPhotoView;
    if (this.b.computeScrollOffset())
    {
      n = this.b.getCurrX();
      i3 = this.j;
      i4 = this.b.getCurrY();
      i5 = this.k;
      localPhotoView = this.this$0;
      PhotoView.a(localPhotoView, PhotoView.q(localPhotoView) + (n - i3));
      localPhotoView = this.this$0;
      PhotoView.b(localPhotoView, PhotoView.u(localPhotoView) + (i4 - i5));
      this.j = this.b.getCurrX();
      this.k = this.b.getCurrY();
      n = 0;
    }
    if (this.c.computeScrollOffset())
    {
      n = this.c.getCurrX();
      i3 = this.h;
      i4 = this.c.getCurrY();
      i5 = this.i;
      this.h = this.c.getCurrX();
      this.i = this.c.getCurrY();
      localPhotoView = this.this$0;
      PhotoView.a(localPhotoView, PhotoView.q(localPhotoView) + (n - i3));
      localPhotoView = this.this$0;
      PhotoView.b(localPhotoView, PhotoView.u(localPhotoView) + (i4 - i5));
      n = 0;
    }
    if (this.f.computeScrollOffset())
    {
      PhotoView.b(this.this$0, this.f.getCurrX());
      n = 0;
    }
    if ((this.e.computeScrollOffset()) || (PhotoView.G(this.this$0) != null))
    {
      float f1 = this.e.getCurrX() / 10000.0F;
      float f2 = this.e.getCurrY() / 10000.0F;
      PhotoView.z(this.this$0).setScale(f1, f2, (PhotoView.o(this.this$0).left + PhotoView.o(this.this$0).right) / 2.0F, this.g.a());
      PhotoView.z(this.this$0).mapRect(this.l, PhotoView.o(this.this$0));
      if (f1 == 1.0F)
      {
        this.l.left = PhotoView.p(this.this$0).left;
        this.l.right = PhotoView.p(this.this$0).right;
      }
      if (f2 == 1.0F)
      {
        this.l.top = PhotoView.p(this.this$0).top;
        this.l.bottom = PhotoView.p(this.this$0).bottom;
      }
      PhotoView.b(this.this$0, this.l);
    }
    if (n == 0)
    {
      c();
      d();
      return;
    }
    this.a = false;
    int n = i2;
    if (PhotoView.l(this.this$0))
    {
      if (PhotoView.o(this.this$0).left > 0.0F)
      {
        localPhotoView = this.this$0;
        PhotoView.a(localPhotoView, (int)(PhotoView.q(localPhotoView) - PhotoView.o(this.this$0).left));
      }
      else if (PhotoView.o(this.this$0).right < PhotoView.p(this.this$0).width())
      {
        localPhotoView = this.this$0;
        PhotoView.a(localPhotoView, PhotoView.q(localPhotoView) - (int)(PhotoView.p(this.this$0).width() - PhotoView.o(this.this$0).right));
      }
      n = 1;
    }
    if (PhotoView.m(this.this$0)) {
      if (PhotoView.o(this.this$0).top > 0.0F)
      {
        localPhotoView = this.this$0;
        PhotoView.b(localPhotoView, (int)(PhotoView.u(localPhotoView) - PhotoView.o(this.this$0).top));
        n = i1;
      }
      else
      {
        n = i1;
        if (PhotoView.o(this.this$0).bottom < PhotoView.p(this.this$0).height())
        {
          localPhotoView = this.this$0;
          PhotoView.b(localPhotoView, PhotoView.u(localPhotoView) - (int)(PhotoView.p(this.this$0).height() - PhotoView.o(this.this$0).bottom));
          n = i1;
        }
      }
    }
    if (n != 0) {
      c();
    }
    this.this$0.invalidate();
    if (PhotoView.H(this.this$0) != null)
    {
      PhotoView.H(this.this$0).run();
      PhotoView.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bm.library.PhotoView.Transform
 * JD-Core Version:    0.7.0.1
 */