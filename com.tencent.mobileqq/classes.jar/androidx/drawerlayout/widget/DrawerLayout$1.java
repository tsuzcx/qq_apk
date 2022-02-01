package androidx.drawerlayout.widget;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

class DrawerLayout$1
  implements View.OnApplyWindowInsetsListener
{
  DrawerLayout$1(DrawerLayout paramDrawerLayout) {}
  
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    paramView = (DrawerLayout)paramView;
    boolean bool;
    if (paramWindowInsets.getSystemWindowInsetTop() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramView.setChildInsets(paramWindowInsets, bool);
    return paramWindowInsets.consumeSystemWindowInsets();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.drawerlayout.widget.DrawerLayout.1
 * JD-Core Version:    0.7.0.1
 */