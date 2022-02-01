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
  private static boolean jdField_a_of_type_Boolean = false;
  private int jdField_a_of_type_Int = 0;
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private final ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new BlockMerger.3(this);
  private BlockPart jdField_a_of_type_ComTencentBizSubscribePartBlockPart;
  private BlockContainer jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer;
  private final ConcurrentHashMap<String, BlockMerger.ShareData> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final CopyOnWriteArrayList<BlockMerger.ShareDataChangeListener> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private int jdField_b_of_type_Int = 0;
  private final ConcurrentHashMap<String, MultiViewBlock> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public BlockMerger(BlockContainer paramBlockContainer)
  {
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer = paramBlockContainer;
    setHasStableIds(true);
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, MultiViewBlock paramMultiViewBlock, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramViewHolder != null) && (paramMultiViewBlock != null) && (paramMultiViewBlock.a(paramViewHolder.getLayoutPosition() - paramMultiViewBlock.c()) == 1)) {
      ((StaggeredGridLayoutManager.LayoutParams)paramLayoutParams).setFullSpan(true);
    }
  }
  
  private void b(MultiViewBlock paramMultiViewBlock, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((MultiViewBlock)localIterator.next()).a(paramMultiViewBlock, paramInt);
    }
  }
  
  private void b(String paramString, BlockMerger.ShareData paramShareData)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        ((BlockMerger.ShareDataChangeListener)localIterator.next()).a(paramString, paramShareData);
      }
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedTryToLoadMore mDataList.size() == 0");
      ((StringBuilder)localObject).append(hashCode());
      QLog.i("CMADebugTAG", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = (MultiViewBlock)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedTryToLoadMore adapter == null");
      ((StringBuilder)localObject).append(hashCode());
      QLog.i("CMADebugTAG", 2, ((StringBuilder)localObject).toString());
      return;
    }
    if (((MultiViewBlock)localObject).a().b())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedTryToLoadMore is loading:");
      ((StringBuilder)localObject).append(hashCode());
      QLog.i("CMADebugTAG", 2, ((StringBuilder)localObject).toString());
      return;
    }
    if (this.jdField_b_of_type_Int == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedTryToLoadMore maxCount 0 hashCode:");
      ((StringBuilder)localObject).append(hashCode());
      QLog.i("CMADebugTAG", 2, ((StringBuilder)localObject).toString());
      return;
    }
    int i = LayoutManagerUtils.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
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
    if (f())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedTryToLoadMore invalid hashCode:");
      ((StringBuilder)localObject).append(hashCode());
      QLog.e("CMADebugTAG", 2, ((StringBuilder)localObject).toString());
      return;
    }
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) && (!paramBoolean))
    {
      this.jdField_a_of_type_Int += 1;
      c();
      QLog.i("CMADebugTAG", 1, String.format("isNeedTryToLoadMore try to loadMore Success hashCode:%d", new Object[] { Integer.valueOf(hashCode()) }));
      return;
    }
    this.jdField_a_of_type_Int = 0;
    QLog.i("CMADebugTAG", 1, String.format("isNeedTryToLoadMore reset hashCode:%d", new Object[] { Integer.valueOf(hashCode()) }));
  }
  
  private boolean f()
  {
    int i = this.jdField_a_of_type_Int;
    return (i != 0) && (i >= this.jdField_b_of_type_Int);
  }
  
  public int a()
  {
    return a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public int a(ArrayList<MultiViewBlock> paramArrayList)
  {
    for (;;)
    {
      try
      {
        int m = paramArrayList.size();
        int i = 0;
        int j = 0;
        if (i < m)
        {
          if (ArrayUtils.a(i, paramArrayList)) {
            return j;
          }
          MultiViewBlock localMultiViewBlock = (MultiViewBlock)paramArrayList.get(i);
          k = j;
          if (localMultiViewBlock != null)
          {
            if (!b()) {
              break label178;
            }
            k = 1;
            localMultiViewBlock.c(k + j);
            j += localMultiViewBlock.getItemCount();
            k = j;
            if (jdField_a_of_type_Boolean)
            {
              Object localObject = new StringBuilder();
              ((StringBuilder)localObject).append("CMADebugTAG|");
              ((StringBuilder)localObject).append(localMultiViewBlock.getClass().getSimpleName());
              localObject = ((StringBuilder)localObject).toString();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("size:");
              localStringBuilder.append(localMultiViewBlock.getItemCount());
              Log.d((String)localObject, localStringBuilder.toString());
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
      label178:
      int k = 0;
    }
  }
  
  public GridLayoutManager.SpanSizeLookup a()
  {
    return new BlockMerger.2(this);
  }
  
  protected RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = new BlockMerger.PtrDefaultViewHolder(this, new View(paramViewGroup.getContext()));
      }
      return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    }
    if (paramInt == -99999) {
      return super.onCreateViewHolder(paramViewGroup, paramInt);
    }
    int k = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt);
    int i = paramInt;
    if (k != 0)
    {
      i = 0;
      int j = 0;
      while (i < k)
      {
        j += ((MultiViewBlock)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
        i += 1;
      }
      i = paramInt - j;
    }
    if (jdField_a_of_type_Boolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CMADebugTAG|");
      ((StringBuilder)localObject).append(((MultiViewBlock)this.jdField_a_of_type_JavaUtilArrayList.get(k)).getClass().getSimpleName());
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createItemViewHolder ViewType:");
      localStringBuilder.append(i);
      Log.d((String)localObject, localStringBuilder.toString());
    }
    return ((MultiViewBlock)this.jdField_a_of_type_JavaUtilArrayList.get(k)).onCreateViewHolder(paramViewGroup, i);
  }
  
  public BlockContainer a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer;
  }
  
  public BlockMerger.ShareData a(String paramString)
  {
    return (BlockMerger.ShareData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public MultiViewBlock a(int paramInt)
  {
    if (paramInt < a())
    {
      int j = this.jdField_a_of_type_JavaUtilArrayList.size();
      int i = paramInt;
      paramInt = 0;
      while (paramInt < j)
      {
        MultiViewBlock localMultiViewBlock = (MultiViewBlock)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
  
  public MultiViewBlock a(String paramString)
  {
    return (MultiViewBlock)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((MultiViewBlock)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramInt1, paramInt2, paramIntent);
      i += 1;
    }
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = paramInt;
    paramInt = 0;
    while (paramInt < j)
    {
      MultiViewBlock localMultiViewBlock = (MultiViewBlock)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockPart = paramBlockPart;
  }
  
  public void a(BlockMerger.ShareDataChangeListener paramShareDataChangeListener)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramShareDataChangeListener);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramShareDataChangeListener.a(str, (BlockMerger.ShareData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str));
    }
  }
  
  public void a(MultiViewBlock paramMultiViewBlock)
  {
    a(paramMultiViewBlock, -1);
  }
  
  public void a(MultiViewBlock paramMultiViewBlock, int paramInt)
  {
    if ((paramMultiViewBlock != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramMultiViewBlock)))
    {
      int i = paramInt;
      if (paramInt == -1) {
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
      }
      if (paramMultiViewBlock.a() != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramMultiViewBlock.a(), paramMultiViewBlock);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(i, paramMultiViewBlock);
      paramMultiViewBlock.a(this);
      paramMultiViewBlock.onAttachedToRecyclerView(a().a());
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
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramShareData);
    b(paramString, paramShareData);
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((MultiViewBlock)localIterator.next()).b()) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      a().setRefreshing(true);
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      MultiViewBlock localMultiViewBlock = (MultiViewBlock)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localMultiViewBlock.a()) {
        localMultiViewBlock.o();
      }
      i += 1;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public void b(BlockMerger.ShareDataChangeListener paramShareDataChangeListener)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramShareDataChangeListener);
  }
  
  public void c()
  {
    MultiViewBlock localMultiViewBlock = (MultiViewBlock)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (!a().b()) {
      return;
    }
    if (localMultiViewBlock.a().b()) {
      return;
    }
    if (localMultiViewBlock.a().a())
    {
      localMultiViewBlock.a().a(4);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      f();
      localMultiViewBlock.a().a(3);
      localMultiViewBlock.b(localMultiViewBlock.a());
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockPart = null;
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      MultiViewBlock localMultiViewBlock = (MultiViewBlock)localIterator.next();
      if (!localMultiViewBlock.e()) {
        localMultiViewBlock.p();
      }
    }
  }
  
  public int getItemCount()
  {
    return a() + b();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((b()) && (paramInt == 0)) {
      return -10000;
    }
    int j = a(paramInt);
    if (j < a())
    {
      int k = this.jdField_a_of_type_JavaUtilArrayList.size();
      paramInt = 0;
      int i = 0;
      while (paramInt < k)
      {
        MultiViewBlock localMultiViewBlock = (MultiViewBlock)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        int m = localMultiViewBlock.getItemCount();
        if (j < m)
        {
          j = localMultiViewBlock.getItemViewType(j);
          if (jdField_a_of_type_Boolean)
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
          localMultiViewBlock.d(i);
          this.jdField_a_of_type_AndroidUtilSparseIntArray.put(j, paramInt);
          return j;
        }
        j = Math.max(j - m, 0);
        if (localMultiViewBlock.a() != 0)
        {
          i += localMultiViewBlock.a();
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
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((MultiViewBlock)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityDestroyed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((MultiViewBlock)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityPaused(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((MultiViewBlock)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityResumed(paramActivity);
      i += 1;
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((MultiViewBlock)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityStarted(paramActivity);
      i += 1;
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((MultiViewBlock)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityStopped(paramActivity);
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
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((MultiViewBlock)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onDetachedFromRecyclerView(paramRecyclerView);
      i += 1;
    }
    paramRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
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
    int j = a(paramViewHolder.getAdapterPosition());
    if (j < 0) {
      return;
    }
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < k)
    {
      MultiViewBlock localMultiViewBlock = (MultiViewBlock)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      int m = localMultiViewBlock.getItemCount();
      if (j < m)
      {
        if (bool) {
          a(paramViewHolder, localMultiViewBlock, localLayoutParams);
        }
        localMultiViewBlock.onViewAttachedToWindow(paramViewHolder);
        return;
      }
      j = Math.max(j - m, 0);
      i += 1;
    }
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    int j = a(paramViewHolder.getAdapterPosition());
    if (j < 0) {
      return;
    }
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < k)
    {
      BaseListViewAdapter localBaseListViewAdapter = (BaseListViewAdapter)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      int m = localBaseListViewAdapter.getItemCount();
      if (j < m)
      {
        localBaseListViewAdapter.onViewDetachedFromWindow(paramViewHolder);
        return;
      }
      j = Math.max(j - m, 0);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.BlockMerger
 * JD-Core Version:    0.7.0.1
 */