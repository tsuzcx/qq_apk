import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class amfn
{
  public int a;
  public String a;
  public HashMap<String, String> a;
  public String b = "";
  
  public amfn()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static amfn a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    amfn localamfn;
    try
    {
      localamfn = new amfn();
      localamfn.jdField_a_of_type_JavaLangString = paramString;
      paramString = new JSONObject(paramString);
      localamfn.jdField_a_of_type_Int = paramString.optInt("isShowEntry");
      localamfn.b = paramString.optString("iconUrl");
      if (!TextUtils.isEmpty(localamfn.b)) {
        localamfn.b = localamfn.b.trim();
      }
      paramString = paramString.optJSONObject("grayTips");
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localamfn.jdField_a_of_type_JavaUtilHashMap.put(str, paramString.optString(str));
      }
      QLog.d("ConfBean", 0, "confBean = " + localamfn.toString());
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ConfBean", 1, "parse e:", paramString);
      }
      return null;
    }
    return localamfn;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("configContent:").append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amfn
 * JD-Core Version:    0.7.0.1
 */