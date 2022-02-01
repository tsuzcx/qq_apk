package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;

public abstract class OrientationHelper
{
  public static final int HORIZONTAL = 0;
  private static final int INVALID_SIZE = -2147483648;
  public static final int VERTICAL = 1;
  private int mLastTotalSpace = -2147483648;
  protected final RecyclerView.LayoutManager mLayoutManager;
  final Rect mTmpRect = new Rect();
  
  private OrientationHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    this.mLayoutManager = paramLayoutManager;
  }
  
  public static OrientationHelper createHorizontalHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    return new OrientationHelper.1(paramLayoutManager);
  }
  
  public static OrientationHelper createOrientationHelper(RecyclerView.LayoutManager paramLayoutManager, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return createVerticalHelper(paramLayoutManager);
      }
      throw new IllegalArgumentException("invalid orientation");
    }
    return createHorizontalHelper(paramLayoutManager);
  }
  
  public static OrientationHelper createVerticalHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    return new OrientationHelper.2(paramLayoutManager);
  }
  
  public abstract int getDecoratedEnd(View paramView);
  
  public abstract int getDecoratedMeasurement(View paramView);
  
  public abstract int getDecoratedMeasurementInOther(View paramView);
  
  public abstract int getDecoratedStart(View paramView);
  
  public abstract int getEnd();
  
  public abstract int getEndAfterPadding();
  
  public abstract int getEndPadding();
  
  public RecyclerView.LayoutManager getLayoutManager()
  {
    return this.mLayoutManager;
  }
  
  public abstract int getMode();
  
  public abstract int getModeInOther();
  
  public abstract int getStartAfterPadding();
  
  public abstract int getTotalSpace();
  
  public int getTotalSpaceChange()
  {
    if (-2147483648 == this.mLastTotalSpace) {
      return 0;
    }
    return getTotalSpace() - this.mLastTotalSpace;
  }
  
  public abstract int getTransformedEndWithDecoration(View paramView);
  
  public abstract int getTransformedStartWithDecoration(View paramView);
  
  public abstract void offsetChild(View paramView, int paramInt);
  
  public abstract void offsetChildren(int paramInt);
  
  public void onLayoutComplete()
  {
    this.mLastTotalSpace = getTotalSpace();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.OrientationHelper
 * JD-Core Version:    0.7.0.1
 */