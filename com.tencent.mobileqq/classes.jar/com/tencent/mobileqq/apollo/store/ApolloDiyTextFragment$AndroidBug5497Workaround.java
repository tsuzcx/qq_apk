package com.tencent.mobileqq.apollo.store;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ApolloDiyTextFragment$AndroidBug5497Workaround
{
  private View a;
  private int b;
  private FrameLayout.LayoutParams c;
  
  private ApolloDiyTextFragment$AndroidBug5497Workaround(Activity paramActivity)
  {
    this.a = ((FrameLayout)paramActivity.findViewById(16908290)).getChildAt(0);
    this.a.getViewTreeObserver().addOnGlobalLayoutListener(new ApolloDiyTextFragment.AndroidBug5497Workaround.1(this));
    this.c = ((FrameLayout.LayoutParams)this.a.getLayoutParams());
  }
  
  private void a()
  {
    int i = b();
    if (i != this.b)
    {
      int j = this.a.getRootView().getHeight();
      int k = j - i;
      if (k > j / 4) {
        this.c.height = (j - k);
      } else {
        this.c.height = j;
      }
      this.a.requestLayout();
      this.b = i;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    new AndroidBug5497Workaround(paramActivity);
  }
  
  private int b()
  {
    Rect localRect = new Rect();
    this.a.getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloDiyTextFragment.AndroidBug5497Workaround
 * JD-Core Version:    0.7.0.1
 */