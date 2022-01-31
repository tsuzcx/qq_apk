import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment;
import mqq.app.AppRuntime;

public class apzc
  implements View.OnClickListener
{
  public apzc(ExtendFriendCampusFragment paramExtendFriendCampusFragment) {}
  
  public void onClick(View paramView)
  {
    if (!aqcz.b(ExtendFriendCampusFragment.a(this.a)))
    {
      paramView = new Intent("com.tencent.mobileqq.action.publishmood");
      bizt localbizt = bizt.a();
      localbizt.a = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      paramView.putExtra("qzone_plugin_activity_name", "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
      paramView.putExtra("uin", localbizt.a);
      paramView.putExtra("key_from_kuolie", true);
      bizm.b(ExtendFriendCampusFragment.a(this.a), localbizt, paramView, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzc
 * JD-Core Version:    0.7.0.1
 */