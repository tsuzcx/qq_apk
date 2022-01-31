import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;

class aqfc
  implements View.OnClickListener
{
  aqfc(aqfb paramaqfb) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null) {
      return;
    }
    paramView = this.a.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.trim();
    if (QLog.isColorLevel()) {
      QLog.e("ForwardOption.ForwardSdkBaseOption", 2, "gotoWeb " + paramView);
    }
    Intent localIntent = new Intent(this.a.a.jdField_a_of_type_AndroidAppActivity, QQBrowserDelegationActivity.class);
    localIntent.putExtra("param_force_internal_browser", true);
    localIntent.putExtra("reqType", 7);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("url", paramView);
    acqv.a(this.a.a.jdField_a_of_type_AndroidAppActivity, localIntent, paramView);
    this.a.a.D();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqfc
 * JD-Core Version:    0.7.0.1
 */