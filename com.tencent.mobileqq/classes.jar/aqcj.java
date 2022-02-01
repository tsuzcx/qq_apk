import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class aqcj
{
  public int a;
  public String a;
  public HashMap<String, String> a;
  public String b = "";
  
  public aqcj()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static aqcj a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    aqcj localaqcj;
    try
    {
      localaqcj = new aqcj();
      localaqcj.jdField_a_of_type_JavaLangString = paramString;
      paramString = new JSONObject(paramString);
      localaqcj.jdField_a_of_type_Int = paramString.optInt("isShowEntry");
      localaqcj.b = paramString.optString("iconUrl");
      if (!TextUtils.isEmpty(localaqcj.b)) {
        localaqcj.b = localaqcj.b.trim();
      }
      paramString = paramString.optJSONObject("grayTips");
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localaqcj.jdField_a_of_type_JavaUtilHashMap.put(str, paramString.optString(str));
      }
      QLog.d("ConfBean", 0, "confBean = " + localaqcj.toString());
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ConfBean", 1, "parse e:", paramString);
      }
      return null;
    }
    return localaqcj;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("configContent:").append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqcj
 * JD-Core Version:    0.7.0.1
 */