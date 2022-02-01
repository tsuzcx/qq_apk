import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class apye
{
  public int a = 0;
  public int b = 0;
  
  public static apye a(aptx[] paramArrayOfaptx)
  {
    apye localapye = new apye();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaptx != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramArrayOfaptx.length > 0) {
        localObject1 = paramArrayOfaptx[0].a;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("LebaQzoneStyleBean", 1, "content is empty");
        return localapye;
      }
      paramArrayOfaptx = new JSONObject((String)localObject1);
      localapye.a = paramArrayOfaptx.optInt("ifnewstyle", 0);
      localapye.b = paramArrayOfaptx.optInt("sequenceadjust", 0);
      QLog.i("LebaQzoneStyleBean", 1, "parse config=" + (String)localObject1 + ",style=" + localapye.a + ",sequenceAdjust=" + localapye.b);
      return localapye;
    }
    catch (Exception paramArrayOfaptx)
    {
      QLog.i("LebaQzoneStyleBean", 1, "handleLebaConfig parse", paramArrayOfaptx);
    }
    return localapye;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apye
 * JD-Core Version:    0.7.0.1
 */