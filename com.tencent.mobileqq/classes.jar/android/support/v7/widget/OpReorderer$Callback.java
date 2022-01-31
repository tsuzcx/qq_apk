package android.support.v7.widget;

abstract interface OpReorderer$Callback
{
  public abstract AdapterHelper.UpdateOp obtainUpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
  
  public abstract void recycleUpdateOp(AdapterHelper.UpdateOp paramUpdateOp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.OpReorderer.Callback
 * JD-Core Version:    0.7.0.1
 */