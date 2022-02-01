import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import com.tencent.qphone.base.util.QLog;

class awvh
  extends ConnectivityManager.NetworkCallback
{
  awvh(awvg paramawvg) {}
  
  public void onAvailable(Network paramNetwork)
  {
    QLog.d("GateWayVerifyManager", 1, "switch network success");
    if ((awvg.a(this.a) == null) || (!awvg.a(this.a).equals(paramNetwork)))
    {
      awvg.a(this.a, paramNetwork);
      if (awvg.a(this.a) != null) {
        awvg.a(this.a).a(paramNetwork);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvh
 * JD-Core Version:    0.7.0.1
 */