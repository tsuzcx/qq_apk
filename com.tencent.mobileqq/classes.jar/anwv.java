import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

class anwv
  extends AnimatorListenerAdapter
{
  anwv(anwq paramanwq, anwx paramanwx) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "animHolder.animView.startPassiveAnimator!");
    }
    if ((this.jdField_a_of_type_Anwx != null) && (this.jdField_a_of_type_Anwx.b != null))
    {
      paramAnimator = "";
      if (this.jdField_a_of_type_Anwx.b.istroop != 0) {
        break label84;
      }
      paramAnimator = "1";
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "Bubble", "Passive_dync", paramAnimator, 1, 0, 0, "", String.valueOf(amca.a(this.jdField_a_of_type_Anwx.b.vipBubbleID)), "");
      return;
      label84:
      if (this.jdField_a_of_type_Anwx.b.istroop == 1) {
        paramAnimator = "2";
      } else if (this.jdField_a_of_type_Anwx.b.istroop == 3000) {
        paramAnimator = "3";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anwv
 * JD-Core Version:    0.7.0.1
 */