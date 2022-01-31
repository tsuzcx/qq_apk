import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class amvt
{
  public int a;
  public String a;
  public HashMap<String, String> a;
  public String b = "";
  
  public amvt()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static amvt a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    amvt localamvt;
    try
    {
      localamvt = new amvt();
      localamvt.jdField_a_of_type_JavaLangString = paramString;
      paramString = new JSONObject(paramString);
      localamvt.jdField_a_of_type_Int = paramString.optInt("isShowEntry");
      localamvt.b = paramString.optString("iconUrl");
      if (!TextUtils.isEmpty(localamvt.b)) {
        localamvt.b = localamvt.b.trim();
      }
      paramString = paramString.optJSONObject("grayTips");
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localamvt.jdField_a_of_type_JavaUtilHashMap.put(str, paramString.optString(str));
      }
      QLog.d("ConfBean", 0, "confBean = " + localamvt.toString());
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ConfBean", 1, "parse e:", paramString);
      }
      return null;
    }
    return localamvt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("configContent:").append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amvt
 * JD-Core Version:    0.7.0.1
 */