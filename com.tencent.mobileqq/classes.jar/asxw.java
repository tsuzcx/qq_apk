import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class asxw
  implements View.OnClickListener
{
  public asxw(ExtendFriendCampusFragment paramExtendFriendCampusFragment) {}
  
  public void onClick(View paramView)
  {
    if (!atck.a(ExtendFriendCampusFragment.a(this.a)))
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.action.publishmood");
      bmtk localbmtk = bmtk.a();
      localbmtk.a = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localIntent.putExtra("qzone_plugin_activity_name", "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
      localIntent.putExtra("uin", localbmtk.a);
      localIntent.putExtra("key_from_kuolie", true);
      bmtd.b(ExtendFriendCampusFragment.a(this.a), localbmtk, localIntent, 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxw
 * JD-Core Version:    0.7.0.1
 */