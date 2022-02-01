import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ampi
  implements Animation.AnimationListener
{
  ampi(ampf paramampf, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView.getTag() instanceof ampl))) {
      ((ampl)this.jdField_a_of_type_AndroidViewView.getTag()).a = true;
    }
    ampf.a(this.jdField_a_of_type_Ampf);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ampi
 * JD-Core Version:    0.7.0.1
 */