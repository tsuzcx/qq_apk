package com.google.android.material.navigation;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.NavigationMenuPresenter;

class NavigationView$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  NavigationView$2(NavigationView paramNavigationView) {}
  
  public void onGlobalLayout()
  {
    Object localObject = this.a;
    ((NavigationView)localObject).getLocationOnScreen(NavigationView.a((NavigationView)localObject));
    localObject = NavigationView.a(this.a);
    boolean bool2 = true;
    boolean bool1;
    if (localObject[1] == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    NavigationView.b(this.a).b(bool1);
    this.a.setDrawTopInsetForeground(bool1);
    localObject = ContextUtils.a(this.a.getContext());
    if ((localObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      int i;
      if (((Activity)localObject).findViewById(16908290).getHeight() == this.a.getHeight()) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (Color.alpha(((Activity)localObject).getWindow().getNavigationBarColor()) != 0) {
        j = 1;
      } else {
        j = 0;
      }
      localObject = this.a;
      if ((i != 0) && (j != 0)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      ((NavigationView)localObject).setDrawBottomInsetForeground(bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.navigation.NavigationView.2
 * JD-Core Version:    0.7.0.1
 */