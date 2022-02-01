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
      f2 = PhotoView.c(this.a);
      f1 = 1.0F;
      PhotoView.b(this.a).reset();
      PhotoView.b(this.a).postTranslate(-PhotoView.d(this.a).left, -PhotoView.d(this.a).top);
      PhotoView.b(this.a).postTranslate(PhotoView.b(this.a).x, PhotoView.b(this.a).y);
      PhotoView.b(this.a).postTranslate(-PhotoView.e(this.a), -PhotoView.f(this.a));
      PhotoView.b(this.a).postRotate(PhotoView.b(this.a), PhotoView.b(this.a).x, PhotoView.b(this.a).y);
      PhotoView.b(this.a).postScale(f1, f1, PhotoView.a(this.a).x, PhotoView.a(this.a).y);
      PhotoView.b(this.a).postTranslate(PhotoView.b(this.a), PhotoView.c(this.a));
      PhotoView.b(this.a).mapRect(PhotoView.e(this.a), PhotoView.d(this.a));
      PhotoView.a(this.a, PhotoView.e(this.a));
      paramMotionEvent = this.a;
      if (PhotoView.f(this.a)) {
        break label444;
      }
    }
    label444:
    for (boolean bool = true;; bool = false)
    {
      PhotoView.d(paramMotionEvent, bool);
      PhotoView.a(this.a).a(f2, f1);
      PhotoView.a(this.a).a();
      return false;
      f2 = PhotoView.c(this.a);
      f1 = PhotoView.d(this.a);
      PhotoView.a(this.a).set(paramMotionEvent.getX(), paramMotionEvent.getY());
      break;
    }
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    PhotoView.b(this.a, false);
    PhotoView.c(this.a, false);
    PhotoView.a(this.a, false);
    this.a.removeCallbacks(PhotoView.a(this.a));
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (PhotoView.b(this.a)) {}
    while (((!PhotoView.c(this.a)) && (!PhotoView.d(this.a))) || (PhotoView.a(this.a).a)) {
      return false;
    }
    if ((Math.round(PhotoView.a(this.a).left) >= PhotoView.b(this.a).left) || (Math.round(PhotoView.a(this.a).right) <= PhotoView.b(this.a).right)) {}
    for (float f2 = 0.0F;; f2 = paramFloat1)
    {
      if ((Math.round(PhotoView.a(this.a).top) >= PhotoView.b(this.a).top) || (Math.round(PhotoView.a(this.a).bottom) <= PhotoView.b(this.a).bottom)) {}
      for (float f3 = 0.0F;; f3 = paramFloat2)
      {
        float f4;
        float f5;
        float f1;
        if ((PhotoView.a(this.a)) || (PhotoView.b(this.a) % 90.0F != 0.0F))
        {
          f4 = (int)(PhotoView.b(this.a) / 90.0F) * 90;
          f5 = PhotoView.b(this.a) % 90.0F;
          if (f5 <= 45.0F) {
            break label311;
          }
          f1 = f4 + 90.0F;
        }
        for (;;)
        {
          PhotoView.a(this.a).a((int)PhotoView.b(this.a), (int)f1);
          PhotoView.b(this.a, f1);
          PhotoView.a(this.a, PhotoView.a(this.a));
          PhotoView.a(this.a).b(f2, f3);
          PhotoView.a(this.a).a();
          return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
          label311:
          f1 = f4;
          if (f5 < -45.0F) {
            f1 = f4 - 90.0F;
          }
        }
      }
    }
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
    if (this.a.a(paramFloat1))
    {
      if ((paramFloat1 >= 0.0F) || (PhotoView.a(this.a).left - paramFloat1 <= PhotoView.b(this.a).left)) {
        break label819;
      }
      paramFloat1 = PhotoView.a(this.a).left;
    }
    label813:
    label819:
    for (;;)
    {
      float f1 = paramFloat1;
      if (paramFloat1 > 0.0F)
      {
        f1 = paramFloat1;
        if (PhotoView.a(this.a).right - paramFloat1 < PhotoView.b(this.a).right) {
          f1 = PhotoView.a(this.a).right - PhotoView.b(this.a).right;
        }
      }
      PhotoView.a(this.a).postTranslate(-f1, 0.0F);
      PhotoView.a(this.a, (int)(PhotoView.b(this.a) - f1));
      if (this.a.b(paramFloat2)) {
        if ((paramFloat2 >= 0.0F) || (PhotoView.a(this.a).top - paramFloat2 <= PhotoView.b(this.a).top)) {
          break label813;
        }
      }
      for (paramFloat1 = PhotoView.a(this.a).top;; paramFloat1 = paramFloat2)
      {
        paramFloat2 = paramFloat1;
        if (paramFloat1 > 0.0F)
        {
          paramFloat2 = paramFloat1;
          if (PhotoView.a(this.a).bottom - paramFloat1 < PhotoView.b(this.a).bottom) {
            paramFloat2 = PhotoView.a(this.a).bottom - PhotoView.b(this.a).bottom;
          }
        }
        PhotoView.a(this.a).postTranslate(0.0F, -paramFloat2);
        PhotoView.b(this.a, (int)(PhotoView.c(this.a) - paramFloat2));
        for (;;)
        {
          PhotoView.a(this.a);
          return true;
          if ((!PhotoView.c(this.a)) && (!PhotoView.b(this.a)) && (!PhotoView.e(this.a))) {
            break;
          }
          PhotoView.b(this.a);
          float f2 = paramFloat1;
          if (!PhotoView.b(this.a))
          {
            f1 = paramFloat1;
            if (paramFloat1 < 0.0F)
            {
              f1 = paramFloat1;
              if (PhotoView.a(this.a).left - paramFloat1 > PhotoView.c(this.a).left) {
                f1 = PhotoView.a(this.a, PhotoView.a(this.a).left - PhotoView.c(this.a).left, paramFloat1);
              }
            }
            f2 = f1;
            if (f1 > 0.0F)
            {
              f2 = f1;
              if (PhotoView.a(this.a).right - f1 < PhotoView.c(this.a).right) {
                f2 = PhotoView.a(this.a, PhotoView.a(this.a).right - PhotoView.c(this.a).right, f1);
              }
            }
          }
          PhotoView.a(this.a, (int)(PhotoView.b(this.a) - f2));
          PhotoView.a(this.a).postTranslate(-f2, 0.0F);
          PhotoView.b(this.a, true);
          break;
          if ((PhotoView.d(this.a)) || (PhotoView.e(this.a)) || (PhotoView.b(this.a)))
          {
            PhotoView.b(this.a);
            f1 = paramFloat2;
            if (!PhotoView.b(this.a))
            {
              paramFloat1 = paramFloat2;
              if (paramFloat2 < 0.0F)
              {
                paramFloat1 = paramFloat2;
                if (PhotoView.a(this.a).top - paramFloat2 > PhotoView.c(this.a).top) {
                  paramFloat1 = PhotoView.b(this.a, PhotoView.a(this.a).top - PhotoView.c(this.a).top, paramFloat2);
                }
              }
              f1 = paramFloat1;
              if (paramFloat1 > 0.0F)
              {
                f1 = paramFloat1;
                if (PhotoView.a(this.a).bottom - paramFloat1 < PhotoView.c(this.a).bottom) {
                  f1 = PhotoView.b(this.a, PhotoView.a(this.a).bottom - PhotoView.c(this.a).bottom, paramFloat1);
                }
              }
            }
            PhotoView.a(this.a).postTranslate(0.0F, -f1);
            PhotoView.b(this.a, (int)(PhotoView.c(this.a) - f1));
            PhotoView.b(this.a, true);
          }
        }
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    this.a.postDelayed(PhotoView.a(this.a), 250L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.bm.library.PhotoView.4
 * JD-Core Version:    0.7.0.1
 */