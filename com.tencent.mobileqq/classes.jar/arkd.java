import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import mqq.app.AppRuntime;

public class arkd
  implements View.OnClickListener
{
  public arkd(ExtendFriendCampusFragment paramExtendFriendCampusFragment) {}
  
  public void onClick(View paramView)
  {
    if (!aros.a(ExtendFriendCampusFragment.a(this.a)))
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.action.publishmood");
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localIntent.putExtra("qzone_plugin_activity_name", "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
      localIntent.putExtra("uin", localUserInfo.qzone_uin);
      localIntent.putExtra("key_from_kuolie", true);
      QZoneHelper.forwardToPublishMood(ExtendFriendCampusFragment.a(this.a), localUserInfo, localIntent, 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arkd
 * JD-Core Version:    0.7.0.1
 */