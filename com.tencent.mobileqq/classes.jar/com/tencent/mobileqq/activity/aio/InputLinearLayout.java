package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

public class InputLinearLayout
  extends LinearLayout
{
  private int a = 1;
  
  public InputLinearLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InputLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setClipToPadding(false);
  }
  
  public void a(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        a(paramView.getChildAt(i));
        i += 1;
      }
    }
    if (this.a == 1)
    {
      ViewCompat.setImportantForAccessibility(paramView, 1);
      return;
    }
    ViewCompat.setImportantForAccessibility(paramView, 2);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.InputLinearLayout", 2, "dispatchTouchEvent status = " + this.a + " action = " + paramMotionEvent.getAction());
    }
    if (this.a == 1) {}
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return true;
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = getChildAt(0);
    if ((localView != null) && (localView.getVisibility() != 8)) {
      localView.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  public void setStatus(int paramInt)
  {
    this.a = paramInt;
    a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.InputLinearLayout
 * JD-Core Version:    0.7.0.1
 */