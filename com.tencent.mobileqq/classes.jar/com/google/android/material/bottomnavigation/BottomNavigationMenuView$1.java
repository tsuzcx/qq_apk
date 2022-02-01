package com.google.android.material.bottomnavigation;

import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.view.menu.MenuBuilder;

class BottomNavigationMenuView$1
  implements View.OnClickListener
{
  BottomNavigationMenuView$1(BottomNavigationMenuView paramBottomNavigationMenuView) {}
  
  public void onClick(View paramView)
  {
    paramView = ((BottomNavigationItemView)paramView).getItemData();
    if (!BottomNavigationMenuView.a(this.a).performItemAction(paramView, BottomNavigationMenuView.a(this.a), 0)) {
      paramView.setChecked(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationMenuView.1
 * JD-Core Version:    0.7.0.1
 */