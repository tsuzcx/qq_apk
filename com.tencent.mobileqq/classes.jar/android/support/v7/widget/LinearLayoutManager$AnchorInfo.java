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
    if (this.mLayoutFromEnd) {}
    for (int i = this.this$0.mOrientationHelper.getEndAfterPadding();; i = this.this$0.mOrientationHelper.getStartAfterPadding())
    {
      this.mCoordinate = i;
      return;
    }
  }
  
  public void assignFromView(View paramView)
  {
    if (this.mLayoutFromEnd) {}
    for (this.mCoordinate = (this.this$0.mOrientationHelper.getDecoratedEnd(paramView) + this.this$0.mOrientationHelper.getTotalSpaceChange());; this.mCoordinate = this.this$0.mOrientationHelper.getDecoratedStart(paramView))
    {
      this.mPosition = this.this$0.getPosition(paramView);
      return;
    }
  }
  
  public void assignFromViewAndKeepVisibleRect(View paramView)
  {
    int j = this.this$0.mOrientationHelper.getTotalSpaceChange();
    if (j >= 0) {
      assignFromView(paramView);
    }
    int i;
    do
    {
      int k;
      do
      {
        do
        {
          do
          {
            return;
            this.mPosition = this.this$0.getPosition(paramView);
            if (!this.mLayoutFromEnd) {
              break;
            }
            i = this.this$0.mOrientationHelper.getEndAfterPadding() - j - this.this$0.mOrientationHelper.getDecoratedEnd(paramView);
            this.mCoordinate = (this.this$0.mOrientationHelper.getEndAfterPadding() - i);
          } while (i <= 0);
          j = this.this$0.mOrientationHelper.getDecoratedMeasurement(paramView);
          k = this.mCoordinate;
          m = this.this$0.mOrientationHelper.getStartAfterPadding();
          j = k - j - (m + Math.min(this.this$0.mOrientationHelper.getDecoratedStart(paramView) - m, 0));
        } while (j >= 0);
        k = this.mCoordinate;
        this.mCoordinate = (Math.min(i, -j) + k);
        return;
        k = this.this$0.mOrientationHelper.getDecoratedStart(paramView);
        i = k - this.this$0.mOrientationHelper.getStartAfterPadding();
        this.mCoordinate = k;
      } while (i <= 0);
      int m = this.this$0.mOrientationHelper.getDecoratedMeasurement(paramView);
      int n = this.this$0.mOrientationHelper.getEndAfterPadding();
      int i1 = this.this$0.mOrientationHelper.getDecoratedEnd(paramView);
      j = this.this$0.mOrientationHelper.getEndAfterPadding() - Math.min(0, n - j - i1) - (k + m);
    } while (j >= 0);
    this.mCoordinate -= Math.min(i, -j);
  }
  
  void reset()
  {
    this.mPosition = -1;
    this.mCoordinate = -2147483648;
    this.mLayoutFromEnd = false;
  }
  
  public String toString()
  {
    return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager.AnchorInfo
 * JD-Core Version:    0.7.0.1
 */