package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.appcompat.widget.MenuPopupWindow;

class StandardMenuPopup$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  StandardMenuPopup$1(StandardMenuPopup paramStandardMenuPopup) {}
  
  public void onGlobalLayout()
  {
    if ((this.this$0.isShowing()) && (!this.this$0.mPopup.isModal()))
    {
      View localView = this.this$0.mShownAnchorView;
      if ((localView != null) && (localView.isShown()))
      {
        this.this$0.mPopup.show();
        return;
      }
      this.this$0.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.StandardMenuPopup.1
 * JD-Core Version:    0.7.0.1
 */