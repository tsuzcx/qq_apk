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
      if (this.this$0.mAccessibilityDelegate == null) {
        return;
      }
      AccessibilityDelegateCompat localAccessibilityDelegateCompat = this.this$0.mAccessibilityDelegate.getItemDelegate();
      if ((localAccessibilityDelegateCompat instanceof RecyclerViewAccessibilityDelegate.ItemDelegate)) {
        ((RecyclerViewAccessibilityDelegate.ItemDelegate)localAccessibilityDelegateCompat).saveOriginalDelegate(paramViewHolder);
      }
      ViewCompat.setAccessibilityDelegate(paramViewHolder, localAccessibilityDelegateCompat);
    }
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
      AccessibilityDelegateCompat localAccessibilityDelegateCompat = this.this$0.mAccessibilityDelegate.getItemDelegate();
      if ((localAccessibilityDelegateCompat instanceof RecyclerViewAccessibilityDelegate.ItemDelegate)) {
        localAccessibilityDelegateCompat = ((RecyclerViewAccessibilityDelegate.ItemDelegate)localAccessibilityDelegateCompat).getAndRemoveOriginalDelegateForItem(localView);
      } else {
        localAccessibilityDelegateCompat = null;
      }
      ViewCompat.setAccessibilityDelegate(localView, localAccessibilityDelegateCompat);
    }
    if (paramBoolean) {
      dispatchViewRecycled(paramViewHolder);
    }
    paramViewHolder.mOwnerRecyclerView = null;
    getRecycledViewPool().putRecycledView(paramViewHolder);
  }
  
  public void bindViewToPosition(@NonNull View paramView, int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder != null)
    {
      int i = this.this$0.mAdapterHelper.findPositionOffset(paramInt);
      if ((i >= 0) && (i < this.this$0.mAdapter.getItemCount()))
      {
        tryBindViewHolderByDeadline(localViewHolder, i, paramInt, 9223372036854775807L);
        paramView = localViewHolder.itemView.getLayoutParams();
        if (paramView == null)
        {
          paramView = (RecyclerView.LayoutParams)this.this$0.generateDefaultLayoutParams();
          localViewHolder.itemView.setLayoutParams(paramView);
        }
        else if (!this.this$0.checkLayoutParams(paramView))
        {
          paramView = (RecyclerView.LayoutParams)this.this$0.generateLayoutParams(paramView);
          localViewHolder.itemView.setLayoutParams(paramView);
        }
        else
        {
          paramView = (RecyclerView.LayoutParams)paramView;
        }
        boolean bool = true;
        paramView.mInsetsDirty = true;
        paramView.mViewHolder = localViewHolder;
        if (localViewHolder.itemView.getParent() != null) {
          bool = false;
        }
        paramView.mPendingInvalidate = bool;
        return;
      }
      paramView = new StringBuilder();
      paramView.append("Inconsistency detected. Invalid item position ");
      paramView.append(paramInt);
      paramView.append("(offset:");
      paramView.append(i);
      paramView.append(").state:");
      paramView.append(this.this$0.mState.getItemCount());
      paramView.append(this.this$0.exceptionLabel());
      throw new IndexOutOfBoundsException(paramView.toString());
    }
    paramView = new StringBuilder();
    paramView.append("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
    paramView.append(this.this$0.exceptionLabel());
    throw new IllegalArgumentException(paramView.toString());
  }
  
  public void clear()
  {
    this.mAttachedScrap.clear();
    recycleAndClearCachedViews();
  }
  
  void clearOldPositions()
  {
    int k = this.mCachedViews.size();
    int j = 0;
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
    ArrayList localArrayList = this.mChangedScrap;
    if (localArrayList != null)
    {
      k = localArrayList.size();
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
    ArrayList localArrayList = this.mChangedScrap;
    if (localArrayList != null) {
      localArrayList.clear();
    }
  }
  
  public int convertPreLayoutPositionToPostLayout(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.this$0.mState.getItemCount()))
    {
      if (!this.this$0.mState.isPreLayout()) {
        return paramInt;
      }
      return this.this$0.mAdapterHelper.findPositionOffset(paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid position ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(". State item count is ");
    localStringBuilder.append(this.this$0.mState.getItemCount());
    localStringBuilder.append(this.this$0.exceptionLabel());
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
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
    Object localObject = this.mChangedScrap;
    if (localObject != null)
    {
      int k = ((ArrayList)localObject).size();
      if (k == 0) {
        return null;
      }
      int j = 0;
      int i = 0;
      while (i < k)
      {
        localObject = (RecyclerView.ViewHolder)this.mChangedScrap.get(i);
        if ((!((RecyclerView.ViewHolder)localObject).wasReturnedFromScrap()) && (((RecyclerView.ViewHolder)localObject).getLayoutPosition() == paramInt))
        {
          ((RecyclerView.ViewHolder)localObject).addFlags(32);
          return localObject;
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
            localObject = (RecyclerView.ViewHolder)this.mChangedScrap.get(paramInt);
            if ((!((RecyclerView.ViewHolder)localObject).wasReturnedFromScrap()) && (((RecyclerView.ViewHolder)localObject).getItemId() == l))
            {
              ((RecyclerView.ViewHolder)localObject).addFlags(32);
              return localObject;
            }
            paramInt += 1;
          }
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
    RecyclerView.ViewHolder localViewHolder;
    while (i >= 0)
    {
      localViewHolder = (RecyclerView.ViewHolder)this.mAttachedScrap.get(i);
      if ((localViewHolder.getItemId() == paramLong) && (!localViewHolder.wasReturnedFromScrap()))
      {
        if (paramInt == localViewHolder.getItemViewType())
        {
          localViewHolder.addFlags(32);
          if ((localViewHolder.isRemoved()) && (!this.this$0.mState.isPreLayout())) {
            localViewHolder.setFlags(2, 14);
          }
          return localViewHolder;
        }
        if (!paramBoolean)
        {
          this.mAttachedScrap.remove(i);
          this.this$0.removeDetachedView(localViewHolder.itemView, false);
          quickRecycleScrapView(localViewHolder.itemView);
        }
      }
      i -= 1;
    }
    i = this.mCachedViews.size() - 1;
    while (i >= 0)
    {
      localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
      if ((localViewHolder.getItemId() == paramLong) && (!localViewHolder.isAttachedToTransitionOverlay()))
      {
        if (paramInt == localViewHolder.getItemViewType())
        {
          if (!paramBoolean) {
            this.mCachedViews.remove(i);
          }
          return localViewHolder;
        }
        if (!paramBoolean)
        {
          recycleCachedViewAt(i);
          return null;
        }
      }
      i -= 1;
    }
    return null;
  }
  
  RecyclerView.ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int paramInt, boolean paramBoolean)
  {
    int k = this.mAttachedScrap.size();
    int j = 0;
    int i = 0;
    RecyclerView.ViewHolder localViewHolder;
    while (i < k)
    {
      localViewHolder = (RecyclerView.ViewHolder)this.mAttachedScrap.get(i);
      if ((!localViewHolder.wasReturnedFromScrap()) && (localViewHolder.getLayoutPosition() == paramInt) && (!localViewHolder.isInvalid()) && ((this.this$0.mState.mInPreLayout) || (!localViewHolder.isRemoved())))
      {
        localViewHolder.addFlags(32);
        return localViewHolder;
      }
      i += 1;
    }
    if (!paramBoolean)
    {
      Object localObject = this.this$0.mChildHelper.findHiddenNonRemovedView(paramInt);
      if (localObject != null)
      {
        localViewHolder = RecyclerView.getChildViewHolderInt((View)localObject);
        this.this$0.mChildHelper.unhide((View)localObject);
        paramInt = this.this$0.mChildHelper.indexOfChild((View)localObject);
        if (paramInt != -1)
        {
          this.this$0.mChildHelper.detachViewFromParent(paramInt);
          scrapView((View)localObject);
          localViewHolder.addFlags(8224);
          return localViewHolder;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("layout index should not be -1 after unhiding a view:");
        ((StringBuilder)localObject).append(localViewHolder);
        ((StringBuilder)localObject).append(this.this$0.exceptionLabel());
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
    }
    k = this.mCachedViews.size();
    i = j;
    while (i < k)
    {
      localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
      if ((!localViewHolder.isInvalid()) && (localViewHolder.getLayoutPosition() == paramInt) && (!localViewHolder.isAttachedToTransitionOverlay()))
      {
        if (!paramBoolean) {
          this.mCachedViews.remove(i);
        }
        return localViewHolder;
      }
      i += 1;
    }
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
    if (paramInt1 < paramInt2)
    {
      i = paramInt1;
      j = paramInt2;
      k = -1;
    }
    else
    {
      j = paramInt1;
      i = paramInt2;
      k = 1;
    }
    int n = this.mCachedViews.size();
    int m = 0;
    while (m < n)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(m);
      if ((localViewHolder != null) && (localViewHolder.mPosition >= i) && (localViewHolder.mPosition <= j)) {
        if (localViewHolder.mPosition == paramInt1) {
          localViewHolder.offsetPosition(paramInt2 - paramInt1, false);
        } else {
          localViewHolder.offsetPosition(k, false);
        }
      }
      m += 1;
    }
  }
  
  void offsetPositionRecordsForRemove(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = this.mCachedViews.size() - 1;
    while (i >= 0)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
      if (localViewHolder != null) {
        if (localViewHolder.mPosition >= paramInt1 + paramInt2)
        {
          localViewHolder.offsetPosition(-paramInt2, paramBoolean);
        }
        else if (localViewHolder.mPosition >= paramInt1)
        {
          localViewHolder.addFlags(8);
          recycleCachedViewAt(i);
        }
      }
      i -= 1;
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
    } else if (localViewHolder.wasReturnedFromScrap()) {
      localViewHolder.clearReturnedFromScrapFlag();
    }
    recycleViewHolderInternal(localViewHolder);
    if ((this.this$0.mItemAnimator != null) && (!localViewHolder.isRecyclable())) {
      this.this$0.mItemAnimator.endAnimation(localViewHolder);
    }
  }
  
  void recycleViewHolderInternal(RecyclerView.ViewHolder paramViewHolder)
  {
    boolean bool2 = paramViewHolder.isScrap();
    boolean bool1 = false;
    int k = 0;
    if ((!bool2) && (paramViewHolder.itemView.getParent() == null))
    {
      if (!paramViewHolder.isTmpDetached())
      {
        if (!paramViewHolder.shouldIgnore())
        {
          bool1 = paramViewHolder.doesTransientStatePreventRecycling();
          int i;
          if ((this.this$0.mAdapter != null) && (bool1) && (this.this$0.mAdapter.onFailedToRecycleView(paramViewHolder))) {
            i = 1;
          } else {
            i = 0;
          }
          int j;
          if ((i == 0) && (!paramViewHolder.isRecyclable()))
          {
            i = 0;
            j = k;
            k = i;
          }
          else
          {
            if ((this.mViewCacheMax > 0) && (!paramViewHolder.hasAnyOfTheFlags(526)))
            {
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
                    while (i >= 0)
                    {
                      j = ((RecyclerView.ViewHolder)this.mCachedViews.get(i)).mPosition;
                      if (!this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(j)) {
                        break;
                      }
                      i -= 1;
                    }
                    j = i + 1;
                  }
                }
              }
              this.mCachedViews.add(j, paramViewHolder);
              i = 1;
            }
            else
            {
              i = 0;
            }
            j = k;
            k = i;
            if (i == 0)
            {
              addViewHolderToRecycledViewPool(paramViewHolder, true);
              j = 1;
              k = i;
            }
          }
          this.this$0.mViewInfoStore.removeViewHolder(paramViewHolder);
          if ((k == 0) && (j == 0) && (bool1)) {
            paramViewHolder.mOwnerRecyclerView = null;
          }
          return;
        }
        paramViewHolder = new StringBuilder();
        paramViewHolder.append("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
        paramViewHolder.append(this.this$0.exceptionLabel());
        throw new IllegalArgumentException(paramViewHolder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
      localStringBuilder.append(paramViewHolder);
      localStringBuilder.append(this.this$0.exceptionLabel());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Scrapped or attached views may not be recycled. isScrap:");
    localStringBuilder.append(paramViewHolder.isScrap());
    localStringBuilder.append(" isAttached:");
    if (paramViewHolder.itemView.getParent() != null) {
      bool1 = true;
    }
    localStringBuilder.append(bool1);
    localStringBuilder.append(this.this$0.exceptionLabel());
    paramViewHolder = new IllegalArgumentException(localStringBuilder.toString());
    for (;;)
    {
      throw paramViewHolder;
    }
  }
  
  void scrapView(View paramView)
  {
    paramView = RecyclerView.getChildViewHolderInt(paramView);
    if ((!paramView.hasAnyOfTheFlags(12)) && (paramView.isUpdated()) && (!this.this$0.canReuseUpdatedViewHolder(paramView)))
    {
      if (this.mChangedScrap == null) {
        this.mChangedScrap = new ArrayList();
      }
      paramView.setScrapContainer(this, true);
      this.mChangedScrap.add(paramView);
      return;
    }
    if ((paramView.isInvalid()) && (!paramView.isRemoved()) && (!this.this$0.mAdapter.hasStableIds()))
    {
      paramView = new StringBuilder();
      paramView.append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
      paramView.append(this.this$0.exceptionLabel());
      throw new IllegalArgumentException(paramView.toString());
    }
    paramView.setScrapContainer(this, false);
    this.mAttachedScrap.add(paramView);
  }
  
  void setRecycledViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    RecyclerView.RecycledViewPool localRecycledViewPool = this.mRecyclerPool;
    if (localRecycledViewPool != null) {
      localRecycledViewPool.detach();
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
    if ((paramInt >= 0) && (paramInt < this.this$0.mState.getItemCount()))
    {
      boolean bool2 = this.this$0.mState.isPreLayout();
      boolean bool1 = true;
      if (bool2)
      {
        localObject2 = getChangedScrapViewForPosition(paramInt);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          j = 1;
          break label70;
        }
      }
      else
      {
        localObject1 = null;
      }
      int j = 0;
      Object localObject2 = localObject1;
      label70:
      localObject1 = localObject2;
      int i = j;
      if (localObject2 == null)
      {
        localObject2 = getScrapOrHiddenOrCachedHolderForPosition(paramInt, paramBoolean);
        localObject1 = localObject2;
        i = j;
        if (localObject2 != null) {
          if (!validateViewHolderForOffsetPosition((RecyclerView.ViewHolder)localObject2))
          {
            if (!paramBoolean)
            {
              ((RecyclerView.ViewHolder)localObject2).addFlags(4);
              if (((RecyclerView.ViewHolder)localObject2).isScrap())
              {
                this.this$0.removeDetachedView(((RecyclerView.ViewHolder)localObject2).itemView, false);
                ((RecyclerView.ViewHolder)localObject2).unScrap();
              }
              else if (((RecyclerView.ViewHolder)localObject2).wasReturnedFromScrap())
              {
                ((RecyclerView.ViewHolder)localObject2).clearReturnedFromScrapFlag();
              }
              recycleViewHolderInternal((RecyclerView.ViewHolder)localObject2);
            }
            localObject1 = null;
            i = j;
          }
          else
          {
            i = 1;
            localObject1 = localObject2;
          }
        }
      }
      localObject2 = localObject1;
      int k = i;
      if (localObject1 == null)
      {
        k = this.this$0.mAdapterHelper.findPositionOffset(paramInt);
        if ((k >= 0) && (k < this.this$0.mAdapter.getItemCount()))
        {
          int m = this.this$0.mAdapter.getItemViewType(k);
          j = i;
          if (this.this$0.mAdapter.hasStableIds())
          {
            localObject2 = getScrapOrCachedViewForId(this.this$0.mAdapter.getItemId(k), m, paramBoolean);
            localObject1 = localObject2;
            j = i;
            if (localObject2 != null)
            {
              ((RecyclerView.ViewHolder)localObject2).mPosition = k;
              j = 1;
              localObject1 = localObject2;
            }
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            Object localObject3 = this.mViewCacheExtension;
            localObject2 = localObject1;
            if (localObject3 != null)
            {
              localObject3 = ((RecyclerView.ViewCacheExtension)localObject3).getViewForPositionAndType(this, paramInt, m);
              localObject2 = localObject1;
              if (localObject3 != null)
              {
                localObject2 = this.this$0.getChildViewHolder((View)localObject3);
                if (localObject2 != null)
                {
                  if (((RecyclerView.ViewHolder)localObject2).shouldIgnore())
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                    ((StringBuilder)localObject1).append(this.this$0.exceptionLabel());
                    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
                  }
                }
                else
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("getViewForPositionAndType returned a view which does not have a ViewHolder");
                  ((StringBuilder)localObject1).append(this.this$0.exceptionLabel());
                  throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
                }
              }
            }
          }
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject2 = getRecycledViewPool().getRecycledView(m);
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              ((RecyclerView.ViewHolder)localObject2).resetInternal();
              localObject1 = localObject2;
              if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST)
              {
                invalidateDisplayListInt((RecyclerView.ViewHolder)localObject2);
                localObject1 = localObject2;
              }
            }
          }
          localObject2 = localObject1;
          k = j;
          if (localObject1 == null)
          {
            long l1 = this.this$0.getNanoTime();
            if ((paramLong != 9223372036854775807L) && (!this.mRecyclerPool.willCreateInTime(m, l1, paramLong))) {
              return null;
            }
            localObject2 = this.this$0.mAdapter.createViewHolder(this.this$0, m);
            if (RecyclerView.ALLOW_THREAD_GAP_WORK)
            {
              localObject1 = RecyclerView.findNestedRecyclerView(((RecyclerView.ViewHolder)localObject2).itemView);
              if (localObject1 != null) {
                ((RecyclerView.ViewHolder)localObject2).mNestedRecyclerView = new WeakReference(localObject1);
              }
            }
            long l2 = this.this$0.getNanoTime();
            this.mRecyclerPool.factorInCreateTime(m, l2 - l1);
            break label748;
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Inconsistency detected. Invalid item position ");
          ((StringBuilder)localObject1).append(paramInt);
          ((StringBuilder)localObject1).append("(offset:");
          ((StringBuilder)localObject1).append(k);
          ((StringBuilder)localObject1).append(").state:");
          ((StringBuilder)localObject1).append(this.this$0.mState.getItemCount());
          ((StringBuilder)localObject1).append(this.this$0.exceptionLabel());
          throw new IndexOutOfBoundsException(((StringBuilder)localObject1).toString());
        }
      }
      j = k;
      label748:
      if ((j != 0) && (!this.this$0.mState.isPreLayout()) && (((RecyclerView.ViewHolder)localObject2).hasAnyOfTheFlags(8192)))
      {
        ((RecyclerView.ViewHolder)localObject2).setFlags(0, 8192);
        if (this.this$0.mState.mRunSimpleAnimations)
        {
          i = RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations((RecyclerView.ViewHolder)localObject2);
          localObject1 = this.this$0.mItemAnimator.recordPreLayoutInformation(this.this$0.mState, (RecyclerView.ViewHolder)localObject2, i | 0x1000, ((RecyclerView.ViewHolder)localObject2).getUnmodifiedPayloads());
          this.this$0.recordAnimationInfoIfBouncedHiddenView((RecyclerView.ViewHolder)localObject2, (RecyclerView.ItemAnimator.ItemHolderInfo)localObject1);
        }
      }
      if ((this.this$0.mState.isPreLayout()) && (((RecyclerView.ViewHolder)localObject2).isBound())) {
        ((RecyclerView.ViewHolder)localObject2).mPreLayoutPosition = paramInt;
      } else {
        if ((!((RecyclerView.ViewHolder)localObject2).isBound()) || (((RecyclerView.ViewHolder)localObject2).needsUpdate()) || (((RecyclerView.ViewHolder)localObject2).isInvalid())) {
          break label911;
        }
      }
      paramBoolean = false;
      break label931;
      label911:
      paramBoolean = tryBindViewHolderByDeadline((RecyclerView.ViewHolder)localObject2, this.this$0.mAdapterHelper.findPositionOffset(paramInt), paramInt, paramLong);
      label931:
      localObject1 = ((RecyclerView.ViewHolder)localObject2).itemView.getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = (RecyclerView.LayoutParams)this.this$0.generateDefaultLayoutParams();
        ((RecyclerView.ViewHolder)localObject2).itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      else if (!this.this$0.checkLayoutParams((ViewGroup.LayoutParams)localObject1))
      {
        localObject1 = (RecyclerView.LayoutParams)this.this$0.generateLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((RecyclerView.ViewHolder)localObject2).itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      else
      {
        localObject1 = (RecyclerView.LayoutParams)localObject1;
      }
      ((RecyclerView.LayoutParams)localObject1).mViewHolder = ((RecyclerView.ViewHolder)localObject2);
      if ((j != 0) && (paramBoolean)) {
        paramBoolean = bool1;
      } else {
        paramBoolean = false;
      }
      ((RecyclerView.LayoutParams)localObject1).mPendingInvalidate = paramBoolean;
      return localObject2;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Invalid item position ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("(");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("). Item count:");
    ((StringBuilder)localObject1).append(this.this$0.mState.getItemCount());
    ((StringBuilder)localObject1).append(this.this$0.exceptionLabel());
    throw new IndexOutOfBoundsException(((StringBuilder)localObject1).toString());
  }
  
  void unscrapView(RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramViewHolder.mInChangeScrap) {
      this.mChangedScrap.remove(paramViewHolder);
    } else {
      this.mAttachedScrap.remove(paramViewHolder);
    }
    paramViewHolder.mScrapContainer = null;
    paramViewHolder.mInChangeScrap = false;
    paramViewHolder.clearReturnedFromScrapFlag();
  }
  
  void updateViewCacheSize()
  {
    if (this.this$0.mLayout != null) {
      i = this.this$0.mLayout.mPrefetchMaxCountObserved;
    } else {
      i = 0;
    }
    this.mViewCacheMax = (this.mRequestedCacheMax + i);
    int i = this.mCachedViews.size() - 1;
    while ((i >= 0) && (this.mCachedViews.size() > this.mViewCacheMax))
    {
      recycleCachedViewAt(i);
      i -= 1;
    }
  }
  
  boolean validateViewHolderForOffsetPosition(RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramViewHolder.isRemoved()) {
      return this.this$0.mState.isPreLayout();
    }
    if ((paramViewHolder.mPosition >= 0) && (paramViewHolder.mPosition < this.this$0.mAdapter.getItemCount()))
    {
      boolean bool2 = this.this$0.mState.isPreLayout();
      boolean bool1 = false;
      if ((!bool2) && (this.this$0.mAdapter.getItemViewType(paramViewHolder.mPosition) != paramViewHolder.getItemViewType())) {
        return false;
      }
      if (this.this$0.mAdapter.hasStableIds())
      {
        if (paramViewHolder.getItemId() == this.this$0.mAdapter.getItemId(paramViewHolder.mPosition)) {
          bool1 = true;
        }
        return bool1;
      }
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Inconsistency detected. Invalid view holder adapter position");
    localStringBuilder.append(paramViewHolder);
    localStringBuilder.append(this.this$0.exceptionLabel());
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  void viewRangeUpdate(int paramInt1, int paramInt2)
  {
    int i = this.mCachedViews.size() - 1;
    while (i >= 0)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
      if (localViewHolder != null)
      {
        int j = localViewHolder.mPosition;
        if ((j >= paramInt1) && (j < paramInt2 + paramInt1))
        {
          localViewHolder.addFlags(2);
          recycleCachedViewAt(i);
        }
      }
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.Recycler
 * JD-Core Version:    0.7.0.1
 */