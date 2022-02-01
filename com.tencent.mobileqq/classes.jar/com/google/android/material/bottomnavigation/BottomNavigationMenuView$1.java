package com.google.android.material.bottomnavigation;

import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BottomNavigationMenuView$1
  implements View.OnClickListener
{
  BottomNavigationMenuView$1(BottomNavigationMenuView paramBottomNavigationMenuView) {}
  
  public void onClick(View paramView)
  {
    MenuItemImpl localMenuItemImpl = ((BottomNavigationItemView)paramView).getItemData();
    if (!BottomNavigationMenuView.b(this.a).performItemAction(localMenuItemImpl, BottomNavigationMenuView.a(this.a), 0)) {
      localMenuItemImpl.setChecked(true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationMenuView.1
 * JD-Core Version:    0.7.0.1
 */