package androidx.appcompat.widget;

import android.widget.PopupWindow;
import androidx.core.view.ViewCompat;

class ListPopupWindow$ResizePopupRunnable
  implements Runnable
{
  ListPopupWindow$ResizePopupRunnable(ListPopupWindow paramListPopupWindow) {}
  
  public void run()
  {
    if ((this.this$0.mDropDownList != null) && (ViewCompat.isAttachedToWindow(this.this$0.mDropDownList)) && (this.this$0.mDropDownList.getCount() > this.this$0.mDropDownList.getChildCount()) && (this.this$0.mDropDownList.getChildCount() <= this.this$0.mListItemExpandMaximum))
    {
      this.this$0.mPopup.setInputMethodMode(2);
      this.this$0.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ListPopupWindow.ResizePopupRunnable
 * JD-Core Version:    0.7.0.1
 */