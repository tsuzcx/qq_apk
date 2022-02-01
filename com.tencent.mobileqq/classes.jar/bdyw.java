import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class bdyw
  implements Animation.AnimationListener
{
  bdyw(bdyt parambdyt, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (bdyt.a(this.jdField_a_of_type_Bdyt) != null)
    {
      bdyt.a(this.jdField_a_of_type_Bdyt).a.clearAnimation();
      bdyt.a(this.jdField_a_of_type_Bdyt).a.setVisibility(8);
    }
    bdyt.a(this.jdField_a_of_type_Bdyt, false);
    bdyt.a(this.jdField_a_of_type_Bdyt, null);
    bdyt.a(this.jdField_a_of_type_Bdyt, null);
    bdyt.a(this.jdField_a_of_type_Bdyt, -1);
    if ((!this.jdField_a_of_type_Boolean) && (!bdyt.b(this.jdField_a_of_type_Bdyt)))
    {
      ThreadManager.getUIHandler().post(bdyt.a(this.jdField_a_of_type_Bdyt));
      bdyt.b(this.jdField_a_of_type_Bdyt, true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyw
 * JD-Core Version:    0.7.0.1
 */