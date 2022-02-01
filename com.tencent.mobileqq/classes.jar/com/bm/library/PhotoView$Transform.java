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
    this.jdField_b_of_type_AndroidWidgetScroller.startScroll((int)(paramFloat1 * 10000.0F), (int)(paramFloat2 * 10000.0F), (int)(paramFloat3 * 10000.0F), (int)(paramFloat4 * 10000.0F), paramInt);
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
    if (paramFloat1 < 0.0F) {
      i = 2147483647;
    } else {
      i = 0;
    }
    this.jdField_a_of_type_Int = i;
    float f;
    if (paramFloat1 > 0.0F) {
      f = Math.abs(PhotoView.a(this.this$0).left);
    } else {
      f = PhotoView.a(this.this$0).right - PhotoView.b(this.this$0).right;
    }
    int j = (int)f;
    int i = j;
    if (paramFloat1 < 0.0F) {
      i = 2147483647 - j;
    }
    if (paramFloat1 < 0.0F) {
      j = i;
    } else {
      j = 0;
    }
    int k;
    if (paramFloat1 < 0.0F) {
      k = 2147483647;
    } else {
      k = i;
    }
    int i1 = i;
    if (paramFloat1 < 0.0F) {
      i1 = 2147483647 - j;
    }
    if (paramFloat2 < 0.0F) {
      i = 2147483647;
    } else {
      i = 0;
    }
    this.jdField_b_of_type_Int = i;
    if (paramFloat2 > 0.0F) {
      f = Math.abs(PhotoView.a(this.this$0).top);
    } else {
      f = PhotoView.a(this.this$0).bottom - PhotoView.b(this.this$0).bottom;
    }
    int m = (int)f;
    i = m;
    if (paramFloat2 < 0.0F) {
      i = 2147483647 - m;
    }
    if (paramFloat2 < 0.0F) {
      m = i;
    } else {
      m = 0;
    }
    int n;
    if (paramFloat2 < 0.0F) {
      n = 2147483647;
    } else {
      n = i;
    }
    if (paramFloat2 < 0.0F) {
      i = 2147483647 - m;
    }
    if (paramFloat1 == 0.0F)
    {
      j = 0;
      k = 0;
    }
    if (paramFloat2 == 0.0F)
    {
      m = 0;
      n = 0;
    }
    OverScroller localOverScroller = this.jdField_b_of_type_AndroidWidgetOverScroller;
    int i2 = this.jdField_a_of_type_Int;
    int i3 = this.jdField_b_of_type_Int;
    int i4 = (int)paramFloat1;
    int i5 = (int)paramFloat2;
    if (Math.abs(i1) < PhotoView.e(this.this$0) * 2) {
      i1 = 0;
    } else {
      i1 = PhotoView.e(this.this$0);
    }
    if (Math.abs(i) < PhotoView.e(this.this$0) * 2) {
      i = 0;
    } else {
      i = PhotoView.e(this.this$0);
    }
    localOverScroller.fling(i2, i3, i4, i5, j, k, m, n, i1, i);
  }
  
  public void run()
  {
    boolean bool = this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
    int j = 1;
    int k = 0;
    if (bool)
    {
      PhotoView.c(this.this$0, this.jdField_a_of_type_AndroidWidgetScroller.getCurrX() / 10000.0F);
      i = 0;
    }
    else
    {
      i = 1;
    }
    int m;
    int n;
    int i1;
    PhotoView localPhotoView;
    if (this.jdField_a_of_type_AndroidWidgetOverScroller.computeScrollOffset())
    {
      i = this.jdField_a_of_type_AndroidWidgetOverScroller.getCurrX();
      m = this.jdField_c_of_type_Int;
      n = this.jdField_a_of_type_AndroidWidgetOverScroller.getCurrY();
      i1 = this.d;
      localPhotoView = this.this$0;
      PhotoView.a(localPhotoView, PhotoView.b(localPhotoView) + (i - m));
      localPhotoView = this.this$0;
      PhotoView.b(localPhotoView, PhotoView.c(localPhotoView) + (n - i1));
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
      localPhotoView = this.this$0;
      PhotoView.a(localPhotoView, PhotoView.b(localPhotoView) + (i - m));
      localPhotoView = this.this$0;
      PhotoView.b(localPhotoView, PhotoView.c(localPhotoView) + (n - i1));
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
    int i = k;
    if (PhotoView.c(this.this$0))
    {
      if (PhotoView.a(this.this$0).left > 0.0F)
      {
        localPhotoView = this.this$0;
        PhotoView.a(localPhotoView, (int)(PhotoView.b(localPhotoView) - PhotoView.a(this.this$0).left));
      }
      else if (PhotoView.a(this.this$0).right < PhotoView.b(this.this$0).width())
      {
        localPhotoView = this.this$0;
        PhotoView.a(localPhotoView, PhotoView.b(localPhotoView) - (int)(PhotoView.b(this.this$0).width() - PhotoView.a(this.this$0).right));
      }
      i = 1;
    }
    if (PhotoView.d(this.this$0)) {
      if (PhotoView.a(this.this$0).top > 0.0F)
      {
        localPhotoView = this.this$0;
        PhotoView.b(localPhotoView, (int)(PhotoView.c(localPhotoView) - PhotoView.a(this.this$0).top));
        i = j;
      }
      else
      {
        i = j;
        if (PhotoView.a(this.this$0).bottom < PhotoView.b(this.this$0).height())
        {
          localPhotoView = this.this$0;
          PhotoView.b(localPhotoView, PhotoView.c(localPhotoView) - (int)(PhotoView.b(this.this$0).height() - PhotoView.a(this.this$0).bottom));
          i = j;
        }
      }
    }
    if (i != 0) {
      c();
    }
    this.this$0.invalidate();
    if (PhotoView.b(this.this$0) != null)
    {
      PhotoView.b(this.this$0).run();
      PhotoView.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.bm.library.PhotoView.Transform
 * JD-Core Version:    0.7.0.1
 */