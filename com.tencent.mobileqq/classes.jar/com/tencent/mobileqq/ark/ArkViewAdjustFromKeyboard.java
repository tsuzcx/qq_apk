package com.tencent.mobileqq.ark;

import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;

public class ArkViewAdjustFromKeyboard
{
  private View a;
  private int b;
  private ViewGroup.MarginLayoutParams c;
  private int d = 0;
  private ArkAppView e;
  private int f = 0;
  
  private ArkViewAdjustFromKeyboard(Activity paramActivity, ArkAppView paramArkAppView)
  {
    Object localObject = (FrameLayout)paramActivity.findViewById(16908290);
    if (localObject == null) {
      return;
    }
    this.a = ((FrameLayout)localObject).getChildAt(0);
    localObject = this.a;
    if (localObject != null) {
      ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new ArkViewAdjustFromKeyboard.1(this));
    }
    this.e = paramArkAppView;
    this.c = ((ViewGroup.MarginLayoutParams)paramArkAppView.getLayoutParams());
    paramArkAppView = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(paramArkAppView);
    this.f = paramArkAppView.heightPixels;
    this.d = this.c.topMargin;
  }
  
  private void a()
  {
    int i = b();
    if (i != this.b)
    {
      int k = this.a.getRootView().getHeight();
      int j = k - i;
      if (j > k / 4)
      {
        Rect localRect = this.e.getInputRect();
        int[] arrayOfInt = new int[2];
        this.e.getLocationOnScreen(arrayOfInt);
        k = localRect.bottom + arrayOfInt[1];
        j = this.f - j;
        if (j < k)
        {
          this.c.topMargin = (j - k);
          this.e.requestLayout();
        }
      }
      else
      {
        this.c.topMargin = this.d;
        this.e.requestLayout();
      }
      this.b = i;
    }
  }
  
  public static void a(Activity paramActivity, ArkAppView paramArkAppView)
  {
    new ArkViewAdjustFromKeyboard(paramActivity, paramArkAppView);
  }
  
  private int b()
  {
    Rect localRect = new Rect();
    this.a.getWindowVisibleDisplayFrame(localRect);
    return localRect.bottom - localRect.top;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkViewAdjustFromKeyboard
 * JD-Core Version:    0.7.0.1
 */