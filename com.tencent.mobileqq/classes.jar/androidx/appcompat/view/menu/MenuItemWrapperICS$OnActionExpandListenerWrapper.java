package androidx.appcompat.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

class MenuItemWrapperICS$OnActionExpandListenerWrapper
  implements MenuItem.OnActionExpandListener
{
  private final MenuItem.OnActionExpandListener mObject;
  
  MenuItemWrapperICS$OnActionExpandListenerWrapper(MenuItemWrapperICS paramMenuItemWrapperICS, MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    this.mObject = paramOnActionExpandListener;
  }
  
  public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
  {
    return this.mObject.onMenuItemActionCollapse(this.this$0.getMenuItemWrapper(paramMenuItem));
  }
  
  public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
  {
    return this.mObject.onMenuItemActionExpand(this.this$0.getMenuItemWrapper(paramMenuItem));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.MenuItemWrapperICS.OnActionExpandListenerWrapper
 * JD-Core Version:    0.7.0.1
 */