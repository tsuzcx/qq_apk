package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class ListMenuPresenter$MenuAdapter
  extends BaseAdapter
{
  private int mExpandedIndex = -1;
  
  public ListMenuPresenter$MenuAdapter(ListMenuPresenter paramListMenuPresenter)
  {
    findExpandedIndex();
  }
  
  void findExpandedIndex()
  {
    MenuItemImpl localMenuItemImpl = this.this$0.mMenu.getExpandedItem();
    if (localMenuItemImpl != null)
    {
      ArrayList localArrayList = this.this$0.mMenu.getNonActionItems();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if ((MenuItemImpl)localArrayList.get(i) == localMenuItemImpl)
        {
          this.mExpandedIndex = i;
          return;
        }
        i += 1;
      }
    }
    this.mExpandedIndex = -1;
  }
  
  public int getCount()
  {
    int i = this.this$0.mMenu.getNonActionItems().size() - this.this$0.mItemIndexOffset;
    if (this.mExpandedIndex < 0) {
      return i;
    }
    return i - 1;
  }
  
  public MenuItemImpl getItem(int paramInt)
  {
    ArrayList localArrayList = this.this$0.mMenu.getNonActionItems();
    int i = paramInt + this.this$0.mItemIndexOffset;
    int j = this.mExpandedIndex;
    paramInt = i;
    if (j >= 0)
    {
      paramInt = i;
      if (i >= j) {
        paramInt = i + 1;
      }
    }
    return (MenuItemImpl)localArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.this$0.mInflater.inflate(this.this$0.mItemLayoutRes, paramViewGroup, false);
    }
    ((MenuView.ItemView)localView).initialize(getItem(paramInt), 0);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    findExpandedIndex();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.ListMenuPresenter.MenuAdapter
 * JD-Core Version:    0.7.0.1
 */