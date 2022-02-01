import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class aydn
  extends axqx
{
  public aydn(NearbyAuthVideoPlayerFragment paramNearbyAuthVideoPlayerFragment) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyAuthVideoPlayerFragment", 2, "onDeleteNearbyPeopleAuthVideo isSuccess:" + paramBoolean);
    }
    ((axny)this.a.getActivity().app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).d.put(this.a.getActivity().app.getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean) {
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydn
 * JD-Core Version:    0.7.0.1
 */