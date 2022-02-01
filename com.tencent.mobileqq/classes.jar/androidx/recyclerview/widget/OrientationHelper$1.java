package androidx.recyclerview.widget;

import android.graphics.Rect;
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
    return this.mLayoutManager.getDecoratedRight(paramView) + localLayoutParams.rightMargin;
  }
  
  public int getDecoratedMeasurement(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return this.mLayoutManager.getDecoratedMeasuredWidth(paramView) + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
  }
  
  public int getDecoratedMeasurementInOther(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return this.mLayoutManager.getDecoratedMeasuredHeight(paramView) + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
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
  
  public int getTransformedEndWithDecoration(View paramView)
  {
    this.mLayoutManager.getTransformedBoundingBox(paramView, true, this.mTmpRect);
    return this.mTmpRect.right;
  }
  
  public int getTransformedStartWithDecoration(View paramView)
  {
    this.mLayoutManager.getTransformedBoundingBox(paramView, true, this.mTmpRect);
    return this.mTmpRect.left;
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
 * Qualified Name:     androidx.recyclerview.widget.OrientationHelper.1
 * JD-Core Version:    0.7.0.1
 */