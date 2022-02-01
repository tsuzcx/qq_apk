package androidx.recyclerview.widget;

class ItemTouchHelper$5
  implements RecyclerView.ChildDrawingOrderCallback
{
  ItemTouchHelper$5(ItemTouchHelper paramItemTouchHelper) {}
  
  public int onGetChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.this$0.mOverdrawChild == null) {}
    int i;
    do
    {
      return paramInt2;
      int j = this.this$0.mOverdrawChildPosition;
      i = j;
      if (j == -1)
      {
        i = this.this$0.mRecyclerView.indexOfChild(this.this$0.mOverdrawChild);
        this.this$0.mOverdrawChildPosition = i;
      }
      if (paramInt2 == paramInt1 - 1) {
        return i;
      }
    } while (paramInt2 < i);
    return paramInt2 + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.ItemTouchHelper.5
 * JD-Core Version:    0.7.0.1
 */