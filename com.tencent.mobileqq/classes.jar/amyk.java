import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.view.View;

public final class amyk
  implements ValueAnimator.AnimatorUpdateListener
{
  final int jdField_a_of_type_Int = Color.red(this.d);
  final int b = Color.green(this.d);
  final int c = Color.blue(this.d);
  
  public amyk(int paramInt, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.argb(i, this.jdField_a_of_type_Int, this.b, this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amyk
 * JD-Core Version:    0.7.0.1
 */