package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.MenuView.ItemView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ActionProvider;
import androidx.core.view.ActionProvider.SubUiVisibilityListener;
import java.util.ArrayList;

class ActionMenuPresenter
  extends BaseMenuPresenter
  implements ActionProvider.SubUiVisibilityListener
{
  private static final String TAG = "ActionMenuPresenter";
  private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
  ActionMenuPresenter.ActionButtonSubmenu mActionButtonPopup;
  private int mActionItemWidthLimit;
  private boolean mExpandedActionViewsExclusive;
  private int mMaxItems;
  private boolean mMaxItemsSet;
  private int mMinCellSize;
  int mOpenSubMenuId;
  ActionMenuPresenter.OverflowMenuButton mOverflowButton;
  ActionMenuPresenter.OverflowPopup mOverflowPopup;
  private Drawable mPendingOverflowIcon;
  private boolean mPendingOverflowIconSet;
  private ActionMenuPresenter.ActionMenuPopupCallback mPopupCallback;
  final ActionMenuPresenter.PopupPresenterCallback mPopupPresenterCallback = new ActionMenuPresenter.PopupPresenterCallback(this);
  ActionMenuPresenter.OpenOverflowRunnable mPostedOpenRunnable;
  private boolean mReserveOverflow;
  private boolean mReserveOverflowSet;
  private boolean mStrictWidthLimit;
  private int mWidthLimit;
  private boolean mWidthLimitSet;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, 2131558403, 2131558402);
  }
  
  private View findViewForItem(MenuItem paramMenuItem)
  {
    ViewGroup localViewGroup = (ViewGroup)this.mMenuView;
    if (localViewGroup == null) {
      return null;
    }
    int j = localViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = localViewGroup.getChildAt(i);
      if (((localView instanceof MenuView.ItemView)) && (((MenuView.ItemView)localView).getItemData() == paramMenuItem)) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView)
  {
    paramItemView.initialize(paramMenuItemImpl, 0);
    paramMenuItemImpl = (ActionMenuView)this.mMenuView;
    paramItemView = (ActionMenuItemView)paramItemView;
    paramItemView.setItemInvoker(paramMenuItemImpl);
    if (this.mPopupCallback == null) {
      this.mPopupCallback = new ActionMenuPresenter.ActionMenuPopupCallback(this);
    }
    paramItemView.setPopupCallback(this.mPopupCallback);
  }
  
  public boolean dismissPopupMenus()
  {
    return hideOverflowMenu() | hideSubMenus();
  }
  
  public boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == this.mOverflowButton) {
      return false;
    }
    return super.filterLeftoverView(paramViewGroup, paramInt);
  }
  
  public boolean flagActionItems()
  {
    Object localObject1 = this;
    ArrayList localArrayList;
    int m;
    if (((ActionMenuPresenter)localObject1).mMenu != null)
    {
      localArrayList = ((ActionMenuPresenter)localObject1).mMenu.getVisibleItems();
      m = localArrayList.size();
    }
    else
    {
      localArrayList = null;
      m = 0;
    }
    int i = ((ActionMenuPresenter)localObject1).mMaxItems;
    int i3 = ((ActionMenuPresenter)localObject1).mActionItemWidthLimit;
    int i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
    ViewGroup localViewGroup = (ViewGroup)((ActionMenuPresenter)localObject1).mMenuView;
    int n = 0;
    int i1 = 0;
    int j = 0;
    int k = 0;
    while (n < m)
    {
      localObject2 = (MenuItemImpl)localArrayList.get(n);
      if (((MenuItemImpl)localObject2).requiresActionButton()) {
        j += 1;
      } else if (((MenuItemImpl)localObject2).requestsActionButton()) {
        k += 1;
      } else {
        i1 = 1;
      }
      i2 = i;
      if (((ActionMenuPresenter)localObject1).mExpandedActionViewsExclusive)
      {
        i2 = i;
        if (((MenuItemImpl)localObject2).isActionViewExpanded()) {
          i2 = 0;
        }
      }
      n += 1;
      i = i2;
    }
    n = i;
    if (((ActionMenuPresenter)localObject1).mReserveOverflow) {
      if (i1 == 0)
      {
        n = i;
        if (k + j <= i) {}
      }
      else
      {
        n = i - 1;
      }
    }
    i = n - j;
    Object localObject2 = ((ActionMenuPresenter)localObject1).mActionButtonGroups;
    ((SparseBooleanArray)localObject2).clear();
    if (((ActionMenuPresenter)localObject1).mStrictWidthLimit)
    {
      j = ((ActionMenuPresenter)localObject1).mMinCellSize;
      k = i3 / j;
      i1 = j + i3 % j / k;
    }
    else
    {
      i1 = 0;
      k = 0;
    }
    n = i3;
    i3 = 0;
    j = 0;
    int i2 = m;
    for (;;)
    {
      localObject1 = this;
      if (i3 >= i2) {
        break;
      }
      MenuItemImpl localMenuItemImpl = (MenuItemImpl)localArrayList.get(i3);
      View localView;
      if (localMenuItemImpl.requiresActionButton())
      {
        localView = ((ActionMenuPresenter)localObject1).getItemView(localMenuItemImpl, null, localViewGroup);
        if (((ActionMenuPresenter)localObject1).mStrictWidthLimit) {
          k -= ActionMenuView.measureChildForCells(localView, i1, k, i5, 0);
        } else {
          localView.measure(i5, i5);
        }
        m = localView.getMeasuredWidth();
        n -= m;
        if (j == 0) {
          j = m;
        }
        m = localMenuItemImpl.getGroupId();
        if (m != 0) {
          ((SparseBooleanArray)localObject2).put(m, true);
        }
        localMenuItemImpl.setIsActionButton(true);
      }
      for (;;)
      {
        break;
        if (localMenuItemImpl.requestsActionButton())
        {
          int i6 = localMenuItemImpl.getGroupId();
          boolean bool = ((SparseBooleanArray)localObject2).get(i6);
          int i7;
          if (((i > 0) || (bool)) && (n > 0) && ((!((ActionMenuPresenter)localObject1).mStrictWidthLimit) || (k > 0))) {
            i7 = 1;
          } else {
            i7 = 0;
          }
          int i4;
          if (i7 != 0)
          {
            localView = ((ActionMenuPresenter)localObject1).getItemView(localMenuItemImpl, null, localViewGroup);
            if (((ActionMenuPresenter)localObject1).mStrictWidthLimit)
            {
              m = ActionMenuView.measureChildForCells(localView, i1, k, i5, 0);
              k -= m;
              if (m == 0) {
                i7 = 0;
              }
            }
            else
            {
              localView.measure(i5, i5);
            }
            i4 = localView.getMeasuredWidth();
            n -= i4;
            m = j;
            if (j == 0) {
              m = i4;
            }
            if (((ActionMenuPresenter)localObject1).mStrictWidthLimit ? n >= 0 : n + m > 0) {
              j = 1;
            } else {
              j = 0;
            }
            i7 &= j;
            j = m;
          }
          if ((i7 != 0) && (i6 != 0))
          {
            ((SparseBooleanArray)localObject2).put(i6, true);
            m = i;
          }
          else
          {
            m = i;
            if (bool)
            {
              ((SparseBooleanArray)localObject2).put(i6, false);
              i4 = 0;
              for (;;)
              {
                m = i;
                if (i4 >= i3) {
                  break;
                }
                localObject1 = (MenuItemImpl)localArrayList.get(i4);
                m = i;
                if (((MenuItemImpl)localObject1).getGroupId() == i6)
                {
                  m = i;
                  if (((MenuItemImpl)localObject1).isActionButton()) {
                    m = i + 1;
                  }
                  ((MenuItemImpl)localObject1).setIsActionButton(false);
                }
                i4 += 1;
                i = m;
              }
            }
          }
          i = m;
          if (i7 != 0) {
            i = m - 1;
          }
          localMenuItemImpl.setIsActionButton(i7);
        }
        else
        {
          localMenuItemImpl.setIsActionButton(false);
        }
      }
      i3 += 1;
    }
    return true;
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramMenuItemImpl.getActionView();
    if ((localView == null) || (paramMenuItemImpl.hasCollapsibleActionView())) {
      localView = super.getItemView(paramMenuItemImpl, paramView, paramViewGroup);
    }
    int i;
    if (paramMenuItemImpl.isActionViewExpanded()) {
      i = 8;
    } else {
      i = 0;
    }
    localView.setVisibility(i);
    paramMenuItemImpl = (ActionMenuView)paramViewGroup;
    paramView = localView.getLayoutParams();
    if (!paramMenuItemImpl.checkLayoutParams(paramView)) {
      localView.setLayoutParams(paramMenuItemImpl.generateLayoutParams(paramView));
    }
    return localView;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    MenuView localMenuView = this.mMenuView;
    paramViewGroup = super.getMenuView(paramViewGroup);
    if (localMenuView != paramViewGroup) {
      ((ActionMenuView)paramViewGroup).setPresenter(this);
    }
    return paramViewGroup;
  }
  
  public Drawable getOverflowIcon()
  {
    ActionMenuPresenter.OverflowMenuButton localOverflowMenuButton = this.mOverflowButton;
    if (localOverflowMenuButton != null) {
      return localOverflowMenuButton.getDrawable();
    }
    if (this.mPendingOverflowIconSet) {
      return this.mPendingOverflowIcon;
    }
    return null;
  }
  
  public boolean hideOverflowMenu()
  {
    if ((this.mPostedOpenRunnable != null) && (this.mMenuView != null))
    {
      ((View)this.mMenuView).removeCallbacks(this.mPostedOpenRunnable);
      this.mPostedOpenRunnable = null;
      return true;
    }
    ActionMenuPresenter.OverflowPopup localOverflowPopup = this.mOverflowPopup;
    if (localOverflowPopup != null)
    {
      localOverflowPopup.dismiss();
      return true;
    }
    return false;
  }
  
  public boolean hideSubMenus()
  {
    ActionMenuPresenter.ActionButtonSubmenu localActionButtonSubmenu = this.mActionButtonPopup;
    if (localActionButtonSubmenu != null)
    {
      localActionButtonSubmenu.dismiss();
      return true;
    }
    return false;
  }
  
  public void initForMenu(@NonNull Context paramContext, @Nullable MenuBuilder paramMenuBuilder)
  {
    super.initForMenu(paramContext, paramMenuBuilder);
    paramMenuBuilder = paramContext.getResources();
    paramContext = ActionBarPolicy.get(paramContext);
    if (!this.mReserveOverflowSet) {
      this.mReserveOverflow = paramContext.showsOverflowMenuButton();
    }
    if (!this.mWidthLimitSet) {
      this.mWidthLimit = paramContext.getEmbeddedMenuWidthLimit();
    }
    if (!this.mMaxItemsSet) {
      this.mMaxItems = paramContext.getMaxActionButtons();
    }
    int i = this.mWidthLimit;
    if (this.mReserveOverflow)
    {
      if (this.mOverflowButton == null)
      {
        this.mOverflowButton = new ActionMenuPresenter.OverflowMenuButton(this, this.mSystemContext);
        if (this.mPendingOverflowIconSet)
        {
          this.mOverflowButton.setImageDrawable(this.mPendingOverflowIcon);
          this.mPendingOverflowIcon = null;
          this.mPendingOverflowIconSet = false;
        }
        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mOverflowButton.measure(j, j);
      }
      i -= this.mOverflowButton.getMeasuredWidth();
    }
    else
    {
      this.mOverflowButton = null;
    }
    this.mActionItemWidthLimit = i;
    this.mMinCellSize = ((int)(paramMenuBuilder.getDisplayMetrics().density * 56.0F));
  }
  
  public boolean isOverflowMenuShowPending()
  {
    return (this.mPostedOpenRunnable != null) || (isOverflowMenuShowing());
  }
  
  public boolean isOverflowMenuShowing()
  {
    ActionMenuPresenter.OverflowPopup localOverflowPopup = this.mOverflowPopup;
    return (localOverflowPopup != null) && (localOverflowPopup.isShowing());
  }
  
  public boolean isOverflowReserved()
  {
    return this.mReserveOverflow;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    dismissPopupMenus();
    super.onCloseMenu(paramMenuBuilder, paramBoolean);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.mMaxItemsSet) {
      this.mMaxItems = ActionBarPolicy.get(this.mContext).getMaxActionButtons();
    }
    if (this.mMenu != null) {
      this.mMenu.onItemsChanged(true);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ActionMenuPresenter.SavedState)) {
      return;
    }
    paramParcelable = (ActionMenuPresenter.SavedState)paramParcelable;
    if (paramParcelable.openSubMenuId > 0)
    {
      paramParcelable = this.mMenu.findItem(paramParcelable.openSubMenuId);
      if (paramParcelable != null) {
        onSubMenuSelected((SubMenuBuilder)paramParcelable.getSubMenu());
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    ActionMenuPresenter.SavedState localSavedState = new ActionMenuPresenter.SavedState();
    localSavedState.openSubMenuId = this.mOpenSubMenuId;
    return localSavedState;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    boolean bool1 = paramSubMenuBuilder.hasVisibleItems();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    for (Object localObject = paramSubMenuBuilder; ((SubMenuBuilder)localObject).getParentMenu() != this.mMenu; localObject = (SubMenuBuilder)((SubMenuBuilder)localObject).getParentMenu()) {}
    localObject = findViewForItem(((SubMenuBuilder)localObject).getItem());
    if (localObject == null) {
      return false;
    }
    this.mOpenSubMenuId = paramSubMenuBuilder.getItem().getItemId();
    int j = paramSubMenuBuilder.size();
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      MenuItem localMenuItem = paramSubMenuBuilder.getItem(i);
      if ((localMenuItem.isVisible()) && (localMenuItem.getIcon() != null))
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
    this.mActionButtonPopup = new ActionMenuPresenter.ActionButtonSubmenu(this, this.mContext, paramSubMenuBuilder, (View)localObject);
    this.mActionButtonPopup.setForceShowIcon(bool1);
    this.mActionButtonPopup.show();
    super.onSubMenuSelected(paramSubMenuBuilder);
    return true;
  }
  
  public void onSubUiVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.onSubMenuSelected(null);
      return;
    }
    if (this.mMenu != null) {
      this.mMenu.close(false);
    }
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.mExpandedActionViewsExclusive = paramBoolean;
  }
  
  public void setItemLimit(int paramInt)
  {
    this.mMaxItems = paramInt;
    this.mMaxItemsSet = true;
  }
  
  public void setMenuView(ActionMenuView paramActionMenuView)
  {
    this.mMenuView = paramActionMenuView;
    paramActionMenuView.initialize(this.mMenu);
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    ActionMenuPresenter.OverflowMenuButton localOverflowMenuButton = this.mOverflowButton;
    if (localOverflowMenuButton != null)
    {
      localOverflowMenuButton.setImageDrawable(paramDrawable);
      return;
    }
    this.mPendingOverflowIconSet = true;
    this.mPendingOverflowIcon = paramDrawable;
  }
  
  public void setReserveOverflow(boolean paramBoolean)
  {
    this.mReserveOverflow = paramBoolean;
    this.mReserveOverflowSet = true;
  }
  
  public void setWidthLimit(int paramInt, boolean paramBoolean)
  {
    this.mWidthLimit = paramInt;
    this.mStrictWidthLimit = paramBoolean;
    this.mWidthLimitSet = true;
  }
  
  public boolean shouldIncludeItem(int paramInt, MenuItemImpl paramMenuItemImpl)
  {
    return paramMenuItemImpl.isActionButton();
  }
  
  public boolean showOverflowMenu()
  {
    if ((this.mReserveOverflow) && (!isOverflowMenuShowing()) && (this.mMenu != null) && (this.mMenuView != null) && (this.mPostedOpenRunnable == null) && (!this.mMenu.getNonActionItems().isEmpty()))
    {
      this.mPostedOpenRunnable = new ActionMenuPresenter.OpenOverflowRunnable(this, new ActionMenuPresenter.OverflowPopup(this, this.mContext, this.mMenu, this.mOverflowButton, true));
      ((View)this.mMenuView).post(this.mPostedOpenRunnable);
      super.onSubMenuSelected(null);
      return true;
    }
    return false;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    super.updateMenuView(paramBoolean);
    ((View)this.mMenuView).requestLayout();
    Object localObject = this.mMenu;
    int j = 0;
    int k;
    if (localObject != null)
    {
      localObject = this.mMenu.getActionItems();
      k = ((ArrayList)localObject).size();
      i = 0;
      while (i < k)
      {
        ActionProvider localActionProvider = ((MenuItemImpl)((ArrayList)localObject).get(i)).getSupportActionProvider();
        if (localActionProvider != null) {
          localActionProvider.setSubUiVisibilityListener(this);
        }
        i += 1;
      }
    }
    if (this.mMenu != null) {
      localObject = this.mMenu.getNonActionItems();
    } else {
      localObject = null;
    }
    int i = j;
    boolean bool;
    if (this.mReserveOverflow)
    {
      i = j;
      if (localObject != null)
      {
        k = ((ArrayList)localObject).size();
        if (k == 1)
        {
          bool = ((MenuItemImpl)((ArrayList)localObject).get(0)).isActionViewExpanded() ^ true;
        }
        else
        {
          bool = j;
          if (k > 0) {
            bool = true;
          }
        }
      }
    }
    if (bool)
    {
      if (this.mOverflowButton == null) {
        this.mOverflowButton = new ActionMenuPresenter.OverflowMenuButton(this, this.mSystemContext);
      }
      localObject = (ViewGroup)this.mOverflowButton.getParent();
      if (localObject != this.mMenuView)
      {
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.mOverflowButton);
        }
        localObject = (ActionMenuView)this.mMenuView;
        ((ActionMenuView)localObject).addView(this.mOverflowButton, ((ActionMenuView)localObject).generateOverflowButtonLayoutParams());
      }
    }
    else
    {
      localObject = this.mOverflowButton;
      if ((localObject != null) && (((ActionMenuPresenter.OverflowMenuButton)localObject).getParent() == this.mMenuView)) {
        ((ViewGroup)this.mMenuView).removeView(this.mOverflowButton);
      }
    }
    ((ActionMenuView)this.mMenuView).setOverflowReserved(this.mReserveOverflow);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ActionMenuPresenter
 * JD-Core Version:    0.7.0.1
 */