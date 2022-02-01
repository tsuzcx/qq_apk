import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class aqjb
{
  private HashMap<String, aqjc> a = new HashMap();
  
  public static aqjb a(aptx paramaptx)
  {
    aqjb localaqjb = new aqjb();
    if (paramaptx != null) {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalNavigationConfBean", 2, "parse taskid->" + paramaptx.jdField_a_of_type_Int + " content->" + paramaptx.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaptx = new JSONObject(paramaptx.jdField_a_of_type_JavaLangString);
      Object localObject;
      if (paramaptx.has("emoji"))
      {
        localObject = paramaptx.optJSONObject("emoji");
        if (localObject != null)
        {
          aqjc localaqjc = new aqjc();
          localaqjc.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("switch", 0);
          localaqjc.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("iconUrl", "");
          localaqjc.b = ((JSONObject)localObject).optString("url", "");
          localaqjb.a.put("emoji", localaqjc);
        }
      }
      if (paramaptx.has("heihua"))
      {
        paramaptx = paramaptx.optJSONObject("heihua");
        if (paramaptx != null)
        {
          localObject = new aqjc();
          ((aqjc)localObject).jdField_a_of_type_Int = paramaptx.optInt("switch", 0);
          ((aqjc)localObject).jdField_a_of_type_JavaLangString = paramaptx.optString("iconUrl", "");
          ((aqjc)localObject).b = paramaptx.optString("url", "");
          ((aqjc)localObject).c = paramaptx.optString("name", "");
          localaqjb.a.put("heihua", localObject);
        }
      }
    }
    catch (Exception paramaptx)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VerticalNavigationConfBean", 2, "parse error->" + paramaptx.toString());
    }
    return localaqjb;
    return localaqjb;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = (aqjc)this.a.get(paramString);
    if (paramString != null) {
      return paramString.b;
    }
    return "";
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = (aqjc)this.a.get(paramString);
    } while (paramString == null);
    if (paramString.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = (aqjc)this.a.get(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = (aqjc)this.a.get(paramString);
    if (paramString != null) {
      return paramString.c;
    }
    return "";
  }
  
  public String toString()
  {
    if (this.a != null) {}
    for (String str = this.a.toString();; str = "null") {
      return String.format("mConfigData:%s ", new Object[] { str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqjb
 * JD-Core Version:    0.7.0.1
 */