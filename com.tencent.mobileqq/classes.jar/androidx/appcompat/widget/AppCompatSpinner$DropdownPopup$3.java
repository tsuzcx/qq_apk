package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow.OnDismissListener;

class AppCompatSpinner$DropdownPopup$3
  implements PopupWindow.OnDismissListener
{
  AppCompatSpinner$DropdownPopup$3(AppCompatSpinner.DropdownPopup paramDropdownPopup, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener) {}
  
  public void onDismiss()
  {
    ViewTreeObserver localViewTreeObserver = this.this$1.this$0.getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.removeGlobalOnLayoutListener(this.val$layoutListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.3
 * JD-Core Version:    0.7.0.1
 */