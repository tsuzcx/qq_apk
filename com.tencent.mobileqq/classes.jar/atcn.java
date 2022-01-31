import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

class atcn
  implements ValueAnimator.AnimatorUpdateListener
{
  atcn(atck paramatck, WindowManager.LayoutParams paramLayoutParams, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.jdField_a_of_type_Atck.b)
    {
      int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = i;
      this.jdField_a_of_type_Atck.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_Atck.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atcn
 * JD-Core Version:    0.7.0.1
 */