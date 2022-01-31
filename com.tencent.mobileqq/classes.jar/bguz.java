import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import org.json.JSONObject;

class bguz
  extends bgur
{
  bguz(bguy parambguy) {}
  
  public void b(@NonNull bgus parambgus)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        parambgus = parambgus.a();
        bgvo.c("ReaderShadowGrayManager", "onReceiveDataOnSubThread: jsonResult:" + parambgus);
        if (parambgus == null) {
          break;
        }
        if (parambgus.length() == 0) {
          return;
        }
        if ((parambgus.getInt("ret") == 0) && (parambgus.getJSONObject("data").getBoolean("isGrayUser")))
        {
          bool = true;
          bguy.a(true);
          parambgus = bguy.a().edit();
          if (!bool) {
            break label140;
          }
          parambgus.putInt("KEY_SHADOW_GRAY", i).apply();
          bgvo.c("ReaderShadowGrayManager", "onReceiveDataOnSubThread: result=" + bool);
          return;
        }
      }
      catch (Exception parambgus)
      {
        bgvo.a("ReaderShadowGrayManager", "onReceiveDataOnSubThread: Exception happened ---> ", parambgus);
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
 * Qualified Name:     bguz
 * JD-Core Version:    0.7.0.1
 */