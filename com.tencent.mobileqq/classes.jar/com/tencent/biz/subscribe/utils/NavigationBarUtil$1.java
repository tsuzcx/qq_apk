package com.tencent.biz.subscribe.utils;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

final class NavigationBarUtil$1
  implements View.OnSystemUiVisibilityChangeListener
{
  NavigationBarUtil$1(Window paramWindow) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramInt = 5894;
    } else {
      paramInt = 1799;
    }
    this.a.getDecorView().setSystemUiVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.NavigationBarUtil.1
 * JD-Core Version:    0.7.0.1
 */