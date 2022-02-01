import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmotionSearchPanel;
import com.tencent.qphone.base.util.QLog;

public class asqi
  implements Animator.AnimatorListener
{
  public asqi(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, "upAndDownAnim onAnimationEnd=");
    }
    agej.a(this.a.jdField_a_of_type_AndroidWidgetEditText);
    this.a.c();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, "upAndDownAnim start animStartBottom=" + EmotionSearchPanel.b(this.a));
    }
    EmotionSearchPanel.c(this.a, EmotionSearchPanel.b(this.a));
    ((asnw)this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().a(7)).c(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqi
 * JD-Core Version:    0.7.0.1
 */