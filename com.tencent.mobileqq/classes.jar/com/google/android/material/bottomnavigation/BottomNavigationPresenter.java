package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.badge.BadgeUtils;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationPresenter
  implements MenuPresenter
{
  private MenuBuilder a;
  private BottomNavigationMenuView b;
  private boolean c = false;
  private int d;
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(BottomNavigationMenuView paramBottomNavigationMenuView)
  {
    this.b = paramBottomNavigationMenuView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public int getId()
  {
    return this.d;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    return this.b;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    this.a = paramMenuBuilder;
    this.b.initialize(this.a);
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof BottomNavigationPresenter.SavedState))
    {
      BottomNavigationMenuView localBottomNavigationMenuView = this.b;
      paramParcelable = (BottomNavigationPresenter.SavedState)paramParcelable;
      localBottomNavigationMenuView.b(paramParcelable.a);
      paramParcelable = BadgeUtils.a(this.b.getContext(), paramParcelable.b);
      this.b.setBadgeDrawables(paramParcelable);
    }
  }
  
  @NonNull
  public Parcelable onSaveInstanceState()
  {
    BottomNavigationPresenter.SavedState localSavedState = new BottomNavigationPresenter.SavedState();
    localSavedState.a = this.b.getSelectedItemId();
    localSavedState.b = BadgeUtils.a(this.b.getBadgeDrawables());
    return localSavedState;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    return false;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback) {}
  
  public void updateMenuView(boolean paramBoolean)
  {
    if (this.c) {
      return;
    }
    if (paramBoolean)
    {
      this.b.b();
      return;
    }
    this.b.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationPresenter
 * JD-Core Version:    0.7.0.1
 */