import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class ankc
  implements View.OnClickListener
{
  ankc(anjz paramanjz, boolean paramBoolean, Activity paramActivity, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    anjz.a(this.jdField_a_of_type_Anjz).dismiss();
    if (this.jdField_a_of_type_Boolean)
    {
      AccountManageActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class).sendEmptyMessage(1134073);
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "0X800B3E8";; str = "0X800B3E5")
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankc
 * JD-Core Version:    0.7.0.1
 */