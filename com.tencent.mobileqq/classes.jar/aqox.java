import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqox
{
  public int a;
  
  public static aqox a(aqlg[] paramArrayOfaqlg)
  {
    localaqox = new aqox();
    int i = 0;
    try
    {
      while (i < paramArrayOfaqlg.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaqlg[i].a);
        if (localJSONObject.has("gc_zone_entry_optimize"))
        {
          localaqox.a = localJSONObject.optInt("gc_zone_entry_optimize");
          if (QLog.isColorLevel()) {
            QLog.d("GameCenterEnterConfBean", 1, "onParsed mGcZoneEntryOptimize=" + localaqox.a);
          }
        }
        i += 1;
      }
      return localaqox;
    }
    catch (Throwable paramArrayOfaqlg)
    {
      QLog.e("GameCenterEnterConfBean", 1, "GameCenterEnterConfBean parse error e=" + paramArrayOfaqlg.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqox
 * JD-Core Version:    0.7.0.1
 */