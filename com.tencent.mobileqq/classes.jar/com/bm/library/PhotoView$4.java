package com.bm.library;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;

class PhotoView$4
  extends GestureDetector.SimpleOnGestureListener
{
  PhotoView$4(PhotoView paramPhotoView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    PhotoView.n(this.a).b();
    float f1 = PhotoView.o(this.a).left + PhotoView.o(this.a).width() / 2.0F;
    float f2 = PhotoView.o(this.a).top + PhotoView.o(this.a).height() / 2.0F;
    PhotoView.v(this.a).set(f1, f2);
    PhotoView.w(this.a).set(f1, f2);
    PhotoView.a(this.a, 0);
    PhotoView.b(this.a, 0);
    if (PhotoView.x(this.a))
    {
      f1 = PhotoView.f(this.a);
      f2 = 1.0F;
    }
    else
    {
      f1 = PhotoView.f(this.a);
      f2 = PhotoView.y(this.a);
      PhotoView.v(this.a).set(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    PhotoView.z(this.a).reset();
    PhotoView.z(this.a).postTranslate(-PhotoView.A(this.a).left, -PhotoView.A(this.a).top);
    PhotoView.z(this.a).postTranslate(PhotoView.w(this.a).x, PhotoView.w(this.a).y);
    PhotoView.z(this.a).postTranslate(-PhotoView.B(this.a), -PhotoView.C(this.a));
    PhotoView.z(this.a).postRotate(PhotoView.c(this.a), PhotoView.w(this.a).x, PhotoView.w(this.a).y);
    PhotoView.z(this.a).postScale(f2, f2, PhotoView.v(this.a).x, PhotoView.v(this.a).y);
    PhotoView.z(this.a).postTranslate(PhotoView.q(this.a), PhotoView.u(this.a));
    PhotoView.z(this.a).mapRect(PhotoView.D(this.a), PhotoView.A(this.a));
    paramMotionEvent = this.a;
    PhotoView.a(paramMotionEvent, PhotoView.D(paramMotionEvent));
    paramMotionEvent = this.a;
    PhotoView.d(paramMotionEvent, PhotoView.x(paramMotionEvent) ^ true);
    PhotoView.n(this.a).a(f1, f2);
    PhotoView.n(this.a).a();
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    PhotoView.b(this.a, false);
    PhotoView.c(this.a, false);
    PhotoView.a(this.a, false);
    paramMotionEvent = this.a;
    paramMotionEvent.removeCallbacks(PhotoView.j(paramMotionEvent));
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (PhotoView.k(this.a)) {
      return false;
    }
    if ((!PhotoView.l(this.a)) && (!PhotoView.m(this.a))) {
      return false;
    }
    if (PhotoView.n(this.a).a) {
      return false;
    }
    float f2;
    if ((Math.round(PhotoView.o(this.a).left) < PhotoView.p(this.a).left) && (Math.round(PhotoView.o(this.a).right) > PhotoView.p(this.a).right)) {
      f2 = paramFloat1;
    } else {
      f2 = 0.0F;
    }
    float f3;
    if ((Math.round(PhotoView.o(this.a).top) < PhotoView.p(this.a).top) && (Math.round(PhotoView.o(this.a).bottom) > PhotoView.p(this.a).bottom)) {
      f3 = paramFloat2;
    } else {
      f3 = 0.0F;
    }
    if ((PhotoView.b(this.a)) || (PhotoView.c(this.a) % 90.0F != 0.0F))
    {
      float f4 = (int)(PhotoView.c(this.a) / 90.0F) * 90;
      float f5 = PhotoView.c(this.a) % 90.0F;
      float f1;
      if (f5 > 45.0F)
      {
        f1 = f4 + 90.0F;
      }
      else
      {
        f1 = f4;
        if (f5 < -45.0F) {
          f1 = f4 - 90.0F;
        }
      }
      PhotoView.n(this.a).a((int)PhotoView.c(this.a), (int)f1);
      PhotoView.b(this.a, f1);
    }
    PhotoView localPhotoView = this.a;
    PhotoView.a(localPhotoView, PhotoView.o(localPhotoView));
    PhotoView.n(this.a).b(f2, f3);
    PhotoView.n(this.a).a();
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (PhotoView.i(this.a) != null) {
      PhotoView.i(this.a).onLongClick(this.a);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (PhotoView.n(this.a).a) {
      PhotoView.n(this.a).b();
    }
    float f1;
    if (this.a.a(paramFloat1))
    {
      f1 = paramFloat1;
      if (paramFloat1 < 0.0F)
      {
        f1 = paramFloat1;
        if (PhotoView.o(this.a).left - paramFloat1 > PhotoView.p(this.a).left) {
          f1 = PhotoView.o(this.a).left;
        }
      }
      paramFloat1 = f1;
      if (f1 > 0.0F)
      {
        paramFloat1 = f1;
        if (PhotoView.o(this.a).right - f1 < PhotoView.p(this.a).right) {
          paramFloat1 = PhotoView.o(this.a).right - PhotoView.p(this.a).right;
        }
      }
      PhotoView.d(this.a).postTranslate(-paramFloat1, 0.0F);
      paramMotionEvent1 = this.a;
      PhotoView.a(paramMotionEvent1, (int)(PhotoView.q(paramMotionEvent1) - paramFloat1));
    }
    else if ((PhotoView.l(this.a)) || (PhotoView.k(this.a)) || (PhotoView.r(this.a)))
    {
      PhotoView.s(this.a);
      float f2 = paramFloat1;
      if (!PhotoView.k(this.a))
      {
        f1 = paramFloat1;
        if (paramFloat1 < 0.0F)
        {
          f1 = paramFloat1;
          if (PhotoView.o(this.a).left - paramFloat1 > PhotoView.t(this.a).left)
          {
            paramMotionEvent1 = this.a;
            f1 = PhotoView.a(paramMotionEvent1, PhotoView.o(paramMotionEvent1).left - PhotoView.t(this.a).left, paramFloat1);
          }
        }
        f2 = f1;
        if (f1 > 0.0F)
        {
          f2 = f1;
          if (PhotoView.o(this.a).right - f1 < PhotoView.t(this.a).right)
          {
            paramMotionEvent1 = this.a;
            f2 = PhotoView.a(paramMotionEvent1, PhotoView.o(paramMotionEvent1).right - PhotoView.t(this.a).right, f1);
          }
        }
      }
      paramMotionEvent1 = this.a;
      PhotoView.a(paramMotionEvent1, (int)(PhotoView.q(paramMotionEvent1) - f2));
      PhotoView.d(this.a).postTranslate(-f2, 0.0F);
      PhotoView.b(this.a, true);
    }
    if (this.a.b(paramFloat2))
    {
      paramFloat1 = paramFloat2;
      if (paramFloat2 < 0.0F)
      {
        paramFloat1 = paramFloat2;
        if (PhotoView.o(this.a).top - paramFloat2 > PhotoView.p(this.a).top) {
          paramFloat1 = PhotoView.o(this.a).top;
        }
      }
      paramFloat2 = paramFloat1;
      if (paramFloat1 > 0.0F)
      {
        paramFloat2 = paramFloat1;
        if (PhotoView.o(this.a).bottom - paramFloat1 < PhotoView.p(this.a).bottom) {
          paramFloat2 = PhotoView.o(this.a).bottom - PhotoView.p(this.a).bottom;
        }
      }
      PhotoView.d(this.a).postTranslate(0.0F, -paramFloat2);
      paramMotionEvent1 = this.a;
      PhotoView.b(paramMotionEvent1, (int)(PhotoView.u(paramMotionEvent1) - paramFloat2));
    }
    else if ((PhotoView.m(this.a)) || (PhotoView.r(this.a)) || (PhotoView.k(this.a)))
    {
      PhotoView.s(this.a);
      f1 = paramFloat2;
      if (!PhotoView.k(this.a))
      {
        paramFloat1 = paramFloat2;
        if (paramFloat2 < 0.0F)
        {
          paramFloat1 = paramFloat2;
          if (PhotoView.o(this.a).top - paramFloat2 > PhotoView.t(this.a).top)
          {
            paramMotionEvent1 = this.a;
            paramFloat1 = PhotoView.b(paramMotionEvent1, PhotoView.o(paramMotionEvent1).top - PhotoView.t(this.a).top, paramFloat2);
          }
        }
        f1 = paramFloat1;
        if (paramFloat1 > 0.0F)
        {
          f1 = paramFloat1;
          if (PhotoView.o(this.a).bottom - paramFloat1 < PhotoView.t(this.a).bottom)
          {
            paramMotionEvent1 = this.a;
            f1 = PhotoView.b(paramMotionEvent1, PhotoView.o(paramMotionEvent1).bottom - PhotoView.t(this.a).bottom, paramFloat1);
          }
        }
      }
      PhotoView.d(this.a).postTranslate(0.0F, -f1);
      paramMotionEvent1 = this.a;
      PhotoView.b(paramMotionEvent1, (int)(PhotoView.u(paramMotionEvent1) - f1));
      PhotoView.b(this.a, true);
    }
    PhotoView.g(this.a);
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.a;
    paramMotionEvent.postDelayed(PhotoView.j(paramMotionEvent), 250L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bm.library.PhotoView.4
 * JD-Core Version:    0.7.0.1
 */