import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aray
{
  public int a;
  public int b;
  
  public static aray a(aqxa[] paramArrayOfaqxa)
  {
    localaray = new aray();
    int i = 0;
    try
    {
      while (i < paramArrayOfaqxa.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaqxa[i].a);
        if (localJSONObject.has("gc_zone_entry_optimize"))
        {
          localaray.a = localJSONObject.optInt("gc_zone_entry_optimize");
          if (QLog.isColorLevel()) {
            QLog.d("GameCenterEnterConfBean", 1, "onParsed mGcZoneEntryOptimize=" + localaray.a);
          }
        }
        if (localJSONObject.has("gc_msg_remind_optimize"))
        {
          localaray.b = localJSONObject.optInt("gc_msg_remind_optimize");
          if (QLog.isColorLevel()) {
            QLog.d("GameCenterEnterConfBean", 1, "onParsed mgcMsgRemindOptimize=" + localaray.b);
          }
        }
        i += 1;
      }
      return localaray;
    }
    catch (Throwable paramArrayOfaqxa)
    {
      QLog.e("GameCenterEnterConfBean", 1, "GameCenterEnterConfBean parse error e=" + paramArrayOfaqxa.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aray
 * JD-Core Version:    0.7.0.1
 */