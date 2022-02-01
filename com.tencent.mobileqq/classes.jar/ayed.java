import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayed
  implements View.OnClickListener
{
  public ayed(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (!this.a.isFinishing()))
    {
      this.a.a.dismiss();
      this.a.a = null;
    }
    this.a.d();
    this.a.b(true);
    bdla.b(this.a.app, "CliOper", "", "", "0X8004824", "0X8004824", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayed
 * JD-Core Version:    0.7.0.1
 */