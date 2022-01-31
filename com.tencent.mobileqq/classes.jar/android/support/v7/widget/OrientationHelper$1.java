package android.support.v7.widget;

import android.view.View;

final class OrientationHelper$1
  extends OrientationHelper
{
  OrientationHelper$1(RecyclerView.LayoutManager paramLayoutManager)
  {
    super(paramLayoutManager, null);
  }
  
  public int getDecoratedEnd(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = this.mLayoutManager.getDecoratedRight(paramView);
    return localLayoutParams.rightMargin + i;
  }
  
  public int getDecoratedMeasurement(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = this.mLayoutManager.getDecoratedMeasuredWidth(paramView);
    int j = localLayoutParams.leftMargin;
    return localLayoutParams.rightMargin + (i + j);
  }
  
  public int getDecoratedMeasurementInOther(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = this.mLayoutManager.getDecoratedMeasuredHeight(paramView);
    int j = localLayoutParams.topMargin;
    return localLayoutParams.bottomMargin + (i + j);
  }
  
  public int getDecoratedStart(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return this.mLayoutManager.getDecoratedLeft(paramView) - localLayoutParams.leftMargin;
  }
  
  public int getEnd()
  {
    return this.mLayoutManager.getWidth();
  }
  
  public int getEndAfterPadding()
  {
    return this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingRight();
  }
  
  public int getEndPadding()
  {
    return this.mLayoutManager.getPaddingRight();
  }
  
  public int getMode()
  {
    return this.mLayoutManager.getWidthMode();
  }
  
  public int getModeInOther()
  {
    return this.mLayoutManager.getHeightMode();
  }
  
  public int getStartAfterPadding()
  {
    return this.mLayoutManager.getPaddingLeft();
  }
  
  public int getTotalSpace()
  {
    return this.mLayoutManager.getWidth() - this.mLayoutManager.getPaddingLeft() - this.mLayoutManager.getPaddingRight();
  }
  
  public void offsetChild(View paramView, int paramInt)
  {
    paramView.offsetLeftAndRight(paramInt);
  }
  
  public void offsetChildren(int paramInt)
  {
    this.mLayoutManager.offsetChildrenHorizontal(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.OrientationHelper.1
 * JD-Core Version:    0.7.0.1
 */