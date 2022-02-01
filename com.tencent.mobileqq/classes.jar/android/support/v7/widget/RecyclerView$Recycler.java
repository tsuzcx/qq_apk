package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RecyclerView$Recycler
{
  private static final int DEFAULT_CACHE_SIZE = 2;
  final ArrayList<RecyclerView.ViewHolder> mAttachedScrap = new ArrayList();
  final ArrayList<RecyclerView.ViewHolder> mCachedViews = new ArrayList();
  private ArrayList<RecyclerView.ViewHolder> mChangedScrap = null;
  private RecyclerView.RecycledViewPool mRecyclerPool;
  private final List<RecyclerView.ViewHolder> mUnmodifiableAttachedScrap = Collections.unmodifiableList(this.mAttachedScrap);
  private RecyclerView.ViewCacheExtension mViewCacheExtension;
  private int mViewCacheMax = 2;
  
  public RecyclerView$Recycler(RecyclerView paramRecyclerView) {}
  
  private void attachAccessibilityDelegate(View paramView)
  {
    if (this.this$0.isAccessibilityEnabled())
    {
      if (ViewCompat.getImportantForAccessibility(paramView) == 0) {
        ViewCompat.setImportantForAccessibility(paramView, 1);
      }
      if (!ViewCompat.hasAccessibilityDelegate(paramView)) {
        ViewCompat.setAccessibilityDelegate(paramView, RecyclerView.access$4800(this.this$0).getItemDelegate());
      }
    }
  }
  
  private void invalidateDisplayListInt(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder.itemView instanceof ViewGroup)) {
      invalidateDisplayListInt((ViewGroup)paramViewHolder.itemView, false);
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
  
  void addViewHolderToRecycledViewPool(RecyclerView.ViewHolder paramViewHolder)
  {
    ViewCompat.setAccessibilityDelegate(paramViewHolder.itemView, null);
    dispatchViewRecycled(paramViewHolder);
    paramViewHolder.mOwnerRecyclerView = null;
    getRecycledViewPool().putRecycledView(paramViewHolder);
  }
  
  public void bindViewToPosition(View paramView, int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder != null)
    {
      int i = this.this$0.mAdapterHelper.findPositionOffset(paramInt);
      if ((i >= 0) && (i < RecyclerView.access$3100(this.this$0).getItemCount()))
      {
        RecyclerView localRecyclerView = this.this$0;
        localViewHolder.mOwnerRecyclerView = localRecyclerView;
        RecyclerView.access$3100(localRecyclerView).bindViewHolder(localViewHolder, i);
        attachAccessibilityDelegate(paramView);
        if (this.this$0.mState.isPreLayout()) {
          localViewHolder.mPreLayoutPosition = paramInt;
        }
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
      throw new IndexOutOfBoundsException(paramView.toString());
    }
    throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
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
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  void dispatchViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    if (RecyclerView.access$5300(this.this$0) != null) {
      RecyclerView.access$5300(this.this$0).onViewRecycled(paramViewHolder);
    }
    if (RecyclerView.access$3100(this.this$0) != null) {
      RecyclerView.access$3100(this.this$0).onViewRecycled(paramViewHolder);
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
      if (RecyclerView.access$3100(this.this$0).hasStableIds())
      {
        paramInt = this.this$0.mAdapterHelper.findPositionOffset(paramInt);
        if ((paramInt > 0) && (paramInt < RecyclerView.access$3100(this.this$0).getItemCount()))
        {
          long l = RecyclerView.access$3100(this.this$0).getItemId(paramInt);
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
  
  public List<RecyclerView.ViewHolder> getScrapList()
  {
    return this.mUnmodifiableAttachedScrap;
  }
  
  View getScrapViewAt(int paramInt)
  {
    return ((RecyclerView.ViewHolder)this.mAttachedScrap.get(paramInt)).itemView;
  }
  
  RecyclerView.ViewHolder getScrapViewForId(long paramLong, int paramInt, boolean paramBoolean)
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
      if (localViewHolder.getItemId() == paramLong)
      {
        if (paramInt == localViewHolder.getItemViewType())
        {
          if (!paramBoolean) {
            this.mCachedViews.remove(i);
          }
          return localViewHolder;
        }
        if (!paramBoolean) {
          recycleCachedViewAt(i);
        }
      }
      i -= 1;
    }
    return null;
  }
  
  RecyclerView.ViewHolder getScrapViewForPosition(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int k = this.mAttachedScrap.size();
    int j = 0;
    int i = 0;
    RecyclerView.ViewHolder localViewHolder;
    Object localObject;
    while (i < k)
    {
      localViewHolder = (RecyclerView.ViewHolder)this.mAttachedScrap.get(i);
      if ((!localViewHolder.wasReturnedFromScrap()) && (localViewHolder.getLayoutPosition() == paramInt1) && (!localViewHolder.isInvalid()) && ((RecyclerView.State.access$2400(this.this$0.mState)) || (!localViewHolder.isRemoved())))
      {
        if ((paramInt2 != -1) && (localViewHolder.getItemViewType() != paramInt2))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Scrap view for position ");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(" isn't dirty but has wrong view type! (found ");
          ((StringBuilder)localObject).append(localViewHolder.getItemViewType());
          ((StringBuilder)localObject).append(" but expected ");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append(")");
          Log.e("RecyclerView", ((StringBuilder)localObject).toString());
          break;
        }
        localViewHolder.addFlags(32);
        return localViewHolder;
      }
      i += 1;
    }
    if (!paramBoolean)
    {
      localObject = this.this$0.mChildHelper.findHiddenNonRemovedView(paramInt1, paramInt2);
      if (localObject != null)
      {
        localViewHolder = RecyclerView.getChildViewHolderInt((View)localObject);
        if (localViewHolder == null) {
          return null;
        }
        this.this$0.mChildHelper.unhide((View)localObject);
        paramInt1 = this.this$0.mChildHelper.indexOfChild((View)localObject);
        if (paramInt1 != -1)
        {
          this.this$0.mChildHelper.detachViewFromParent(paramInt1);
          scrapView((View)localObject);
          localViewHolder.addFlags(8224);
          return localViewHolder;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("layout index should not be -1 after unhiding a view:");
        ((StringBuilder)localObject).append(localViewHolder);
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
    }
    i = this.mCachedViews.size();
    paramInt2 = j;
    while (paramInt2 < i)
    {
      localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(paramInt2);
      if ((!localViewHolder.isInvalid()) && (localViewHolder.getLayoutPosition() == paramInt1))
      {
        if (!paramBoolean) {
          this.mCachedViews.remove(paramInt2);
        }
        return localViewHolder;
      }
      paramInt2 += 1;
    }
    return null;
  }
  
  public View getViewForPosition(int paramInt)
  {
    return getViewForPosition(paramInt, false);
  }
  
  View getViewForPosition(int paramInt, boolean paramBoolean)
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
        localObject2 = getScrapViewForPosition(paramInt, -1, paramBoolean);
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
        if ((k >= 0) && (k < RecyclerView.access$3100(this.this$0).getItemCount()))
        {
          int m = RecyclerView.access$3100(this.this$0).getItemViewType(k);
          j = i;
          if (RecyclerView.access$3100(this.this$0).hasStableIds())
          {
            localObject2 = getScrapViewForId(RecyclerView.access$3100(this.this$0).getItemId(k), m, paramBoolean);
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
                  if (((RecyclerView.ViewHolder)localObject2).shouldIgnore()) {
                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                  }
                }
                else {
                  throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                }
              }
            }
          }
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = getRecycledViewPool().getRecycledView(m);
            if (localObject1 != null)
            {
              ((RecyclerView.ViewHolder)localObject1).resetInternal();
              if (RecyclerView.access$4600()) {
                invalidateDisplayListInt((RecyclerView.ViewHolder)localObject1);
              }
            }
          }
          localObject2 = localObject1;
          k = j;
          if (localObject1 == null)
          {
            localObject2 = RecyclerView.access$3100(this.this$0).createViewHolder(this.this$0, m);
            k = j;
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
          throw new IndexOutOfBoundsException(((StringBuilder)localObject1).toString());
        }
      }
      if ((k != 0) && (!this.this$0.mState.isPreLayout()) && (((RecyclerView.ViewHolder)localObject2).hasAnyOfTheFlags(8192)))
      {
        ((RecyclerView.ViewHolder)localObject2).setFlags(0, 8192);
        if (RecyclerView.State.access$2500(this.this$0.mState))
        {
          i = RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations((RecyclerView.ViewHolder)localObject2);
          localObject1 = this.this$0.mItemAnimator.recordPreLayoutInformation(this.this$0.mState, (RecyclerView.ViewHolder)localObject2, i | 0x1000, ((RecyclerView.ViewHolder)localObject2).getUnmodifiedPayloads());
          RecyclerView.access$4700(this.this$0, (RecyclerView.ViewHolder)localObject2, (RecyclerView.ItemAnimator.ItemHolderInfo)localObject1);
        }
      }
      if ((this.this$0.mState.isPreLayout()) && (((RecyclerView.ViewHolder)localObject2).isBound())) {
        ((RecyclerView.ViewHolder)localObject2).mPreLayoutPosition = paramInt;
      } else {
        if ((!((RecyclerView.ViewHolder)localObject2).isBound()) || (((RecyclerView.ViewHolder)localObject2).needsUpdate()) || (((RecyclerView.ViewHolder)localObject2).isInvalid())) {
          break label718;
        }
      }
      paramInt = 0;
      break label784;
      label718:
      i = this.this$0.mAdapterHelper.findPositionOffset(paramInt);
      localObject1 = this.this$0;
      ((RecyclerView.ViewHolder)localObject2).mOwnerRecyclerView = ((RecyclerView)localObject1);
      RecyclerView.access$3100((RecyclerView)localObject1).bindViewHolder((RecyclerView.ViewHolder)localObject2, i);
      attachAccessibilityDelegate(((RecyclerView.ViewHolder)localObject2).itemView);
      if (this.this$0.mState.isPreLayout()) {
        ((RecyclerView.ViewHolder)localObject2).mPreLayoutPosition = paramInt;
      }
      paramInt = 1;
      label784:
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
      if ((k != 0) && (paramInt != 0)) {
        paramBoolean = bool1;
      } else {
        paramBoolean = false;
      }
      ((RecyclerView.LayoutParams)localObject1).mPendingInvalidate = paramBoolean;
      return ((RecyclerView.ViewHolder)localObject2).itemView;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Invalid item position ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("(");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("). Item count:");
    ((StringBuilder)localObject1).append(this.this$0.mState.getItemCount());
    throw new IndexOutOfBoundsException(((StringBuilder)localObject1).toString());
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
    int j;
    int i;
    if ((RecyclerView.access$3100(this.this$0) != null) && (RecyclerView.access$3100(this.this$0).hasStableIds()))
    {
      j = this.mCachedViews.size();
      i = 0;
    }
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
      if (localViewHolder != null)
      {
        localViewHolder.addFlags(6);
        localViewHolder.addChangePayload(null);
      }
      i += 1;
      continue;
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
    if (paramView != null)
    {
      RecyclerView.ViewHolder.access$5002(paramView, null);
      RecyclerView.ViewHolder.access$5102(paramView, false);
      paramView.clearReturnedFromScrapFlag();
      recycleViewHolderInternal(paramView);
    }
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
  }
  
  void recycleCachedViewAt(int paramInt)
  {
    addViewHolderToRecycledViewPool((RecyclerView.ViewHolder)this.mCachedViews.get(paramInt));
    this.mCachedViews.remove(paramInt);
  }
  
  public void recycleView(View paramView)
  {
    RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
    if (localViewHolder == null) {
      return;
    }
    if (localViewHolder.isTmpDetached()) {
      this.this$0.removeDetachedView(paramView, false);
    }
    if (localViewHolder.isScrap()) {
      localViewHolder.unScrap();
    } else if (localViewHolder.wasReturnedFromScrap()) {
      localViewHolder.clearReturnedFromScrapFlag();
    }
    recycleViewHolderInternal(localViewHolder);
  }
  
  void recycleViewHolderInternal(RecyclerView.ViewHolder paramViewHolder)
  {
    boolean bool2 = paramViewHolder.isScrap();
    boolean bool1 = true;
    int j = 0;
    if ((!bool2) && (paramViewHolder.itemView.getParent() == null))
    {
      if (!paramViewHolder.isTmpDetached())
      {
        if (!paramViewHolder.shouldIgnore())
        {
          bool1 = RecyclerView.ViewHolder.access$4900(paramViewHolder);
          int i;
          if ((RecyclerView.access$3100(this.this$0) != null) && (bool1) && (RecyclerView.access$3100(this.this$0).onFailedToRecycleView(paramViewHolder))) {
            i = 1;
          } else {
            i = 0;
          }
          int k;
          if ((i == 0) && (!paramViewHolder.isRecyclable()))
          {
            k = 0;
          }
          else
          {
            if (!paramViewHolder.hasAnyOfTheFlags(14))
            {
              i = this.mCachedViews.size();
              if ((i == this.mViewCacheMax) && (i > 0)) {
                recycleCachedViewAt(0);
              }
              if (i < this.mViewCacheMax)
              {
                this.mCachedViews.add(paramViewHolder);
                i = 1;
                break label163;
              }
            }
            i = 0;
            label163:
            k = i;
            if (i == 0)
            {
              addViewHolderToRecycledViewPool(paramViewHolder);
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
        throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
      localStringBuilder.append(paramViewHolder);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Scrapped or attached views may not be recycled. isScrap:");
    localStringBuilder.append(paramViewHolder.isScrap());
    localStringBuilder.append(" isAttached:");
    if (paramViewHolder.itemView.getParent() == null) {
      bool1 = false;
    }
    localStringBuilder.append(bool1);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  void recycleViewInternal(View paramView)
  {
    paramView = RecyclerView.getChildViewHolderInt(paramView);
    if (paramView != null) {
      recycleViewHolderInternal(paramView);
    }
  }
  
  void scrapView(View paramView)
  {
    paramView = RecyclerView.getChildViewHolderInt(paramView);
    if (paramView == null) {
      return;
    }
    if ((!paramView.hasAnyOfTheFlags(12)) && (paramView.isUpdated()) && (!RecyclerView.access$5200(this.this$0, paramView)))
    {
      if (this.mChangedScrap == null) {
        this.mChangedScrap = new ArrayList();
      }
      paramView.setScrapContainer(this, true);
      this.mChangedScrap.add(paramView);
      return;
    }
    if ((paramView.isInvalid()) && (!paramView.isRemoved()) && (!RecyclerView.access$3100(this.this$0).hasStableIds())) {
      throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
    }
    paramView.setScrapContainer(this, false);
    this.mAttachedScrap.add(paramView);
  }
  
  void setAdapterPositionsAsUnknown()
  {
    int j = this.mCachedViews.size();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
      if (localViewHolder != null) {
        localViewHolder.addFlags(512);
      }
      i += 1;
    }
  }
  
  void setRecycledViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    RecyclerView.RecycledViewPool localRecycledViewPool = this.mRecyclerPool;
    if (localRecycledViewPool != null) {
      localRecycledViewPool.detach();
    }
    this.mRecyclerPool = paramRecycledViewPool;
    if (paramRecycledViewPool != null) {
      this.mRecyclerPool.attach(this.this$0.getAdapter());
    }
  }
  
  void setViewCacheExtension(RecyclerView.ViewCacheExtension paramViewCacheExtension)
  {
    this.mViewCacheExtension = paramViewCacheExtension;
  }
  
  public void setViewCacheSize(int paramInt)
  {
    this.mViewCacheMax = paramInt;
    int i = this.mCachedViews.size() - 1;
    while ((i >= 0) && (this.mCachedViews.size() > paramInt))
    {
      recycleCachedViewAt(i);
      i -= 1;
    }
  }
  
  void unscrapView(RecyclerView.ViewHolder paramViewHolder)
  {
    if (RecyclerView.ViewHolder.access$5100(paramViewHolder)) {
      this.mChangedScrap.remove(paramViewHolder);
    } else {
      this.mAttachedScrap.remove(paramViewHolder);
    }
    RecyclerView.ViewHolder.access$5002(paramViewHolder, null);
    RecyclerView.ViewHolder.access$5102(paramViewHolder, false);
    paramViewHolder.clearReturnedFromScrapFlag();
  }
  
  boolean validateViewHolderForOffsetPosition(RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramViewHolder.isRemoved()) {
      return this.this$0.mState.isPreLayout();
    }
    if ((paramViewHolder.mPosition >= 0) && (paramViewHolder.mPosition < RecyclerView.access$3100(this.this$0).getItemCount()))
    {
      boolean bool2 = this.this$0.mState.isPreLayout();
      boolean bool1 = false;
      if ((!bool2) && (RecyclerView.access$3100(this.this$0).getItemViewType(paramViewHolder.mPosition) != paramViewHolder.getItemViewType())) {
        return false;
      }
      if (RecyclerView.access$3100(this.this$0).hasStableIds())
      {
        if (paramViewHolder.getItemId() == RecyclerView.access$3100(this.this$0).getItemId(paramViewHolder.mPosition)) {
          bool1 = true;
        }
        return bool1;
      }
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Inconsistency detected. Invalid view holder adapter position");
    localStringBuilder.append(paramViewHolder);
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
        int j = localViewHolder.getLayoutPosition();
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
 * Qualified Name:     android.support.v7.widget.RecyclerView.Recycler
 * JD-Core Version:    0.7.0.1
 */