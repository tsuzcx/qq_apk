package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PagerSnapHelper
  extends SnapHelper
{
  private static final int MAX_SCROLL_ON_FLING_DURATION = 100;
  @Nullable
  private OrientationHelper mHorizontalHelper;
  @Nullable
  private OrientationHelper mVerticalHelper;
  
  private int distanceToCenter(@NonNull RecyclerView.LayoutManager paramLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getDecoratedStart(paramView) + paramOrientationHelper.getDecoratedMeasurement(paramView) / 2 - (paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2);
  }
  
  @Nullable
  private View findCenterView(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper)
  {
    int n = paramLayoutManager.getChildCount();
    Object localObject = null;
    if (n == 0) {
      return null;
    }
    int i1 = paramOrientationHelper.getStartAfterPadding();
    int i2 = paramOrientationHelper.getTotalSpace() / 2;
    int j = 2147483647;
    int i = 0;
    while (i < n)
    {
      View localView = paramLayoutManager.getChildAt(i);
      int m = Math.abs(paramOrientationHelper.getDecoratedStart(localView) + paramOrientationHelper.getDecoratedMeasurement(localView) / 2 - (i1 + i2));
      int k = j;
      if (m < j)
      {
        localObject = localView;
        k = m;
      }
      i += 1;
      j = k;
    }
    return localObject;
  }
  
  @NonNull
  private OrientationHelper getHorizontalHelper(@NonNull RecyclerView.LayoutManager paramLayoutManager)
  {
    OrientationHelper localOrientationHelper = this.mHorizontalHelper;
    if ((localOrientationHelper == null) || (localOrientationHelper.mLayoutManager != paramLayoutManager)) {
      this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(paramLayoutManager);
    }
    return this.mHorizontalHelper;
  }
  
  @Nullable
  private OrientationHelper getOrientationHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager.canScrollVertically()) {
      return getVerticalHelper(paramLayoutManager);
    }
    if (paramLayoutManager.canScrollHorizontally()) {
      return getHorizontalHelper(paramLayoutManager);
    }
    return null;
  }
  
  @NonNull
  private OrientationHelper getVerticalHelper(@NonNull RecyclerView.LayoutManager paramLayoutManager)
  {
    OrientationHelper localOrientationHelper = this.mVerticalHelper;
    if ((localOrientationHelper == null) || (localOrientationHelper.mLayoutManager != paramLayoutManager)) {
      this.mVerticalHelper = OrientationHelper.createVerticalHelper(paramLayoutManager);
    }
    return this.mVerticalHelper;
  }
  
  private boolean isForwardFling(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    if (paramLayoutManager.canScrollHorizontally()) {
      return paramInt1 > 0;
    }
    return paramInt2 > 0;
  }
  
  private boolean isReverseLayout(RecyclerView.LayoutManager paramLayoutManager)
  {
    int i = paramLayoutManager.getItemCount();
    if ((paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider))
    {
      paramLayoutManager = (RecyclerView.SmoothScroller.ScrollVectorProvider)paramLayoutManager;
      boolean bool = true;
      paramLayoutManager = paramLayoutManager.computeScrollVectorForPosition(i - 1);
      if (paramLayoutManager != null)
      {
        if (paramLayoutManager.x >= 0.0F)
        {
          if (paramLayoutManager.y < 0.0F) {
            return true;
          }
          bool = false;
        }
        return bool;
      }
    }
    return false;
  }
  
  @Nullable
  public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager paramLayoutManager, @NonNull View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramLayoutManager.canScrollHorizontally()) {
      arrayOfInt[0] = distanceToCenter(paramLayoutManager, paramView, getHorizontalHelper(paramLayoutManager));
    } else {
      arrayOfInt[0] = 0;
    }
    if (paramLayoutManager.canScrollVertically())
    {
      arrayOfInt[1] = distanceToCenter(paramLayoutManager, paramView, getVerticalHelper(paramLayoutManager));
      return arrayOfInt;
    }
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }
  
  protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (!(paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
      return null;
    }
    return new PagerSnapHelper.1(this, this.mRecyclerView.getContext());
  }
  
  @Nullable
  public View findSnapView(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager.canScrollVertically()) {
      return findCenterView(paramLayoutManager, getVerticalHelper(paramLayoutManager));
    }
    if (paramLayoutManager.canScrollHorizontally()) {
      return findCenterView(paramLayoutManager, getHorizontalHelper(paramLayoutManager));
    }
    return null;
  }
  
  public int findTargetSnapPosition(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    int i2 = paramLayoutManager.getItemCount();
    if (i2 == 0) {
      return -1;
    }
    OrientationHelper localOrientationHelper = getOrientationHelper(paramLayoutManager);
    if (localOrientationHelper == null) {
      return -1;
    }
    int i3 = paramLayoutManager.getChildCount();
    int k = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    int j = -2147483648;
    int i1;
    for (int m = 2147483647; k < i3; m = i1)
    {
      View localView = paramLayoutManager.getChildAt(k);
      Object localObject4;
      if (localView == null)
      {
        localObject4 = localObject2;
        i1 = m;
      }
      else
      {
        int n = distanceToCenter(paramLayoutManager, localView, localOrientationHelper);
        Object localObject3 = localObject1;
        int i = j;
        if (n <= 0)
        {
          localObject3 = localObject1;
          i = j;
          if (n > j)
          {
            localObject3 = localView;
            i = n;
          }
        }
        localObject1 = localObject3;
        j = i;
        localObject4 = localObject2;
        i1 = m;
        if (n >= 0)
        {
          localObject1 = localObject3;
          j = i;
          localObject4 = localObject2;
          i1 = m;
          if (n < m)
          {
            i1 = n;
            localObject4 = localView;
            j = i;
            localObject1 = localObject3;
          }
        }
      }
      k += 1;
      localObject2 = localObject4;
    }
    boolean bool = isForwardFling(paramLayoutManager, paramInt1, paramInt2);
    if ((bool) && (localObject2 != null)) {
      return paramLayoutManager.getPosition(localObject2);
    }
    if ((!bool) && (localObject1 != null)) {
      return paramLayoutManager.getPosition(localObject1);
    }
    if (!bool) {
      localObject1 = localObject2;
    }
    if (localObject1 == null) {
      return -1;
    }
    paramInt2 = paramLayoutManager.getPosition(localObject1);
    if (isReverseLayout(paramLayoutManager) == bool) {
      paramInt1 = -1;
    } else {
      paramInt1 = 1;
    }
    paramInt1 = paramInt2 + paramInt1;
    if (paramInt1 >= 0)
    {
      if (paramInt1 >= i2) {
        return -1;
      }
      return paramInt1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.PagerSnapHelper
 * JD-Core Version:    0.7.0.1
 */