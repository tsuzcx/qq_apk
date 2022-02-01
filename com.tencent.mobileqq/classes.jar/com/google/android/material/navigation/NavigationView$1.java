package com.google.android.material.navigation;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder.Callback;

class NavigationView$1
  implements MenuBuilder.Callback
{
  NavigationView$1(NavigationView paramNavigationView) {}
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return (this.a.a != null) && (this.a.a.a(paramMenuItem));
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.navigation.NavigationView.1
 * JD-Core Version:    0.7.0.1
 */