import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;

public class bhfk
  implements Animator.AnimatorListener
{
  public bhfk(AppBrandPage paramAppBrandPage, bgmk parambgmk) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_Bgmk.b();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_Bgmk.a();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhfk
 * JD-Core Version:    0.7.0.1
 */