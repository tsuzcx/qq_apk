import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo;
import com.tencent.mobileqq.friends.intimate.CommonTroopListActivity;

public class aqkd
  implements View.OnClickListener
{
  public aqkd(CommonTroopListActivity paramCommonTroopListActivity) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof IntimateInfo.CommonTroopInfo))
    {
      paramView = (IntimateInfo.CommonTroopInfo)paramView.getTag();
      Intent localIntent = actn.a(new Intent(CommonTroopListActivity.a(this.a), SplashActivity.class), null);
      localIntent.putExtra("uin", paramView.troopCode);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", paramView.troopName);
      this.a.startActivity(localIntent);
    }
    axqw.b(null, "dc00898", "", "", "0X8009F54", "0X8009F54", CommonTroopListActivity.a(this.a), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqkd
 * JD-Core Version:    0.7.0.1
 */