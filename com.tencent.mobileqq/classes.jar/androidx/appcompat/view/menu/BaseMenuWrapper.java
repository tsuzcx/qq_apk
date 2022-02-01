package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

abstract class BaseMenuWrapper
{
  final Context mContext;
  private SimpleArrayMap<SupportMenuItem, MenuItem> mMenuItems;
  private SimpleArrayMap<SupportSubMenu, SubMenu> mSubMenus;
  
  BaseMenuWrapper(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  final MenuItem getMenuItemWrapper(MenuItem paramMenuItem)
  {
    Object localObject = paramMenuItem;
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      SupportMenuItem localSupportMenuItem = (SupportMenuItem)paramMenuItem;
      if (this.mMenuItems == null) {
        this.mMenuItems = new SimpleArrayMap();
      }
      paramMenuItem = (MenuItem)this.mMenuItems.get(paramMenuItem);
      localObject = paramMenuItem;
      if (paramMenuItem == null)
      {
        localObject = new MenuItemWrapperICS(this.mContext, localSupportMenuItem);
        this.mMenuItems.put(localSupportMenuItem, localObject);
      }
    }
    return localObject;
  }
  
  final SubMenu getSubMenuWrapper(SubMenu paramSubMenu)
  {
    if ((paramSubMenu instanceof SupportSubMenu))
    {
      SupportSubMenu localSupportSubMenu = (SupportSubMenu)paramSubMenu;
      if (this.mSubMenus == null) {
        this.mSubMenus = new SimpleArrayMap();
      }
      SubMenu localSubMenu = (SubMenu)this.mSubMenus.get(localSupportSubMenu);
      paramSubMenu = localSubMenu;
      if (localSubMenu == null)
      {
        paramSubMenu = new SubMenuWrapperICS(this.mContext, localSupportSubMenu);
        this.mSubMenus.put(localSupportSubMenu, paramSubMenu);
      }
      return paramSubMenu;
    }
    return paramSubMenu;
  }
  
  final void internalClear()
  {
    SimpleArrayMap localSimpleArrayMap = this.mMenuItems;
    if (localSimpleArrayMap != null) {
      localSimpleArrayMap.clear();
    }
    localSimpleArrayMap = this.mSubMenus;
    if (localSimpleArrayMap != null) {
      localSimpleArrayMap.clear();
    }
  }
  
  final void internalRemoveGroup(int paramInt)
  {
    if (this.mMenuItems == null) {
      return;
    }
    int j;
    for (int i = 0; i < this.mMenuItems.size(); i = j + 1)
    {
      j = i;
      if (((SupportMenuItem)this.mMenuItems.keyAt(i)).getGroupId() == paramInt)
      {
        this.mMenuItems.removeAt(i);
        j = i - 1;
      }
    }
  }
  
  final void internalRemoveItem(int paramInt)
  {
    if (this.mMenuItems == null) {
      return;
    }
    int i = 0;
    while (i < this.mMenuItems.size())
    {
      if (((SupportMenuItem)this.mMenuItems.keyAt(i)).getItemId() == paramInt)
      {
        this.mMenuItems.removeAt(i);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.BaseMenuWrapper
 * JD-Core Version:    0.7.0.1
 */