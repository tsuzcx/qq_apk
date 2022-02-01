package androidx.appcompat.widget;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter.Callback;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;

class Toolbar$ExpandedActionViewMenuPresenter
  implements MenuPresenter
{
  MenuItemImpl mCurrentExpandedItem;
  MenuBuilder mMenu;
  
  Toolbar$ExpandedActionViewMenuPresenter(Toolbar paramToolbar) {}
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    if ((this.this$0.mExpandedActionView instanceof CollapsibleActionView)) {
      ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewCollapsed();
    }
    paramMenuBuilder = this.this$0;
    paramMenuBuilder.removeView(paramMenuBuilder.mExpandedActionView);
    paramMenuBuilder = this.this$0;
    paramMenuBuilder.removeView(paramMenuBuilder.mCollapseButtonView);
    paramMenuBuilder = this.this$0;
    paramMenuBuilder.mExpandedActionView = null;
    paramMenuBuilder.addChildrenForExpandedActionView();
    this.mCurrentExpandedItem = null;
    this.this$0.requestLayout();
    paramMenuItemImpl.setActionViewExpanded(false);
    return true;
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    this.this$0.ensureCollapseButtonView();
    paramMenuBuilder = this.this$0.mCollapseButtonView.getParent();
    Toolbar localToolbar = this.this$0;
    if (paramMenuBuilder != localToolbar)
    {
      if ((paramMenuBuilder instanceof ViewGroup)) {
        ((ViewGroup)paramMenuBuilder).removeView(localToolbar.mCollapseButtonView);
      }
      paramMenuBuilder = this.this$0;
      paramMenuBuilder.addView(paramMenuBuilder.mCollapseButtonView);
    }
    this.this$0.mExpandedActionView = paramMenuItemImpl.getActionView();
    this.mCurrentExpandedItem = paramMenuItemImpl;
    paramMenuBuilder = this.this$0.mExpandedActionView.getParent();
    localToolbar = this.this$0;
    if (paramMenuBuilder != localToolbar)
    {
      if ((paramMenuBuilder instanceof ViewGroup)) {
        ((ViewGroup)paramMenuBuilder).removeView(localToolbar.mExpandedActionView);
      }
      paramMenuBuilder = this.this$0.generateDefaultLayoutParams();
      paramMenuBuilder.gravity = (0x800003 | this.this$0.mButtonGravity & 0x70);
      paramMenuBuilder.mViewType = 2;
      this.this$0.mExpandedActionView.setLayoutParams(paramMenuBuilder);
      paramMenuBuilder = this.this$0;
      paramMenuBuilder.addView(paramMenuBuilder.mExpandedActionView);
    }
    this.this$0.removeChildrenForExpandedActionView();
    this.this$0.requestLayout();
    paramMenuItemImpl.setActionViewExpanded(true);
    if ((this.this$0.mExpandedActionView instanceof CollapsibleActionView)) {
      ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewExpanded();
    }
    return true;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public int getId()
  {
    return 0;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    paramContext = this.mMenu;
    if (paramContext != null)
    {
      MenuItemImpl localMenuItemImpl = this.mCurrentExpandedItem;
      if (localMenuItemImpl != null) {
        paramContext.collapseItemActionView(localMenuItemImpl);
      }
    }
    this.mMenu = paramMenuBuilder;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    return false;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback) {}
  
  public void updateMenuView(boolean paramBoolean)
  {
    if (this.mCurrentExpandedItem != null)
    {
      MenuBuilder localMenuBuilder = this.mMenu;
      int k = 0;
      int j = k;
      if (localMenuBuilder != null)
      {
        int m = localMenuBuilder.size();
        int i = 0;
        for (;;)
        {
          j = k;
          if (i >= m) {
            break;
          }
          if (this.mMenu.getItem(i) == this.mCurrentExpandedItem)
          {
            j = 1;
            break;
          }
          i += 1;
        }
      }
      if (j == 0) {
        collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.Toolbar.ExpandedActionViewMenuPresenter
 * JD-Core Version:    0.7.0.1
 */