import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class aton
  extends atcd
{
  public aton(NearbyAuthVideoPlayerFragment paramNearbyAuthVideoPlayerFragment) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyAuthVideoPlayerFragment", 2, "onDeleteNearbyPeopleAuthVideo isSuccess:" + paramBoolean);
    }
    ((aszf)this.a.getActivity().app.getManager(106)).d.put(this.a.getActivity().app.getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean) {
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aton
 * JD-Core Version:    0.7.0.1
 */