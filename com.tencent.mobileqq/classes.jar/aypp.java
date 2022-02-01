import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aypp
  implements View.OnClickListener
{
  public aypp(NearbyProfileFragment paramNearbyProfileFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false);
    if (this.a.a.app != null)
    {
      if ((NearbyProfileFragment.a(this.a).iIsGodFlag != 1) || (NearbyProfileFragment.a(this.a).gender != 0)) {
        break label89;
      }
      bdll.b(this.a.a.app, "CliOper", "", "", "0X800528A", "0X800528A", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label89:
      if ((NearbyProfileFragment.a(this.a).iIsGodFlag == 1) && (NearbyProfileFragment.a(this.a).gender == 1)) {
        bdll.b(this.a.a.app, "CliOper", "", "", "0X800528B", "0X800528B", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypp
 * JD-Core Version:    0.7.0.1
 */