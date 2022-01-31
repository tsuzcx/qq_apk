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
    int i;
    int j;
    int k;
    label43:
    GridLayoutManager.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      i = 1;
      paramInt2 = 0;
      j = paramInt1;
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
      localLayoutParams = (GridLayoutManager.LayoutParams)localView.getLayoutParams();
      GridLayoutManager.LayoutParams.access$102(localLayoutParams, getSpanSize(paramRecycler, paramState, getPosition(localView)));
      if ((k != -1) || (GridLayoutManager.LayoutParams.access$100(localLayoutParams) <= 1)) {
        break label159;
      }
      GridLayoutManager.LayoutParams.access$002(localLayoutParams, paramInt2 - (GridLayoutManager.LayoutParams.access$100(localLayoutParams) - 1));
    }
    for (;;)
    {
      paramInt2 += GridLayoutManager.LayoutParams.access$100(localLayoutParams) * k;
      paramInt1 += i;
      break label43;
      paramInt1 -= 1;
      i = -1;
      j = -1;
      break;
      label150:
      paramInt2 = 0;
      k = 1;
      break label43;
      label159:
      GridLayoutManager.LayoutParams.access$002(localLayoutParams, paramInt2);
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
    int k = 0;
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
    int m = paramInt2 / paramInt1;
    int n = paramInt2 % paramInt1;
    int i = 1;
    int j = 0;
    paramInt2 = k;
    if (i <= paramInt1)
    {
      paramInt2 += n;
      if ((paramInt2 <= 0) || (paramInt1 - paramInt2 >= n)) {
        break label113;
      }
      k = m + 1;
      paramInt2 -= paramInt1;
    }
    for (;;)
    {
      j += k;
      arrayOfInt[i] = j;
      i += 1;
      break;
      return arrayOfInt;
      label113:
      k = m;
    }
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
    return paramLayoutParams instanceof GridLayoutManager.LayoutParams;
  }
  
  View findReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    ensureLayoutState();
    int j = this.mOrientationHelper.getStartAfterPadding();
    int k = this.mOrientationHelper.getEndAfterPadding();
    int i;
    Object localObject1;
    label37:
    Object localObject3;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      localObject1 = null;
      if (paramInt1 == paramInt2) {
        break label197;
      }
      localObject3 = getChildAt(paramInt1);
      int m = getPosition((View)localObject3);
      if ((m < 0) || (m >= paramInt3)) {
        break label216;
      }
      if (getSpanIndex(paramRecycler, paramState, m) == 0) {
        break label119;
      }
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      paramInt1 += i;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break label37;
      i = -1;
      break;
      label119:
      if (((RecyclerView.LayoutParams)((View)localObject3).getLayoutParams()).isItemRemoved())
      {
        if (localObject1 == null)
        {
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
      }
      else
      {
        Object localObject4;
        if (this.mOrientationHelper.getDecoratedStart((View)localObject3) < k)
        {
          localObject4 = localObject3;
          if (this.mOrientationHelper.getDecoratedEnd((View)localObject3) >= j) {}
        }
        else
        {
          if (localObject2 != null) {
            break label216;
          }
          localObject2 = localObject1;
          localObject1 = localObject3;
          continue;
          if (localObject2 == null) {
            break label209;
          }
        }
        for (;;)
        {
          localObject4 = localObject2;
          return localObject4;
          localObject2 = localObject1;
        }
      }
      label197:
      label209:
      label216:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
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
    int i3 = this.mOrientationHelper.getModeInOther();
    int j;
    int k;
    label38:
    boolean bool;
    label58:
    int i1;
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
    assignSpans(paramRecycler, paramState, n, m, bool);
    int m = 0;
    float f1 = 0.0F;
    int i = 0;
    if (m < n)
    {
      paramRecycler = this.mSet[m];
      if (paramLayoutState.mScrapList == null) {
        if (bool)
        {
          addView(paramRecycler);
          label352:
          paramState = (GridLayoutManager.LayoutParams)paramRecycler.getLayoutParams();
          i2 = this.mCachedBorders[(GridLayoutManager.LayoutParams.access$000(paramState) + GridLayoutManager.LayoutParams.access$100(paramState))];
          int i4 = this.mCachedBorders[GridLayoutManager.LayoutParams.access$000(paramState)];
          if (this.mOrientation != 0) {
            break label572;
          }
          i1 = paramState.height;
          label400:
          i2 = getChildMeasureSpec(i2 - i4, i3, 0, i1, false);
          i4 = this.mOrientationHelper.getTotalSpace();
          int i5 = this.mOrientationHelper.getMode();
          if (this.mOrientation != 1) {
            break label581;
          }
          i1 = paramState.height;
          label448:
          i1 = getChildMeasureSpec(i4, i5, 0, i1, true);
          if (this.mOrientation != 1) {
            break label590;
          }
          measureChildWithDecorationsAndMargin(paramRecycler, i2, i1, false, false);
          label480:
          i1 = this.mOrientationHelper.getDecoratedMeasurement(paramRecycler);
          if (i1 <= i) {
            break label1427;
          }
          i = i1;
        }
      }
    }
    label775:
    label1421:
    label1427:
    for (;;)
    {
      float f2 = 1.0F * this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) / GridLayoutManager.LayoutParams.access$100(paramState);
      if (f2 > f1) {
        f1 = f2;
      }
      for (;;)
      {
        m += 1;
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
        label572:
        i1 = paramState.width;
        break label400;
        label581:
        i1 = paramState.width;
        break label448;
        label590:
        measureChildWithDecorationsAndMargin(paramRecycler, i1, i2, false, false);
        break label480;
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
            paramState = (GridLayoutManager.LayoutParams)paramRecycler.getLayoutParams();
            m = this.mCachedBorders[(GridLayoutManager.LayoutParams.access$000(paramState) + GridLayoutManager.LayoutParams.access$100(paramState))];
            i1 = this.mCachedBorders[GridLayoutManager.LayoutParams.access$000(paramState)];
            if (this.mOrientation == 0)
            {
              k = paramState.height;
              label694:
              m = getChildMeasureSpec(m - i1, 1073741824, 0, k, false);
              i1 = this.mOrientationHelper.getTotalSpace();
              i2 = this.mOrientationHelper.getMode();
              if (this.mOrientation != 1) {
                break label814;
              }
              k = paramState.height;
              label743:
              k = getChildMeasureSpec(i1, i2, 0, k, true);
              if (this.mOrientation != 1) {
                break label823;
              }
              measureChildWithDecorationsAndMargin(paramRecycler, m, k, false, true);
              k = this.mOrientationHelper.getDecoratedMeasurement(paramRecycler);
              if (k <= i) {
                break label1421;
              }
              i = k;
            }
          }
        }
        for (;;)
        {
          j += 1;
          break;
          k = paramState.width;
          break label694;
          label814:
          k = paramState.width;
          break label743;
          label823:
          measureChildWithDecorationsAndMargin(paramRecycler, k, m, false, true);
          break label775;
          k = View.MeasureSpec.makeMeasureSpec(m, 1073741824);
          i = 0;
          if (i < n)
          {
            paramRecycler = this.mSet[i];
            if (this.mOrientationHelper.getDecoratedMeasurement(paramRecycler) != m)
            {
              paramState = (GridLayoutManager.LayoutParams)paramRecycler.getLayoutParams();
              i1 = this.mCachedBorders[(GridLayoutManager.LayoutParams.access$000(paramState) + GridLayoutManager.LayoutParams.access$100(paramState))];
              i2 = this.mCachedBorders[GridLayoutManager.LayoutParams.access$000(paramState)];
              if (this.mOrientation != 0) {
                break label971;
              }
              j = paramState.height;
              label926:
              j = getChildMeasureSpec(i1 - i2, 1073741824, 0, j, false);
              if (this.mOrientation != 1) {
                break label980;
              }
              measureChildWithDecorationsAndMargin(paramRecycler, j, k, true, true);
            }
            for (;;)
            {
              i += 1;
              break;
              label971:
              j = paramState.width;
              break label926;
              label980:
              measureChildWithDecorationsAndMargin(paramRecycler, k, j, true, true);
            }
          }
          paramLayoutChunkResult.mConsumed = m;
          j = 0;
          k = 0;
          if (this.mOrientation == 1) {
            if (paramLayoutState.mLayoutDirection == -1)
            {
              k = paramLayoutState.mOffset;
              m = k - m;
              i = 0;
              j = 0;
              i3 = 0;
              i1 = i;
              i2 = k;
              k = i3;
              i = j;
              j = i1;
              i1 = i2;
              label1069:
              if (k >= n) {
                break label1412;
              }
              paramRecycler = this.mSet[k];
              paramState = (GridLayoutManager.LayoutParams)paramRecycler.getLayoutParams();
              if (this.mOrientation != 1) {
                break label1364;
              }
              if (!isLayoutRTL()) {
                break label1328;
              }
              j = getPaddingLeft() + this.mCachedBorders[(GridLayoutManager.LayoutParams.access$000(paramState) + GridLayoutManager.LayoutParams.access$100(paramState))];
              i2 = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
              i = j;
              j -= i2;
            }
          }
          for (;;)
          {
            layoutDecorated(paramRecycler, j + paramState.leftMargin, m + paramState.topMargin, i - paramState.rightMargin, i1 - paramState.bottomMargin);
            if ((paramState.isItemRemoved()) || (paramState.isItemChanged())) {
              paramLayoutChunkResult.mIgnoreConsumed = true;
            }
            paramLayoutChunkResult.mFocusable |= paramRecycler.isFocusable();
            i2 = k + 1;
            k = j;
            j = i;
            i = k;
            k = i2;
            break label1069;
            i = paramLayoutState.mOffset;
            k = i + m;
            i1 = 0;
            j = 0;
            m = i;
            i = i1;
            break;
            if (paramLayoutState.mLayoutDirection == -1)
            {
              i = paramLayoutState.mOffset;
              i1 = i - m;
              m = j;
              j = i1;
              break;
            }
            i1 = paramLayoutState.mOffset;
            i = m + i1;
            m = j;
            j = i1;
            break;
            label1328:
            i = getPaddingLeft();
            j = this.mCachedBorders[GridLayoutManager.LayoutParams.access$000(paramState)] + i;
            i = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) + j;
            continue;
            label1364:
            m = getPaddingTop();
            m = this.mCachedBorders[GridLayoutManager.LayoutParams.access$000(paramState)] + m;
            i1 = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) + m;
            i2 = i;
            i = j;
            j = i2;
          }
          Arrays.fill(this.mSet, null);
          return;
        }
      }
    }
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
    if (localView == null)
    {
      paramRecycler = null;
      return paramRecycler;
    }
    GridLayoutManager.LayoutParams localLayoutParams = (GridLayoutManager.LayoutParams)localView.getLayoutParams();
    int i4 = GridLayoutManager.LayoutParams.access$000(localLayoutParams);
    int i5 = GridLayoutManager.LayoutParams.access$000(localLayoutParams) + GridLayoutManager.LayoutParams.access$100(localLayoutParams);
    if (super.onFocusSearchFailed(paramView, paramInt, paramRecycler, paramState) == null) {
      return null;
    }
    int i8;
    label83:
    int m;
    int k;
    if (convertFocusDirectionToLayoutDirection(paramInt) == 1)
    {
      i8 = 1;
      if (i8 == this.mShouldReverseLayout) {
        break label162;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label167;
      }
      paramInt = getChildCount() - 1;
      m = -1;
      k = -1;
      label100:
      if ((this.mOrientation != 1) || (!isLayoutRTL())) {
        break label181;
      }
    }
    int j;
    int i;
    int i1;
    label132:
    label162:
    label167:
    label181:
    for (int n = 1;; n = 0)
    {
      paramView = null;
      j = -1;
      i = 0;
      i1 = paramInt;
      paramInt = j;
      if (i1 != k)
      {
        paramState = getChildAt(i1);
        if (paramState != localView) {
          break label187;
        }
      }
      return paramView;
      i8 = 0;
      break;
      paramInt = 0;
      break label83;
      k = getChildCount();
      paramInt = 0;
      m = 1;
      break label100;
    }
    label187:
    if (!paramState.isFocusable())
    {
      j = i;
      i = paramInt;
      paramInt = j;
    }
    for (;;)
    {
      i1 += m;
      j = i;
      i = paramInt;
      paramInt = j;
      break label132;
      localLayoutParams = (GridLayoutManager.LayoutParams)paramState.getLayoutParams();
      int i6 = GridLayoutManager.LayoutParams.access$000(localLayoutParams);
      int i7 = GridLayoutManager.LayoutParams.access$000(localLayoutParams) + GridLayoutManager.LayoutParams.access$100(localLayoutParams);
      if (i6 == i4)
      {
        paramRecycler = paramState;
        if (i7 == i5) {
          break;
        }
      }
      int i3 = 0;
      if (paramView == null) {
        j = 1;
      }
      for (;;)
      {
        if (j != 0)
        {
          i = GridLayoutManager.LayoutParams.access$000(localLayoutParams);
          paramInt = Math.min(i7, i5) - Math.max(i6, i4);
          paramView = paramState;
          break;
          j = Math.max(i6, i4);
          int i2 = Math.min(i7, i5) - j;
          if (i2 > i)
          {
            j = 1;
          }
          else
          {
            j = i3;
            if (i2 == i)
            {
              if (i6 > paramInt) {}
              for (i2 = 1;; i2 = 0)
              {
                j = i3;
                if (n != i2) {
                  break;
                }
                j = 1;
                break;
              }
            }
          }
        }
      }
      j = paramInt;
      paramInt = i;
      i = j;
    }
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
    int i = getPaddingLeft();
    int j = getPaddingRight() + i;
    int k = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1)
    {
      i = chooseSize(paramInt2, k + paramRect.height(), getMinimumHeight());
      paramInt2 = chooseSize(paramInt1, j + this.mCachedBorders[(this.mCachedBorders.length - 1)], getMinimumWidth());
      paramInt1 = i;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      i = chooseSize(paramInt1, j + paramRect.width(), getMinimumWidth());
      paramInt1 = chooseSize(paramInt2, k + this.mCachedBorders[(this.mCachedBorders.length - 1)], getMinimumHeight());
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
  
  public void setSpanSizeLookup(GridLayoutManager.SpanSizeLookup paramSpanSizeLookup)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.GridLayoutManager
 * JD-Core Version:    0.7.0.1
 */