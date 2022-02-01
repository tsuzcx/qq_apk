package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import java.util.Arrays;

public class GridLayoutManager
  extends LinearLayoutManager
{
  private static final boolean DEBUG = false;
  public static final int DEFAULT_SPAN_COUNT = -1;
  private static final String TAG = "GridLayoutManager";
  int[] mCachedBorders;
  final Rect mDecorInsets = new Rect();
  boolean mPendingSpanCountChange = false;
  final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
  final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
  View[] mSet;
  int mSpanCount = -1;
  GridLayoutManager.SpanSizeLookup mSpanSizeLookup = new GridLayoutManager.DefaultSpanSizeLookup();
  private boolean mUsingSpansToEstimateScrollBarDimensions;
  
  public GridLayoutManager(Context paramContext, int paramInt)
  {
    super(paramContext);
    setSpanCount(paramInt);
  }
  
  public GridLayoutManager(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext, paramInt2, paramBoolean);
    setSpanCount(paramInt1);
  }
  
  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setSpanCount(getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2).spanCount);
  }
  
  private void assignSpans(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt, boolean paramBoolean)
  {
    int k = 0;
    int i = -1;
    int j;
    if (paramBoolean)
    {
      int m = 0;
      j = 1;
      i = paramInt;
      paramInt = m;
    }
    else
    {
      paramInt -= 1;
      j = -1;
    }
    while (paramInt != i)
    {
      View localView = this.mSet[paramInt];
      GridLayoutManager.LayoutParams localLayoutParams = (GridLayoutManager.LayoutParams)localView.getLayoutParams();
      localLayoutParams.mSpanSize = getSpanSize(paramRecycler, paramState, getPosition(localView));
      localLayoutParams.mSpanIndex = k;
      k += localLayoutParams.mSpanSize;
      paramInt += j;
    }
  }
  
  private void cachePreLayoutSpanMapping()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      GridLayoutManager.LayoutParams localLayoutParams = (GridLayoutManager.LayoutParams)getChildAt(i).getLayoutParams();
      int k = localLayoutParams.getViewLayoutPosition();
      this.mPreLayoutSpanSizeCache.put(k, localLayoutParams.getSpanSize());
      this.mPreLayoutSpanIndexCache.put(k, localLayoutParams.getSpanIndex());
      i += 1;
    }
  }
  
  private void calculateItemBorders(int paramInt)
  {
    this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, paramInt);
  }
  
  static int[] calculateItemBorders(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int j = 1;
    int[] arrayOfInt;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length == paramInt1 + 1))
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt[(paramArrayOfInt.length - 1)] == paramInt2) {}
    }
    else
    {
      arrayOfInt = new int[paramInt1 + 1];
    }
    int k = 0;
    arrayOfInt[0] = 0;
    int m = paramInt2 / paramInt1;
    int n = paramInt2 % paramInt1;
    int i = 0;
    paramInt2 = k;
    while (j <= paramInt1)
    {
      paramInt2 += n;
      if ((paramInt2 > 0) && (paramInt1 - paramInt2 < n))
      {
        k = m + 1;
        paramInt2 -= paramInt1;
      }
      else
      {
        k = m;
      }
      i += k;
      arrayOfInt[j] = i;
      j += 1;
    }
    return arrayOfInt;
  }
  
  private void clearPreLayoutSpanMappingCache()
  {
    this.mPreLayoutSpanSizeCache.clear();
    this.mPreLayoutSpanIndexCache.clear();
  }
  
  private int computeScrollOffsetWithSpanInfo(RecyclerView.State paramState)
  {
    if (getChildCount() != 0)
    {
      if (paramState.getItemCount() == 0) {
        return 0;
      }
      ensureLayoutState();
      boolean bool = isSmoothScrollbarEnabled();
      View localView1 = findFirstVisibleChildClosestToStart(bool ^ true, true);
      View localView2 = findFirstVisibleChildClosestToEnd(bool ^ true, true);
      if (localView1 != null)
      {
        if (localView2 == null) {
          return 0;
        }
        int j = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(localView1), this.mSpanCount);
        int k = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(localView2), this.mSpanCount);
        int i = Math.min(j, k);
        j = Math.max(j, k);
        k = this.mSpanSizeLookup.getCachedSpanGroupIndex(paramState.getItemCount() - 1, this.mSpanCount);
        if (this.mShouldReverseLayout) {
          i = Math.max(0, k + 1 - j - 1);
        } else {
          i = Math.max(0, i);
        }
        if (!bool) {
          return i;
        }
        j = Math.abs(this.mOrientationHelper.getDecoratedEnd(localView2) - this.mOrientationHelper.getDecoratedStart(localView1));
        k = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(localView1), this.mSpanCount);
        int m = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(localView2), this.mSpanCount);
        float f = j / (m - k + 1);
        return Math.round(i * f + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(localView1)));
      }
    }
    return 0;
  }
  
  private int computeScrollRangeWithSpanInfo(RecyclerView.State paramState)
  {
    if (getChildCount() != 0)
    {
      if (paramState.getItemCount() == 0) {
        return 0;
      }
      ensureLayoutState();
      View localView1 = findFirstVisibleChildClosestToStart(isSmoothScrollbarEnabled() ^ true, true);
      View localView2 = findFirstVisibleChildClosestToEnd(isSmoothScrollbarEnabled() ^ true, true);
      if (localView1 != null)
      {
        if (localView2 == null) {
          return 0;
        }
        if (!isSmoothScrollbarEnabled()) {
          return this.mSpanSizeLookup.getCachedSpanGroupIndex(paramState.getItemCount() - 1, this.mSpanCount) + 1;
        }
        int i = this.mOrientationHelper.getDecoratedEnd(localView2);
        int j = this.mOrientationHelper.getDecoratedStart(localView1);
        int k = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(localView1), this.mSpanCount);
        int m = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(localView2), this.mSpanCount);
        int n = this.mSpanSizeLookup.getCachedSpanGroupIndex(paramState.getItemCount() - 1, this.mSpanCount);
        return (int)((i - j) / (m - k + 1) * (n + 1));
      }
    }
    return 0;
  }
  
  private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo, int paramInt)
  {
    if (paramInt == 1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int i = getSpanIndex(paramRecycler, paramState, paramAnchorInfo.mPosition);
    if (paramInt != 0) {
      while ((i > 0) && (paramAnchorInfo.mPosition > 0))
      {
        paramAnchorInfo.mPosition -= 1;
        i = getSpanIndex(paramRecycler, paramState, paramAnchorInfo.mPosition);
      }
    }
    int m = paramState.getItemCount();
    paramInt = paramAnchorInfo.mPosition;
    while (paramInt < m - 1)
    {
      int k = paramInt + 1;
      int j = getSpanIndex(paramRecycler, paramState, k);
      if (j <= i) {
        break;
      }
      paramInt = k;
      i = j;
    }
    paramAnchorInfo.mPosition = paramInt;
  }
  
  private void ensureViewSet()
  {
    View[] arrayOfView = this.mSet;
    if ((arrayOfView == null) || (arrayOfView.length != this.mSpanCount)) {
      this.mSet = new View[this.mSpanCount];
    }
  }
  
  private int getSpanGroupIndex(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (!paramState.isPreLayout()) {
      return this.mSpanSizeLookup.getCachedSpanGroupIndex(paramInt, this.mSpanCount);
    }
    int i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      paramRecycler = new StringBuilder();
      paramRecycler.append("Cannot find span size for pre layout position. ");
      paramRecycler.append(paramInt);
      Log.w("GridLayoutManager", paramRecycler.toString());
      return 0;
    }
    return this.mSpanSizeLookup.getCachedSpanGroupIndex(i, this.mSpanCount);
  }
  
  private int getSpanIndex(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (!paramState.isPreLayout()) {
      return this.mSpanSizeLookup.getCachedSpanIndex(paramInt, this.mSpanCount);
    }
    int i = this.mPreLayoutSpanIndexCache.get(paramInt, -1);
    if (i != -1) {
      return i;
    }
    i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      paramRecycler = new StringBuilder();
      paramRecycler.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
      paramRecycler.append(paramInt);
      Log.w("GridLayoutManager", paramRecycler.toString());
      return 0;
    }
    return this.mSpanSizeLookup.getCachedSpanIndex(i, this.mSpanCount);
  }
  
  private int getSpanSize(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (!paramState.isPreLayout()) {
      return this.mSpanSizeLookup.getSpanSize(paramInt);
    }
    int i = this.mPreLayoutSpanSizeCache.get(paramInt, -1);
    if (i != -1) {
      return i;
    }
    i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      paramRecycler = new StringBuilder();
      paramRecycler.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
      paramRecycler.append(paramInt);
      Log.w("GridLayoutManager", paramRecycler.toString());
      return 1;
    }
    return this.mSpanSizeLookup.getSpanSize(i);
  }
  
  private void guessMeasurement(float paramFloat, int paramInt)
  {
    calculateItemBorders(Math.max(Math.round(paramFloat * this.mSpanCount), paramInt));
  }
  
  private void measureChild(View paramView, int paramInt, boolean paramBoolean)
  {
    GridLayoutManager.LayoutParams localLayoutParams = (GridLayoutManager.LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.mDecorInsets;
    int j = localRect.top + localRect.bottom + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
    int i = localRect.left + localRect.right + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
    int k = getSpaceForSpanRange(localLayoutParams.mSpanIndex, localLayoutParams.mSpanSize);
    if (this.mOrientation == 1)
    {
      i = getChildMeasureSpec(k, paramInt, i, localLayoutParams.width, false);
      paramInt = getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), j, localLayoutParams.height, true);
    }
    else
    {
      paramInt = getChildMeasureSpec(k, paramInt, j, localLayoutParams.height, false);
      i = getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), i, localLayoutParams.width, true);
    }
    measureChildWithDecorationsAndMargin(paramView, i, paramInt, paramBoolean);
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if (paramBoolean) {
      paramBoolean = shouldReMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);
    } else {
      paramBoolean = shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);
    }
    if (paramBoolean) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  private void updateMeasurements()
  {
    int i;
    int j;
    if (getOrientation() == 1)
    {
      i = getWidth() - getPaddingRight();
      j = getPaddingLeft();
    }
    else
    {
      i = getHeight() - getPaddingBottom();
      j = getPaddingTop();
    }
    calculateItemBorders(i - j);
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof GridLayoutManager.LayoutParams;
  }
  
  void collectPrefetchPositionsForLayoutState(RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    int j = this.mSpanCount;
    int i = 0;
    while ((i < this.mSpanCount) && (paramLayoutState.hasMore(paramState)) && (j > 0))
    {
      int k = paramLayoutState.mCurrentPosition;
      paramLayoutPrefetchRegistry.addPosition(k, Math.max(0, paramLayoutState.mScrollingOffset));
      j -= this.mSpanSizeLookup.getSpanSize(k);
      paramLayoutState.mCurrentPosition += paramLayoutState.mItemDirection;
      i += 1;
    }
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState)
  {
    if (this.mUsingSpansToEstimateScrollBarDimensions) {
      return computeScrollOffsetWithSpanInfo(paramState);
    }
    return super.computeHorizontalScrollOffset(paramState);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState)
  {
    if (this.mUsingSpansToEstimateScrollBarDimensions) {
      return computeScrollRangeWithSpanInfo(paramState);
    }
    return super.computeHorizontalScrollRange(paramState);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState)
  {
    if (this.mUsingSpansToEstimateScrollBarDimensions) {
      return computeScrollOffsetWithSpanInfo(paramState);
    }
    return super.computeVerticalScrollOffset(paramState);
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState)
  {
    if (this.mUsingSpansToEstimateScrollBarDimensions) {
      return computeScrollRangeWithSpanInfo(paramState);
    }
    return super.computeVerticalScrollRange(paramState);
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
    Object localObject2 = null;
    Object localObject4;
    for (Object localObject1 = null; paramInt1 != paramInt2; localObject1 = localObject4)
    {
      View localView = getChildAt(paramInt1);
      int m = getPosition(localView);
      Object localObject3 = localObject2;
      localObject4 = localObject1;
      if (m >= 0)
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (m < paramInt3) {
          if (getSpanIndex(paramRecycler, paramState, m) != 0)
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
          }
          else if (((RecyclerView.LayoutParams)localView.getLayoutParams()).isItemRemoved())
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (localObject1 == null)
            {
              localObject4 = localView;
              localObject3 = localObject2;
            }
          }
          else
          {
            if ((this.mOrientationHelper.getDecoratedStart(localView) < k) && (this.mOrientationHelper.getDecoratedEnd(localView) >= j)) {
              return localView;
            }
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (localObject2 == null)
            {
              localObject3 = localView;
              localObject4 = localObject1;
            }
          }
        }
      }
      paramInt1 += i;
      localObject2 = localObject3;
    }
    if (localObject2 != null) {
      return localObject2;
    }
    return localObject1;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    if (this.mOrientation == 0) {
      return new GridLayoutManager.LayoutParams(-2, -1);
    }
    return new GridLayoutManager.LayoutParams(-1, -2);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new GridLayoutManager.LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new GridLayoutManager.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new GridLayoutManager.LayoutParams(paramLayoutParams);
  }
  
  public int getColumnCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 1) {
      return this.mSpanCount;
    }
    if (paramState.getItemCount() < 1) {
      return 0;
    }
    return getSpanGroupIndex(paramRecycler, paramState, paramState.getItemCount() - 1) + 1;
  }
  
  public int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 0) {
      return this.mSpanCount;
    }
    if (paramState.getItemCount() < 1) {
      return 0;
    }
    return getSpanGroupIndex(paramRecycler, paramState, paramState.getItemCount() - 1) + 1;
  }
  
  int getSpaceForSpanRange(int paramInt1, int paramInt2)
  {
    if ((this.mOrientation == 1) && (isLayoutRTL()))
    {
      arrayOfInt = this.mCachedBorders;
      int i = this.mSpanCount;
      return arrayOfInt[(i - paramInt1)] - arrayOfInt[(i - paramInt1 - paramInt2)];
    }
    int[] arrayOfInt = this.mCachedBorders;
    return arrayOfInt[(paramInt2 + paramInt1)] - arrayOfInt[paramInt1];
  }
  
  public int getSpanCount()
  {
    return this.mSpanCount;
  }
  
  public GridLayoutManager.SpanSizeLookup getSpanSizeLookup()
  {
    return this.mSpanSizeLookup;
  }
  
  public boolean isUsingSpansToEstimateScrollbarDimensions()
  {
    return this.mUsingSpansToEstimateScrollBarDimensions;
  }
  
  void layoutChunk(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, LinearLayoutManager.LayoutChunkResult paramLayoutChunkResult)
  {
    int i3 = this.mOrientationHelper.getModeInOther();
    int k;
    if (i3 != 1073741824) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if (getChildCount() > 0) {
      m = this.mCachedBorders[this.mSpanCount];
    } else {
      m = 0;
    }
    if (k != 0) {
      updateMeasurements();
    }
    boolean bool;
    if (paramLayoutState.mItemDirection == 1) {
      bool = true;
    } else {
      bool = false;
    }
    int i = this.mSpanCount;
    if (!bool) {
      i = getSpanIndex(paramRecycler, paramState, paramLayoutState.mCurrentPosition) + getSpanSize(paramRecycler, paramState, paramLayoutState.mCurrentPosition);
    }
    int n = 0;
    Object localObject;
    while ((n < this.mSpanCount) && (paramLayoutState.hasMore(paramState)) && (i > 0))
    {
      j = paramLayoutState.mCurrentPosition;
      i1 = getSpanSize(paramRecycler, paramState, j);
      if (i1 <= this.mSpanCount)
      {
        i -= i1;
        if (i >= 0)
        {
          localObject = paramLayoutState.next(paramRecycler);
          if (localObject != null)
          {
            this.mSet[n] = localObject;
            n += 1;
          }
        }
      }
      else
      {
        paramRecycler = new StringBuilder();
        paramRecycler.append("Item at position ");
        paramRecycler.append(j);
        paramRecycler.append(" requires ");
        paramRecycler.append(i1);
        paramRecycler.append(" spans but GridLayoutManager has only ");
        paramRecycler.append(this.mSpanCount);
        paramRecycler.append(" spans.");
        throw new IllegalArgumentException(paramRecycler.toString());
      }
    }
    if (n == 0)
    {
      paramLayoutChunkResult.mFinished = true;
      return;
    }
    float f1 = 0.0F;
    assignSpans(paramRecycler, paramState, n, bool);
    int j = 0;
    i = 0;
    int i2;
    while (j < n)
    {
      paramRecycler = this.mSet[j];
      if (paramLayoutState.mScrapList == null)
      {
        if (bool) {
          addView(paramRecycler);
        } else {
          addView(paramRecycler, 0);
        }
      }
      else if (bool) {
        addDisappearingView(paramRecycler);
      } else {
        addDisappearingView(paramRecycler, 0);
      }
      calculateItemDecorationsForChild(paramRecycler, this.mDecorInsets);
      measureChild(paramRecycler, i3, false);
      i2 = this.mOrientationHelper.getDecoratedMeasurement(paramRecycler);
      i1 = i;
      if (i2 > i) {
        i1 = i2;
      }
      paramState = (GridLayoutManager.LayoutParams)paramRecycler.getLayoutParams();
      float f3 = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) * 1.0F / paramState.mSpanSize;
      float f2 = f1;
      if (f3 > f1) {
        f2 = f3;
      }
      j += 1;
      i = i1;
      f1 = f2;
    }
    j = i;
    if (k != 0)
    {
      guessMeasurement(f1, m);
      k = 0;
      for (i = 0;; i = j)
      {
        j = i;
        if (k >= n) {
          break;
        }
        paramRecycler = this.mSet[k];
        measureChild(paramRecycler, 1073741824, true);
        m = this.mOrientationHelper.getDecoratedMeasurement(paramRecycler);
        j = i;
        if (m > i) {
          j = m;
        }
        k += 1;
      }
    }
    i = 0;
    while (i < n)
    {
      paramRecycler = this.mSet[i];
      if (this.mOrientationHelper.getDecoratedMeasurement(paramRecycler) != j)
      {
        paramState = (GridLayoutManager.LayoutParams)paramRecycler.getLayoutParams();
        localObject = paramState.mDecorInsets;
        m = ((Rect)localObject).top + ((Rect)localObject).bottom + paramState.topMargin + paramState.bottomMargin;
        k = ((Rect)localObject).left + ((Rect)localObject).right + paramState.leftMargin + paramState.rightMargin;
        i1 = getSpaceForSpanRange(paramState.mSpanIndex, paramState.mSpanSize);
        if (this.mOrientation == 1)
        {
          k = getChildMeasureSpec(i1, 1073741824, k, paramState.width, false);
          m = View.MeasureSpec.makeMeasureSpec(j - m, 1073741824);
        }
        else
        {
          k = View.MeasureSpec.makeMeasureSpec(j - k, 1073741824);
          m = getChildMeasureSpec(i1, 1073741824, m, paramState.height, false);
        }
        measureChildWithDecorationsAndMargin(paramRecycler, k, m, true);
      }
      i += 1;
    }
    int i1 = 0;
    paramLayoutChunkResult.mConsumed = j;
    if (this.mOrientation == 1)
    {
      if (paramLayoutState.mLayoutDirection == -1)
      {
        i = paramLayoutState.mOffset;
        k = i - j;
        j = i;
        i = k;
      }
      else
      {
        i = paramLayoutState.mOffset;
        j = i + j;
      }
      k = 0;
      m = 0;
    }
    else if (paramLayoutState.mLayoutDirection == -1)
    {
      m = paramLayoutState.mOffset;
      k = m - j;
      i = 0;
      j = 0;
    }
    else
    {
      k = paramLayoutState.mOffset;
      i = 0;
      i2 = 0;
      m = k + j;
      j = i2;
    }
    while (i1 < n)
    {
      paramRecycler = this.mSet[i1];
      paramState = (GridLayoutManager.LayoutParams)paramRecycler.getLayoutParams();
      if (this.mOrientation == 1)
      {
        int i4;
        if (isLayoutRTL())
        {
          i3 = getPaddingLeft() + this.mCachedBorders[(this.mSpanCount - paramState.mSpanIndex)];
          i4 = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
          k = i3;
          i2 = i;
          m = j;
          i = i3 - i4;
          j = i2;
        }
        else
        {
          i3 = getPaddingLeft() + this.mCachedBorders[paramState.mSpanIndex];
          i4 = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
          k = i3;
          i2 = i;
          m = j;
          i3 = i4 + i3;
          i = k;
          j = i2;
          k = i3;
        }
      }
      else
      {
        i2 = getPaddingTop() + this.mCachedBorders[paramState.mSpanIndex];
        i3 = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
        i = k;
        j = i2;
        i2 = i3 + i2;
        k = m;
        m = i2;
      }
      layoutDecoratedWithMargins(paramRecycler, i, j, k, m);
      if ((paramState.isItemRemoved()) || (paramState.isItemChanged())) {
        paramLayoutChunkResult.mIgnoreConsumed = true;
      }
      paramLayoutChunkResult.mFocusable |= paramRecycler.hasFocusable();
      i2 = i1 + 1;
      i1 = k;
      k = i;
      i = j;
      j = m;
      m = i1;
      i1 = i2;
    }
    Arrays.fill(this.mSet, null);
  }
  
  void onAnchorReady(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo, int paramInt)
  {
    super.onAnchorReady(paramRecycler, paramState, paramAnchorInfo, paramInt);
    updateMeasurements();
    if ((paramState.getItemCount() > 0) && (!paramState.isPreLayout())) {
      ensureAnchorIsInCorrectSpan(paramRecycler, paramState, paramAnchorInfo, paramInt);
    }
    ensureViewSet();
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    View localView = findContainingItemView(paramView);
    Object localObject1 = null;
    if (localView == null) {
      return null;
    }
    Object localObject2 = (GridLayoutManager.LayoutParams)localView.getLayoutParams();
    int i6 = ((GridLayoutManager.LayoutParams)localObject2).mSpanIndex;
    int i7 = ((GridLayoutManager.LayoutParams)localObject2).mSpanIndex + ((GridLayoutManager.LayoutParams)localObject2).mSpanSize;
    if (super.onFocusSearchFailed(paramView, paramInt, paramRecycler, paramState) == null) {
      return null;
    }
    int i12;
    if (convertFocusDirectionToLayoutDirection(paramInt) == 1) {
      i12 = 1;
    } else {
      i12 = 0;
    }
    if (i12 != this.mShouldReverseLayout) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int k;
    int m;
    if (paramInt != 0)
    {
      k = getChildCount() - 1;
      j = -1;
      m = -1;
    }
    else
    {
      j = getChildCount();
      k = 0;
      m = 1;
    }
    int n;
    if ((this.mOrientation == 1) && (isLayoutRTL())) {
      n = 1;
    } else {
      n = 0;
    }
    int i8 = getSpanGroupIndex(paramRecycler, paramState, k);
    paramView = null;
    int i2 = -1;
    int i3 = 0;
    paramInt = 0;
    int i = -1;
    int i1 = j;
    int j = i2;
    i2 = k;
    while (i2 != i1)
    {
      k = getSpanGroupIndex(paramRecycler, paramState, i2);
      localObject2 = getChildAt(i2);
      if (localObject2 == localView) {
        break;
      }
      if ((((View)localObject2).hasFocusable()) && (k != i8))
      {
        if (localObject1 != null) {
          break;
        }
      }
      else
      {
        GridLayoutManager.LayoutParams localLayoutParams = (GridLayoutManager.LayoutParams)((View)localObject2).getLayoutParams();
        int i9 = localLayoutParams.mSpanIndex;
        int i10 = localLayoutParams.mSpanIndex + localLayoutParams.mSpanSize;
        if ((((View)localObject2).hasFocusable()) && (i9 == i6) && (i10 == i7)) {
          return localObject2;
        }
        if (((((View)localObject2).hasFocusable()) && (localObject1 == null)) || ((!((View)localObject2).hasFocusable()) && (paramView == null))) {}
        do
        {
          int i11;
          for (;;)
          {
            k = 1;
            break label480;
            k = Math.max(i9, i6);
            i11 = Math.min(i10, i7) - k;
            if (!((View)localObject2).hasFocusable()) {
              break;
            }
            if (i11 <= i3)
            {
              if (i11 != i3) {
                break label477;
              }
              if (i9 > j) {
                k = 1;
              } else {
                k = 0;
              }
              if (n != k) {
                break label477;
              }
            }
          }
          if (localObject1 != null) {
            break;
          }
          int i5 = 1;
          k = 1;
          if (!isViewPartiallyVisible((View)localObject2, false, true)) {
            break;
          }
          int i4 = paramInt;
          if (i11 > i4)
          {
            k = i5;
            break label480;
          }
          if (i11 != i4) {
            break;
          }
          if (i9 <= i) {
            k = 0;
          }
        } while (n == k);
        label477:
        k = 0;
        label480:
        if (k != 0) {
          if (((View)localObject2).hasFocusable())
          {
            j = localLayoutParams.mSpanIndex;
            k = Math.min(i10, i7);
            i3 = Math.max(i9, i6);
            i3 = k - i3;
            localObject1 = localObject2;
          }
          else
          {
            i = localLayoutParams.mSpanIndex;
            paramInt = Math.min(i10, i7);
            k = Math.max(i9, i6);
            paramView = (View)localObject2;
            paramInt -= k;
          }
        }
      }
      i2 += m;
    }
    if (localObject1 != null) {
      return localObject1;
    }
    return paramView;
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof GridLayoutManager.LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
      return;
    }
    paramView = (GridLayoutManager.LayoutParams)localLayoutParams;
    int i = getSpanGroupIndex(paramRecycler, paramState, paramView.getViewLayoutPosition());
    if (this.mOrientation == 0)
    {
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(paramView.getSpanIndex(), paramView.getSpanSize(), i, 1, false, false));
      return;
    }
    paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, paramView.getSpanIndex(), paramView.getSpanSize(), false, false));
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
    this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
    this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
    this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
    this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
    this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (paramState.isPreLayout()) {
      cachePreLayoutSpanMapping();
    }
    super.onLayoutChildren(paramRecycler, paramState);
    clearPreLayoutSpanMappingCache();
  }
  
  public void onLayoutCompleted(RecyclerView.State paramState)
  {
    super.onLayoutCompleted(paramState);
    this.mPendingSpanCountChange = false;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    updateMeasurements();
    ensureViewSet();
    return super.scrollHorizontallyBy(paramInt, paramRecycler, paramState);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    updateMeasurements();
    ensureViewSet();
    return super.scrollVerticallyBy(paramInt, paramRecycler, paramState);
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (this.mCachedBorders == null) {
      super.setMeasuredDimension(paramRect, paramInt1, paramInt2);
    }
    int i = getPaddingLeft() + getPaddingRight();
    int j = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1)
    {
      paramInt2 = chooseSize(paramInt2, paramRect.height() + j, getMinimumHeight());
      paramRect = this.mCachedBorders;
      i = chooseSize(paramInt1, paramRect[(paramRect.length - 1)] + i, getMinimumWidth());
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
    else
    {
      paramInt1 = chooseSize(paramInt1, paramRect.width() + i, getMinimumWidth());
      paramRect = this.mCachedBorders;
      i = chooseSize(paramInt2, paramRect[(paramRect.length - 1)] + j, getMinimumHeight());
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void setSpanCount(int paramInt)
  {
    if (paramInt == this.mSpanCount) {
      return;
    }
    this.mPendingSpanCountChange = true;
    if (paramInt >= 1)
    {
      this.mSpanCount = paramInt;
      this.mSpanSizeLookup.invalidateSpanIndexCache();
      requestLayout();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Span count should be at least 1. Provided ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setSpanSizeLookup(GridLayoutManager.SpanSizeLookup paramSpanSizeLookup)
  {
    this.mSpanSizeLookup = paramSpanSizeLookup;
  }
  
  public void setStackFromEnd(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      super.setStackFromEnd(false);
      return;
    }
    throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
  }
  
  public void setUsingSpansToEstimateScrollbarDimensions(boolean paramBoolean)
  {
    this.mUsingSpansToEstimateScrollBarDimensions = paramBoolean;
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (this.mPendingSavedState == null) && (!this.mPendingSpanCountChange);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.GridLayoutManager
 * JD-Core Version:    0.7.0.1
 */