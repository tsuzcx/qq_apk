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
    int i;
    if (this.mLayoutFromEnd) {
      i = this.mOrientationHelper.getEndAfterPadding();
    } else {
      i = this.mOrientationHelper.getStartAfterPadding();
    }
    this.mCoordinate = i;
  }
  
  public void assignFromView(View paramView, int paramInt)
  {
    if (this.mLayoutFromEnd) {
      this.mCoordinate = (this.mOrientationHelper.getDecoratedEnd(paramView) + this.mOrientationHelper.getTotalSpaceChange());
    } else {
      this.mCoordinate = this.mOrientationHelper.getDecoratedStart(paramView);
    }
    this.mPosition = paramInt;
  }
  
  public void assignFromViewAndKeepVisibleRect(View paramView, int paramInt)
  {
    int i = this.mOrientationHelper.getTotalSpaceChange();
    if (i >= 0)
    {
      assignFromView(paramView, paramInt);
      return;
    }
    this.mPosition = paramInt;
    int j;
    int k;
    if (this.mLayoutFromEnd)
    {
      paramInt = this.mOrientationHelper.getEndAfterPadding() - i - this.mOrientationHelper.getDecoratedEnd(paramView);
      this.mCoordinate = (this.mOrientationHelper.getEndAfterPadding() - paramInt);
      if (paramInt > 0)
      {
        i = this.mOrientationHelper.getDecoratedMeasurement(paramView);
        j = this.mCoordinate;
        k = this.mOrientationHelper.getStartAfterPadding();
        i = j - i - (k + Math.min(this.mOrientationHelper.getDecoratedStart(paramView) - k, 0));
        if (i < 0) {
          this.mCoordinate += Math.min(paramInt, -i);
        }
      }
    }
    else
    {
      j = this.mOrientationHelper.getDecoratedStart(paramView);
      paramInt = j - this.mOrientationHelper.getStartAfterPadding();
      this.mCoordinate = j;
      if (paramInt > 0)
      {
        k = this.mOrientationHelper.getDecoratedMeasurement(paramView);
        int m = this.mOrientationHelper.getEndAfterPadding();
        int n = this.mOrientationHelper.getDecoratedEnd(paramView);
        i = this.mOrientationHelper.getEndAfterPadding() - Math.min(0, m - i - n) - (j + k);
        if (i < 0) {
          this.mCoordinate -= Math.min(paramInt, -i);
        }
      }
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AnchorInfo{mPosition=");
    localStringBuilder.append(this.mPosition);
    localStringBuilder.append(", mCoordinate=");
    localStringBuilder.append(this.mCoordinate);
    localStringBuilder.append(", mLayoutFromEnd=");
    localStringBuilder.append(this.mLayoutFromEnd);
    localStringBuilder.append(", mValid=");
    localStringBuilder.append(this.mValid);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.LinearLayoutManager.AnchorInfo
 * JD-Core Version:    0.7.0.1
 */