package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RecyclerView$Recycler
{
  static final int DEFAULT_CACHE_SIZE = 2;
  final ArrayList<RecyclerView.ViewHolder> mAttachedScrap = new ArrayList();
  final ArrayList<RecyclerView.ViewHolder> mCachedViews = new ArrayList();
  ArrayList<RecyclerView.ViewHolder> mChangedScrap = null;
  RecyclerView.RecycledViewPool mRecyclerPool;
  private int mRequestedCacheMax = 2;
  private final List<RecyclerView.ViewHolder> mUnmodifiableAttachedScrap = Collections.unmodifiableList(this.mAttachedScrap);
  private RecyclerView.ViewCacheExtension mViewCacheExtension;
  int mViewCacheMax = 2;
  
  public RecyclerView$Recycler(RecyclerView paramRecyclerView) {}
  
  private void attachAccessibilityDelegateOnBind(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.this$0.isAccessibilityEnabled())
    {
      paramViewHolder = paramViewHolder.itemView;
      if (ViewCompat.getImportantForAccessibility(paramViewHolder) == 0) {
        ViewCompat.setImportantForAccessibility(paramViewHolder, 1);
      }
      if (this.this$0.mAccessibilityDelegate != null) {}
    }
    else
    {
      return;
    }
    AccessibilityDelegateCompat localAccessibilityDelegateCompat = this.this$0.mAccessibilityDelegate.getItemDelegate();
    if ((localAccessibilityDelegateCompat instanceof RecyclerViewAccessibilityDelegate.ItemDelegate)) {
      ((RecyclerViewAccessibilityDelegate.ItemDelegate)localAccessibilityDelegateCompat).saveOriginalDelegate(paramViewHolder);
    }
    ViewCompat.setAccessibilityDelegate(paramViewHolder, localAccessibilityDelegateCompat);
  }
  
  private void invalidateDisplayListInt(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i = paramViewGroup.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        invalidateDisplayListInt((ViewGroup)localView, true);
      }
      i -= 1;
    }
    if (!paramBoolean) {
      return;
    }
    if (paramViewGroup.getVisibility() == 4)
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setVisibility(4);
      return;
    }
    i = paramViewGroup.getVisibility();
    paramViewGroup.setVisibility(4);
    paramViewGroup.setVisibility(i);
  }
  
  private void invalidateDisplayListInt(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder.itemView instanceof ViewGroup)) {
      invalidateDisplayListInt((ViewGroup)paramViewHolder.itemView, false);
    }
  }
  
  private boolean tryBindViewHolderByDeadline(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, long paramLong)
  {
    paramViewHolder.mOwnerRecyclerView = this.this$0;
    int i = paramViewHolder.getItemViewType();
    long l = this.this$0.getNanoTime();
    if ((paramLong != 9223372036854775807L) && (!this.mRecyclerPool.willBindInTime(i, l, paramLong))) {
      return false;
    }
    this.this$0.mAdapter.bindViewHolder(paramViewHolder, paramInt1);
    paramLong = this.this$0.getNanoTime();
    this.mRecyclerPool.factorInBindTime(paramViewHolder.getItemViewType(), paramLong - l);
    attachAccessibilityDelegateOnBind(paramViewHolder);
    if (this.this$0.mState.isPreLayout()) {
      paramViewHolder.mPreLayoutPosition = paramInt2;
    }
    return true;
  }
  
  void addViewHolderToRecycledViewPool(@NonNull RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    RecyclerView.clearNestedRecyclerViewIfNotNested(paramViewHolder);
    View localView = paramViewHolder.itemView;
    if (this.this$0.mAccessibilityDelegate != null)
    {
      localAccessibilityDelegateCompat = this.this$0.mAccessibilityDelegate.getItemDelegate();
      if (!(localAccessibilityDelegateCompat instanceof RecyclerViewAccessibilityDelegate.ItemDelegate)) {
        break label77;
      }
    }
    label77:
    for (AccessibilityDelegateCompat localAccessibilityDelegateCompat = ((RecyclerViewAccessibilityDelegate.ItemDelegate)localAccessibilityDelegateCompat).getAndRemoveOriginalDelegateForItem(localView);; localAccessibilityDelegateCompat = null)
    {
      ViewCompat.setAccessibilityDelegate(localView, localAccessibilityDelegateCompat);
      if (paramBoolean) {
        dispatchViewRecycled(paramViewHolder);
      }
      paramViewHolder.mOwnerRecyclerView = null;
      getRecycledViewPool().putRecycledView(paramViewHolder);
      return;
    }
  }
  
  public void bindViewToPosition(@NonNull View paramView, int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder == null) {
      throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter" + this.this$0.exceptionLabel());
    }
    int i = this.this$0.mAdapterHelper.findPositionOffset(paramInt);
    if ((i < 0) || (i >= this.this$0.mAdapter.getItemCount())) {
      throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + i + ").state:" + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
    }
    tryBindViewHolderByDeadline(localViewHolder, i, paramInt, 9223372036854775807L);
    paramView = localViewHolder.itemView.getLayoutParams();
    if (paramView == null)
    {
      paramView = (RecyclerView.LayoutParams)this.this$0.generateDefaultLayoutParams();
      localViewHolder.itemView.setLayoutParams(paramView);
      paramView.mInsetsDirty = true;
      paramView.mViewHolder = localViewHolder;
      if (localViewHolder.itemView.getParent() != null) {
        break label258;
      }
    }
    label258:
    for (boolean bool = true;; bool = false)
    {
      paramView.mPendingInvalidate = bool;
      return;
      if (!this.this$0.checkLayoutParams(paramView))
      {
        paramView = (RecyclerView.LayoutParams)this.this$0.generateLayoutParams(paramView);
        localViewHolder.itemView.setLayoutParams(paramView);
        break;
      }
      paramView = (RecyclerView.LayoutParams)paramView;
      break;
    }
  }
  
  public void clear()
  {
    this.mAttachedScrap.clear();
    recycleAndClearCachedViews();
  }
  
  void clearOldPositions()
  {
    int j = 0;
    int k = this.mCachedViews.size();
    int i = 0;
    while (i < k)
    {
      ((RecyclerView.ViewHolder)this.mCachedViews.get(i)).clearOldPosition();
      i += 1;
    }
    k = this.mAttachedScrap.size();
    i = 0;
    while (i < k)
    {
      ((RecyclerView.ViewHolder)this.mAttachedScrap.get(i)).clearOldPosition();
      i += 1;
    }
    if (this.mChangedScrap != null)
    {
      k = this.mChangedScrap.size();
      i = j;
      while (i < k)
      {
        ((RecyclerView.ViewHolder)this.mChangedScrap.get(i)).clearOldPosition();
        i += 1;
      }
    }
  }
  
  void clearScrap()
  {
    this.mAttachedScrap.clear();
    if (this.mChangedScrap != null) {
      this.mChangedScrap.clear();
    }
  }
  
  public int convertPreLayoutPositionToPostLayout(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.this$0.mState.getItemCount())) {
      throw new IndexOutOfBoundsException("invalid position " + paramInt + ". State item count is " + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
    }
    if (!this.this$0.mState.isPreLayout()) {
      return paramInt;
    }
    return this.this$0.mAdapterHelper.findPositionOffset(paramInt);
  }
  
  void dispatchViewRecycled(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.this$0.mRecyclerListener != null) {
      this.this$0.mRecyclerListener.onViewRecycled(paramViewHolder);
    }
    if (this.this$0.mAdapter != null) {
      this.this$0.mAdapter.onViewRecycled(paramViewHolder);
    }
    if (this.this$0.mState != null) {
      this.this$0.mViewInfoStore.removeViewHolder(paramViewHolder);
    }
  }
  
  RecyclerView.ViewHolder getChangedScrapViewForPosition(int paramInt)
  {
    int j = 0;
    int k;
    if (this.mChangedScrap != null)
    {
      k = this.mChangedScrap.size();
      if (k != 0) {}
    }
    else
    {
      return null;
    }
    int i = 0;
    RecyclerView.ViewHolder localViewHolder;
    while (i < k)
    {
      localViewHolder = (RecyclerView.ViewHolder)this.mChangedScrap.get(i);
      if ((!localViewHolder.wasReturnedFromScrap()) && (localViewHolder.getLayoutPosition() == paramInt))
      {
        localViewHolder.addFlags(32);
        return localViewHolder;
      }
      i += 1;
    }
    if (this.this$0.mAdapter.hasStableIds())
    {
      paramInt = this.this$0.mAdapterHelper.findPositionOffset(paramInt);
      if ((paramInt > 0) && (paramInt < this.this$0.mAdapter.getItemCount()))
      {
        long l = this.this$0.mAdapter.getItemId(paramInt);
        paramInt = j;
        while (paramInt < k)
        {
          localViewHolder = (RecyclerView.ViewHolder)this.mChangedScrap.get(paramInt);
          if ((!localViewHolder.wasReturnedFromScrap()) && (localViewHolder.getItemId() == l))
          {
            localViewHolder.addFlags(32);
            return localViewHolder;
          }
          paramInt += 1;
        }
      }
    }
    return null;
  }
  
  RecyclerView.RecycledViewPool getRecycledViewPool()
  {
    if (this.mRecyclerPool == null) {
      this.mRecyclerPool = new RecyclerView.RecycledViewPool();
    }
    return this.mRecyclerPool;
  }
  
  int getScrapCount()
  {
    return this.mAttachedScrap.size();
  }
  
  @NonNull
  public List<RecyclerView.ViewHolder> getScrapList()
  {
    return this.mUnmodifiableAttachedScrap;
  }
  
  RecyclerView.ViewHolder getScrapOrCachedViewForId(long paramLong, int paramInt, boolean paramBoolean)
  {
    int i = this.mAttachedScrap.size() - 1;
    RecyclerView.ViewHolder localViewHolder2;
    RecyclerView.ViewHolder localViewHolder1;
    while (i >= 0)
    {
      localViewHolder2 = (RecyclerView.ViewHolder)this.mAttachedScrap.get(i);
      if ((localViewHolder2.getItemId() == paramLong) && (!localViewHolder2.wasReturnedFromScrap()))
      {
        if (paramInt == localViewHolder2.getItemViewType())
        {
          localViewHolder2.addFlags(32);
          localViewHolder1 = localViewHolder2;
          if (localViewHolder2.isRemoved())
          {
            localViewHolder1 = localViewHolder2;
            if (!this.this$0.mState.isPreLayout())
            {
              localViewHolder2.setFlags(2, 14);
              localViewHolder1 = localViewHolder2;
            }
          }
          return localViewHolder1;
        }
        if (!paramBoolean)
        {
          this.mAttachedScrap.remove(i);
          this.this$0.removeDetachedView(localViewHolder2.itemView, false);
          quickRecycleScrapView(localViewHolder2.itemView);
        }
      }
      i -= 1;
    }
    i = this.mCachedViews.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label255;
      }
      localViewHolder2 = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
      if ((localViewHolder2.getItemId() == paramLong) && (!localViewHolder2.isAttachedToTransitionOverlay()))
      {
        if (paramInt == localViewHolder2.getItemViewType())
        {
          localViewHolder1 = localViewHolder2;
          if (paramBoolean) {
            break;
          }
          this.mCachedViews.remove(i);
          return localViewHolder2;
        }
        if (!paramBoolean)
        {
          recycleCachedViewAt(i);
          return null;
        }
      }
      i -= 1;
    }
    label255:
    return null;
  }
  
  RecyclerView.ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    int k = this.mAttachedScrap.size();
    int i = 0;
    Object localObject;
    while (i < k)
    {
      localObject = (RecyclerView.ViewHolder)this.mAttachedScrap.get(i);
      if ((!((RecyclerView.ViewHolder)localObject).wasReturnedFromScrap()) && (((RecyclerView.ViewHolder)localObject).getLayoutPosition() == paramInt) && (!((RecyclerView.ViewHolder)localObject).isInvalid()) && ((this.this$0.mState.mInPreLayout) || (!((RecyclerView.ViewHolder)localObject).isRemoved())))
      {
        ((RecyclerView.ViewHolder)localObject).addFlags(32);
        return localObject;
      }
      i += 1;
    }
    RecyclerView.ViewHolder localViewHolder;
    if (!paramBoolean)
    {
      localObject = this.this$0.mChildHelper.findHiddenNonRemovedView(paramInt);
      if (localObject != null)
      {
        localViewHolder = RecyclerView.getChildViewHolderInt((View)localObject);
        this.this$0.mChildHelper.unhide((View)localObject);
        paramInt = this.this$0.mChildHelper.indexOfChild((View)localObject);
        if (paramInt == -1) {
          throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + localViewHolder + this.this$0.exceptionLabel());
        }
        this.this$0.mChildHelper.detachViewFromParent(paramInt);
        scrapView((View)localObject);
        localViewHolder.addFlags(8224);
        return localViewHolder;
      }
    }
    k = this.mCachedViews.size();
    i = j;
    for (;;)
    {
      if (i >= k) {
        break label305;
      }
      localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
      if ((!localViewHolder.isInvalid()) && (localViewHolder.getLayoutPosition() == paramInt) && (!localViewHolder.isAttachedToTransitionOverlay()))
      {
        localObject = localViewHolder;
        if (paramBoolean) {
          break;
        }
        this.mCachedViews.remove(i);
        return localViewHolder;
      }
      i += 1;
    }
    label305:
    return null;
  }
  
  View getScrapViewAt(int paramInt)
  {
    return ((RecyclerView.ViewHolder)this.mAttachedScrap.get(paramInt)).itemView;
  }
  
  @NonNull
  public View getViewForPosition(int paramInt)
  {
    return getViewForPosition(paramInt, false);
  }
  
  View getViewForPosition(int paramInt, boolean paramBoolean)
  {
    return tryGetViewHolderForPositionByDeadline(paramInt, paramBoolean, 9223372036854775807L).itemView;
  }
  
  void markItemDecorInsetsDirty()
  {
    int j = this.mCachedViews.size();
    int i = 0;
    while (i < j)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((RecyclerView.ViewHolder)this.mCachedViews.get(i)).itemView.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.mInsetsDirty = true;
      }
      i += 1;
    }
  }
  
  void markKnownViewsInvalid()
  {
    int j = this.mCachedViews.size();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
      if (localViewHolder != null)
      {
        localViewHolder.addFlags(6);
        localViewHolder.addChangePayload(null);
      }
      i += 1;
    }
    if ((this.this$0.mAdapter == null) || (!this.this$0.mAdapter.hasStableIds())) {
      recycleAndClearCachedViews();
    }
  }
  
  void offsetPositionRecordsForInsert(int paramInt1, int paramInt2)
  {
    int j = this.mCachedViews.size();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
      if ((localViewHolder != null) && (localViewHolder.mPosition >= paramInt1)) {
        localViewHolder.offsetPosition(paramInt2, true);
      }
      i += 1;
    }
  }
  
  void offsetPositionRecordsForMove(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    int k;
    int m;
    label25:
    RecyclerView.ViewHolder localViewHolder;
    if (paramInt1 < paramInt2)
    {
      i = -1;
      j = paramInt2;
      k = paramInt1;
      int n = this.mCachedViews.size();
      m = 0;
      if (m >= n) {
        return;
      }
      localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(m);
      if ((localViewHolder != null) && (localViewHolder.mPosition >= k) && (localViewHolder.mPosition <= j)) {
        break label91;
      }
    }
    for (;;)
    {
      m += 1;
      break label25;
      i = 1;
      j = paramInt1;
      k = paramInt2;
      break;
      label91:
      if (localViewHolder.mPosition == paramInt1) {
        localViewHolder.offsetPosition(paramInt2 - paramInt1, false);
      } else {
        localViewHolder.offsetPosition(i, false);
      }
    }
  }
  
  void offsetPositionRecordsForRemove(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = this.mCachedViews.size() - 1;
    if (i >= 0)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
      if (localViewHolder != null)
      {
        if (localViewHolder.mPosition < paramInt1 + paramInt2) {
          break label63;
        }
        localViewHolder.offsetPosition(-paramInt2, paramBoolean);
      }
      for (;;)
      {
        i -= 1;
        break;
        label63:
        if (localViewHolder.mPosition >= paramInt1)
        {
          localViewHolder.addFlags(8);
          recycleCachedViewAt(i);
        }
      }
    }
  }
  
  void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2, boolean paramBoolean)
  {
    clear();
    getRecycledViewPool().onAdapterChanged(paramAdapter1, paramAdapter2, paramBoolean);
  }
  
  void quickRecycleScrapView(View paramView)
  {
    paramView = RecyclerView.getChildViewHolderInt(paramView);
    paramView.mScrapContainer = null;
    paramView.mInChangeScrap = false;
    paramView.clearReturnedFromScrapFlag();
    recycleViewHolderInternal(paramView);
  }
  
  void recycleAndClearCachedViews()
  {
    int i = this.mCachedViews.size() - 1;
    while (i >= 0)
    {
      recycleCachedViewAt(i);
      i -= 1;
    }
    this.mCachedViews.clear();
    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
      this.this$0.mPrefetchRegistry.clearPrefetchPositions();
    }
  }
  
  void recycleCachedViewAt(int paramInt)
  {
    addViewHolderToRecycledViewPool((RecyclerView.ViewHolder)this.mCachedViews.get(paramInt), true);
    this.mCachedViews.remove(paramInt);
  }
  
  public void recycleView(@NonNull View paramView)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder.isTmpDetached()) {
      this.this$0.removeDetachedView(paramView, false);
    }
    if (localViewHolder.isScrap()) {
      localViewHolder.unScrap();
    }
    for (;;)
    {
      recycleViewHolderInternal(localViewHolder);
      if ((this.this$0.mItemAnimator != null) && (!localViewHolder.isRecyclable())) {
        this.this$0.mItemAnimator.endAnimation(localViewHolder);
      }
      return;
      if (localViewHolder.wasReturnedFromScrap()) {
        localViewHolder.clearReturnedFromScrapFlag();
      }
    }
  }
  
  void recycleViewHolderInternal(RecyclerView.ViewHolder paramViewHolder)
  {
    int k = 0;
    if ((paramViewHolder.isScrap()) || (paramViewHolder.itemView.getParent() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(paramViewHolder.isScrap()).append(" isAttached:");
      if (paramViewHolder.itemView.getParent() != null) {}
      for (bool = true;; bool = false) {
        throw new IllegalArgumentException(bool + this.this$0.exceptionLabel());
      }
    }
    if (paramViewHolder.isTmpDetached()) {
      throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + paramViewHolder + this.this$0.exceptionLabel());
    }
    if (paramViewHolder.shouldIgnore()) {
      throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + this.this$0.exceptionLabel());
    }
    boolean bool = paramViewHolder.doesTransientStatePreventRecycling();
    int i;
    if ((this.this$0.mAdapter != null) && (bool) && (this.this$0.mAdapter.onFailedToRecycleView(paramViewHolder)))
    {
      i = 1;
      if ((i == 0) && (!paramViewHolder.isRecyclable())) {
        break label429;
      }
      if ((this.mViewCacheMax <= 0) || (paramViewHolder.hasAnyOfTheFlags(526))) {
        break label424;
      }
      j = this.mCachedViews.size();
      i = j;
      if (j >= this.mViewCacheMax)
      {
        i = j;
        if (j > 0)
        {
          recycleCachedViewAt(0);
          i = j - 1;
        }
      }
      j = i;
      if (RecyclerView.ALLOW_THREAD_GAP_WORK)
      {
        j = i;
        if (i > 0)
        {
          j = i;
          if (!this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(paramViewHolder.mPosition))
          {
            i -= 1;
            label316:
            if (i >= 0)
            {
              j = ((RecyclerView.ViewHolder)this.mCachedViews.get(i)).mPosition;
              if (this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(j)) {
                break label417;
              }
            }
            j = i + 1;
          }
        }
      }
      this.mCachedViews.add(j, paramViewHolder);
      i = 1;
      label364:
      j = i;
      if (i == 0)
      {
        addViewHolderToRecycledViewPool(paramViewHolder, true);
        k = 1;
      }
    }
    label417:
    label424:
    label429:
    for (int j = i;; j = 0)
    {
      this.this$0.mViewInfoStore.removeViewHolder(paramViewHolder);
      if ((j == 0) && (k == 0) && (bool)) {
        paramViewHolder.mOwnerRecyclerView = null;
      }
      return;
      i = 0;
      break;
      i -= 1;
      break label316;
      i = 0;
      break label364;
    }
  }
  
  void scrapView(View paramView)
  {
    paramView = RecyclerView.getChildViewHolderInt(paramView);
    if ((paramView.hasAnyOfTheFlags(12)) || (!paramView.isUpdated()) || (this.this$0.canReuseUpdatedViewHolder(paramView)))
    {
      if ((paramView.isInvalid()) && (!paramView.isRemoved()) && (!this.this$0.mAdapter.hasStableIds())) {
        throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + this.this$0.exceptionLabel());
      }
      paramView.setScrapContainer(this, false);
      this.mAttachedScrap.add(paramView);
      return;
    }
    if (this.mChangedScrap == null) {
      this.mChangedScrap = new ArrayList();
    }
    paramView.setScrapContainer(this, true);
    this.mChangedScrap.add(paramView);
  }
  
  void setRecycledViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    if (this.mRecyclerPool != null) {
      this.mRecyclerPool.detach();
    }
    this.mRecyclerPool = paramRecycledViewPool;
    if ((this.mRecyclerPool != null) && (this.this$0.getAdapter() != null)) {
      this.mRecyclerPool.attach();
    }
  }
  
  void setViewCacheExtension(RecyclerView.ViewCacheExtension paramViewCacheExtension)
  {
    this.mViewCacheExtension = paramViewCacheExtension;
  }
  
  public void setViewCacheSize(int paramInt)
  {
    this.mRequestedCacheMax = paramInt;
    updateViewCacheSize();
  }
  
  @Nullable
  RecyclerView.ViewHolder tryGetViewHolderForPositionByDeadline(int paramInt, boolean paramBoolean, long paramLong)
  {
    boolean bool = true;
    if ((paramInt < 0) || (paramInt >= this.this$0.mState.getItemCount())) {
      throw new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
    }
    Object localObject2;
    int i;
    if (this.this$0.mState.isPreLayout())
    {
      localObject2 = getChangedScrapViewForPosition(paramInt);
      if (localObject2 != null) {
        i = 1;
      }
    }
    for (int j = i;; j = 0)
    {
      Object localObject1 = localObject2;
      i = j;
      if (localObject2 == null)
      {
        localObject2 = getScrapOrHiddenOrCachedHolderForPosition(paramInt, paramBoolean);
        localObject1 = localObject2;
        i = j;
        if (localObject2 != null)
        {
          if (validateViewHolderForOffsetPosition((RecyclerView.ViewHolder)localObject2)) {
            break label337;
          }
          if (!paramBoolean)
          {
            ((RecyclerView.ViewHolder)localObject2).addFlags(4);
            if (!((RecyclerView.ViewHolder)localObject2).isScrap()) {
              break label321;
            }
            this.this$0.removeDetachedView(((RecyclerView.ViewHolder)localObject2).itemView, false);
            ((RecyclerView.ViewHolder)localObject2).unScrap();
            label199:
            recycleViewHolderInternal((RecyclerView.ViewHolder)localObject2);
          }
          localObject1 = null;
          i = j;
        }
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          int k = this.this$0.mAdapterHelper.findPositionOffset(paramInt);
          if ((k < 0) || (k >= this.this$0.mAdapter.getItemCount()))
          {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + k + ").state:" + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
            i = 0;
            break;
            label321:
            if (!((RecyclerView.ViewHolder)localObject2).wasReturnedFromScrap()) {
              break label199;
            }
            ((RecyclerView.ViewHolder)localObject2).clearReturnedFromScrapFlag();
            break label199;
            label337:
            i = 1;
            localObject1 = localObject2;
            continue;
          }
          j = this.this$0.mAdapter.getItemViewType(k);
          if (this.this$0.mAdapter.hasStableIds())
          {
            localObject2 = getScrapOrCachedViewForId(this.this$0.mAdapter.getItemId(k), j, paramBoolean);
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              ((RecyclerView.ViewHolder)localObject2).mPosition = k;
              i = 1;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = localObject2;
                if (this.mViewCacheExtension != null)
                {
                  View localView = this.mViewCacheExtension.getViewForPositionAndType(this, paramInt, j);
                  localObject1 = localObject2;
                  if (localView != null)
                  {
                    localObject2 = this.this$0.getChildViewHolder(localView);
                    if (localObject2 == null) {
                      throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + this.this$0.exceptionLabel());
                    }
                    localObject1 = localObject2;
                    if (((RecyclerView.ViewHolder)localObject2).shouldIgnore()) {
                      throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + this.this$0.exceptionLabel());
                    }
                  }
                }
              }
              localObject2 = localObject1;
              if (localObject1 == null)
              {
                localObject1 = getRecycledViewPool().getRecycledView(j);
                localObject2 = localObject1;
                if (localObject1 != null)
                {
                  ((RecyclerView.ViewHolder)localObject1).resetInternal();
                  localObject2 = localObject1;
                  if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST)
                  {
                    invalidateDisplayListInt((RecyclerView.ViewHolder)localObject1);
                    localObject2 = localObject1;
                  }
                }
              }
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                long l1 = this.this$0.getNanoTime();
                if ((paramLong != 9223372036854775807L) && (!this.mRecyclerPool.willCreateInTime(j, l1, paramLong))) {
                  return null;
                }
                localObject1 = this.this$0.mAdapter.createViewHolder(this.this$0, j);
                if (RecyclerView.ALLOW_THREAD_GAP_WORK)
                {
                  localObject2 = RecyclerView.findNestedRecyclerView(((RecyclerView.ViewHolder)localObject1).itemView);
                  if (localObject2 != null) {
                    ((RecyclerView.ViewHolder)localObject1).mNestedRecyclerView = new WeakReference(localObject2);
                  }
                }
                long l2 = this.this$0.getNanoTime();
                this.mRecyclerPool.factorInCreateTime(j, l2 - l1);
              }
            }
          }
        }
      }
      for (localObject2 = localObject1;; localObject2 = localObject1)
      {
        if ((i != 0) && (!this.this$0.mState.isPreLayout()) && (((RecyclerView.ViewHolder)localObject2).hasAnyOfTheFlags(8192)))
        {
          ((RecyclerView.ViewHolder)localObject2).setFlags(0, 8192);
          if (this.this$0.mState.mRunSimpleAnimations)
          {
            j = RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations((RecyclerView.ViewHolder)localObject2);
            localObject1 = this.this$0.mItemAnimator.recordPreLayoutInformation(this.this$0.mState, (RecyclerView.ViewHolder)localObject2, j | 0x1000, ((RecyclerView.ViewHolder)localObject2).getUnmodifiedPayloads());
            this.this$0.recordAnimationInfoIfBouncedHiddenView((RecyclerView.ViewHolder)localObject2, (RecyclerView.ItemAnimator.ItemHolderInfo)localObject1);
          }
        }
        if ((this.this$0.mState.isPreLayout()) && (((RecyclerView.ViewHolder)localObject2).isBound()))
        {
          ((RecyclerView.ViewHolder)localObject2).mPreLayoutPosition = paramInt;
          paramBoolean = false;
        }
        for (;;)
        {
          localObject1 = ((RecyclerView.ViewHolder)localObject2).itemView.getLayoutParams();
          if (localObject1 == null)
          {
            localObject1 = (RecyclerView.LayoutParams)this.this$0.generateDefaultLayoutParams();
            ((RecyclerView.ViewHolder)localObject2).itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            label896:
            ((RecyclerView.LayoutParams)localObject1).mViewHolder = ((RecyclerView.ViewHolder)localObject2);
            if ((i == 0) || (!paramBoolean)) {
              break label1020;
            }
          }
          label1020:
          for (paramBoolean = bool;; paramBoolean = false)
          {
            ((RecyclerView.LayoutParams)localObject1).mPendingInvalidate = paramBoolean;
            return localObject2;
            if ((((RecyclerView.ViewHolder)localObject2).isBound()) && (!((RecyclerView.ViewHolder)localObject2).needsUpdate()) && (!((RecyclerView.ViewHolder)localObject2).isInvalid())) {
              break label1025;
            }
            paramBoolean = tryBindViewHolderByDeadline((RecyclerView.ViewHolder)localObject2, this.this$0.mAdapterHelper.findPositionOffset(paramInt), paramInt, paramLong);
            break;
            if (!this.this$0.checkLayoutParams((ViewGroup.LayoutParams)localObject1))
            {
              localObject1 = (RecyclerView.LayoutParams)this.this$0.generateLayoutParams((ViewGroup.LayoutParams)localObject1);
              ((RecyclerView.ViewHolder)localObject2).itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              break label896;
            }
            localObject1 = (RecyclerView.LayoutParams)localObject1;
            break label896;
          }
          label1025:
          paramBoolean = false;
        }
        localObject2 = localObject1;
        break;
      }
      localObject2 = null;
    }
  }
  
  void unscrapView(RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramViewHolder.mInChangeScrap) {
      this.mChangedScrap.remove(paramViewHolder);
    }
    for (;;)
    {
      paramViewHolder.mScrapContainer = null;
      paramViewHolder.mInChangeScrap = false;
      paramViewHolder.clearReturnedFromScrapFlag();
      return;
      this.mAttachedScrap.remove(paramViewHolder);
    }
  }
  
  void updateViewCacheSize()
  {
    if (this.this$0.mLayout != null) {}
    for (int i = this.this$0.mLayout.mPrefetchMaxCountObserved;; i = 0)
    {
      this.mViewCacheMax = (i + this.mRequestedCacheMax);
      i = this.mCachedViews.size() - 1;
      while ((i >= 0) && (this.mCachedViews.size() > this.mViewCacheMax))
      {
        recycleCachedViewAt(i);
        i -= 1;
      }
    }
  }
  
  boolean validateViewHolderForOffsetPosition(RecyclerView.ViewHolder paramViewHolder)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramViewHolder.isRemoved()) {
      bool1 = this.this$0.mState.isPreLayout();
    }
    do
    {
      do
      {
        return bool1;
        if ((paramViewHolder.mPosition < 0) || (paramViewHolder.mPosition >= this.this$0.mAdapter.getItemCount())) {
          throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + paramViewHolder + this.this$0.exceptionLabel());
        }
        if ((!this.this$0.mState.isPreLayout()) && (this.this$0.mAdapter.getItemViewType(paramViewHolder.mPosition) != paramViewHolder.getItemViewType())) {
          return false;
        }
        bool1 = bool2;
      } while (!this.this$0.mAdapter.hasStableIds());
      bool1 = bool2;
    } while (paramViewHolder.getItemId() == this.this$0.mAdapter.getItemId(paramViewHolder.mPosition));
    return false;
  }
  
  void viewRangeUpdate(int paramInt1, int paramInt2)
  {
    int i = this.mCachedViews.size() - 1;
    if (i >= 0)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
      if (localViewHolder == null) {}
      for (;;)
      {
        i -= 1;
        break;
        int j = localViewHolder.mPosition;
        if ((j >= paramInt1) && (j < paramInt1 + paramInt2))
        {
          localViewHolder.addFlags(2);
          recycleCachedViewAt(i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.Recycler
 * JD-Core Version:    0.7.0.1
 */