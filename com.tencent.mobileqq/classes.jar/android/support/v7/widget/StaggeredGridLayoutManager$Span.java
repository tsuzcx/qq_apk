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
    int k = -1;
    int m = this.this$0.mPrimaryOrientation.getStartAfterPadding();
    int n = this.this$0.mPrimaryOrientation.getEndAfterPadding();
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    }
    for (;;)
    {
      int j = k;
      View localView;
      if (paramInt1 != paramInt2)
      {
        localView = (View)this.mViews.get(paramInt1);
        j = this.this$0.mPrimaryOrientation.getDecoratedStart(localView);
        int i1 = this.this$0.mPrimaryOrientation.getDecoratedEnd(localView);
        if ((j >= n) || (i1 <= m)) {
          break label147;
        }
        if (paramBoolean)
        {
          if ((j < m) || (i1 > n)) {
            break label147;
          }
          j = this.this$0.getPosition(localView);
        }
      }
      else
      {
        return j;
        i = -1;
        continue;
      }
      return this.this$0.getPosition(localView);
      label147:
      paramInt1 += i;
    }
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
    int i;
    if (paramInt2 == -1)
    {
      i = this.mViews.size();
      paramInt2 = 0;
      if (paramInt2 < i)
      {
        localView2 = (View)this.mViews.get(paramInt2);
        if (localView2.isFocusable())
        {
          if (this.this$0.getPosition(localView2) > paramInt1) {}
          for (int k = 1;; k = 0)
          {
            if (k != StaggeredGridLayoutManager.access$600(this.this$0)) {
              break label92;
            }
            paramInt2 += 1;
            localView1 = localView2;
            break;
          }
        }
      }
      label92:
      return localView1;
    }
    paramInt2 = this.mViews.size() - 1;
    localView1 = localView2;
    if (paramInt2 >= 0)
    {
      localView2 = (View)this.mViews.get(paramInt2);
      if (localView2.isFocusable())
      {
        if (this.this$0.getPosition(localView2) > paramInt1)
        {
          i = 1;
          label149:
          if (StaggeredGridLayoutManager.access$600(this.this$0)) {
            break label184;
          }
        }
        label184:
        for (int j = 1;; j = 0)
        {
          if (i != j) {
            break label190;
          }
          paramInt2 -= 1;
          localView1 = localView2;
          break;
          i = 0;
          break label149;
        }
      }
    }
    label190:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.Span
 * JD-Core Version:    0.7.0.1
 */