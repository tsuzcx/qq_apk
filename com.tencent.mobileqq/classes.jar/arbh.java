import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arbh
{
  public int a = 0;
  public int b = 0;
  
  public static arbh a(aqxa[] paramArrayOfaqxa)
  {
    arbh localarbh = new arbh();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaqxa != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramArrayOfaqxa.length > 0) {
        localObject1 = paramArrayOfaqxa[0].a;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("LebaQzoneStyleBean", 1, "content is empty");
        return localarbh;
      }
      paramArrayOfaqxa = new JSONObject((String)localObject1);
      localarbh.a = paramArrayOfaqxa.optInt("gridstyle", 0);
      localarbh.b = paramArrayOfaqxa.optInt("sequenceadjust", 0);
      QLog.i("LebaQzoneStyleBean", 1, "parse config=" + (String)localObject1 + ",style=" + localarbh.a + ",sequenceAdjust=" + localarbh.b);
      return localarbh;
    }
    catch (Exception paramArrayOfaqxa)
    {
      QLog.i("LebaQzoneStyleBean", 1, "handleLebaConfig parse", paramArrayOfaqxa);
    }
    return localarbh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbh
 * JD-Core Version:    0.7.0.1
 */