import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearSmoothScroller;
import android.view.View;

class bimo
  extends LinearSmoothScroller
{
  public bimo(bimn parambimn, Context paramContext)
  {
    super(paramContext);
  }
  
  public int calculateDxToMakeVisible(View paramView, int paramInt)
  {
    return bimn.a(this.a).a(-this.a.g);
  }
  
  public int calculateDyToMakeVisible(View paramView, int paramInt)
  {
    return bimn.a(this.a).b(-this.a.g);
  }
  
  public int calculateTimeForScrolling(int paramInt)
  {
    return (int)(Math.max(0.01F, Math.min(Math.abs(paramInt), this.a.d) / this.a.d) * bimn.a(this.a));
  }
  
  @Nullable
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    return new PointF(bimn.a(this.a).a(this.a.g), bimn.a(this.a).b(this.a.g));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bimo
 * JD-Core Version:    0.7.0.1
 */