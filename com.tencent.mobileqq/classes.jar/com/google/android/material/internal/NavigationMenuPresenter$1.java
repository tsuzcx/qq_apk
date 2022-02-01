package com.google.android.material.internal;

import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NavigationMenuPresenter$1
  implements View.OnClickListener
{
  NavigationMenuPresenter$1(NavigationMenuPresenter paramNavigationMenuPresenter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (NavigationMenuItemView)paramView;
    NavigationMenuPresenter localNavigationMenuPresenter = this.a;
    int i = 1;
    localNavigationMenuPresenter.a(true);
    localObject = ((NavigationMenuItemView)localObject).getItemData();
    boolean bool = this.a.b.performItemAction((MenuItem)localObject, this.a, 0);
    if ((localObject != null) && (((MenuItemImpl)localObject).isCheckable()) && (bool)) {
      this.a.c.a((MenuItemImpl)localObject);
    } else {
      i = 0;
    }
    this.a.a(false);
    if (i != 0) {
      this.a.updateMenuView(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.NavigationMenuPresenter.1
 * JD-Core Version:    0.7.0.1
 */