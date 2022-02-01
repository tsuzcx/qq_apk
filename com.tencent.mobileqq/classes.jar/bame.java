import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bame
  implements View.OnClickListener
{
  bame(bamd parambamd) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(bamd.a(this.a).mActivity, PublicFragmentActivity.class);
    localIntent.putExtra("key_uin", bamd.a(this.a).sessionInfo.curFriendUin);
    localIntent.putExtra("key_uin_name", bamd.a(this.a).sessionInfo.curFriendNick);
    localIntent.putExtra("key_open_via", "history-liaotian");
    adxr.a(bamd.a(this.a).mActivity, localIntent, PublicFragmentActivity.class, SignatureHistoryFragment.class);
    bamd.a(this.a).app.reportClickEvent("CliOper", "0X800A66B");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bame
 * JD-Core Version:    0.7.0.1
 */