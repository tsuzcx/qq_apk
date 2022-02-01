import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class apyu
{
  public int a = 1;
  
  public static apyu a(aptx[] paramArrayOfaptx)
  {
    apyu localapyu = new apyu();
    for (;;)
    {
      int i;
      try
      {
        int j = paramArrayOfaptx.length;
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = new JSONObject(paramArrayOfaptx[i].a);
          if (localJSONObject.has("cameraSwitchOnMessageTab")) {
            localapyu.a = Integer.valueOf(localJSONObject.optString("cameraSwitchOnMessageTab")).intValue();
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgTabCameraConfBean", 2, "onParsed switch= " + localapyu.a);
          }
          return localapyu;
        }
      }
      catch (Throwable paramArrayOfaptx)
      {
        QLog.e("MsgTabCameraConfBean", 1, "MsgTabCameraConfBean parse error, ", paramArrayOfaptx);
        return localapyu;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apyu
 * JD-Core Version:    0.7.0.1
 */