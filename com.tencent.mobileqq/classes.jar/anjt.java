import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class anjt
  implements View.OnClickListener
{
  anjt(anjr paramanjr, boolean paramBoolean, Activity paramActivity, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    anjr.a(this.jdField_a_of_type_Anjr).dismiss();
    if (this.jdField_a_of_type_Boolean) {
      AccountManageActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "0X800B276";; str = "0X800B273")
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjt
 * JD-Core Version:    0.7.0.1
 */