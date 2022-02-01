package androidx.recyclerview.widget;

import android.database.Observable;
import androidx.annotation.Nullable;
import java.util.ArrayList;

class RecyclerView$AdapterDataObservable
  extends Observable<RecyclerView.AdapterDataObserver>
{
  public boolean hasObservers()
  {
    return !this.mObservers.isEmpty();
  }
  
  public void notifyChanged()
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onChanged();
      i -= 1;
    }
  }
  
  public void notifyItemMoved(int paramInt1, int paramInt2)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeMoved(paramInt1, paramInt2, 1);
      i -= 1;
    }
  }
  
  public void notifyItemRangeChanged(int paramInt1, int paramInt2)
  {
    notifyItemRangeChanged(paramInt1, paramInt2, null);
  }
  
  public void notifyItemRangeChanged(int paramInt1, int paramInt2, @Nullable Object paramObject)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeChanged(paramInt1, paramInt2, paramObject);
      i -= 1;
    }
  }
  
  public void notifyItemRangeInserted(int paramInt1, int paramInt2)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeInserted(paramInt1, paramInt2);
      i -= 1;
    }
  }
  
  public void notifyItemRangeRemoved(int paramInt1, int paramInt2)
  {
    int i = this.mObservers.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeRemoved(paramInt1, paramInt2);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.AdapterDataObservable
 * JD-Core Version:    0.7.0.1
 */