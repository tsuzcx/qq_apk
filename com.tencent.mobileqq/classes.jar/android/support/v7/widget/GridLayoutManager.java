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
  SpanSizeLookup mSpanSizeLookup = new DefaultSpanSizeLookup();
  
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
    int k;
    label43:
    LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      paramInt2 = 0;
      j = paramInt1;
      i = 1;
      paramInt1 = paramInt2;
      if ((this.mOrientation != 1) || (!isLayoutRTL())) {
        break label150;
      }
      paramInt2 = this.mSpanCount - 1;
      k = -1;
      if (paramInt1 == j) {
        return;
      }
      View localView = this.mSet[paramInt1];
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      LayoutParams.access$102(localLayoutParams, getSpanSize(paramRecycler, paramState, getPosition(localView)));
      if ((k != -1) || (localLayoutParams.mSpanSize <= 1)) {
        break label159;
      }
      LayoutParams.access$002(localLayoutParams, paramInt2 - (localLayoutParams.mSpanSize - 1));
    }
    for (;;)
    {
      paramInt2 += localLayoutParams.mSpanSize * k;
      paramInt1 += i;
      break label43;
      paramInt1 -= 1;
      j = -1;
      i = -1;
      break;
      label150:
      paramInt2 = 0;
      k = 1;
      break label43;
      label159:
      LayoutParams.access$002(localLayoutParams, paramInt2);
    }
  }
  
  private void cachePreLayoutSpanMapping()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      LayoutParams localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
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
    arrayOfInt[0] = 0;
    int n = paramInt2 / paramInt1;
    int i2 = paramInt2 % paramInt1;
    int j = 0;
    paramInt2 = 0;
    int i = 1;
    while (i <= paramInt1)
    {
      int k = n;
      int i1 = paramInt2 + i2;
      paramInt2 = i1;
      int m = k;
      if (i1 > 0)
      {
        paramInt2 = i1;
        m = k;
        if (paramInt1 - i1 < i2)
        {
          m = k + 1;
          paramInt2 = i1 - paramInt1;
        }
      }
      j += m;
      arrayOfInt[i] = j;
      i += 1;
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
    int i = 1;
    if (paramInt == 1) {}
    for (;;)
    {
      paramInt = getSpanIndex(paramRecycler, paramState, paramAnchorInfo.mPosition);
      if (i == 0) {
        break;
      }
      while ((paramInt > 0) && (paramAnchorInfo.mPosition > 0))
      {
        paramAnchorInfo.mPosition -= 1;
        paramInt = getSpanIndex(paramRecycler, paramState, paramAnchorInfo.mPosition);
      }
      i = 0;
    }
    int k = paramState.getItemCount();
    i = paramAnchorInfo.mPosition;
    while (i < k - 1)
    {
      int j = getSpanIndex(paramRecycler, paramState, i + 1);
      if (j <= paramInt) {
        break;
      }
      i += 1;
      paramInt = j;
    }
    paramAnchorInfo.mPosition = i;
  }
  
  private void ensureViewSet()
  {
    if ((this.mSet == null) || (this.mSet.length != this.mSpanCount)) {
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
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + paramInt);
      return 0;
    }
    return this.mSpanSizeLookup.getSpanGroupIndex(i, this.mSpanCount);
  }
  
  private int getSpanIndex(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (!paramState.isPreLayout()) {
      i = this.mSpanSizeLookup.getCachedSpanIndex(paramInt, this.mSpanCount);
    }
    int j;
    do
    {
      return i;
      j = this.mPreLayoutSpanIndexCache.get(paramInt, -1);
      i = j;
    } while (j != -1);
    int i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + paramInt);
      return 0;
    }
    return this.mSpanSizeLookup.getCachedSpanIndex(i, this.mSpanCount);
  }
  
  private int getSpanSize(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (!paramState.isPreLayout()) {
      i = this.mSpanSizeLookup.getSpanSize(paramInt);
    }
    int j;
    do
    {
      return i;
      j = this.mPreLayoutSpanSizeCache.get(paramInt, -1);
      i = j;
    } while (j != -1);
    int i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + paramInt);
      return 1;
    }
    return this.mSpanSizeLookup.getSpanSize(i);
  }
  
  private void guessMeasurement(float paramFloat, int paramInt)
  {
    calculateItemBorders(Math.max(Math.round(this.mSpanCount * paramFloat), paramInt));
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
    if (paramBoolean2) {}
    for (paramBoolean1 = shouldReMeasureChild(paramView, i, paramInt1, localLayoutParams);; paramBoolean1 = shouldMeasureChild(paramView, i, paramInt1, localLayoutParams))
    {
      if (paramBoolean1) {
        paramView.measure(i, paramInt1);
      }
      return;
    }
  }
  
  private void updateMeasurements()
  {
    if (getOrientation() == 1) {}
    for (int i = getWidth() - getPaddingRight() - getPaddingLeft();; i = getHeight() - getPaddingBottom() - getPaddingTop())
    {
      calculateItemBorders(i);
      return;
    }
  }
  
  private int updateSpecWithExtra(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {}
    int i;
    do
    {
      return paramInt1;
      i = View.MeasureSpec.getMode(paramInt1);
    } while ((i != -2147483648) && (i != 1073741824));
    return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3, i);
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  View findReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, int paramInt3)
  {
    ensureLayoutState();
    Object localObject2 = null;
    Object localObject1 = null;
    int j = this.mOrientationHelper.getStartAfterPadding();
    int k = this.mOrientationHelper.getEndAfterPadding();
    int i;
    View localView;
    Object localObject3;
    Object localObject4;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      if (paramInt1 == paramInt2) {
        break label221;
      }
      localView = getChildAt(paramInt1);
      int m = getPosition(localView);
      localObject3 = localObject2;
      localObject4 = localObject1;
      if (m >= 0)
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (m < paramInt3)
        {
          if (getSpanIndex(paramRecycler, paramState, m) == 0) {
            break label127;
          }
          localObject4 = localObject1;
          localObject3 = localObject2;
        }
      }
    }
    for (;;)
    {
      paramInt1 += i;
      localObject2 = localObject3;
      localObject1 = localObject4;
      break;
      i = -1;
      break;
      label127:
      if (((RecyclerView.LayoutParams)localView.getLayoutParams()).isItemRemoved())
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (localObject2 == null)
        {
          localObject3 = localView;
          localObject4 = localObject1;
        }
      }
      else
      {
        if (this.mOrientationHelper.getDecoratedStart(localView) < k)
        {
          localObject3 = localView;
          if (this.mOrientationHelper.getDecoratedEnd(localView) >= j) {
            break label230;
          }
        }
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (localObject1 == null)
        {
          localObject3 = localObject2;
          localObject4 = localView;
        }
      }
    }
    label221:
    if (localObject1 != null) {}
    for (;;)
    {
      localObject3 = localObject1;
      label230:
      return localObject3;
      localObject1 = localObject2;
    }
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    if (this.mOrientation == 0) {
      return new LayoutParams(-2, -1);
    }
    return new LayoutParams(-1, -2);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
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
  
  public SpanSizeLookup getSpanSizeLookup()
  {
    return this.mSpanSizeLookup;
  }
  
  void layoutChunk(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, LinearLayoutManager.LayoutChunkResult paramLayoutChunkResult)
  {
    int i3 = this.mOrientationHelper.getModeInOther();
    label38:
    boolean bool;
    label58:
    int i2;
    int n;
    if (i3 != 1073741824)
    {
      j = 1;
      if (getChildCount() <= 0) {
        break label226;
      }
      k = this.mCachedBorders[this.mSpanCount];
      if (j != 0) {
        updateMeasurements();
      }
      if (paramLayoutState.mItemDirection != 1) {
        break label232;
      }
      bool = true;
      i1 = 0;
      i2 = 0;
      i = this.mSpanCount;
      n = i1;
      m = i2;
      if (!bool)
      {
        i = getSpanIndex(paramRecycler, paramState, paramLayoutState.mCurrentPosition) + getSpanSize(paramRecycler, paramState, paramLayoutState.mCurrentPosition);
        m = i2;
        n = i1;
      }
    }
    for (;;)
    {
      if ((n < this.mSpanCount) && (paramLayoutState.hasMore(paramState)) && (i > 0))
      {
        i2 = paramLayoutState.mCurrentPosition;
        i1 = getSpanSize(paramRecycler, paramState, i2);
        if (i1 > this.mSpanCount)
        {
          throw new IllegalArgumentException("Item at position " + i2 + " requires " + i1 + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
          j = 0;
          break;
          label226:
          k = 0;
          break label38;
          label232:
          bool = false;
          break label58;
        }
        i -= i1;
        if (i >= 0) {
          break label262;
        }
      }
      label262:
      View localView;
      do
      {
        if (n != 0) {
          break;
        }
        paramLayoutChunkResult.mFinished = true;
        return;
        localView = paramLayoutState.next(paramRecycler);
      } while (localView == null);
      m += i1;
      this.mSet[n] = localView;
      n += 1;
    }
    int i = 0;
    float f1 = 0.0F;
    assignSpans(paramRecycler, paramState, n, m, bool);
    int m = 0;
    if (m < n)
    {
      paramRecycler = this.mSet[m];
      if (paramLayoutState.mScrapList == null) {
        if (bool)
        {
          addView(paramRecycler);
          label352:
          paramState = (LayoutParams)paramRecycler.getLayoutParams();
          i2 = this.mCachedBorders[(paramState.mSpanIndex + paramState.mSpanSize)];
          int i4 = this.mCachedBorders[paramState.mSpanIndex];
          if (this.mOrientation != 0) {
            break label588;
          }
          i1 = paramState.height;
          label400:
          i2 = getChildMeasureSpec(i2 - i4, i3, 0, i1, false);
          i4 = this.mOrientationHelper.getTotalSpace();
          int i5 = this.mOrientationHelper.getMode();
          if (this.mOrientation != 1) {
            break label597;
          }
          i1 = paramState.height;
          label448:
          i1 = getChildMeasureSpec(i4, i5, 0, i1, true);
          if (this.mOrientation != 1) {
            break label606;
          }
          measureChildWithDecorationsAndMargin(paramRecycler, i2, i1, false, false);
        }
      }
      for (;;)
      {
        i2 = this.mOrientationHelper.getDecoratedMeasurement(paramRecycler);
        i1 = i;
        if (i2 > i) {
          i1 = i2;
        }
        float f3 = 1.0F * this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) / paramState.mSpanSize;
        float f2 = f1;
        if (f3 > f1) {
          f2 = f3;
        }
        m += 1;
        i = i1;
        f1 = f2;
        break;
        addView(paramRecycler, 0);
        break label352;
        if (bool)
        {
          addDisappearingView(paramRecycler);
          break label352;
        }
        addDisappearingView(paramRecycler, 0);
        break label352;
        label588:
        i1 = paramState.width;
        break label400;
        label597:
        i1 = paramState.width;
        break label448;
        label606:
        measureChildWithDecorationsAndMargin(paramRecycler, i1, i2, false, false);
      }
    }
    m = i;
    if (j != 0)
    {
      guessMeasurement(f1, k);
      i = 0;
      j = 0;
      m = i;
      if (j < n)
      {
        paramRecycler = this.mSet[j];
        paramState = (LayoutParams)paramRecycler.getLayoutParams();
        m = this.mCachedBorders[(paramState.mSpanIndex + paramState.mSpanSize)];
        i1 = this.mCachedBorders[paramState.mSpanIndex];
        if (this.mOrientation == 0)
        {
          k = paramState.height;
          label710:
          m = getChildMeasureSpec(m - i1, 1073741824, 0, k, false);
          i1 = this.mOrientationHelper.getTotalSpace();
          i2 = this.mOrientationHelper.getMode();
          if (this.mOrientation != 1) {
            break label838;
          }
          k = paramState.height;
          label759:
          k = getChildMeasureSpec(i1, i2, 0, k, true);
          if (this.mOrientation != 1) {
            break label847;
          }
          measureChildWithDecorationsAndMargin(paramRecycler, m, k, false, true);
        }
        for (;;)
        {
          m = this.mOrientationHelper.getDecoratedMeasurement(paramRecycler);
          k = i;
          if (m > i) {
            k = m;
          }
          j += 1;
          i = k;
          break;
          k = paramState.width;
          break label710;
          label838:
          k = paramState.width;
          break label759;
          label847:
          measureChildWithDecorationsAndMargin(paramRecycler, k, m, false, true);
        }
      }
    }
    int k = View.MeasureSpec.makeMeasureSpec(m, 1073741824);
    i = 0;
    if (i < n)
    {
      paramRecycler = this.mSet[i];
      if (this.mOrientationHelper.getDecoratedMeasurement(paramRecycler) != m)
      {
        paramState = (LayoutParams)paramRecycler.getLayoutParams();
        i1 = this.mCachedBorders[(paramState.mSpanIndex + paramState.mSpanSize)];
        i2 = this.mCachedBorders[paramState.mSpanIndex];
        if (this.mOrientation != 0) {
          break label995;
        }
        j = paramState.height;
        label950:
        j = getChildMeasureSpec(i1 - i2, 1073741824, 0, j, false);
        if (this.mOrientation != 1) {
          break label1004;
        }
        measureChildWithDecorationsAndMargin(paramRecycler, j, k, true, true);
      }
      for (;;)
      {
        i += 1;
        break;
        label995:
        j = paramState.width;
        break label950;
        label1004:
        measureChildWithDecorationsAndMargin(paramRecycler, k, j, true, true);
      }
    }
    paramLayoutChunkResult.mConsumed = m;
    int j = 0;
    k = 0;
    int i1 = 0;
    i = 0;
    if (this.mOrientation == 1) {
      if (paramLayoutState.mLayoutDirection == -1)
      {
        i = paramLayoutState.mOffset;
        m = i - m;
        i1 = 0;
        i2 = k;
        i3 = j;
        k = i1;
        i1 = i;
        label1085:
        if (k >= n) {
          break label1382;
        }
        paramRecycler = this.mSet[k];
        paramState = (LayoutParams)paramRecycler.getLayoutParams();
        if (this.mOrientation != 1) {
          break label1342;
        }
        if (!isLayoutRTL()) {
          break label1310;
        }
        j = getPaddingLeft() + this.mCachedBorders[(paramState.mSpanIndex + paramState.mSpanSize)];
        i = j - this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
      }
    }
    for (;;)
    {
      layoutDecorated(paramRecycler, i + paramState.leftMargin, m + paramState.topMargin, j - paramState.rightMargin, i1 - paramState.bottomMargin);
      if ((paramState.isItemRemoved()) || (paramState.isItemChanged())) {
        paramLayoutChunkResult.mIgnoreConsumed = true;
      }
      paramLayoutChunkResult.mFocusable |= paramRecycler.isFocusable();
      k += 1;
      i3 = i;
      i2 = j;
      break label1085;
      i1 = paramLayoutState.mOffset;
      i = i1 + m;
      m = i1;
      break;
      if (paramLayoutState.mLayoutDirection == -1)
      {
        k = paramLayoutState.mOffset;
        j = k - m;
        m = i1;
        break;
      }
      j = paramLayoutState.mOffset;
      k = j + m;
      m = i1;
      break;
      label1310:
      i = getPaddingLeft() + this.mCachedBorders[paramState.mSpanIndex];
      j = i + this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
      continue;
      label1342:
      m = getPaddingTop() + this.mCachedBorders[paramState.mSpanIndex];
      i1 = m + this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
      i = i3;
      j = i2;
    }
    label1382:
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
    if (localView == null) {
      paramRecycler = null;
    }
    LayoutParams localLayoutParams;
    int i4;
    int i5;
    label83:
    label100:
    int k;
    label118:
    int n;
    int i1;
    label159:
    label164:
    label178:
    label201:
    int i6;
    int i7;
    do
    {
      return paramRecycler;
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      i4 = localLayoutParams.mSpanIndex;
      i5 = localLayoutParams.mSpanIndex + localLayoutParams.mSpanSize;
      if (super.onFocusSearchFailed(paramView, paramInt, paramRecycler, paramState) == null) {
        return null;
      }
      int i8;
      int i;
      int j;
      int m;
      if (convertFocusDirectionToLayoutDirection(paramInt) == 1)
      {
        i8 = 1;
        if (i8 == this.mShouldReverseLayout) {
          break label159;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label164;
        }
        paramInt = getChildCount() - 1;
        i = -1;
        j = -1;
        if ((this.mOrientation != 1) || (!isLayoutRTL())) {
          break label178;
        }
        k = 1;
        paramState = null;
        n = -1;
        i1 = 0;
        m = paramInt;
      }
      for (;;)
      {
        if (m != j)
        {
          paramView = getChildAt(m);
          if (paramView != localView) {}
        }
        else
        {
          return paramState;
          i8 = 0;
          break;
          paramInt = 0;
          break label83;
          paramInt = 0;
          i = 1;
          j = getChildCount();
          break label100;
          k = 0;
          break label118;
        }
        if (paramView.isFocusable()) {
          break label201;
        }
        m += i;
      }
      localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      i6 = localLayoutParams.mSpanIndex;
      i7 = localLayoutParams.mSpanIndex + localLayoutParams.mSpanSize;
      if (i6 != i4) {
        break;
      }
      paramRecycler = paramView;
    } while (i7 == i5);
    int i3 = 0;
    if (paramState == null) {
      paramInt = 1;
    }
    for (;;)
    {
      label256:
      if (paramInt != 0)
      {
        n = localLayoutParams.mSpanIndex;
        i1 = Math.min(i7, i5) - Math.max(i6, i4);
        paramState = paramView;
        break;
        paramInt = Math.max(i6, i4);
        i2 = Math.min(i7, i5) - paramInt;
        if (i2 > i1)
        {
          paramInt = 1;
        }
        else
        {
          paramInt = i3;
          if (i2 == i1) {
            if (i6 <= n) {
              break label356;
            }
          }
        }
      }
    }
    label356:
    for (int i2 = 1;; i2 = 0)
    {
      paramInt = i3;
      if (k != i2) {
        break label256;
      }
      paramInt = 1;
      break label256;
      break;
    }
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
      return;
    }
    paramView = (LayoutParams)localLayoutParams;
    int i = getSpanGroupIndex(paramRecycler, paramState, paramView.getViewLayoutPosition());
    if (this.mOrientation == 0)
    {
      j = paramView.getSpanIndex();
      k = paramView.getSpanSize();
      if ((this.mSpanCount > 1) && (paramView.getSpanSize() == this.mSpanCount)) {}
      for (bool = true;; bool = false)
      {
        paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(j, k, i, 1, bool, false));
        return;
      }
    }
    int j = paramView.getSpanIndex();
    int k = paramView.getSpanSize();
    if ((this.mSpanCount > 1) && (paramView.getSpanSize() == this.mSpanCount)) {}
    for (boolean bool = true;; bool = false)
    {
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, j, k, bool, false));
      return;
    }
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
    int j = getPaddingLeft() + getPaddingRight();
    int k = getPaddingTop() + getPaddingBottom();
    int i;
    if (this.mOrientation == 1)
    {
      i = chooseSize(paramInt2, paramRect.height() + k, getMinimumHeight());
      paramInt2 = chooseSize(paramInt1, this.mCachedBorders[(this.mCachedBorders.length - 1)] + j, getMinimumWidth());
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i = chooseSize(paramInt1, paramRect.width() + j, getMinimumWidth());
      paramInt1 = chooseSize(paramInt2, this.mCachedBorders[(this.mCachedBorders.length - 1)] + k, getMinimumHeight());
      paramInt2 = i;
    }
  }
  
  public void setSpanCount(int paramInt)
  {
    if (paramInt == this.mSpanCount) {
      return;
    }
    this.mPendingSpanCountChange = true;
    if (paramInt < 1) {
      throw new IllegalArgumentException("Span count should be at least 1. Provided " + paramInt);
    }
    this.mSpanCount = paramInt;
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void setSpanSizeLookup(SpanSizeLookup paramSpanSizeLookup)
  {
    this.mSpanSizeLookup = paramSpanSizeLookup;
  }
  
  public void setStackFromEnd(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }
    super.setStackFromEnd(false);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (this.mPendingSavedState == null) && (!this.mPendingSpanCountChange);
  }
  
  public static final class DefaultSpanSizeLookup
    extends GridLayoutManager.SpanSizeLookup
  {
    public int getSpanIndex(int paramInt1, int paramInt2)
    {
      return paramInt1 % paramInt2;
    }
    
    public int getSpanSize(int paramInt)
    {
      return 1;
    }
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    public static final int INVALID_SPAN_ID = -1;
    private int mSpanIndex = -1;
    private int mSpanSize = 0;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(RecyclerView.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public int getSpanIndex()
    {
      return this.mSpanIndex;
    }
    
    public int getSpanSize()
    {
      return this.mSpanSize;
    }
  }
  
  public static abstract class SpanSizeLookup
  {
    private boolean mCacheSpanIndices = false;
    final SparseIntArray mSpanIndexCache = new SparseIntArray();
    
    int findReferenceIndexFromCache(int paramInt)
    {
      int i = 0;
      int j = this.mSpanIndexCache.size() - 1;
      while (i <= j)
      {
        int k = i + j >>> 1;
        if (this.mSpanIndexCache.keyAt(k) < paramInt) {
          i = k + 1;
        } else {
          j = k - 1;
        }
      }
      paramInt = i - 1;
      if ((paramInt >= 0) && (paramInt < this.mSpanIndexCache.size())) {
        return this.mSpanIndexCache.keyAt(paramInt);
      }
      return -1;
    }
    
    int getCachedSpanIndex(int paramInt1, int paramInt2)
    {
      int i;
      if (!this.mCacheSpanIndices) {
        i = getSpanIndex(paramInt1, paramInt2);
      }
      int j;
      do
      {
        return i;
        j = this.mSpanIndexCache.get(paramInt1, -1);
        i = j;
      } while (j != -1);
      paramInt2 = getSpanIndex(paramInt1, paramInt2);
      this.mSpanIndexCache.put(paramInt1, paramInt2);
      return paramInt2;
    }
    
    public int getSpanGroupIndex(int paramInt1, int paramInt2)
    {
      int i = 0;
      int j = 0;
      int i2 = getSpanSize(paramInt1);
      int m = 0;
      if (m < paramInt1)
      {
        int n = getSpanSize(m);
        int i1 = i + n;
        int k;
        if (i1 == paramInt2)
        {
          i = 0;
          k = j + 1;
        }
        for (;;)
        {
          m += 1;
          j = k;
          break;
          k = j;
          i = i1;
          if (i1 > paramInt2)
          {
            i = n;
            k = j + 1;
          }
        }
      }
      paramInt1 = j;
      if (i + i2 > paramInt2) {
        paramInt1 = j + 1;
      }
      return paramInt1;
    }
    
    public int getSpanIndex(int paramInt1, int paramInt2)
    {
      int n = getSpanSize(paramInt1);
      if (n == paramInt2) {
        paramInt1 = 0;
      }
      int i;
      do
      {
        return paramInt1;
        int k = 0;
        int m = 0;
        i = k;
        int j = m;
        if (this.mCacheSpanIndices)
        {
          i = k;
          j = m;
          if (this.mSpanIndexCache.size() > 0)
          {
            int i1 = findReferenceIndexFromCache(paramInt1);
            i = k;
            j = m;
            if (i1 >= 0)
            {
              i = this.mSpanIndexCache.get(i1) + getSpanSize(i1);
              j = i1 + 1;
            }
          }
        }
        if (j < paramInt1)
        {
          k = getSpanSize(j);
          m = i + k;
          if (m == paramInt2) {
            i = 0;
          }
          for (;;)
          {
            j += 1;
            break;
            i = m;
            if (m > paramInt2) {
              i = k;
            }
          }
        }
        paramInt1 = i;
      } while (i + n <= paramInt2);
      return 0;
    }
    
    public abstract int getSpanSize(int paramInt);
    
    public void invalidateSpanIndexCache()
    {
      this.mSpanIndexCache.clear();
    }
    
    public boolean isSpanIndexCacheEnabled()
    {
      return this.mCacheSpanIndices;
    }
    
    public void setSpanIndexCacheEnabled(boolean paramBoolean)
    {
      this.mCacheSpanIndices = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.GridLayoutManager
 * JD-Core Version:    0.7.0.1
 */