import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;

public class bhjx
  implements View.OnClickListener
{
  public bhjx(QQCustomMenuNoIconLayout paramQQCustomMenuNoIconLayout, bhjs parambhjs) {}
  
  public void onClick(View paramView)
  {
    if (QQCustomMenuNoIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout) != null) {
      QQCustomMenuNoIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout).onClick(paramView);
    }
    QQCustomMenuNoIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout).a();
    QQCustomMenuNoIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenuNoIconLayout, "0X800B3BF", this.jdField_a_of_type_Bhjs.a());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhjx
 * JD-Core Version:    0.7.0.1
 */