package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class BaseTransientBottomBar$BehaviorDelegate
{
  private SnackbarManager.Callback a;
  
  public BaseTransientBottomBar$BehaviorDelegate(@NonNull SwipeDismissBehavior<?> paramSwipeDismissBehavior)
  {
    paramSwipeDismissBehavior.a(0.1F);
    paramSwipeDismissBehavior.b(0.6F);
    paramSwipeDismissBehavior.a(0);
  }
  
  public void a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView, @NonNull MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if ((i != 1) && (i != 3)) {
        return;
      }
      SnackbarManager.a().d(this.a);
      return;
    }
    if (paramCoordinatorLayout.isPointInChildBounds(paramView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      SnackbarManager.a().c(this.a);
    }
  }
  
  public void a(@NonNull BaseTransientBottomBar<?> paramBaseTransientBottomBar)
  {
    this.a = paramBaseTransientBottomBar.c;
  }
  
  public boolean a(View paramView)
  {
    return paramView instanceof BaseTransientBottomBar.SnackbarBaseLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.BehaviorDelegate
 * JD-Core Version:    0.7.0.1
 */