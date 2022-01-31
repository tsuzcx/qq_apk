import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class atek
  implements ymm
{
  atek(atei paramatei) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("state", 0);
    String str = paramBundle.getString("version");
    long l = paramBundle.getLong("size", 0L);
    try
    {
      paramBundle = new JSONObject();
      paramBundle.put("status", i);
      paramBundle.put("versionCode", str);
      paramBundle.put("fileSize", l);
      this.a.callJs(this.a.f, new String[] { paramBundle.toString() });
      return;
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopApiPlugin", 2, "previewRewardVideo exp", paramBundle);
      }
      this.a.callJs(this.a.f, new String[] { "{\"result\":-10,\"message\":\"request fail\"}" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atek
 * JD-Core Version:    0.7.0.1
 */