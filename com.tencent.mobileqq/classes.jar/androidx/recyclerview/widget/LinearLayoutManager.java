package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import java.util.List;

public class LinearLayoutManager
  extends RecyclerView.LayoutManager
  implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider
{
  static final boolean DEBUG = false;
  public static final int HORIZONTAL = 0;
  public static final int INVALID_OFFSET = -2147483648;
  private static final float MAX_SCROLL_FACTOR = 0.3333333F;
  private static final String TAG = "LinearLayoutManager";
  public static final int VERTICAL = 1;
  final LinearLayoutManager.AnchorInfo mAnchorInfo = new LinearLayoutManager.AnchorInfo();
  private int mInitialPrefetchItemCount = 2;
  private boolean mLastStackFromEnd;
  private final LinearLayoutManager.LayoutChunkResult mLayoutChunkResult = new LinearLayoutManager.LayoutChunkResult();
  private LinearLayoutManager.LayoutState mLayoutState;
  int mOrientation = 1;
  OrientationHelper mOrientationHelper;
  LinearLayoutManager.SavedState mPendingSavedState = null;
  int mPendingScrollPosition = -1;
  int mPendingScrollPositionOffset = -2147483648;
  private boolean mRecycleChildrenOnDetach;
  private int[] mReusableIntPair = new int[2];
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
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(paramContext.orientation);
    setReverseLayout(paramContext.reverseLayout);
    setStackFromEnd(paramContext.stackFromEnd);
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
  
  private View findFirstPartiallyOrCompletelyInvisibleChild()
  {
    return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
  }
  
