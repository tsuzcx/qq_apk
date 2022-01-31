import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aonz
{
  public int a = 0;
  
  public static aonz a(aoko[] paramArrayOfaoko)
  {
    aonz localaonz = new aonz();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaoko != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramArrayOfaoko.length > 0) {
        localObject1 = paramArrayOfaoko[0].a;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("LebaQzoneStyleBean", 1, "content is empty");
        return localaonz;
      }
      localaonz.a = new JSONObject((String)localObject1).optInt("ifnewstyle", 0);
      QLog.i("LebaQzoneStyleBean", 1, "parse config=" + (String)localObject1 + ",style=" + localaonz.a);
      return localaonz;
    }
    catch (Exception paramArrayOfaoko)
    {
      QLog.i("LebaQzoneStyleBean", 1, "handleLebaConfig parse", paramArrayOfaoko);
    }
    return localaonz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aonz
 * JD-Core Version:    0.7.0.1
 */