import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class azmz
  implements Animation.AnimationListener
{
  azmz(azmw paramazmw, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (azmw.a(this.jdField_a_of_type_Azmw) != null)
    {
      azmw.a(this.jdField_a_of_type_Azmw).a.clearAnimation();
      azmw.a(this.jdField_a_of_type_Azmw).a.setVisibility(8);
    }
    azmw.a(this.jdField_a_of_type_Azmw, false);
    azmw.a(this.jdField_a_of_type_Azmw, null);
    azmw.a(this.jdField_a_of_type_Azmw, null);
    azmw.a(this.jdField_a_of_type_Azmw, -1);
    if ((!this.jdField_a_of_type_Boolean) && (!azmw.b(this.jdField_a_of_type_Azmw)))
    {
      ThreadManager.getUIHandler().post(azmw.a(this.jdField_a_of_type_Azmw));
      azmw.b(this.jdField_a_of_type_Azmw, true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azmz
 * JD-Core Version:    0.7.0.1
 */