  private View findFirstReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return findReferenceChild(paramRecycler, paramState, 0, getChildCount(), paramState.getItemCount());
  }
  
  private View findLastPartiallyOrCompletelyInvisibleChild()
  {
    return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
  }
  
  private View findLastReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return findReferenceChild(paramRecycler, paramState, getChildCount() - 1, -1, paramState.getItemCount());
  }
  
  private View findPartiallyOrCompletelyInvisibleChildClosestToEnd()
  {
    if (this.mShouldReverseLayout) {
      return findFirstPartiallyOrCompletelyInvisibleChild();
    }
    return findLastPartiallyOrCompletelyInvisibleChild();
  }
  
  private View findPartiallyOrCompletelyInvisibleChildClosestToStart()
  {
    if (this.mShouldReverseLayout) {
      return findLastPartiallyOrCompletelyInvisibleChild();
    }
    return findFirstPartiallyOrCompletelyInvisibleChild();
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
      this.mLayoutState.mExtraFillSpace = i;
      this.mLayoutState.mAvailable = 0;
      this.mLayoutState.assignPositionFromScrapList();
      fill(paramRecycler, this.mLayoutState, paramState, false);
    }
    if (j > 0)
    {
      updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), paramInt2);
      this.mLayoutState.mExtraFillSpace = j;
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
    int i = paramLayoutState.mScrollingOffset;
    int j = paramLayoutState.mNoRecycleSpace;
    if (paramLayoutState.mLayoutDirection == -1)
    {
      recycleViewsFromEnd(paramRecycler, i, j);
      return;
    }
    recycleViewsFromStart(paramRecycler, i, j);
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
  
  private void recycleViewsFromEnd(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    if (paramInt1 < 0) {}
    for (;;)
    {
      return;
      paramInt2 = this.mOrientationHelper.getEnd() - paramInt1 + paramInt2;
      View localView;
      if (this.mShouldReverseLayout)
      {
        paramInt1 = 0;
        while (paramInt1 < i)
        {
          localView = getChildAt(paramInt1);
          if ((this.mOrientationHelper.getDecoratedStart(localView) < paramInt2) || (this.mOrientationHelper.getTransformedStartWithDecoration(localView) < paramInt2))
          {
            recycleChildren(paramRecycler, 0, paramInt1);
            return;
          }
          paramInt1 += 1;
        }
      }
      else
      {
        paramInt1 = i - 1;
        while (paramInt1 >= 0)
        {
          localView = getChildAt(paramInt1);
          if ((this.mOrientationHelper.getDecoratedStart(localView) < paramInt2) || (this.mOrientationHelper.getTransformedStartWithDecoration(localView) < paramInt2))
          {
            recycleChildren(paramRecycler, i - 1, paramInt1);
            return;
          }
          paramInt1 -= 1;
        }
      }
    }
  }
  
  private void recycleViewsFromStart(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {}
    for (;;)
    {
      return;
      paramInt2 = paramInt1 - paramInt2;
      int i = getChildCount();
      View localView;
      if (this.mShouldReverseLayout)
      {
        paramInt1 = i - 1;
        while (paramInt1 >= 0)
        {
          localView = getChildAt(paramInt1);
          if ((this.mOrientationHelper.getDecoratedEnd(localView) > paramInt2) || (this.mOrientationHelper.getTransformedEndWithDecoration(localView) > paramInt2))
          {
            recycleChildren(paramRecycler, i - 1, paramInt1);
            return;
          }
          paramInt1 -= 1;
        }
      }
      else
      {
        paramInt1 = 0;
        while (paramInt1 < i)
        {
          localView = getChildAt(paramInt1);
          if ((this.mOrientationHelper.getDecoratedEnd(localView) > paramInt2) || (this.mOrientationHelper.getTransformedEndWithDecoration(localView) > paramInt2))
          {
            recycleChildren(paramRecycler, 0, paramInt1);
            return;
          }
          paramInt1 += 1;
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
      if ((localView != null) && (paramAnchorInfo.isViewValidAsAnchor(localView, paramState)))
      {
        paramAnchorInfo.assignFromViewAndKeepVisibleRect(localView, getPosition(localView));
        return true;
      }
    } while (this.mLastStackFromEnd != this.mStackFromEnd);
    if (paramAnchorInfo.mLayoutFromEnd)
    {
      paramRecycler = findReferenceChildClosestToEnd(paramRecycler, paramState);
      label72:
      if (paramRecycler == null) {
        break label176;
      }
      paramAnchorInfo.assignFromView(paramRecycler, getPosition(paramRecycler));
      if ((!paramState.isPreLayout()) && (supportsPredictiveItemAnimations()))
      {
        if ((this.mOrientationHelper.getDecoratedStart(paramRecycler) >= this.mOrientationHelper.getEndAfterPadding()) || (this.mOrientationHelper.getDecoratedEnd(paramRecycler) < this.mOrientationHelper.getStartAfterPadding())) {
          i = 1;
        }
        if (i != 0) {
          if (!paramAnchorInfo.mLayoutFromEnd) {
            break label178;
          }
        }
      }
    }
    label176:
    label178:
    for (i = this.mOrientationHelper.getEndAfterPadding();; i = this.mOrientationHelper.getStartAfterPadding())
    {
      paramAnchorInfo.mCoordinate = i;
      return true;
      paramRecycler = findReferenceChildClosestToStart(paramRecycler, paramState);
      break label72;
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
    int n = 1;
    int m = 1;
    int k = 0;
    this.mLayoutState.mInfinite = resolveIsInfinite();
    this.mLayoutState.mLayoutDirection = paramInt1;
    this.mReusableIntPair[0] = 0;
    this.mReusableIntPair[1] = 0;
    calculateExtraLayoutSpace(paramState, this.mReusableIntPair);
    int i = Math.max(0, this.mReusableIntPair[0]);
    int j = Math.max(0, this.mReusableIntPair[1]);
    if (paramInt1 == 1) {
      k = 1;
    }
    paramState = this.mLayoutState;
    if (k != 0)
    {
      paramInt1 = j;
      paramState.mExtraFillSpace = paramInt1;
      paramState = this.mLayoutState;
      if (k == 0) {
        break label281;
      }
    }
    for (;;)
    {
      paramState.mNoRecycleSpace = i;
      if (k == 0) {
        break label288;
      }
      paramState = this.mLayoutState;
      paramState.mExtraFillSpace += this.mOrientationHelper.getEndPadding();
      paramState = getChildClosestToEnd();
      localLayoutState = this.mLayoutState;
      paramInt1 = m;
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
      paramInt1 = i;
      break;
      label281:
      i = j;
    }
    label288:
    paramState = getChildClosestToStart();
    LinearLayoutManager.LayoutState localLayoutState = this.mLayoutState;
    localLayoutState.mExtraFillSpace += this.mOrientationHelper.getStartAfterPadding();
    localLayoutState = this.mLayoutState;
    if (this.mShouldReverseLayout) {}
    for (paramInt1 = n;; paramInt1 = -1)
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
  
  protected void calculateExtraLayoutSpace(@NonNull RecyclerView.State paramState, @NonNull int[] paramArrayOfInt)
  {
    int i = getExtraLayoutSpace(paramState);
    int j;
    if (this.mLayoutState.mLayoutDirection == -1)
    {
      int k = 0;
      j = i;
      i = k;
    }
    for (;;)
    {
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = i;
      return;
      j = 0;
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
  
  public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.State paramState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    if (this.mOrientation == 0) {}
    while ((getChildCount() == 0) || (paramInt1 == 0))
    {
      return;
      paramInt1 = paramInt2;
    }
    ensureLayoutState();
    if (paramInt1 > 0) {}
    for (paramInt2 = 1;; paramInt2 = -1)
    {
      updateLayoutState(paramInt2, Math.abs(paramInt1), true, paramState);
      collectPrefetchPositionsForLayoutState(paramState, this.mLayoutState, paramLayoutPrefetchRegistry);
      return;
    }
  }
  
  public void collectInitialPrefetchPositions(int paramInt, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    boolean bool;
    int i;
    if ((this.mPendingSavedState != null) && (this.mPendingSavedState.hasValidAnchor()))
    {
      bool = this.mPendingSavedState.mAnchorLayoutFromEnd;
      i = this.mPendingSavedState.mAnchorPosition;
      if (!bool) {
        break label136;
      }
    }
    label136:
    for (int j = -1;; j = 1)
    {
      int m = 0;
      int k = i;
      i = m;
      while ((i < this.mInitialPrefetchItemCount) && (k >= 0) && (k < paramInt))
      {
        paramLayoutPrefetchRegistry.addPosition(k, 0);
        k += j;
        i += 1;
      }
      resolveShouldLayoutReverse();
      bool = this.mShouldReverseLayout;
      if (this.mPendingScrollPosition == -1)
      {
        if (bool) {}
        for (i = paramInt - 1;; i = 0) {
          break;
        }
      }
      i = this.mPendingScrollPosition;
      break;
    }
  }
  
  void collectPrefetchPositionsForLayoutState(RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    int i = paramLayoutState.mCurrentPosition;
    if ((i >= 0) && (i < paramState.getItemCount())) {
      paramLayoutPrefetchRegistry.addPosition(i, Math.max(0, paramLayoutState.mScrollingOffset));
    }
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
    int i = -1;
    int j = -2147483648;
    int k = 1;
    switch (paramInt)
    {
    default: 
      paramInt = -2147483648;
    case 1: 
    case 2: 
    case 33: 
    case 130: 
    case 17: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return paramInt;
                paramInt = i;
              } while (this.mOrientation == 1);
              paramInt = i;
            } while (!isLayoutRTL());
            return 1;
            if (this.mOrientation == 1) {
              return 1;
            }
            paramInt = i;
          } while (isLayoutRTL());
          return 1;
          paramInt = i;
        } while (this.mOrientation == 1);
        return -2147483648;
        paramInt = j;
        if (this.mOrientation == 1) {
          paramInt = 1;
        }
        return paramInt;
        paramInt = i;
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
    int i = paramLayoutState.mAvailable + paramLayoutState.mExtraFillSpace;
    LinearLayoutManager.LayoutChunkResult localLayoutChunkResult = this.mLayoutChunkResult;
    if (((paramLayoutState.mInfinite) || (i > 0)) && (paramLayoutState.hasMore(paramState)))
    {
      localLayoutChunkResult.resetInternal();
      layoutChunk(paramRecycler, paramState, paramLayoutState, localLayoutChunkResult);
      if (!localLayoutChunkResult.mFinished) {
        break label108;
      }
    }
    for (;;)
    {
      return k - paramLayoutState.mAvailable;
      label108:
      paramLayoutState.mOffset += localLayoutChunkResult.mConsumed * paramLayoutState.mLayoutDirection;
      int j;
      if ((localLayoutChunkResult.mIgnoreConsumed) && (paramLayoutState.mScrapList == null))
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
  
  View findFirstVisibleChildClosestToEnd(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mShouldReverseLayout) {
      return findOneVisibleChild(0, getChildCount(), paramBoolean1, paramBoolean2);
    }
    return findOneVisibleChild(getChildCount() - 1, -1, paramBoolean1, paramBoolean2);
  }
  
  View findFirstVisibleChildClosestToStart(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mShouldReverseLayout) {
      return findOneVisibleChild(getChildCount() - 1, -1, paramBoolean1, paramBoolean2);
    }
    return findOneVisibleChild(0, getChildCount(), paramBoolean1, paramBoolean2);
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
  
  View findOnePartiallyOrCompletelyInvisibleChild(int paramInt1, int paramInt2)
  {
    ensureLayoutState();
    if (paramInt2 > paramInt1) {
      i = 1;
    }
    while (i == 0)
    {
      return getChildAt(paramInt1);
      if (paramInt2 < paramInt1) {
        i = -1;
      } else {
        i = 0;
      }
    }
    int j;
    if (this.mOrientationHelper.getDecoratedStart(getChildAt(paramInt1)) < this.mOrientationHelper.getStartAfterPadding()) {
      j = 16644;
    }
    for (int i = 16388; this.mOrientation == 0; i = 4097)
    {
      return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(paramInt1, paramInt2, j, i);
      j = 4161;
    }
    return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(paramInt1, paramInt2, j, i);
  }
  
  View findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 320;
    ensureLayoutState();
    int i;
    if (paramBoolean1)
    {
      i = 24579;
      if (!paramBoolean2) {
        break label66;
      }
    }
    for (;;)
    {
      if (this.mOrientation == 0)
      {
        return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(paramInt1, paramInt2, i, j);
        i = 320;
        break;
      }
      return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(paramInt1, paramInt2, i, j);
      label66:
      j = 0;
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
  
  @Deprecated
  protected int getExtraLayoutSpace(RecyclerView.State paramState)
  {
    if (paramState.hasTargetScrollPosition()) {
      return this.mOrientationHelper.getTotalSpace();
    }
    return 0;
  }
  
  public int getInitialPrefetchItemCount()
  {
    return this.mInitialPrefetchItemCount;
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
  
  public boolean isAutoMeasureEnabled()
  {
    return true;
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
    int m;
    int k;
    if (paramLayoutState.mScrapList == null)
    {
      bool2 = this.mShouldReverseLayout;
      if (paramLayoutState.mLayoutDirection == -1)
      {
        bool1 = true;
        if (bool2 != bool1) {
          break label195;
        }
        addView(paramRecycler);
        measureChildWithMargins(paramRecycler, 0, 0);
        paramLayoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(paramRecycler);
        if (this.mOrientation != 1) {
          break label298;
        }
        if (!isLayoutRTL()) {
          break label251;
        }
        i = getWidth() - getPaddingRight();
        j = i - this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
        if (paramLayoutState.mLayoutDirection != -1) {
          break label273;
        }
        m = paramLayoutState.mOffset;
        k = paramLayoutState.mOffset - paramLayoutChunkResult.mConsumed;
      }
    }
    for (;;)
    {
      layoutDecoratedWithMargins(paramRecycler, j, k, i, m);
      if ((paramState.isItemRemoved()) || (paramState.isItemChanged())) {
        paramLayoutChunkResult.mIgnoreConsumed = true;
      }
      paramLayoutChunkResult.mFocusable = paramRecycler.hasFocusable();
      return;
      bool1 = false;
      break;
      label195:
      addView(paramRecycler, 0);
      break label61;
      bool2 = this.mShouldReverseLayout;
      if (paramLayoutState.mLayoutDirection == -1) {}
      for (bool1 = true;; bool1 = false)
      {
        if (bool2 != bool1) {
          break label242;
        }
        addDisappearingView(paramRecycler);
        break;
      }
      label242:
      addDisappearingView(paramRecycler, 0);
      break label61;
      label251:
      j = getPaddingLeft();
      i = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) + j;
      break label120;
      label273:
      k = paramLayoutState.mOffset;
      m = paramLayoutState.mOffset;
      m = paramLayoutChunkResult.mConsumed + m;
      continue;
      label298:
      k = getPaddingTop();
      m = k + this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
      if (paramLayoutState.mLayoutDirection == -1)
      {
        i = paramLayoutState.mOffset;
        j = paramLayoutState.mOffset - paramLayoutChunkResult.mConsumed;
      }
      else
      {
        j = paramLayoutState.mOffset;
        i = paramLayoutState.mOffset + paramLayoutChunkResult.mConsumed;
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
    if (getChildCount() == 0)
    {
      paramView = null;
      return paramView;
    }
    paramInt = convertFocusDirectionToLayoutDirection(paramInt);
    if (paramInt == -2147483648) {
      return null;
    }
    ensureLayoutState();
    updateLayoutState(paramInt, (int)(0.3333333F * this.mOrientationHelper.getTotalSpace()), false, paramState);
    this.mLayoutState.mScrollingOffset = -2147483648;
    this.mLayoutState.mRecycle = false;
    fill(paramRecycler, this.mLayoutState, paramState, true);
    if (paramInt == -1)
    {
      paramRecycler = findPartiallyOrCompletelyInvisibleChildClosestToStart();
      label93:
      if (paramInt != -1) {
        break label124;
      }
    }
    label124:
    for (paramView = getChildClosestToStart();; paramView = getChildClosestToEnd())
    {
      if (!paramView.hasFocusable()) {
        return paramRecycler;
      }
      if (paramRecycler != null) {
        break;
      }
      return null;
      paramRecycler = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
      break label93;
    }
    return paramRecycler;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
      paramAccessibilityEvent.setToIndex(findLastVisibleItemPosition());
    }
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    int k = -1;
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
    Object localObject = getFocusedChild();
    label165:
    int m;
    int n;
    int j;
    if ((!this.mAnchorInfo.mValid) || (this.mPendingScrollPosition != -1) || (this.mPendingSavedState != null))
    {
      this.mAnchorInfo.reset();
      this.mAnchorInfo.mLayoutFromEnd = (this.mShouldReverseLayout ^ this.mStackFromEnd);
      updateAnchorInfoForLayout(paramRecycler, paramState, this.mAnchorInfo);
      this.mAnchorInfo.mValid = true;
      localObject = this.mLayoutState;
      if (this.mLayoutState.mLastScrollDelta < 0) {
        break label780;
      }
      i = 1;
      ((LinearLayoutManager.LayoutState)localObject).mLayoutDirection = i;
      this.mReusableIntPair[0] = 0;
      this.mReusableIntPair[1] = 0;
      calculateExtraLayoutSpace(paramState, this.mReusableIntPair);
      i = Math.max(0, this.mReusableIntPair[0]);
      m = this.mOrientationHelper.getStartAfterPadding() + i;
      n = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.getEndPadding();
      i = n;
      j = m;
      if (paramState.isPreLayout())
      {
        i = n;
        j = m;
        if (this.mPendingScrollPosition != -1)
        {
          i = n;
          j = m;
          if (this.mPendingScrollPositionOffset != -2147483648)
          {
            localObject = findViewByPosition(this.mPendingScrollPosition);
            i = n;
            j = m;
            if (localObject != null)
            {
              if (!this.mShouldReverseLayout) {
                break label785;
              }
              i = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd((View)localObject) - this.mPendingScrollPositionOffset;
              label333:
              if (i <= 0) {
                break label817;
              }
              j = m + i;
              i = n;
            }
          }
        }
      }
      label346:
      if (!this.mAnchorInfo.mLayoutFromEnd) {
        break label829;
      }
      if (this.mShouldReverseLayout) {
        k = 1;
      }
      label366:
      onAnchorReady(paramRecycler, paramState, this.mAnchorInfo, k);
      detachAndScrapAttachedViews(paramRecycler);
      this.mLayoutState.mInfinite = resolveIsInfinite();
      this.mLayoutState.mIsPreLayout = paramState.isPreLayout();
      this.mLayoutState.mNoRecycleSpace = 0;
      if (!this.mAnchorInfo.mLayoutFromEnd) {
        break label842;
      }
      updateLayoutStateToFillStart(this.mAnchorInfo);
      this.mLayoutState.mExtraFillSpace = j;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      m = this.mLayoutState.mOffset;
      n = this.mLayoutState.mCurrentPosition;
      j = i;
      if (this.mLayoutState.mAvailable > 0) {
        j = i + this.mLayoutState.mAvailable;
      }
      updateLayoutStateToFillEnd(this.mAnchorInfo);
      this.mLayoutState.mExtraFillSpace = j;
      localObject = this.mLayoutState;
      ((LinearLayoutManager.LayoutState)localObject).mCurrentPosition += this.mLayoutState.mItemDirection;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      k = this.mLayoutState.mOffset;
      if (this.mLayoutState.mAvailable <= 0) {
        break label1096;
      }
      i = this.mLayoutState.mAvailable;
      updateLayoutStateToFillStart(n, m);
      this.mLayoutState.mExtraFillSpace = i;
      fill(paramRecycler, this.mLayoutState, paramState, false);
    }
    label686:
    label817:
    label829:
    label1086:
    label1096:
    for (int i = this.mLayoutState.mOffset;; i = m)
    {
      j = i;
      i = k;
      label616:
      k = i;
      m = j;
      if (getChildCount() > 0)
      {
        if ((this.mShouldReverseLayout ^ this.mStackFromEnd))
        {
          k = fixLayoutEndGap(i, paramRecycler, paramState, true);
          m = j + k;
          j = fixLayoutStartGap(m, paramRecycler, paramState, false);
          m += j;
          k = i + k + j;
        }
      }
      else
      {
        layoutForPredictiveAnimations(paramRecycler, paramState, m, k);
        if (paramState.isPreLayout()) {
          break label1086;
        }
        this.mOrientationHelper.onLayoutComplete();
      }
      for (;;)
      {
        this.mLastStackFromEnd = this.mStackFromEnd;
        return;
        if ((localObject == null) || ((this.mOrientationHelper.getDecoratedStart((View)localObject) < this.mOrientationHelper.getEndAfterPadding()) && (this.mOrientationHelper.getDecoratedEnd((View)localObject) > this.mOrientationHelper.getStartAfterPadding()))) {
          break;
        }
        this.mAnchorInfo.assignFromViewAndKeepVisibleRect((View)localObject, getPosition((View)localObject));
        break;
        i = -1;
        break label165;
        i = this.mOrientationHelper.getDecoratedStart((View)localObject);
        j = this.mOrientationHelper.getStartAfterPadding();
        i = this.mPendingScrollPositionOffset - (i - j);
        break label333;
        i = n - i;
        j = m;
        break label346;
        if (this.mShouldReverseLayout) {
          break label366;
        }
        k = 1;
        break label366;
        label842:
        updateLayoutStateToFillEnd(this.mAnchorInfo);
        this.mLayoutState.mExtraFillSpace = i;
        fill(paramRecycler, this.mLayoutState, paramState, false);
        k = this.mLayoutState.mOffset;
        n = this.mLayoutState.mCurrentPosition;
        i = j;
        if (this.mLayoutState.mAvailable > 0) {
          i = j + this.mLayoutState.mAvailable;
        }
        updateLayoutStateToFillStart(this.mAnchorInfo);
        this.mLayoutState.mExtraFillSpace = i;
        localObject = this.mLayoutState;
        ((LinearLayoutManager.LayoutState)localObject).mCurrentPosition += this.mLayoutState.mItemDirection;
        fill(paramRecycler, this.mLayoutState, paramState, false);
        m = this.mLayoutState.mOffset;
        i = k;
        j = m;
        if (this.mLayoutState.mAvailable <= 0) {
          break label616;
        }
        i = this.mLayoutState.mAvailable;
        updateLayoutStateToFillEnd(n, k);
        this.mLayoutState.mExtraFillSpace = i;
        fill(paramRecycler, this.mLayoutState, paramState, false);
        i = this.mLayoutState.mOffset;
        j = m;
        break label616;
        k = fixLayoutStartGap(j, paramRecycler, paramState, true);
        i += k;
        n = fixLayoutEndGap(i, paramRecycler, paramState, false);
        m = j + k + n;
        k = i + n;
        break label686;
        this.mAnchorInfo.reset();
      }
    }
  }
  
  public void onLayoutCompleted(RecyclerView.State paramState)
  {
    super.onLayoutCompleted(paramState);
    this.mPendingSavedState = null;
    this.mPendingScrollPosition = -1;
    this.mPendingScrollPositionOffset = -2147483648;
    this.mAnchorInfo.reset();
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
  
  public void prepareForDrop(@NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
  {
    assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
    ensureLayoutState();
    resolveShouldLayoutReverse();
    paramInt1 = getPosition(paramView1);
    paramInt2 = getPosition(paramView2);
    if (paramInt1 < paramInt2) {
      paramInt1 = 1;
    }
    while (this.mShouldReverseLayout) {
      if (paramInt1 == 1)
      {
        scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(paramView2) + this.mOrientationHelper.getDecoratedMeasurement(paramView1)));
        return;
        paramInt1 = -1;
      }
      else
      {
        scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(paramView2));
        return;
      }
    }
    if (paramInt1 == -1)
    {
      scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getDecoratedStart(paramView2));
      return;
    }
    scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getDecoratedEnd(paramView2) - this.mOrientationHelper.getDecoratedMeasurement(paramView1));
  }
  
  boolean resolveIsInfinite()
  {
    return (this.mOrientationHelper.getMode() == 0) && (this.mOrientationHelper.getEnd() == 0);
  }
  
  int scrollBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if ((getChildCount() == 0) || (paramInt == 0)) {
      return 0;
    }
    ensureLayoutState();
    this.mLayoutState.mRecycle = true;
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
  
  public void setInitialPrefetchItemCount(int paramInt)
  {
    this.mInitialPrefetchItemCount = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation:" + paramInt);
    }
    assertNotInLayoutOrScroll(null);
    if ((paramInt != this.mOrientation) || (this.mOrientationHelper == null))
    {
      this.mOrientationHelper = OrientationHelper.createOrientationHelper(this, paramInt);
      this.mAnchorInfo.mOrientationHelper = this.mOrientationHelper;
      this.mOrientation = paramInt;
      requestLayout();
    }
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
    paramRecyclerView = new LinearSmoothScroller(paramRecyclerView.getContext());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.LinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */