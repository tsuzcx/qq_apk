package com.tencent.biz.qqcircle.transition;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import android.widget.Scroller;
import com.tencent.widget.immersive.ImmersiveUtils;
import vst;
import vsw;
import vsz;

class QCircleTransitionImageView$Transform
  implements Runnable
{
  int jdField_a_of_type_Int;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  OverScroller jdField_a_of_type_AndroidWidgetOverScroller;
  Scroller jdField_a_of_type_AndroidWidgetScroller;
  vst jdField_a_of_type_Vst;
  vsw jdField_a_of_type_Vsw = new vsw(this.this$0, null);
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  Scroller jdField_b_of_type_AndroidWidgetScroller;
  
  QCircleTransitionImageView$Transform(QCircleTransitionImageView paramQCircleTransitionImageView)
  {
    paramQCircleTransitionImageView = paramQCircleTransitionImageView.getContext();
    this.jdField_a_of_type_AndroidWidgetOverScroller = new OverScroller(paramQCircleTransitionImageView, this.jdField_a_of_type_Vsw);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramQCircleTransitionImageView, this.jdField_a_of_type_Vsw);
    this.jdField_b_of_type_AndroidWidgetScroller = new Scroller(paramQCircleTransitionImageView, this.jdField_a_of_type_Vsw);
  }
  
  private void c()
  {
    QCircleTransitionImageView.b(this.this$0).reset();
    QCircleTransitionImageView.b(this.this$0).postTranslate(-QCircleTransitionImageView.d(this.this$0).left, -QCircleTransitionImageView.d(this.this$0).top);
    QCircleTransitionImageView.b(this.this$0).postTranslate(QCircleTransitionImageView.a(this.this$0).x, QCircleTransitionImageView.a(this.this$0).y);
    QCircleTransitionImageView.b(this.this$0).postTranslate(-QCircleTransitionImageView.a(this.this$0), -QCircleTransitionImageView.b(this.this$0));
    QCircleTransitionImageView.b(this.this$0).postScale(QCircleTransitionImageView.c(this.this$0), QCircleTransitionImageView.c(this.this$0), QCircleTransitionImageView.b(this.this$0).x, QCircleTransitionImageView.b(this.this$0).y);
    QCircleTransitionImageView.b(this.this$0).postTranslate(QCircleTransitionImageView.b(this.this$0), QCircleTransitionImageView.c(this.this$0));
    QCircleTransitionImageView.a(this.this$0);
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
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll((int)(paramFloat1 * 10000.0F), 0, (int)((paramFloat2 - paramFloat1) * 10000.0F), 0, QCircleTransitionImageView.a(this.this$0));
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, vst paramvst)
  {
    this.jdField_b_of_type_AndroidWidgetScroller.startScroll((int)(paramFloat1 * 10000.0F), (int)(paramFloat2 * 10000.0F), (int)(paramFloat3 * 10000.0F), (int)(10000.0F * paramFloat4), paramInt);
    this.jdField_a_of_type_Vst = paramvst;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetOverScroller.startScroll(0, 0, paramInt3, paramInt4, QCircleTransitionImageView.a(this.this$0));
  }
  
  public void a(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_Vsw.a(paramInterpolator);
  }
  
  void b()
  {
    this.this$0.removeCallbacks(this);
    this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void run()
  {
    int j = 1;
    int k = 0;
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset()) {
      QCircleTransitionImageView.a(this.this$0, this.jdField_a_of_type_AndroidWidgetScroller.getCurrX() / 10000.0F);
    }
    for (int i = 0;; i = 1)
    {
      if (this.jdField_a_of_type_AndroidWidgetOverScroller.computeScrollOffset())
      {
        i = this.jdField_a_of_type_AndroidWidgetOverScroller.getCurrX();
        int m = this.jdField_a_of_type_Int;
        int n = this.jdField_a_of_type_AndroidWidgetOverScroller.getCurrY();
        int i1 = this.jdField_b_of_type_Int;
        QCircleTransitionImageView.a(this.this$0, i - m + QCircleTransitionImageView.b(this.this$0));
        QCircleTransitionImageView.b(this.this$0, n - i1 + QCircleTransitionImageView.c(this.this$0));
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetOverScroller.getCurrX();
        this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetOverScroller.getCurrY();
        i = 0;
      }
      if ((this.jdField_b_of_type_AndroidWidgetScroller.computeScrollOffset()) || (QCircleTransitionImageView.a(this.this$0) != null))
      {
        float f1 = this.jdField_b_of_type_AndroidWidgetScroller.getCurrX() / 10000.0F;
        float f2 = this.jdField_b_of_type_AndroidWidgetScroller.getCurrY() / 10000.0F;
        QCircleTransitionImageView.a(this.this$0).setScale(f1, f2, (QCircleTransitionImageView.b(this.this$0).left + QCircleTransitionImageView.b(this.this$0).right) / 2.0F, this.jdField_a_of_type_Vst.a());
        QCircleTransitionImageView.a(this.this$0).mapRect(this.jdField_a_of_type_AndroidGraphicsRectF, QCircleTransitionImageView.b(this.this$0));
        if (f1 == 1.0F)
        {
          this.jdField_a_of_type_AndroidGraphicsRectF.left = 0.0F;
          this.jdField_a_of_type_AndroidGraphicsRectF.right = ImmersiveUtils.a();
        }
        if (f2 == 1.0F)
        {
          this.jdField_a_of_type_AndroidGraphicsRectF.top = 0.0F;
          this.jdField_a_of_type_AndroidGraphicsRectF.bottom = ImmersiveUtils.b();
        }
        QCircleTransitionImageView.a(this.this$0, this.jdField_a_of_type_AndroidGraphicsRectF);
      }
      if (i == 0)
      {
        c();
        d();
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      i = k;
      if (QCircleTransitionImageView.a(this.this$0))
      {
        if (QCircleTransitionImageView.b(this.this$0).left > 0.0F)
        {
          QCircleTransitionImageView.a(this.this$0, (int)(QCircleTransitionImageView.b(this.this$0) - QCircleTransitionImageView.b(this.this$0).left));
          label387:
          i = 1;
        }
      }
      else
      {
        if (!QCircleTransitionImageView.b(this.this$0)) {
          break label628;
        }
        if (QCircleTransitionImageView.b(this.this$0).top <= 0.0F) {
          break label557;
        }
        QCircleTransitionImageView.b(this.this$0, (int)(QCircleTransitionImageView.c(this.this$0) - QCircleTransitionImageView.b(this.this$0).top));
        i = j;
      }
      label557:
      label628:
      for (;;)
      {
        if (i != 0) {
          c();
        }
        this.this$0.invalidate();
        if (QCircleTransitionImageView.a(this.this$0) == null) {
          break;
        }
        QCircleTransitionImageView.a(this.this$0).a();
        QCircleTransitionImageView.a(this.this$0, null);
        return;
        if (QCircleTransitionImageView.b(this.this$0).right >= QCircleTransitionImageView.c(this.this$0).width()) {
          break label387;
        }
        QCircleTransitionImageView.a(this.this$0, QCircleTransitionImageView.b(this.this$0) - (int)(QCircleTransitionImageView.c(this.this$0).width() - QCircleTransitionImageView.b(this.this$0).right));
        break label387;
        i = j;
        if (QCircleTransitionImageView.b(this.this$0).bottom < QCircleTransitionImageView.c(this.this$0).height())
        {
          QCircleTransitionImageView.b(this.this$0, QCircleTransitionImageView.c(this.this$0) - (int)(QCircleTransitionImageView.c(this.this$0).height() - QCircleTransitionImageView.b(this.this$0).bottom));
          i = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.transition.QCircleTransitionImageView.Transform
 * JD-Core Version:    0.7.0.1
 */