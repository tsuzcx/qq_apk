import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayga
  implements View.OnClickListener
{
  ayga(ayfx paramayfx) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a.a, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=501");
    localIntent.putExtra("url", "https://imgcache.qq.com/club/client/flower/release/html/points.html?source=501");
    this.a.a.startActivity(localIntent);
    bdla.b(null, "dc00899", "grp_lbs", "", "rank_data", "clk_gift", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayga
 * JD-Core Version:    0.7.0.1
 */