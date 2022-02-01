import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqpw
{
  public int a = 1;
  
  public static aqpw a(aqlg[] paramArrayOfaqlg)
  {
    aqpw localaqpw = new aqpw();
    for (;;)
    {
      int i;
      try
      {
        int j = paramArrayOfaqlg.length;
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = new JSONObject(paramArrayOfaqlg[i].a);
          if (localJSONObject.has("cameraSwitchOnMessageTab")) {
            localaqpw.a = Integer.valueOf(localJSONObject.optString("cameraSwitchOnMessageTab")).intValue();
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgTabCameraConfBean", 2, "onParsed switch= " + localaqpw.a);
          }
          return localaqpw;
        }
      }
      catch (Throwable paramArrayOfaqlg)
      {
        QLog.e("MsgTabCameraConfBean", 1, "MsgTabCameraConfBean parse error, ", paramArrayOfaqlg);
        return localaqpw;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqpw
 * JD-Core Version:    0.7.0.1
 */