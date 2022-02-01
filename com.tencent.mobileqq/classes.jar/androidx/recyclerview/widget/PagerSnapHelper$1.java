package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

class PagerSnapHelper$1
  extends LinearSmoothScroller
{
  PagerSnapHelper$1(PagerSnapHelper paramPagerSnapHelper, Context paramContext)
  {
    super(paramContext);
  }
  
  protected float calculateSpeedPerPixel(DisplayMetrics paramDisplayMetrics)
  {
    return 100.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected int calculateTimeForScrolling(int paramInt)
  {
    return Math.min(100, super.calculateTimeForScrolling(paramInt));
  }
  
  protected void onTargetFound(View paramView, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction)
  {
    paramState = this.this$0;
    paramView = paramState.calculateDistanceToFinalSnap(paramState.mRecyclerView.getLayoutManager(), paramView);
    int i = paramView[0];
    int j = paramView[1];
    int k = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(j)));
    if (k > 0) {
      paramAction.update(i, j, k, this.mDecelerateInterpolator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.PagerSnapHelper.1
 * JD-Core Version:    0.7.0.1
 */