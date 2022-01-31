import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import com.tencent.mobileqq.ar.view.ViewfinderView;

public class anie
  implements ValueAnimator.AnimatorUpdateListener
{
  public anie(ViewfinderView paramViewfinderView, Rect paramRect) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ViewfinderView.a(this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.jdField_a_of_type_ComTencentMobileqqArViewViewfinderView.postInvalidate(this.jdField_a_of_type_AndroidGraphicsRect.left - 6, this.jdField_a_of_type_AndroidGraphicsRect.top - 6, this.jdField_a_of_type_AndroidGraphicsRect.right + 6, this.jdField_a_of_type_AndroidGraphicsRect.bottom + 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anie
 * JD-Core Version:    0.7.0.1
 */