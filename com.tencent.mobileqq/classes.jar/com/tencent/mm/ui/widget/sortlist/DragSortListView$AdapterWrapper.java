package com.tencent.mm.ui.widget.sortlist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DragSortListView$AdapterWrapper
  extends BaseAdapter
{
  private ListAdapter b;
  
  private DragSortListView$AdapterWrapper(DragSortListView paramDragSortListView, ListAdapter paramListAdapter)
  {
    this.b = paramListAdapter;
    this.b.registerDataSetObserver(new DragSortListView.AdapterWrapper.1(this, paramDragSortListView));
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.b.areAllItemsEnabled();
  }
  
  public ListAdapter getAdapter()
  {
    return this.b;
  }
  
  public int getCount()
  {
    return this.b.getCount();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.b.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.b.getItemViewType(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if ((paramView != null) && ((paramView instanceof DragSortItemView)))
    {
      localObject2 = (DragSortItemView)paramView;
      View localView1 = ((DragSortItemView)localObject2).getChildAt(0);
      View localView2 = this.b.getView(paramInt, localView1, this.a);
      localObject1 = localObject2;
      if (localView2 != localView1)
      {
        if (localView1 != null) {
          ((DragSortItemView)localObject2).removeViewAt(0);
        }
        ((DragSortItemView)localObject2).addView(localView2);
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject2 = this.b.getView(paramInt, null, this.a);
      if ((localObject2 instanceof Checkable)) {
        localObject1 = new DragSortItemViewCheckable(this.a.getContext());
      } else {
        localObject1 = new DragSortItemView(this.a.getContext());
      }
      ((DragSortItemView)localObject1).setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      ((DragSortItemView)localObject1).addView((View)localObject2);
    }
    Object localObject2 = this.a;
    DragSortListView.a((DragSortListView)localObject2, ((DragSortListView)localObject2).getHeaderViewsCount() + paramInt, (View)localObject1, true);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public int getViewTypeCount()
  {
    return this.b.getViewTypeCount();
  }
  
  public boolean hasStableIds()
  {
    return this.b.hasStableIds();
  }
  
  public boolean isEmpty()
  {
    return this.b.isEmpty();
  }
  
  public boolean isEnabled(int paramInt)
  {
    return this.b.isEnabled(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.AdapterWrapper
 * JD-Core Version:    0.7.0.1
 */