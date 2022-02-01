package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class BaseMenuPresenter
  implements MenuPresenter
{
  private MenuPresenter.Callback mCallback;
  protected Context mContext;
  private int mId;
  protected LayoutInflater mInflater;
  private int mItemLayoutRes;
  protected MenuBuilder mMenu;
  private int mMenuLayoutRes;
  protected MenuView mMenuView;
  protected Context mSystemContext;
  protected LayoutInflater mSystemInflater;
  
  public BaseMenuPresenter(Context paramContext, int paramInt1, int paramInt2)
  {
    this.mSystemContext = paramContext;
    this.mSystemInflater = LayoutInflater.from(paramContext);
    this.mMenuLayoutRes = paramInt1;
    this.mItemLayoutRes = paramInt2;
  }
  
  protected void addItemView(View paramView, int paramInt)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(paramView);
    }
    ((ViewGroup)this.mMenuView).addView(paramView, paramInt);
  }
  
  public abstract void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView);
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public MenuView.ItemView createItemView(ViewGroup paramViewGroup)
  {
    return (MenuView.ItemView)this.mSystemInflater.inflate(this.mItemLayoutRes, paramViewGroup, false);
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  protected boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public MenuPresenter.Callback getCallback()
  {
    return this.mCallback;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView instanceof MenuView.ItemView)) {
      paramView = (MenuView.ItemView)paramView;
    } else {
      paramView = createItemView(paramViewGroup);
    }
    bindItemView(paramMenuItemImpl, paramView);
    return (View)paramView;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    if (this.mMenuView == null)
    {
      this.mMenuView = ((MenuView)this.mSystemInflater.inflate(this.mMenuLayoutRes, paramViewGroup, false));
      this.mMenuView.initialize(this.mMenu);
      updateMenuView(true);
    }
    return this.mMenuView;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    this.mMenu = paramMenuBuilder;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    MenuPresenter.Callback localCallback = this.mCallback;
    if (localCallback != null) {
      localCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    MenuPresenter.Callback localCallback = this.mCallback;
    if (localCallback != null)
    {
      if (paramSubMenuBuilder == null) {
        paramSubMenuBuilder = this.mMenu;
      }
      return localCallback.onOpenSubMenu(paramSubMenuBuilder);
    }
    return false;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  public void setId(int paramInt)
  {
    this.mId = paramInt;
  }
  
  public boolean shouldIncludeItem(int paramInt, MenuItemImpl paramMenuItemImpl)
  {
    return true;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)this.mMenuView;
    if (localViewGroup == null) {
      return;
    }
    Object localObject = this.mMenu;
    int i = 0;
    if (localObject != null)
    {
      ((MenuBuilder)localObject).flagActionItems();
      ArrayList localArrayList = this.mMenu.getVisibleItems();
      int m = localArrayList.size();
      int j = 0;
      int k;
      for (i = 0; j < m; i = k)
      {
        MenuItemImpl localMenuItemImpl = (MenuItemImpl)localArrayList.get(j);
        k = i;
        if (shouldIncludeItem(i, localMenuItemImpl))
        {
          View localView1 = localViewGroup.getChildAt(i);
          if ((localView1 instanceof MenuView.ItemView)) {
            localObject = ((MenuView.ItemView)localView1).getItemData();
          } else {
            localObject = null;
          }
          View localView2 = getItemView(localMenuItemImpl, localView1, localViewGroup);
          if (localMenuItemImpl != localObject)
          {
            localView2.setPressed(false);
            localView2.jumpDrawablesToCurrentState();
          }
          if (localView2 != localView1) {
            addItemView(localView2, i);
          }
          k = i + 1;
        }
        j += 1;
      }
    }
    while (i < localViewGroup.getChildCount()) {
      if (!filterLeftoverView(localViewGroup, i)) {
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.BaseMenuPresenter
 * JD-Core Version:    0.7.0.1
 */