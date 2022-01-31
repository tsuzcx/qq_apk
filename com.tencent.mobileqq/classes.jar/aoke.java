import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aoke
{
  public int a = 1;
  
  public static aoke a(aogf[] paramArrayOfaogf)
  {
    aoke localaoke = new aoke();
    for (;;)
    {
      int i;
      try
      {
        int j = paramArrayOfaogf.length;
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = new JSONObject(paramArrayOfaogf[i].a);
          if (localJSONObject.has("cameraSwitchOnMessageTab")) {
            localaoke.a = Integer.valueOf(localJSONObject.optString("cameraSwitchOnMessageTab")).intValue();
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgTabCameraConfBean", 2, "onParsed switch= " + localaoke.a);
          }
          return localaoke;
        }
      }
      catch (Throwable paramArrayOfaogf)
      {
        QLog.e("MsgTabCameraConfBean", 1, "MsgTabCameraConfBean parse error, ", paramArrayOfaogf);
        return localaoke;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoke
 * JD-Core Version:    0.7.0.1
 */