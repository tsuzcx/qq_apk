import android.app.Activity;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.mobileqq.activity.weather.SessionClearFragment.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class amkx
  implements aouo
{
  public amkx(SessionClearFragment paramSessionClearFragment) {}
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SessionClearFragment", 2, "onLoadStart");
      this.a.a();
    }
  }
  
  public void a(List<aoui> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onLoadFinish");
    }
    SessionClearFragment.a(this.a).runOnUiThread(new SessionClearFragment.1.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkx
 * JD-Core Version:    0.7.0.1
 */