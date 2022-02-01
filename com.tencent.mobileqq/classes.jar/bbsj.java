import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bbsj
  implements View.OnClickListener
{
  bbsj(bbsi parambbsi) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(bbsi.a(this.a).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, PublicFragmentActivity.class);
    localIntent.putExtra("key_uin", bbsi.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    localIntent.putExtra("key_uin_name", bbsi.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    localIntent.putExtra("key_open_via", "history-liaotian");
    afez.a(bbsi.a(this.a).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent, PublicFragmentActivity.class, SignatureHistoryFragment.class);
    bbsi.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X800A66B");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsj
 * JD-Core Version:    0.7.0.1
 */