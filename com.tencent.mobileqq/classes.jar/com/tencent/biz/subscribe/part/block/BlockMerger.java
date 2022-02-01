package com.tencent.biz.subscribe.part.block;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.subscribe.part.BlockPart;
import com.tencent.biz.subscribe.part.block.base.BaseListViewAdapter;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.biz.subscribe.part.block.base.PullLoadMoreAdapter;
import com.tencent.biz.subscribe.part.block.base.PullLoadMoreAdapter.LoadMoreViewHolder;
import com.tencent.biz.subscribe.part.block.base.PullLoadMoreAdapter.RefreshViewHolder;
import com.tencent.biz.subscribe.part.utils.LayoutManagerUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class BlockMerger
  extends PullLoadMoreAdapter<MultiViewBlock>
  implements Application.ActivityLifecycleCallbacks
{
  private static boolean k = false;
  private BlockContainer l;
  private SparseIntArray m = new SparseIntArray();
  private RecyclerView.ViewHolder n;
  private final ConcurrentHashMap<String, BlockMerger.ShareData> o = new ConcurrentHashMap();
  private final CopyOnWriteArrayList<BlockMerger.ShareDataChangeListener> p = new CopyOnWriteArrayList();
  private final ConcurrentHashMap<String, MultiViewBlock> q = new ConcurrentHashMap();
  private BlockPart r;
  private int s = 0;
  private int t = 0;
  private final ViewTreeObserver.OnGlobalLayoutListener u = new BlockMerger.3(this);
  
  public BlockMerger(BlockContainer paramBlockContainer)
  {
    this.l = paramBlockContainer;
    setHasStableIds(true);
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, MultiViewBlock paramMultiViewBlock, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramViewHolder != null) && (paramMultiViewBlock != null) && (paramMultiViewBlock.a(paramViewHolder.getLayoutPosition() - paramMultiViewBlock.C()) == 1)) {
      ((StaggeredGridLayoutManager.LayoutParams)paramLayoutParams).setFullSpan(true);
    }
  }
  
  private void b(MultiViewBlock paramMultiViewBlock, int paramInt)
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      ((MultiViewBlock)localIterator.next()).a(paramMultiViewBlock, paramInt);
    }
  }
  
  private void b(String paramString, BlockMerger.ShareData paramShareData)
  {
    if (this.p.size() > 0)
    {
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext()) {
        ((BlockMerger.ShareDataChangeListener)localIterator.next()).a(paramString, paramShareData);
      }
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.j.size() == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedTryToLoadMore mDataList.size() == 0");
      ((StringBuilder)localObject).append(hashCode());
      QLog.i("CMADebugTAG", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = (MultiViewBlock)this.j.get(this.j.size() - 1);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedTryToLoadMore adapter == null");
      ((StringBuilder)localObject).append(hashCode());
      QLog.i("CMADebugTAG", 2, ((StringBuilder)localObject).toString());
      return;
    }
    if (((MultiViewBlock)localObject).D().b())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedTryToLoadMore is loading:");
      ((StringBuilder)localObject).append(hashCode());
      QLog.i("CMADebugTAG", 2, ((StringBuilder)localObject).toString());
      return;
    }
    if (this.t == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedTryToLoadMore maxCount 0 hashCode:");
      ((StringBuilder)localObject).append(hashCode());
      QLog.i("CMADebugTAG", 2, ((StringBuilder)localObject).toString());
      return;
    }
    int i = LayoutManagerUtils.a(this.h);
    if (i == -1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedTryToLoadMore not renderReady hashCode:");
      ((StringBuilder)localObject).append(hashCode());
      QLog.i("CMADebugTAG", 2, ((StringBuilder)localObject).toString());
      return;
    }
    if (i < ((MultiViewBlock)localObject).getItemCount() - 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedTryToLoadMore enough to scroll hashCode:");
      ((StringBuilder)localObject).append(hashCode());
      QLog.i("CMADebugTAG", 2, ((StringBuilder)localObject).toString());
      return;
    }
    if (s())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedTryToLoadMore invalid hashCode:");
      ((StringBuilder)localObject).append(hashCode());
      QLog.e("CMADebugTAG", 2, ((StringBuilder)localObject).toString());
      return;
    }
    if ((this.h != null) && (!paramBoolean))
    {
      this.s += 1;
      d();
      QLog.i("CMADebugTAG", 1, String.format("isNeedTryToLoadMore try to loadMore Success hashCode:%d", new Object[] { Integer.valueOf(hashCode()) }));
      return;
    }
    this.s = 0;
    QLog.i("CMADebugTAG", 1, String.format("isNeedTryToLoadMore reset hashCode:%d", new Object[] { Integer.valueOf(hashCode()) }));
  }
  
  private boolean s()
  {
    int i = this.s;
    return (i != 0) && (i >= this.t);
  }
  
  public int a(ArrayList<MultiViewBlock> paramArrayList)
  {
    for (;;)
    {
      try
      {
        int i2 = paramArrayList.size();
        int i = 0;
        int j = 0;
        if (i < i2)
        {
          if (ArrayUtils.isOutOfArrayIndex(i, paramArrayList)) {
            return j;
          }
          MultiViewBlock localMultiViewBlock = (MultiViewBlock)paramArrayList.get(i);
          i1 = j;
          if (localMultiViewBlock != null)
          {
            if (!m()) {
              break label179;
            }
            i1 = 1;
            localMultiViewBlock.d(i1 + j);
            j += localMultiViewBlock.getItemCount();
            i1 = j;
            if (k)
            {
              Object localObject = new StringBuilder();
              ((StringBuilder)localObject).append("CMADebugTAG|");
              ((StringBuilder)localObject).append(localMultiViewBlock.getClass().getSimpleName());
              localObject = ((StringBuilder)localObject).toString();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("size:");
              localStringBuilder.append(localMultiViewBlock.getItemCount());
              Log.d((String)localObject, localStringBuilder.toString());
              i1 = j;
            }
          }
          i += 1;
          j = i1;
        }
        else
        {
          return j;
        }
      }
      catch (Exception paramArrayList)
      {
        return 0;
      }
      label179:
      int i1 = 0;
    }
  }
  
  protected RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.j.size() == 0)
    {
      if (this.n == null) {
        this.n = new BlockMerger.PtrDefaultViewHolder(this, new View(paramViewGroup.getContext()));
      }
      return this.n;
    }
    if (paramInt == -99999) {
      return super.onCreateViewHolder(paramViewGroup, paramInt);
    }
    int i1 = this.m.get(paramInt);
    int i = paramInt;
    if (i1 != 0)
    {
      i = 0;
      int j = 0;
      while (i < i1)
      {
        j += ((MultiViewBlock)this.j.get(i)).c();
        i += 1;
      }
      i = paramInt - j;
    }
    if (k)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CMADebugTAG|");
      ((StringBuilder)localObject).append(((MultiViewBlock)this.j.get(i1)).getClass().getSimpleName());
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createItemViewHolder ViewType:");
      localStringBuilder.append(i);
      Log.d((String)localObject, localStringBuilder.toString());
    }
    return ((MultiViewBlock)this.j.get(i1)).onCreateViewHolder(paramViewGroup, i);
  }
  
  public BlockMerger.ShareData a(String paramString)
  {
    return (BlockMerger.ShareData)this.o.get(paramString);
  }
  
  public MultiViewBlock a(int paramInt)
  {
    if (paramInt < c())
    {
      int j = this.j.size();
      int i = paramInt;
      paramInt = 0;
      while (paramInt < j)
      {
        MultiViewBlock localMultiViewBlock = (MultiViewBlock)this.j.get(paramInt);
        int i1 = localMultiViewBlock.getItemCount();
        if (i < i1) {
          return localMultiViewBlock;
        }
        i = Math.max(i - i1, 0);
        paramInt += 1;
      }
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    if (this.j.size() > 0) {
      f().setRefreshing(true);
    }
    int i = 0;
    while (i < this.j.size())
    {
      MultiViewBlock localMultiViewBlock = (MultiViewBlock)this.j.get(i);
      if (localMultiViewBlock.a()) {
        localMultiViewBlock.y();
      }
      i += 1;
    }
    this.s = 0;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    while (i < this.j.size())
    {
      ((MultiViewBlock)this.j.get(i)).a(paramInt1, paramInt2, paramIntent);
      i += 1;
    }
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int j = this.j.size();
    int i = paramInt;
    paramInt = 0;
    while (paramInt < j)
    {
      MultiViewBlock localMultiViewBlock = (MultiViewBlock)this.j.get(paramInt);
      int i1 = localMultiViewBlock.getItemCount();
      if (i < i1)
      {
        localMultiViewBlock.onBindViewHolder(paramViewHolder, i);
        return;
      }
      i = Math.max(i - i1, 0);
      paramInt += 1;
    }
  }
  
  public void a(BlockPart paramBlockPart)
  {
    this.r = paramBlockPart;
  }
  
  public void a(BlockMerger.ShareDataChangeListener paramShareDataChangeListener)
  {
    this.p.add(paramShareDataChangeListener);
    Iterator localIterator = this.o.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramShareDataChangeListener.a(str, (BlockMerger.ShareData)this.o.get(str));
    }
  }
  
  public void a(MultiViewBlock paramMultiViewBlock)
  {
    a(paramMultiViewBlock, -1);
  }
  
  public void a(MultiViewBlock paramMultiViewBlock, int paramInt)
  {
    if ((paramMultiViewBlock != null) && (!this.j.contains(paramMultiViewBlock)))
    {
      int i = paramInt;
      if (paramInt == -1) {
        i = this.j.size();
      }
      if (paramMultiViewBlock.bA_() != null) {
        this.q.put(paramMultiViewBlock.bA_(), paramMultiViewBlock);
      }
      this.j.add(i, paramMultiViewBlock);
      paramMultiViewBlock.a(this);
      paramMultiViewBlock.onAttachedToRecyclerView(f().getRecyclerView());
      b(paramMultiViewBlock, 1);
      a(paramMultiViewBlock);
    }
  }
  
  public void a(String paramString, BlockMerger.ShareData paramShareData)
  {
    if (paramShareData == null)
    {
      QLog.w(getClass().getSimpleName(), 1, "setShareData null");
      return;
    }
    this.o.put(paramString, paramShareData);
    b(paramString, paramShareData);
  }
  
  public MultiViewBlock b(String paramString)
  {
    return (MultiViewBlock)this.q.get(paramString);
  }
  
  public void b(int paramInt)
  {
    this.t = paramInt;
    if (this.h != null) {
      this.h.getViewTreeObserver().addOnGlobalLayoutListener(this.u);
    }
  }
  
  public void b(BlockMerger.ShareDataChangeListener paramShareDataChangeListener)
  {
    this.p.remove(paramShareDataChangeListener);
  }
  
  public int c()
  {
    return a(this.j);
  }
  
  public void d()
  {
    MultiViewBlock localMultiViewBlock = (MultiViewBlock)this.j.get(this.j.size() - 1);
    if (!f().d()) {
      return;
    }
    if (localMultiViewBlock.D().b()) {
      return;
    }
    if (localMultiViewBlock.D().a())
    {
      localMultiViewBlock.D().a(4);
      return;
    }
    if (this.j.size() > 0)
    {
      j();
      localMultiViewBlock.D().a(3);
      localMultiViewBlock.b(localMultiViewBlock.D());
    }
  }
  
  public void e()
  {
    this.l = null;
    this.o.clear();
    this.q.clear();
    this.r = null;
  }
  
  public BlockContainer f()
  {
    return this.l;
  }
  
  public boolean g()
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext()) {
      if (((MultiViewBlock)localIterator.next()).i()) {
        return true;
      }
    }
    return false;
  }
  
  public int getItemCount()
  {
    return c() + k();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((m()) && (paramInt == 0)) {
      return -10000;
    }
    int j = c(paramInt);
    if (j < c())
    {
      int i1 = this.j.size();
      paramInt = 0;
      int i = 0;
      while (paramInt < i1)
      {
        MultiViewBlock localMultiViewBlock = (MultiViewBlock)this.j.get(paramInt);
        int i2 = localMultiViewBlock.getItemCount();
        if (j < i2)
        {
          j = localMultiViewBlock.getItemViewType(j);
          if (k)
          {
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append("CMADebugTAG|");
            ((StringBuilder)localObject).append(localMultiViewBlock.getClass().getSimpleName());
            localObject = ((StringBuilder)localObject).toString();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getItemViewType ViewType:");
            localStringBuilder.append(j);
            Log.d((String)localObject, localStringBuilder.toString());
          }
          if (j >= 0) {
            j += i;
          }
          localMultiViewBlock.g(i);
          this.m.put(j, paramInt);
          return j;
        }
        j = Math.max(j - i2, 0);
        if (localMultiViewBlock.c() != 0)
        {
          i += localMultiViewBlock.c();
          paramInt += 1;
        }
        else
        {
          throw new IllegalArgumentException("HorizontalRVBlock getViewTypeCount() has to be greater than 0");
        }
      }
      return -1;
    }
    return -99999;
  }
  
  public GridLayoutManager.SpanSizeLookup h()
  {
    return new BlockMerger.2(this);
  }
  
  public void i()
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      MultiViewBlock localMultiViewBlock = (MultiViewBlock)localIterator.next();
      if (!localMultiViewBlock.E()) {
        localMultiViewBlock.z();
      }
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    int i = 0;
    while (i < this.j.size())
    {
      ((MultiViewBlock)this.j.get(i)).onActivityDestroyed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    int i = 0;
    while (i < this.j.size())
    {
      ((MultiViewBlock)this.j.get(i)).onActivityPaused(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    int i = 0;
    while (i < this.j.size())
    {
      ((MultiViewBlock)this.j.get(i)).onActivityResumed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    int i = 0;
    while (i < this.j.size())
    {
      ((MultiViewBlock)this.j.get(i)).onActivityStarted(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    int i = 0;
    while (i < this.j.size())
    {
      ((MultiViewBlock)this.j.get(i)).onActivityStopped(paramActivity);
      i += 1;
    }
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    int j = this.j.size();
    int i = 0;
    while (i < j)
    {
      ((MultiViewBlock)this.j.get(i)).onDetachedFromRecyclerView(paramRecyclerView);
      i += 1;
    }
    paramRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.u);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    ViewGroup.LayoutParams localLayoutParams = paramViewHolder.itemView.getLayoutParams();
    boolean bool = localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams;
    if ((bool) && (((paramViewHolder instanceof PullLoadMoreAdapter.LoadMoreViewHolder)) || ((paramViewHolder instanceof PullLoadMoreAdapter.RefreshViewHolder))))
    {
      ((StaggeredGridLayoutManager.LayoutParams)localLayoutParams).setFullSpan(true);
      return;
    }
    int j = c(paramViewHolder.getAdapterPosition());
    if (j < 0) {
      return;
    }
    int i1 = this.j.size();
    int i = 0;
    while (i < i1)
    {
      MultiViewBlock localMultiViewBlock = (MultiViewBlock)this.j.get(i);
      int i2 = localMultiViewBlock.getItemCount();
      if (j < i2)
      {
        if (bool) {
          a(paramViewHolder, localMultiViewBlock, localLayoutParams);
        }
        localMultiViewBlock.onViewAttachedToWindow(paramViewHolder);
        return;
      }
      j = Math.max(j - i2, 0);
      i += 1;
    }
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    int j = c(paramViewHolder.getAdapterPosition());
    if (j < 0) {
      return;
    }
    int i1 = this.j.size();
    int i = 0;
    while (i < i1)
    {
      BaseListViewAdapter localBaseListViewAdapter = (BaseListViewAdapter)this.j.get(i);
      int i2 = localBaseListViewAdapter.getItemCount();
      if (j < i2)
      {
        localBaseListViewAdapter.onViewDetachedFromWindow(paramViewHolder);
        return;
      }
      j = Math.max(j - i2, 0);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.BlockMerger
 * JD-Core Version:    0.7.0.1
 */