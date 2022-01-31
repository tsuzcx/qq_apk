import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class aqor
  implements Animation.AnimationListener
{
  aqor(aqoq paramaqoq) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (!this.a.jdField_a_of_type_Aqok.g()) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqor
 * JD-Core Version:    0.7.0.1
 */