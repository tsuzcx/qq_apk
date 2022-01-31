import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class azmx
  implements Animation.AnimationListener
{
  azmx(azmu paramazmu, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (azmu.a(this.jdField_a_of_type_Azmu) != null)
    {
      azmu.a(this.jdField_a_of_type_Azmu).a.clearAnimation();
      azmu.a(this.jdField_a_of_type_Azmu).a.setVisibility(8);
    }
    azmu.a(this.jdField_a_of_type_Azmu, false);
    azmu.a(this.jdField_a_of_type_Azmu, null);
    azmu.a(this.jdField_a_of_type_Azmu, null);
    azmu.a(this.jdField_a_of_type_Azmu, -1);
    if ((!this.jdField_a_of_type_Boolean) && (!azmu.b(this.jdField_a_of_type_Azmu)))
    {
      ThreadManager.getUIHandler().post(azmu.a(this.jdField_a_of_type_Azmu));
      azmu.b(this.jdField_a_of_type_Azmu, true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azmx
 * JD-Core Version:    0.7.0.1
 */