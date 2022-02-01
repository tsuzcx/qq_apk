package com.tencent.biz.richframework.part.block;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.IRefreshViewProvider.OnGetRefreshUpdateListener;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter;
import com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter.LoadMoreViewHolder;
import com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter.RefreshViewHolder;
import com.tencent.biz.richframework.part.utils.ArrayUtils;
import com.tencent.biz.richframework.part.utils.LayoutManagerUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class BlockMerger
  extends PullLoadMoreAdapter<MultiViewBlock>
{
  private static boolean m = false;
  private BlockContainer n;
  private SparseIntArray o = new SparseIntArray();
  private SparseIntArray p = new SparseIntArray();
  private RecyclerView.ViewHolder q;
  private final Map<String, BlockMerger.ShareData> r = new ConcurrentHashMap();
  private final List<BlockMerger.ShareDataChangeListener> s = new CopyOnWriteArrayList();
  private final Map<String, MultiViewBlock> t = new ConcurrentHashMap();
  private BlockPart u;
  private int v = 0;
  private int w = 0;
  private IRefreshViewProvider.OnGetRefreshUpdateListener x;
  private final ViewTreeObserver.OnGlobalLayoutListener y = new BlockMerger.3(this);
  
  public BlockMerger(BlockContainer paramBlockContainer)
  {
    this.n = paramBlockContainer;
    setHasStableIds(true);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 != 0) {
      i = paramInt1 - ((MultiViewBlock)this.mDataList.get(paramInt2)).getViewTypeOffsetStart();
    }
    return i;
  }
  
  private int a(int paramInt1, int paramInt2, MultiViewBlock paramMultiViewBlock, int paramInt3)
  {
    if (h().h())
    {
      paramInt1 = paramMultiViewBlock.getFixedViewTypeOffset();
      paramMultiViewBlock.setViewTypeOffset(paramMultiViewBlock.getFixedViewTypeOffset());
      return paramInt1 + paramInt3;
    }
    if (paramInt3 >= 0) {
      paramInt3 += paramInt1;
    }
    paramMultiViewBlock.setViewTypeOffset(paramInt1);
    return paramInt3;
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, MultiViewBlock paramMultiViewBlock, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramMultiViewBlock.getSpanCount(paramViewHolder.getLayoutPosition() - paramMultiViewBlock.getPositionOffsetStart()) == 1) {
      ((StaggeredGridLayoutManager.LayoutParams)paramLayoutParams).setFullSpan(true);
    }
  }
  
  private boolean a()
  {
    int i = this.v;
    return (i != 0) && (i >= this.w);
  }
  
  private void b(MultiViewBlock paramMultiViewBlock, int paramInt)
  {
    if (h().h())
    {
      int i = paramMultiViewBlock.getFixedViewTypeOffset() / 100000;
      if (RFApplication.isDebug()) {
        if (paramMultiViewBlock.getFixedViewTypeOffset() >= 100000)
        {
          if (this.p.get(i, -1) != -1)
          {
            paramMultiViewBlock = new StringBuilder();
            paramMultiViewBlock.append("the FixViewTypeOffset has been register by");
            paramMultiViewBlock.append(((MultiViewBlock)this.mDataList.get(paramInt)).getClass().getSimpleName());
            throw new RuntimeException(paramMultiViewBlock.toString());
          }
        }
        else {
          throw new RuntimeException("the FixViewTypeOffset must bigger than100000");
        }
      }
      this.p.put(i, paramInt);
    }
  }
  
  private void b(String paramString, BlockMerger.ShareData paramShareData)
  {
    if (this.s.size() > 0)
    {
      Iterator localIterator = this.s.iterator();
      while (localIterator.hasNext()) {
        ((BlockMerger.ShareDataChangeListener)localIterator.next()).handleShareDataChange(paramString, paramShareData);
      }
    }
  }
  
  private void c(MultiViewBlock paramMultiViewBlock, int paramInt)
  {
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext()) {
      ((MultiViewBlock)localIterator.next()).handleBlockChange(paramMultiViewBlock, paramInt);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (this.mDataList.size() == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedTryToLoadMore mDataList.size() == 0");
      ((StringBuilder)localObject).append(hashCode());
      QLog.i("CMADebugTAG", 2, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = (MultiViewBlock)this.mDataList.get(this.mDataList.size() - 1);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedTryToLoadMore adapter == null");
      ((StringBuilder)localObject).append(hashCode());
      QLog.i("CMADebugTAG", 2, ((StringBuilder)localObject).toString());
      return;
    }
    if (this.w == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedTryToLoadMore maxCount 0 hashCode:");
      ((StringBuilder)localObject).append(hashCode());
      QLog.i("CMADebugTAG", 2, ((StringBuilder)localObject).toString());
      return;
    }
    if (((MultiViewBlock)localObject).getLoadInfo().b()) {
      return;
    }
    int i = LayoutManagerUtils.a(this.k);
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
    if (a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedTryToLoadMore invalid hashCode:");
      ((StringBuilder)localObject).append(hashCode());
      QLog.e("CMADebugTAG", 2, ((StringBuilder)localObject).toString());
      return;
    }
    if ((this.k != null) && (!paramBoolean))
    {
      this.v += 1;
      e();
      QLog.i("CMADebugTAG", 1, String.format("isNeedTryToLoadMore try to loadMore Success hashCode:%d", new Object[] { Integer.valueOf(hashCode()) }));
      return;
    }
    this.v = 0;
    QLog.i("CMADebugTAG", 1, String.format("isNeedTryToLoadMore reset hashCode:%d", new Object[] { Integer.valueOf(hashCode()) }));
  }
  
  public int a(ArrayList<MultiViewBlock> paramArrayList)
  {
    for (;;)
    {
      try
      {
        int i1 = paramArrayList.size();
        int i = 0;
        int j = 0;
        if (i < i1)
        {
          if (ArrayUtils.a(i, paramArrayList)) {
            return j;
          }
          MultiViewBlock localMultiViewBlock = (MultiViewBlock)paramArrayList.get(i);
          k = j;
          if (localMultiViewBlock != null)
          {
            if (!p()) {
              break label180;
            }
            k = 1;
            localMultiViewBlock.setGlobalPositionOffset(k + j);
            j += localMultiViewBlock.getItemCount();
            k = j;
            if (m)
            {
              Object localObject = new StringBuilder();
              ((StringBuilder)localObject).append("CMADebugTAG|");
              ((StringBuilder)localObject).append(localMultiViewBlock.getClass().getSimpleName());
              localObject = ((StringBuilder)localObject).toString();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("size:");
              localStringBuilder.append(localMultiViewBlock.getItemCount());
              QLog.d((String)localObject, 1, localStringBuilder.toString());
              k = j;
            }
          }
          i += 1;
          j = k;
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
      label180:
      int k = 0;
    }
  }
  
  protected RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mDataList.size() == 0)
    {
      if (this.q == null) {
        this.q = new BlockMerger.PtrDefaultViewHolder(this, new View(paramViewGroup.getContext()));
      }
      return this.q;
    }
    if (paramInt == -99999) {
      return super.onCreateViewHolder(paramViewGroup, paramInt);
    }
    int i = this.o.get(paramInt);
    paramInt = a(paramInt, i);
    if (m)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CMADebugTAG|");
      ((StringBuilder)localObject).append(((MultiViewBlock)this.mDataList.get(i)).getClass().getSimpleName());
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createItemViewHolder ViewType:");
      localStringBuilder.append(paramInt);
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
    return ((MultiViewBlock)this.mDataList.get(i)).onCreateViewHolder(paramViewGroup, paramInt);
  }
  
  public BlockMerger.ShareData a(String paramString)
  {
    return (BlockMerger.ShareData)this.r.get(paramString);
  }
  
  public MultiViewBlock a(int paramInt)
  {
    if (paramInt < d())
    {
      int j = this.mDataList.size();
      int i = paramInt;
      paramInt = 0;
      while (paramInt < j)
      {
        MultiViewBlock localMultiViewBlock = (MultiViewBlock)this.mDataList.get(paramInt);
        int k = localMultiViewBlock.getItemCount();
        if (i < k) {
          return localMultiViewBlock;
        }
        i = Math.max(i - k, 0);
        paramInt += 1;
      }
    }
    return null;
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int j = this.mDataList.size();
    int i = paramInt;
    paramInt = 0;
    while (paramInt < j)
    {
      MultiViewBlock localMultiViewBlock = (MultiViewBlock)this.mDataList.get(paramInt);
      int k = localMultiViewBlock.getItemCount();
      if (i < k)
      {
        localMultiViewBlock.onBindViewHolder(paramViewHolder, i);
        return;
      }
      i = Math.max(i - k, 0);
      paramInt += 1;
    }
  }
  
  public void a(BlockPart paramBlockPart)
  {
    this.u = paramBlockPart;
  }
  
  public void a(IRefreshViewProvider.OnGetRefreshUpdateListener paramOnGetRefreshUpdateListener)
  {
    this.x = paramOnGetRefreshUpdateListener;
  }
  
  public void a(BlockMerger.ShareDataChangeListener paramShareDataChangeListener)
  {
    this.s.add(paramShareDataChangeListener);
    Iterator localIterator = this.r.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramShareDataChangeListener.handleShareDataChange(str, (BlockMerger.ShareData)this.r.get(str));
    }
  }
  
  public void a(MultiViewBlock paramMultiViewBlock)
  {
    a(paramMultiViewBlock, -1);
  }
  
  public void a(MultiViewBlock paramMultiViewBlock, int paramInt)
  {
    if ((paramMultiViewBlock != null) && (!this.mDataList.contains(paramMultiViewBlock)))
    {
      int i = paramInt;
      if (paramInt == -1) {
        i = this.mDataList.size();
      }
      if (paramMultiViewBlock.getUniqueKey() != null) {
        this.t.put(paramMultiViewBlock.getUniqueKey(), paramMultiViewBlock);
      }
      this.mDataList.add(i, paramMultiViewBlock);
      b(paramMultiViewBlock, i);
      paramMultiViewBlock.setBlockMerger(this);
      paramMultiViewBlock.onAttachedToRecyclerView(h().getRecyclerView());
      c(paramMultiViewBlock, 1);
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
    this.r.put(paramString, paramShareData);
    b(paramString, paramShareData);
  }
  
  public void b()
  {
    super.b();
    if ((this.mDataList.size() > 0) && (h() != null)) {
      h().setRefreshing(true);
    }
    int i = 0;
    while (i < this.mDataList.size())
    {
      MultiViewBlock localMultiViewBlock = (MultiViewBlock)this.mDataList.get(i);
      if (localMultiViewBlock.isEnableRefresh()) {
        localMultiViewBlock.onRefreshData();
      }
      i += 1;
    }
  }
  
  public void b(int paramInt)
  {
    this.w = paramInt;
    if (this.k != null) {
      this.k.getViewTreeObserver().addOnGlobalLayoutListener(this.y);
    }
  }
  
  public void b(BlockMerger.ShareDataChangeListener paramShareDataChangeListener)
  {
    this.s.remove(paramShareDataChangeListener);
  }
  
  public String c()
  {
    IRefreshViewProvider.OnGetRefreshUpdateListener localOnGetRefreshUpdateListener = this.x;
    if (localOnGetRefreshUpdateListener != null) {
      return localOnGetRefreshUpdateListener.a();
    }
    return null;
  }
  
  public int d()
  {
    return a(this.mDataList);
  }
  
  public void e()
  {
    MultiViewBlock localMultiViewBlock = (MultiViewBlock)this.mDataList.get(this.mDataList.size() - 1);
    if (!h().f()) {
      return;
    }
    if (localMultiViewBlock.getLoadInfo().b()) {
      return;
    }
    if (localMultiViewBlock.getLoadInfo().a())
    {
      localMultiViewBlock.getLoadInfo().a(4);
      return;
    }
    if (localMultiViewBlock.getDataList().size() > 0)
    {
      m();
      localMultiViewBlock.getLoadInfo().a(3);
      localMultiViewBlock.loadMoreData(localMultiViewBlock.getLoadInfo());
    }
  }
  
  public BlockPart f()
  {
    return this.u;
  }
  
  public void g()
  {
    this.n = null;
    this.r.clear();
    this.t.clear();
    this.u = null;
  }
  
  public int getDataNumber()
  {
    return d();
  }
  
  public int getItemCount()
  {
    return d() + n();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((p()) && (paramInt == 0)) {
      return -10000;
    }
    int j = c(paramInt);
    if (j < d())
    {
      int k = this.mDataList.size();
      paramInt = 0;
      int i = 0;
      while (paramInt < k)
      {
        MultiViewBlock localMultiViewBlock = (MultiViewBlock)this.mDataList.get(paramInt);
        int i1 = localMultiViewBlock.getItemCount();
        if (j < i1)
        {
          j = localMultiViewBlock.getItemViewType(j);
          if (m)
          {
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append("CMADebugTAG|");
            ((StringBuilder)localObject).append(localMultiViewBlock.getClass().getSimpleName());
            localObject = ((StringBuilder)localObject).toString();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getItemViewType ViewType:");
            localStringBuilder.append(j);
            QLog.d((String)localObject, 1, localStringBuilder.toString());
          }
          i = a(i, -1, localMultiViewBlock, j);
          this.o.put(i, paramInt);
          return i;
        }
        j = Math.max(j - i1, 0);
        if (localMultiViewBlock.getViewTypeCount() != 0)
        {
          i += localMultiViewBlock.getViewTypeCount();
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
  
  public BlockContainer h()
  {
    return this.n;
  }
  
  public boolean i()
  {
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext()) {
      if (((MultiViewBlock)localIterator.next()).onBackEvent()) {
        return true;
      }
    }
    return false;
  }
  
  public GridLayoutManager.SpanSizeLookup j()
  {
    return new BlockMerger.2(this);
  }
  
  public void k()
  {
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext())
    {
      MultiViewBlock localMultiViewBlock = (MultiViewBlock)localIterator.next();
      if (!localMultiViewBlock.isLazyLoad()) {
        localMultiViewBlock.onInit();
      }
    }
  }
  
  public void l()
  {
    this.v = 0;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((MultiViewBlock)this.mDataList.get(i)).onActivityDestroyed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((MultiViewBlock)this.mDataList.get(i)).onActivityPaused(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((MultiViewBlock)this.mDataList.get(i)).onActivityResult(paramInt1, paramInt2, paramIntent);
      i += 1;
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((MultiViewBlock)this.mDataList.get(i)).onActivityResumed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivitySaveInstanceState(paramActivity, paramBundle);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    super.onActivityStarted(paramActivity);
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((MultiViewBlock)this.mDataList.get(i)).onActivityStarted(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    int i = 0;
    while (i < this.mDataList.size())
    {
      ((MultiViewBlock)this.mDataList.get(i)).onActivityStopped(paramActivity);
      i += 1;
    }
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
  }
  
  public void onDetachedFromRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    int j = this.mDataList.size();
    int i = 0;
    while (i < j)
    {
      ((MultiViewBlock)this.mDataList.get(i)).onDetachedFromRecyclerView(paramRecyclerView);
      i += 1;
    }
    paramRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.y);
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
    int k = this.mDataList.size();
    int i = 0;
    while (i < k)
    {
      MultiViewBlock localMultiViewBlock = (MultiViewBlock)this.mDataList.get(i);
      int i1 = localMultiViewBlock.getItemCount();
      if (j < i1)
      {
        if (bool) {
          a(paramViewHolder, localMultiViewBlock, localLayoutParams);
        }
        localMultiViewBlock.onViewAttachedToWindow(paramViewHolder);
        return;
      }
      j = Math.max(j - i1, 0);
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
    int k = this.mDataList.size();
    int i = 0;
    while (i < k)
    {
      BaseListViewAdapter localBaseListViewAdapter = (BaseListViewAdapter)this.mDataList.get(i);
      int i1 = localBaseListViewAdapter.getItemCount();
      if (j < i1)
      {
        localBaseListViewAdapter.onViewDetachedFromWindow(paramViewHolder);
        return;
      }
      j = Math.max(j - i1, 0);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.BlockMerger
 * JD-Core Version:    0.7.0.1
 */