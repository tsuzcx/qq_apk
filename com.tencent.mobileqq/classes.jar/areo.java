import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class areo
{
  public int a = 0;
  public int b = 0;
  
  public static areo a(araj[] paramArrayOfaraj)
  {
    areo localareo = new areo();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaraj != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramArrayOfaraj.length > 0) {
        localObject1 = paramArrayOfaraj[0].a;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("LebaQzoneStyleBean", 1, "content is empty");
        return localareo;
      }
      paramArrayOfaraj = new JSONObject((String)localObject1);
      localareo.a = paramArrayOfaraj.optInt("ifnewstyle", 0);
      localareo.b = paramArrayOfaraj.optInt("sequenceadjust", 0);
      QLog.i("LebaQzoneStyleBean", 1, "parse config=" + (String)localObject1 + ",style=" + localareo.a + ",sequenceAdjust=" + localareo.b);
      return localareo;
    }
    catch (Exception paramArrayOfaraj)
    {
      QLog.i("LebaQzoneStyleBean", 1, "handleLebaConfig parse", paramArrayOfaraj);
    }
    return localareo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     areo
 * JD-Core Version:    0.7.0.1
 */