import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.medalwall.MedalGuideView;

public class atww
  implements ValueAnimator.AnimatorUpdateListener
{
  public atww(MedalGuideView paramMedalGuideView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue("alpha")).floatValue();
    this.a.jdField_a_of_type_ComTencentImageURLImageView.setAlpha(f);
    f = ((Float)paramValueAnimator.getAnimatedValue("scale")).floatValue();
    this.a.jdField_a_of_type_ComTencentImageURLImageView.setScaleX(f);
    this.a.jdField_a_of_type_ComTencentImageURLImageView.setScaleY(f);
    f = ((Float)paramValueAnimator.getAnimatedValue("translationX")).floatValue();
    this.a.jdField_a_of_type_ComTencentImageURLImageView.setTranslationX(f);
    f = ((Float)paramValueAnimator.getAnimatedValue("translationY")).floatValue();
    this.a.jdField_a_of_type_ComTencentImageURLImageView.setTranslationY(f);
    f = paramValueAnimator.getAnimatedFraction();
    if ((!this.a.jdField_a_of_type_Boolean) && (f >= 1.0F))
    {
      this.a.jdField_a_of_type_Boolean = true;
      this.a.jdField_a_of_type_Bhow.sendEmptyMessage(3);
    }
    if (f >= 1.0F) {
      paramValueAnimator.removeAllUpdateListeners();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atww
 * JD-Core Version:    0.7.0.1
 */