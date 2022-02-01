package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;

class AppCompatSpinner$1
  extends ForwardingListener
{
  AppCompatSpinner$1(AppCompatSpinner paramAppCompatSpinner, View paramView, AppCompatSpinner.DropdownPopup paramDropdownPopup)
  {
    super(paramView);
  }
  
  public ShowableListMenu getPopup()
  {
    return this.val$popup;
  }
  
  @SuppressLint({"SyntheticAccessor"})
  public boolean onForwardingStarted()
  {
    if (!this.this$0.getInternalPopup().isShowing()) {
      this.this$0.showPopup();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatSpinner.1
 * JD-Core Version:    0.7.0.1
 */