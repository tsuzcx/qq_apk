package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.appcompat.view.menu.SubMenuBuilder;

class ActionMenuPresenter$PopupPresenterCallback
  implements MenuPresenter.Callback
{
  ActionMenuPresenter$PopupPresenterCallback(ActionMenuPresenter paramActionMenuPresenter) {}
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if ((paramMenuBuilder instanceof SubMenuBuilder)) {
      paramMenuBuilder.getRootMenu().close(false);
    }
    MenuPresenter.Callback localCallback = this.this$0.getCallback();
    if (localCallback != null) {
      localCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    boolean bool = false;
    if (paramMenuBuilder == null) {
      return false;
    }
    this.this$0.mOpenSubMenuId = ((SubMenuBuilder)paramMenuBuilder).getItem().getItemId();
    MenuPresenter.Callback localCallback = this.this$0.getCallback();
    if (localCallback != null) {
      bool = localCallback.onOpenSubMenu(paramMenuBuilder);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ActionMenuPresenter.PopupPresenterCallback
 * JD-Core Version:    0.7.0.1
 */