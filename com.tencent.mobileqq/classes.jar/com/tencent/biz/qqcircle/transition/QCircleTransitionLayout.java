package com.tencent.biz.qqcircle.transition;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import uav;
import uaw;

public class QCircleTransitionLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private QCircleTransitionInnerLayout jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout;
  private uaw jdField_a_of_type_Uaw;
  private boolean jdField_a_of_type_Boolean = QzoneConfig.getQQCircleEnableTransitionCloseAnim();
  private float jdField_b_of_type_Float = 0.5F;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = 500;
  private boolean jdField_c_of_type_Boolean = true;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int = 255;
  
  public QCircleTransitionLayout(@android.support.annotation.NonNull @androidx.annotation.NonNull Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public QCircleTransitionLayout(@android.support.annotation.NonNull @androidx.annotation.NonNull Context paramContext, @android.support.annotation.Nullable @androidx.annotation.Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public QCircleTransitionLayout(@android.support.annotation.NonNull @androidx.annotation.NonNull Context paramContext, @android.support.annotation.Nullable @androidx.annotation.Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = Math.abs(paramFloat1 - paramFloat3);
    paramFloat2 = Math.abs(paramFloat2 - paramFloat4);
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (!a()) {}
    label210:
    label240:
    do
    {
      for (;;)
      {
        return;
        float f1 = paramMotionEvent.getRawY();
        float f2 = paramMotionEvent.getRawX();
        switch (paramMotionEvent.getAction())
        {
        default: 
          return;
        case 1: 
        case 3: 
          if (this.jdField_a_of_type_Float >= 0.85F) {
            break label433;
          }
          if (this.jdField_a_of_type_Uaw != null)
          {
            this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable.setAlpha(0);
            this.jdField_a_of_type_Uaw.a(this.jdField_e_of_type_Float, this.jdField_f_of_type_Float);
            return;
          }
          break;
        case 2: 
          if (getBackground() == null)
          {
            if (Build.VERSION.SDK_INT >= 16) {
              setBackground(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
            }
          }
          else
          {
            if (this.jdField_d_of_type_Boolean)
            {
              this.jdField_d_of_type_Boolean = false;
              if (this.jdField_a_of_type_Uaw != null) {
                this.jdField_a_of_type_Uaw.a();
              }
            }
            this.jdField_e_of_type_Float = (f2 - this.jdField_d_of_type_Float);
            this.jdField_f_of_type_Float = (f1 - this.jdField_c_of_type_Float);
            this.jdField_f_of_type_Int = ((int)((1.0F - a(f2, f1, this.jdField_d_of_type_Float, this.jdField_c_of_type_Float) / this.jdField_c_of_type_Int) * 255.0F));
            if (this.jdField_f_of_type_Int <= 255) {
              break label390;
            }
            this.jdField_f_of_type_Int = 255;
            f1 = Math.abs(this.jdField_e_of_type_Float);
            f2 = Math.abs(this.jdField_f_of_type_Float);
            if (f1 <= f2) {
              break label405;
            }
            f1 /= this.jdField_d_of_type_Int;
            if ((this.jdField_a_of_type_Float >= this.jdField_b_of_type_Float) && (this.jdField_a_of_type_Float <= 1.0F)) {
              this.jdField_a_of_type_Float = (1.0F - f1);
            }
            if (this.jdField_a_of_type_Float >= this.jdField_b_of_type_Float) {
              break label416;
            }
            this.jdField_a_of_type_Float = this.jdField_b_of_type_Float;
          }
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout == null) {
              break label431;
            }
            this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.setTranslationX(this.jdField_e_of_type_Float);
            this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.setTranslationY(this.jdField_f_of_type_Float);
            this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.setPivotX(this.jdField_a_of_type_Int / 2.0F);
            this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.setPivotY(this.jdField_b_of_type_Int / 2.0F);
            this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.setScaleX(this.jdField_a_of_type_Float);
            this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.setScaleY(this.jdField_a_of_type_Float);
            this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable.setAlpha(this.jdField_f_of_type_Int);
            return;
            setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
            break;
            if (this.jdField_f_of_type_Int >= 0) {
              break label210;
            }
            this.jdField_f_of_type_Int = 0;
            break label210;
            f1 = f2 / this.jdField_e_of_type_Int;
            break label240;
            if (this.jdField_a_of_type_Float > 1.0F) {
              this.jdField_a_of_type_Float = 1.0F;
            }
          }
        }
      }
    } while (this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout == null);
    label390:
    label405:
    label416:
    label431:
    label433:
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.animate().translationX(0.0F).setDuration(300L).setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.animate().translationY(0.0F).setDuration(300L).setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.animate().scaleX(1.0F).setDuration(300L).setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.animate().scaleY(1.0F).setDuration(300L).setInterpolator(new DecelerateInterpolator()).setListener(new uav(this));
  }
  
  private boolean a()
  {
    return (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = ImmersiveUtils.a();
    this.jdField_b_of_type_Int = ImmersiveUtils.b();
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-16777216);
    this.jdField_d_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_e_of_type_Int = this.jdField_b_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void a(QCircleTransitionInnerLayout paramQCircleTransitionInnerLayout, uaw paramuaw)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout = paramQCircleTransitionInnerLayout;
    this.jdField_a_of_type_Uaw = paramuaw;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.a(paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while (paramMotionEvent.getAction() == 0)
    {
      return false;
      QLog.d("QCircleTransitionLayout", 1, "onInterceptTouchEvent: MotionEvent.ACTION_DOWN ");
      continue;
      this.jdField_c_of_type_Float = paramMotionEvent.getRawY();
      this.jdField_d_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_d_of_type_Boolean = true;
      QLog.d("QCircleTransitionLayout", 1, "onInterceptTouchEvent: MotionEvent.ACTION_MOVE StarX:" + this.jdField_d_of_type_Float + ",mStarY:" + this.jdField_c_of_type_Float);
      continue;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      QLog.d("QCircleTransitionLayout", 1, "onInterceptTouchEvent: MotionEvent.ACTION_UP x:" + f1 + ",y:" + f2);
    }
    return a();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent);
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.transition.QCircleTransitionLayout
 * JD-Core Version:    0.7.0.1
 */