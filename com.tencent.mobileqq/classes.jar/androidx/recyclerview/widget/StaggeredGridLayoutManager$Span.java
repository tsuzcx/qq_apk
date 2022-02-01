package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;

class StaggeredGridLayoutManager$Span
{
  static final int INVALID_LINE = -2147483648;
  int mCachedEnd = -2147483648;
  int mCachedStart = -2147483648;
  int mDeletedSize = 0;
  final int mIndex;
  ArrayList<View> mViews = new ArrayList();
  
  StaggeredGridLayoutManager$Span(StaggeredGridLayoutManager paramStaggeredGridLayoutManager, int paramInt)
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
    if (this.this$0.mReverseLayout) {
      return findOneVisibleChild(this.mViews.size() - 1, -1, true);
    }
    return findOneVisibleChild(0, this.mViews.size(), true);
  }
  
  public int findFirstPartiallyVisibleItemPosition()
  {
    if (this.this$0.mReverseLayout) {
      return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
    }
    return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
  }
  
  public int findFirstVisibleItemPosition()
  {
    if (this.this$0.mReverseLayout) {
      return findOneVisibleChild(this.mViews.size() - 1, -1, false);
    }
    return findOneVisibleChild(0, this.mViews.size(), false);
  }
  
  public int findLastCompletelyVisibleItemPosition()
  {
    if (this.this$0.mReverseLayout) {
      return findOneVisibleChild(0, this.mViews.size(), true);
    }
    return findOneVisibleChild(this.mViews.size() - 1, -1, true);
  }
  
  public int findLastPartiallyVisibleItemPosition()
  {
    if (this.this$0.mReverseLayout) {
      return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
    }
    return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
  }
  
  public int findLastVisibleItemPosition()
  {
    if (this.this$0.mReverseLayout) {
      return findOneVisibleChild(0, this.mViews.size(), false);
    }
    return findOneVisibleChild(this.mViews.size() - 1, -1, false);
  }
  
  int findOnePartiallyOrCompletelyVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int m = this.this$0.mPrimaryOrientation.getStartAfterPadding();
    int n = this.this$0.mPrimaryOrientation.getEndAfterPadding();
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    } else {
      i = -1;
    }
    while (paramInt1 != paramInt2)
    {
      View localView = (View)this.mViews.get(paramInt1);
      int i1 = this.this$0.mPrimaryOrientation.getDecoratedStart(localView);
      int i2 = this.this$0.mPrimaryOrientation.getDecoratedEnd(localView);
      int k = 0;
      int j;
      if (paramBoolean3 ? i1 <= n : i1 < n) {
        j = 1;
      } else {
        j = 0;
      }
      if (paramBoolean3 ? i2 >= m : i2 > m) {
        k = 1;
      }
      if ((j != 0) && (k != 0)) {
        if ((paramBoolean1) && (paramBoolean2))
        {
          if ((i1 >= m) && (i2 <= n)) {
            return this.this$0.getPosition(localView);
          }
        }
        else
        {
          if (paramBoolean2) {
            return this.this$0.getPosition(localView);
          }
          if ((i1 < m) || (i2 > n)) {
            return this.this$0.getPosition(localView);
          }
        }
      }
      paramInt1 += i;
    }
    return -1;
  }
  
  int findOnePartiallyVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return findOnePartiallyOrCompletelyVisibleChild(paramInt1, paramInt2, false, false, paramBoolean);
  }
  
  int findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return findOnePartiallyOrCompletelyVisibleChild(paramInt1, paramInt2, paramBoolean, true, false);
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
    View localView;
    if (paramInt2 == -1)
    {
      int i = this.mViews.size();
      paramInt2 = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (paramInt2 >= i) {
          break;
        }
        localView = (View)this.mViews.get(paramInt2);
        if (this.this$0.mReverseLayout)
        {
          localObject2 = localObject1;
          if (this.this$0.getPosition(localView) <= paramInt1) {
            break;
          }
        }
        if ((!this.this$0.mReverseLayout) && (this.this$0.getPosition(localView) >= paramInt1)) {
          return localObject1;
        }
        localObject2 = localObject1;
        if (!localView.hasFocusable()) {
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
      if (this.this$0.mReverseLayout)
      {
        localObject2 = localObject1;
        if (this.this$0.getPosition(localView) >= paramInt1) {
          break;
        }
      }
      if ((!this.this$0.mReverseLayout) && (this.this$0.getPosition(localView) <= paramInt1)) {
        return localObject1;
      }
      localObject2 = localObject1;
      if (!localView.hasFocusable()) {
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
 * Qualified Name:     androidx.recyclerview.widget.StaggeredGridLayoutManager.Span
 * JD-Core Version:    0.7.0.1
 */