import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bazq
  implements View.OnClickListener
{
  bazq(bazp parambazp) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(bazp.a(this.a).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, PublicFragmentActivity.class);
    localIntent.putExtra("key_uin", bazp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    localIntent.putExtra("key_uin_name", bazp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    localIntent.putExtra("key_open_via", "history-liaotian");
    aevv.a(bazp.a(this.a).jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent, PublicFragmentActivity.class, SignatureHistoryFragment.class);
    bazp.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("CliOper", "0X800A66B");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazq
 * JD-Core Version:    0.7.0.1
 */