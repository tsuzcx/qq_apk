package androidx.recyclerview.widget;

import android.view.View;

class LinearLayoutManager$AnchorInfo
{
  int mCoordinate;
  boolean mLayoutFromEnd;
  OrientationHelper mOrientationHelper;
  int mPosition;
  boolean mValid;
  
  LinearLayoutManager$AnchorInfo()
  {
    reset();
  }
  
  void assignCoordinateFromPadding()
  {
    if (this.mLayoutFromEnd) {}
    for (int i = this.mOrientationHelper.getEndAfterPadding();; i = this.mOrientationHelper.getStartAfterPadding())
    {
      this.mCoordinate = i;
      return;
    }
  }
  
  public void assignFromView(View paramView, int paramInt)
  {
    if (this.mLayoutFromEnd) {}
    for (this.mCoordinate = (this.mOrientationHelper.getDecoratedEnd(paramView) + this.mOrientationHelper.getTotalSpaceChange());; this.mCoordinate = this.mOrientationHelper.getDecoratedStart(paramView))
    {
      this.mPosition = paramInt;
      return;
    }
  }
  
  public void assignFromViewAndKeepVisibleRect(View paramView, int paramInt)
  {
    int i = this.mOrientationHelper.getTotalSpaceChange();
    if (i >= 0) {
      assignFromView(paramView, paramInt);
    }
    do
    {
      int j;
      do
      {
        do
        {
          do
          {
            return;
            this.mPosition = paramInt;
            if (!this.mLayoutFromEnd) {
              break;
            }
            paramInt = this.mOrientationHelper.getEndAfterPadding() - i - this.mOrientationHelper.getDecoratedEnd(paramView);
            this.mCoordinate = (this.mOrientationHelper.getEndAfterPadding() - paramInt);
          } while (paramInt <= 0);
          i = this.mOrientationHelper.getDecoratedMeasurement(paramView);
          j = this.mCoordinate;
          k = this.mOrientationHelper.getStartAfterPadding();
          i = j - i - (k + Math.min(this.mOrientationHelper.getDecoratedStart(paramView) - k, 0));
        } while (i >= 0);
        j = this.mCoordinate;
        this.mCoordinate = (Math.min(paramInt, -i) + j);
        return;
        j = this.mOrientationHelper.getDecoratedStart(paramView);
        paramInt = j - this.mOrientationHelper.getStartAfterPadding();
        this.mCoordinate = j;
      } while (paramInt <= 0);
      int k = this.mOrientationHelper.getDecoratedMeasurement(paramView);
      int m = this.mOrientationHelper.getEndAfterPadding();
      int n = this.mOrientationHelper.getDecoratedEnd(paramView);
      i = this.mOrientationHelper.getEndAfterPadding() - Math.min(0, m - i - n) - (j + k);
    } while (i >= 0);
    this.mCoordinate -= Math.min(paramInt, -i);
  }
  
  boolean isViewValidAsAnchor(View paramView, RecyclerView.State paramState)
  {
    paramView = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return (!paramView.isItemRemoved()) && (paramView.getViewLayoutPosition() >= 0) && (paramView.getViewLayoutPosition() < paramState.getItemCount());
  }
  
  void reset()
  {
    this.mPosition = -1;
    this.mCoordinate = -2147483648;
    this.mLayoutFromEnd = false;
    this.mValid = false;
  }
  
  public String toString()
  {
    return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.LinearLayoutManager.AnchorInfo
 * JD-Core Version:    0.7.0.1
 */