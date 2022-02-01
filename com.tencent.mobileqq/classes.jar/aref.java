import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aref
{
  public int a;
  
  public static aref a(araj[] paramArrayOfaraj)
  {
    localaref = new aref();
    int i = 0;
    try
    {
      while (i < paramArrayOfaraj.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaraj[i].a);
        if (localJSONObject.has("gc_zone_entry_optimize"))
        {
          localaref.a = localJSONObject.optInt("gc_zone_entry_optimize");
          if (QLog.isColorLevel()) {
            QLog.d("GameCenterEnterConfBean", 1, "onParsed mGcZoneEntryOptimize=" + localaref.a);
          }
        }
        i += 1;
      }
      return localaref;
    }
    catch (Throwable paramArrayOfaraj)
    {
      QLog.e("GameCenterEnterConfBean", 1, "GameCenterEnterConfBean parse error e=" + paramArrayOfaraj.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aref
 * JD-Core Version:    0.7.0.1
 */