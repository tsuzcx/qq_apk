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
    int j = 0;
    int i = 0;
    Object localObject;
    if (j < m)
    {
      localObject = (RecyclerView)this.mRecyclerViews.get(j);
      if (((RecyclerView)localObject).getWindowVisibility() != 0) {
        break label292;
      }
      ((RecyclerView)localObject).mPrefetchRegistry.collectPrefetchPositionsFromView((RecyclerView)localObject, false);
      i = ((RecyclerView)localObject).mPrefetchRegistry.mCount + i;
    }
    label272:
    label292:
    for (;;)
    {
      j += 1;
      break;
      this.mTasks.ensureCapacity(i);
      j = 0;
      i = 0;
      RecyclerView localRecyclerView;
      if (j < m)
      {
        localRecyclerView = (RecyclerView)this.mRecyclerViews.get(j);
        if (localRecyclerView.getWindowVisibility() == 0) {}
      }
      for (;;)
      {
        j += 1;
        break;
        GapWorker.LayoutPrefetchRegistryImpl localLayoutPrefetchRegistryImpl = localRecyclerView.mPrefetchRegistry;
        int n = Math.abs(localLayoutPrefetchRegistryImpl.mPrefetchDx) + Math.abs(localLayoutPrefetchRegistryImpl.mPrefetchDy);
        int k = 0;
        if (k < localLayoutPrefetchRegistryImpl.mCount * 2)
        {
          label184:
          int i1;
          if (i >= this.mTasks.size())
          {
            localObject = new GapWorker.Task();
            this.mTasks.add(localObject);
            i1 = localLayoutPrefetchRegistryImpl.mPrefetchArray[(k + 1)];
            if (i1 > n) {
              break label272;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            ((GapWorker.Task)localObject).immediate = bool;
            ((GapWorker.Task)localObject).viewVelocity = n;
            ((GapWorker.Task)localObject).distanceToItem = i1;
            ((GapWorker.Task)localObject).view = localRecyclerView;
            ((GapWorker.Task)localObject).position = localLayoutPrefetchRegistryImpl.mPrefetchArray[k];
            i += 1;
            k += 2;
            break;
            localObject = (GapWorker.Task)this.mTasks.get(i);
            break label184;
          }
          Collections.sort(this.mTasks, sTaskComparator);
          return;
        }
      }
    }
  }
  
  private void flushTaskWithDeadline(GapWorker.Task paramTask, long paramLong)
  {
    if (paramTask.immediate) {}
    for (long l = 9223372036854775807L;; l = paramLong)
    {
      paramTask = prefetchPositionWithDeadline(paramTask.view, paramTask.position, l);
      if ((paramTask != null) && (paramTask.mNestedRecyclerView != null) && (paramTask.isBound()) && (!paramTask.isInvalid())) {
        prefetchInnerRecyclerViewWithDeadline((RecyclerView)paramTask.mNestedRecyclerView.get(), paramLong);
      }
      return;
    }
  }
  
  private void flushTasksWithDeadline(long paramLong)
  {
    int i = 0;
    for (;;)
    {
      GapWorker.Task localTask;
      if (i < this.mTasks.size())
      {
        localTask = (GapWorker.Task)this.mTasks.get(i);
        if (localTask.view != null) {}
      }
      else
      {
        return;
      }
      flushTaskWithDeadline(localTask, paramLong);
      localTask.clear();
      i += 1;
    }
  }
  
  static boolean isPrefetchPositionAttached(RecyclerView paramRecyclerView, int paramInt)
  {
    boolean bool2 = false;
    int j = paramRecyclerView.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramRecyclerView.mChildHelper.getUnfilteredChildAt(i));
        if ((localViewHolder.mPosition == paramInt) && (!localViewHolder.isInvalid())) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void prefetchInnerRecyclerViewWithDeadline(@Nullable RecyclerView paramRecyclerView, long paramLong)
  {
    if (paramRecyclerView == null) {}
    GapWorker.LayoutPrefetchRegistryImpl localLayoutPrefetchRegistryImpl;
    do
    {
      return;
      if ((paramRecyclerView.mDataSetHasChangedAfterLayout) && (paramRecyclerView.mChildHelper.getUnfilteredChildCount() != 0)) {
        paramRecyclerView.removeAndRecycleViews();
      }
      localLayoutPrefetchRegistryImpl = paramRecyclerView.mPrefetchRegistry;
      localLayoutPrefetchRegistryImpl.collectPrefetchPositionsFromView(paramRecyclerView, true);
    } while (localLayoutPrefetchRegistryImpl.mCount == 0);
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
  
  /* Error */
  private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView paramRecyclerView, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: invokestatic 215	androidx/recyclerview/widget/GapWorker:isPrefetchPositionAttached	(Landroidx/recyclerview/widget/RecyclerView;I)Z
    //   5: ifeq +5 -> 10
    //   8: aconst_null
    //   9: areturn
    //   10: aload_1
    //   11: getfield 219	androidx/recyclerview/widget/RecyclerView:mRecycler	Landroidx/recyclerview/widget/RecyclerView$Recycler;
    //   14: astore 5
    //   16: aload_1
    //   17: invokevirtual 222	androidx/recyclerview/widget/RecyclerView:onEnterLayoutOrScroll	()V
    //   20: aload 5
    //   22: iload_2
    //   23: iconst_0
    //   24: lload_3
    //   25: invokevirtual 228	androidx/recyclerview/widget/RecyclerView$Recycler:tryGetViewHolderForPositionByDeadline	(IZJ)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    //   28: astore 6
    //   30: aload 6
    //   32: ifnull +29 -> 61
    //   35: aload 6
    //   37: invokevirtual 139	androidx/recyclerview/widget/RecyclerView$ViewHolder:isBound	()Z
    //   40: ifeq +29 -> 69
    //   43: aload 6
    //   45: invokevirtual 142	androidx/recyclerview/widget/RecyclerView$ViewHolder:isInvalid	()Z
    //   48: ifne +21 -> 69
    //   51: aload 5
    //   53: aload 6
    //   55: getfield 232	androidx/recyclerview/widget/RecyclerView$ViewHolder:itemView	Landroid/view/View;
    //   58: invokevirtual 236	androidx/recyclerview/widget/RecyclerView$Recycler:recycleView	(Landroid/view/View;)V
    //   61: aload_1
    //   62: iconst_0
    //   63: invokevirtual 240	androidx/recyclerview/widget/RecyclerView:onExitLayoutOrScroll	(Z)V
    //   66: aload 6
    //   68: areturn
    //   69: aload 5
    //   71: aload 6
    //   73: iconst_0
    //   74: invokevirtual 244	androidx/recyclerview/widget/RecyclerView$Recycler:addViewHolderToRecycledViewPool	(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Z)V
    //   77: goto -16 -> 61
    //   80: astore 5
    //   82: aload_1
    //   83: iconst_0
    //   84: invokevirtual 240	androidx/recyclerview/widget/RecyclerView:onExitLayoutOrScroll	(Z)V
    //   87: aload 5
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	GapWorker
    //   0	90	1	paramRecyclerView	RecyclerView
    //   0	90	2	paramInt	int
    //   0	90	3	paramLong	long
    //   14	56	5	localRecycler	RecyclerView.Recycler
    //   80	8	5	localObject	Object
    //   28	44	6	localViewHolder	RecyclerView.ViewHolder
    // Exception table:
    //   from	to	target	type
    //   16	30	80	finally
    //   35	61	80	finally
    //   69	77	80	finally
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
    for (;;)
    {
      try
      {
        TraceCompat.beginSection("RV Prefetch");
        boolean bool = this.mRecyclerViews.isEmpty();
        if (bool) {
          return;
        }
        int j = this.mRecyclerViews.size();
        int i = 0;
        long l = 0L;
        if (i < j)
        {
          RecyclerView localRecyclerView = (RecyclerView)this.mRecyclerViews.get(i);
          if (localRecyclerView.getWindowVisibility() == 0)
          {
            l = Math.max(localRecyclerView.getDrawingTime(), l);
            i += 1;
          }
        }
        else
        {
          if (l == 0L) {
            return;
          }
          prefetch(TimeUnit.MILLISECONDS.toNanos(l) + this.mFrameIntervalNs);
          return;
        }
      }
      finally
      {
        this.mPostTimeNs = 0L;
        TraceCompat.endSection();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.GapWorker
 * JD-Core Version:    0.7.0.1
 */