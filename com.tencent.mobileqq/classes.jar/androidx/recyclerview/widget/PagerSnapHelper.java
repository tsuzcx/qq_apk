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
    Object localObject1 = null;
    Object localObject2 = null;
    int m = paramLayoutManager.getChildCount();
    if (m == 0) {}
    int n;
    int i1;
    int i;
    int j;
    do
    {
      return localObject2;
      n = paramOrientationHelper.getStartAfterPadding();
      i1 = paramOrientationHelper.getTotalSpace() / 2;
      i = 2147483647;
      j = 0;
      localObject2 = localObject1;
    } while (j >= m);
    localObject2 = paramLayoutManager.getChildAt(j);
    int k = Math.abs(paramOrientationHelper.getDecoratedStart((View)localObject2) + paramOrientationHelper.getDecoratedMeasurement((View)localObject2) / 2 - (n + i1));
    if (k < i)
    {
      localObject1 = localObject2;
      i = k;
    }
    for (;;)
    {
      j += 1;
      break;
    }
  }
  
  @NonNull
  private OrientationHelper getHorizontalHelper(@NonNull RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((this.mHorizontalHelper == null) || (this.mHorizontalHelper.mLayoutManager != paramLayoutManager)) {
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
    if ((this.mVerticalHelper == null) || (this.mVerticalHelper.mLayoutManager != paramLayoutManager)) {
      this.mVerticalHelper = OrientationHelper.createVerticalHelper(paramLayoutManager);
    }
    return this.mVerticalHelper;
  }
  
  private boolean isForwardFling(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    if (paramLayoutManager.canScrollHorizontally()) {
      if (paramInt1 <= 0) {}
    }
    while (paramInt2 > 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private boolean isReverseLayout(RecyclerView.LayoutManager paramLayoutManager)
  {
    boolean bool2 = false;
    int i = paramLayoutManager.getItemCount();
    boolean bool1 = bool2;
    if ((paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider))
    {
      paramLayoutManager = ((RecyclerView.SmoothScroller.ScrollVectorProvider)paramLayoutManager).computeScrollVectorForPosition(i - 1);
      bool1 = bool2;
      if (paramLayoutManager != null) {
        if (paramLayoutManager.x >= 0.0F)
        {
          bool1 = bool2;
          if (paramLayoutManager.y >= 0.0F) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @Nullable
  public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager paramLayoutManager, @NonNull View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramLayoutManager.canScrollHorizontally()) {
      arrayOfInt[0] = distanceToCenter(paramLayoutManager, paramView, getHorizontalHelper(paramLayoutManager));
    }
    while (paramLayoutManager.canScrollVertically())
    {
      arrayOfInt[1] = distanceToCenter(paramLayoutManager, paramView, getVerticalHelper(paramLayoutManager));
      return arrayOfInt;
      arrayOfInt[0] = 0;
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
    Object localObject1 = null;
    int i1 = paramLayoutManager.getItemCount();
    if (i1 == 0)
    {
      paramInt1 = -1;
      return paramInt1;
    }
    OrientationHelper localOrientationHelper = getOrientationHelper(paramLayoutManager);
    if (localOrientationHelper == null) {
      return -1;
    }
    int i = -2147483648;
    int i2 = paramLayoutManager.getChildCount();
    int k = 0;
    Object localObject2 = null;
    int m = 2147483647;
    label52:
    View localView;
    if (k < i2)
    {
      localView = paramLayoutManager.getChildAt(k);
      if (localView != null) {}
    }
    for (;;)
    {
      k += 1;
      break label52;
      int n = distanceToCenter(paramLayoutManager, localView, localOrientationHelper);
      int j = i;
      Object localObject3 = localObject2;
      if (n <= 0)
      {
        j = i;
        localObject3 = localObject2;
        if (n > i)
        {
          j = n;
          localObject3 = localView;
        }
      }
      if ((n >= 0) && (n < m))
      {
        m = n;
        i = j;
        localObject1 = localView;
        localObject2 = localObject3;
        continue;
        boolean bool = isForwardFling(paramLayoutManager, paramInt1, paramInt2);
        if ((bool) && (localObject1 != null)) {
          return paramLayoutManager.getPosition(localObject1);
        }
        if ((!bool) && (localObject2 != null)) {
          return paramLayoutManager.getPosition(localObject2);
        }
        if (bool) {}
        while (localObject2 == null)
        {
          return -1;
          localObject2 = localObject1;
        }
        paramInt2 = paramLayoutManager.getPosition(localObject2);
        if (isReverseLayout(paramLayoutManager) == bool) {}
        for (paramInt1 = -1;; paramInt1 = 1)
        {
          paramInt2 = paramInt1 + paramInt2;
          if (paramInt2 >= 0)
          {
            paramInt1 = paramInt2;
            if (paramInt2 < i1) {
              break;
            }
          }
          return -1;
        }
      }
      else
      {
        localObject2 = localObject3;
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.PagerSnapHelper
 * JD-Core Version:    0.7.0.1
 */