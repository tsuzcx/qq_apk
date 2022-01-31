import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;

class awbt
  implements View.OnClickListener
{
  awbt(awbs paramawbs) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(awbs.a(this.a).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, PublicFragmentActivity.class);
    paramView.putExtra("key_uin", awbs.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    paramView.putExtra("key_uin_name", awbs.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    paramView.putExtra("key_open_via", "history-liaotian");
    abtu.a(awbs.a(this.a).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramView, PublicFragmentActivity.class, SignatureHistoryFragment.class);
    awbs.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X800A66B");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awbt
 * JD-Core Version:    0.7.0.1
 */