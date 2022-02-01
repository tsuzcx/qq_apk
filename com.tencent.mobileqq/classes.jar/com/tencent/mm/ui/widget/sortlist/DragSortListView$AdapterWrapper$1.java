package com.tencent.mm.ui.widget.sortlist;

import android.database.DataSetObserver;

class DragSortListView$AdapterWrapper$1
  extends DataSetObserver
{
  DragSortListView$AdapterWrapper$1(DragSortListView.AdapterWrapper paramAdapterWrapper, DragSortListView paramDragSortListView) {}
  
  public void onChanged()
  {
    this.b.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.b.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.AdapterWrapper.1
 * JD-Core Version:    0.7.0.1
 */