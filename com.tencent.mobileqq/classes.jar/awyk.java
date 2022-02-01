import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awyk
  implements View.OnClickListener
{
  awyk(awyf paramawyf) {}
  
  public void onClick(View paramView)
  {
    awhj localawhj = awhj.a(this.a.a, this.a.a.app.getAccount(), 2);
    if (localawhj != null)
    {
      localawhj.f = "13";
      localawhj.g = awyf.a(this.a).uin;
      axhh localaxhh = new axhh(this.a.a);
      localaxhh.a(localawhj);
      localaxhh.show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awyk
 * JD-Core Version:    0.7.0.1
 */