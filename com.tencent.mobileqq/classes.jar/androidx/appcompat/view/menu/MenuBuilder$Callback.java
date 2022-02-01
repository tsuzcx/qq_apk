package androidx.appcompat.view.menu;

import android.view.MenuItem;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract interface MenuBuilder$Callback
{
  public abstract boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem);
  
  public abstract void onMenuModeChange(MenuBuilder paramMenuBuilder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.MenuBuilder.Callback
 * JD-Core Version:    0.7.0.1
 */