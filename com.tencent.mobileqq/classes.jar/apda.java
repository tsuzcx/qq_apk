import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;

public class apda
  implements Animator.AnimatorListener
{
  public apda(DataReportViewer paramDataReportViewer) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.setVisibility(0);
    paramAnimator = new AlphaAnimation(0.0F, 1.0F);
    paramAnimator.setFillAfter(true);
    paramAnimator.setDuration(200L);
    this.a.a.startAnimation(paramAnimator);
    paramAnimator.setAnimationListener(new apdb(this));
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apda
 * JD-Core Version:    0.7.0.1
 */