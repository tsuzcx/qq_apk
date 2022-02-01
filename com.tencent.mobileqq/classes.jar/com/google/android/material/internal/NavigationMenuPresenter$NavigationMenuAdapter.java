package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;

class NavigationMenuPresenter$NavigationMenuAdapter
  extends RecyclerView.Adapter<NavigationMenuPresenter.ViewHolder>
{
  private MenuItemImpl jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl;
  private final ArrayList<NavigationMenuPresenter.NavigationMenuItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  NavigationMenuPresenter$NavigationMenuAdapter(NavigationMenuPresenter paramNavigationMenuPresenter)
  {
    b();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      ((NavigationMenuPresenter.NavigationMenuTextItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_Boolean = true;
      paramInt1 += 1;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(new NavigationMenuPresenter.NavigationMenuHeaderItem());
    int i2 = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.getVisibleItems().size();
    int m = 0;
    int n = -1;
    boolean bool2 = false;
    int k;
    for (int i = 0; m < i2; i = k)
    {
      Object localObject = (MenuItemImpl)this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_a_of_type_AndroidxAppcompatViewMenuMenuBuilder.getVisibleItems().get(m);
      if (((MenuItemImpl)localObject).isChecked()) {
        a((MenuItemImpl)localObject);
      }
      if (((MenuItemImpl)localObject).isCheckable()) {
        ((MenuItemImpl)localObject).setExclusiveCheckable(false);
      }
      int i1;
      boolean bool1;
      int j;
      if (((MenuItemImpl)localObject).hasSubMenu())
      {
        SubMenu localSubMenu = ((MenuItemImpl)localObject).getSubMenu();
        i1 = n;
        bool1 = bool2;
        k = i;
        if (localSubMenu.hasVisibleItems())
        {
          if (m != 0) {
            this.jdField_a_of_type_JavaUtilArrayList.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.e, 0));
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(new NavigationMenuPresenter.NavigationMenuTextItem((MenuItemImpl)localObject));
          int i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
          int i4 = localSubMenu.size();
          i1 = 0;
          for (j = 0; i1 < i4; j = k)
          {
            MenuItemImpl localMenuItemImpl = (MenuItemImpl)localSubMenu.getItem(i1);
            k = j;
            if (localMenuItemImpl.isVisible())
            {
              k = j;
              if (j == 0)
              {
                k = j;
                if (localMenuItemImpl.getIcon() != null) {
                  k = 1;
                }
              }
              if (localMenuItemImpl.isCheckable()) {
                localMenuItemImpl.setExclusiveCheckable(false);
              }
              if (((MenuItemImpl)localObject).isChecked()) {
                a((MenuItemImpl)localObject);
              }
              this.jdField_a_of_type_JavaUtilArrayList.add(new NavigationMenuPresenter.NavigationMenuTextItem(localMenuItemImpl));
            }
            i1 += 1;
          }
          i1 = n;
          bool1 = bool2;
          k = i;
          if (j != 0)
          {
            a(i3, this.jdField_a_of_type_JavaUtilArrayList.size());
            i1 = n;
            bool1 = bool2;
            k = i;
          }
        }
      }
      else
      {
        i1 = ((MenuItemImpl)localObject).getGroupId();
        if (i1 != n)
        {
          i = this.jdField_a_of_type_JavaUtilArrayList.size();
          if (((MenuItemImpl)localObject).getIcon() != null) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          j = i;
          if (m != 0)
          {
            j = i + 1;
            this.jdField_a_of_type_JavaUtilArrayList.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.e, this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.e));
          }
        }
        else
        {
          bool1 = bool2;
          j = i;
          if (!bool2)
          {
            bool1 = bool2;
            j = i;
            if (((MenuItemImpl)localObject).getIcon() != null)
            {
              a(i, this.jdField_a_of_type_JavaUtilArrayList.size());
              bool1 = true;
              j = i;
            }
          }
        }
        localObject = new NavigationMenuPresenter.NavigationMenuTextItem((MenuItemImpl)localObject);
        ((NavigationMenuPresenter.NavigationMenuTextItem)localObject).jdField_a_of_type_Boolean = bool1;
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        k = j;
      }
      m += 1;
      n = i1;
      bool2 = bool1;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  int a()
  {
    int i = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int j = 0;
    if (i == 0) {
      i = 0;
    }
    int k;
    for (i = 1; j < this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter$NavigationMenuAdapter.getItemCount(); i = k)
    {
      k = i;
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter$NavigationMenuAdapter.getItemViewType(j) == 0) {
        k = i + 1;
      }
      j += 1;
    }
    return i;
  }
  
  @NonNull
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    Object localObject = this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl;
    if (localObject != null) {
      localBundle.putInt("android:menu:checked", ((MenuItemImpl)localObject).getItemId());
    }
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    while (i < j)
    {
      localObject = (NavigationMenuPresenter.NavigationMenuItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localObject instanceof NavigationMenuPresenter.NavigationMenuTextItem))
      {
        MenuItemImpl localMenuItemImpl = ((NavigationMenuPresenter.NavigationMenuTextItem)localObject).a();
        if (localMenuItemImpl != null) {
          localObject = localMenuItemImpl.getActionView();
        } else {
          localObject = null;
        }
        if (localObject != null)
        {
          ParcelableSparseArray localParcelableSparseArray = new ParcelableSparseArray();
          ((View)localObject).saveHierarchyState(localParcelableSparseArray);
          localSparseArray.put(localMenuItemImpl.getItemId(), localParcelableSparseArray);
        }
      }
      i += 1;
    }
    localBundle.putSparseParcelableArray("android:menu:action_views", localSparseArray);
    return localBundle;
  }
  
  @Nullable
  public NavigationMenuPresenter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return null;
          }
          return new NavigationMenuPresenter.HeaderViewHolder(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_a_of_type_AndroidWidgetLinearLayout);
        }
        return new NavigationMenuPresenter.SeparatorViewHolder(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_a_of_type_AndroidViewLayoutInflater, paramViewGroup);
      }
      return new NavigationMenuPresenter.SubheaderViewHolder(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_a_of_type_AndroidViewLayoutInflater, paramViewGroup);
    }
    return new NavigationMenuPresenter.NormalViewHolder(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_a_of_type_AndroidViewLayoutInflater, paramViewGroup, this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a()
  {
    b();
    notifyDataSetChanged();
  }
  
  public void a(@NonNull Bundle paramBundle)
  {
    int j = 0;
    int k = paramBundle.getInt("android:menu:checked", 0);
    int i;
    Object localObject1;
    if (k != 0)
    {
      this.jdField_a_of_type_Boolean = true;
      int m = this.jdField_a_of_type_JavaUtilArrayList.size();
      i = 0;
      while (i < m)
      {
        localObject1 = (NavigationMenuPresenter.NavigationMenuItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localObject1 instanceof NavigationMenuPresenter.NavigationMenuTextItem))
        {
          localObject1 = ((NavigationMenuPresenter.NavigationMenuTextItem)localObject1).a();
          if ((localObject1 != null) && (((MenuItemImpl)localObject1).getItemId() == k))
          {
            a((MenuItemImpl)localObject1);
            break;
          }
        }
        i += 1;
      }
      this.jdField_a_of_type_Boolean = false;
      b();
    }
    paramBundle = paramBundle.getSparseParcelableArray("android:menu:action_views");
    if (paramBundle != null)
    {
      k = this.jdField_a_of_type_JavaUtilArrayList.size();
      i = j;
      while (i < k)
      {
        localObject1 = (NavigationMenuPresenter.NavigationMenuItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localObject1 instanceof NavigationMenuPresenter.NavigationMenuTextItem))
        {
          Object localObject2 = ((NavigationMenuPresenter.NavigationMenuTextItem)localObject1).a();
          if (localObject2 != null)
          {
            localObject1 = ((MenuItemImpl)localObject2).getActionView();
            if (localObject1 != null)
            {
              localObject2 = (ParcelableSparseArray)paramBundle.get(((MenuItemImpl)localObject2).getItemId());
              if (localObject2 != null) {
                ((View)localObject1).restoreHierarchyState((SparseArray)localObject2);
              }
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void a(@NonNull MenuItemImpl paramMenuItemImpl)
  {
    if (this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl != paramMenuItemImpl)
    {
      if (!paramMenuItemImpl.isCheckable()) {
        return;
      }
      MenuItemImpl localMenuItemImpl = this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl;
      if (localMenuItemImpl != null) {
        localMenuItemImpl.setChecked(false);
      }
      this.jdField_a_of_type_AndroidxAppcompatViewMenuMenuItemImpl = paramMenuItemImpl;
      paramMenuItemImpl.setChecked(true);
    }
  }
  
  public void a(NavigationMenuPresenter.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof NavigationMenuPresenter.NormalViewHolder)) {
      ((NavigationMenuItemView)paramViewHolder.itemView).a();
    }
  }
  
  public void a(@NonNull NavigationMenuPresenter.ViewHolder paramViewHolder, int paramInt)
  {
    int i = getItemViewType(paramInt);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        localObject = (NavigationMenuPresenter.NavigationMenuSeparatorItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        paramViewHolder.itemView.setPadding(0, ((NavigationMenuPresenter.NavigationMenuSeparatorItem)localObject).a(), 0, ((NavigationMenuPresenter.NavigationMenuSeparatorItem)localObject).b());
        return;
      }
      ((TextView)paramViewHolder.itemView).setText(((NavigationMenuPresenter.NavigationMenuTextItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a().getTitle());
      return;
    }
    Object localObject = (NavigationMenuItemView)paramViewHolder.itemView;
    ((NavigationMenuItemView)localObject).a(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_b_of_type_AndroidContentResColorStateList);
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_a_of_type_Boolean) {
      ((NavigationMenuItemView)localObject).setTextAppearance(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_a_of_type_AndroidContentResColorStateList != null) {
      ((NavigationMenuItemView)localObject).setTextColor(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_a_of_type_AndroidContentResColorStateList);
    }
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      paramViewHolder = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable();
    } else {
      paramViewHolder = null;
    }
    ViewCompat.setBackground((View)localObject, paramViewHolder);
    paramViewHolder = (NavigationMenuPresenter.NavigationMenuTextItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    ((NavigationMenuItemView)localObject).setNeedsEmptyIcon(paramViewHolder.jdField_a_of_type_Boolean);
    ((NavigationMenuItemView)localObject).setHorizontalPadding(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_b_of_type_Int);
    ((NavigationMenuItemView)localObject).setIconPadding(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.c);
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.jdField_b_of_type_Boolean) {
      ((NavigationMenuItemView)localObject).setIconSize(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter.d);
    }
    ((NavigationMenuItemView)localObject).setMaxLines(NavigationMenuPresenter.a(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalNavigationMenuPresenter));
    ((NavigationMenuItemView)localObject).initialize(paramViewHolder.a(), 0);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    NavigationMenuPresenter.NavigationMenuItem localNavigationMenuItem = (NavigationMenuPresenter.NavigationMenuItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((localNavigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuSeparatorItem)) {
      return 2;
    }
    if ((localNavigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuHeaderItem)) {
      return 3;
    }
    if ((localNavigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuTextItem))
    {
      if (((NavigationMenuPresenter.NavigationMenuTextItem)localNavigationMenuItem).a().hasSubMenu()) {
        return 1;
      }
      return 0;
    }
    throw new RuntimeException("Unknown item type.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuAdapter
 * JD-Core Version:    0.7.0.1
 */