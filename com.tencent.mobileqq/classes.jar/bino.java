import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;

class bino
  implements Animation.AnimationListener
{
  bino(binn parambinn, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramAnimation.leftMargin = this.jdField_a_of_type_Binn.e;
    paramAnimation.topMargin = this.jdField_a_of_type_Binn.f;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimation);
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Binn.a = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bino
 * JD-Core Version:    0.7.0.1
 */