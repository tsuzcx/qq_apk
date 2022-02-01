package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;

class ActionMenuPresenter$OverflowPopup
  extends MenuPopupHelper
{
  public ActionMenuPresenter$OverflowPopup(ActionMenuPresenter paramActionMenuPresenter, Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean)
  {
    super(paramContext, paramMenuBuilder, paramView, paramBoolean, 2131034147);
    setGravity(8388613);
    setPresenterCallback(paramActionMenuPresenter.mPopupPresenterCallback);
  }
  
  protected void onDismiss()
  {
    if (ActionMenuPresenter.access$000(this.this$0) != null) {
      ActionMenuPresenter.access$100(this.this$0).close();
    }
    this.this$0.mOverflowPopup = null;
    super.onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ActionMenuPresenter.OverflowPopup
 * JD-Core Version:    0.7.0.1
 */