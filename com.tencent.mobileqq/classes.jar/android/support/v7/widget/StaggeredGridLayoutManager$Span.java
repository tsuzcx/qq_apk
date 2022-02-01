package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

class StaggeredGridLayoutManager$Span
{
  static final int INVALID_LINE = -2147483648;
  int mCachedEnd = -2147483648;
  int mCachedStart = -2147483648;
  int mDeletedSize = 0;
  final int mIndex;
  private ArrayList<View> mViews = new ArrayList();
  
  private StaggeredGridLayoutManager$Span(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, int paramInt)
  {
    this.mIndex = paramInt;
  }
  
  void appendToSpan(View paramView)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(paramView);
    localLayoutParams.mSpan = this;
    this.mViews.add(paramView);
    this.mCachedEnd = -2147483648;
    if (this.mViews.size() == 1) {
      this.mCachedStart = -2147483648;
    }
    if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
      this.mDeletedSize += this.this$0.mPrimaryOrientation.getDecoratedMeasurement(paramView);
    }
  }
  
  void cacheReferenceLineAndClear(boolean paramBoolean, int paramInt)
  {
    int i;
    if (paramBoolean) {
      i = getEndLine(-2147483648);
    } else {
      i = getStartLine(-2147483648);
    }
    clear();
    if (i == -2147483648) {
      return;
    }
    if (((paramBoolean) && (i < this.this$0.mPrimaryOrientation.getEndAfterPadding())) || ((!paramBoolean) && (i > this.this$0.mPrimaryOrientation.getStartAfterPadding()))) {
      return;
    }
    int j = i;
    if (paramInt != -2147483648) {
      j = i + paramInt;
    }
    this.mCachedEnd = j;
    this.mCachedStart = j;
  }
  
  void calculateCachedEnd()
  {
    Object localObject = this.mViews;
    localObject = (View)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams((View)localObject);
    this.mCachedEnd = this.this$0.mPrimaryOrientation.getDecoratedEnd((View)localObject);
    if (localLayoutParams.mFullSpan)
    {
      localObject = this.this$0.mLazySpanLookup.getFullSpanItem(localLayoutParams.getViewLayoutPosition());
      if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).mGapDir == 1)) {
        this.mCachedEnd += ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).getGapForSpan(this.mIndex);
      }
    }
  }
  
  void calculateCachedStart()
  {
    Object localObject = (View)this.mViews.get(0);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams((View)localObject);
    this.mCachedStart = this.this$0.mPrimaryOrientation.getDecoratedStart((View)localObject);
    if (localLayoutParams.mFullSpan)
    {
      localObject = this.this$0.mLazySpanLookup.getFullSpanItem(localLayoutParams.getViewLayoutPosition());
      if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).mGapDir == -1)) {
        this.mCachedStart -= ((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).getGapForSpan(this.mIndex);
      }
    }
  }
  
  void clear()
  {
    this.mViews.clear();
    invalidateCache();
    this.mDeletedSize = 0;
  }
  
  public int findFirstCompletelyVisibleItemPosition()
  {
    if (StaggeredGridLayoutManager.access$600(this.this$0)) {
      return findOneVisibleChild(this.mViews.size() - 1, -1, true);
    }
    return findOneVisibleChild(0, this.mViews.size(), true);
  }
  
  public int findFirstVisibleItemPosition()
  {
    if (StaggeredGridLayoutManager.access$600(this.this$0)) {
      return findOneVisibleChild(this.mViews.size() - 1, -1, false);
    }
    return findOneVisibleChild(0, this.mViews.size(), false);
  }
  
  public int findLastCompletelyVisibleItemPosition()
  {
    if (StaggeredGridLayoutManager.access$600(this.this$0)) {
      return findOneVisibleChild(0, this.mViews.size(), true);
    }
    return findOneVisibleChild(this.mViews.size() - 1, -1, true);
  }
  
  public int findLastVisibleItemPosition()
  {
    if (StaggeredGridLayoutManager.access$600(this.this$0)) {
      return findOneVisibleChild(0, this.mViews.size(), false);
    }
    return findOneVisibleChild(this.mViews.size() - 1, -1, false);
  }
  
  int findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = this.this$0.mPrimaryOrientation.getStartAfterPadding();
    int k = this.this$0.mPrimaryOrientation.getEndAfterPadding();
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    } else {
      i = -1;
    }
    while (paramInt1 != paramInt2)
    {
      View localView = (View)this.mViews.get(paramInt1);
      int m = this.this$0.mPrimaryOrientation.getDecoratedStart(localView);
      int n = this.this$0.mPrimaryOrientation.getDecoratedEnd(localView);
      if ((m < k) && (n > j)) {
        if (paramBoolean)
        {
          if ((m >= j) && (n <= k)) {
            return this.this$0.getPosition(localView);
          }
        }
        else {
          return this.this$0.getPosition(localView);
        }
      }
      paramInt1 += i;
    }
    return -1;
  }
  
  public int getDeletedSize()
  {
    return this.mDeletedSize;
  }
  
  int getEndLine()
  {
    int i = this.mCachedEnd;
    if (i != -2147483648) {
      return i;
    }
    calculateCachedEnd();
    return this.mCachedEnd;
  }
  
  int getEndLine(int paramInt)
  {
    int i = this.mCachedEnd;
    if (i != -2147483648) {
      return i;
    }
    if (this.mViews.size() == 0) {
      return paramInt;
    }
    calculateCachedEnd();
    return this.mCachedEnd;
  }
  
  public View getFocusableViewAfter(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    View localView;
    if (paramInt2 == -1)
    {
      i = this.mViews.size();
      paramInt2 = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (paramInt2 >= i) {
          break;
        }
        localView = (View)this.mViews.get(paramInt2);
        localObject2 = localObject1;
        if (!localView.isFocusable()) {
          break;
        }
        int j;
        if (this.this$0.getPosition(localView) > paramInt1) {
          j = 1;
        } else {
          j = 0;
        }
        localObject2 = localObject1;
        if (j != StaggeredGridLayoutManager.access$600(this.this$0)) {
          break;
        }
        paramInt2 += 1;
        localObject1 = localView;
      }
    }
    paramInt2 = this.mViews.size() - 1;
    for (localObject1 = localObject2;; localObject1 = localView)
    {
      localObject2 = localObject1;
      if (paramInt2 < 0) {
        break;
      }
      localView = (View)this.mViews.get(paramInt2);
      localObject2 = localObject1;
      if (!localView.isFocusable()) {
        break;
      }
      if (this.this$0.getPosition(localView) > paramInt1) {
        i = 1;
      } else {
        i = 0;
      }
      localObject2 = localObject1;
      if (i != (StaggeredGridLayoutManager.access$600(this.this$0) ^ true)) {
        break;
      }
      paramInt2 -= 1;
    }
    return localObject2;
  }
  
  StaggeredGridLayoutManager.LayoutParams getLayoutParams(View paramView)
  {
    return (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
  }
  
  int getStartLine()
  {
    int i = this.mCachedStart;
    if (i != -2147483648) {
      return i;
    }
    calculateCachedStart();
    return this.mCachedStart;
  }
  
  int getStartLine(int paramInt)
  {
    int i = this.mCachedStart;
    if (i != -2147483648) {
      return i;
    }
    if (this.mViews.size() == 0) {
      return paramInt;
    }
    calculateCachedStart();
    return this.mCachedStart;
  }
  
  void invalidateCache()
  {
    this.mCachedStart = -2147483648;
    this.mCachedEnd = -2147483648;
  }
  
  void onOffset(int paramInt)
  {
    int i = this.mCachedStart;
    if (i != -2147483648) {
      this.mCachedStart = (i + paramInt);
    }
    i = this.mCachedEnd;
    if (i != -2147483648) {
      this.mCachedEnd = (i + paramInt);
    }
  }
  
  void popEnd()
  {
    int i = this.mViews.size();
    View localView = (View)this.mViews.remove(i - 1);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(localView);
    localLayoutParams.mSpan = null;
    if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
      this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(localView);
    }
    if (i == 1) {
      this.mCachedStart = -2147483648;
    }
    this.mCachedEnd = -2147483648;
  }
  
  void popStart()
  {
    View localView = (View)this.mViews.remove(0);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(localView);
    localLayoutParams.mSpan = null;
    if (this.mViews.size() == 0) {
      this.mCachedEnd = -2147483648;
    }
    if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
      this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(localView);
    }
    this.mCachedStart = -2147483648;
  }
  
  void prependToSpan(View paramView)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams(paramView);
    localLayoutParams.mSpan = this;
    this.mViews.add(0, paramView);
    this.mCachedStart = -2147483648;
    if (this.mViews.size() == 1) {
      this.mCachedEnd = -2147483648;
    }
    if ((localLayoutParams.isItemRemoved()) || (localLayoutParams.isItemChanged())) {
      this.mDeletedSize += this.this$0.mPrimaryOrientation.getDecoratedMeasurement(paramView);
    }
  }
  
  void setLine(int paramInt)
  {
    this.mCachedStart = paramInt;
    this.mCachedEnd = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.Span
 * JD-Core Version:    0.7.0.1
 */