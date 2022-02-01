package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
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
  
  private void assignSpans(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j;
    int i;
    if (paramBoolean)
    {
      j = paramInt1;
      paramInt1 = 0;
      i = 1;
    }
    else
    {
      paramInt1 -= 1;
      j = -1;
      i = -1;
    }
    int k;
    if ((this.mOrientation == 1) && (isLayoutRTL()))
    {
      paramInt2 = this.mSpanCount - 1;
      k = -1;
    }
    else
    {
      k = 1;
      paramInt2 = 0;
    }
    while (paramInt1 != j)
    {
      View localView = this.mSet[paramInt1];
      GridLayoutManager.LayoutParams localLayoutParams = (GridLayoutManager.LayoutParams)localView.getLayoutParams();
      GridLayoutManager.LayoutParams.access$102(localLayoutParams, getSpanSize(paramRecycler, paramState, getPosition(localView)));
      if ((k == -1) && (GridLayoutManager.LayoutParams.access$100(localLayoutParams) > 1)) {
        GridLayoutManager.LayoutParams.access$002(localLayoutParams, paramInt2 - (GridLayoutManager.LayoutParams.access$100(localLayoutParams) - 1));
      } else {
        GridLayoutManager.LayoutParams.access$002(localLayoutParams, paramInt2);
      }
      paramInt2 += GridLayoutManager.LayoutParams.access$100(localLayoutParams) * k;
      paramInt1 += i;
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
      return this.mSpanSizeLookup.getSpanGroupIndex(paramInt, this.mSpanCount);
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
    return this.mSpanSizeLookup.getSpanGroupIndex(i, this.mSpanCount);
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
  
  private void measureChildWithDecorationsAndMargin(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    calculateItemDecorationsForChild(paramView, this.mDecorInsets);
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i;
    if (!paramBoolean1)
    {
      i = paramInt1;
      if (this.mOrientation != 1) {}
    }
    else
    {
      i = updateSpecWithExtra(paramInt1, localLayoutParams.leftMargin + this.mDecorInsets.left, localLayoutParams.rightMargin + this.mDecorInsets.right);
    }
    if (!paramBoolean1)
    {
      paramInt1 = paramInt2;
      if (this.mOrientation != 0) {}
    }
    else
    {
      paramInt1 = updateSpecWithExtra(paramInt2, localLayoutParams.topMargin + this.mDecorInsets.top, localLayoutParams.bottomMargin + this.mDecorInsets.bottom);
    }
    if (paramBoolean2) {
      paramBoolean1 = shouldReMeasureChild(paramView, i, paramInt1, localLayoutParams);
    } else {
      paramBoolean1 = shouldMeasureChild(paramView, i, paramInt1, localLayoutParams);
    }
    if (paramBoolean1) {
      paramView.measure(i, paramInt1);
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
  
  private int updateSpecWithExtra(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      return paramInt1;
    }
    int i = View.MeasureSpec.getMode(paramInt1);
    if ((i != -2147483648) && (i != 1073741824)) {
      return paramInt1;
    }
    return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3, i);
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof GridLayoutManager.LayoutParams;
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
  
  public int getSpanCount()
  {
    return this.mSpanCount;
  }
  
  public GridLayoutManager.SpanSizeLookup getSpanSizeLookup()
  {
    return this.mSpanSizeLookup;
  }
  
  void layoutChunk(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, LinearLayoutManager.LayoutChunkResult paramLayoutChunkResult)
  {
    int i2 = this.mOrientationHelper.getModeInOther();
    if (i2 != 1073741824) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if (getChildCount() > 0) {
      k = this.mCachedBorders[this.mSpanCount];
    } else {
      k = 0;
    }
    if (j != 0) {
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
    int m = 0;
    int n = 0;
    int i3;
    while ((n < this.mSpanCount) && (paramLayoutState.hasMore(paramState)) && (i > 0))
    {
      i3 = paramLayoutState.mCurrentPosition;
      i1 = getSpanSize(paramRecycler, paramState, i3);
      if (i1 <= this.mSpanCount)
      {
        i -= i1;
        if (i >= 0)
        {
          View localView = paramLayoutState.next(paramRecycler);
          if (localView != null)
          {
            m += i1;
            this.mSet[n] = localView;
            n += 1;
          }
        }
      }
      else
      {
        paramRecycler = new StringBuilder();
        paramRecycler.append("Item at position ");
        paramRecycler.append(i3);
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
    assignSpans(paramRecycler, paramState, n, m, bool);
    i = 0;
    float f1 = 0.0F;
    int i1 = 0;
    m = i2;
    while (i1 < n)
    {
      paramRecycler = this.mSet[i1];
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
      paramState = (GridLayoutManager.LayoutParams)paramRecycler.getLayoutParams();
      i3 = this.mCachedBorders[(GridLayoutManager.LayoutParams.access$000(paramState) + GridLayoutManager.LayoutParams.access$100(paramState))];
      int i4 = this.mCachedBorders[GridLayoutManager.LayoutParams.access$000(paramState)];
      if (this.mOrientation == 0) {
        i2 = paramState.height;
      } else {
        i2 = paramState.width;
      }
      i3 = getChildMeasureSpec(i3 - i4, m, 0, i2, false);
      i4 = this.mOrientationHelper.getTotalSpace();
      int i5 = this.mOrientationHelper.getMode();
      if (this.mOrientation == 1) {
        i2 = paramState.height;
      } else {
        i2 = paramState.width;
      }
      i2 = getChildMeasureSpec(i4, i5, 0, i2, true);
      if (this.mOrientation == 1) {
        measureChildWithDecorationsAndMargin(paramRecycler, i3, i2, false, false);
      } else {
        measureChildWithDecorationsAndMargin(paramRecycler, i2, i3, false, false);
      }
      i2 = this.mOrientationHelper.getDecoratedMeasurement(paramRecycler);
      if (i2 > i) {
        i = i2;
      }
      float f2 = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) * 1.0F / GridLayoutManager.LayoutParams.access$100(paramState);
      if (f2 > f1) {
        f1 = f2;
      }
      i1 += 1;
    }
    if (j != 0)
    {
      guessMeasurement(f1, k);
      j = 0;
      for (i = 0; j < n; i = k)
      {
        paramRecycler = this.mSet[j];
        paramState = (GridLayoutManager.LayoutParams)paramRecycler.getLayoutParams();
        m = this.mCachedBorders[(GridLayoutManager.LayoutParams.access$000(paramState) + GridLayoutManager.LayoutParams.access$100(paramState))];
        i1 = this.mCachedBorders[GridLayoutManager.LayoutParams.access$000(paramState)];
        if (this.mOrientation == 0) {
          k = paramState.height;
        } else {
          k = paramState.width;
        }
        m = getChildMeasureSpec(m - i1, 1073741824, 0, k, false);
        i1 = this.mOrientationHelper.getTotalSpace();
        i2 = this.mOrientationHelper.getMode();
        if (this.mOrientation == 1) {
          k = paramState.height;
        } else {
          k = paramState.width;
        }
        k = getChildMeasureSpec(i1, i2, 0, k, true);
        if (this.mOrientation == 1) {
          measureChildWithDecorationsAndMargin(paramRecycler, m, k, false, true);
        } else {
          measureChildWithDecorationsAndMargin(paramRecycler, k, m, false, true);
        }
        m = this.mOrientationHelper.getDecoratedMeasurement(paramRecycler);
        k = i;
        if (m > i) {
          k = m;
        }
        j += 1;
      }
    }
    m = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    int j = 0;
    while (j < n)
    {
      paramRecycler = this.mSet[j];
      if (this.mOrientationHelper.getDecoratedMeasurement(paramRecycler) != i)
      {
        paramState = (GridLayoutManager.LayoutParams)paramRecycler.getLayoutParams();
        i1 = this.mCachedBorders[(GridLayoutManager.LayoutParams.access$000(paramState) + GridLayoutManager.LayoutParams.access$100(paramState))];
        i2 = this.mCachedBorders[GridLayoutManager.LayoutParams.access$000(paramState)];
        if (this.mOrientation == 0) {
          k = paramState.height;
        } else {
          k = paramState.width;
        }
        k = getChildMeasureSpec(i1 - i2, 1073741824, 0, k, false);
        if (this.mOrientation == 1) {
          measureChildWithDecorationsAndMargin(paramRecycler, k, m, true, true);
        } else {
          measureChildWithDecorationsAndMargin(paramRecycler, m, k, true, true);
        }
      }
      j += 1;
    }
    i1 = 0;
    paramLayoutChunkResult.mConsumed = i;
    if (this.mOrientation == 1)
    {
      if (paramLayoutState.mLayoutDirection == -1)
      {
        k = paramLayoutState.mOffset;
        j = k;
        i = k - i;
      }
      else
      {
        j = paramLayoutState.mOffset;
        k = j;
        j += i;
        i = k;
      }
      k = 0;
      m = 0;
    }
    else if (paramLayoutState.mLayoutDirection == -1)
    {
      k = paramLayoutState.mOffset;
      i2 = 0;
      j = 0;
      m = k;
      k -= i;
      i = i2;
    }
    else
    {
      k = paramLayoutState.mOffset;
      m = k + i;
      i = 0;
      j = 0;
    }
    while (i1 < n)
    {
      paramRecycler = this.mSet[i1];
      paramState = (GridLayoutManager.LayoutParams)paramRecycler.getLayoutParams();
      if (this.mOrientation == 1)
      {
        if (isLayoutRTL())
        {
          m = getPaddingLeft() + this.mCachedBorders[(GridLayoutManager.LayoutParams.access$000(paramState) + GridLayoutManager.LayoutParams.access$100(paramState))];
          i2 = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
          k = m;
          m -= i2;
          break label1302;
        }
        k = getPaddingLeft() + this.mCachedBorders[GridLayoutManager.LayoutParams.access$000(paramState)];
        m = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) + k;
      }
      else
      {
        i = getPaddingTop() + this.mCachedBorders[GridLayoutManager.LayoutParams.access$000(paramState)];
        j = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) + i;
      }
      i2 = k;
      k = m;
      m = i2;
      label1302:
      layoutDecorated(paramRecycler, m + paramState.leftMargin, i + paramState.topMargin, k - paramState.rightMargin, j - paramState.bottomMargin);
      if ((!paramState.isItemRemoved()) && (!paramState.isItemChanged())) {
        break label1361;
      }
      paramLayoutChunkResult.mIgnoreConsumed = true;
      label1361:
      paramLayoutChunkResult.mFocusable |= paramRecycler.isFocusable();
      i2 = i1 + 1;
      i1 = k;
      k = m;
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
    Object localObject = null;
    if (localView == null) {
      return null;
    }
    GridLayoutManager.LayoutParams localLayoutParams = (GridLayoutManager.LayoutParams)localView.getLayoutParams();
    int i2 = GridLayoutManager.LayoutParams.access$000(localLayoutParams);
    int i3 = GridLayoutManager.LayoutParams.access$000(localLayoutParams) + GridLayoutManager.LayoutParams.access$100(localLayoutParams);
    if (super.onFocusSearchFailed(paramView, paramInt, paramRecycler, paramState) == null) {
      return null;
    }
    int i6;
    if (convertFocusDirectionToLayoutDirection(paramInt) == 1) {
      i6 = 1;
    } else {
      i6 = 0;
    }
    if (i6 != this.mShouldReverseLayout) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int i;
    int j;
    if (paramInt != 0)
    {
      paramInt = getChildCount() - 1;
      i = -1;
      j = -1;
    }
    else
    {
      i = getChildCount();
      paramInt = 0;
      j = 1;
    }
    int k;
    if ((this.mOrientation == 1) && (isLayoutRTL())) {
      k = 1;
    } else {
      k = 0;
    }
    int i1 = 0;
    int n = -1;
    int m = paramInt;
    paramView = localObject;
    for (;;)
    {
      paramInt = 1;
      if (m == i) {
        break;
      }
      paramRecycler = getChildAt(m);
      if (paramRecycler == localView) {
        return paramView;
      }
      if (paramRecycler.isFocusable())
      {
        paramState = (GridLayoutManager.LayoutParams)paramRecycler.getLayoutParams();
        int i4 = GridLayoutManager.LayoutParams.access$000(paramState);
        int i5 = GridLayoutManager.LayoutParams.access$000(paramState) + GridLayoutManager.LayoutParams.access$100(paramState);
        if ((i4 == i2) && (i5 == i3)) {
          return paramRecycler;
        }
        if (paramView != null)
        {
          paramInt = Math.max(i4, i2);
          paramInt = Math.min(i5, i3) - paramInt;
          if (paramInt > i1) {}
          do
          {
            paramInt = 1;
            break label308;
            if (paramInt != i1) {
              break;
            }
            if (i4 > n) {
              paramInt = 1;
            } else {
              paramInt = 0;
            }
          } while (k == paramInt);
          paramInt = 0;
        }
        label308:
        if (paramInt != 0)
        {
          n = GridLayoutManager.LayoutParams.access$000(paramState);
          paramInt = Math.min(i5, i3);
          i1 = Math.max(i4, i2);
          i1 = paramInt - i1;
          paramView = paramRecycler;
        }
      }
      m += j;
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
    boolean bool;
    if (this.mOrientation == 0)
    {
      j = paramView.getSpanIndex();
      k = paramView.getSpanSize();
      if ((this.mSpanCount > 1) && (paramView.getSpanSize() == this.mSpanCount)) {
        bool = true;
      } else {
        bool = false;
      }
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(j, k, i, 1, bool, false));
      return;
    }
    int j = paramView.getSpanIndex();
    int k = paramView.getSpanSize();
    if ((this.mSpanCount > 1) && (paramView.getSpanSize() == this.mSpanCount)) {
      bool = true;
    } else {
      bool = false;
    }
    paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, j, k, bool, false));
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (paramState.isPreLayout()) {
      cachePreLayoutSpanMapping();
    }
    super.onLayoutChildren(paramRecycler, paramState);
    clearPreLayoutSpanMappingCache();
    if (!paramState.isPreLayout()) {
      this.mPendingSpanCountChange = false;
    }
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
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (this.mPendingSavedState == null) && (!this.mPendingSpanCountChange);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.GridLayoutManager
 * JD-Core Version:    0.7.0.1
 */