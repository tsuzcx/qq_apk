import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class avky
  implements View.OnClickListener
{
  avky(avkt paramavkt) {}
  
  public void onClick(View paramView)
  {
    paramView = autz.a(this.a.a, this.a.a.app.getAccount(), 2);
    if (paramView != null)
    {
      paramView.f = "13";
      paramView.g = avkt.a(this.a).uin;
      avtq localavtq = new avtq(this.a.a);
      localavtq.a(paramView);
      localavtq.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avky
 * JD-Core Version:    0.7.0.1
 */