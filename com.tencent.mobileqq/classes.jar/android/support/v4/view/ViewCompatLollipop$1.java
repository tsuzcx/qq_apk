package android.support.v4.view;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

final class ViewCompatLollipop$1
  implements View.OnApplyWindowInsetsListener
{
  ViewCompatLollipop$1(OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener) {}
  
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    paramWindowInsets = new WindowInsetsCompatApi21(paramWindowInsets);
    return ((WindowInsetsCompatApi21)this.val$listener.onApplyWindowInsets(paramView, paramWindowInsets)).unwrap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompatLollipop.1
 * JD-Core Version:    0.7.0.1
 */