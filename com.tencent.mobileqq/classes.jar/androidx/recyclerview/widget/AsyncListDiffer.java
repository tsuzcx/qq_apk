package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class AsyncListDiffer<T>
{
  private static final Executor sMainThreadExecutor = new AsyncListDiffer.MainThreadExecutor();
  final AsyncDifferConfig<T> mConfig;
  @Nullable
  private List<T> mList;
  private final List<AsyncListDiffer.ListListener<T>> mListeners = new CopyOnWriteArrayList();
  Executor mMainThreadExecutor;
  int mMaxScheduledGeneration;
  @NonNull
  private List<T> mReadOnlyList = Collections.emptyList();
  private final ListUpdateCallback mUpdateCallback;
  
  public AsyncListDiffer(@NonNull ListUpdateCallback paramListUpdateCallback, @NonNull AsyncDifferConfig<T> paramAsyncDifferConfig)
  {
    this.mUpdateCallback = paramListUpdateCallback;
    this.mConfig = paramAsyncDifferConfig;
    if (paramAsyncDifferConfig.getMainThreadExecutor() != null)
    {
      this.mMainThreadExecutor = paramAsyncDifferConfig.getMainThreadExecutor();
      return;
    }
    this.mMainThreadExecutor = sMainThreadExecutor;
  }
  
  public AsyncListDiffer(@NonNull RecyclerView.Adapter paramAdapter, @NonNull DiffUtil.ItemCallback<T> paramItemCallback)
  {
    this(new AdapterListUpdateCallback(paramAdapter), new AsyncDifferConfig.Builder(paramItemCallback).build());
  }
  
  private void onCurrentListChanged(@NonNull List<T> paramList, @Nullable Runnable paramRunnable)
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((AsyncListDiffer.ListListener)localIterator.next()).onCurrentListChanged(paramList, this.mReadOnlyList);
    }
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  public void addListListener(@NonNull AsyncListDiffer.ListListener<T> paramListListener)
  {
    this.mListeners.add(paramListListener);
  }
  
  @NonNull
  public List<T> getCurrentList()
  {
    return this.mReadOnlyList;
  }
  
  void latchList(@NonNull List<T> paramList, @NonNull DiffUtil.DiffResult paramDiffResult, @Nullable Runnable paramRunnable)
  {
    List localList = this.mReadOnlyList;
    this.mList = paramList;
    this.mReadOnlyList = Collections.unmodifiableList(paramList);
    paramDiffResult.dispatchUpdatesTo(this.mUpdateCallback);
    onCurrentListChanged(localList, paramRunnable);
  }
  
  public void removeListListener(@NonNull AsyncListDiffer.ListListener<T> paramListListener)
  {
    this.mListeners.remove(paramListListener);
  }
  
  public void submitList(@Nullable List<T> paramList)
  {
    submitList(paramList, null);
  }
  
  public void submitList(@Nullable List<T> paramList, @Nullable Runnable paramRunnable)
  {
    int i = this.mMaxScheduledGeneration + 1;
    this.mMaxScheduledGeneration = i;
    if (paramList == this.mList)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      return;
    }
    List localList = this.mReadOnlyList;
    if (paramList == null)
    {
      i = this.mList.size();
      this.mList = null;
      this.mReadOnlyList = Collections.emptyList();
      this.mUpdateCallback.onRemoved(0, i);
      onCurrentListChanged(localList, paramRunnable);
      return;
    }
    if (this.mList == null)
    {
      this.mList = paramList;
      this.mReadOnlyList = Collections.unmodifiableList(paramList);
      this.mUpdateCallback.onInserted(0, paramList.size());
      onCurrentListChanged(localList, paramRunnable);
      return;
    }
    localList = this.mList;
    this.mConfig.getBackgroundThreadExecutor().execute(new AsyncListDiffer.1(this, localList, paramList, i, paramRunnable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.AsyncListDiffer
 * JD-Core Version:    0.7.0.1
 */