import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import mqq.app.AppRuntime;

public class asoj
  implements View.OnClickListener
{
  public asoj(ExtendFriendCampusFragment paramExtendFriendCampusFragment) {}
  
  public void onClick(View paramView)
  {
    if (!assy.a(ExtendFriendCampusFragment.a(this.a)))
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.action.publishmood");
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localIntent.putExtra("qzone_plugin_activity_name", "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
      localIntent.putExtra("uin", localUserInfo.qzone_uin);
      localIntent.putExtra("key_from_kuolie", true);
      QZoneHelper.forwardToPublishMood(ExtendFriendCampusFragment.a(this.a), localUserInfo, localIntent, 0);
      UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#feeds_page#publish_entrance", true, -1L, -1L, null, true, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asoj
 * JD-Core Version:    0.7.0.1
 */