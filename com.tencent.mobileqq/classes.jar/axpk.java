import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.view.View;

final class axpk
  implements ValueAnimator.AnimatorUpdateListener
{
  final int jdField_a_of_type_Int = Color.red(this.d);
  final int b = Color.green(this.d);
  final int c = Color.blue(this.d);
  
  axpk(int paramInt, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.argb(i, this.jdField_a_of_type_Int, this.b, this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axpk
 * JD-Core Version:    0.7.0.1
 */