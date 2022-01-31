import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class aorg
{
  public int a;
  public String a;
  public HashMap<String, String> a;
  public String b = "";
  
  public aorg()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static aorg a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    aorg localaorg;
    try
    {
      localaorg = new aorg();
      localaorg.jdField_a_of_type_JavaLangString = paramString;
      paramString = new JSONObject(paramString);
      localaorg.jdField_a_of_type_Int = paramString.optInt("isShowEntry");
      localaorg.b = paramString.optString("iconUrl");
      if (!TextUtils.isEmpty(localaorg.b)) {
        localaorg.b = localaorg.b.trim();
      }
      paramString = paramString.optJSONObject("grayTips");
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localaorg.jdField_a_of_type_JavaUtilHashMap.put(str, paramString.optString(str));
      }
      QLog.d("ConfBean", 0, "confBean = " + localaorg.toString());
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ConfBean", 1, "parse e:", paramString);
      }
      return null;
    }
    return localaorg;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("configContent:").append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aorg
 * JD-Core Version:    0.7.0.1
 */