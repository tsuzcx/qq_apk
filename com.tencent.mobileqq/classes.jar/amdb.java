import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amdb
{
  public int a = 1;
  
  public static amdb a(alzs[] paramArrayOfalzs)
  {
    amdb localamdb = new amdb();
    for (;;)
    {
      int i;
      try
      {
        int j = paramArrayOfalzs.length;
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = new JSONObject(paramArrayOfalzs[i].a);
          if (localJSONObject.has("cameraSwitchOnMessageTab")) {
            localamdb.a = Integer.valueOf(localJSONObject.optString("cameraSwitchOnMessageTab")).intValue();
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgTabCameraConfBean", 2, "onParsed switch= " + localamdb.a);
          }
          return localamdb;
        }
      }
      catch (Throwable paramArrayOfalzs)
      {
        QLog.e("MsgTabCameraConfBean", 1, "MsgTabCameraConfBean parse error, ", paramArrayOfalzs);
        return localamdb;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amdb
 * JD-Core Version:    0.7.0.1
 */