package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper.Callback;

class SwipeDismissBehavior$1
  extends ViewDragHelper.Callback
{
  private int jdField_a_of_type_Int;
  private int b = -1;
  
  SwipeDismissBehavior$1(SwipeDismissBehavior paramSwipeDismissBehavior) {}
  
  private boolean a(@NonNull View paramView, float paramFloat)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    if (paramFloat != 0.0F)
    {
      if (ViewCompat.getLayoutDirection(paramView) == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior.jdField_a_of_type_Int == 2) {
        return true;
      }
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior.jdField_a_of_type_Int == 0)
      {
        if (i != 0 ? paramFloat < 0.0F : paramFloat > 0.0F) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior.jdField_a_of_type_Int == 1)
      {
        if (i != 0)
        {
          bool1 = bool2;
          if (paramFloat <= 0.0F) {
            break label123;
          }
        }
        else
        {
          bool1 = bool2;
          if (paramFloat >= 0.0F) {
            break label123;
          }
        }
        bool1 = true;
      }
      label123:
      return bool1;
    }
    int i = paramView.getLeft();
    int j = this.jdField_a_of_type_Int;
    int k = Math.round(paramView.getWidth() * this.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior.jdField_a_of_type_Float);
    bool1 = bool3;
    if (Math.abs(i - j) >= k) {
      bool1 = true;
    }
    return bool1;
  }
  
  public int clampViewPositionHorizontal(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    if (ViewCompat.getLayoutDirection(paramView) == 1) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    int i;
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior.jdField_a_of_type_Int == 0)
    {
      if (paramInt2 != 0)
      {
        i = this.jdField_a_of_type_Int - paramView.getWidth();
        paramInt2 = this.jdField_a_of_type_Int;
      }
      else
      {
        i = this.jdField_a_of_type_Int;
      }
    }
    else
    {
      for (paramInt2 = paramView.getWidth();; paramInt2 = paramView.getWidth())
      {
        paramInt2 += i;
        break label138;
        if (this.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior.jdField_a_of_type_Int != 1) {
          break label115;
        }
        if (paramInt2 == 0) {
          break;
        }
        i = this.jdField_a_of_type_Int;
      }
      i = this.jdField_a_of_type_Int - paramView.getWidth();
      paramInt2 = this.jdField_a_of_type_Int;
      break label138;
      label115:
      i = this.jdField_a_of_type_Int - paramView.getWidth();
      paramInt2 = this.jdField_a_of_type_Int;
      paramInt2 = paramView.getWidth() + paramInt2;
    }
    label138:
    return SwipeDismissBehavior.a(i, paramInt1, paramInt2);
  }
  
  public int clampViewPositionVertical(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    return paramView.getTop();
  }
  
  public int getViewHorizontalDragRange(@NonNull View paramView)
  {
    return paramView.getWidth();
  }
  
  public void onViewCaptured(@NonNull View paramView, int paramInt)
  {
    this.b = paramInt;
    this.jdField_a_of_type_Int = paramView.getLeft();
    paramView = paramView.getParent();
    if (paramView != null) {
      paramView.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  public void onViewDragStateChanged(int paramInt)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior$OnDismissListener != null) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior$OnDismissListener.a(paramInt);
    }
  }
  
  public void onViewPositionChanged(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = this.jdField_a_of_type_Int + paramView.getWidth() * this.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior.b;
    float f2 = this.jdField_a_of_type_Int + paramView.getWidth() * this.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior.c;
    float f3 = paramInt1;
    if (f3 <= f1)
    {
      paramView.setAlpha(1.0F);
      return;
    }
    if (f3 >= f2)
    {
      paramView.setAlpha(0.0F);
      return;
    }
    paramView.setAlpha(SwipeDismissBehavior.a(0.0F, 1.0F - SwipeDismissBehavior.b(f1, f2, f3), 1.0F));
  }
  
  public void onViewReleased(@NonNull View paramView, float paramFloat1, float paramFloat2)
  {
    this.b = -1;
    int i = paramView.getWidth();
    boolean bool;
    if (a(paramView, paramFloat1))
    {
      int j = paramView.getLeft();
      int k = this.jdField_a_of_type_Int;
      if (j < k) {
        i = k - i;
      } else {
        i = k + i;
      }
      bool = true;
    }
    else
    {
      i = this.jdField_a_of_type_Int;
      bool = false;
    }
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper.settleCapturedViewAt(i, paramView.getTop()))
    {
      ViewCompat.postOnAnimation(paramView, new SwipeDismissBehavior.SettleRunnable(this.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior, paramView, bool));
      return;
    }
    if ((bool) && (this.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior$OnDismissListener != null)) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior$OnDismissListener.a(paramView);
    }
  }
  
  public boolean tryCaptureView(View paramView, int paramInt)
  {
    int i = this.b;
    return ((i == -1) || (i == paramInt)) && (this.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior.a(paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.behavior.SwipeDismissBehavior.1
 * JD-Core Version:    0.7.0.1
 */