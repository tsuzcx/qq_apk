package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;

class ActionMenuPresenter$ActionButtonSubmenu
  extends MenuPopupHelper
{
  public ActionMenuPresenter$ActionButtonSubmenu(ActionMenuPresenter paramActionMenuPresenter, Context paramContext, SubMenuBuilder paramSubMenuBuilder, View paramView)
  {
    super(paramContext, paramSubMenuBuilder, paramView, false, 2131034147);
    if (!((MenuItemImpl)paramSubMenuBuilder.getItem()).isActionButton())
    {
      if (paramActionMenuPresenter.mOverflowButton == null) {
        paramContext = (View)ActionMenuPresenter.access$200(paramActionMenuPresenter);
      } else {
        paramContext = paramActionMenuPresenter.mOverflowButton;
      }
      setAnchorView(paramContext);
    }
    setPresenterCallback(paramActionMenuPresenter.mPopupPresenterCallback);
  }
  
  protected void onDismiss()
  {
    ActionMenuPresenter localActionMenuPresenter = this.this$0;
    localActionMenuPresenter.mActionButtonPopup = null;
    localActionMenuPresenter.mOpenSubMenuId = 0;
    super.onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ActionMenuPresenter.ActionButtonSubmenu
 * JD-Core Version:    0.7.0.1
 */