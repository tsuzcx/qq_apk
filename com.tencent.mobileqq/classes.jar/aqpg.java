import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqpg
{
  public int a = 0;
  public int b = 0;
  
  public static aqpg a(aqlg[] paramArrayOfaqlg)
  {
    aqpg localaqpg = new aqpg();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaqlg != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramArrayOfaqlg.length > 0) {
        localObject1 = paramArrayOfaqlg[0].a;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("LebaQzoneStyleBean", 1, "content is empty");
        return localaqpg;
      }
      paramArrayOfaqlg = new JSONObject((String)localObject1);
      localaqpg.a = paramArrayOfaqlg.optInt("ifnewstyle", 0);
      localaqpg.b = paramArrayOfaqlg.optInt("sequenceadjust", 0);
      QLog.i("LebaQzoneStyleBean", 1, "parse config=" + (String)localObject1 + ",style=" + localaqpg.a + ",sequenceAdjust=" + localaqpg.b);
      return localaqpg;
    }
    catch (Exception paramArrayOfaqlg)
    {
      QLog.i("LebaQzoneStyleBean", 1, "handleLebaConfig parse", paramArrayOfaqlg);
    }
    return localaqpg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqpg
 * JD-Core Version:    0.7.0.1
 */