package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper.Callback;

public class SwipeDismissBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  float jdField_a_of_type_Float = 0.5F;
  int jdField_a_of_type_Int = 2;
  private final ViewDragHelper.Callback jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper$Callback = new SwipeDismissBehavior.1(this);
  ViewDragHelper jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper;
  SwipeDismissBehavior.OnDismissListener jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior$OnDismissListener;
  private boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float = 0.0F;
  private boolean jdField_b_of_type_Boolean;
  float c = 0.5F;
  private float d = 0.0F;
  
  static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.min(Math.max(paramFloat1, paramFloat2), paramFloat3);
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  private void a(View paramView)
  {
    ViewCompat.removeAccessibilityAction(paramView, 1048576);
    if (a(paramView)) {
      ViewCompat.replaceAccessibilityAction(paramView, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new SwipeDismissBehavior.2(this));
    }
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper == null)
    {
      if (this.jdField_b_of_type_Boolean) {
        paramViewGroup = ViewDragHelper.create(paramViewGroup, this.d, this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper$Callback);
      } else {
        paramViewGroup = ViewDragHelper.create(paramViewGroup, this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper$Callback);
      }
      this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper = paramViewGroup;
    }
  }
  
  static float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_b_of_type_Float = a(0.0F, paramFloat, 1.0F);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(@Nullable SwipeDismissBehavior.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialBehaviorSwipeDismissBehavior$OnDismissListener = paramOnDismissListener;
  }
  
  public boolean a(@NonNull View paramView)
  {
    return true;
  }
  
  public void b(float paramFloat)
  {
    this.c = a(0.0F, paramFloat, 1.0F);
  }
  
  public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull MotionEvent paramMotionEvent)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = paramCoordinatorLayout.isPointInChildBounds(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      bool = this.jdField_a_of_type_Boolean;
    }
    if (bool)
    {
      a(paramCoordinatorLayout);
      return this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper.shouldInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onLayoutChild(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, int paramInt)
  {
    boolean bool = super.onLayoutChild(paramCoordinatorLayout, paramV, paramInt);
    if (ViewCompat.getImportantForAccessibility(paramV) == 0)
    {
      ViewCompat.setImportantForAccessibility(paramV, 1);
      a(paramV);
    }
    return bool;
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    paramCoordinatorLayout = this.jdField_a_of_type_AndroidxCustomviewWidgetViewDragHelper;
    if (paramCoordinatorLayout != null)
    {
      paramCoordinatorLayout.processTouchEvent(paramMotionEvent);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.behavior.SwipeDismissBehavior
 * JD-Core Version:    0.7.0.1
 */