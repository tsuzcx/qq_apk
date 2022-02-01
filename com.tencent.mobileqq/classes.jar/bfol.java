import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.TextView;

class bfol
  implements ValueAnimator.AnimatorUpdateListener
{
  bfol(bfoi parambfoi, bfmu parambfmu) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    float f = 1.0F * (100 - i) / 100.0F;
    this.jdField_a_of_type_Bfmu.jdField_b_of_type_AndroidWidgetTextView.setAlpha(f);
    f = this.jdField_a_of_type_Bfmu.jdField_b_of_type_AndroidWidgetTextView.getHeight() / 2.0F * i / 100.0F;
    this.jdField_a_of_type_Bfmu.jdField_b_of_type_AndroidViewView.setTranslationY(f);
    f = i * -180.0F / 100.0F;
    this.jdField_a_of_type_Bfmu.c.setRotation(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfol
 * JD-Core Version:    0.7.0.1
 */