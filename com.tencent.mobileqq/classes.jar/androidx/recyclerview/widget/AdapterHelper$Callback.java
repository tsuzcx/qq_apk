package androidx.recyclerview.widget;

abstract interface AdapterHelper$Callback
{
  public abstract RecyclerView.ViewHolder findViewHolder(int paramInt);
  
  public abstract void markViewHoldersUpdated(int paramInt1, int paramInt2, Object paramObject);
  
  public abstract void offsetPositionsForAdd(int paramInt1, int paramInt2);
  
  public abstract void offsetPositionsForMove(int paramInt1, int paramInt2);
  
  public abstract void offsetPositionsForRemovingInvisible(int paramInt1, int paramInt2);
  
  public abstract void offsetPositionsForRemovingLaidOutOrNewView(int paramInt1, int paramInt2);
  
  public abstract void onDispatchFirstPass(AdapterHelper.UpdateOp paramUpdateOp);
  
  public abstract void onDispatchSecondPass(AdapterHelper.UpdateOp paramUpdateOp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.AdapterHelper.Callback
 * JD-Core Version:    0.7.0.1
 */