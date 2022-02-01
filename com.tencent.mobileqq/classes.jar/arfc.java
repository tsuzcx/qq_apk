import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.QuickAuthorityConfBean.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class arfc
{
  public int a;
  public ConcurrentHashMap<String, String> a;
  public int b;
  public int c = 1;
  public int d;
  public int e;
  
  public arfc()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
  }
  
  public static arfc a(String paramString)
  {
    arfc localarfc = new arfc();
    if (paramString == null) {
      return localarfc;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localarfc.jdField_a_of_type_Int = paramString.optInt("kCheckSignatureSwitch", 0);
      localarfc.b = paramString.optInt("kDisableChooseSwitch", 0);
      localarfc.c = paramString.optInt("kShowKickDialog", 1);
      localarfc.d = paramString.optInt("kFDHookSwitch", 0);
      localarfc.e = paramString.optInt("kWtloginPowTest", 0);
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
            localarfc.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, str2);
            if (QLog.isColorLevel()) {
              QLog.d("QuickAuthorityConfProcessor", 2, new Object[] { "package: ", str1, " signature:", str2 });
            }
          }
        }
      }
      QLog.d("QuickAuthorityConfProcessor", 2, "confBean = " + localarfc.toString());
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QuickAuthorityConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
      }
      return null;
    }
    if (localarfc.e == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ThreadManagerV2.executeOnSubThread(new QuickAuthorityConfBean.1(bool));
      return localarfc;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("kCheckSignatureSwitch:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" kDisableChooseSwitch:").append(this.b);
    localStringBuilder.append(" signatureMaps:").append(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    localStringBuilder.append(" fdSwitch:").append(this.d);
    localStringBuilder.append(" wtloginPowTest:").append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfc
 * JD-Core Version:    0.7.0.1
 */