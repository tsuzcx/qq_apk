package com.google.android.material.bottomnavigation;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder.Callback;

class BottomNavigationView$1
  implements MenuBuilder.Callback
{
  BottomNavigationView$1(BottomNavigationView paramBottomNavigationView) {}
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, @NonNull MenuItem paramMenuItem)
  {
    if ((BottomNavigationView.a(this.a) != null) && (paramMenuItem.getItemId() == this.a.getSelectedItemId()))
    {
      BottomNavigationView.a(this.a).a(paramMenuItem);
      return true;
    }
    return (BottomNavigationView.b(this.a) != null) && (!BottomNavigationView.b(this.a).a(paramMenuItem));
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationView.1
 * JD-Core Version:    0.7.0.1
 */