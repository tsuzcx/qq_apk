package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

class SnapHelper$2
  extends LinearSmoothScroller
{
  SnapHelper$2(SnapHelper paramSnapHelper, Context paramContext)
  {
    super(paramContext);
  }
  
  protected float calculateSpeedPerPixel(DisplayMetrics paramDisplayMetrics)
  {
    return 100.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected void onTargetFound(View paramView, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction)
  {
    if (this.this$0.mRecyclerView == null) {}
    int i;
    int j;
    int k;
    do
    {
      return;
      paramView = this.this$0.calculateDistanceToFinalSnap(this.this$0.mRecyclerView.getLayoutManager(), paramView);
      i = paramView[0];
      j = paramView[1];
      k = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(j)));
    } while (k <= 0);
    paramAction.update(i, j, k, this.mDecelerateInterpolator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.SnapHelper.2
 * JD-Core Version:    0.7.0.1
 */