import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class aomx
{
  public int a;
  public String a;
  public HashMap<String, String> a;
  public String b = "";
  
  public aomx()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static aomx a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    aomx localaomx;
    try
    {
      localaomx = new aomx();
      localaomx.jdField_a_of_type_JavaLangString = paramString;
      paramString = new JSONObject(paramString);
      localaomx.jdField_a_of_type_Int = paramString.optInt("isShowEntry");
      localaomx.b = paramString.optString("iconUrl");
      if (!TextUtils.isEmpty(localaomx.b)) {
        localaomx.b = localaomx.b.trim();
      }
      paramString = paramString.optJSONObject("grayTips");
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localaomx.jdField_a_of_type_JavaUtilHashMap.put(str, paramString.optString(str));
      }
      QLog.d("ConfBean", 0, "confBean = " + localaomx.toString());
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ConfBean", 1, "parse e:", paramString);
      }
      return null;
    }
    return localaomx;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("configContent:").append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aomx
 * JD-Core Version:    0.7.0.1
 */