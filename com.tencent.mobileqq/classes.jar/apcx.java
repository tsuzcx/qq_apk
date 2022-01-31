import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;

public class apcx
  implements ValueAnimator.AnimatorUpdateListener
{
  public apcx(DataReportViewer paramDataReportViewer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcx
 * JD-Core Version:    0.7.0.1
 */