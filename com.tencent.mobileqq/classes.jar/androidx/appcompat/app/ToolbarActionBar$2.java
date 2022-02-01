package androidx.appcompat.app;

import android.view.MenuItem;
import android.view.Window.Callback;
import androidx.appcompat.widget.Toolbar.OnMenuItemClickListener;

class ToolbarActionBar$2
  implements Toolbar.OnMenuItemClickListener
{
  ToolbarActionBar$2(ToolbarActionBar paramToolbarActionBar) {}
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    return this.this$0.mWindowCallback.onMenuItemSelected(0, paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.ToolbarActionBar.2
 * JD-Core Version:    0.7.0.1
 */