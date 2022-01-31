import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import org.json.JSONObject;

class bgvq
  extends bgvi
{
  bgvq(bgvp parambgvp) {}
  
  public void b(@NonNull bgvj parambgvj)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        parambgvj = parambgvj.a();
        bgwf.c("ReaderShadowGrayManager", "onReceiveDataOnSubThread: jsonResult:" + parambgvj);
        if (parambgvj == null) {
          break;
        }
        if (parambgvj.length() == 0) {
          return;
        }
        if ((parambgvj.getInt("ret") == 0) && (parambgvj.getJSONObject("data").getBoolean("isGrayUser")))
        {
          bool = true;
          bgvp.a(true);
          parambgvj = bgvp.a().edit();
          if (!bool) {
            break label140;
          }
          parambgvj.putInt("KEY_SHADOW_GRAY", i).apply();
          bgwf.c("ReaderShadowGrayManager", "onReceiveDataOnSubThread: result=" + bool);
          return;
        }
      }
      catch (Exception parambgvj)
      {
        bgwf.a("ReaderShadowGrayManager", "onReceiveDataOnSubThread: Exception happened ---> ", parambgvj);
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
 * Qualified Name:     bgvq
 * JD-Core Version:    0.7.0.1
 */