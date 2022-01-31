import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class avgp
  implements View.OnClickListener
{
  avgp(avgk paramavgk) {}
  
  public void onClick(View paramView)
  {
    paramView = aupq.a(this.a.a, this.a.a.app.getAccount(), 2);
    if (paramView != null)
    {
      paramView.f = "13";
      paramView.g = avgk.a(this.a).uin;
      avph localavph = new avph(this.a.a);
      localavph.a(paramView);
      localavph.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avgp
 * JD-Core Version:    0.7.0.1
 */