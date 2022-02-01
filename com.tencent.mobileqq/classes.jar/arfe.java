import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arfe
{
  public int a = 1;
  
  public static arfe a(araj[] paramArrayOfaraj)
  {
    arfe localarfe = new arfe();
    for (;;)
    {
      int i;
      try
      {
        int j = paramArrayOfaraj.length;
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = new JSONObject(paramArrayOfaraj[i].a);
          if (localJSONObject.has("cameraSwitchOnMessageTab")) {
            localarfe.a = Integer.valueOf(localJSONObject.optString("cameraSwitchOnMessageTab")).intValue();
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgTabCameraConfBean", 2, "onParsed switch= " + localarfe.a);
          }
          return localarfe;
        }
      }
      catch (Throwable paramArrayOfaraj)
      {
        QLog.e("MsgTabCameraConfBean", 1, "MsgTabCameraConfBean parse error, ", paramArrayOfaraj);
        return localarfe;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfe
 * JD-Core Version:    0.7.0.1
 */