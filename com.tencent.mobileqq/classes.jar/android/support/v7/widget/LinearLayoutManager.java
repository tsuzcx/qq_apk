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
    boolean bool2 = false;
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    OrientationHelper localOrientationHelper = this.mOrientationHelper;
    if (!this.mSmoothScrollbarEnabled) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = findFirstVisibleChildClosestToStart(bool1, true);
      bool1 = bool2;
      if (!this.mSmoothScrollbarEnabled) {
        bool1 = true;
      }
      return ScrollbarHelper.computeScrollExtent(paramState, localOrientationHelper, localView, findFirstVisibleChildClosestToEnd(bool1, true), this, this.mSmoothScrollbarEnabled);
    }
  }
  
  private int computeScrollOffset(RecyclerView.State paramState)
  {
    boolean bool2 = false;
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    OrientationHelper localOrientationHelper = this.mOrientationHelper;
    if (!this.mSmoothScrollbarEnabled) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = findFirstVisibleChildClosestToStart(bool1, true);
      bool1 = bool2;
      if (!this.mSmoothScrollbarEnabled) {
        bool1 = true;
      }
      return ScrollbarHelper.computeScrollOffset(paramState, localOrientationHelper, localView, findFirstVisibleChildClosestToEnd(bool1, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }
  }
  
  private int computeScrollRange(RecyclerView.State paramState)
  {
    boolean bool2 = false;
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    OrientationHelper localOrientationHelper = this.mOrientationHelper;
    if (!this.mSmoothScrollbarEnabled) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      View localView = findFirstVisibleChildClosestToStart(bool1, true);
      bool1 = bool2;
      if (!this.mSmoothScrollbarEnabled) {
        bool1 = true;
      }
      return ScrollbarHelper.computeScrollRange(paramState, localOrientationHelper, localView, findFirstVisibleChildClosestToEnd(bool1, true), this, this.mSmoothScrollbarEnabled);
    }
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
      int j = -scrollBy(-i, paramRecycler, paramState);
      i = j;
      if (paramBoolean)
      {
        paramInt = this.mOrientationHelper.getEndAfterPadding() - (paramInt + j);
        i = j;
        if (paramInt > 0)
        {
          this.mOrientationHelper.offsetChildren(paramInt);
          i = j + paramInt;
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
    if (this.mShouldReverseLayout) {}
    for (int i = 0;; i = getChildCount() - 1) {
      return getChildAt(i);
    }
  }
  
  private View getChildClosestToStart()
  {
    if (this.mShouldReverseLayout) {}
    for (int i = getChildCount() - 1;; i = 0) {
      return getChildAt(i);
    }
  }
  
  private void layoutForPredictiveAnimations(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
  {
    if ((!paramState.willRunPredictiveAnimations()) || (getChildCount() == 0) || (paramState.isPreLayout()) || (!supportsPredictiveItemAnimations())) {
      return;
    }
    int i = 0;
    int j = 0;
    List localList = paramRecycler.getScrapList();
    int n = localList.size();
    int i1 = getPosition(getChildAt(0));
    int k = 0;
    if (k < n)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localList.get(k);
      int m;
      if (localViewHolder.isRemoved())
      {
        m = j;
        j = i;
        i = m;
      }
      for (;;)
      {
        m = k + 1;
        k = j;
        j = i;
        i = k;
        k = m;
        break;
        int i2;
        if (localViewHolder.getLayoutPosition() < i1)
        {
          i2 = 1;
          label143:
          if (i2 == this.mShouldReverseLayout) {
            break label195;
          }
        }
        label195:
        for (m = -1;; m = 1)
        {
          if (m != -1) {
            break label201;
          }
          m = this.mOrientationHelper.getDecoratedMeasurement(localViewHolder.itemView) + i;
          i = j;
          j = m;
          break;
          i2 = 0;
          break label143;
        }
        label201:
        m = this.mOrientationHelper.getDecoratedMeasurement(localViewHolder.itemView) + j;
        j = i;
        i = m;
      }
    }
    this.mLayoutState.mScrapList = localList;
    if (i > 0)
    {
      updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), paramInt1);
      this.mLayoutState.mExtra = i;
      this.mLayoutState.mAvailable = 0;
      this.mLayoutState.assignPositionFromScrapList();
      fill(paramRecycler, this.mLayoutState, paramState, false);
    }
    if (j > 0)
    {
      updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), paramInt2);
      this.mLayoutState.mExtra = j;
      this.mLayoutState.mAvailable = 0;
      this.mLayoutState.assignPositionFromScrapList();
      fill(paramRecycler, this.mLayoutState, paramState, false);
    }
    this.mLayoutState.mScrapList = null;
  }
  
  private void logChildren()
  {
    Log.d("LinearLayoutManager", "internal representation of views on the screen");
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      Log.d("LinearLayoutManager", "item " + getPosition(localView) + ", coord:" + this.mOrientationHelper.getDecoratedStart(localView));
      i += 1;
    }
    Log.d("LinearLayoutManager", "==============");
  }
  
  private void recycleByLayoutState(RecyclerView.Recycler paramRecycler, LinearLayoutManager.LayoutState paramLayoutState)
  {
    if ((!paramLayoutState.mRecycle) || (paramLayoutState.mInfinite)) {
      return;
    }
    if (paramLayoutState.mLayoutDirection == -1)
    {
      recycleViewsFromEnd(paramRecycler, paramLayoutState.mScrollingOffset);
      return;
    }
    recycleViewsFromStart(paramRecycler, paramLayoutState.mScrollingOffset);
  }
  
  private void recycleChildren(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {}
    for (;;)
    {
      return;
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
      else
      {
        while (i > paramInt2)
        {
          removeAndRecycleViewAt(i, paramRecycler);
          i -= 1;
        }
      }
    }
  }
  
  private void recycleViewsFromEnd(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    int i = getChildCount();
    if (paramInt < 0) {}
    for (;;)
    {
      return;
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
      else
      {
        paramInt = i - 1;
        while (paramInt >= 0)
        {
          localView = getChildAt(paramInt);
          if (this.mOrientationHelper.getDecoratedStart(localView) < j)
          {
            recycleChildren(paramRecycler, i - 1, paramInt);
            return;
          }
          paramInt -= 1;
        }
      }
    }
  }
  
  private void recycleViewsFromStart(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    if (paramInt < 0) {}
    for (;;)
    {
      return;
      int j = getChildCount();
      int i;
      View localView;
      if (this.mShouldReverseLayout)
      {
        i = j - 1;
        while (i >= 0)
        {
          localView = getChildAt(i);
          if (this.mOrientationHelper.getDecoratedEnd(localView) > paramInt)
          {
            recycleChildren(paramRecycler, j - 1, i);
            return;
          }
          i -= 1;
        }
      }
      else
      {
        i = 0;
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
    }
  }
  
  private void resolveShouldLayoutReverse()
  {
    boolean bool = true;
    if ((this.mOrientation == 1) || (!isLayoutRTL()))
    {
      this.mShouldReverseLayout = this.mReverseLayout;
      return;
    }
    if (!this.mReverseLayout) {}
    for (;;)
    {
      this.mShouldReverseLayout = bool;
      return;
      bool = false;
    }
  }
  
  private boolean updateAnchorFromChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo)
  {
    int i = 0;
    if (getChildCount() == 0) {}
    do
    {
      return false;
      View localView = getFocusedChild();
      if ((localView != null) && (LinearLayoutManager.AnchorInfo.access$000(paramAnchorInfo, localView, paramState)))
      {
        paramAnchorInfo.assignFromViewAndKeepVisibleRect(localView);
        return true;
      }
    } while (this.mLastStackFromEnd != this.mStackFromEnd);
    if (paramAnchorInfo.mLayoutFromEnd)
    {
      paramRecycler = findReferenceChildClosestToEnd(paramRecycler, paramState);
      label66:
      if (paramRecycler == null) {
        break label165;
      }
      paramAnchorInfo.assignFromView(paramRecycler);
      if ((!paramState.isPreLayout()) && (supportsPredictiveItemAnimations()))
      {
        if ((this.mOrientationHelper.getDecoratedStart(paramRecycler) >= this.mOrientationHelper.getEndAfterPadding()) || (this.mOrientationHelper.getDecoratedEnd(paramRecycler) < this.mOrientationHelper.getStartAfterPadding())) {
          i = 1;
        }
        if (i != 0) {
          if (!paramAnchorInfo.mLayoutFromEnd) {
            break label167;
          }
        }
      }
    }
    label165:
    label167:
    for (i = this.mOrientationHelper.getEndAfterPadding();; i = this.mOrientationHelper.getStartAfterPadding())
    {
      paramAnchorInfo.mCoordinate = i;
      return true;
      paramRecycler = findReferenceChildClosestToStart(paramRecycler, paramState);
      break label66;
      break;
    }
  }
  
  private boolean updateAnchorFromPendingData(RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo)
  {
    boolean bool = false;
    if ((paramState.isPreLayout()) || (this.mPendingScrollPosition == -1)) {
      return false;
    }
    if ((this.mPendingScrollPosition < 0) || (this.mPendingScrollPosition >= paramState.getItemCount()))
    {
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = -2147483648;
      return false;
    }
    paramAnchorInfo.mPosition = this.mPendingScrollPosition;
    if ((this.mPendingSavedState != null) && (this.mPendingSavedState.hasValidAnchor()))
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
      int i;
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
        if (paramAnchorInfo.mLayoutFromEnd) {}
        for (i = this.mOrientationHelper.getDecoratedEnd(paramState) + this.mOrientationHelper.getTotalSpaceChange();; i = this.mOrientationHelper.getDecoratedStart(paramState))
        {
          paramAnchorInfo.mCoordinate = i;
          return true;
        }
      }
      if (getChildCount() > 0)
      {
        i = getPosition(getChildAt(0));
        if (this.mPendingScrollPosition >= i) {
          break label351;
        }
      }
      label351:
      for (int j = 1;; j = 0)
      {
        if (j == this.mShouldReverseLayout) {
          bool = true;
        }
        paramAnchorInfo.mLayoutFromEnd = bool;
        paramAnchorInfo.assignCoordinateFromPadding();
        return true;
      }
    }
    paramAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
    if (this.mShouldReverseLayout)
    {
      paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset);
      return true;
    }
    paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset);
    return true;
  }
  
  private void updateAnchorInfoForLayout(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo)
  {
    if (updateAnchorFromPendingData(paramState, paramAnchorInfo)) {}
    while (updateAnchorFromChildren(paramRecycler, paramState, paramAnchorInfo)) {
      return;
    }
    paramAnchorInfo.assignCoordinateFromPadding();
    if (this.mStackFromEnd) {}
    for (int i = paramState.getItemCount() - 1;; i = 0)
    {
      paramAnchorInfo.mPosition = i;
      return;
    }
  }
  
  private void updateLayoutState(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.State paramState)
  {
    int j = 1;
    int i = 1;
    LinearLayoutManager.LayoutState localLayoutState = this.mLayoutState;
    if (this.mOrientationHelper.getMode() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localLayoutState.mInfinite = bool;
      this.mLayoutState.mExtra = getExtraLayoutSpace(paramState);
      this.mLayoutState.mLayoutDirection = paramInt1;
      if (paramInt1 != 1) {
        break;
      }
      paramState = this.mLayoutState;
      paramState.mExtra += this.mOrientationHelper.getEndPadding();
      paramState = getChildClosestToEnd();
      localLayoutState = this.mLayoutState;
      paramInt1 = i;
      if (this.mShouldReverseLayout) {
        paramInt1 = -1;
      }
      localLayoutState.mItemDirection = paramInt1;
      this.mLayoutState.mCurrentPosition = (getPosition(paramState) + this.mLayoutState.mItemDirection);
      this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(paramState);
      paramInt1 = this.mOrientationHelper.getDecoratedEnd(paramState) - this.mOrientationHelper.getEndAfterPadding();
      this.mLayoutState.mAvailable = paramInt2;
      if (paramBoolean)
      {
        paramState = this.mLayoutState;
        paramState.mAvailable -= paramInt1;
      }
      this.mLayoutState.mScrollingOffset = paramInt1;
      return;
    }
    paramState = getChildClosestToStart();
    localLayoutState = this.mLayoutState;
    localLayoutState.mExtra += this.mOrientationHelper.getStartAfterPadding();
    localLayoutState = this.mLayoutState;
    if (this.mShouldReverseLayout) {}
    for (paramInt1 = j;; paramInt1 = -1)
    {
      localLayoutState.mItemDirection = paramInt1;
      this.mLayoutState.mCurrentPosition = (getPosition(paramState) + this.mLayoutState.mItemDirection);
      this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(paramState);
      paramInt1 = -this.mOrientationHelper.getDecoratedStart(paramState) + this.mOrientationHelper.getStartAfterPadding();
      break;
    }
  }
  
  private void updateLayoutStateToFillEnd(int paramInt1, int paramInt2)
  {
    this.mLayoutState.mAvailable = (this.mOrientationHelper.getEndAfterPadding() - paramInt2);
    LinearLayoutManager.LayoutState localLayoutState = this.mLayoutState;
    if (this.mShouldReverseLayout) {}
    for (int i = -1;; i = 1)
    {
      localLayoutState.mItemDirection = i;
      this.mLayoutState.mCurrentPosition = paramInt1;
      this.mLayoutState.mLayoutDirection = 1;
      this.mLayoutState.mOffset = paramInt2;
      this.mLayoutState.mScrollingOffset = -2147483648;
      return;
    }
  }
  
  private void updateLayoutStateToFillEnd(LinearLayoutManager.AnchorInfo paramAnchorInfo)
  {
    updateLayoutStateToFillEnd(paramAnchorInfo.mPosition, paramAnchorInfo.mCoordinate);
  }
  
  private void updateLayoutStateToFillStart(int paramInt1, int paramInt2)
  {
    this.mLayoutState.mAvailable = (paramInt2 - this.mOrientationHelper.getStartAfterPadding());
    this.mLayoutState.mCurrentPosition = paramInt1;
    LinearLayoutManager.LayoutState localLayoutState = this.mLayoutState;
    if (this.mShouldReverseLayout) {}
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      localLayoutState.mItemDirection = paramInt1;
      this.mLayoutState.mLayoutDirection = -1;
      this.mLayoutState.mOffset = paramInt2;
      this.mLayoutState.mScrollingOffset = -2147483648;
      return;
    }
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
    int i = 1;
    int j = 0;
    if (getChildCount() == 0) {
      return null;
    }
    if (paramInt < getPosition(getChildAt(0))) {
      j = 1;
    }
    paramInt = i;
    if (j != this.mShouldReverseLayout) {
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
    int j = -1;
    int k = 1;
    int m = -2147483648;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = -2147483648;
    case 1: 
    case 2: 
    case 33: 
    case 130: 
    case 17: 
      do
      {
        do
        {
          return i;
          return 1;
          i = j;
        } while (this.mOrientation == 1);
        return -2147483648;
        paramInt = m;
        if (this.mOrientation == 1) {
          paramInt = 1;
        }
        return paramInt;
        i = j;
      } while (this.mOrientation == 0);
      return -2147483648;
    }
    if (this.mOrientation == 0) {}
    for (paramInt = k;; paramInt = -2147483648) {
      return paramInt;
    }
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
    if (((paramLayoutState.mInfinite) || (i > 0)) && (paramLayoutState.hasMore(paramState)))
    {
      localLayoutChunkResult.resetInternal();
      layoutChunk(paramRecycler, paramState, paramLayoutState, localLayoutChunkResult);
      if (!localLayoutChunkResult.mFinished) {
        break label111;
      }
    }
    for (;;)
    {
      return k - paramLayoutState.mAvailable;
      label111:
      paramLayoutState.mOffset += localLayoutChunkResult.mConsumed * paramLayoutState.mLayoutDirection;
      int j;
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
      if (!paramBoolean) {
        break;
      }
      i = j;
      if (!localLayoutChunkResult.mFocusable) {
        break;
      }
    }
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
    if (paramInt2 > paramInt1) {}
    Object localObject;
    View localView;
    for (int i = 1;; i = -1)
    {
      localObject = null;
      if (paramInt1 == paramInt2) {
        break label130;
      }
      localView = getChildAt(paramInt1);
      int m = this.mOrientationHelper.getDecoratedStart(localView);
      int n = this.mOrientationHelper.getDecoratedEnd(localView);
      if ((m >= k) || (n <= j)) {
        break label133;
      }
      if ((paramBoolean1) && ((m < j) || (n > k))) {
        break;
      }
      return localView;
    }
    if ((paramBoolean2) && (localObject == null)) {
      localObject = localView;
    }
    label130:
    label133:
    for (;;)
    {
      paramInt1 += i;
      break;
      return localObject;
    }
  }
  
  View findReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, int paramInt3)
  {
    paramState = null;
    ensureLayoutState();
    int j = this.mOrientationHelper.getStartAfterPadding();
    int k = this.mOrientationHelper.getEndAfterPadding();
    int i;
    label35:
    Object localObject1;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      paramRecycler = null;
      if (paramInt1 == paramInt2) {
        break label157;
      }
      localObject1 = getChildAt(paramInt1);
      int m = getPosition((View)localObject1);
      if ((m < 0) || (m >= paramInt3)) {
        break label172;
      }
      if (!((RecyclerView.LayoutParams)((View)localObject1).getLayoutParams()).isItemRemoved()) {
        break label113;
      }
      if (paramRecycler != null) {
        break label172;
      }
      paramRecycler = paramState;
      paramState = (RecyclerView.State)localObject1;
    }
    for (;;)
    {
      paramInt1 += i;
      localObject1 = paramState;
      paramState = paramRecycler;
      paramRecycler = (RecyclerView.Recycler)localObject1;
      break label35;
      i = -1;
      break;
      label113:
      Object localObject2;
      if (this.mOrientationHelper.getDecoratedStart((View)localObject1) < k)
      {
        localObject2 = localObject1;
        if (this.mOrientationHelper.getDecoratedEnd((View)localObject1) >= j) {}
      }
      else
      {
        if (paramState != null) {
          break label172;
        }
        paramState = paramRecycler;
        paramRecycler = (RecyclerView.Recycler)localObject1;
        continue;
        label157:
        if (paramState == null) {
          break label167;
        }
      }
      for (;;)
      {
        localObject2 = paramState;
        return localObject2;
        label167:
        paramState = paramRecycler;
      }
      label172:
      localObject1 = paramRecycler;
      paramRecycler = paramState;
      paramState = (RecyclerView.State)localObject1;
    }
  }
  
  public View findViewByPosition(int paramInt)
  {
    int i = getChildCount();
    Object localObject;
    if (i == 0) {
      localObject = null;
    }
    View localView;
    do
    {
      return localObject;
      int j = paramInt - getPosition(getChildAt(0));
      if ((j < 0) || (j >= i)) {
        break;
      }
      localView = getChildAt(j);
      localObject = localView;
    } while (getPosition(localView) == paramInt);
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
    label61:
    int i;
    int j;
    label120:
    int k;
    int m;
    if (paramLayoutState.mScrapList == null)
    {
      bool2 = this.mShouldReverseLayout;
      if (paramLayoutState.mLayoutDirection == -1)
      {
        bool1 = true;
        if (bool2 != bool1) {
          break label215;
        }
        addView(paramRecycler);
        measureChildWithMargins(paramRecycler, 0, 0);
        paramLayoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(paramRecycler);
        if (this.mOrientation != 1) {
          break label322;
        }
        if (!isLayoutRTL()) {
          break label271;
        }
        i = getWidth() - getPaddingRight();
        j = i - this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
        if (paramLayoutState.mLayoutDirection != -1) {
          break label293;
        }
        k = paramLayoutState.mOffset;
        m = paramLayoutState.mOffset - paramLayoutChunkResult.mConsumed;
      }
    }
    for (;;)
    {
      layoutDecorated(paramRecycler, j + paramState.leftMargin, m + paramState.topMargin, i - paramState.rightMargin, k - paramState.bottomMargin);
      if ((paramState.isItemRemoved()) || (paramState.isItemChanged())) {
        paramLayoutChunkResult.mIgnoreConsumed = true;
      }
      paramLayoutChunkResult.mFocusable = paramRecycler.isFocusable();
      return;
      bool1 = false;
      break;
      label215:
      addView(paramRecycler, 0);
      break label61;
      bool2 = this.mShouldReverseLayout;
      if (paramLayoutState.mLayoutDirection == -1) {}
      for (bool1 = true;; bool1 = false)
      {
        if (bool2 != bool1) {
          break label262;
        }
        addDisappearingView(paramRecycler);
        break;
      }
      label262:
      addDisappearingView(paramRecycler, 0);
      break label61;
      label271:
      j = getPaddingLeft();
      i = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) + j;
      break label120;
      label293:
      m = paramLayoutState.mOffset;
      k = paramLayoutState.mOffset;
      int n = paramLayoutChunkResult.mConsumed;
      k += n;
      continue;
      label322:
      m = getPaddingTop();
      k = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) + m;
      if (paramLayoutState.mLayoutDirection == -1)
      {
        i = paramLayoutState.mOffset;
        j = paramLayoutState.mOffset - paramLayoutChunkResult.mConsumed;
      }
      else
      {
        j = paramLayoutState.mOffset;
        i = paramLayoutState.mOffset;
        n = paramLayoutChunkResult.mConsumed;
        i += n;
      }
    }
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
    if (getChildCount() == 0) {}
    label133:
    label135:
    label141:
    for (;;)
    {
      return null;
      paramInt = convertFocusDirectionToLayoutDirection(paramInt);
      if (paramInt != -2147483648)
      {
        ensureLayoutState();
        if (paramInt == -1)
        {
          paramView = findReferenceChildClosestToStart(paramRecycler, paramState);
          label42:
          if (paramView == null) {
            break label133;
          }
          ensureLayoutState();
          updateLayoutState(paramInt, (int)(0.3333333F * this.mOrientationHelper.getTotalSpace()), false, paramState);
          this.mLayoutState.mScrollingOffset = -2147483648;
          this.mLayoutState.mRecycle = false;
          fill(paramRecycler, this.mLayoutState, paramState, true);
          if (paramInt != -1) {
            break label135;
          }
        }
        for (paramRecycler = getChildClosestToStart();; paramRecycler = getChildClosestToEnd())
        {
          if ((paramRecycler == paramView) || (!paramRecycler.isFocusable())) {
            break label141;
          }
          return paramRecycler;
          paramView = findReferenceChildClosestToEnd(paramRecycler, paramState);
          break label42;
          break;
        }
      }
    }
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
    if ((this.mPendingSavedState != null) && (this.mPendingSavedState.hasValidAnchor())) {
      this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
    }
    ensureLayoutState();
    this.mLayoutState.mRecycle = false;
    resolveShouldLayoutReverse();
    this.mAnchorInfo.reset();
    this.mAnchorInfo.mLayoutFromEnd = (this.mShouldReverseLayout ^ this.mStackFromEnd);
    updateAnchorInfoForLayout(paramRecycler, paramState, this.mAnchorInfo);
    int i = getExtraLayoutSpace(paramState);
    int j;
    int m;
    int n;
    int k;
    Object localObject;
    label248:
    boolean bool;
    if (this.mLayoutState.mLastScrollDelta >= 0)
    {
      j = 0;
      m = j + this.mOrientationHelper.getStartAfterPadding();
      n = i + this.mOrientationHelper.getEndPadding();
      j = n;
      k = m;
      if (paramState.isPreLayout())
      {
        j = n;
        k = m;
        if (this.mPendingScrollPosition != -1)
        {
          j = n;
          k = m;
          if (this.mPendingScrollPositionOffset != -2147483648)
          {
            localObject = findViewByPosition(this.mPendingScrollPosition);
            j = n;
            k = m;
            if (localObject != null)
            {
              if (!this.mShouldReverseLayout) {
                break label663;
              }
              i = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd((View)localObject) - this.mPendingScrollPositionOffset;
              if (i <= 0) {
                break label695;
              }
              k = m + i;
              j = n;
            }
          }
        }
      }
      label262:
      if (!this.mAnchorInfo.mLayoutFromEnd) {
        break label713;
      }
      if (!this.mShouldReverseLayout) {
        break label708;
      }
      i = 1;
      label281:
      onAnchorReady(paramRecycler, paramState, this.mAnchorInfo, i);
      detachAndScrapAttachedViews(paramRecycler);
      localObject = this.mLayoutState;
      if (this.mOrientationHelper.getMode() != 0) {
        break label730;
      }
      bool = true;
      label316:
      ((LinearLayoutManager.LayoutState)localObject).mInfinite = bool;
      this.mLayoutState.mIsPreLayout = paramState.isPreLayout();
      if (!this.mAnchorInfo.mLayoutFromEnd) {
        break label736;
      }
      updateLayoutStateToFillStart(this.mAnchorInfo);
      this.mLayoutState.mExtra = k;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      m = this.mLayoutState.mOffset;
      n = this.mLayoutState.mCurrentPosition;
      i = j;
      if (this.mLayoutState.mAvailable > 0) {
        i = j + this.mLayoutState.mAvailable;
      }
      updateLayoutStateToFillEnd(this.mAnchorInfo);
      this.mLayoutState.mExtra = i;
      localObject = this.mLayoutState;
      ((LinearLayoutManager.LayoutState)localObject).mCurrentPosition += this.mLayoutState.mItemDirection;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      k = this.mLayoutState.mOffset;
      if (this.mLayoutState.mAvailable <= 0) {
        break label981;
      }
      i = this.mLayoutState.mAvailable;
      updateLayoutStateToFillStart(n, m);
      this.mLayoutState.mExtra = i;
      fill(paramRecycler, this.mLayoutState, paramState, false);
    }
    label536:
    label695:
    label708:
    label713:
    label981:
    for (i = this.mLayoutState.mOffset;; i = m)
    {
      j = i;
      i = k;
      k = i;
      m = j;
      if (getChildCount() > 0)
      {
        if (!(this.mShouldReverseLayout ^ this.mStackFromEnd)) {
          break label936;
        }
        k = fixLayoutEndGap(i, paramRecycler, paramState, true);
        m = j + k;
        j = fixLayoutStartGap(m, paramRecycler, paramState, false);
        m += j;
      }
      for (k = i + k + j;; k = i + n)
      {
        layoutForPredictiveAnimations(paramRecycler, paramState, m, k);
        if (!paramState.isPreLayout())
        {
          this.mPendingScrollPosition = -1;
          this.mPendingScrollPositionOffset = -2147483648;
          this.mOrientationHelper.onLayoutComplete();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
        this.mPendingSavedState = null;
        return;
        j = i;
        i = 0;
        break;
        i = this.mOrientationHelper.getDecoratedStart((View)localObject);
        j = this.mOrientationHelper.getStartAfterPadding();
        i = this.mPendingScrollPositionOffset - (i - j);
        break label248;
        j = n - i;
        k = m;
        break label262;
        i = -1;
        break label281;
        if (this.mShouldReverseLayout)
        {
          i = -1;
          break label281;
        }
        i = 1;
        break label281;
        label730:
        bool = false;
        break label316;
        label736:
        updateLayoutStateToFillEnd(this.mAnchorInfo);
        this.mLayoutState.mExtra = j;
        fill(paramRecycler, this.mLayoutState, paramState, false);
        m = this.mLayoutState.mOffset;
        n = this.mLayoutState.mCurrentPosition;
        i = k;
        if (this.mLayoutState.mAvailable > 0) {
          i = k + this.mLayoutState.mAvailable;
        }
        updateLayoutStateToFillStart(this.mAnchorInfo);
        this.mLayoutState.mExtra = i;
        localObject = this.mLayoutState;
        ((LinearLayoutManager.LayoutState)localObject).mCurrentPosition += this.mLayoutState.mItemDirection;
        fill(paramRecycler, this.mLayoutState, paramState, false);
        k = this.mLayoutState.mOffset;
        i = m;
        j = k;
        if (this.mLayoutState.mAvailable <= 0) {
          break label536;
        }
        i = this.mLayoutState.mAvailable;
        updateLayoutStateToFillEnd(n, m);
        this.mLayoutState.mExtra = i;
        fill(paramRecycler, this.mLayoutState, paramState, false);
        i = this.mLayoutState.mOffset;
        j = k;
        break label536;
        k = fixLayoutStartGap(j, paramRecycler, paramState, true);
        i += k;
        n = fixLayoutEndGap(i, paramRecycler, paramState, false);
        m = j + k + n;
      }
    }
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
    if (this.mPendingSavedState != null) {
      return new LinearLayoutManager.SavedState(this.mPendingSavedState);
    }
    LinearLayoutManager.SavedState localSavedState = new LinearLayoutManager.SavedState();
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
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    this.mLayoutState.mRecycle = true;
    ensureLayoutState();
    if (paramInt > 0) {}
    int j;
    int k;
    for (int i = 1;; i = -1)
    {
      j = Math.abs(paramInt);
      updateLayoutState(i, j, true, paramState);
      k = this.mLayoutState.mScrollingOffset + fill(paramRecycler, this.mLayoutState, paramState, false);
      if (k >= 0) {
        break;
      }
      return 0;
    }
    if (j > k) {
      paramInt = i * k;
    }
    this.mOrientationHelper.offsetChildren(-paramInt);
    this.mLayoutState.mLastScrollDelta = paramInt;
    return paramInt;
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
    if (this.mPendingSavedState != null) {
      this.mPendingSavedState.invalidateAnchor();
    }
    requestLayout();
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    this.mPendingScrollPosition = paramInt1;
    this.mPendingScrollPositionOffset = paramInt2;
    if (this.mPendingSavedState != null) {
      this.mPendingSavedState.invalidateAnchor();
    }
    requestLayout();
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
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:" + paramInt);
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
    boolean bool2 = true;
    boolean bool1 = true;
    Log.d("LinearLayoutManager", "validating child count " + getChildCount());
    if (getChildCount() < 1) {}
    for (;;)
    {
      return;
      int j = getPosition(getChildAt(0));
      int k = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
      int i;
      Object localObject;
      int m;
      int n;
      if (this.mShouldReverseLayout)
      {
        i = 1;
        while (i < getChildCount())
        {
          localObject = getChildAt(i);
          m = getPosition((View)localObject);
          n = this.mOrientationHelper.getDecoratedStart((View)localObject);
          if (m < j)
          {
            logChildren();
            localObject = new StringBuilder().append("detected invalid position. loc invalid? ");
            if (n < k) {}
            for (;;)
            {
              throw new RuntimeException(bool1);
              bool1 = false;
            }
          }
          if (n > k)
          {
            logChildren();
            throw new RuntimeException("detected invalid location");
          }
          i += 1;
        }
      }
      else
      {
        i = 1;
        while (i < getChildCount())
        {
          localObject = getChildAt(i);
          m = getPosition((View)localObject);
          n = this.mOrientationHelper.getDecoratedStart((View)localObject);
          if (m < j)
          {
            logChildren();
            localObject = new StringBuilder().append("detected invalid position. loc invalid? ");
            if (n < k) {}
            for (bool1 = bool2;; bool1 = false) {
              throw new RuntimeException(bool1);
            }
          }
          if (n < k)
          {
            logChildren();
            throw new RuntimeException("detected invalid location");
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */