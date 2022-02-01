import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import com.tencent.qphone.base.util.QLog;

class awor
  extends ConnectivityManager.NetworkCallback
{
  awor(awoq paramawoq) {}
  
  public void onAvailable(Network paramNetwork)
  {
    QLog.d("GateWayVerifyManager", 1, "switch network success");
    if ((awoq.a(this.a) == null) || (!awoq.a(this.a).equals(paramNetwork)))
    {
      this.a.a(paramNetwork);
      if (awoq.a(this.a) != null) {
        awoq.a(this.a).a(paramNetwork);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awor
 * JD-Core Version:    0.7.0.1
 */