import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class atiu
  implements yrb
{
  atiu(atir paramatir) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("state", 0);
    int j = paramBundle.getInt("percentage", 0);
    long l = paramBundle.getLong("errCode", 0L);
    try
    {
      paramBundle = new JSONObject();
      paramBundle.put("state", i);
      paramBundle.put("percentage", j);
      paramBundle.put("errCode", l);
      this.a.callJs(this.a.g, new String[] { paramBundle.toString() });
      return;
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopApiPlugin", 2, "huanjiDownload exp", paramBundle);
      }
      this.a.callJs(this.a.g, new String[] { "{\"errCode\":-10,\"message\":\"request fail\"}" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atiu
 * JD-Core Version:    0.7.0.1
 */