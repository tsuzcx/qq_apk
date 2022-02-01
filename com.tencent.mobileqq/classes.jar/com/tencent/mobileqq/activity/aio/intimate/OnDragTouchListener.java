package com.tencent.mobileqq.activity.aio.intimate;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.RelativeLayout.LayoutParams;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/aio/intimate/OnDragTouchListener;", "Landroid/view/View$OnTouchListener;", "dragTopMargin", "", "(I)V", "CLICK_MIN_DISTANCE", "bottom", "distanceX", "", "distanceY", "fromX", "fromY", "left", "maxHeight", "maxWidth", "right", "top", "viewHeight", "viewWidth", "dip2px", "resources", "Landroid/content/res/Resources;", "dpValue", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class OnDragTouchListener
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private final int j;
  
  public OnDragTouchListener(int paramInt)
  {
    this.j = paramInt;
    this.jdField_a_of_type_Int = 2;
  }
  
  public final int a(@NotNull Resources paramResources, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramResources, "resources");
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public boolean onTouch(@NotNull View paramView, @NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    Object localObject;
    switch (paramMotionEvent.getAction())
    {
    default: 
      return true;
    case 0: 
      localObject = paramView.getParent();
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
      }
      this.jdField_b_of_type_Int = ((View)localObject).getWidth();
      localObject = paramView.getParent();
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
      }
      this.jdField_c_of_type_Int = ((View)localObject).getHeight();
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
      this.jdField_c_of_type_Float = (paramMotionEvent.getRawX() - paramView.getLeft());
      this.jdField_d_of_type_Float = (paramMotionEvent.getRawY() - paramView.getTop());
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      return true;
    case 2: 
      if (this.h == 0) {
        this.h = paramView.getWidth();
      }
      if (this.i == 0) {
        this.i = paramView.getHeight();
      }
      this.jdField_d_of_type_Int = ((int)(paramMotionEvent.getRawX() - this.jdField_c_of_type_Float));
      this.e = ((int)(paramMotionEvent.getRawY() - this.jdField_d_of_type_Float));
      this.f = (this.jdField_d_of_type_Int + this.h);
      this.g = (this.e + this.i);
      if (this.jdField_d_of_type_Int < 0)
      {
        this.jdField_d_of_type_Int = 0;
        this.f = (this.jdField_d_of_type_Int + this.h);
      }
      if (this.e < this.j)
      {
        this.e = this.j;
        this.g = (this.e + this.i);
      }
      if (this.f > this.jdField_b_of_type_Int)
      {
        this.f = this.jdField_b_of_type_Int;
        this.jdField_d_of_type_Int = (this.f - this.h);
      }
      if (this.g > this.jdField_c_of_type_Int)
      {
        this.g = this.jdField_c_of_type_Int;
        this.e = (this.g - this.i);
      }
      paramMotionEvent = paramView.getLayoutParams();
      if (paramMotionEvent == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      }
      paramMotionEvent = (RelativeLayout.LayoutParams)paramMotionEvent;
      paramMotionEvent.addRule(12, 0);
      paramMotionEvent.addRule(11, 0);
      paramMotionEvent.addRule(10);
      paramMotionEvent.addRule(9);
      localObject = (OnDragTouchListener)this;
      paramMotionEvent.bottomMargin = 0;
      paramMotionEvent.rightMargin = paramMotionEvent.bottomMargin;
      paramMotionEvent.topMargin = this.e;
      paramMotionEvent.leftMargin = this.jdField_d_of_type_Int;
      paramView.setLayoutParams((ViewGroup.LayoutParams)paramMotionEvent);
      return true;
    case 1: 
      localObject = paramView.getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "v.resources");
      int k = a((Resources)localObject, this.jdField_a_of_type_Int);
      if ((Math.abs(paramMotionEvent.getRawX() - this.jdField_a_of_type_Float) < k) && (Math.abs(paramMotionEvent.getRawY() - this.jdField_b_of_type_Float) < k)) {
        paramView.performClick();
      }
      paramView.getParent().requestDisallowInterceptTouchEvent(false);
      return true;
    }
    paramView.getParent().requestDisallowInterceptTouchEvent(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.OnDragTouchListener
 * JD-Core Version:    0.7.0.1
 */