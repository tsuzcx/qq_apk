package com.tencent.biz.subscribe.utils;

import android.view.View;
import android.view.Window;

public class NavigationBarUtil
{
  public static void a(Window paramWindow)
  {
    if (paramWindow == null) {
      return;
    }
    paramWindow.getDecorView().setSystemUiVisibility(2);
    paramWindow.getDecorView().setOnSystemUiVisibilityChangeListener(new NavigationBarUtil.1(paramWindow));
  }
  
  public static void b(Window paramWindow)
  {
    if (paramWindow == null) {
      return;
    }
    paramWindow.setFlags(8, 8);
  }
  
  public static void c(Window paramWindow)
  {
    if (paramWindow == null) {
      return;
    }
    paramWindow.clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.NavigationBarUtil
 * JD-Core Version:    0.7.0.1
 */