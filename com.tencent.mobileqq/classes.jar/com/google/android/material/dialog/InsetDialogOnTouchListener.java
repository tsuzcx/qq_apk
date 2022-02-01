package com.google.android.material.dialog;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class InsetDialogOnTouchListener
  implements View.OnTouchListener
{
  @NonNull
  private final Dialog a;
  private final int b;
  private final int c;
  private final int d;
  
  public InsetDialogOnTouchListener(@NonNull Dialog paramDialog, @NonNull Rect paramRect)
  {
    this.a = paramDialog;
    this.b = paramRect.left;
    this.c = paramRect.top;
    this.d = ViewConfiguration.get(paramDialog.getContext()).getScaledWindowTouchSlop();
  }
  
  public boolean onTouch(@NonNull View paramView, @NonNull MotionEvent paramMotionEvent)
  {
    Object localObject = paramView.findViewById(16908290);
    int i = this.b + ((View)localObject).getLeft();
    int j = ((View)localObject).getWidth();
    int k = this.c + ((View)localObject).getTop();
    int m = ((View)localObject).getHeight();
    if (new RectF(i, k, j + i, m + k).contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
      return false;
    }
    localObject = MotionEvent.obtain(paramMotionEvent);
    if (paramMotionEvent.getAction() == 1) {
      ((MotionEvent)localObject).setAction(4);
    }
    if (Build.VERSION.SDK_INT < 28)
    {
      ((MotionEvent)localObject).setAction(0);
      i = this.d;
      ((MotionEvent)localObject).setLocation(-i - 1, -i - 1);
    }
    paramView.performClick();
    return this.a.onTouchEvent((MotionEvent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.dialog.InsetDialogOnTouchListener
 * JD-Core Version:    0.7.0.1
 */