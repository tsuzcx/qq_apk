import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class beqf
  implements Animation.AnimationListener
{
  beqf(beqc parambeqc, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (beqc.a(this.jdField_a_of_type_Beqc) != null)
    {
      beqc.a(this.jdField_a_of_type_Beqc).a.clearAnimation();
      beqc.a(this.jdField_a_of_type_Beqc).a.setVisibility(8);
    }
    beqc.a(this.jdField_a_of_type_Beqc, false);
    beqc.a(this.jdField_a_of_type_Beqc, null);
    beqc.a(this.jdField_a_of_type_Beqc, null);
    beqc.a(this.jdField_a_of_type_Beqc, -1);
    if ((!this.jdField_a_of_type_Boolean) && (!beqc.b(this.jdField_a_of_type_Beqc)))
    {
      ThreadManager.getUIHandler().post(beqc.a(this.jdField_a_of_type_Beqc));
      beqc.b(this.jdField_a_of_type_Beqc, true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqf
 * JD-Core Version:    0.7.0.1
 */