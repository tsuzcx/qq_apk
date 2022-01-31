import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.support.v7.widget.RecyclerView.State;
import android.util.DisplayMetrics;
import android.view.View;

class bfzq
  extends LinearSmoothScroller
{
  bfzq(bfzo parambfzo, Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    super(paramContext);
  }
  
  public float calculateSpeedPerPixel(DisplayMetrics paramDisplayMetrics)
  {
    return bfzo.a(this.jdField_a_of_type_Bfzo) / paramDisplayMetrics.densityDpi;
  }
  
  public int calculateTimeForDeceleration(int paramInt)
  {
    return super.calculateTimeForDeceleration(paramInt);
  }
  
  public int calculateTimeForScrolling(int paramInt)
  {
    return super.calculateTimeForScrolling(paramInt);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.computeScrollVectorForPosition(paramInt);
  }
  
  public void onTargetFound(View paramView, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction)
  {
    paramView = bfzo.a(this.jdField_a_of_type_Bfzo, this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager, paramView);
    int i = paramView[0];
    int j = paramView[1];
    int k = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(j)));
    if (k > 0)
    {
      paramAction.update(i, j, k, this.mDecelerateInterpolator);
      return;
    }
    bfzu.a(bfzo.a(this.jdField_a_of_type_Bfzo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfzq
 * JD-Core Version:    0.7.0.1
 */