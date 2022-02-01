package androidx.appcompat.app;

import android.view.Window.Callback;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter.Callback;

final class AppCompatDelegateImpl$PanelMenuPresenterCallback
  implements MenuPresenter.Callback
{
  AppCompatDelegateImpl$PanelMenuPresenterCallback(AppCompatDelegateImpl paramAppCompatDelegateImpl) {}
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    MenuBuilder localMenuBuilder = paramMenuBuilder.getRootMenu();
    int i;
    if (localMenuBuilder != paramMenuBuilder) {
      i = 1;
    } else {
      i = 0;
    }
    AppCompatDelegateImpl localAppCompatDelegateImpl = this.this$0;
    if (i != 0) {
      paramMenuBuilder = localMenuBuilder;
    }
    paramMenuBuilder = localAppCompatDelegateImpl.findMenuPanel(paramMenuBuilder);
    if (paramMenuBuilder != null)
    {
      if (i != 0)
      {
        this.this$0.callOnPanelClosed(paramMenuBuilder.featureId, paramMenuBuilder, localMenuBuilder);
        this.this$0.closePanel(paramMenuBuilder, true);
        return;
      }
      this.this$0.closePanel(paramMenuBuilder, paramBoolean);
    }
  }
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    if ((paramMenuBuilder == null) && (this.this$0.mHasActionBar))
    {
      Window.Callback localCallback = this.this$0.getWindowCallback();
      if ((localCallback != null) && (!this.this$0.mIsDestroyed)) {
        localCallback.onMenuOpened(108, paramMenuBuilder);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.PanelMenuPresenterCallback
 * JD-Core Version:    0.7.0.1
 */