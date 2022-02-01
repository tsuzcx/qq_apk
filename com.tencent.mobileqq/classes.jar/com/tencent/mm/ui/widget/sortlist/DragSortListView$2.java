package com.tencent.mm.ui.widget.sortlist;

import android.database.DataSetObserver;

class DragSortListView$2
  extends DataSetObserver
{
  DragSortListView$2(DragSortListView paramDragSortListView) {}
  
  private void a()
  {
    if (DragSortListView.b(this.a) == 4) {
      this.a.cancelDrag();
    }
  }
  
  public void onChanged()
  {
    a();
  }
  
  public void onInvalidated()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.2
 * JD-Core Version:    0.7.0.1
 */