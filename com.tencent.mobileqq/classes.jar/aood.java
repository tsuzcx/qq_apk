import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;

public class aood
  implements ValueAnimator.AnimatorUpdateListener
{
  public aood(FlowCameraActivity2 paramFlowCameraActivity2, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowCameraActivity2.g.setPadding(0, 0, 0, paramValueAnimator.intValue());
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowCameraActivity2.e.setPadding(0, this.jdField_a_of_type_Int - paramValueAnimator.intValue(), 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aood
 * JD-Core Version:    0.7.0.1
 */