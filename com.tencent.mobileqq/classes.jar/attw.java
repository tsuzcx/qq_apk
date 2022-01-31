import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;
import com.tencent.qphone.base.util.QLog;

public class attw
  implements ValueAnimator.AnimatorUpdateListener
{
  public attw(PoiSlideBottomPanel paramPoiSlideBottomPanel, View paramView, float paramFloat1, float paramFloat2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if ((paramValueAnimator instanceof Float))
    {
      this.jdField_a_of_type_AndroidViewView.setY(((Float)paramValueAnimator).floatValue());
      if (QLog.isColorLevel()) {
        QLog.d("PoiSlideBottomPanel", 2, "[panel] onAnimationUpdate: show invoked. mPanel:" + this.jdField_a_of_type_AndroidViewView.getId() + " org: " + this.jdField_a_of_type_Float + " dest: " + this.b + " value: " + this.jdField_a_of_type_AndroidViewView.getY());
      }
      if (PoiSlideBottomPanel.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel) != null) {
        PoiSlideBottomPanel.b(this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel).fadeBackground(1.0F - ((Float)paramValueAnimator).floatValue() / (PoiSlideBottomPanel.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel) - PoiSlideBottomPanel.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     attw
 * JD-Core Version:    0.7.0.1
 */