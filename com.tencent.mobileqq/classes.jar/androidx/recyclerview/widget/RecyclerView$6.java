package androidx.recyclerview.widget;

class RecyclerView$6
  implements AdapterHelper.Callback
{
  RecyclerView$6(RecyclerView paramRecyclerView) {}
  
  void dispatchUpdate(AdapterHelper.UpdateOp paramUpdateOp)
  {
    switch (paramUpdateOp.cmd)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    case 1: 
      this.this$0.mLayout.onItemsAdded(this.this$0, paramUpdateOp.positionStart, paramUpdateOp.itemCount);
      return;
    case 2: 
      this.this$0.mLayout.onItemsRemoved(this.this$0, paramUpdateOp.positionStart, paramUpdateOp.itemCount);
      return;
    case 4: 
      this.this$0.mLayout.onItemsUpdated(this.this$0, paramUpdateOp.positionStart, paramUpdateOp.itemCount, paramUpdateOp.payload);
      return;
    }
    this.this$0.mLayout.onItemsMoved(this.this$0, paramUpdateOp.positionStart, paramUpdateOp.itemCount, 1);
  }
  
  public RecyclerView.ViewHolder findViewHolder(int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = this.this$0.findViewHolderForPosition(paramInt, true);
    if (localViewHolder == null) {}
    while (this.this$0.mChildHelper.isHidden(localViewHolder.itemView)) {
      return null;
    }
    return localViewHolder;
  }
  
  public void markViewHoldersUpdated(int paramInt1, int paramInt2, Object paramObject)
  {
    this.this$0.viewRangeUpdate(paramInt1, paramInt2, paramObject);
    this.this$0.mItemsChanged = true;
  }
  
  public void offsetPositionsForAdd(int paramInt1, int paramInt2)
  {
    this.this$0.offsetPositionRecordsForInsert(paramInt1, paramInt2);
    this.this$0.mItemsAddedOrRemoved = true;
  }
  
  public void offsetPositionsForMove(int paramInt1, int paramInt2)
  {
    this.this$0.offsetPositionRecordsForMove(paramInt1, paramInt2);
    this.this$0.mItemsAddedOrRemoved = true;
  }
  
  public void offsetPositionsForRemovingInvisible(int paramInt1, int paramInt2)
  {
    this.this$0.offsetPositionRecordsForRemove(paramInt1, paramInt2, true);
    this.this$0.mItemsAddedOrRemoved = true;
    RecyclerView.State localState = this.this$0.mState;
    localState.mDeletedInvisibleItemCountSincePreviousLayout += paramInt2;
  }
  
  public void offsetPositionsForRemovingLaidOutOrNewView(int paramInt1, int paramInt2)
  {
    this.this$0.offsetPositionRecordsForRemove(paramInt1, paramInt2, false);
    this.this$0.mItemsAddedOrRemoved = true;
  }
  
  public void onDispatchFirstPass(AdapterHelper.UpdateOp paramUpdateOp)
  {
    dispatchUpdate(paramUpdateOp);
  }
  
  public void onDispatchSecondPass(AdapterHelper.UpdateOp paramUpdateOp)
  {
    dispatchUpdate(paramUpdateOp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.6
 * JD-Core Version:    0.7.0.1
 */