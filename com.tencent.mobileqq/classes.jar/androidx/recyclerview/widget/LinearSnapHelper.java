package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LinearSnapHelper
  extends SnapHelper
{
  private static final float INVALID_DISTANCE = 1.0F;
  @Nullable
  private OrientationHelper mHorizontalHelper;
  @Nullable
  private OrientationHelper mVerticalHelper;
  
  private float computeDistancePerChild(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper)
  {
    Object localObject1 = null;
    int i = 2147483647;
    int i1 = paramLayoutManager.getChildCount();
    if (i1 == 0) {
      return 1.0F;
    }
    int k = 0;
    Object localObject2 = null;
    int m = -2147483648;
    View localView;
    int n;
    if (k < i1)
    {
      localView = paramLayoutManager.getChildAt(k);
      n = paramLayoutManager.getPosition(localView);
      if (n != -1) {}
    }
    for (;;)
    {
      k += 1;
      break;
      int j = i;
      if (n < i)
      {
        j = n;
        localObject2 = localView;
      }
      if (n > m)
      {
        m = n;
        i = j;
        localObject1 = localView;
        continue;
        if ((localObject2 == null) || (localObject1 == null)) {
          return 1.0F;
        }
        j = Math.min(paramOrientationHelper.getDecoratedStart(localObject2), paramOrientationHelper.getDecoratedStart(localObject1));
        j = Math.max(paramOrientationHelper.getDecoratedEnd(localObject2), paramOrientationHelper.getDecoratedEnd(localObject1)) - j;
        if (j == 0) {
          return 1.0F;
        }
        return j * 1.0F / (m - i + 1);
      }
      else
      {
        i = j;
      }
    }
  }
  
  private int distanceToCenter(@NonNull RecyclerView.LayoutManager paramLayoutManager, @NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getDecoratedStart(paramView) + paramOrientationHelper.getDecoratedMeasurement(paramView) / 2 - (paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2);
  }
  
  private int estimateNextPositionDiffForFling(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = calculateScrollDistance(paramInt1, paramInt2);
    float f = computeDistancePerChild(paramLayoutManager, paramOrientationHelper);
    if (f <= 0.0F) {
      return 0;
    }
    if (Math.abs(arrayOfInt[0]) > Math.abs(arrayOfInt[1])) {}
    for (paramInt1 = arrayOfInt[0];; paramInt1 = arrayOfInt[1]) {
      return Math.round(paramInt1 / f);
    }
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
  
  @NonNull
  private OrientationHelper getVerticalHelper(@NonNull RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((this.mVerticalHelper == null) || (this.mVerticalHelper.mLayoutManager != paramLayoutManager)) {
      this.mVerticalHelper = OrientationHelper.createVerticalHelper(paramLayoutManager);
    }
    return this.mVerticalHelper;
  }
  
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
    if (!(paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
      paramInt2 = -1;
    }
    int j;
    label152:
    label170:
    label175:
    label180:
    do
    {
      return paramInt2;
      j = paramLayoutManager.getItemCount();
      if (j == 0) {
        return -1;
      }
      Object localObject = findSnapView(paramLayoutManager);
      if (localObject == null) {
        return -1;
      }
      int k = paramLayoutManager.getPosition((View)localObject);
      if (k == -1) {
        return -1;
      }
      localObject = ((RecyclerView.SmoothScroller.ScrollVectorProvider)paramLayoutManager).computeScrollVectorForPosition(j - 1);
      if (localObject == null) {
        return -1;
      }
      if (paramLayoutManager.canScrollHorizontally())
      {
        int i = estimateNextPositionDiffForFling(paramLayoutManager, getHorizontalHelper(paramLayoutManager), paramInt1, 0);
        paramInt1 = i;
        if (((PointF)localObject).x < 0.0F) {
          paramInt1 = -i;
        }
        if (!paramLayoutManager.canScrollVertically()) {
          break label170;
        }
        i = estimateNextPositionDiffForFling(paramLayoutManager, getVerticalHelper(paramLayoutManager), 0, paramInt2);
        paramInt2 = i;
        if (((PointF)localObject).y < 0.0F) {
          paramInt2 = -i;
        }
        if (!paramLayoutManager.canScrollVertically()) {
          break label175;
        }
      }
      for (;;)
      {
        if (paramInt2 != 0) {
          break label180;
        }
        return -1;
        paramInt1 = 0;
        break;
        paramInt2 = 0;
        break label152;
        paramInt2 = paramInt1;
      }
      paramInt2 = k + paramInt2;
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        paramInt1 = 0;
      }
      paramInt2 = paramInt1;
    } while (paramInt1 < j);
    return j - 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.LinearSnapHelper
 * JD-Core Version:    0.7.0.1
 */