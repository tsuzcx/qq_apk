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
    PhotoView.a(this.a).b();
    float f1 = PhotoView.a(this.a).left + PhotoView.a(this.a).width() / 2.0F;
    float f2 = PhotoView.a(this.a).top + PhotoView.a(this.a).height() / 2.0F;
    PhotoView.a(this.a).set(f1, f2);
    PhotoView.b(this.a).set(f1, f2);
    PhotoView.a(this.a, 0);
    PhotoView.b(this.a, 0);
    if (PhotoView.f(this.a))
    {
      f1 = PhotoView.c(this.a);
      f2 = 1.0F;
    }
    else
    {
      f1 = PhotoView.c(this.a);
      f2 = PhotoView.d(this.a);
      PhotoView.a(this.a).set(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    PhotoView.b(this.a).reset();
    PhotoView.b(this.a).postTranslate(-PhotoView.d(this.a).left, -PhotoView.d(this.a).top);
    PhotoView.b(this.a).postTranslate(PhotoView.b(this.a).x, PhotoView.b(this.a).y);
    PhotoView.b(this.a).postTranslate(-PhotoView.e(this.a), -PhotoView.f(this.a));
    PhotoView.b(this.a).postRotate(PhotoView.b(this.a), PhotoView.b(this.a).x, PhotoView.b(this.a).y);
    PhotoView.b(this.a).postScale(f2, f2, PhotoView.a(this.a).x, PhotoView.a(this.a).y);
    PhotoView.b(this.a).postTranslate(PhotoView.b(this.a), PhotoView.c(this.a));
    PhotoView.b(this.a).mapRect(PhotoView.e(this.a), PhotoView.d(this.a));
    paramMotionEvent = this.a;
    PhotoView.a(paramMotionEvent, PhotoView.e(paramMotionEvent));
    paramMotionEvent = this.a;
    PhotoView.d(paramMotionEvent, PhotoView.f(paramMotionEvent) ^ true);
    PhotoView.a(this.a).a(f1, f2);
    PhotoView.a(this.a).a();
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    PhotoView.b(this.a, false);
    PhotoView.c(this.a, false);
    PhotoView.a(this.a, false);
    paramMotionEvent = this.a;
    paramMotionEvent.removeCallbacks(PhotoView.a(paramMotionEvent));
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (PhotoView.b(this.a)) {
      return false;
    }
    if ((!PhotoView.c(this.a)) && (!PhotoView.d(this.a))) {
      return false;
    }
    if (PhotoView.a(this.a).a) {
      return false;
    }
    float f2;
    if ((Math.round(PhotoView.a(this.a).left) < PhotoView.b(this.a).left) && (Math.round(PhotoView.a(this.a).right) > PhotoView.b(this.a).right)) {
      f2 = paramFloat1;
    } else {
      f2 = 0.0F;
    }
    float f3;
    if ((Math.round(PhotoView.a(this.a).top) < PhotoView.b(this.a).top) && (Math.round(PhotoView.a(this.a).bottom) > PhotoView.b(this.a).bottom)) {
      f3 = paramFloat2;
    } else {
      f3 = 0.0F;
    }
    if ((PhotoView.a(this.a)) || (PhotoView.b(this.a) % 90.0F != 0.0F))
    {
      float f4 = (int)(PhotoView.b(this.a) / 90.0F) * 90;
      float f5 = PhotoView.b(this.a) % 90.0F;
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
      PhotoView.a(this.a).a((int)PhotoView.b(this.a), (int)f1);
      PhotoView.b(this.a, f1);
    }
    PhotoView localPhotoView = this.a;
    PhotoView.a(localPhotoView, PhotoView.a(localPhotoView));
    PhotoView.a(this.a).b(f2, f3);
    PhotoView.a(this.a).a();
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (PhotoView.a(this.a) != null) {
      PhotoView.a(this.a).onLongClick(this.a);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (PhotoView.a(this.a).a) {
      PhotoView.a(this.a).b();
    }
    float f1;
    if (this.a.a(paramFloat1))
    {
      f1 = paramFloat1;
      if (paramFloat1 < 0.0F)
      {
        f1 = paramFloat1;
        if (PhotoView.a(this.a).left - paramFloat1 > PhotoView.b(this.a).left) {
          f1 = PhotoView.a(this.a).left;
        }
      }
      paramFloat1 = f1;
      if (f1 > 0.0F)
      {
        paramFloat1 = f1;
        if (PhotoView.a(this.a).right - f1 < PhotoView.b(this.a).right) {
          paramFloat1 = PhotoView.a(this.a).right - PhotoView.b(this.a).right;
        }
      }
      PhotoView.a(this.a).postTranslate(-paramFloat1, 0.0F);
      paramMotionEvent1 = this.a;
      PhotoView.a(paramMotionEvent1, (int)(PhotoView.b(paramMotionEvent1) - paramFloat1));
    }
    else if ((PhotoView.c(this.a)) || (PhotoView.b(this.a)) || (PhotoView.e(this.a)))
    {
      PhotoView.b(this.a);
      float f2 = paramFloat1;
      if (!PhotoView.b(this.a))
      {
        f1 = paramFloat1;
        if (paramFloat1 < 0.0F)
        {
          f1 = paramFloat1;
          if (PhotoView.a(this.a).left - paramFloat1 > PhotoView.c(this.a).left)
          {
            paramMotionEvent1 = this.a;
            f1 = PhotoView.a(paramMotionEvent1, PhotoView.a(paramMotionEvent1).left - PhotoView.c(this.a).left, paramFloat1);
          }
        }
        f2 = f1;
        if (f1 > 0.0F)
        {
          f2 = f1;
          if (PhotoView.a(this.a).right - f1 < PhotoView.c(this.a).right)
          {
            paramMotionEvent1 = this.a;
            f2 = PhotoView.a(paramMotionEvent1, PhotoView.a(paramMotionEvent1).right - PhotoView.c(this.a).right, f1);
          }
        }
      }
      paramMotionEvent1 = this.a;
      PhotoView.a(paramMotionEvent1, (int)(PhotoView.b(paramMotionEvent1) - f2));
      PhotoView.a(this.a).postTranslate(-f2, 0.0F);
      PhotoView.b(this.a, true);
    }
    if (this.a.b(paramFloat2))
    {
      paramFloat1 = paramFloat2;
      if (paramFloat2 < 0.0F)
      {
        paramFloat1 = paramFloat2;
        if (PhotoView.a(this.a).top - paramFloat2 > PhotoView.b(this.a).top) {
          paramFloat1 = PhotoView.a(this.a).top;
        }
      }
      paramFloat2 = paramFloat1;
      if (paramFloat1 > 0.0F)
      {
        paramFloat2 = paramFloat1;
        if (PhotoView.a(this.a).bottom - paramFloat1 < PhotoView.b(this.a).bottom) {
          paramFloat2 = PhotoView.a(this.a).bottom - PhotoView.b(this.a).bottom;
        }
      }
      PhotoView.a(this.a).postTranslate(0.0F, -paramFloat2);
      paramMotionEvent1 = this.a;
      PhotoView.b(paramMotionEvent1, (int)(PhotoView.c(paramMotionEvent1) - paramFloat2));
    }
    else if ((PhotoView.d(this.a)) || (PhotoView.e(this.a)) || (PhotoView.b(this.a)))
    {
      PhotoView.b(this.a);
      f1 = paramFloat2;
      if (!PhotoView.b(this.a))
      {
        paramFloat1 = paramFloat2;
        if (paramFloat2 < 0.0F)
        {
          paramFloat1 = paramFloat2;
          if (PhotoView.a(this.a).top - paramFloat2 > PhotoView.c(this.a).top)
          {
            paramMotionEvent1 = this.a;
            paramFloat1 = PhotoView.b(paramMotionEvent1, PhotoView.a(paramMotionEvent1).top - PhotoView.c(this.a).top, paramFloat2);
          }
        }
        f1 = paramFloat1;
        if (paramFloat1 > 0.0F)
        {
          f1 = paramFloat1;
          if (PhotoView.a(this.a).bottom - paramFloat1 < PhotoView.c(this.a).bottom)
          {
            paramMotionEvent1 = this.a;
            f1 = PhotoView.b(paramMotionEvent1, PhotoView.a(paramMotionEvent1).bottom - PhotoView.c(this.a).bottom, paramFloat1);
          }
        }
      }
      PhotoView.a(this.a).postTranslate(0.0F, -f1);
      paramMotionEvent1 = this.a;
      PhotoView.b(paramMotionEvent1, (int)(PhotoView.c(paramMotionEvent1) - f1));
      PhotoView.b(this.a, true);
    }
    PhotoView.a(this.a);
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.a;
    paramMotionEvent.postDelayed(PhotoView.a(paramMotionEvent), 250L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.bm.library.PhotoView.4
 * JD-Core Version:    0.7.0.1
 */