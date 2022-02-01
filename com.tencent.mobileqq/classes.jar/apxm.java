import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.AvatarPendantManager;

class apxm
  extends AnimatorListenerAdapter
{
  apxm(apxi paramapxi, apxs paramapxs) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_Apxi.d != null) && (this.jdField_a_of_type_Apxi.e != null))
    {
      this.jdField_a_of_type_Apxi.d.setVisibility(4);
      this.jdField_a_of_type_Apxi.e.setVisibility(0);
      paramAnimator = (AvatarPendantManager)this.jdField_a_of_type_Apxi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      paramAnimator.jdField_a_of_type_Long = -1L;
      this.jdField_a_of_type_Apxi.a("show pendant, " + this.jdField_a_of_type_Apxi.jdField_a_of_type_Long);
      paramAnimator.b();
    }
    if (this.jdField_a_of_type_Apxi.c != null) {
      this.jdField_a_of_type_Apxi.c.setVisibility(0);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_Apxi.d != null) && (this.jdField_a_of_type_Apxi.e != null))
    {
      this.jdField_a_of_type_Apxi.d.setVisibility(0);
      this.jdField_a_of_type_Apxi.e.setVisibility(4);
      paramAnimator = (AvatarPendantManager)this.jdField_a_of_type_Apxi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      this.jdField_a_of_type_Apxi.a("stop show pendant, " + this.jdField_a_of_type_Apxi.jdField_a_of_type_Long);
      paramAnimator.jdField_a_of_type_Long = this.jdField_a_of_type_Apxi.jdField_a_of_type_Long;
      paramAnimator.a();
    }
    if ((this.jdField_a_of_type_Apxi.c != null) && (TextUtils.isEmpty(this.jdField_a_of_type_Apxs.e))) {
      this.jdField_a_of_type_Apxi.c.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxm
 * JD-Core Version:    0.7.0.1
 */