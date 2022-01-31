import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amtc
{
  public int a = 1;
  
  public static amtc a(amph[] paramArrayOfamph)
  {
    amtc localamtc = new amtc();
    for (;;)
    {
      int i;
      try
      {
        int j = paramArrayOfamph.length;
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = new JSONObject(paramArrayOfamph[i].a);
          if (localJSONObject.has("cameraSwitchOnMessageTab")) {
            localamtc.a = Integer.valueOf(localJSONObject.optString("cameraSwitchOnMessageTab")).intValue();
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgTabCameraConfBean", 2, "onParsed switch= " + localamtc.a);
          }
          return localamtc;
        }
      }
      catch (Throwable paramArrayOfamph)
      {
        QLog.e("MsgTabCameraConfBean", 1, "MsgTabCameraConfBean parse error, ", paramArrayOfamph);
        return localamtc;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amtc
 * JD-Core Version:    0.7.0.1
 */