package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.TraceCompat;
import java.util.List;

public abstract class RecyclerView$Adapter<VH extends RecyclerView.ViewHolder>
{
  private boolean mHasStableIds = false;
  private final RecyclerView.AdapterDataObservable mObservable = new RecyclerView.AdapterDataObservable();
  
  public final void bindViewHolder(@NonNull VH paramVH, int paramInt)
  {
    paramVH.mPosition = paramInt;
    if (hasStableIds()) {
      paramVH.mItemId = getItemId(paramInt);
    }
    paramVH.setFlags(1, 519);
    TraceCompat.beginSection("RV OnBindView");
    onBindViewHolder(paramVH, paramInt, paramVH.getUnmodifiedPayloads());
    paramVH.clearPayload();
    paramVH = paramVH.itemView.getLayoutParams();
    if ((paramVH instanceof RecyclerView.LayoutParams)) {
      ((RecyclerView.LayoutParams)paramVH).mInsetsDirty = true;
    }
    TraceCompat.endSection();
  }
  
  @NonNull
  public final VH createViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    try
    {
      TraceCompat.beginSection("RV CreateView");
      paramViewGroup = onCreateViewHolder(paramViewGroup, paramInt);
      if (paramViewGroup.itemView.getParent() != null) {
        throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
      }
    }
    finally
    {
      TraceCompat.endSection();
    }
    paramViewGroup.mItemViewType = paramInt;
    TraceCompat.endSection();
    return paramViewGroup;
  }
  
  public abstract int getItemCount();
  
  public long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final boolean hasObservers()
  {
    return this.mObservable.hasObservers();
  }
  
  public final boolean hasStableIds()
  {
    return this.mHasStableIds;
  }
  
  public final void notifyDataSetChanged()
  {
    this.mObservable.notifyChanged();
  }
  
  public final void notifyItemChanged(int paramInt)
  {
    this.mObservable.notifyItemRangeChanged(paramInt, 1);
  }
  
  public final void notifyItemChanged(int paramInt, @Nullable Object paramObject)
  {
    this.mObservable.notifyItemRangeChanged(paramInt, 1, paramObject);
  }
  
  public final void notifyItemInserted(int paramInt)
  {
    this.mObservable.notifyItemRangeInserted(paramInt, 1);
  }
  
  public final void notifyItemMoved(int paramInt1, int paramInt2)
  {
    this.mObservable.notifyItemMoved(paramInt1, paramInt2);
  }
  
  public final void notifyItemRangeChanged(int paramInt1, int paramInt2)
  {
    this.mObservable.notifyItemRangeChanged(paramInt1, paramInt2);
  }
  
  public final void notifyItemRangeChanged(int paramInt1, int paramInt2, @Nullable Object paramObject)
  {
    this.mObservable.notifyItemRangeChanged(paramInt1, paramInt2, paramObject);
  }
  
  public final void notifyItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.mObservable.notifyItemRangeInserted(paramInt1, paramInt2);
  }
  
  public final void notifyItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.mObservable.notifyItemRangeRemoved(paramInt1, paramInt2);
  }
  
  public final void notifyItemRemoved(int paramInt)
  {
    this.mObservable.notifyItemRangeRemoved(paramInt, 1);
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView) {}
  
  public abstract void onBindViewHolder(@NonNull VH paramVH, int paramInt);
  
  public void onBindViewHolder(@NonNull VH paramVH, int paramInt, @NonNull List<Object> paramList)
  {
    onBindViewHolder(paramVH, paramInt);
  }
  
  @NonNull
  public abstract VH onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt);
  
  public void onDetachedFromRecyclerView(@NonNull RecyclerView paramRecyclerView) {}
  
  public boolean onFailedToRecycleView(@NonNull VH paramVH)
  {
    return false;
  }
  
  public void onViewAttachedToWindow(@NonNull VH paramVH) {}
  
  public void onViewDetachedFromWindow(@NonNull VH paramVH) {}
  
  public void onViewRecycled(@NonNull VH paramVH) {}
  
  public void registerAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver paramAdapterDataObserver)
  {
    this.mObservable.registerObserver(paramAdapterDataObserver);
  }
  
  public void setHasStableIds(boolean paramBoolean)
  {
    if (hasObservers()) {
      throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
    }
    this.mHasStableIds = paramBoolean;
  }
  
  public void unregisterAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver paramAdapterDataObserver)
  {
    this.mObservable.unregisterObserver(paramAdapterDataObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.Adapter
 * JD-Core Version:    0.7.0.1
 */