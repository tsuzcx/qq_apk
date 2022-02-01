import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arbx
{
  public int a = 1;
  
  public static arbx a(aqxa[] paramArrayOfaqxa)
  {
    arbx localarbx = new arbx();
    for (;;)
    {
      int i;
      try
      {
        int j = paramArrayOfaqxa.length;
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = new JSONObject(paramArrayOfaqxa[i].a);
          if (localJSONObject.has("cameraSwitchOnMessageTab")) {
            localarbx.a = Integer.valueOf(localJSONObject.optString("cameraSwitchOnMessageTab")).intValue();
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgTabCameraConfBean", 2, "onParsed switch= " + localarbx.a);
          }
          return localarbx;
        }
      }
      catch (Throwable paramArrayOfaqxa)
      {
        QLog.e("MsgTabCameraConfBean", 1, "MsgTabCameraConfBean parse error, ", paramArrayOfaqxa);
        return localarbx;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbx
 * JD-Core Version:    0.7.0.1
 */