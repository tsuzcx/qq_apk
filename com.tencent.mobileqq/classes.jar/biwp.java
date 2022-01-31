import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import org.json.JSONObject;

class biwp
  extends biwh
{
  biwp(biwo parambiwo) {}
  
  public void b(@NonNull biwi parambiwi)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        parambiwi = parambiwi.a();
        bixe.c("ReaderShadowGrayManager", "onReceiveDataOnSubThread: jsonResult:" + parambiwi);
        if (parambiwi == null) {
          break;
        }
        if (parambiwi.length() == 0) {
          return;
        }
        if ((parambiwi.getInt("ret") == 0) && (parambiwi.getJSONObject("data").getBoolean("isGrayUser")))
        {
          bool = true;
          biwo.a(true);
          parambiwi = biwo.a().edit();
          if (!bool) {
            break label140;
          }
          parambiwi.putInt("KEY_SHADOW_GRAY", i).apply();
          bixe.c("ReaderShadowGrayManager", "onReceiveDataOnSubThread: result=" + bool);
          return;
        }
      }
      catch (Exception parambiwi)
      {
        bixe.a("ReaderShadowGrayManager", "onReceiveDataOnSubThread: Exception happened ---> ", parambiwi);
        return;
      }
      boolean bool = false;
      continue;
      label140:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biwp
 * JD-Core Version:    0.7.0.1
 */