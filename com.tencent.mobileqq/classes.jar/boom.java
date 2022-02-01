import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

final class boom
  implements ValueAnimator.AnimatorUpdateListener
{
  float jdField_a_of_type_Float = 1.0F;
  final View jdField_a_of_type_AndroidViewView;
  
  boom(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_Float = f;
    this.jdField_a_of_type_AndroidViewView.invalidate();
    if (QLog.isColorLevel()) {
      QLog.d("PressScaleAnimDelegate ", 2, "do scale animtion, scale=" + f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boom
 * JD-Core Version:    0.7.0.1
 */