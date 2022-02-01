package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;

class ActionMenuPresenter$OpenOverflowRunnable
  implements Runnable
{
  private ActionMenuPresenter.OverflowPopup mPopup;
  
  public ActionMenuPresenter$OpenOverflowRunnable(ActionMenuPresenter paramActionMenuPresenter, ActionMenuPresenter.OverflowPopup paramOverflowPopup)
  {
    this.mPopup = paramOverflowPopup;
  }
  
  public void run()
  {
    if (ActionMenuPresenter.access$400(this.this$0) != null) {
      ActionMenuPresenter.access$500(this.this$0).changeMenuMode();
    }
    View localView = (View)ActionMenuPresenter.access$600(this.this$0);
    if ((localView != null) && (localView.getWindowToken() != null) && (this.mPopup.tryShow())) {
      this.this$0.mOverflowPopup = this.mPopup;
    }
    this.this$0.mPostedOpenRunnable = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ActionMenuPresenter.OpenOverflowRunnable
 * JD-Core Version:    0.7.0.1
 */