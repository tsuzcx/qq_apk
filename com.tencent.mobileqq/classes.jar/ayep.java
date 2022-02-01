import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayep
  implements View.OnClickListener
{
  ayep(ayek paramayek) {}
  
  public void onClick(View paramView)
  {
    axnl localaxnl = axnl.a(this.a.a, this.a.a.app.getAccount(), 2);
    if (localaxnl != null)
    {
      localaxnl.f = "13";
      localaxnl.g = ayek.a(this.a).uin;
      aynm localaynm = new aynm(this.a.a);
      localaynm.a(localaxnl);
      localaynm.show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayep
 * JD-Core Version:    0.7.0.1
 */