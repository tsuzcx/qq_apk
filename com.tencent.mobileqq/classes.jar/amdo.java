import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class amdo
  implements Animation.AnimationListener
{
  amdo(amdl paramamdl, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView.getTag() instanceof amdr))) {
      ((amdr)this.jdField_a_of_type_AndroidViewView.getTag()).a = true;
    }
    amdl.a(this.jdField_a_of_type_Amdl);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdo
 * JD-Core Version:    0.7.0.1
 */