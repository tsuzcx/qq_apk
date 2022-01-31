import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.share.QZoneShareActivity;

public class bhmf
  implements View.OnClickListener
{
  public bhmf(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void onClick(View paramView)
  {
    bhbe.a().a(QZoneShareActivity.a, paramView);
    this.a.a(false);
    paramView = new Intent(BaseApplication.getContext(), SelectMemberActivity.class);
    paramView.putExtra("param_only_friends", true);
    paramView.putExtra("param_min", 1);
    this.a.startActivityForResult(paramView, 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhmf
 * JD-Core Version:    0.7.0.1
 */