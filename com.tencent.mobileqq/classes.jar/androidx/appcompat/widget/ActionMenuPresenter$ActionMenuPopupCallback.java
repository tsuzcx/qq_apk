package androidx.appcompat.widget;

import androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback;
import androidx.appcompat.view.menu.ShowableListMenu;

class ActionMenuPresenter$ActionMenuPopupCallback
  extends ActionMenuItemView.PopupCallback
{
  ActionMenuPresenter$ActionMenuPopupCallback(ActionMenuPresenter paramActionMenuPresenter) {}
  
  public ShowableListMenu getPopup()
  {
    if (this.this$0.mActionButtonPopup != null) {
      return this.this$0.mActionButtonPopup.getPopup();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ActionMenuPresenter.ActionMenuPopupCallback
 * JD-Core Version:    0.7.0.1
 */