import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.10.1;

public class avmh
  implements View.OnClickListener
{
  avmh(avmf paramavmf) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, QQBrowserActivity.class);
    paramView.putExtra("url", "https://nearby.qq.com/nearby-visitor/index.html?_proxy=1&_wwv=128");
    this.a.a.startActivity(paramView);
    avmf.a(this.a, null);
    ThreadManager.post(new NearbyProfileDisplayTribePanel.10.1(this), 5, null, false);
    azqs.b(this.a.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_visit", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avmh
 * JD-Core Version:    0.7.0.1
 */