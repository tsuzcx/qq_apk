package androidx.appcompat.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MenuItemWrapperICS$OnMenuItemClickListenerWrapper
  implements MenuItem.OnMenuItemClickListener
{
  private final MenuItem.OnMenuItemClickListener mObject;
  
  MenuItemWrapperICS$OnMenuItemClickListenerWrapper(MenuItemWrapperICS paramMenuItemWrapperICS, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mObject = paramOnMenuItemClickListener;
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    return this.mObject.onMenuItemClick(this.this$0.getMenuItemWrapper(paramMenuItem));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.MenuItemWrapperICS.OnMenuItemClickListenerWrapper
 * JD-Core Version:    0.7.0.1
 */