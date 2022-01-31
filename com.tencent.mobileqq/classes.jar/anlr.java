import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;

public class anlr
  implements Animation.AnimationListener
{
  public anlr(DataReportViewer paramDataReportViewer) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anlr
 * JD-Core Version:    0.7.0.1
 */