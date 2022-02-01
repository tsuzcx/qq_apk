import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;

class bfoj
  implements ValueAnimator.AnimatorUpdateListener
{
  bfoj(bfoi parambfoi, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfoj
 * JD-Core Version:    0.7.0.1
 */