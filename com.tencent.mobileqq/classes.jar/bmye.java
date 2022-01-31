import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SlideBottomPanel;

public class bmye
  implements Animator.AnimatorListener
{
  public bmye(SlideBottomPanel paramSlideBottomPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.b = false;
    this.a.e = false;
    if (this.a.jdField_a_of_type_Bmxq != null) {
      this.a.jdField_a_of_type_Bmxq.hidePanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.b = false;
    this.a.e = false;
    if (this.a.jdField_a_of_type_Bmxq != null) {
      this.a.jdField_a_of_type_Bmxq.hidePanelFinish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmye
 * JD-Core Version:    0.7.0.1
 */