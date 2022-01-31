import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

public class avkm
  extends Handler
{
  public avkm(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 101: 
    case 100: 
      do
      {
        do
        {
          return;
          this.a.a();
          bhso localbhso = bhso.b;
          if ((localbhso != null) && (localbhso.a())) {
            localbhso.b(5);
          }
        } while (paramMessage.obj == null);
        paramMessage = (NearbyPeopleCard)paramMessage.obj;
        this.a.b = true;
        this.a.a(paramMessage, true, false);
        return;
      } while (NearbyPeopleProfileActivity.a(this.a) == null);
      NearbyPeopleProfileActivity.a(this.a).b();
      return;
    case 102: 
      NearbyPeopleProfileActivity.a(this.a).a(paramMessage.arg1, paramMessage.arg2);
      return;
    case 202: 
      NearbyPeopleProfileActivity.a(this.a).a(true);
      this.a.a.sendEmptyMessageDelayed(203, 1500L);
      return;
    case 203: 
      NearbyPeopleProfileActivity.a(this.a).a(false);
      return;
    case 204: 
      this.a.a(this.a.getString(2131694722));
      return;
    case 207: 
      this.a.a(alud.a(2131707633));
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avkm
 * JD-Core Version:    0.7.0.1
 */