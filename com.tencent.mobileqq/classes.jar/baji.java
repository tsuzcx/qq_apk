import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import android.view.View;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;
import com.tencent.mobileqq.widget.RatioLayout;

public class baji
  implements ValueAnimator.AnimatorUpdateListener
{
  public baji(VasProfileTagView paramVasProfileTagView, View paramView, PointF paramPointF) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    this.jdField_a_of_type_AndroidViewView.setScaleX(paramValueAnimator.floatValue());
    this.jdField_a_of_type_AndroidViewView.setScaleY(paramValueAnimator.floatValue());
    float f1 = this.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f2 = VasProfileTagView.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView).x;
    float f3 = VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView).getWidth();
    float f4 = this.jdField_a_of_type_AndroidGraphicsPointF.y;
    float f5 = VasProfileTagView.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView).y;
    float f6 = VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView).getHeight();
    this.jdField_a_of_type_AndroidViewView.setTranslationX((f1 - f2) * f3 * paramValueAnimator.floatValue());
    this.jdField_a_of_type_AndroidViewView.setTranslationY((f4 - f5) * f6 * paramValueAnimator.floatValue());
    this.jdField_a_of_type_AndroidViewView.setRotation(paramValueAnimator.floatValue() * 120.0F - 120.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baji
 * JD-Core Version:    0.7.0.1
 */