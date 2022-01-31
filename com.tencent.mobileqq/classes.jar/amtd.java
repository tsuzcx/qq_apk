import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amtd
{
  public int a = 1;
  
  public static amtd a(ampi[] paramArrayOfampi)
  {
    amtd localamtd = new amtd();
    for (;;)
    {
      int i;
      try
      {
        int j = paramArrayOfampi.length;
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = new JSONObject(paramArrayOfampi[i].a);
          if (localJSONObject.has("cameraSwitchOnMessageTab")) {
            localamtd.a = Integer.valueOf(localJSONObject.optString("cameraSwitchOnMessageTab")).intValue();
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgTabCameraConfBean", 2, "onParsed switch= " + localamtd.a);
          }
          return localamtd;
        }
      }
      catch (Throwable paramArrayOfampi)
      {
        QLog.e("MsgTabCameraConfBean", 1, "MsgTabCameraConfBean parse error, ", paramArrayOfampi);
        return localamtd;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amtd
 * JD-Core Version:    0.7.0.1
 */