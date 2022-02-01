import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import com.tencent.qphone.base.util.QLog;

class awcp
  extends ConnectivityManager.NetworkCallback
{
  awcp(awco paramawco) {}
  
  public void onAvailable(Network paramNetwork)
  {
    QLog.d("GateWayVerifyManager", 1, "switch network success");
    if ((awco.a(this.a) == null) || (!awco.a(this.a).equals(paramNetwork)))
    {
      awco.a(this.a, paramNetwork);
      if (awco.a(this.a) != null) {
        awco.a(this.a).a(paramNetwork);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awcp
 * JD-Core Version:    0.7.0.1
 */