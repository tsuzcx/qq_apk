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
  LinearLayout a;
  MenuBuilder b;
  NavigationMenuPresenter.NavigationMenuAdapter c;
  LayoutInflater d;
  int e;
  boolean f;
  ColorStateList g;
  ColorStateList h;
  Drawable i;
  int j;
  int k;
  int l;
  boolean m;
  boolean n = true;
  int o;
  final View.OnClickListener p = new NavigationMenuPresenter.1(this);
  private NavigationMenuView q;
  private MenuPresenter.Callback r;
  private int s;
  private int t;
  private int u;
  private int v = -1;
  
  private void i()
  {
    int i1;
    if ((this.a.getChildCount() == 0) && (this.n)) {
      i1 = this.u;
    } else {
      i1 = 0;
    }
    NavigationMenuView localNavigationMenuView = this.q;
    localNavigationMenuView.setPadding(0, i1, 0, localNavigationMenuView.getPaddingBottom());
  }
  
  @Nullable
  public MenuItemImpl a()
  {
    return this.c.b();
  }
  
  public void a(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void a(@Nullable ColorStateList paramColorStateList)
  {
    this.h = paramColorStateList;
    updateMenuView(false);
  }
  
  public void a(@Nullable Drawable paramDrawable)
  {
    this.i = paramDrawable;
    updateMenuView(false);
  }
  
  public void a(@NonNull View paramView)
  {
    this.a.addView(paramView);
    paramView = this.q;
    paramView.setPadding(0, 0, 0, paramView.getPaddingBottom());
  }
  
  public void a(@NonNull MenuItemImpl paramMenuItemImpl)
  {
    this.c.a(paramMenuItemImpl);
  }
  
  public void a(@NonNull WindowInsetsCompat paramWindowInsetsCompat)
  {
    int i1 = paramWindowInsetsCompat.getSystemWindowInsetTop();
    if (this.u != i1)
    {
      this.u = i1;
      i();
    }
    NavigationMenuView localNavigationMenuView = this.q;
    localNavigationMenuView.setPadding(0, localNavigationMenuView.getPaddingTop(), 0, paramWindowInsetsCompat.getSystemWindowInsetBottom());
    ViewCompat.dispatchApplyWindowInsets(this.a, paramWindowInsetsCompat);
  }
  
  public void a(boolean paramBoolean)
  {
    NavigationMenuPresenter.NavigationMenuAdapter localNavigationMenuAdapter = this.c;
    if (localNavigationMenuAdapter != null) {
      localNavigationMenuAdapter.a(paramBoolean);
    }
  }
  
  public int b()
  {
    return this.a.getChildCount();
  }
  
  public View b(@LayoutRes int paramInt)
  {
    View localView = this.d.inflate(paramInt, this.a, false);
    a(localView);
    return localView;
  }
  
  public void b(@Nullable ColorStateList paramColorStateList)
  {
    this.g = paramColorStateList;
    updateMenuView(false);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.n != paramBoolean)
    {
      this.n = paramBoolean;
      i();
    }
  }
  
  @Nullable
  public ColorStateList c()
  {
    return this.h;
  }
  
  public void c(@StyleRes int paramInt)
  {
    this.e = paramInt;
    this.f = true;
    updateMenuView(false);
  }
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  @Nullable
  public ColorStateList d()
  {
    return this.g;
  }
  
  public void d(int paramInt)
  {
    this.j = paramInt;
    updateMenuView(false);
  }
  
  @Nullable
  public Drawable e()
  {
    return this.i;
  }
  
  public void e(int paramInt)
  {
    this.k = paramInt;
    updateMenuView(false);
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public int f()
  {
    return this.j;
  }
  
  public void f(int paramInt)
  {
    this.t = paramInt;
    updateMenuView(false);
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public int g()
  {
    return this.k;
  }
  
  public void g(@Dimension int paramInt)
  {
    if (this.l != paramInt)
    {
      this.l = paramInt;
      this.m = true;
      updateMenuView(false);
    }
  }
  
  public int getId()
  {
    return this.s;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    if (this.q == null)
    {
      this.q = ((NavigationMenuView)this.d.inflate(R.layout.i, paramViewGroup, false));
      paramViewGroup = this.q;
      paramViewGroup.setAccessibilityDelegateCompat(new NavigationMenuPresenter.NavigationMenuViewAccessibilityDelegate(this, paramViewGroup));
      if (this.c == null) {
        this.c = new NavigationMenuPresenter.NavigationMenuAdapter(this);
      }
      int i1 = this.v;
      if (i1 != -1) {
        this.q.setOverScrollMode(i1);
      }
      this.a = ((LinearLayout)this.d.inflate(R.layout.f, this.q, false));
      this.q.setAdapter(this.c);
    }
    return this.q;
  }
  
  public int h()
  {
    return this.t;
  }
  
  public void h(int paramInt)
  {
    this.v = paramInt;
    NavigationMenuView localNavigationMenuView = this.q;
    if (localNavigationMenuView != null) {
      localNavigationMenuView.setOverScrollMode(paramInt);
    }
  }
  
  public void initForMenu(@NonNull Context paramContext, @NonNull MenuBuilder paramMenuBuilder)
  {
    this.d = LayoutInflater.from(paramContext);
    this.b = paramMenuBuilder;
    this.o = paramContext.getResources().getDimensionPixelOffset(R.dimen.n);
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    MenuPresenter.Callback localCallback = this.r;
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
        this.q.restoreHierarchyState((SparseArray)localObject);
      }
      localObject = paramParcelable.getBundle("android:menu:adapter");
      if (localObject != null) {
        this.c.a((Bundle)localObject);
      }
      paramParcelable = paramParcelable.getSparseParcelableArray("android:menu:header");
      if (paramParcelable != null) {
        this.a.restoreHierarchyState(paramParcelable);
      }
    }
  }
  
  @NonNull
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    if (this.q != null)
    {
      localObject = new SparseArray();
      this.q.saveHierarchyState((SparseArray)localObject);
      localBundle.putSparseParcelableArray("android:menu:list", (SparseArray)localObject);
    }
    Object localObject = this.c;
    if (localObject != null) {
      localBundle.putBundle("android:menu:adapter", ((NavigationMenuPresenter.NavigationMenuAdapter)localObject).c());
    }
    if (this.a != null)
    {
      localObject = new SparseArray();
      this.a.saveHierarchyState((SparseArray)localObject);
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
    this.r = paramCallback;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    NavigationMenuPresenter.NavigationMenuAdapter localNavigationMenuAdapter = this.c;
    if (localNavigationMenuAdapter != null) {
      localNavigationMenuAdapter.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.NavigationMenuPresenter
 * JD-Core Version:    0.7.0.1
 */