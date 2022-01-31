import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class bbpr
  implements Animation.AnimationListener
{
  bbpr(bbpo parambbpo, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (bbpo.a(this.jdField_a_of_type_Bbpo) != null)
    {
      bbpo.a(this.jdField_a_of_type_Bbpo).a.clearAnimation();
      bbpo.a(this.jdField_a_of_type_Bbpo).a.setVisibility(8);
    }
    bbpo.a(this.jdField_a_of_type_Bbpo, false);
    bbpo.a(this.jdField_a_of_type_Bbpo, null);
    bbpo.a(this.jdField_a_of_type_Bbpo, null);
    bbpo.a(this.jdField_a_of_type_Bbpo, -1);
    if ((!this.jdField_a_of_type_Boolean) && (!bbpo.b(this.jdField_a_of_type_Bbpo)))
    {
      ThreadManager.getUIHandler().post(bbpo.a(this.jdField_a_of_type_Bbpo));
      bbpo.b(this.jdField_a_of_type_Bbpo, true);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpr
 * JD-Core Version:    0.7.0.1
 */