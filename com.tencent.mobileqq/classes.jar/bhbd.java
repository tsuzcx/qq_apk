import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;

public class bhbd
  implements Animator.AnimatorListener
{
  public bhbd(AppBrandPage paramAppBrandPage, bgid parambgid) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_Bgid.b();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_Bgid.a();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhbd
 * JD-Core Version:    0.7.0.1
 */