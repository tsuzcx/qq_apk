import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo;
import com.tencent.mobileqq.friends.intimate.CommonTroopListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auot
  implements View.OnClickListener
{
  public auot(CommonTroopListActivity paramCommonTroopListActivity) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof IntimateInfo.CommonTroopInfo))
    {
      IntimateInfo.CommonTroopInfo localCommonTroopInfo = (IntimateInfo.CommonTroopInfo)paramView.getTag();
      Intent localIntent = afur.a(new Intent(CommonTroopListActivity.a(this.a), SplashActivity.class), null);
      localIntent.putExtra("uin", localCommonTroopInfo.troopCode);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", localCommonTroopInfo.troopName);
      this.a.startActivity(localIntent);
    }
    bcst.b(null, "dc00898", "", "", "0X8009F54", "0X8009F54", CommonTroopListActivity.a(this.a), 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auot
 * JD-Core Version:    0.7.0.1
 */