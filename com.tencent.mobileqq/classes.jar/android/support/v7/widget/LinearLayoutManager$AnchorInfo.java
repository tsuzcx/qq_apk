package android.support.v7.widget;

import android.view.View;

class LinearLayoutManager$AnchorInfo
{
  int mCoordinate;
  boolean mLayoutFromEnd;
  int mPosition;
  
  LinearLayoutManager$AnchorInfo(LinearLayoutManager paramLinearLayoutManager) {}
  
  private boolean isViewValidAsAnchor(View paramView, RecyclerView.State paramState)
  {
    paramView = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return (!paramView.isItemRemoved()) && (paramView.getViewLayoutPosition() >= 0) && (paramView.getViewLayoutPosition() < paramState.getItemCount());
  }
  
  void assignCoordinateFromPadding()
  {
    int i;
    if (this.mLayoutFromEnd) {
      i = this.this$0.mOrientationHelper.getEndAfterPadding();
    } else {
      i = this.this$0.mOrientationHelper.getStartAfterPadding();
    }
    this.mCoordinate = i;
  }
  
  public void assignFromView(View paramView)
  {
    if (this.mLayoutFromEnd) {
      this.mCoordinate = (this.this$0.mOrientationHelper.getDecoratedEnd(paramView) + this.this$0.mOrientationHelper.getTotalSpaceChange());
    } else {
      this.mCoordinate = this.this$0.mOrientationHelper.getDecoratedStart(paramView);
    }
    this.mPosition = this.this$0.getPosition(paramView);
  }
  
  public void assignFromViewAndKeepVisibleRect(View paramView)
  {
    int j = this.this$0.mOrientationHelper.getTotalSpaceChange();
    if (j >= 0)
    {
      assignFromView(paramView);
      return;
    }
    this.mPosition = this.this$0.getPosition(paramView);
    int i;
    int k;
    int m;
    if (this.mLayoutFromEnd)
    {
      i = this.this$0.mOrientationHelper.getEndAfterPadding() - j - this.this$0.mOrientationHelper.getDecoratedEnd(paramView);
      this.mCoordinate = (this.this$0.mOrientationHelper.getEndAfterPadding() - i);
      if (i > 0)
      {
        j = this.this$0.mOrientationHelper.getDecoratedMeasurement(paramView);
        k = this.mCoordinate;
        m = this.this$0.mOrientationHelper.getStartAfterPadding();
        j = k - j - (m + Math.min(this.this$0.mOrientationHelper.getDecoratedStart(paramView) - m, 0));
        if (j < 0) {
          this.mCoordinate += Math.min(i, -j);
        }
      }
    }
    else
    {
      k = this.this$0.mOrientationHelper.getDecoratedStart(paramView);
      i = k - this.this$0.mOrientationHelper.getStartAfterPadding();
      this.mCoordinate = k;
      if (i > 0)
      {
        m = this.this$0.mOrientationHelper.getDecoratedMeasurement(paramView);
        int n = this.this$0.mOrientationHelper.getEndAfterPadding();
        int i1 = this.this$0.mOrientationHelper.getDecoratedEnd(paramView);
        j = this.this$0.mOrientationHelper.getEndAfterPadding() - Math.min(0, n - j - i1) - (k + m);
        if (j < 0) {
          this.mCoordinate -= Math.min(i, -j);
        }
      }
    }
  }
  
  void reset()
  {
    this.mPosition = -1;
    this.mCoordinate = -2147483648;
    this.mLayoutFromEnd = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AnchorInfo{mPosition=");
    localStringBuilder.append(this.mPosition);
    localStringBuilder.append(", mCoordinate=");
    localStringBuilder.append(this.mCoordinate);
    localStringBuilder.append(", mLayoutFromEnd=");
    localStringBuilder.append(this.mLayoutFromEnd);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager.AnchorInfo
 * JD-Core Version:    0.7.0.1
 */