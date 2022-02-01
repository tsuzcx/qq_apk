package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class LinearLayoutManager
  extends RecyclerView.LayoutManager
{
  private static final boolean DEBUG = false;
  public static final int HORIZONTAL = 0;
  public static final int INVALID_OFFSET = -2147483648;
  private static final float MAX_SCROLL_FACTOR = 0.3333333F;
  private static final String TAG = "LinearLayoutManager";
  public static final int VERTICAL = 1;
  final LinearLayoutManager.AnchorInfo mAnchorInfo = new LinearLayoutManager.AnchorInfo(this);
  private boolean mLastStackFromEnd;
  private LinearLayoutManager.LayoutState mLayoutState;
  int mOrientation;
  OrientationHelper mOrientationHelper;
  LinearLayoutManager.SavedState mPendingSavedState = null;
  int mPendingScrollPosition = -1;
  int mPendingScrollPositionOffset = -2147483648;
  private boolean mRecycleChildrenOnDetach;
  private boolean mReverseLayout = false;
  boolean mShouldReverseLayout = false;
  private boolean mSmoothScrollbarEnabled = true;
  private boolean mStackFromEnd = false;
  
  public LinearLayoutManager(Context paramContext)
  {
    this(paramContext, 1, false);
  }
  
  public LinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    setReverseLayout(paramBoolean);
    setAutoMeasureEnabled(true);
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(paramContext.orientation);
    setReverseLayout(paramContext.reverseLayout);
    setStackFromEnd(paramContext.stackFromEnd);
    setAutoMeasureEnabled(true);
  }
  
  private int computeScrollExtent(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    return ScrollbarHelper.computeScrollExtent(paramState, this.mOrientationHelper, findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled);
  }
  
  private int computeScrollOffset(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    return ScrollbarHelper.computeScrollOffset(paramState, this.mOrientationHelper, findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
  }
  
  private int computeScrollRange(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    return ScrollbarHelper.computeScrollRange(paramState, this.mOrientationHelper, findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled);
  }
  
  private View findFirstReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return findReferenceChild(paramRecycler, paramState, 0, getChildCount(), paramState.getItemCount());
  }
  
  private View findFirstVisibleChildClosestToEnd(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mShouldReverseLayout) {
      return findOneVisibleChild(0, getChildCount(), paramBoolean1, paramBoolean2);
    }
    return findOneVisibleChild(getChildCount() - 1, -1, paramBoolean1, paramBoolean2);
  }
  
  private View findFirstVisibleChildClosestToStart(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mShouldReverseLayout) {
      return findOneVisibleChild(getChildCount() - 1, -1, paramBoolean1, paramBoolean2);
    }
    return findOneVisibleChild(0, getChildCount(), paramBoolean1, paramBoolean2);
  }
  
  private View findLastReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return findReferenceChild(paramRecycler, paramState, getChildCount() - 1, -1, paramState.getItemCount());
  }
  
  private View findReferenceChildClosestToEnd(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mShouldReverseLayout) {
      return findFirstReferenceChild(paramRecycler, paramState);
    }
    return findLastReferenceChild(paramRecycler, paramState);
  }
  
  private View findReferenceChildClosestToStart(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mShouldReverseLayout) {
      return findLastReferenceChild(paramRecycler, paramState);
    }
    return findFirstReferenceChild(paramRecycler, paramState);
  }
  
  private int fixLayoutEndGap(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = this.mOrientationHelper.getEndAfterPadding() - paramInt;
    if (i > 0)
    {
      i = -scrollBy(-i, paramRecycler, paramState);
      if (paramBoolean)
      {
        paramInt = this.mOrientationHelper.getEndAfterPadding() - (paramInt + i);
        if (paramInt > 0)
        {
          this.mOrientationHelper.offsetChildren(paramInt);
          return paramInt + i;
        }
      }
      return i;
    }
    return 0;
  }
  
  private int fixLayoutStartGap(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = paramInt - this.mOrientationHelper.getStartAfterPadding();
    if (i > 0)
    {
      int j = -scrollBy(i, paramRecycler, paramState);
      i = j;
      if (paramBoolean)
      {
        paramInt = paramInt + j - this.mOrientationHelper.getStartAfterPadding();
        i = j;
        if (paramInt > 0)
        {
          this.mOrientationHelper.offsetChildren(-paramInt);
          i = j - paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private View getChildClosestToEnd()
  {
    int i;
    if (this.mShouldReverseLayout) {
      i = 0;
    } else {
      i = getChildCount() - 1;
    }
    return getChildAt(i);
  }
  
  private View getChildClosestToStart()
  {
    int i;
    if (this.mShouldReverseLayout) {
      i = getChildCount() - 1;
    } else {
      i = 0;
    }
    return getChildAt(i);
  }
  
  private void layoutForPredictiveAnimations(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
  {
    if ((paramState.willRunPredictiveAnimations()) && (getChildCount() != 0) && (!paramState.isPreLayout()))
    {
      if (!supportsPredictiveItemAnimations()) {
        return;
      }
      Object localObject = paramRecycler.getScrapList();
      int n = ((List)localObject).size();
      int i1 = getPosition(getChildAt(0));
      int i = 0;
      int k = 0;
      int j = 0;
      while (i < n)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)((List)localObject).get(i);
        if (!localViewHolder.isRemoved())
        {
          int i2 = localViewHolder.getLayoutPosition();
          int m = 1;
          int i3;
          if (i2 < i1) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          if (i3 != this.mShouldReverseLayout) {
            m = -1;
          }
          if (m == -1) {
            k += this.mOrientationHelper.getDecoratedMeasurement(localViewHolder.itemView);
          } else {
            j += this.mOrientationHelper.getDecoratedMeasurement(localViewHolder.itemView);
          }
        }
        i += 1;
      }
      this.mLayoutState.mScrapList = ((List)localObject);
      if (k > 0)
      {
        updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), paramInt1);
        localObject = this.mLayoutState;
        ((LinearLayoutManager.LayoutState)localObject).mExtra = k;
        ((LinearLayoutManager.LayoutState)localObject).mAvailable = 0;
        ((LinearLayoutManager.LayoutState)localObject).assignPositionFromScrapList();
        fill(paramRecycler, this.mLayoutState, paramState, false);
      }
      if (j > 0)
      {
        updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), paramInt2);
        localObject = this.mLayoutState;
        ((LinearLayoutManager.LayoutState)localObject).mExtra = j;
        ((LinearLayoutManager.LayoutState)localObject).mAvailable = 0;
        ((LinearLayoutManager.LayoutState)localObject).assignPositionFromScrapList();
        fill(paramRecycler, this.mLayoutState, paramState, false);
      }
      this.mLayoutState.mScrapList = null;
    }
  }
  
  private void logChildren()
  {
    Log.d("LinearLayoutManager", "internal representation of views on the screen");
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("item ");
      localStringBuilder.append(getPosition(localView));
      localStringBuilder.append(", coord:");
      localStringBuilder.append(this.mOrientationHelper.getDecoratedStart(localView));
      Log.d("LinearLayoutManager", localStringBuilder.toString());
      i += 1;
    }
    Log.d("LinearLayoutManager", "==============");
  }
  
  private void recycleByLayoutState(RecyclerView.Recycler paramRecycler, LinearLayoutManager.LayoutState paramLayoutState)
  {
    if (paramLayoutState.mRecycle)
    {
      if (paramLayoutState.mInfinite) {
        return;
      }
      if (paramLayoutState.mLayoutDirection == -1)
      {
        recycleViewsFromEnd(paramRecycler, paramLayoutState.mScrollingOffset);
        return;
      }
      recycleViewsFromStart(paramRecycler, paramLayoutState.mScrollingOffset);
    }
  }
  
  private void recycleChildren(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    int i = paramInt1;
    if (paramInt2 > paramInt1)
    {
      paramInt2 -= 1;
      while (paramInt2 >= paramInt1)
      {
        removeAndRecycleViewAt(paramInt2, paramRecycler);
        paramInt2 -= 1;
      }
    }
    while (i > paramInt2)
    {
      removeAndRecycleViewAt(i, paramRecycler);
      i -= 1;
    }
  }
  
  private void recycleViewsFromEnd(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    int i = getChildCount();
    if (paramInt < 0) {
      return;
    }
    int j = this.mOrientationHelper.getEnd() - paramInt;
    View localView;
    if (this.mShouldReverseLayout)
    {
      paramInt = 0;
      while (paramInt < i)
      {
        localView = getChildAt(paramInt);
        if (this.mOrientationHelper.getDecoratedStart(localView) < j)
        {
          recycleChildren(paramRecycler, 0, paramInt);
          return;
        }
        paramInt += 1;
      }
    }
    i -= 1;
    paramInt = i;
    while (paramInt >= 0)
    {
      localView = getChildAt(paramInt);
      if (this.mOrientationHelper.getDecoratedStart(localView) < j)
      {
        recycleChildren(paramRecycler, i, paramInt);
        return;
      }
      paramInt -= 1;
    }
  }
  
  private void recycleViewsFromStart(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    int j = getChildCount();
    View localView;
    if (this.mShouldReverseLayout)
    {
      j -= 1;
      i = j;
      while (i >= 0)
      {
        localView = getChildAt(i);
        if (this.mOrientationHelper.getDecoratedEnd(localView) > paramInt)
        {
          recycleChildren(paramRecycler, j, i);
          return;
        }
        i -= 1;
      }
    }
    int i = 0;
    while (i < j)
    {
      localView = getChildAt(i);
      if (this.mOrientationHelper.getDecoratedEnd(localView) > paramInt)
      {
        recycleChildren(paramRecycler, 0, i);
        return;
      }
      i += 1;
    }
  }
  
  private void resolveShouldLayoutReverse()
  {
    if ((this.mOrientation != 1) && (isLayoutRTL()))
    {
      this.mShouldReverseLayout = (this.mReverseLayout ^ true);
      return;
    }
    this.mShouldReverseLayout = this.mReverseLayout;
  }
  
  private boolean updateAnchorFromChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo)
  {
    int j = getChildCount();
    int i = 0;
    if (j == 0) {
      return false;
    }
    View localView = getFocusedChild();
    if ((localView != null) && (LinearLayoutManager.AnchorInfo.access$000(paramAnchorInfo, localView, paramState)))
    {
      paramAnchorInfo.assignFromViewAndKeepVisibleRect(localView);
      return true;
    }
    if (this.mLastStackFromEnd != this.mStackFromEnd) {
      return false;
    }
    if (paramAnchorInfo.mLayoutFromEnd) {
      paramRecycler = findReferenceChildClosestToEnd(paramRecycler, paramState);
    } else {
      paramRecycler = findReferenceChildClosestToStart(paramRecycler, paramState);
    }
    if (paramRecycler != null)
    {
      paramAnchorInfo.assignFromView(paramRecycler);
      if ((!paramState.isPreLayout()) && (supportsPredictiveItemAnimations()))
      {
        if ((this.mOrientationHelper.getDecoratedStart(paramRecycler) >= this.mOrientationHelper.getEndAfterPadding()) || (this.mOrientationHelper.getDecoratedEnd(paramRecycler) < this.mOrientationHelper.getStartAfterPadding())) {
          i = 1;
        }
        if (i != 0)
        {
          if (paramAnchorInfo.mLayoutFromEnd) {
            i = this.mOrientationHelper.getEndAfterPadding();
          } else {
            i = this.mOrientationHelper.getStartAfterPadding();
          }
          paramAnchorInfo.mCoordinate = i;
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean updateAnchorFromPendingData(RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo)
  {
    boolean bool1 = paramState.isPreLayout();
    boolean bool2 = false;
    if (!bool1)
    {
      int i = this.mPendingScrollPosition;
      if (i == -1) {
        return false;
      }
      if ((i >= 0) && (i < paramState.getItemCount()))
      {
        paramAnchorInfo.mPosition = this.mPendingScrollPosition;
        paramState = this.mPendingSavedState;
        if ((paramState != null) && (paramState.hasValidAnchor()))
        {
          paramAnchorInfo.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
          if (paramAnchorInfo.mLayoutFromEnd)
          {
            paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset);
            return true;
          }
          paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset);
          return true;
        }
        if (this.mPendingScrollPositionOffset == -2147483648)
        {
          paramState = findViewByPosition(this.mPendingScrollPosition);
          if (paramState != null)
          {
            if (this.mOrientationHelper.getDecoratedMeasurement(paramState) > this.mOrientationHelper.getTotalSpace())
            {
              paramAnchorInfo.assignCoordinateFromPadding();
              return true;
            }
            if (this.mOrientationHelper.getDecoratedStart(paramState) - this.mOrientationHelper.getStartAfterPadding() < 0)
            {
              paramAnchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
              paramAnchorInfo.mLayoutFromEnd = false;
              return true;
            }
            if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(paramState) < 0)
            {
              paramAnchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
              paramAnchorInfo.mLayoutFromEnd = true;
              return true;
            }
            if (paramAnchorInfo.mLayoutFromEnd) {
              i = this.mOrientationHelper.getDecoratedEnd(paramState) + this.mOrientationHelper.getTotalSpaceChange();
            } else {
              i = this.mOrientationHelper.getDecoratedStart(paramState);
            }
            paramAnchorInfo.mCoordinate = i;
            return true;
          }
          if (getChildCount() > 0)
          {
            i = getPosition(getChildAt(0));
            if (this.mPendingScrollPosition < i) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            if (bool1 == this.mShouldReverseLayout) {
              bool2 = true;
            }
            paramAnchorInfo.mLayoutFromEnd = bool2;
          }
          paramAnchorInfo.assignCoordinateFromPadding();
          return true;
        }
        bool1 = this.mShouldReverseLayout;
        paramAnchorInfo.mLayoutFromEnd = bool1;
        if (bool1)
        {
          paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset);
          return true;
        }
        paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset);
        return true;
      }
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = -2147483648;
    }
    return false;
  }
  
  private void updateAnchorInfoForLayout(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo)
  {
    if (updateAnchorFromPendingData(paramState, paramAnchorInfo)) {
      return;
    }
    if (updateAnchorFromChildren(paramRecycler, paramState, paramAnchorInfo)) {
      return;
    }
    paramAnchorInfo.assignCoordinateFromPadding();
    int i;
    if (this.mStackFromEnd) {
      i = paramState.getItemCount() - 1;
    } else {
      i = 0;
    }
    paramAnchorInfo.mPosition = i;
  }
  
  private void updateLayoutState(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.State paramState)
  {
    LinearLayoutManager.LayoutState localLayoutState = this.mLayoutState;
    boolean bool;
    if (this.mOrientationHelper.getMode() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localLayoutState.mInfinite = bool;
    this.mLayoutState.mExtra = getExtraLayoutSpace(paramState);
    paramState = this.mLayoutState;
    paramState.mLayoutDirection = paramInt1;
    int i = -1;
    if (paramInt1 == 1)
    {
      paramState.mExtra += this.mOrientationHelper.getEndPadding();
      paramState = getChildClosestToEnd();
      localLayoutState = this.mLayoutState;
      if (!this.mShouldReverseLayout) {
        i = 1;
      }
      localLayoutState.mItemDirection = i;
      this.mLayoutState.mCurrentPosition = (getPosition(paramState) + this.mLayoutState.mItemDirection);
      this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(paramState);
      paramInt1 = this.mOrientationHelper.getDecoratedEnd(paramState) - this.mOrientationHelper.getEndAfterPadding();
    }
    else
    {
      paramState = getChildClosestToStart();
      localLayoutState = this.mLayoutState;
      localLayoutState.mExtra += this.mOrientationHelper.getStartAfterPadding();
      localLayoutState = this.mLayoutState;
      if (this.mShouldReverseLayout) {
        i = 1;
      }
      localLayoutState.mItemDirection = i;
      this.mLayoutState.mCurrentPosition = (getPosition(paramState) + this.mLayoutState.mItemDirection);
      this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(paramState);
      paramInt1 = -this.mOrientationHelper.getDecoratedStart(paramState) + this.mOrientationHelper.getStartAfterPadding();
    }
    paramState = this.mLayoutState;
    paramState.mAvailable = paramInt2;
    if (paramBoolean) {
      paramState.mAvailable -= paramInt1;
    }
    this.mLayoutState.mScrollingOffset = paramInt1;
  }
  
  private void updateLayoutStateToFillEnd(int paramInt1, int paramInt2)
  {
    this.mLayoutState.mAvailable = (this.mOrientationHelper.getEndAfterPadding() - paramInt2);
    LinearLayoutManager.LayoutState localLayoutState = this.mLayoutState;
    int i;
    if (this.mShouldReverseLayout) {
      i = -1;
    } else {
      i = 1;
    }
    localLayoutState.mItemDirection = i;
    localLayoutState = this.mLayoutState;
    localLayoutState.mCurrentPosition = paramInt1;
    localLayoutState.mLayoutDirection = 1;
    localLayoutState.mOffset = paramInt2;
    localLayoutState.mScrollingOffset = -2147483648;
  }
  
  private void updateLayoutStateToFillEnd(LinearLayoutManager.AnchorInfo paramAnchorInfo)
  {
    updateLayoutStateToFillEnd(paramAnchorInfo.mPosition, paramAnchorInfo.mCoordinate);
  }
  
  private void updateLayoutStateToFillStart(int paramInt1, int paramInt2)
  {
    this.mLayoutState.mAvailable = (paramInt2 - this.mOrientationHelper.getStartAfterPadding());
    LinearLayoutManager.LayoutState localLayoutState = this.mLayoutState;
    localLayoutState.mCurrentPosition = paramInt1;
    if (this.mShouldReverseLayout) {
      paramInt1 = 1;
    } else {
      paramInt1 = -1;
    }
    localLayoutState.mItemDirection = paramInt1;
    localLayoutState = this.mLayoutState;
    localLayoutState.mLayoutDirection = -1;
    localLayoutState.mOffset = paramInt2;
    localLayoutState.mScrollingOffset = -2147483648;
  }
  
  private void updateLayoutStateToFillStart(LinearLayoutManager.AnchorInfo paramAnchorInfo)
  {
    updateLayoutStateToFillStart(paramAnchorInfo.mPosition, paramAnchorInfo.mCoordinate);
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    if (this.mPendingSavedState == null) {
      super.assertNotInLayoutOrScroll(paramString);
    }
  }
  
  public boolean canScrollHorizontally()
  {
    return this.mOrientation == 0;
  }
  
  public boolean canScrollVertically()
  {
    return this.mOrientation == 1;
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.State paramState)
  {
    return computeScrollExtent(paramState);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState)
  {
    return computeScrollOffset(paramState);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState)
  {
    return computeScrollRange(paramState);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    if (getChildCount() == 0) {
      return null;
    }
    int k = 0;
    int j = getPosition(getChildAt(0));
    int i = 1;
    if (paramInt < j) {
      k = 1;
    }
    paramInt = i;
    if (k != this.mShouldReverseLayout) {
      paramInt = -1;
    }
    if (this.mOrientation == 0) {
      return new PointF(paramInt, 0.0F);
    }
    return new PointF(0.0F, paramInt);
  }
  
  public int computeVerticalScrollExtent(RecyclerView.State paramState)
  {
    return computeScrollExtent(paramState);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState)
  {
    return computeScrollOffset(paramState);
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState)
  {
    return computeScrollRange(paramState);
  }
  
  int convertFocusDirectionToLayoutDirection(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 17)
        {
          if (paramInt != 33)
          {
            if (paramInt != 66)
            {
              if (paramInt != 130) {
                return -2147483648;
              }
              if (this.mOrientation == 1) {
                return 1;
              }
              return -2147483648;
            }
            if (this.mOrientation == 0) {
              return 1;
            }
            return -2147483648;
          }
          if (this.mOrientation == 1) {
            return -1;
          }
          return -2147483648;
        }
        if (this.mOrientation == 0) {
          return -1;
        }
        return -2147483648;
      }
      return 1;
    }
    return -1;
  }
  
  LinearLayoutManager.LayoutState createLayoutState()
  {
    return new LinearLayoutManager.LayoutState();
  }
  
  void ensureLayoutState()
  {
    if (this.mLayoutState == null) {
      this.mLayoutState = createLayoutState();
    }
    if (this.mOrientationHelper == null) {
      this.mOrientationHelper = OrientationHelper.createOrientationHelper(this, this.mOrientation);
    }
  }
  
  int fill(RecyclerView.Recycler paramRecycler, LinearLayoutManager.LayoutState paramLayoutState, RecyclerView.State paramState, boolean paramBoolean)
  {
    int k = paramLayoutState.mAvailable;
    if (paramLayoutState.mScrollingOffset != -2147483648)
    {
      if (paramLayoutState.mAvailable < 0) {
        paramLayoutState.mScrollingOffset += paramLayoutState.mAvailable;
      }
      recycleByLayoutState(paramRecycler, paramLayoutState);
    }
    int i = paramLayoutState.mAvailable + paramLayoutState.mExtra;
    LinearLayoutManager.LayoutChunkResult localLayoutChunkResult = new LinearLayoutManager.LayoutChunkResult();
    do
    {
      int j;
      do
      {
        if (((!paramLayoutState.mInfinite) && (i <= 0)) || (!paramLayoutState.hasMore(paramState))) {
          break;
        }
        localLayoutChunkResult.resetInternal();
        layoutChunk(paramRecycler, paramState, paramLayoutState, localLayoutChunkResult);
        if (localLayoutChunkResult.mFinished) {
          break;
        }
        paramLayoutState.mOffset += localLayoutChunkResult.mConsumed * paramLayoutState.mLayoutDirection;
        if ((localLayoutChunkResult.mIgnoreConsumed) && (this.mLayoutState.mScrapList == null))
        {
          j = i;
          if (paramState.isPreLayout()) {}
        }
        else
        {
          paramLayoutState.mAvailable -= localLayoutChunkResult.mConsumed;
          j = i - localLayoutChunkResult.mConsumed;
        }
        if (paramLayoutState.mScrollingOffset != -2147483648)
        {
          paramLayoutState.mScrollingOffset += localLayoutChunkResult.mConsumed;
          if (paramLayoutState.mAvailable < 0) {
            paramLayoutState.mScrollingOffset += paramLayoutState.mAvailable;
          }
          recycleByLayoutState(paramRecycler, paramLayoutState);
        }
        i = j;
      } while (!paramBoolean);
      i = j;
    } while (!localLayoutChunkResult.mFocusable);
    return k - paramLayoutState.mAvailable;
  }
  
  public int findFirstCompletelyVisibleItemPosition()
  {
    View localView = findOneVisibleChild(0, getChildCount(), true, false);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int findFirstVisibleItemPosition()
  {
    View localView = findOneVisibleChild(0, getChildCount(), false, true);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int findLastCompletelyVisibleItemPosition()
  {
    View localView = findOneVisibleChild(getChildCount() - 1, -1, true, false);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int findLastVisibleItemPosition()
  {
    View localView = findOneVisibleChild(getChildCount() - 1, -1, false, true);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  View findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    ensureLayoutState();
    int j = this.mOrientationHelper.getStartAfterPadding();
    int k = this.mOrientationHelper.getEndAfterPadding();
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    } else {
      i = -1;
    }
    Object localObject2;
    for (Object localObject1 = null; paramInt1 != paramInt2; localObject1 = localObject2)
    {
      View localView = getChildAt(paramInt1);
      int m = this.mOrientationHelper.getDecoratedStart(localView);
      int n = this.mOrientationHelper.getDecoratedEnd(localView);
      localObject2 = localObject1;
      if (m < k)
      {
        localObject2 = localObject1;
        if (n > j) {
          if (paramBoolean1)
          {
            if ((m >= j) && (n <= k)) {
              return localView;
            }
            localObject2 = localObject1;
            if (paramBoolean2)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = localView;
              }
            }
          }
          else
          {
            return localView;
          }
        }
      }
      paramInt1 += i;
    }
    return localObject1;
  }
  
  View findReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, int paramInt3)
  {
    ensureLayoutState();
    int j = this.mOrientationHelper.getStartAfterPadding();
    int k = this.mOrientationHelper.getEndAfterPadding();
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    } else {
      i = -1;
    }
    paramState = null;
    Object localObject2;
    for (paramRecycler = null; paramInt1 != paramInt2; paramRecycler = (RecyclerView.Recycler)localObject2)
    {
      View localView = getChildAt(paramInt1);
      int m = getPosition(localView);
      Object localObject1 = paramState;
      localObject2 = paramRecycler;
      if (m >= 0)
      {
        localObject1 = paramState;
        localObject2 = paramRecycler;
        if (m < paramInt3) {
          if (((RecyclerView.LayoutParams)localView.getLayoutParams()).isItemRemoved())
          {
            localObject1 = paramState;
            localObject2 = paramRecycler;
            if (paramRecycler == null)
            {
              localObject2 = localView;
              localObject1 = paramState;
            }
          }
          else
          {
            if ((this.mOrientationHelper.getDecoratedStart(localView) < k) && (this.mOrientationHelper.getDecoratedEnd(localView) >= j)) {
              return localView;
            }
            localObject1 = paramState;
            localObject2 = paramRecycler;
            if (paramState == null)
            {
              localObject1 = localView;
              localObject2 = paramRecycler;
            }
          }
        }
      }
      paramInt1 += i;
      paramState = (RecyclerView.State)localObject1;
    }
    if (paramState != null) {
      return paramState;
    }
    return paramRecycler;
  }
  
  public View findViewByPosition(int paramInt)
  {
    int i = getChildCount();
    if (i == 0) {
      return null;
    }
    int j = paramInt - getPosition(getChildAt(0));
    if ((j >= 0) && (j < i))
    {
      View localView = getChildAt(j);
      if (getPosition(localView) == paramInt) {
        return localView;
      }
    }
    return super.findViewByPosition(paramInt);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  protected int getExtraLayoutSpace(RecyclerView.State paramState)
  {
    if (paramState.hasTargetScrollPosition()) {
      return this.mOrientationHelper.getTotalSpace();
    }
    return 0;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public boolean getRecycleChildrenOnDetach()
  {
    return this.mRecycleChildrenOnDetach;
  }
  
  public boolean getReverseLayout()
  {
    return this.mReverseLayout;
  }
  
  public boolean getStackFromEnd()
  {
    return this.mStackFromEnd;
  }
  
  protected boolean isLayoutRTL()
  {
    return getLayoutDirection() == 1;
  }
  
  public boolean isSmoothScrollbarEnabled()
  {
    return this.mSmoothScrollbarEnabled;
  }
  
  void layoutChunk(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, LinearLayoutManager.LayoutChunkResult paramLayoutChunkResult)
  {
    paramRecycler = paramLayoutState.next(paramRecycler);
    if (paramRecycler == null)
    {
      paramLayoutChunkResult.mFinished = true;
      return;
    }
    paramState = (RecyclerView.LayoutParams)paramRecycler.getLayoutParams();
    boolean bool2;
    boolean bool1;
    if (paramLayoutState.mScrapList == null)
    {
      bool2 = this.mShouldReverseLayout;
      if (paramLayoutState.mLayoutDirection == -1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool2 == bool1) {
        addView(paramRecycler);
      } else {
        addView(paramRecycler, 0);
      }
    }
    else
    {
      bool2 = this.mShouldReverseLayout;
      if (paramLayoutState.mLayoutDirection == -1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool2 == bool1) {
        addDisappearingView(paramRecycler);
      } else {
        addDisappearingView(paramRecycler, 0);
      }
    }
    measureChildWithMargins(paramRecycler, 0, 0);
    paramLayoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(paramRecycler);
    int i;
    int j;
    int k;
    int n;
    int m;
    if (this.mOrientation == 1)
    {
      if (isLayoutRTL())
      {
        i = getWidth() - getPaddingRight();
        j = i - this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
      }
      else
      {
        j = getPaddingLeft();
        i = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) + j;
      }
      if (paramLayoutState.mLayoutDirection == -1)
      {
        k = paramLayoutState.mOffset;
        n = paramLayoutState.mOffset - paramLayoutChunkResult.mConsumed;
        m = i;
        i = n;
        n = j;
        j = m;
      }
      else
      {
        n = paramLayoutState.mOffset;
        k = paramLayoutState.mOffset + paramLayoutChunkResult.mConsumed;
        m = i;
        i = n;
        n = j;
        j = m;
      }
    }
    else
    {
      m = getPaddingTop();
      k = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) + m;
      if (paramLayoutState.mLayoutDirection == -1)
      {
        j = paramLayoutState.mOffset;
        i = paramLayoutState.mOffset - paramLayoutChunkResult.mConsumed;
      }
      else
      {
        i = paramLayoutState.mOffset;
        j = paramLayoutState.mOffset + paramLayoutChunkResult.mConsumed;
      }
      n = i;
      i = m;
    }
    layoutDecorated(paramRecycler, n + paramState.leftMargin, paramState.topMargin + i, j - paramState.rightMargin, k - paramState.bottomMargin);
    if ((paramState.isItemRemoved()) || (paramState.isItemChanged())) {
      paramLayoutChunkResult.mIgnoreConsumed = true;
    }
    paramLayoutChunkResult.mFocusable = paramRecycler.isFocusable();
  }
  
  void onAnchorReady(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo, int paramInt) {}
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    super.onDetachedFromWindow(paramRecyclerView, paramRecycler);
    if (this.mRecycleChildrenOnDetach)
    {
      removeAndRecycleAllViews(paramRecycler);
      paramRecycler.clear();
    }
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    resolveShouldLayoutReverse();
    if (getChildCount() == 0) {
      return null;
    }
    paramInt = convertFocusDirectionToLayoutDirection(paramInt);
    if (paramInt == -2147483648) {
      return null;
    }
    ensureLayoutState();
    if (paramInt == -1) {
      paramView = findReferenceChildClosestToStart(paramRecycler, paramState);
    } else {
      paramView = findReferenceChildClosestToEnd(paramRecycler, paramState);
    }
    if (paramView == null) {
      return null;
    }
    ensureLayoutState();
    updateLayoutState(paramInt, (int)(this.mOrientationHelper.getTotalSpace() * 0.3333333F), false, paramState);
    LinearLayoutManager.LayoutState localLayoutState = this.mLayoutState;
    localLayoutState.mScrollingOffset = -2147483648;
    localLayoutState.mRecycle = false;
    fill(paramRecycler, localLayoutState, paramState, true);
    if (paramInt == -1) {
      paramRecycler = getChildClosestToStart();
    } else {
      paramRecycler = getChildClosestToEnd();
    }
    if (paramRecycler != paramView)
    {
      if (!paramRecycler.isFocusable()) {
        return null;
      }
      return paramRecycler;
    }
    return null;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
      paramAccessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
      paramAccessibilityEvent.setToIndex(findLastVisibleItemPosition());
    }
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (((this.mPendingSavedState != null) || (this.mPendingScrollPosition != -1)) && (paramState.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramRecycler);
      return;
    }
    Object localObject = this.mPendingSavedState;
    if ((localObject != null) && (((LinearLayoutManager.SavedState)localObject).hasValidAnchor())) {
      this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
    }
    ensureLayoutState();
    this.mLayoutState.mRecycle = false;
    resolveShouldLayoutReverse();
    this.mAnchorInfo.reset();
    localObject = this.mAnchorInfo;
    ((LinearLayoutManager.AnchorInfo)localObject).mLayoutFromEnd = (this.mShouldReverseLayout ^ this.mStackFromEnd);
    updateAnchorInfoForLayout(paramRecycler, paramState, (LinearLayoutManager.AnchorInfo)localObject);
    int j = getExtraLayoutSpace(paramState);
    if (this.mLayoutState.mLastScrollDelta >= 0)
    {
      i = j;
      j = 0;
    }
    else
    {
      i = 0;
    }
    int k = j + this.mOrientationHelper.getStartAfterPadding();
    int m = i + this.mOrientationHelper.getEndPadding();
    int i = k;
    j = m;
    int n;
    if (paramState.isPreLayout())
    {
      n = this.mPendingScrollPosition;
      i = k;
      j = m;
      if (n != -1)
      {
        i = k;
        j = m;
        if (this.mPendingScrollPositionOffset != -2147483648)
        {
          localObject = findViewByPosition(n);
          i = k;
          j = m;
          if (localObject != null)
          {
            if (this.mShouldReverseLayout)
            {
              j = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd((View)localObject);
              i = this.mPendingScrollPositionOffset;
            }
            else
            {
              i = this.mOrientationHelper.getDecoratedStart((View)localObject) - this.mOrientationHelper.getStartAfterPadding();
              j = this.mPendingScrollPositionOffset;
            }
            i = j - i;
            if (i > 0)
            {
              i = k + i;
              j = m;
            }
            else
            {
              j = m - i;
              i = k;
            }
          }
        }
      }
    }
    if (this.mAnchorInfo.mLayoutFromEnd) {
      if (this.mShouldReverseLayout)
      {
        k = 1;
        break label356;
      }
    }
    for (;;)
    {
      k = -1;
      break label356;
      if (!this.mShouldReverseLayout) {
        break;
      }
    }
    label356:
    onAnchorReady(paramRecycler, paramState, this.mAnchorInfo, k);
    detachAndScrapAttachedViews(paramRecycler);
    localObject = this.mLayoutState;
    boolean bool;
    if (this.mOrientationHelper.getMode() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((LinearLayoutManager.LayoutState)localObject).mInfinite = bool;
    this.mLayoutState.mIsPreLayout = paramState.isPreLayout();
    if (this.mAnchorInfo.mLayoutFromEnd)
    {
      updateLayoutStateToFillStart(this.mAnchorInfo);
      localObject = this.mLayoutState;
      ((LinearLayoutManager.LayoutState)localObject).mExtra = i;
      fill(paramRecycler, (LinearLayoutManager.LayoutState)localObject, paramState, false);
      k = this.mLayoutState.mOffset;
      n = this.mLayoutState.mCurrentPosition;
      i = j;
      if (this.mLayoutState.mAvailable > 0) {
        i = j + this.mLayoutState.mAvailable;
      }
      updateLayoutStateToFillEnd(this.mAnchorInfo);
      localObject = this.mLayoutState;
      ((LinearLayoutManager.LayoutState)localObject).mExtra = i;
      ((LinearLayoutManager.LayoutState)localObject).mCurrentPosition += this.mLayoutState.mItemDirection;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      m = this.mLayoutState.mOffset;
      j = k;
      i = m;
      if (this.mLayoutState.mAvailable > 0)
      {
        i = this.mLayoutState.mAvailable;
        updateLayoutStateToFillStart(n, k);
        localObject = this.mLayoutState;
        ((LinearLayoutManager.LayoutState)localObject).mExtra = i;
        fill(paramRecycler, (LinearLayoutManager.LayoutState)localObject, paramState, false);
        j = this.mLayoutState.mOffset;
        i = m;
      }
    }
    else
    {
      updateLayoutStateToFillEnd(this.mAnchorInfo);
      localObject = this.mLayoutState;
      ((LinearLayoutManager.LayoutState)localObject).mExtra = j;
      fill(paramRecycler, (LinearLayoutManager.LayoutState)localObject, paramState, false);
      k = this.mLayoutState.mOffset;
      n = this.mLayoutState.mCurrentPosition;
      j = i;
      if (this.mLayoutState.mAvailable > 0) {
        j = i + this.mLayoutState.mAvailable;
      }
      updateLayoutStateToFillStart(this.mAnchorInfo);
      localObject = this.mLayoutState;
      ((LinearLayoutManager.LayoutState)localObject).mExtra = j;
      ((LinearLayoutManager.LayoutState)localObject).mCurrentPosition += this.mLayoutState.mItemDirection;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      m = this.mLayoutState.mOffset;
      j = m;
      i = k;
      if (this.mLayoutState.mAvailable > 0)
      {
        i = this.mLayoutState.mAvailable;
        updateLayoutStateToFillEnd(n, k);
        localObject = this.mLayoutState;
        ((LinearLayoutManager.LayoutState)localObject).mExtra = i;
        fill(paramRecycler, (LinearLayoutManager.LayoutState)localObject, paramState, false);
        i = this.mLayoutState.mOffset;
        j = m;
      }
    }
    m = j;
    k = i;
    if (getChildCount() > 0)
    {
      if ((this.mShouldReverseLayout ^ this.mStackFromEnd))
      {
        m = fixLayoutEndGap(i, paramRecycler, paramState, true);
        k = j + m;
        j = i + m;
        i = fixLayoutStartGap(k, paramRecycler, paramState, false);
      }
      else
      {
        m = fixLayoutStartGap(j, paramRecycler, paramState, true);
        k = j + m;
        j = i + m;
        i = fixLayoutEndGap(j, paramRecycler, paramState, false);
      }
      m = k + i;
      k = j + i;
    }
    layoutForPredictiveAnimations(paramRecycler, paramState, m, k);
    if (!paramState.isPreLayout())
    {
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = -2147483648;
      this.mOrientationHelper.onLayoutComplete();
    }
    this.mLastStackFromEnd = this.mStackFromEnd;
    this.mPendingSavedState = null;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof LinearLayoutManager.SavedState))
    {
      this.mPendingSavedState = ((LinearLayoutManager.SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    LinearLayoutManager.SavedState localSavedState = this.mPendingSavedState;
    if (localSavedState != null) {
      return new LinearLayoutManager.SavedState(localSavedState);
    }
    localSavedState = new LinearLayoutManager.SavedState();
    if (getChildCount() > 0)
    {
      ensureLayoutState();
      boolean bool = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
      localSavedState.mAnchorLayoutFromEnd = bool;
      if (bool)
      {
        localView = getChildClosestToEnd();
        localSavedState.mAnchorOffset = (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(localView));
        localSavedState.mAnchorPosition = getPosition(localView);
        return localSavedState;
      }
      View localView = getChildClosestToStart();
      localSavedState.mAnchorPosition = getPosition(localView);
      localSavedState.mAnchorOffset = (this.mOrientationHelper.getDecoratedStart(localView) - this.mOrientationHelper.getStartAfterPadding());
      return localSavedState;
    }
    localSavedState.invalidateAnchor();
    return localSavedState;
  }
  
  int scrollBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (getChildCount() != 0)
    {
      if (paramInt == 0) {
        return 0;
      }
      this.mLayoutState.mRecycle = true;
      ensureLayoutState();
      int i;
      if (paramInt > 0) {
        i = 1;
      } else {
        i = -1;
      }
      int j = Math.abs(paramInt);
      updateLayoutState(i, j, true, paramState);
      int k = this.mLayoutState.mScrollingOffset + fill(paramRecycler, this.mLayoutState, paramState, false);
      if (k < 0) {
        return 0;
      }
      if (j > k) {
        paramInt = i * k;
      }
      this.mOrientationHelper.offsetChildren(-paramInt);
      this.mLayoutState.mLastScrollDelta = paramInt;
      return paramInt;
    }
    return 0;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void scrollToPosition(int paramInt)
  {
    this.mPendingScrollPosition = paramInt;
    this.mPendingScrollPositionOffset = -2147483648;
    LinearLayoutManager.SavedState localSavedState = this.mPendingSavedState;
    if (localSavedState != null) {
      localSavedState.invalidateAnchor();
    }
    requestLayout();
    EventCollector.getInstance().onRecyclerViewScrollToPosition(this);
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    this.mPendingScrollPosition = paramInt1;
    this.mPendingScrollPositionOffset = paramInt2;
    LinearLayoutManager.SavedState localSavedState = this.mPendingSavedState;
    if (localSavedState != null) {
      localSavedState.invalidateAnchor();
    }
    requestLayout();
    EventCollector.getInstance().onRecyclerViewScrollToPositionWithOffset(this);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 0) {
      return 0;
    }
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid orientation:");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    assertNotInLayoutOrScroll(null);
    if (paramInt == this.mOrientation) {
      return;
    }
    this.mOrientation = paramInt;
    this.mOrientationHelper = null;
    requestLayout();
  }
  
  public void setRecycleChildrenOnDetach(boolean paramBoolean)
  {
    this.mRecycleChildrenOnDetach = paramBoolean;
  }
  
  public void setReverseLayout(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (paramBoolean == this.mReverseLayout) {
      return;
    }
    this.mReverseLayout = paramBoolean;
    requestLayout();
  }
  
  public void setSmoothScrollbarEnabled(boolean paramBoolean)
  {
    this.mSmoothScrollbarEnabled = paramBoolean;
  }
  
  public void setStackFromEnd(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (this.mStackFromEnd == paramBoolean) {
      return;
    }
    this.mStackFromEnd = paramBoolean;
    requestLayout();
  }
  
  boolean shouldMeasureTwice()
  {
    return (getHeightMode() != 1073741824) && (getWidthMode() != 1073741824) && (hasFlexibleChildInBothOrientations());
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    paramRecyclerView = new LinearLayoutManager.1(this, paramRecyclerView.getContext());
    paramRecyclerView.setTargetPosition(paramInt);
    startSmoothScroll(paramRecyclerView);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (this.mPendingSavedState == null) && (this.mLastStackFromEnd == this.mStackFromEnd);
  }
  
  void validateChildOrder()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("validating child count ");
    ((StringBuilder)localObject).append(getChildCount());
    Log.d("LinearLayoutManager", ((StringBuilder)localObject).toString());
    if (getChildCount() < 1) {
      return;
    }
    boolean bool2 = false;
    boolean bool1 = false;
    int j = getPosition(getChildAt(0));
    int k = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
    int m;
    int n;
    if (this.mShouldReverseLayout)
    {
      i = 1;
      for (;;)
      {
        if (i >= getChildCount()) {
          return;
        }
        localObject = getChildAt(i);
        m = getPosition((View)localObject);
        n = this.mOrientationHelper.getDecoratedStart((View)localObject);
        if (m < j)
        {
          logChildren();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("detected invalid position. loc invalid? ");
          if (n < k) {
            bool1 = true;
          }
          ((StringBuilder)localObject).append(bool1);
          throw new RuntimeException(((StringBuilder)localObject).toString());
        }
        if (n > k) {
          break;
        }
        i += 1;
      }
      logChildren();
      throw new RuntimeException("detected invalid location");
    }
    int i = 1;
    while (i < getChildCount())
    {
      localObject = getChildAt(i);
      m = getPosition((View)localObject);
      n = this.mOrientationHelper.getDecoratedStart((View)localObject);
      if (m < j)
      {
        logChildren();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("detected invalid position. loc invalid? ");
        bool1 = bool2;
        if (n < k) {
          bool1 = true;
        }
        ((StringBuilder)localObject).append(bool1);
        throw new RuntimeException(((StringBuilder)localObject).toString());
      }
      if (n >= k)
      {
        i += 1;
      }
      else
      {
        logChildren();
        throw new RuntimeException("detected invalid location");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */