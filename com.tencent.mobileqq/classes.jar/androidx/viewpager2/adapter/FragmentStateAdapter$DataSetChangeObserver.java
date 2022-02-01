package androidx.viewpager2.adapter;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;

abstract class FragmentStateAdapter$DataSetChangeObserver
  extends RecyclerView.AdapterDataObserver
{
  public abstract void onChanged();
  
  public final void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    onChanged();
  }
  
  public final void onItemRangeChanged(int paramInt1, int paramInt2, @Nullable Object paramObject)
  {
    onChanged();
  }
  
  public final void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    onChanged();
  }
  
  public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    onChanged();
  }
  
  public final void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    onChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager2.adapter.FragmentStateAdapter.DataSetChangeObserver
 * JD-Core Version:    0.7.0.1
 */