import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class atpp
  implements View.OnClickListener
{
  atpp(atpk paramatpk) {}
  
  public void onClick(View paramView)
  {
    paramView = asyt.a(this.a.a, this.a.a.app.getAccount(), 2);
    if (paramView != null)
    {
      paramView.f = "13";
      paramView.g = atpk.a(this.a).uin;
      atyd localatyd = new atyd(this.a.a);
      localatyd.a(paramView);
      localatyd.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atpp
 * JD-Core Version:    0.7.0.1
 */