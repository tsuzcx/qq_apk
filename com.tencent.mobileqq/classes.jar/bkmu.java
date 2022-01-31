import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SlideBottomPanel;

public class bkmu
  implements Animator.AnimatorListener
{
  public bkmu(SlideBottomPanel paramSlideBottomPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.b = false;
    this.a.e = false;
    if (this.a.jdField_a_of_type_Bkmg != null) {
      this.a.jdField_a_of_type_Bkmg.hidePanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.b = false;
    this.a.e = false;
    if (this.a.jdField_a_of_type_Bkmg != null) {
      this.a.jdField_a_of_type_Bkmg.hidePanelFinish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkmu
 * JD-Core Version:    0.7.0.1
 */