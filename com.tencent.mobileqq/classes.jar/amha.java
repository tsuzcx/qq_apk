import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;

public class amha
  implements ValueAnimator.AnimatorUpdateListener
{
  public amha(ForwardRecentItemView paramForwardRecentItemView, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.b - this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.jdField_a_of_type_Int);
    if (AppSetting.c)
    {
      paramValueAnimator = this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.getResources();
      if (!this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label124;
      }
    }
    label124:
    for (int i = 2131690825;; i = 2131719791)
    {
      paramValueAnimator = paramValueAnimator.getString(i);
      this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.jdField_a_of_type_JavaLangString + paramValueAnimator);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amha
 * JD-Core Version:    0.7.0.1
 */