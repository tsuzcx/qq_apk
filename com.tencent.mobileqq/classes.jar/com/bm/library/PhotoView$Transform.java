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
  int jdField_a_of_type_Int;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  OverScroller jdField_a_of_type_AndroidWidgetOverScroller;
  Scroller jdField_a_of_type_AndroidWidgetScroller;
  PhotoView.ClipCalculate jdField_a_of_type_ComBmLibraryPhotoView$ClipCalculate;
  PhotoView.InterpolatorProxy jdField_a_of_type_ComBmLibraryPhotoView$InterpolatorProxy = new PhotoView.InterpolatorProxy(this.this$0, null);
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  OverScroller jdField_b_of_type_AndroidWidgetOverScroller;
  Scroller jdField_b_of_type_AndroidWidgetScroller;
  int jdField_c_of_type_Int;
  Scroller jdField_c_of_type_AndroidWidgetScroller;
  int d;
  
  PhotoView$Transform(PhotoView paramPhotoView)
  {
    paramPhotoView = paramPhotoView.getContext();
    this.jdField_a_of_type_AndroidWidgetOverScroller = new OverScroller(paramPhotoView, this.jdField_a_of_type_ComBmLibraryPhotoView$InterpolatorProxy);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramPhotoView, this.jdField_a_of_type_ComBmLibraryPhotoView$InterpolatorProxy);
    this.jdField_b_of_type_AndroidWidgetOverScroller = new OverScroller(paramPhotoView, this.jdField_a_of_type_ComBmLibraryPhotoView$InterpolatorProxy);
    this.jdField_b_of_type_AndroidWidgetScroller = new Scroller(paramPhotoView, this.jdField_a_of_type_ComBmLibraryPhotoView$InterpolatorProxy);
    this.jdField_c_of_type_AndroidWidgetScroller = new Scroller(paramPhotoView, this.jdField_a_of_type_ComBmLibraryPhotoView$InterpolatorProxy);
  }
  
  private void c()
  {
    PhotoView.a(this.this$0).reset();
    PhotoView.a(this.this$0).postTranslate(-PhotoView.d(this.this$0).left, -PhotoView.d(this.this$0).top);
    PhotoView.a(this.this$0).postTranslate(PhotoView.b(this.this$0).x, PhotoView.b(this.this$0).y);
    PhotoView.a(this.this$0).postTranslate(-PhotoView.e(this.this$0), -PhotoView.f(this.this$0));
    PhotoView.a(this.this$0).postRotate(PhotoView.b(this.this$0), PhotoView.b(this.this$0).x, PhotoView.b(this.this$0).y);
    PhotoView.a(this.this$0).postScale(PhotoView.c(this.this$0), PhotoView.c(this.this$0), PhotoView.a(this.this$0).x, PhotoView.a(this.this$0).y);
    PhotoView.a(this.this$0).postTranslate(PhotoView.b(this.this$0), PhotoView.c(this.this$0));
    PhotoView.a(this.this$0);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.this$0.post(this);
    }
  }
  
  void a()
  {
    this.jdField_a_of_type_Boolean = true;
    d();
  }
  
  void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll((int)(paramFloat1 * 10000.0F), 0, (int)((paramFloat2 - paramFloat1) * 10000.0F), 0, PhotoView.d(this.this$0));
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, PhotoView.ClipCalculate paramClipCalculate)
  {
    this.jdField_b_of_type_AndroidWidgetScroller.startScroll((int)(paramFloat1 * 10000.0F), (int)(paramFloat2 * 10000.0F), (int)(paramFloat3 * 10000.0F), (int)(10000.0F * paramFloat4), paramInt);
    this.jdField_a_of_type_ComBmLibraryPhotoView$ClipCalculate = paramClipCalculate;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_AndroidWidgetScroller.startScroll(paramInt1, 0, paramInt2 - paramInt1, 0, PhotoView.d(this.this$0));
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_c_of_type_Int = 0;
    this.d = 0;
    this.jdField_a_of_type_AndroidWidgetOverScroller.startScroll(0, 0, paramInt3, paramInt4, PhotoView.d(this.this$0));
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_ComBmLibraryPhotoView$InterpolatorProxy.a(paramInterpolator);
  }
  
  void b()
  {
    this.this$0.removeCallbacks(this);
    this.jdField_a_of_type_AndroidWidgetOverScroller.abortAnimation();
    this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
    this.jdField_b_of_type_AndroidWidgetOverScroller.abortAnimation();
    this.jdField_c_of_type_AndroidWidgetScroller.abortAnimation();
    this.jdField_a_of_type_Boolean = false;
  }
  
  void b(float paramFloat1, float paramFloat2)
  {
    int i2 = 0;
    float f;
    label39:
    int j;
    label70:
    int k;
    label80:
    int i1;
    label93:
    label103:
    int m;
    label129:
    label160:
    int n;
    label170:
    label183:
    OverScroller localOverScroller;
    int i3;
    int i4;
    int i5;
    int i6;
    if (paramFloat1 < 0.0F)
    {
      i = 2147483647;
      this.jdField_a_of_type_Int = i;
      if (paramFloat1 <= 0.0F) {
        break label306;
      }
      f = Math.abs(PhotoView.a(this.this$0).left);
      j = (int)f;
      i = j;
      if (paramFloat1 < 0.0F) {
        i = 2147483647 - j;
      }
      if (paramFloat1 >= 0.0F) {
        break label331;
      }
      j = i;
      if (paramFloat1 >= 0.0F) {
        break label337;
      }
      k = 2147483647;
      if (paramFloat1 >= 0.0F) {
        break label344;
      }
      i1 = 2147483647 - j;
      if (paramFloat2 >= 0.0F) {
        break label351;
      }
      i = 2147483647;
      this.jdField_b_of_type_Int = i;
      if (paramFloat2 <= 0.0F) {
        break label357;
      }
      f = Math.abs(PhotoView.a(this.this$0).top);
      m = (int)f;
      i = m;
      if (paramFloat2 < 0.0F) {
        i = 2147483647 - m;
      }
      if (paramFloat2 >= 0.0F) {
        break label382;
      }
      m = i;
      if (paramFloat2 >= 0.0F) {
        break label388;
      }
      n = 2147483647;
      if (paramFloat2 >= 0.0F) {
        break label395;
      }
      i = 2147483647 - m;
      if (paramFloat1 == 0.0F)
      {
        k = 0;
        j = 0;
      }
      if (paramFloat2 == 0.0F)
      {
        n = 0;
        m = 0;
      }
      localOverScroller = this.jdField_b_of_type_AndroidWidgetOverScroller;
      i3 = this.jdField_a_of_type_Int;
      i4 = this.jdField_b_of_type_Int;
      i5 = (int)paramFloat1;
      i6 = (int)paramFloat2;
      if (Math.abs(i1) >= PhotoView.e(this.this$0) * 2) {
        break label398;
      }
      i1 = 0;
      label253:
      if (Math.abs(i) >= PhotoView.e(this.this$0) * 2) {
        break label410;
      }
    }
    label388:
    label395:
    label398:
    label410:
    for (int i = i2;; i = PhotoView.e(this.this$0))
    {
      localOverScroller.fling(i3, i4, i5, i6, j, k, m, n, i1, i);
      return;
      i = 0;
      break;
      label306:
      f = PhotoView.a(this.this$0).right - PhotoView.b(this.this$0).right;
      break label39;
      label331:
      j = 0;
      break label70;
      label337:
      k = i;
      break label80;
      label344:
      i1 = i;
      break label93;
      label351:
      i = 0;
      break label103;
      label357:
      f = PhotoView.a(this.this$0).bottom - PhotoView.b(this.this$0).bottom;
      break label129;
      label382:
      m = 0;
      break label160;
      n = i;
      break label170;
      break label183;
      i1 = PhotoView.e(this.this$0);
      break label253;
    }
  }
  
  public void run()
  {
    int j = 1;
    int k = 0;
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset()) {
      PhotoView.c(this.this$0, this.jdField_a_of_type_AndroidWidgetScroller.getCurrX() / 10000.0F);
    }
    for (int i = 0;; i = 1)
    {
      int m;
      int n;
      int i1;
      if (this.jdField_a_of_type_AndroidWidgetOverScroller.computeScrollOffset())
      {
        i = this.jdField_a_of_type_AndroidWidgetOverScroller.getCurrX();
        m = this.jdField_c_of_type_Int;
        n = this.jdField_a_of_type_AndroidWidgetOverScroller.getCurrY();
        i1 = this.d;
        PhotoView.a(this.this$0, i - m + PhotoView.b(this.this$0));
        PhotoView.b(this.this$0, n - i1 + PhotoView.c(this.this$0));
        this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidWidgetOverScroller.getCurrX();
        this.d = this.jdField_a_of_type_AndroidWidgetOverScroller.getCurrY();
        i = 0;
      }
      if (this.jdField_b_of_type_AndroidWidgetOverScroller.computeScrollOffset())
      {
        i = this.jdField_b_of_type_AndroidWidgetOverScroller.getCurrX();
        m = this.jdField_a_of_type_Int;
        n = this.jdField_b_of_type_AndroidWidgetOverScroller.getCurrY();
        i1 = this.jdField_b_of_type_Int;
        this.jdField_a_of_type_Int = this.jdField_b_of_type_AndroidWidgetOverScroller.getCurrX();
        this.jdField_b_of_type_Int = this.jdField_b_of_type_AndroidWidgetOverScroller.getCurrY();
        PhotoView.a(this.this$0, i - m + PhotoView.b(this.this$0));
        PhotoView.b(this.this$0, n - i1 + PhotoView.c(this.this$0));
        i = 0;
      }
      if (this.jdField_c_of_type_AndroidWidgetScroller.computeScrollOffset())
      {
        PhotoView.b(this.this$0, this.jdField_c_of_type_AndroidWidgetScroller.getCurrX());
        i = 0;
      }
      if ((this.jdField_b_of_type_AndroidWidgetScroller.computeScrollOffset()) || (PhotoView.f(this.this$0) != null))
      {
        float f1 = this.jdField_b_of_type_AndroidWidgetScroller.getCurrX() / 10000.0F;
        float f2 = this.jdField_b_of_type_AndroidWidgetScroller.getCurrY() / 10000.0F;
        PhotoView.b(this.this$0).setScale(f1, f2, (PhotoView.a(this.this$0).left + PhotoView.a(this.this$0).right) / 2.0F, this.jdField_a_of_type_ComBmLibraryPhotoView$ClipCalculate.a());
        PhotoView.b(this.this$0).mapRect(this.jdField_a_of_type_AndroidGraphicsRectF, PhotoView.a(this.this$0));
        if (f1 == 1.0F)
        {
          this.jdField_a_of_type_AndroidGraphicsRectF.left = PhotoView.b(this.this$0).left;
          this.jdField_a_of_type_AndroidGraphicsRectF.right = PhotoView.b(this.this$0).right;
        }
        if (f2 == 1.0F)
        {
          this.jdField_a_of_type_AndroidGraphicsRectF.top = PhotoView.b(this.this$0).top;
          this.jdField_a_of_type_AndroidGraphicsRectF.bottom = PhotoView.b(this.this$0).bottom;
        }
        PhotoView.a(this.this$0, this.jdField_a_of_type_AndroidGraphicsRectF);
      }
      if (i == 0)
      {
        c();
        d();
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      i = k;
      if (PhotoView.c(this.this$0))
      {
        if (PhotoView.a(this.this$0).left > 0.0F)
        {
          PhotoView.a(this.this$0, (int)(PhotoView.b(this.this$0) - PhotoView.a(this.this$0).left));
          label549:
          i = 1;
        }
      }
      else
      {
        if (!PhotoView.d(this.this$0)) {
          break label790;
        }
        if (PhotoView.a(this.this$0).top <= 0.0F) {
          break label719;
        }
        PhotoView.b(this.this$0, (int)(PhotoView.c(this.this$0) - PhotoView.a(this.this$0).top));
        i = j;
      }
      label790:
      for (;;)
      {
        if (i != 0) {
          c();
        }
        this.this$0.invalidate();
        if (PhotoView.b(this.this$0) == null) {
          break;
        }
        PhotoView.b(this.this$0).run();
        PhotoView.a(this.this$0, null);
        return;
        if (PhotoView.a(this.this$0).right >= PhotoView.b(this.this$0).width()) {
          break label549;
        }
        PhotoView.a(this.this$0, PhotoView.b(this.this$0) - (int)(PhotoView.b(this.this$0).width() - PhotoView.a(this.this$0).right));
        break label549;
        label719:
        i = j;
        if (PhotoView.a(this.this$0).bottom < PhotoView.b(this.this$0).height())
        {
          PhotoView.b(this.this$0, PhotoView.c(this.this$0) - (int)(PhotoView.b(this.this$0).height() - PhotoView.a(this.this$0).bottom));
          i = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.bm.library.PhotoView.Transform
 * JD-Core Version:    0.7.0.1
 */