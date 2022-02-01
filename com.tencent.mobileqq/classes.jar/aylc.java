import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aylc
  implements View.OnClickListener
{
  aylc(aykx paramaykx) {}
  
  public void onClick(View paramView)
  {
    axuc localaxuc = axuc.a(this.a.a, this.a.a.app.getAccount(), 2);
    if (localaxuc != null)
    {
      localaxuc.f = "13";
      localaxuc.g = aykx.a(this.a).uin;
      aytz localaytz = new aytz(this.a.a);
      localaytz.a(localaxuc);
      localaytz.show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylc
 * JD-Core Version:    0.7.0.1
 */