import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;
import com.tencent.qphone.base.util.QLog;

public class atty
  implements ValueAnimator.AnimatorUpdateListener
{
  public atty(PoiSlideBottomPanel paramPoiSlideBottomPanel, View paramView, float paramFloat, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if ((paramValueAnimator instanceof Float))
    {
      this.jdField_a_of_type_AndroidViewView.setY(((Float)paramValueAnimator).floatValue());
      if (QLog.isColorLevel()) {
        QLog.d("PoiSlideBottomPanel", 2, "[panel] onAnimationUpdate: hide invoked. org: " + this.jdField_a_of_type_Float + " dest: " + this.jdField_a_of_type_Int + " value: " + this.jdField_a_of_type_AndroidViewView.getY());
      }
      if (PoiSlideBottomPanel.g(this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel) != null) {
        PoiSlideBottomPanel.h(this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel).fadeBackground(1.0F - ((Float)paramValueAnimator).floatValue() / this.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atty
 * JD-Core Version:    0.7.0.1
 */