package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuPopupWindow$MenuDropDownListView
  extends DropDownListView
{
  final int mAdvanceKey;
  private MenuItemHoverListener mHoverListener;
  private MenuItem mHoveredMenuItem;
  final int mRetreatKey;
  
  public MenuPopupWindow$MenuDropDownListView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
    paramContext = paramContext.getResources().getConfiguration();
    if ((Build.VERSION.SDK_INT >= 17) && (1 == paramContext.getLayoutDirection()))
    {
      this.mAdvanceKey = 21;
      this.mRetreatKey = 22;
      return;
    }
    this.mAdvanceKey = 22;
    this.mRetreatKey = 21;
  }
  
  public void clearSelection()
  {
    setSelection(-1);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    if (this.mHoverListener != null)
    {
      Object localObject1 = getAdapter();
      int i;
      if ((localObject1 instanceof HeaderViewListAdapter))
      {
        localObject1 = (HeaderViewListAdapter)localObject1;
        i = ((HeaderViewListAdapter)localObject1).getHeadersCount();
        localObject1 = (MenuAdapter)((HeaderViewListAdapter)localObject1).getWrappedAdapter();
      }
      else
      {
        i = 0;
        localObject1 = (MenuAdapter)localObject1;
      }
      MenuItem localMenuItem = null;
      Object localObject2 = localMenuItem;
      if (paramMotionEvent.getAction() != 10)
      {
        int j = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        localObject2 = localMenuItem;
        if (j != -1)
        {
          i = j - i;
          localObject2 = localMenuItem;
          if (i >= 0)
          {
            localObject2 = localMenuItem;
            if (i < ((MenuAdapter)localObject1).getCount()) {
              localObject2 = ((MenuAdapter)localObject1).getItem(i);
            }
          }
        }
      }
      localMenuItem = this.mHoveredMenuItem;
      if (localMenuItem != localObject2)
      {
        localObject1 = ((MenuAdapter)localObject1).getAdapterMenu();
        if (localMenuItem != null) {
          this.mHoverListener.onItemHoverExit((MenuBuilder)localObject1, localMenuItem);
        }
        this.mHoveredMenuItem = ((MenuItem)localObject2);
        if (localObject2 != null) {
          this.mHoverListener.onItemHoverEnter((MenuBuilder)localObject1, (MenuItem)localObject2);
        }
      }
    }
    return super.onHoverEvent(paramMotionEvent);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    ListMenuItemView localListMenuItemView = (ListMenuItemView)getSelectedView();
    if ((localListMenuItemView != null) && (paramInt == this.mAdvanceKey))
    {
      if ((localListMenuItemView.isEnabled()) && (localListMenuItemView.getItemData().hasSubMenu())) {
        performItemClick(localListMenuItemView, getSelectedItemPosition(), getSelectedItemId());
      }
      return true;
    }
    if ((localListMenuItemView != null) && (paramInt == this.mRetreatKey))
    {
      setSelection(-1);
      ((MenuAdapter)getAdapter()).getAdapterMenu().close(false);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setHoverListener(MenuItemHoverListener paramMenuItemHoverListener)
  {
    this.mHoverListener = paramMenuItemHoverListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.MenuPopupWindow.MenuDropDownListView
 * JD-Core Version:    0.7.0.1
 */