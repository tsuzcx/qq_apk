import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

public class avkq
  implements View.OnClickListener
{
  public avkq(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.b != null) && (!this.a.isFinishing()))
    {
      this.a.b.dismiss();
      this.a.b = null;
    }
    this.a.a(300L);
    azqs.b(this.a.app, "CliOper", "", "", "0X8004BB0", "0X8004BB0", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avkq
 * JD-Core Version:    0.7.0.1
 */