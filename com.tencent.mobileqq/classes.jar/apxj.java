import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.AvatarPendantManager;

class apxj
  extends AnimatorListenerAdapter
{
  apxj(apxi paramapxi) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a("animator set end!");
    if (this.a.c != null)
    {
      apxi.a(this.a).removeView(this.a.c);
      this.a.c = null;
      if (this.a.d == null) {
        break label186;
      }
      apxi.b(this.a).removeView(this.a.d);
      this.a.d = null;
    }
    for (;;)
    {
      if (this.a.e != null)
      {
        this.a.e.setVisibility(0);
        paramAnimator = (AvatarPendantManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
        paramAnimator.a = -1L;
        paramAnimator.b();
      }
      if (this.a.jdField_b_of_type_AndroidViewView != null) {
        this.a.jdField_b_of_type_AndroidViewView.invalidate();
      }
      this.a.jdField_a_of_type_JavaLangString = "";
      this.a.jdField_b_of_type_JavaLangString = "";
      this.a.a(true);
      return;
      this.a.a("something wrong, bubble view is null!");
      break;
      label186:
      this.a.a("something wrong, pendview is null!");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.a("animator set start!");
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxj
 * JD-Core Version:    0.7.0.1
 */