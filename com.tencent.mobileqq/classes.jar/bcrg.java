import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.troop.widget.MessageSubtitleView;
import java.util.Queue;

public class bcrg
  implements Animator.AnimatorListener
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean = false;
  
  public bcrg(MessageSubtitleView paramMessageSubtitleView, boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Int == MessageSubtitleView.c) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView.b();
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView.a.isEmpty()) {
        MessageSubtitleView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcrg
 * JD-Core Version:    0.7.0.1
 */