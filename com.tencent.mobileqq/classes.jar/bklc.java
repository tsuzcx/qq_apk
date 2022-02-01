import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class bklc
  implements aaea
{
  bklc(bklb parambklb) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("msg");
    if (i == 90)
    {
      bklb.a(this.a, paramBundle.getInt("state"));
      if (QLog.isColorLevel()) {
        QLog.d("NowLiveJsPlugin", 2, "TroopMemberApiClient.Callback | plugin state: " + bklb.a(this.a));
      }
    }
    do
    {
      do
      {
        return;
      } while (i != 91);
      i = paramBundle.getInt("errCode");
      paramBundle = paramBundle.getString("desc");
    } while (!QLog.isColorLevel());
    QLog.d("NowLiveJsPlugin", 2, "TroopMemberApiClient.Callback | errCode=" + i + ", desc=" + paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bklc
 * JD-Core Version:    0.7.0.1
 */