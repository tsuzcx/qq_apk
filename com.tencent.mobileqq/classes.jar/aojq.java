import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aojq
{
  public int a = 0;
  
  public static aojq a(aogf[] paramArrayOfaogf)
  {
    aojq localaojq = new aojq();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaogf != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramArrayOfaogf.length > 0) {
        localObject1 = paramArrayOfaogf[0].a;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("LebaQzoneStyleBean", 1, "content is empty");
        return localaojq;
      }
      localaojq.a = new JSONObject((String)localObject1).optInt("ifnewstyle", 0);
      QLog.i("LebaQzoneStyleBean", 1, "parse config=" + (String)localObject1 + ",style=" + localaojq.a);
      return localaojq;
    }
    catch (Exception paramArrayOfaogf)
    {
      QLog.i("LebaQzoneStyleBean", 1, "handleLebaConfig parse", paramArrayOfaogf);
    }
    return localaojq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aojq
 * JD-Core Version:    0.7.0.1
 */