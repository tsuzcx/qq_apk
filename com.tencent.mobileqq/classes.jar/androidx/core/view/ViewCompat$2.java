package androidx.core.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnUnhandledKeyEventListener;

class ViewCompat$2
  implements View.OnUnhandledKeyEventListener
{
  ViewCompat$2(ViewCompat.OnUnhandledKeyEventListenerCompat paramOnUnhandledKeyEventListenerCompat) {}
  
  public boolean onUnhandledKeyEvent(View paramView, KeyEvent paramKeyEvent)
  {
    return this.val$listener.onUnhandledKeyEvent(paramView, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.ViewCompat.2
 * JD-Core Version:    0.7.0.1
 */