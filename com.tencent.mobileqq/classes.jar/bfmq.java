import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import org.json.JSONObject;

class bfmq
  extends bfmh
{
  bfmq(bfmp parambfmp) {}
  
  public void b(@NonNull bfmi parambfmi)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        parambfmi = parambfmi.a();
        bfne.b("ReaderShadowGrayManager", "onReceiveDataOnSubThread: jsonResult:" + parambfmi);
        if (parambfmi == null) {
          break;
        }
        if (parambfmi.length() == 0) {
          return;
        }
        if ((parambfmi.getInt("ret") == 0) && (parambfmi.getJSONObject("data").getBoolean("isGrayUser")))
        {
          bool = true;
          bfmp.a(true);
          parambfmi = bfmp.a().edit();
          if (!bool) {
            break label140;
          }
          parambfmi.putInt("KEY_SHADOW_GRAY", i).apply();
          bfne.b("ReaderShadowGrayManager", "onReceiveDataOnSubThread: result=" + bool);
          return;
        }
      }
      catch (Exception parambfmi)
      {
        bfne.a("ReaderShadowGrayManager", "onReceiveDataOnSubThread: Exception happened ---> ", parambfmi);
        return;
      }
      boolean bool = false;
      continue;
      label140:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmq
 * JD-Core Version:    0.7.0.1
 */