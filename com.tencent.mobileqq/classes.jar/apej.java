import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

class apej
  extends AnimatorListenerAdapter
{
  apej(apeg paramapeg, ObjectAnimator paramObjectAnimator, apen paramapen) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "animHolder.animView.startAnimation!");
    }
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
    }
    if ((this.jdField_a_of_type_Apen != null) && (this.jdField_a_of_type_Apen.a != null))
    {
      paramAnimator = "";
      if (this.jdField_a_of_type_Apen.a.istroop != 0) {
        break label98;
      }
      paramAnimator = "1";
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "Bubble", "Active_dync", paramAnimator, 1, 0, 0, "", String.valueOf(anaj.a(this.jdField_a_of_type_Apen.a.vipBubbleID)), "");
      return;
      label98:
      if (this.jdField_a_of_type_Apen.a.istroop == 1) {
        paramAnimator = "2";
      } else if (this.jdField_a_of_type_Apen.a.istroop == 3000) {
        paramAnimator = "3";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apej
 * JD-Core Version:    0.7.0.1
 */