import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayeg
  implements View.OnClickListener
{
  public ayeg(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.b != null) && (!this.a.isFinishing()))
    {
      this.a.b.dismiss();
      this.a.b = null;
    }
    this.a.a(300L);
    bdla.b(this.a.app, "CliOper", "", "", "0X8004BB0", "0X8004BB0", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayeg
 * JD-Core Version:    0.7.0.1
 */