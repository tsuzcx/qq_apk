import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import org.json.JSONObject;

class bjaw
  extends bjao
{
  bjaw(bjav parambjav) {}
  
  public void b(@NonNull bjap parambjap)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        parambjap = parambjap.a();
        bjbl.c("ReaderShadowGrayManager", "onReceiveDataOnSubThread: jsonResult:" + parambjap);
        if (parambjap == null) {
          break;
        }
        if (parambjap.length() == 0) {
          return;
        }
        if ((parambjap.getInt("ret") == 0) && (parambjap.getJSONObject("data").getBoolean("isGrayUser")))
        {
          bool = true;
          bjav.a(true);
          parambjap = bjav.a().edit();
          if (!bool) {
            break label140;
          }
          parambjap.putInt("KEY_SHADOW_GRAY", i).apply();
          bjbl.c("ReaderShadowGrayManager", "onReceiveDataOnSubThread: result=" + bool);
          return;
        }
      }
      catch (Exception parambjap)
      {
        bjbl.a("ReaderShadowGrayManager", "onReceiveDataOnSubThread: Exception happened ---> ", parambjap);
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
 * Qualified Name:     bjaw
 * JD-Core Version:    0.7.0.1
 */