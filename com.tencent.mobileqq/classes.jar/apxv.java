import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class apxv
{
  public int a;
  public int b;
  
  public static apxv a(aptx[] paramArrayOfaptx)
  {
    localapxv = new apxv();
    int i = 0;
    try
    {
      while (i < paramArrayOfaptx.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaptx[i].a);
        if (localJSONObject.has("gc_zone_entry_optimize"))
        {
          localapxv.a = localJSONObject.optInt("gc_zone_entry_optimize");
          if (QLog.isColorLevel()) {
            QLog.d("GameCenterEnterConfBean", 1, "onParsed mGcZoneEntryOptimize=" + localapxv.a);
          }
        }
        if (localJSONObject.has("gc_msg_remind_optimize"))
        {
          localapxv.b = localJSONObject.optInt("gc_msg_remind_optimize");
          if (QLog.isColorLevel()) {
            QLog.d("GameCenterEnterConfBean", 1, "onParsed mgcMsgRemindOptimize=" + localapxv.b);
          }
        }
        i += 1;
      }
      return localapxv;
    }
    catch (Throwable paramArrayOfaptx)
    {
      QLog.e("GameCenterEnterConfBean", 1, "GameCenterEnterConfBean parse error e=" + paramArrayOfaptx.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apxv
 * JD-Core Version:    0.7.0.1
 */