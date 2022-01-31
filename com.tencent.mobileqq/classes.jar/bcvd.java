import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatView;

public class bcvd
  implements ValueAnimator.AnimatorUpdateListener
{
  public bcvd(QUSHalfScreenFloatView paramQUSHalfScreenFloatView, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if ((paramValueAnimator instanceof Float))
    {
      this.jdField_a_of_type_AndroidViewView.setY(((Float)paramValueAnimator).floatValue());
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQusQUSHalfScreenFloatView.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQusQUSHalfScreenFloatView.a.fadeBackground(1.0F - ((Float)paramValueAnimator).floatValue() / (this.jdField_a_of_type_ComTencentMobileqqWidgetQusQUSHalfScreenFloatView.b - this.jdField_a_of_type_ComTencentMobileqqWidgetQusQUSHalfScreenFloatView.j));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcvd
 * JD-Core Version:    0.7.0.1
 */