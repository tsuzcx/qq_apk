import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class aymh
  implements Animation.AnimationListener
{
  aymh(ayme paramayme, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (ayme.a(this.jdField_a_of_type_Ayme) != null)
    {
      ayme.a(this.jdField_a_of_type_Ayme).a.clearAnimation();
      ayme.a(this.jdField_a_of_type_Ayme).a.setVisibility(8);
    }
    ayme.a(this.jdField_a_of_type_Ayme, false);
    ayme.a(this.jdField_a_of_type_Ayme, null);
    ayme.a(this.jdField_a_of_type_Ayme, null);
    ayme.a(this.jdField_a_of_type_Ayme, -1);
    if ((!this.jdField_a_of_type_Boolean) && (!ayme.b(this.jdField_a_of_type_Ayme)))
    {
      ThreadManager.getUIHandler().post(ayme.a(this.jdField_a_of_type_Ayme));
      ayme.b(this.jdField_a_of_type_Ayme, true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aymh
 * JD-Core Version:    0.7.0.1
 */