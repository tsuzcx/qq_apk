package com.tencent.biz.qqcircle.publish.preview.itemtouchhelper;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback;

class ItemTouchHelper$5
  implements RecyclerView.ChildDrawingOrderCallback
{
  ItemTouchHelper$5(ItemTouchHelper paramItemTouchHelper) {}
  
  public int onGetChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.a.s == null) {
      return paramInt2;
    }
    int j = this.a.t;
    int i = j;
    if (j == -1)
    {
      i = this.a.p.indexOfChild(this.a.s);
      this.a.t = i;
    }
    if (paramInt2 == paramInt1 - 1) {
      return i;
    }
    if (paramInt2 < i) {
      return paramInt2;
    }
    return paramInt2 + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.itemtouchhelper.ItemTouchHelper.5
 * JD-Core Version:    0.7.0.1
 */