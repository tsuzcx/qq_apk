package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R.dimen;
import com.google.android.material.R.layout;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuPresenter
  implements MenuPresenter
{
  int jdField_a_of_type_Int;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new NavigationMenuPresenter.1(this);
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  MenuBuilder jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder;
  private MenuPresenter.Callback jdField_a_of_type_AndroidxAppcompatViewMenuMenuPresenter$Callback;
  NavigationMenuPresenter.NavigationMenuAdapter jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter$NavigationMenuAdapter;
  private NavigationMenuView jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuView;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  ColorStateList jdField_b_of_type_AndroidContentResColorStateList;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean = true;
  int d;
  int e;
  private int f;
  private int g;
  private int h;
  private int i = -1;
  
  private void a()
  {
    int j;
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == 0) && (this.jdField_c_of_type_Boolean)) {
      j = this.h;
    } else {
      j = 0;
    }
    NavigationMenuView localNavigationMenuView = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuView;
    localNavigationMenuView.setPadding(0, j, 0, localNavigationMenuView.getPaddingBottom());
  }
  
  public View a(@LayoutRes int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    a(localView);
    return localView;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_b_of_type_AndroidContentResColorStateList = paramColorStateList;
    updateMenuView(false);
  }
  
  public void a(@Nullable Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    updateMenuView(false);
  }
  
  public void a(@NonNull View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
    paramView = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuView;
    paramView.setPadding(0, 0, 0, paramView.getPaddingBottom());
  }
  
  public void a(@NonNull MenuItemImpl paramMenuItemImpl)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter$NavigationMenuAdapter.a(paramMenuItemImpl);
  }
  
  public void a(@NonNull WindowInsetsCompat paramWindowInsetsCompat)
  {
    int j = paramWindowInsetsCompat.getSystemWindowInsetTop();
    if (this.h != j)
    {
      this.h = j;
      a();
    }
    NavigationMenuView localNavigationMenuView = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuView;
    localNavigationMenuView.setPadding(0, localNavigationMenuView.getPaddingTop(), 0, paramWindowInsetsCompat.getSystemWindowInsetBottom());
    ViewCompat.dispatchApplyWindowInsets(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramWindowInsetsCompat);
  }
  
  public void a(boolean paramBoolean)
  {
    NavigationMenuPresenter.NavigationMenuAdapter localNavigationMenuAdapter = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter$NavigationMenuAdapter;
    if (localNavigationMenuAdapter != null) {
      localNavigationMenuAdapter.a(paramBoolean);
    }
  }
  
  public void b(@StyleRes int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = true;
    updateMenuView(false);
  }
  
  public void b(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    updateMenuView(false);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean != paramBoolean)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      a();
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    updateMenuView(false);
  }
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public void d(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    updateMenuView(false);
  }
  
  public void e(int paramInt)
  {
    this.g = paramInt;
    updateMenuView(false);
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public void f(@Dimension int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      this.jdField_b_of_type_Boolean = true;
      updateMenuView(false);
    }
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public void g(int paramInt)
  {
    this.i = paramInt;
    NavigationMenuView localNavigationMenuView = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuView;
    if (localNavigationMenuView != null) {
      localNavigationMenuView.setOverScrollMode(paramInt);
    }
  }
  
  public int getId()
  {
    return this.f;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuView == null)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuView = ((NavigationMenuView)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(R.layout.i, paramViewGroup, false));
      paramViewGroup = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuView;
      paramViewGroup.setAccessibilityDelegateCompat(new NavigationMenuPresenter.NavigationMenuViewAccessibilityDelegate(this, paramViewGroup));
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter$NavigationMenuAdapter == null) {
        this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter$NavigationMenuAdapter = new NavigationMenuPresenter.NavigationMenuAdapter(this);
      }
      int j = this.i;
      if (j != -1) {
        this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuView.setOverScrollMode(j);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(R.layout.f, this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuView, false));
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuView.setAdapter(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter$NavigationMenuAdapter);
    }
    return this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuView;
  }
  
  public void initForMenu(@NonNull Context paramContext, @NonNull MenuBuilder paramMenuBuilder)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder = paramMenuBuilder;
    this.e = paramContext.getResources().getDimensionPixelOffset(R.dimen.n);
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    MenuPresenter.Callback localCallback = this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuPresenter$Callback;
    if (localCallback != null) {
      localCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      Object localObject = paramParcelable.getSparseParcelableArray("android:menu:list");
      if (localObject != null) {
        this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuView.restoreHierarchyState((SparseArray)localObject);
      }
      localObject = paramParcelable.getBundle("android:menu:adapter");
      if (localObject != null) {
        this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter$NavigationMenuAdapter.a((Bundle)localObject);
      }
      paramParcelable = paramParcelable.getSparseParcelableArray("android:menu:header");
      if (paramParcelable != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.restoreHierarchyState(paramParcelable);
      }
    }
  }
  
  @NonNull
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuView != null)
    {
      localObject = new SparseArray();
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuView.saveHierarchyState((SparseArray)localObject);
      localBundle.putSparseParcelableArray("android:menu:list", (SparseArray)localObject);
    }
    Object localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter$NavigationMenuAdapter;
    if (localObject != null) {
      localBundle.putBundle("android:menu:adapter", ((NavigationMenuPresenter.NavigationMenuAdapter)localObject).a());
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      localObject = new SparseArray();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.saveHierarchyState((SparseArray)localObject);
      localBundle.putSparseParcelableArray("android:menu:header", (SparseArray)localObject);
    }
    return localBundle;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    return false;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback)
  {
    this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuPresenter$Callback = paramCallback;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    NavigationMenuPresenter.NavigationMenuAdapter localNavigationMenuAdapter = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter$NavigationMenuAdapter;
    if (localNavigationMenuAdapter != null) {
      localNavigationMenuAdapter.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.NavigationMenuPresenter
 * JD-Core Version:    0.7.0.1
 */