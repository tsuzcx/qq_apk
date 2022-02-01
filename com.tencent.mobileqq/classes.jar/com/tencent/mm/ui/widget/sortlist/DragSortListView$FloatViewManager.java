package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Point;
import android.view.View;

public abstract interface DragSortListView$FloatViewManager
{
  public abstract View onCreateFloatView(int paramInt);
  
  public abstract void onDestroyFloatView(View paramView);
  
  public abstract void onDragFloatView(View paramView, Point paramPoint1, Point paramPoint2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.FloatViewManager
 * JD-Core Version:    0.7.0.1
 */