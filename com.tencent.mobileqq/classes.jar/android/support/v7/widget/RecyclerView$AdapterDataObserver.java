package android.support.v7.widget;

public abstract class RecyclerView$AdapterDataObserver
{
  public void onChanged() {}
  
  public void onItemRangeChanged(int paramInt1, int paramInt2) {}
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    onItemRangeChanged(paramInt1, paramInt2);
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2) {}
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.AdapterDataObserver
 * JD-Core Version:    0.7.0.1
 */