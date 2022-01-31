import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class atpn
  implements View.OnClickListener
{
  atpn(atpi paramatpi) {}
  
  public void onClick(View paramView)
  {
    paramView = asyr.a(this.a.a, this.a.a.app.getAccount(), 2);
    if (paramView != null)
    {
      paramView.f = "13";
      paramView.g = atpi.a(this.a).uin;
      atyb localatyb = new atyb(this.a.a);
      localatyb.a(paramView);
      localatyb.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atpn
 * JD-Core Version:    0.7.0.1
 */