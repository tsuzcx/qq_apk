package androidx.recyclerview.widget;

import androidx.annotation.Nullable;
import androidx.core.os.TraceCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class GapWorker
  implements Runnable
{
  static final ThreadLocal<GapWorker> sGapWorker = new ThreadLocal();
  static Comparator<GapWorker.Task> sTaskComparator = new GapWorker.1();
  long mFrameIntervalNs;
  long mPostTimeNs;
  ArrayList<RecyclerView> mRecyclerViews = new ArrayList();
  private ArrayList<GapWorker.Task> mTasks = new ArrayList();
  
  private void buildTaskList()
  {
    int m = this.mRecyclerViews.size();
    int i = 0;
    Object localObject;
    int k;
    for (int j = 0; i < m; j = k)
    {
      localObject = (RecyclerView)this.mRecyclerViews.get(i);
      k = j;
      if (((RecyclerView)localObject).getWindowVisibility() == 0)
      {
        ((RecyclerView)localObject).mPrefetchRegistry.collectPrefetchPositionsFromView((RecyclerView)localObject, false);
        k = j + ((RecyclerView)localObject).mPrefetchRegistry.mCount;
      }
      i += 1;
    }
    this.mTasks.ensureCapacity(j);
    j = 0;
    i = 0;
    while (j < m)
    {
      RecyclerView localRecyclerView = (RecyclerView)this.mRecyclerViews.get(j);
      if (localRecyclerView.getWindowVisibility() == 0)
      {
        GapWorker.LayoutPrefetchRegistryImpl localLayoutPrefetchRegistryImpl = localRecyclerView.mPrefetchRegistry;
        int n = Math.abs(localLayoutPrefetchRegistryImpl.mPrefetchDx) + Math.abs(localLayoutPrefetchRegistryImpl.mPrefetchDy);
        k = 0;
        while (k < localLayoutPrefetchRegistryImpl.mCount * 2)
        {
          if (i >= this.mTasks.size())
          {
            localObject = new GapWorker.Task();
            this.mTasks.add(localObject);
          }
          else
          {
            localObject = (GapWorker.Task)this.mTasks.get(i);
          }
          int i1 = localLayoutPrefetchRegistryImpl.mPrefetchArray[(k + 1)];
          boolean bool;
          if (i1 <= n) {
            bool = true;
          } else {
            bool = false;
          }
          ((GapWorker.Task)localObject).immediate = bool;
          ((GapWorker.Task)localObject).viewVelocity = n;
          ((GapWorker.Task)localObject).distanceToItem = i1;
          ((GapWorker.Task)localObject).view = localRecyclerView;
          ((GapWorker.Task)localObject).position = localLayoutPrefetchRegistryImpl.mPrefetchArray[k];
          i += 1;
          k += 2;
        }
      }
      j += 1;
    }
    Collections.sort(this.mTasks, sTaskComparator);
  }
  
  private void flushTaskWithDeadline(GapWorker.Task paramTask, long paramLong)
  {
    long l;
    if (paramTask.immediate) {
      l = 9223372036854775807L;
    } else {
      l = paramLong;
    }
    paramTask = prefetchPositionWithDeadline(paramTask.view, paramTask.position, l);
    if ((paramTask != null) && (paramTask.mNestedRecyclerView != null) && (paramTask.isBound()) && (!paramTask.isInvalid())) {
      prefetchInnerRecyclerViewWithDeadline((RecyclerView)paramTask.mNestedRecyclerView.get(), paramLong);
    }
  }
  
  private void flushTasksWithDeadline(long paramLong)
  {
    int i = 0;
    while (i < this.mTasks.size())
    {
      GapWorker.Task localTask = (GapWorker.Task)this.mTasks.get(i);
      if (localTask.view == null) {
        return;
      }
      flushTaskWithDeadline(localTask, paramLong);
      localTask.clear();
      i += 1;
    }
  }
  
  static boolean isPrefetchPositionAttached(RecyclerView paramRecyclerView, int paramInt)
  {
    int j = paramRecyclerView.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramRecyclerView.mChildHelper.getUnfilteredChildAt(i));
      if ((localViewHolder.mPosition == paramInt) && (!localViewHolder.isInvalid())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void prefetchInnerRecyclerViewWithDeadline(@Nullable RecyclerView paramRecyclerView, long paramLong)
  {
    if (paramRecyclerView == null) {
      return;
    }
    if ((paramRecyclerView.mDataSetHasChangedAfterLayout) && (paramRecyclerView.mChildHelper.getUnfilteredChildCount() != 0)) {
      paramRecyclerView.removeAndRecycleViews();
    }
    GapWorker.LayoutPrefetchRegistryImpl localLayoutPrefetchRegistryImpl = paramRecyclerView.mPrefetchRegistry;
    localLayoutPrefetchRegistryImpl.collectPrefetchPositionsFromView(paramRecyclerView, true);
    if (localLayoutPrefetchRegistryImpl.mCount != 0) {
      try
      {
        TraceCompat.beginSection("RV Nested Prefetch");
        paramRecyclerView.mState.prepareForNestedPrefetch(paramRecyclerView.mAdapter);
        int i = 0;
        while (i < localLayoutPrefetchRegistryImpl.mCount * 2)
        {
          prefetchPositionWithDeadline(paramRecyclerView, localLayoutPrefetchRegistryImpl.mPrefetchArray[i], paramLong);
          i += 2;
        }
        return;
      }
      finally
      {
        TraceCompat.endSection();
      }
    }
  }
  
  private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView paramRecyclerView, int paramInt, long paramLong)
  {
    if (isPrefetchPositionAttached(paramRecyclerView, paramInt)) {
      return null;
    }
    RecyclerView.Recycler localRecycler = paramRecyclerView.mRecycler;
    try
    {
      paramRecyclerView.onEnterLayoutOrScroll();
      RecyclerView.ViewHolder localViewHolder = localRecycler.tryGetViewHolderForPositionByDeadline(paramInt, false, paramLong);
      if (localViewHolder != null) {
        if ((localViewHolder.isBound()) && (!localViewHolder.isInvalid())) {
          localRecycler.recycleView(localViewHolder.itemView);
        } else {
          localRecycler.addViewHolderToRecycledViewPool(localViewHolder, false);
        }
      }
      return localViewHolder;
    }
    finally
    {
      paramRecyclerView.onExitLayoutOrScroll(false);
    }
  }
  
  public void add(RecyclerView paramRecyclerView)
  {
    this.mRecyclerViews.add(paramRecyclerView);
  }
  
  void postFromTraversal(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramRecyclerView.isAttachedToWindow()) && (this.mPostTimeNs == 0L))
    {
      this.mPostTimeNs = paramRecyclerView.getNanoTime();
      paramRecyclerView.post(this);
    }
    paramRecyclerView.mPrefetchRegistry.setPrefetchVector(paramInt1, paramInt2);
  }
  
  void prefetch(long paramLong)
  {
    buildTaskList();
    flushTasksWithDeadline(paramLong);
  }
  
  public void remove(RecyclerView paramRecyclerView)
  {
    this.mRecyclerViews.remove(paramRecyclerView);
  }
  
  public void run()
  {
    try
    {
      TraceCompat.beginSection("RV Prefetch");
      boolean bool = this.mRecyclerViews.isEmpty();
      if (!bool) {
        break label27;
      }
    }
    finally
    {
      for (;;)
      {
        label27:
        int j;
        int i;
        RecyclerView localRecyclerView;
        long l2;
        this.mPostTimeNs = 0L;
        TraceCompat.endSection();
        for (;;)
        {
          throw localObject;
        }
        label130:
        i += 1;
        long l1 = l2;
        continue;
        if (l1 != 0L) {}
      }
    }
    this.mPostTimeNs = 0L;
    TraceCompat.endSection();
    return;
    j = this.mRecyclerViews.size();
    i = 0;
    l1 = 0L;
    if (i < j)
    {
      localRecyclerView = (RecyclerView)this.mRecyclerViews.get(i);
      l2 = l1;
      if (localRecyclerView.getWindowVisibility() == 0)
      {
        l2 = Math.max(localRecyclerView.getDrawingTime(), l1);
        break label130;
        prefetch(TimeUnit.MILLISECONDS.toNanos(l1) + this.mFrameIntervalNs);
        this.mPostTimeNs = 0L;
        TraceCompat.endSection();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.GapWorker
 * JD-Core Version:    0.7.0.1
 */