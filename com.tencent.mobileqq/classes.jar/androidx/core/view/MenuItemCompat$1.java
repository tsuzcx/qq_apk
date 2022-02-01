package androidx.core.view;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

class MenuItemCompat$1
  implements MenuItem.OnActionExpandListener
{
  MenuItemCompat$1(MenuItemCompat.OnActionExpandListener paramOnActionExpandListener) {}
  
  public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    return this.val$listener.onMenuItemActionCollapse(paramMenuItem);
  }
  
  public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    return this.val$listener.onMenuItemActionExpand(paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.MenuItemCompat.1
 * JD-Core Version:    0.7.0.1
 */