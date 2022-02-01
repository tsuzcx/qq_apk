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
    if (paramBoolean)
    {
      i = getEndLine(-2147483648);
      clear();
      if (i != -2147483648) {
        break label32;
      }
    }
    label32:
    while (((paramBoolean) && (i < this.this$0.mPrimaryOrientation.getEndAfterPadding())) || ((!paramBoolean) && (i > this.this$0.mPrimaryOrientation.getStartAfterPadding())))
    {
      return;
      i = getStartLine(-2147483648);
      break;
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
    Object localObject = (View)this.mViews.get(this.mViews.size() - 1);
    StaggeredGridLayoutManager.LayoutParams localLayoutParams = getLayoutParams((View)localObject);
    this.mCachedEnd = this.this$0.mPrimaryOrientation.getDecoratedEnd((View)localObject);
    if (localLayoutParams.mFullSpan)
    {
      localObject = this.this$0.mLazySpanLookup.getFullSpanItem(localLayoutParams.getViewLayoutPosition());
      if ((localObject != null) && (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).mGapDir == 1))
      {
        int i = this.mCachedEnd;
        this.mCachedEnd = (((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject).getGapForSpan(this.mIndex) + i);
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
    int j;
    int k;
    if (paramInt2 > paramInt1)
    {
      j = 1;
      k = paramInt1;
    }
    while (k != paramInt2)
    {
      View localView = (View)this.mViews.get(k);
      int i1 = this.this$0.mPrimaryOrientation.getDecoratedStart(localView);
      int i2 = this.this$0.mPrimaryOrientation.getDecoratedEnd(localView);
      label97:
      int i;
      if (paramBoolean3) {
        if (i1 <= n)
        {
          paramInt1 = 1;
          if (!paramBoolean3) {
            break label191;
          }
          if (i2 < m) {
            break label185;
          }
          i = 1;
        }
      }
      for (;;)
      {
        if ((paramInt1 != 0) && (i != 0))
        {
          if ((paramBoolean1) && (paramBoolean2))
          {
            if ((i1 < m) || (i2 > n)) {
              break label249;
            }
            return this.this$0.getPosition(localView);
            j = -1;
            k = paramInt1;
            break;
            paramInt1 = 0;
            break label97;
            if (i1 < n)
            {
              paramInt1 = 1;
              break label97;
            }
            paramInt1 = 0;
            break label97;
            label185:
            i = 0;
            continue;
            label191:
            if (i2 > m)
            {
              i = 1;
              continue;
            }
            i = 0;
            continue;
          }
          if (paramBoolean2) {
            return this.this$0.getPosition(localView);
          }
          if ((i1 < m) || (i2 > n)) {
            return this.this$0.getPosition(localView);
          }
        }
      }
      label249:
      k += j;
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
    if (this.mCachedEnd != -2147483648) {
      return this.mCachedEnd;
    }
    calculateCachedEnd();
    return this.mCachedEnd;
  }
  
  int getEndLine(int paramInt)
  {
    if (this.mCachedEnd != -2147483648) {
      paramInt = this.mCachedEnd;
    }
    while (this.mViews.size() == 0) {
      return paramInt;
    }
    calculateCachedEnd();
    return this.mCachedEnd;
  }
  
  public View getFocusableViewAfter(int paramInt1, int paramInt2)
  {
    View localView2 = null;
    View localView1 = null;
    if (paramInt2 == -1)
    {
      int i = this.mViews.size();
      paramInt2 = 0;
      for (;;)
      {
        if (paramInt2 < i)
        {
          localView2 = (View)this.mViews.get(paramInt2);
          if (((!this.this$0.mReverseLayout) || (this.this$0.getPosition(localView2) > paramInt1)) && ((this.this$0.mReverseLayout) || (this.this$0.getPosition(localView2) < paramInt1))) {
            break label88;
          }
        }
        label88:
        while (!localView2.hasFocusable()) {
          return localView1;
        }
        paramInt2 += 1;
        localView1 = localView2;
      }
    }
    paramInt2 = this.mViews.size() - 1;
    for (localView1 = localView2; paramInt2 >= 0; localView1 = localView2)
    {
      localView2 = (View)this.mViews.get(paramInt2);
      if ((this.this$0.mReverseLayout) && (this.this$0.getPosition(localView2) >= paramInt1)) {
        break;
      }
      if ((!this.this$0.mReverseLayout) && (this.this$0.getPosition(localView2) <= paramInt1)) {
        return localView1;
      }
      if (!localView2.hasFocusable()) {
        break;
      }
      paramInt2 -= 1;
    }
    return localView1;
  }
  
  StaggeredGridLayoutManager.LayoutParams getLayoutParams(View paramView)
  {
    return (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
  }
  
  int getStartLine()
  {
    if (this.mCachedStart != -2147483648) {
      return this.mCachedStart;
    }
    calculateCachedStart();
    return this.mCachedStart;
  }
  
  int getStartLine(int paramInt)
  {
    if (this.mCachedStart != -2147483648) {
      paramInt = this.mCachedStart;
    }
    while (this.mViews.size() == 0) {
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
    if (this.mCachedStart != -2147483648) {
      this.mCachedStart += paramInt;
    }
    if (this.mCachedEnd != -2147483648) {
      this.mCachedEnd += paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.StaggeredGridLayoutManager.Span
 * JD-Core Version:    0.7.0.1
 */