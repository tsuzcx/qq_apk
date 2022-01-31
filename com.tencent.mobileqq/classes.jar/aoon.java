import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aoon
{
  public int a = 1;
  
  public static aoon a(aoko[] paramArrayOfaoko)
  {
    aoon localaoon = new aoon();
    for (;;)
    {
      int i;
      try
      {
        int j = paramArrayOfaoko.length;
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = new JSONObject(paramArrayOfaoko[i].a);
          if (localJSONObject.has("cameraSwitchOnMessageTab")) {
            localaoon.a = Integer.valueOf(localJSONObject.optString("cameraSwitchOnMessageTab")).intValue();
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgTabCameraConfBean", 2, "onParsed switch= " + localaoon.a);
          }
          return localaoon;
        }
      }
      catch (Throwable paramArrayOfaoko)
      {
        QLog.e("MsgTabCameraConfBean", 1, "MsgTabCameraConfBean parse error, ", paramArrayOfaoko);
        return localaoon;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoon
 * JD-Core Version:    0.7.0.1
 */