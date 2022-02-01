package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder.Callback;

class ActionMenuView$MenuBuilderCallback
  implements MenuBuilder.Callback
{
  ActionMenuView$MenuBuilderCallback(ActionMenuView paramActionMenuView) {}
  
  public boolean onMenuItemSelected(@NonNull MenuBuilder paramMenuBuilder, @NonNull MenuItem paramMenuItem)
  {
    return (this.this$0.mOnMenuItemClickListener != null) && (this.this$0.mOnMenuItemClickListener.onMenuItemClick(paramMenuItem));
  }
  
  public void onMenuModeChange(@NonNull MenuBuilder paramMenuBuilder)
  {
    if (this.this$0.mMenuBuilderCallback != null) {
      this.this$0.mMenuBuilderCallback.onMenuModeChange(paramMenuBuilder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ActionMenuView.MenuBuilderCallback
 * JD-Core Version:    0.7.0.1
 */