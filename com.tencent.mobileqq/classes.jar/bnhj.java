import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.share.QZoneShareActivity;

public class bnhj
  implements View.OnClickListener
{
  public bnhj(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void onClick(View paramView)
  {
    bmwa.a().a(QZoneShareActivity.a, paramView);
    this.a.a(false);
    Intent localIntent = new Intent(BaseApplication.getContext(), SelectMemberActivity.class);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_min", 1);
    this.a.startActivityForResult(localIntent, 1000);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhj
 * JD-Core Version:    0.7.0.1
 */