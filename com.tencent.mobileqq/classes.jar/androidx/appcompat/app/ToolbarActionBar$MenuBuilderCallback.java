package androidx.appcompat.app;

import android.view.MenuItem;
import android.view.Window.Callback;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder.Callback;
import androidx.appcompat.widget.DecorToolbar;

final class ToolbarActionBar$MenuBuilderCallback
  implements MenuBuilder.Callback
{
  ToolbarActionBar$MenuBuilderCallback(ToolbarActionBar paramToolbarActionBar) {}
  
  public boolean onMenuItemSelected(@NonNull MenuBuilder paramMenuBuilder, @NonNull MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onMenuModeChange(@NonNull MenuBuilder paramMenuBuilder)
  {
    if (this.this$0.mWindowCallback != null)
    {
      if (this.this$0.mDecorToolbar.isOverflowMenuShowing())
      {
        this.this$0.mWindowCallback.onPanelClosed(108, paramMenuBuilder);
        return;
      }
      if (this.this$0.mWindowCallback.onPreparePanel(0, null, paramMenuBuilder)) {
        this.this$0.mWindowCallback.onMenuOpened(108, paramMenuBuilder);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.ToolbarActionBar.MenuBuilderCallback
 * JD-Core Version:    0.7.0.1
 */