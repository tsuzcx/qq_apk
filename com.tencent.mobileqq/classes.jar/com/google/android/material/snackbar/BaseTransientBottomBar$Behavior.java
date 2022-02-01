package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;

public class BaseTransientBottomBar$Behavior
  extends SwipeDismissBehavior<View>
{
  @NonNull
  private final BaseTransientBottomBar.BehaviorDelegate g = new BaseTransientBottomBar.BehaviorDelegate(this);
  
  private void a(@NonNull BaseTransientBottomBar<?> paramBaseTransientBottomBar)
  {
    this.g.a(paramBaseTransientBottomBar);
  }
  
  public boolean a(View paramView)
  {
    return this.g.a(paramView);
  }
  
  public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView, @NonNull MotionEvent paramMotionEvent)
  {
    this.g.a(paramCoordinatorLayout, paramView, paramMotionEvent);
    return super.onInterceptTouchEvent(paramCoordinatorLayout, paramView, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.Behavior
 * JD-Core Version:    0.7.0.1
 */