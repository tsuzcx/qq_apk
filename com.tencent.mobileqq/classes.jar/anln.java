import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;

public class anln
  implements ValueAnimator.AnimatorUpdateListener
{
  public anln(DataReportViewer paramDataReportViewer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anln
 * JD-Core Version:    0.7.0.1
 */