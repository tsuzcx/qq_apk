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
  private int jdField_a_of_type_Int;
  private MenuBuilder jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder;
  private BottomNavigationMenuView jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView;
  private boolean jdField_a_of_type_Boolean = false;
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(BottomNavigationMenuView paramBottomNavigationMenuView)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView = paramBottomNavigationMenuView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
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
    return this.jdField_a_of_type_Int;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder = paramMenuBuilder;
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.initialize(this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder);
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof BottomNavigationPresenter.SavedState))
    {
      BottomNavigationMenuView localBottomNavigationMenuView = this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView;
      paramParcelable = (BottomNavigationPresenter.SavedState)paramParcelable;
      localBottomNavigationMenuView.a(paramParcelable.jdField_a_of_type_Int);
      paramParcelable = BadgeUtils.a(this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.getContext(), paramParcelable.jdField_a_of_type_ComGoogleAndroidMaterialInternalParcelableSparseArray);
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.a(paramParcelable);
    }
  }
  
  @NonNull
  public Parcelable onSaveInstanceState()
  {
    BottomNavigationPresenter.SavedState localSavedState = new BottomNavigationPresenter.SavedState();
    localSavedState.jdField_a_of_type_Int = this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.b();
    localSavedState.jdField_a_of_type_ComGoogleAndroidMaterialInternalParcelableSparseArray = BadgeUtils.a(this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.a());
    return localSavedState;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    return false;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback) {}
  
  public void updateMenuView(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.a();
      return;
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomnavigationBottomNavigationMenuView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationPresenter
 * JD-Core Version:    0.7.0.1
 */