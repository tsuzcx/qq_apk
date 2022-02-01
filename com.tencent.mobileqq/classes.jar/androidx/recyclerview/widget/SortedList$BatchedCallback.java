package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

public class SortedList$BatchedCallback<T2>
  extends SortedList.Callback<T2>
{
  private final BatchingListUpdateCallback mBatchingListUpdateCallback;
  final SortedList.Callback<T2> mWrappedCallback;
  
  public SortedList$BatchedCallback(SortedList.Callback<T2> paramCallback)
  {
    this.mWrappedCallback = paramCallback;
    this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(this.mWrappedCallback);
  }
  
  public boolean areContentsTheSame(T2 paramT21, T2 paramT22)
  {
    return this.mWrappedCallback.areContentsTheSame(paramT21, paramT22);
  }
  
  public boolean areItemsTheSame(T2 paramT21, T2 paramT22)
  {
    return this.mWrappedCallback.areItemsTheSame(paramT21, paramT22);
  }
  
  public int compare(T2 paramT21, T2 paramT22)
  {
    return this.mWrappedCallback.compare(paramT21, paramT22);
  }
  
  public void dispatchLastEvent()
  {
    this.mBatchingListUpdateCallback.dispatchLastEvent();
  }
  
  @Nullable
  public Object getChangePayload(T2 paramT21, T2 paramT22)
  {
    return this.mWrappedCallback.getChangePayload(paramT21, paramT22);
  }
  
  public void onChanged(int paramInt1, int paramInt2)
  {
    this.mBatchingListUpdateCallback.onChanged(paramInt1, paramInt2, null);
  }
  
  public void onChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    this.mBatchingListUpdateCallback.onChanged(paramInt1, paramInt2, paramObject);
  }
  
  public void onInserted(int paramInt1, int paramInt2)
  {
    this.mBatchingListUpdateCallback.onInserted(paramInt1, paramInt2);
  }
  
  public void onMoved(int paramInt1, int paramInt2)
  {
    this.mBatchingListUpdateCallback.onMoved(paramInt1, paramInt2);
  }
  
  public void onRemoved(int paramInt1, int paramInt2)
  {
    this.mBatchingListUpdateCallback.onRemoved(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.SortedList.BatchedCallback
 * JD-Core Version:    0.7.0.1
 */