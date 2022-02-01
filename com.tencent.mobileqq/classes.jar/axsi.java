import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axsi
  implements View.OnClickListener
{
  axsi(axsd paramaxsd) {}
  
  public void onClick(View paramView)
  {
    axbl localaxbl = axbl.a(this.a.a, this.a.a.app.getAccount(), 2);
    if (localaxbl != null)
    {
      localaxbl.f = "13";
      localaxbl.g = axsd.a(this.a).uin;
      aybf localaybf = new aybf(this.a.a);
      localaybf.a(localaxbl);
      localaybf.show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsi
 * JD-Core Version:    0.7.0.1
 */