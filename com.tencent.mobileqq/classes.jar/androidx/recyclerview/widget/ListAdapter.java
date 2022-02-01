package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder>
  extends RecyclerView.Adapter<VH>
{
  final AsyncListDiffer<T> mDiffer;
  private final AsyncListDiffer.ListListener<T> mListener = new ListAdapter.1(this);
  
  protected ListAdapter(@NonNull AsyncDifferConfig<T> paramAsyncDifferConfig)
  {
    this.mDiffer = new AsyncListDiffer(new AdapterListUpdateCallback(this), paramAsyncDifferConfig);
    this.mDiffer.addListListener(this.mListener);
  }
  
  protected ListAdapter(@NonNull DiffUtil.ItemCallback<T> paramItemCallback)
  {
    this.mDiffer = new AsyncListDiffer(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(paramItemCallback).build());
    this.mDiffer.addListListener(this.mListener);
  }
  
  @NonNull
  public List<T> getCurrentList()
  {
    return this.mDiffer.getCurrentList();
  }
  
  protected T getItem(int paramInt)
  {
    return this.mDiffer.getCurrentList().get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.mDiffer.getCurrentList().size();
  }
  
  public void onCurrentListChanged(@NonNull List<T> paramList1, @NonNull List<T> paramList2) {}
  
  public void submitList(@Nullable List<T> paramList)
  {
    this.mDiffer.submitList(paramList);
  }
  
  public void submitList(@Nullable List<T> paramList, @Nullable Runnable paramRunnable)
  {
    this.mDiffer.submitList(paramList, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.ListAdapter
 * JD-Core Version:    0.7.0.1
 */