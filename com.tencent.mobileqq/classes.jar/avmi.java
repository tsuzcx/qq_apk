import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class avmi
  implements View.OnClickListener
{
  avmi(avmf paramavmf) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a.a, QQBrowserActivity.class);
    paramView.putExtra("url", "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=501");
    paramView.putExtra("url", "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=501");
    this.a.a.startActivity(paramView);
    azqs.b(null, "dc00899", "grp_lbs", "", "rank_data", "clk_gift", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avmi
 * JD-Core Version:    0.7.0.1
 */