import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment;
import mqq.app.AppRuntime;

public class aqdl
  implements View.OnClickListener
{
  public aqdl(ExtendFriendCampusFragment paramExtendFriendCampusFragment) {}
  
  public void onClick(View paramView)
  {
    if (!aqhi.b(ExtendFriendCampusFragment.a(this.a)))
    {
      paramView = new Intent("com.tencent.mobileqq.action.publishmood");
      bjea localbjea = bjea.a();
      localbjea.a = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      paramView.putExtra("qzone_plugin_activity_name", "com.qzone.publish.ui.activity.QZonePublishMoodRealActivity");
      paramView.putExtra("uin", localbjea.a);
      paramView.putExtra("key_from_kuolie", true);
      bjdt.b(ExtendFriendCampusFragment.a(this.a), localbjea, paramView, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdl
 * JD-Core Version:    0.7.0.1
 */