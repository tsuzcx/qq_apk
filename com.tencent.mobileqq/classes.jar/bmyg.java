import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SlideBottomPanel;

public class bmyg
  implements Animator.AnimatorListener
{
  public bmyg(SlideBottomPanel paramSlideBottomPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = false;
    if (this.a.jdField_a_of_type_Bmxq != null) {
      this.a.jdField_a_of_type_Bmxq.displayPanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = false;
    if (this.a.jdField_a_of_type_Bmxq != null) {
      this.a.jdField_a_of_type_Bmxq.displayPanelFinish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyg
 * JD-Core Version:    0.7.0.1
 */