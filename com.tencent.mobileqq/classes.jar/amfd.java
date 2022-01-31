import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class amfd
{
  public int a;
  public ConcurrentHashMap<String, String> a;
  public int b;
  public int c = 1;
  
  public amfd()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
  }
  
  public static amfd a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    amfd localamfd;
    try
    {
      localamfd = new amfd();
      paramString = new JSONObject(paramString);
      localamfd.jdField_a_of_type_Int = paramString.optInt("kCheckSignatureSwitch", 0);
      localamfd.b = paramString.optInt("kDisableChooseSwitch", 0);
      localamfd.c = paramString.optInt("kShowKickDialog", 1);
      paramString = paramString.optJSONObject("kSignatureList");
      if (paramString != null)
      {
        Iterator localIterator = paramString.keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = paramString.optString(str1);
          if (!TextUtils.isEmpty(str2))
          {
            localamfd.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, str2);
            if (QLog.isColorLevel()) {
              QLog.d("QuickAuthorityConfProcessor", 2, new Object[] { "package: ", str1, " signature:", str2 });
            }
          }
        }
      }
      QLog.d("QuickAuthorityConfProcessor", 2, "confBean = " + localamfd.toString());
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QuickAuthorityConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
      }
      return null;
    }
    return localamfd;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("kCheckSignatureSwitch:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" kDisableChooseSwitch:").append(this.b);
    localStringBuilder.append(" signatureMaps:").append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amfd
 * JD-Core Version:    0.7.0.1
 */