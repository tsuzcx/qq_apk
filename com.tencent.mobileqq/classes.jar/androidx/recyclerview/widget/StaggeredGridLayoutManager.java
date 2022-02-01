package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class StaggeredGridLayoutManager
  extends RecyclerView.LayoutManager
  implements RecyclerView.SmoothScroller.ScrollVectorProvider
{
  static final boolean DEBUG = false;
  @Deprecated
  public static final int GAP_HANDLING_LAZY = 1;
  public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
  public static final int GAP_HANDLING_NONE = 0;
  public static final int HORIZONTAL = 0;
  static final int INVALID_OFFSET = -2147483648;
  private static final float MAX_SCROLL_FACTOR = 0.3333333F;
  private static final String TAG = "StaggeredGridLManager";
  public static final int VERTICAL = 1;
  private final StaggeredGridLayoutManager.AnchorInfo mAnchorInfo = new StaggeredGridLayoutManager.AnchorInfo(this);
  private final Runnable mCheckForGapsRunnable = new StaggeredGridLayoutManager.1(this);
  private int mFullSizeSpec;
  private int mGapStrategy = 2;
  private boolean mLaidOutInvalidFullSpan = false;
  private boolean mLastLayoutFromEnd;
  private boolean mLastLayoutRTL;
  @NonNull
  private final LayoutState mLayoutState;
  StaggeredGridLayoutManager.LazySpanLookup mLazySpanLookup = new StaggeredGridLayoutManager.LazySpanLookup();
  private int mOrientation;
  private StaggeredGridLayoutManager.SavedState mPendingSavedState;
  int mPendingScrollPosition = -1;
  int mPendingScrollPositionOffset = -2147483648;
  private int[] mPrefetchDistances;
  @NonNull
  OrientationHelper mPrimaryOrientation;
  private BitSet mRemainingSpans;
  boolean mReverseLayout = false;
  @NonNull
  OrientationHelper mSecondaryOrientation;
  boolean mShouldReverseLayout = false;
  private int mSizePerSpan;
  private boolean mSmoothScrollbarEnabled = true;
  private int mSpanCount = -1;
  StaggeredGridLayoutManager.Span[] mSpans;
  private final Rect mTmpRect = new Rect();
  
  public StaggeredGridLayoutManager(int paramInt1, int paramInt2)
  {
    this.mOrientation = paramInt2;
    setSpanCount(paramInt1);
    this.mLayoutState = new LayoutState();
    createOrientationHelpers();
  }
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(paramContext.orientation);
    setSpanCount(paramContext.spanCount);
    setReverseLayout(paramContext.reverseLayout);
    this.mLayoutState = new LayoutState();
    createOrientationHelpers();
  }
  
  private void appendViewToAllSpans(View paramView)
  {
    int i = this.mSpanCount - 1;
    while (i >= 0)
    {
      this.mSpans[i].appendToSpan(paramView);
      i -= 1;
    }
  }
  
  private void applyPendingSavedState(StaggeredGridLayoutManager.AnchorInfo paramAnchorInfo)
  {
    if (this.mPendingSavedState.mSpanOffsetsSize > 0)
    {
      if (this.mPendingSavedState.mSpanOffsetsSize == this.mSpanCount)
      {
        int i = 0;
        while (i < this.mSpanCount)
        {
          this.mSpans[i].clear();
          int k = this.mPendingSavedState.mSpanOffsets[i];
          int j = k;
          if (k != -2147483648)
          {
            if (this.mPendingSavedState.mAnchorLayoutFromEnd) {
              j = this.mPrimaryOrientation.getEndAfterPadding();
            } else {
              j = this.mPrimaryOrientation.getStartAfterPadding();
            }
            j = k + j;
          }
          this.mSpans[i].setLine(j);
          i += 1;
        }
      }
      this.mPendingSavedState.invalidateSpanInfo();
      StaggeredGridLayoutManager.SavedState localSavedState = this.mPendingSavedState;
      localSavedState.mAnchorPosition = localSavedState.mVisibleAnchorPosition;
    }
    this.mLastLayoutRTL = this.mPendingSavedState.mLastLayoutRTL;
    setReverseLayout(this.mPendingSavedState.mReverseLayout);
    resolveShouldLayoutReverse();
    if (this.mPendingSavedState.mAnchorPosition != -1)
    {
      this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
      paramAnchorInfo.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
    }
    else
    {
      paramAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
    }
    if (this.mPendingSavedState.mSpanLookupSize > 1)
    {
      this.mLazySpanLookup.mData = this.mPendingSavedState.mSpanLookup;
      this.mLazySpanLookup.mFullSpanItems = this.mPendingSavedState.mFullSpanItems;
    }
  }
  
  private void attachViewToSpans(View paramView, StaggeredGridLayoutManager.LayoutParams paramLayoutParams, LayoutState paramLayoutState)
  {
    if (paramLayoutState.mLayoutDirection == 1)
    {
      if (paramLayoutParams.mFullSpan)
      {
        appendViewToAllSpans(paramView);
        return;
      }
      paramLayoutParams.mSpan.appendToSpan(paramView);
      return;
    }
    if (paramLayoutParams.mFullSpan)
    {
      prependViewToAllSpans(paramView);
      return;
    }
    paramLayoutParams.mSpan.prependToSpan(paramView);
  }
  
  private int calculateScrollDirectionForPosition(int paramInt)
  {
    int j = getChildCount();
    int i = -1;
    if (j == 0)
    {
      paramInt = i;
      if (this.mShouldReverseLayout) {
        paramInt = 1;
      }
      return paramInt;
    }
    int k;
    if (paramInt < getFirstChildPosition()) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != this.mShouldReverseLayout) {
      return -1;
    }
    return 1;
  }
  
  private boolean checkSpanForGap(StaggeredGridLayoutManager.Span paramSpan)
  {
    if (this.mShouldReverseLayout)
    {
      if (paramSpan.getEndLine() < this.mPrimaryOrientation.getEndAfterPadding()) {
        return paramSpan.getLayoutParams((View)paramSpan.mViews.get(paramSpan.mViews.size() - 1)).mFullSpan ^ true;
      }
    }
    else if (paramSpan.getStartLine() > this.mPrimaryOrientation.getStartAfterPadding()) {
      return paramSpan.getLayoutParams((View)paramSpan.mViews.get(0)).mFullSpan ^ true;
    }
    return false;
  }
  
  private int computeScrollExtent(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return ScrollbarHelper.computeScrollExtent(paramState, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(this.mSmoothScrollbarEnabled ^ true), findFirstVisibleItemClosestToEnd(this.mSmoothScrollbarEnabled ^ true), this, this.mSmoothScrollbarEnabled);
  }
  
  private int computeScrollOffset(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return ScrollbarHelper.computeScrollOffset(paramState, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(this.mSmoothScrollbarEnabled ^ true), findFirstVisibleItemClosestToEnd(this.mSmoothScrollbarEnabled ^ true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
  }
  
  private int computeScrollRange(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return ScrollbarHelper.computeScrollRange(paramState, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(this.mSmoothScrollbarEnabled ^ true), findFirstVisibleItemClosestToEnd(this.mSmoothScrollbarEnabled ^ true), this, this.mSmoothScrollbarEnabled);
  }
  
  private int convertFocusDirectionToLayoutDirection(int paramInt)
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
      if (this.mOrientation == 1) {
        return 1;
      }
      if (isLayoutRTL()) {
        return -1;
      }
      return 1;
    }
    if (this.mOrientation == 1) {
      return -1;
    }
    if (isLayoutRTL()) {
      return 1;
    }
    return -1;
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.mGapPerSpan = new int[this.mSpanCount];
    int i = 0;
    while (i < this.mSpanCount)
    {
      localFullSpanItem.mGapPerSpan[i] = (paramInt - this.mSpans[i].getEndLine(paramInt));
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    localFullSpanItem.mGapPerSpan = new int[this.mSpanCount];
    int i = 0;
    while (i < this.mSpanCount)
    {
      localFullSpanItem.mGapPerSpan[i] = (this.mSpans[i].getStartLine(paramInt) - paramInt);
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private void createOrientationHelpers()
  {
    this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
    this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
  }
  
  private int fill(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState, RecyclerView.State paramState)
  {
    this.mRemainingSpans.set(0, this.mSpanCount, true);
    int i;
    if (this.mLayoutState.mInfinite)
    {
      if (paramLayoutState.mLayoutDirection == 1) {
        i = 2147483647;
      } else {
        i = -2147483648;
      }
    }
    else if (paramLayoutState.mLayoutDirection == 1) {
      i = paramLayoutState.mEndLine + paramLayoutState.mAvailable;
    } else {
      i = paramLayoutState.mStartLine - paramLayoutState.mAvailable;
    }
    updateAllRemainingSpans(paramLayoutState.mLayoutDirection, i);
    if (this.mShouldReverseLayout) {
      k = this.mPrimaryOrientation.getEndAfterPadding();
    } else {
      k = this.mPrimaryOrientation.getStartAfterPadding();
    }
    for (int j = 0; (paramLayoutState.hasMore(paramState)) && ((this.mLayoutState.mInfinite) || (!this.mRemainingSpans.isEmpty())); j = 1)
    {
      View localView = paramLayoutState.next(paramRecycler);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      int i2 = localLayoutParams.getViewLayoutPosition();
      j = this.mLazySpanLookup.getSpan(i2);
      int i1;
      if (j == -1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      StaggeredGridLayoutManager.Span localSpan;
      if (i1 != 0)
      {
        if (localLayoutParams.mFullSpan) {
          localSpan = this.mSpans[0];
        } else {
          localSpan = getNextSpan(paramLayoutState);
        }
        this.mLazySpanLookup.setSpan(i2, localSpan);
      }
      else
      {
        localSpan = this.mSpans[j];
      }
      localLayoutParams.mSpan = localSpan;
      if (paramLayoutState.mLayoutDirection == 1) {
        addView(localView);
      } else {
        addView(localView, 0);
      }
      measureChildWithDecorationsAndMargin(localView, localLayoutParams, false);
      int m;
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem;
      int n;
      if (paramLayoutState.mLayoutDirection == 1)
      {
        if (localLayoutParams.mFullSpan) {
          j = getMaxEnd(k);
        } else {
          j = localSpan.getEndLine(k);
        }
        m = this.mPrimaryOrientation.getDecoratedMeasurement(localView);
        if ((i1 != 0) && (localLayoutParams.mFullSpan))
        {
          localFullSpanItem = createFullSpanItemFromEnd(j);
          localFullSpanItem.mGapDir = -1;
          localFullSpanItem.mPosition = i2;
          this.mLazySpanLookup.addFullSpanItem(localFullSpanItem);
        }
        n = m + j;
        m = j;
      }
      else
      {
        if (localLayoutParams.mFullSpan) {
          j = getMinStart(k);
        } else {
          j = localSpan.getStartLine(k);
        }
        m = j - this.mPrimaryOrientation.getDecoratedMeasurement(localView);
        if ((i1 != 0) && (localLayoutParams.mFullSpan))
        {
          localFullSpanItem = createFullSpanItemFromStart(j);
          localFullSpanItem.mGapDir = 1;
          localFullSpanItem.mPosition = i2;
          this.mLazySpanLookup.addFullSpanItem(localFullSpanItem);
        }
        n = j;
      }
      if ((localLayoutParams.mFullSpan) && (paramLayoutState.mItemDirection == -1)) {
        if (i1 != 0)
        {
          this.mLaidOutInvalidFullSpan = true;
        }
        else
        {
          boolean bool;
          if (paramLayoutState.mLayoutDirection == 1) {
            bool = areAllEndsEqual();
          } else {
            bool = areAllStartsEqual();
          }
          if ((bool ^ true))
          {
            localFullSpanItem = this.mLazySpanLookup.getFullSpanItem(i2);
            if (localFullSpanItem != null) {
              localFullSpanItem.mHasUnwantedGapAfter = true;
            }
            this.mLaidOutInvalidFullSpan = true;
          }
        }
      }
      attachViewToSpans(localView, localLayoutParams, paramLayoutState);
      if ((isLayoutRTL()) && (this.mOrientation == 1))
      {
        if (localLayoutParams.mFullSpan) {
          j = this.mSecondaryOrientation.getEndAfterPadding();
        } else {
          j = this.mSecondaryOrientation.getEndAfterPadding() - (this.mSpanCount - 1 - localSpan.mIndex) * this.mSizePerSpan;
        }
        i2 = this.mSecondaryOrientation.getDecoratedMeasurement(localView);
        i1 = j;
        j -= i2;
        i2 = i1;
      }
      else
      {
        if (localLayoutParams.mFullSpan) {
          j = this.mSecondaryOrientation.getStartAfterPadding();
        } else {
          j = localSpan.mIndex * this.mSizePerSpan + this.mSecondaryOrientation.getStartAfterPadding();
        }
        i2 = this.mSecondaryOrientation.getDecoratedMeasurement(localView);
        i1 = j;
        i2 += j;
        j = i1;
      }
      if (this.mOrientation == 1) {
        layoutDecoratedWithMargins(localView, j, m, i2, n);
      } else {
        layoutDecoratedWithMargins(localView, m, j, n, i2);
      }
      if (localLayoutParams.mFullSpan) {
        updateAllRemainingSpans(this.mLayoutState.mLayoutDirection, i);
      } else {
        updateRemainingSpans(localSpan, this.mLayoutState.mLayoutDirection, i);
      }
      recycle(paramRecycler, this.mLayoutState);
      if ((this.mLayoutState.mStopInFocusable) && (localView.hasFocusable())) {
        if (localLayoutParams.mFullSpan) {
          this.mRemainingSpans.clear();
        } else {
          this.mRemainingSpans.set(localSpan.mIndex, false);
        }
      }
    }
    int k = 0;
    if (j == 0) {
      recycle(paramRecycler, this.mLayoutState);
    }
    if (this.mLayoutState.mLayoutDirection == -1)
    {
      i = getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
      i = this.mPrimaryOrientation.getStartAfterPadding() - i;
    }
    else
    {
      i = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
    }
    j = k;
    if (i > 0) {
      j = Math.min(paramLayoutState.mAvailable, i);
    }
    return j;
  }
  
  private int findFirstReferenceChildPosition(int paramInt)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      int k = getPosition(getChildAt(i));
      if ((k >= 0) && (k < paramInt)) {
        return k;
      }
      i += 1;
    }
    return 0;
  }
  
  private int findLastReferenceChildPosition(int paramInt)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      int j = getPosition(getChildAt(i));
      if ((j >= 0) && (j < paramInt)) {
        return j;
      }
      i -= 1;
    }
    return 0;
  }
  
  private void fixEndGap(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = getMaxEnd(-2147483648);
    if (i == -2147483648) {
      return;
    }
    i = this.mPrimaryOrientation.getEndAfterPadding() - i;
    if (i > 0)
    {
      i -= -scrollBy(-i, paramRecycler, paramState);
      if ((paramBoolean) && (i > 0)) {
        this.mPrimaryOrientation.offsetChildren(i);
      }
    }
  }
  
  private void fixStartGap(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = getMinStart(2147483647);
    if (i == 2147483647) {
      return;
    }
    i -= this.mPrimaryOrientation.getStartAfterPadding();
    if (i > 0)
    {
      i -= scrollBy(i, paramRecycler, paramState);
      if ((paramBoolean) && (i > 0)) {
        this.mPrimaryOrientation.offsetChildren(-i);
      }
    }
  }
  
  private int getMaxEnd(int paramInt)
  {
    int j = this.mSpans[0].getEndLine(paramInt);
    int i = 1;
    while (i < this.mSpanCount)
    {
      int m = this.mSpans[i].getEndLine(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int getMaxStart(int paramInt)
  {
    int j = this.mSpans[0].getStartLine(paramInt);
    int i = 1;
    while (i < this.mSpanCount)
    {
      int m = this.mSpans[i].getStartLine(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int getMinEnd(int paramInt)
  {
    int j = this.mSpans[0].getEndLine(paramInt);
    int i = 1;
    while (i < this.mSpanCount)
    {
      int m = this.mSpans[i].getEndLine(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private int getMinStart(int paramInt)
  {
    int j = this.mSpans[0].getStartLine(paramInt);
    int i = 1;
    while (i < this.mSpanCount)
    {
      int m = this.mSpans[i].getStartLine(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private StaggeredGridLayoutManager.Span getNextSpan(LayoutState paramLayoutState)
  {
    boolean bool = preferLastSpan(paramLayoutState.mLayoutDirection);
    int j = -1;
    int i;
    int k;
    if (bool)
    {
      i = this.mSpanCount - 1;
      k = -1;
    }
    else
    {
      i = 0;
      j = this.mSpanCount;
      k = 1;
    }
    int m = paramLayoutState.mLayoutDirection;
    StaggeredGridLayoutManager.Span localSpan = null;
    paramLayoutState = null;
    int i1;
    int n;
    if (m == 1)
    {
      m = 2147483647;
      i2 = this.mPrimaryOrientation.getStartAfterPadding();
      while (i != j)
      {
        localSpan = this.mSpans[i];
        i1 = localSpan.getEndLine(i2);
        n = m;
        if (i1 < m)
        {
          paramLayoutState = localSpan;
          n = i1;
        }
        i += k;
        m = n;
      }
      return paramLayoutState;
    }
    m = -2147483648;
    int i2 = this.mPrimaryOrientation.getEndAfterPadding();
    paramLayoutState = localSpan;
    while (i != j)
    {
      localSpan = this.mSpans[i];
      i1 = localSpan.getStartLine(i2);
      n = m;
      if (i1 > m)
      {
        paramLayoutState = localSpan;
        n = i1;
      }
      i += k;
      m = n;
    }
    return paramLayoutState;
  }
  
  private void handleUpdate(int paramInt1, int paramInt2, int paramInt3)
  {
    int j;
    if (this.mShouldReverseLayout) {
      j = getLastChildPosition();
    } else {
      j = getFirstChildPosition();
    }
    if (paramInt3 == 8)
    {
      if (paramInt1 < paramInt2)
      {
        i = paramInt2 + 1;
      }
      else
      {
        k = paramInt1 + 1;
        i = paramInt2;
        break label64;
      }
    }
    else {
      i = paramInt1 + paramInt2;
    }
    int k = i;
    int i = paramInt1;
    label64:
    this.mLazySpanLookup.invalidateAfter(i);
    if (paramInt3 != 1)
    {
      if (paramInt3 != 2)
      {
        if (paramInt3 == 8)
        {
          this.mLazySpanLookup.offsetForRemoval(paramInt1, 1);
          this.mLazySpanLookup.offsetForAddition(paramInt2, 1);
        }
      }
      else {
        this.mLazySpanLookup.offsetForRemoval(paramInt1, paramInt2);
      }
    }
    else {
      this.mLazySpanLookup.offsetForAddition(paramInt1, paramInt2);
    }
    if (k <= j) {
      return;
    }
    if (this.mShouldReverseLayout) {
      paramInt1 = getFirstChildPosition();
    } else {
      paramInt1 = getLastChildPosition();
    }
    if (i <= paramInt1) {
      requestLayout();
    }
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    calculateItemDecorationsForChild(paramView, this.mTmpRect);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    paramInt1 = updateSpecWithExtra(paramInt1, localLayoutParams.leftMargin + this.mTmpRect.left, localLayoutParams.rightMargin + this.mTmpRect.right);
    paramInt2 = updateSpecWithExtra(paramInt2, localLayoutParams.topMargin + this.mTmpRect.top, localLayoutParams.bottomMargin + this.mTmpRect.bottom);
    if (paramBoolean) {
      paramBoolean = shouldReMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);
    } else {
      paramBoolean = shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);
    }
    if (paramBoolean) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, StaggeredGridLayoutManager.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (paramLayoutParams.mFullSpan)
    {
      if (this.mOrientation == 1)
      {
        measureChildWithDecorationsAndMargin(paramView, this.mFullSizeSpec, getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true), paramBoolean);
        return;
      }
      measureChildWithDecorationsAndMargin(paramView, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), this.mFullSizeSpec, paramBoolean);
      return;
    }
    if (this.mOrientation == 1)
    {
      measureChildWithDecorationsAndMargin(paramView, getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, paramLayoutParams.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), paramLayoutParams.height, true), paramBoolean);
      return;
    }
    measureChildWithDecorationsAndMargin(paramView, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), paramLayoutParams.width, true), getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, paramLayoutParams.height, false), paramBoolean);
  }
  
  private void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    StaggeredGridLayoutManager.AnchorInfo localAnchorInfo = this.mAnchorInfo;
    if (((this.mPendingSavedState != null) || (this.mPendingScrollPosition != -1)) && (paramState.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramRecycler);
      localAnchorInfo.reset();
      return;
    }
    boolean bool = localAnchorInfo.mValid;
    int j = 1;
    if ((bool) && (this.mPendingScrollPosition == -1) && (this.mPendingSavedState == null)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      localAnchorInfo.reset();
      if (this.mPendingSavedState != null)
      {
        applyPendingSavedState(localAnchorInfo);
      }
      else
      {
        resolveShouldLayoutReverse();
        localAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
      }
      updateAnchorInfoForLayout(paramState, localAnchorInfo);
      localAnchorInfo.mValid = true;
    }
    if ((this.mPendingSavedState == null) && (this.mPendingScrollPosition == -1) && ((localAnchorInfo.mLayoutFromEnd != this.mLastLayoutFromEnd) || (isLayoutRTL() != this.mLastLayoutRTL)))
    {
      this.mLazySpanLookup.clear();
      localAnchorInfo.mInvalidateOffsets = true;
    }
    if (getChildCount() > 0)
    {
      Object localObject = this.mPendingSavedState;
      if ((localObject == null) || (((StaggeredGridLayoutManager.SavedState)localObject).mSpanOffsetsSize < 1))
      {
        if (localAnchorInfo.mInvalidateOffsets)
        {
          i = 0;
          while (i < this.mSpanCount)
          {
            this.mSpans[i].clear();
            if (localAnchorInfo.mOffset != -2147483648) {
              this.mSpans[i].setLine(localAnchorInfo.mOffset);
            }
            i += 1;
          }
        }
        if ((i == 0) && (this.mAnchorInfo.mSpanReferenceLines != null)) {
          i = 0;
        }
        while (i < this.mSpanCount)
        {
          localObject = this.mSpans[i];
          ((StaggeredGridLayoutManager.Span)localObject).clear();
          ((StaggeredGridLayoutManager.Span)localObject).setLine(this.mAnchorInfo.mSpanReferenceLines[i]);
          i += 1;
          continue;
          i = 0;
          while (i < this.mSpanCount)
          {
            this.mSpans[i].cacheReferenceLineAndClear(this.mShouldReverseLayout, localAnchorInfo.mOffset);
            i += 1;
          }
          this.mAnchorInfo.saveSpanReferenceLines(this.mSpans);
        }
      }
    }
    detachAndScrapAttachedViews(paramRecycler);
    this.mLayoutState.mRecycle = false;
    this.mLaidOutInvalidFullSpan = false;
    updateMeasureSpecs(this.mSecondaryOrientation.getTotalSpace());
    updateLayoutState(localAnchorInfo.mPosition, paramState);
    if (localAnchorInfo.mLayoutFromEnd)
    {
      setLayoutStateDirection(-1);
      fill(paramRecycler, this.mLayoutState, paramState);
      setLayoutStateDirection(1);
      this.mLayoutState.mCurrentPosition = (localAnchorInfo.mPosition + this.mLayoutState.mItemDirection);
      fill(paramRecycler, this.mLayoutState, paramState);
    }
    else
    {
      setLayoutStateDirection(1);
      fill(paramRecycler, this.mLayoutState, paramState);
      setLayoutStateDirection(-1);
      this.mLayoutState.mCurrentPosition = (localAnchorInfo.mPosition + this.mLayoutState.mItemDirection);
      fill(paramRecycler, this.mLayoutState, paramState);
    }
    repositionToWrapContentIfNecessary();
    if (getChildCount() > 0) {
      if (this.mShouldReverseLayout)
      {
        fixEndGap(paramRecycler, paramState, true);
        fixStartGap(paramRecycler, paramState, false);
      }
      else
      {
        fixStartGap(paramRecycler, paramState, true);
        fixEndGap(paramRecycler, paramState, false);
      }
    }
    if ((paramBoolean) && (!paramState.isPreLayout()))
    {
      if ((this.mGapStrategy != 0) && (getChildCount() > 0) && ((this.mLaidOutInvalidFullSpan) || (hasGapsToFix() != null))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        removeCallbacks(this.mCheckForGapsRunnable);
        if (checkForGaps())
        {
          i = j;
          break label676;
        }
      }
    }
    int i = 0;
    label676:
    if (paramState.isPreLayout()) {
      this.mAnchorInfo.reset();
    }
    this.mLastLayoutFromEnd = localAnchorInfo.mLayoutFromEnd;
    this.mLastLayoutRTL = isLayoutRTL();
    if (i != 0)
    {
      this.mAnchorInfo.reset();
      onLayoutChildren(paramRecycler, paramState, false);
    }
  }
  
  private boolean preferLastSpan(int paramInt)
  {
    int i;
    if (this.mOrientation == 0)
    {
      if (paramInt == -1) {
        i = 1;
      } else {
        i = 0;
      }
      return i != this.mShouldReverseLayout;
    }
    if (paramInt == -1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == this.mShouldReverseLayout) {
      i = 1;
    } else {
      i = 0;
    }
    return i == isLayoutRTL();
  }
  
  private void prependViewToAllSpans(View paramView)
  {
    int i = this.mSpanCount - 1;
    while (i >= 0)
    {
      this.mSpans[i].prependToSpan(paramView);
      i -= 1;
    }
  }
  
  private void recycle(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState)
  {
    if (paramLayoutState.mRecycle)
    {
      if (paramLayoutState.mInfinite) {
        return;
      }
      if (paramLayoutState.mAvailable == 0)
      {
        if (paramLayoutState.mLayoutDirection == -1)
        {
          recycleFromEnd(paramRecycler, paramLayoutState.mEndLine);
          return;
        }
        recycleFromStart(paramRecycler, paramLayoutState.mStartLine);
        return;
      }
      if (paramLayoutState.mLayoutDirection == -1)
      {
        i = paramLayoutState.mStartLine - getMaxStart(paramLayoutState.mStartLine);
        if (i < 0) {
          i = paramLayoutState.mEndLine;
        } else {
          i = paramLayoutState.mEndLine - Math.min(i, paramLayoutState.mAvailable);
        }
        recycleFromEnd(paramRecycler, i);
        return;
      }
      int i = getMinEnd(paramLayoutState.mEndLine) - paramLayoutState.mEndLine;
      if (i < 0)
      {
        i = paramLayoutState.mStartLine;
      }
      else
      {
        int j = paramLayoutState.mStartLine;
        i = Math.min(i, paramLayoutState.mAvailable) + j;
      }
      recycleFromStart(paramRecycler, i);
    }
  }
  
  private void recycleFromEnd(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      View localView = getChildAt(i);
      if ((this.mPrimaryOrientation.getDecoratedStart(localView) < paramInt) || (this.mPrimaryOrientation.getTransformedStartWithDecoration(localView) < paramInt)) {
        break;
      }
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.mFullSpan)
      {
        int m = 0;
        int j = 0;
        int k;
        for (;;)
        {
          k = m;
          if (j >= this.mSpanCount) {
            break;
          }
          if (this.mSpans[j].mViews.size() == 1) {
            return;
          }
          j += 1;
        }
        while (k < this.mSpanCount)
        {
          this.mSpans[k].popEnd();
          k += 1;
        }
      }
      if (localLayoutParams.mSpan.mViews.size() == 1) {
        return;
      }
      localLayoutParams.mSpan.popEnd();
      removeAndRecycleView(localView, paramRecycler);
      i -= 1;
    }
  }
  
  private void recycleFromStart(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    while (getChildCount() > 0)
    {
      int k = 0;
      View localView = getChildAt(0);
      if ((this.mPrimaryOrientation.getDecoratedEnd(localView) > paramInt) || (this.mPrimaryOrientation.getTransformedEndWithDecoration(localView) > paramInt)) {
        break;
      }
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.mFullSpan)
      {
        int i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= this.mSpanCount) {
            break;
          }
          if (this.mSpans[i].mViews.size() == 1) {
            return;
          }
          i += 1;
        }
        while (j < this.mSpanCount)
        {
          this.mSpans[j].popStart();
          j += 1;
        }
      }
      if (localLayoutParams.mSpan.mViews.size() == 1) {
        return;
      }
      localLayoutParams.mSpan.popStart();
      removeAndRecycleView(localView, paramRecycler);
    }
  }
  
  private void repositionToWrapContentIfNecessary()
  {
    if (this.mSecondaryOrientation.getMode() == 1073741824) {
      return;
    }
    int m = getChildCount();
    int j = 0;
    int i = 0;
    float f1 = 0.0F;
    View localView;
    while (i < m)
    {
      localView = getChildAt(i);
      float f3 = this.mSecondaryOrientation.getDecoratedMeasurement(localView);
      if (f3 >= f1)
      {
        float f2 = f3;
        if (((StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams()).isFullSpan()) {
          f2 = f3 * 1.0F / this.mSpanCount;
        }
        f1 = Math.max(f1, f2);
      }
      i += 1;
    }
    int n = this.mSizePerSpan;
    int k = Math.round(f1 * this.mSpanCount);
    i = k;
    if (this.mSecondaryOrientation.getMode() == -2147483648) {
      i = Math.min(k, this.mSecondaryOrientation.getTotalSpace());
    }
    updateMeasureSpecs(i);
    i = j;
    if (this.mSizePerSpan == n) {
      return;
    }
    while (i < m)
    {
      localView = getChildAt(i);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      if (!localLayoutParams.mFullSpan) {
        if ((isLayoutRTL()) && (this.mOrientation == 1))
        {
          localView.offsetLeftAndRight(-(this.mSpanCount - 1 - localLayoutParams.mSpan.mIndex) * this.mSizePerSpan - -(this.mSpanCount - 1 - localLayoutParams.mSpan.mIndex) * n);
        }
        else
        {
          j = localLayoutParams.mSpan.mIndex * this.mSizePerSpan;
          k = localLayoutParams.mSpan.mIndex * n;
          if (this.mOrientation == 1) {
            localView.offsetLeftAndRight(j - k);
          } else {
            localView.offsetTopAndBottom(j - k);
          }
        }
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
  
  private void setLayoutStateDirection(int paramInt)
  {
    LayoutState localLayoutState = this.mLayoutState;
    localLayoutState.mLayoutDirection = paramInt;
    boolean bool2 = this.mShouldReverseLayout;
    int i = 1;
    boolean bool1;
    if (paramInt == -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool2 == bool1) {
      paramInt = i;
    } else {
      paramInt = -1;
    }
    localLayoutState.mItemDirection = paramInt;
  }
  
  private void updateAllRemainingSpans(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.mSpanCount)
    {
      if (!this.mSpans[i].mViews.isEmpty()) {
        updateRemainingSpans(this.mSpans[i], paramInt1, paramInt2);
      }
      i += 1;
    }
  }
  
  private boolean updateAnchorFromChildren(RecyclerView.State paramState, StaggeredGridLayoutManager.AnchorInfo paramAnchorInfo)
  {
    int i;
    if (this.mLastLayoutFromEnd) {
      i = findLastReferenceChildPosition(paramState.getItemCount());
    } else {
      i = findFirstReferenceChildPosition(paramState.getItemCount());
    }
    paramAnchorInfo.mPosition = i;
    paramAnchorInfo.mOffset = -2147483648;
    return true;
  }
  
  private void updateLayoutState(int paramInt, RecyclerView.State paramState)
  {
    LayoutState localLayoutState = this.mLayoutState;
    boolean bool2 = false;
    localLayoutState.mAvailable = 0;
    localLayoutState.mCurrentPosition = paramInt;
    if (isSmoothScrolling())
    {
      i = paramState.getTargetScrollPosition();
      if (i != -1)
      {
        boolean bool3 = this.mShouldReverseLayout;
        if (i < paramInt) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (bool3 == bool1)
        {
          paramInt = this.mPrimaryOrientation.getTotalSpace();
          break label91;
        }
        i = this.mPrimaryOrientation.getTotalSpace();
        paramInt = 0;
        break label93;
      }
    }
    paramInt = 0;
    label91:
    int i = 0;
    label93:
    if (getClipToPadding())
    {
      this.mLayoutState.mStartLine = (this.mPrimaryOrientation.getStartAfterPadding() - i);
      this.mLayoutState.mEndLine = (this.mPrimaryOrientation.getEndAfterPadding() + paramInt);
    }
    else
    {
      this.mLayoutState.mEndLine = (this.mPrimaryOrientation.getEnd() + paramInt);
      this.mLayoutState.mStartLine = (-i);
    }
    paramState = this.mLayoutState;
    paramState.mStopInFocusable = false;
    paramState.mRecycle = true;
    boolean bool1 = bool2;
    if (this.mPrimaryOrientation.getMode() == 0)
    {
      bool1 = bool2;
      if (this.mPrimaryOrientation.getEnd() == 0) {
        bool1 = true;
      }
    }
    paramState.mInfinite = bool1;
  }
  
  private void updateRemainingSpans(StaggeredGridLayoutManager.Span paramSpan, int paramInt1, int paramInt2)
  {
    int i = paramSpan.getDeletedSize();
    if (paramInt1 == -1)
    {
      if (paramSpan.getStartLine() + i <= paramInt2) {
        this.mRemainingSpans.set(paramSpan.mIndex, false);
      }
    }
    else if (paramSpan.getEndLine() - i >= paramInt2) {
      this.mRemainingSpans.set(paramSpan.mIndex, false);
    }
  }
  
  private int updateSpecWithExtra(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      return paramInt1;
    }
    int i = View.MeasureSpec.getMode(paramInt1);
    if ((i != -2147483648) && (i != 1073741824)) {
      return paramInt1;
    }
    return View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), i);
  }
  
  boolean areAllEndsEqual()
  {
    int j = this.mSpans[0].getEndLine(-2147483648);
    int i = 1;
    while (i < this.mSpanCount)
    {
      if (this.mSpans[i].getEndLine(-2147483648) != j) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  boolean areAllStartsEqual()
  {
    int j = this.mSpans[0].getStartLine(-2147483648);
    int i = 1;
    while (i < this.mSpanCount)
    {
      if (this.mSpans[i].getStartLine(-2147483648) != j) {
        return false;
      }
      i += 1;
    }
    return true;
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
  
  boolean checkForGaps()
  {
    if ((getChildCount() != 0) && (this.mGapStrategy != 0))
    {
      if (!isAttachedToWindow()) {
        return false;
      }
      int i;
      int j;
      if (this.mShouldReverseLayout)
      {
        i = getLastChildPosition();
        j = getFirstChildPosition();
      }
      else
      {
        i = getFirstChildPosition();
        j = getLastChildPosition();
      }
      if ((i == 0) && (hasGapsToFix() != null))
      {
        this.mLazySpanLookup.clear();
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
      }
      if (!this.mLaidOutInvalidFullSpan) {
        return false;
      }
      int k;
      if (this.mShouldReverseLayout) {
        k = -1;
      } else {
        k = 1;
      }
      Object localObject = this.mLazySpanLookup;
      j += 1;
      localObject = ((StaggeredGridLayoutManager.LazySpanLookup)localObject).getFirstFullSpanItemInRange(i, j, k, true);
      if (localObject == null)
      {
        this.mLaidOutInvalidFullSpan = false;
        this.mLazySpanLookup.forceInvalidateAfter(j);
        return false;
      }
      StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = this.mLazySpanLookup.getFirstFullSpanItemInRange(i, ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).mPosition, k * -1, true);
      if (localFullSpanItem == null) {
        this.mLazySpanLookup.forceInvalidateAfter(((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).mPosition);
      } else {
        this.mLazySpanLookup.forceInvalidateAfter(localFullSpanItem.mPosition + 1);
      }
      requestSimpleAnimationsInNextLayout();
      requestLayout();
      return true;
    }
    return false;
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.State paramState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    if (this.mOrientation != 0) {
      paramInt1 = paramInt2;
    }
    if (getChildCount() != 0)
    {
      if (paramInt1 == 0) {
        return;
      }
      prepareLayoutStateForDelta(paramInt1, paramState);
      Object localObject = this.mPrefetchDistances;
      if ((localObject == null) || (localObject.length < this.mSpanCount)) {
        this.mPrefetchDistances = new int[this.mSpanCount];
      }
      int k = 0;
      paramInt2 = 0;
      int i;
      for (paramInt1 = 0; paramInt2 < this.mSpanCount; paramInt1 = i)
      {
        if (this.mLayoutState.mItemDirection == -1)
        {
          i = this.mLayoutState.mStartLine;
          j = this.mSpans[paramInt2].getStartLine(this.mLayoutState.mStartLine);
        }
        else
        {
          i = this.mSpans[paramInt2].getEndLine(this.mLayoutState.mEndLine);
          j = this.mLayoutState.mEndLine;
        }
        int j = i - j;
        i = paramInt1;
        if (j >= 0)
        {
          this.mPrefetchDistances[paramInt1] = j;
          i = paramInt1 + 1;
        }
        paramInt2 += 1;
      }
      Arrays.sort(this.mPrefetchDistances, 0, paramInt1);
      paramInt2 = k;
      while ((paramInt2 < paramInt1) && (this.mLayoutState.hasMore(paramState)))
      {
        paramLayoutPrefetchRegistry.addPosition(this.mLayoutState.mCurrentPosition, this.mPrefetchDistances[paramInt2]);
        localObject = this.mLayoutState;
        ((LayoutState)localObject).mCurrentPosition += this.mLayoutState.mItemDirection;
        paramInt2 += 1;
      }
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
    paramInt = calculateScrollDirectionForPosition(paramInt);
    PointF localPointF = new PointF();
    if (paramInt == 0) {
      return null;
    }
    if (this.mOrientation == 0)
    {
      localPointF.x = paramInt;
      localPointF.y = 0.0F;
      return localPointF;
    }
    localPointF.x = 0.0F;
    localPointF.y = paramInt;
    return localPointF;
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
  
  public int[] findFirstCompletelyVisibleItemPositions(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      paramArrayOfInt = new int[this.mSpanCount];
    } else {
      if (paramArrayOfInt.length < this.mSpanCount) {
        break label54;
      }
    }
    int i = 0;
    while (i < this.mSpanCount)
    {
      paramArrayOfInt[i] = this.mSpans[i].findFirstCompletelyVisibleItemPosition();
      i += 1;
    }
    return paramArrayOfInt;
    label54:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
    localStringBuilder.append(this.mSpanCount);
    localStringBuilder.append(", array size:");
    localStringBuilder.append(paramArrayOfInt.length);
    paramArrayOfInt = new IllegalArgumentException(localStringBuilder.toString());
    for (;;)
    {
      throw paramArrayOfInt;
    }
  }
  
  View findFirstVisibleItemClosestToEnd(boolean paramBoolean)
  {
    int j = this.mPrimaryOrientation.getStartAfterPadding();
    int k = this.mPrimaryOrientation.getEndAfterPadding();
    int i = getChildCount() - 1;
    Object localObject2;
    for (Object localObject1 = null; i >= 0; localObject1 = localObject2)
    {
      View localView = getChildAt(i);
      int m = this.mPrimaryOrientation.getDecoratedStart(localView);
      int n = this.mPrimaryOrientation.getDecoratedEnd(localView);
      localObject2 = localObject1;
      if (n > j) {
        if (m >= k)
        {
          localObject2 = localObject1;
        }
        else if (n > k)
        {
          if (!paramBoolean) {
            return localView;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localView;
          }
        }
        else
        {
          return localView;
        }
      }
      i -= 1;
    }
    return localObject1;
  }
  
  View findFirstVisibleItemClosestToStart(boolean paramBoolean)
  {
    int j = this.mPrimaryOrientation.getStartAfterPadding();
    int k = this.mPrimaryOrientation.getEndAfterPadding();
    int m = getChildCount();
    Object localObject1 = null;
    int i = 0;
    while (i < m)
    {
      View localView = getChildAt(i);
      int n = this.mPrimaryOrientation.getDecoratedStart(localView);
      Object localObject2 = localObject1;
      if (this.mPrimaryOrientation.getDecoratedEnd(localView) > j) {
        if (n >= k)
        {
          localObject2 = localObject1;
        }
        else if (n < j)
        {
          if (!paramBoolean) {
            return localView;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localView;
          }
        }
        else
        {
          return localView;
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  int findFirstVisibleItemPositionInt()
  {
    View localView;
    if (this.mShouldReverseLayout) {
      localView = findFirstVisibleItemClosestToEnd(true);
    } else {
      localView = findFirstVisibleItemClosestToStart(true);
    }
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int[] findFirstVisibleItemPositions(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      paramArrayOfInt = new int[this.mSpanCount];
    } else {
      if (paramArrayOfInt.length < this.mSpanCount) {
        break label54;
      }
    }
    int i = 0;
    while (i < this.mSpanCount)
    {
      paramArrayOfInt[i] = this.mSpans[i].findFirstVisibleItemPosition();
      i += 1;
    }
    return paramArrayOfInt;
    label54:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
    localStringBuilder.append(this.mSpanCount);
    localStringBuilder.append(", array size:");
    localStringBuilder.append(paramArrayOfInt.length);
    paramArrayOfInt = new IllegalArgumentException(localStringBuilder.toString());
    for (;;)
    {
      throw paramArrayOfInt;
    }
  }
  
  public int[] findLastCompletelyVisibleItemPositions(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      paramArrayOfInt = new int[this.mSpanCount];
    } else {
      if (paramArrayOfInt.length < this.mSpanCount) {
        break label54;
      }
    }
    int i = 0;
    while (i < this.mSpanCount)
    {
      paramArrayOfInt[i] = this.mSpans[i].findLastCompletelyVisibleItemPosition();
      i += 1;
    }
    return paramArrayOfInt;
    label54:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
    localStringBuilder.append(this.mSpanCount);
    localStringBuilder.append(", array size:");
    localStringBuilder.append(paramArrayOfInt.length);
    paramArrayOfInt = new IllegalArgumentException(localStringBuilder.toString());
    for (;;)
    {
      throw paramArrayOfInt;
    }
  }
  
  public int[] findLastVisibleItemPositions(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      paramArrayOfInt = new int[this.mSpanCount];
    } else {
      if (paramArrayOfInt.length < this.mSpanCount) {
        break label54;
      }
    }
    int i = 0;
    while (i < this.mSpanCount)
    {
      paramArrayOfInt[i] = this.mSpans[i].findLastVisibleItemPosition();
      i += 1;
    }
    return paramArrayOfInt;
    label54:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
    localStringBuilder.append(this.mSpanCount);
    localStringBuilder.append(", array size:");
    localStringBuilder.append(paramArrayOfInt.length);
    paramArrayOfInt = new IllegalArgumentException(localStringBuilder.toString());
    for (;;)
    {
      throw paramArrayOfInt;
    }
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    if (this.mOrientation == 0) {
      return new StaggeredGridLayoutManager.LayoutParams(-2, -1);
    }
    return new StaggeredGridLayoutManager.LayoutParams(-1, -2);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new StaggeredGridLayoutManager.LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new StaggeredGridLayoutManager.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new StaggeredGridLayoutManager.LayoutParams(paramLayoutParams);
  }
  
  public int getColumnCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 1) {
      return this.mSpanCount;
    }
    return super.getColumnCountForAccessibility(paramRecycler, paramState);
  }
  
  int getFirstChildPosition()
  {
    if (getChildCount() == 0) {
      return 0;
    }
    return getPosition(getChildAt(0));
  }
  
  public int getGapStrategy()
  {
    return this.mGapStrategy;
  }
  
  int getLastChildPosition()
  {
    int i = getChildCount();
    if (i == 0) {
      return 0;
    }
    return getPosition(getChildAt(i - 1));
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public boolean getReverseLayout()
  {
    return this.mReverseLayout;
  }
  
  public int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 0) {
      return this.mSpanCount;
    }
    return super.getRowCountForAccessibility(paramRecycler, paramState);
  }
  
  public int getSpanCount()
  {
    return this.mSpanCount;
  }
  
  View hasGapsToFix()
  {
    int i = getChildCount() - 1;
    BitSet localBitSet = new BitSet(this.mSpanCount);
    localBitSet.set(0, this.mSpanCount, true);
    int j = this.mOrientation;
    int n = -1;
    if ((j == 1) && (isLayoutRTL())) {
      j = 1;
    } else {
      j = -1;
    }
    int k;
    if (this.mShouldReverseLayout)
    {
      k = -1;
    }
    else
    {
      k = i + 1;
      i = 0;
    }
    int m = i;
    if (i < k)
    {
      n = 1;
      m = i;
    }
    while (m != k)
    {
      View localView = getChildAt(m);
      StaggeredGridLayoutManager.LayoutParams localLayoutParams = (StaggeredGridLayoutManager.LayoutParams)localView.getLayoutParams();
      if (localBitSet.get(localLayoutParams.mSpan.mIndex))
      {
        if (checkSpanForGap(localLayoutParams.mSpan)) {
          return localView;
        }
        localBitSet.clear(localLayoutParams.mSpan.mIndex);
      }
      if (!localLayoutParams.mFullSpan)
      {
        i = m + n;
        if (i != k)
        {
          Object localObject = getChildAt(i);
          int i1;
          if (this.mShouldReverseLayout)
          {
            i = this.mPrimaryOrientation.getDecoratedEnd(localView);
            i1 = this.mPrimaryOrientation.getDecoratedEnd((View)localObject);
            if (i < i1) {
              return localView;
            }
            if (i != i1) {
              break label274;
            }
          }
          else
          {
            i = this.mPrimaryOrientation.getDecoratedStart(localView);
            i1 = this.mPrimaryOrientation.getDecoratedStart((View)localObject);
            if (i > i1) {
              return localView;
            }
            if (i != i1) {
              break label274;
            }
          }
          i = 1;
          break label276;
          label274:
          i = 0;
          label276:
          if (i != 0)
          {
            localObject = (StaggeredGridLayoutManager.LayoutParams)((View)localObject).getLayoutParams();
            if (localLayoutParams.mSpan.mIndex - ((StaggeredGridLayoutManager.LayoutParams)localObject).mSpan.mIndex < 0) {
              i = 1;
            } else {
              i = 0;
            }
            if (j < 0) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            if (i != i1) {
              return localView;
            }
          }
        }
      }
      m += n;
    }
    return null;
  }
  
  public void invalidateSpanAssignments()
  {
    this.mLazySpanLookup.clear();
    requestLayout();
  }
  
  public boolean isAutoMeasureEnabled()
  {
    return this.mGapStrategy != 0;
  }
  
  boolean isLayoutRTL()
  {
    return getLayoutDirection() == 1;
  }
  
  public void offsetChildrenHorizontal(int paramInt)
  {
    super.offsetChildrenHorizontal(paramInt);
    int i = 0;
    while (i < this.mSpanCount)
    {
      this.mSpans[i].onOffset(paramInt);
      i += 1;
    }
  }
  
  public void offsetChildrenVertical(int paramInt)
  {
    super.offsetChildrenVertical(paramInt);
    int i = 0;
    while (i < this.mSpanCount)
    {
      this.mSpans[i].onOffset(paramInt);
      i += 1;
    }
  }
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    super.onDetachedFromWindow(paramRecyclerView, paramRecycler);
    removeCallbacks(this.mCheckForGapsRunnable);
    int i = 0;
    while (i < this.mSpanCount)
    {
      this.mSpans[i].clear();
      i += 1;
    }
    paramRecyclerView.requestLayout();
  }
  
  @Nullable
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return null;
    }
    paramView = findContainingItemView(paramView);
    if (paramView == null) {
      return null;
    }
    resolveShouldLayoutReverse();
    int k = convertFocusDirectionToLayoutDirection(paramInt);
    if (k == -2147483648) {
      return null;
    }
    Object localObject = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    boolean bool1 = ((StaggeredGridLayoutManager.LayoutParams)localObject).mFullSpan;
    localObject = ((StaggeredGridLayoutManager.LayoutParams)localObject).mSpan;
    if (k == 1) {
      paramInt = getLastChildPosition();
    } else {
      paramInt = getFirstChildPosition();
    }
    updateLayoutState(paramInt, paramState);
    setLayoutStateDirection(k);
    LayoutState localLayoutState = this.mLayoutState;
    localLayoutState.mCurrentPosition = (localLayoutState.mItemDirection + paramInt);
    this.mLayoutState.mAvailable = ((int)(this.mPrimaryOrientation.getTotalSpace() * 0.3333333F));
    localLayoutState = this.mLayoutState;
    localLayoutState.mStopInFocusable = true;
    int j = 0;
    localLayoutState.mRecycle = false;
    fill(paramRecycler, localLayoutState, paramState);
    this.mLastLayoutFromEnd = this.mShouldReverseLayout;
    if (!bool1)
    {
      paramRecycler = ((StaggeredGridLayoutManager.Span)localObject).getFocusableViewAfter(paramInt, k);
      if ((paramRecycler != null) && (paramRecycler != paramView)) {
        return paramRecycler;
      }
    }
    if (preferLastSpan(k))
    {
      i = this.mSpanCount - 1;
      while (i >= 0)
      {
        paramRecycler = this.mSpans[i].getFocusableViewAfter(paramInt, k);
        if ((paramRecycler != null) && (paramRecycler != paramView)) {
          return paramRecycler;
        }
        i -= 1;
      }
    }
    int i = 0;
    while (i < this.mSpanCount)
    {
      paramRecycler = this.mSpans[i].getFocusableViewAfter(paramInt, k);
      if ((paramRecycler != null) && (paramRecycler != paramView)) {
        return paramRecycler;
      }
      i += 1;
    }
    boolean bool2 = this.mReverseLayout;
    if (k == -1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((bool2 ^ true) == paramInt) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (!bool1)
    {
      if (paramInt != 0) {
        i = ((StaggeredGridLayoutManager.Span)localObject).findFirstPartiallyVisibleItemPosition();
      } else {
        i = ((StaggeredGridLayoutManager.Span)localObject).findLastPartiallyVisibleItemPosition();
      }
      paramRecycler = findViewByPosition(i);
      if ((paramRecycler != null) && (paramRecycler != paramView)) {
        return paramRecycler;
      }
    }
    i = j;
    if (preferLastSpan(k))
    {
      i = this.mSpanCount - 1;
      while (i >= 0)
      {
        if (i != ((StaggeredGridLayoutManager.Span)localObject).mIndex)
        {
          if (paramInt != 0) {
            j = this.mSpans[i].findFirstPartiallyVisibleItemPosition();
          } else {
            j = this.mSpans[i].findLastPartiallyVisibleItemPosition();
          }
          paramRecycler = findViewByPosition(j);
          if ((paramRecycler != null) && (paramRecycler != paramView)) {
            return paramRecycler;
          }
        }
        i -= 1;
      }
    }
    while (i < this.mSpanCount)
    {
      if (paramInt != 0) {
        j = this.mSpans[i].findFirstPartiallyVisibleItemPosition();
      } else {
        j = this.mSpans[i].findLastPartiallyVisibleItemPosition();
      }
      paramRecycler = findViewByPosition(j);
      if ((paramRecycler != null) && (paramRecycler != paramView)) {
        return paramRecycler;
      }
      i += 1;
    }
    return null;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      View localView1 = findFirstVisibleItemClosestToStart(false);
      View localView2 = findFirstVisibleItemClosestToEnd(false);
      if (localView1 != null)
      {
        if (localView2 == null) {
          return;
        }
        int i = getPosition(localView1);
        int j = getPosition(localView2);
        if (i < j)
        {
          paramAccessibilityEvent.setFromIndex(i);
          paramAccessibilityEvent.setToIndex(j);
          return;
        }
        paramAccessibilityEvent.setFromIndex(j);
        paramAccessibilityEvent.setToIndex(i);
      }
    }
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    paramRecycler = paramView.getLayoutParams();
    if (!(paramRecycler instanceof StaggeredGridLayoutManager.LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
      return;
    }
    paramRecycler = (StaggeredGridLayoutManager.LayoutParams)paramRecycler;
    int i;
    if (this.mOrientation == 0)
    {
      j = paramRecycler.getSpanIndex();
      if (paramRecycler.mFullSpan) {
        i = this.mSpanCount;
      } else {
        i = 1;
      }
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(j, i, -1, -1, false, false));
      return;
    }
    int j = paramRecycler.getSpanIndex();
    if (paramRecycler.mFullSpan) {
      i = this.mSpanCount;
    } else {
      i = 1;
    }
    paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, j, i, false, false));
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    handleUpdate(paramInt1, paramInt2, 1);
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    this.mLazySpanLookup.clear();
    requestLayout();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    handleUpdate(paramInt1, paramInt2, 8);
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    handleUpdate(paramInt1, paramInt2, 2);
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    handleUpdate(paramInt1, paramInt2, 4);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    onLayoutChildren(paramRecycler, paramState, true);
  }
  
  public void onLayoutCompleted(RecyclerView.State paramState)
  {
    super.onLayoutCompleted(paramState);
    this.mPendingScrollPosition = -1;
    this.mPendingScrollPositionOffset = -2147483648;
    this.mPendingSavedState = null;
    this.mAnchorInfo.reset();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof StaggeredGridLayoutManager.SavedState))
    {
      this.mPendingSavedState = ((StaggeredGridLayoutManager.SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    StaggeredGridLayoutManager.SavedState localSavedState = this.mPendingSavedState;
    if (localSavedState != null) {
      return new StaggeredGridLayoutManager.SavedState(localSavedState);
    }
    localSavedState = new StaggeredGridLayoutManager.SavedState();
    localSavedState.mReverseLayout = this.mReverseLayout;
    localSavedState.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
    localSavedState.mLastLayoutRTL = this.mLastLayoutRTL;
    StaggeredGridLayoutManager.LazySpanLookup localLazySpanLookup = this.mLazySpanLookup;
    int j = 0;
    if ((localLazySpanLookup != null) && (localLazySpanLookup.mData != null))
    {
      localSavedState.mSpanLookup = this.mLazySpanLookup.mData;
      localSavedState.mSpanLookupSize = localSavedState.mSpanLookup.length;
      localSavedState.mFullSpanItems = this.mLazySpanLookup.mFullSpanItems;
    }
    else
    {
      localSavedState.mSpanLookupSize = 0;
    }
    if (getChildCount() > 0)
    {
      if (this.mLastLayoutFromEnd) {
        i = getLastChildPosition();
      } else {
        i = getFirstChildPosition();
      }
      localSavedState.mAnchorPosition = i;
      localSavedState.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
      int i = this.mSpanCount;
      localSavedState.mSpanOffsetsSize = i;
      localSavedState.mSpanOffsets = new int[i];
      while (j < this.mSpanCount)
      {
        int k;
        if (this.mLastLayoutFromEnd)
        {
          k = this.mSpans[j].getEndLine(-2147483648);
          i = k;
          if (k == -2147483648) {
            break label261;
          }
          i = this.mPrimaryOrientation.getEndAfterPadding();
        }
        else
        {
          k = this.mSpans[j].getStartLine(-2147483648);
          i = k;
          if (k == -2147483648) {
            break label261;
          }
          i = this.mPrimaryOrientation.getStartAfterPadding();
        }
        i = k - i;
        label261:
        localSavedState.mSpanOffsets[j] = i;
        j += 1;
      }
    }
    localSavedState.mAnchorPosition = -1;
    localSavedState.mVisibleAnchorPosition = -1;
    localSavedState.mSpanOffsetsSize = 0;
    return localSavedState;
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 0) {
      checkForGaps();
    }
  }
  
  void prepareLayoutStateForDelta(int paramInt, RecyclerView.State paramState)
  {
    int i;
    int j;
    if (paramInt > 0)
    {
      i = getLastChildPosition();
      j = 1;
    }
    else
    {
      i = getFirstChildPosition();
      j = -1;
    }
    this.mLayoutState.mRecycle = true;
    updateLayoutState(i, paramState);
    setLayoutStateDirection(j);
    paramState = this.mLayoutState;
    paramState.mCurrentPosition = (i + paramState.mItemDirection);
    this.mLayoutState.mAvailable = Math.abs(paramInt);
  }
  
  int scrollBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (getChildCount() != 0)
    {
      if (paramInt == 0) {
        return 0;
      }
      prepareLayoutStateForDelta(paramInt, paramState);
      int i = fill(paramRecycler, this.mLayoutState, paramState);
      if (this.mLayoutState.mAvailable >= i) {
        if (paramInt < 0) {
          paramInt = -i;
        } else {
          paramInt = i;
        }
      }
      this.mPrimaryOrientation.offsetChildren(-paramInt);
      this.mLastLayoutFromEnd = this.mShouldReverseLayout;
      paramState = this.mLayoutState;
      paramState.mAvailable = 0;
      recycle(paramRecycler, paramState);
      return paramInt;
    }
    return 0;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void scrollToPosition(int paramInt)
  {
    StaggeredGridLayoutManager.SavedState localSavedState = this.mPendingSavedState;
    if ((localSavedState != null) && (localSavedState.mAnchorPosition != paramInt)) {
      this.mPendingSavedState.invalidateAnchorPositionInfo();
    }
    this.mPendingScrollPosition = paramInt;
    this.mPendingScrollPositionOffset = -2147483648;
    requestLayout();
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    StaggeredGridLayoutManager.SavedState localSavedState = this.mPendingSavedState;
    if (localSavedState != null) {
      localSavedState.invalidateAnchorPositionInfo();
    }
    this.mPendingScrollPosition = paramInt1;
    this.mPendingScrollPositionOffset = paramInt2;
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void setGapStrategy(int paramInt)
  {
    assertNotInLayoutOrScroll(null);
    if (paramInt == this.mGapStrategy) {
      return;
    }
    if ((paramInt != 0) && (paramInt != 2)) {
      throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
    }
    this.mGapStrategy = paramInt;
    requestLayout();
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = getPaddingLeft() + getPaddingRight();
    int j = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1)
    {
      paramInt2 = chooseSize(paramInt2, paramRect.height() + j, getMinimumHeight());
      i = chooseSize(paramInt1, this.mSizePerSpan * this.mSpanCount + i, getMinimumWidth());
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
    else
    {
      paramInt1 = chooseSize(paramInt1, paramRect.width() + i, getMinimumWidth());
      i = chooseSize(paramInt2, this.mSizePerSpan * this.mSpanCount + j, getMinimumHeight());
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException("invalid orientation.");
    }
    assertNotInLayoutOrScroll(null);
    if (paramInt == this.mOrientation) {
      return;
    }
    this.mOrientation = paramInt;
    OrientationHelper localOrientationHelper = this.mPrimaryOrientation;
    this.mPrimaryOrientation = this.mSecondaryOrientation;
    this.mSecondaryOrientation = localOrientationHelper;
    requestLayout();
  }
  
  public void setReverseLayout(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    StaggeredGridLayoutManager.SavedState localSavedState = this.mPendingSavedState;
    if ((localSavedState != null) && (localSavedState.mReverseLayout != paramBoolean)) {
      this.mPendingSavedState.mReverseLayout = paramBoolean;
    }
    this.mReverseLayout = paramBoolean;
    requestLayout();
  }
  
  public void setSpanCount(int paramInt)
  {
    assertNotInLayoutOrScroll(null);
    if (paramInt != this.mSpanCount)
    {
      invalidateSpanAssignments();
      this.mSpanCount = paramInt;
      this.mRemainingSpans = new BitSet(this.mSpanCount);
      this.mSpans = new StaggeredGridLayoutManager.Span[this.mSpanCount];
      paramInt = 0;
      while (paramInt < this.mSpanCount)
      {
        this.mSpans[paramInt] = new StaggeredGridLayoutManager.Span(this, paramInt);
        paramInt += 1;
      }
      requestLayout();
    }
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    paramRecyclerView = new LinearSmoothScroller(paramRecyclerView.getContext());
    paramRecyclerView.setTargetPosition(paramInt);
    startSmoothScroll(paramRecyclerView);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return this.mPendingSavedState == null;
  }
  
  boolean updateAnchorFromPendingData(RecyclerView.State paramState, StaggeredGridLayoutManager.AnchorInfo paramAnchorInfo)
  {
    boolean bool2 = paramState.isPreLayout();
    boolean bool1 = false;
    if (!bool2)
    {
      int i = this.mPendingScrollPosition;
      if (i == -1) {
        return false;
      }
      if ((i >= 0) && (i < paramState.getItemCount()))
      {
        paramState = this.mPendingSavedState;
        if ((paramState != null) && (paramState.mAnchorPosition != -1) && (this.mPendingSavedState.mSpanOffsetsSize >= 1))
        {
          paramAnchorInfo.mOffset = -2147483648;
          paramAnchorInfo.mPosition = this.mPendingScrollPosition;
          return true;
        }
        paramState = findViewByPosition(this.mPendingScrollPosition);
        if (paramState != null)
        {
          if (this.mShouldReverseLayout) {
            i = getLastChildPosition();
          } else {
            i = getFirstChildPosition();
          }
          paramAnchorInfo.mPosition = i;
          if (this.mPendingScrollPositionOffset != -2147483648)
          {
            if (paramAnchorInfo.mLayoutFromEnd)
            {
              paramAnchorInfo.mOffset = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset - this.mPrimaryOrientation.getDecoratedEnd(paramState));
              return true;
            }
            paramAnchorInfo.mOffset = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset - this.mPrimaryOrientation.getDecoratedStart(paramState));
            return true;
          }
          if (this.mPrimaryOrientation.getDecoratedMeasurement(paramState) > this.mPrimaryOrientation.getTotalSpace())
          {
            if (paramAnchorInfo.mLayoutFromEnd) {
              i = this.mPrimaryOrientation.getEndAfterPadding();
            } else {
              i = this.mPrimaryOrientation.getStartAfterPadding();
            }
            paramAnchorInfo.mOffset = i;
            return true;
          }
          i = this.mPrimaryOrientation.getDecoratedStart(paramState) - this.mPrimaryOrientation.getStartAfterPadding();
          if (i < 0)
          {
            paramAnchorInfo.mOffset = (-i);
            return true;
          }
          i = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(paramState);
          if (i < 0)
          {
            paramAnchorInfo.mOffset = i;
            return true;
          }
          paramAnchorInfo.mOffset = -2147483648;
          return true;
        }
        paramAnchorInfo.mPosition = this.mPendingScrollPosition;
        i = this.mPendingScrollPositionOffset;
        if (i == -2147483648)
        {
          if (calculateScrollDirectionForPosition(paramAnchorInfo.mPosition) == 1) {
            bool1 = true;
          }
          paramAnchorInfo.mLayoutFromEnd = bool1;
          paramAnchorInfo.assignCoordinateFromPadding();
        }
        else
        {
          paramAnchorInfo.assignCoordinateFromPadding(i);
        }
        paramAnchorInfo.mInvalidateOffsets = true;
        return true;
      }
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = -2147483648;
    }
    return false;
  }
  
  void updateAnchorInfoForLayout(RecyclerView.State paramState, StaggeredGridLayoutManager.AnchorInfo paramAnchorInfo)
  {
    if (updateAnchorFromPendingData(paramState, paramAnchorInfo)) {
      return;
    }
    if (updateAnchorFromChildren(paramState, paramAnchorInfo)) {
      return;
    }
    paramAnchorInfo.assignCoordinateFromPadding();
    paramAnchorInfo.mPosition = 0;
  }
  
  void updateMeasureSpecs(int paramInt)
  {
    this.mSizePerSpan = (paramInt / this.mSpanCount);
    this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(paramInt, this.mSecondaryOrientation.getMode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.StaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */