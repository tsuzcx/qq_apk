import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

class axxw
  implements ValueAnimator.AnimatorUpdateListener
{
  axxw(axxu paramaxxu, WindowManager.LayoutParams paramLayoutParams, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.jdField_a_of_type_Axxu.b)
    {
      int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = i;
      this.jdField_a_of_type_Axxu.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_Axxu.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxw
 * JD-Core Version:    0.7.0.1
 */