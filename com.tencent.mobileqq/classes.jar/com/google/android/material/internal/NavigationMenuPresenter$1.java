package com.google.android.material.internal;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

class NavigationMenuPresenter$1
  implements View.OnClickListener
{
  NavigationMenuPresenter$1(NavigationMenuPresenter paramNavigationMenuPresenter) {}
  
  public void onClick(View paramView)
  {
    paramView = (NavigationMenuItemView)paramView;
    NavigationMenuPresenter localNavigationMenuPresenter = this.a;
    int i = 1;
    localNavigationMenuPresenter.a(true);
    paramView = paramView.getItemData();
    boolean bool = this.a.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.performItemAction(paramView, this.a, 0);
    if ((paramView != null) && (paramView.isCheckable()) && (bool)) {
      this.a.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter$NavigationMenuAdapter.a(paramView);
    } else {
      i = 0;
    }
    this.a.a(false);
    if (i != 0) {
      this.a.updateMenuView(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.NavigationMenuPresenter.1
 * JD-Core Version:    0.7.0.1
 */