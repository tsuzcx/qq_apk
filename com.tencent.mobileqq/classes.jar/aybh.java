import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;

class aybh
  implements View.OnClickListener
{
  aybh(aybg paramaybg) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(aybg.a(this.a).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, PublicFragmentActivity.class);
    paramView.putExtra("key_uin", aybg.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    paramView.putExtra("key_uin_name", aybg.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    paramView.putExtra("key_open_via", "history-liaotian");
    adpn.a(aybg.a(this.a).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramView, PublicFragmentActivity.class, SignatureHistoryFragment.class);
    aybg.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X800A66B");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybh
 * JD-Core Version:    0.7.0.1
 */