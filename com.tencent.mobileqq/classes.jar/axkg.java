import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;

public class axkg
  implements ValueAnimator.AnimatorUpdateListener
{
  public axkg(MultiAIOFragment paramMultiAIOFragment, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    paramValueAnimator.leftMargin = (this.jdField_a_of_type_Int + Math.round((0.0F - this.jdField_a_of_type_Int) * f1));
    paramValueAnimator.topMargin = (this.b + Math.round((this.c - this.b) * f1));
    paramValueAnimator.width = (this.d + Math.round((this.e - this.d) * f1));
    int i = this.f;
    paramValueAnimator.height = (Math.round(f1 * (this.g - this.f)) + i);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramValueAnimator);
    this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axkg
 * JD-Core Version:    0.7.0.1
 */