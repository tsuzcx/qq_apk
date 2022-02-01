package androidx.appcompat.app;

import android.view.Window.Callback;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter.Callback;

final class AppCompatDelegateImpl$ActionMenuPresenterCallback
  implements MenuPresenter.Callback
{
  AppCompatDelegateImpl$ActionMenuPresenterCallback(AppCompatDelegateImpl paramAppCompatDelegateImpl) {}
  
  public void onCloseMenu(@NonNull MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    this.this$0.checkCloseActionMenu(paramMenuBuilder);
  }
  
  public boolean onOpenSubMenu(@NonNull MenuBuilder paramMenuBuilder)
  {
    Window.Callback localCallback = this.this$0.getWindowCallback();
    if (localCallback != null) {
      localCallback.onMenuOpened(108, paramMenuBuilder);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.ActionMenuPresenterCallback
 * JD-Core Version:    0.7.0.1
 */