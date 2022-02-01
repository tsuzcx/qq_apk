import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import com.tencent.qphone.base.util.QLog;

class avio
  extends ConnectivityManager.NetworkCallback
{
  avio(avin paramavin) {}
  
  public void onAvailable(Network paramNetwork)
  {
    QLog.d("GateWayVerifyManager", 1, "switch network success");
    if ((avin.a(this.a) == null) || (!avin.a(this.a).equals(paramNetwork)))
    {
      avin.a(this.a, paramNetwork);
      if (avin.a(this.a) != null) {
        avin.a(this.a).a(paramNetwork);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avio
 * JD-Core Version:    0.7.0.1
 */