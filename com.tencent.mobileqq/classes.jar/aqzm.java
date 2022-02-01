import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class aqzm
{
  private HashMap<String, aqzn> a = new HashMap();
  
  public static aqzm a(aqlg paramaqlg)
  {
    aqzm localaqzm = new aqzm();
    if (paramaqlg != null) {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalNavigationConfBean", 2, "parse taskid->" + paramaqlg.jdField_a_of_type_Int + " content->" + paramaqlg.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaqlg = new JSONObject(paramaqlg.jdField_a_of_type_JavaLangString);
      Object localObject;
      if (paramaqlg.has("emoji"))
      {
        localObject = paramaqlg.optJSONObject("emoji");
        if (localObject != null)
        {
          aqzn localaqzn = new aqzn();
          localaqzn.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("switch", 0);
          localaqzn.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("iconUrl", "");
          localaqzn.b = ((JSONObject)localObject).optString("url", "");
          localaqzm.a.put("emoji", localaqzn);
        }
      }
      if (paramaqlg.has("heihua"))
      {
        paramaqlg = paramaqlg.optJSONObject("heihua");
        if (paramaqlg != null)
        {
          localObject = new aqzn();
          ((aqzn)localObject).jdField_a_of_type_Int = paramaqlg.optInt("switch", 0);
          ((aqzn)localObject).jdField_a_of_type_JavaLangString = paramaqlg.optString("iconUrl", "");
          ((aqzn)localObject).b = paramaqlg.optString("url", "");
          ((aqzn)localObject).c = paramaqlg.optString("name", "");
          localaqzm.a.put("heihua", localObject);
        }
      }
    }
    catch (Exception paramaqlg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VerticalNavigationConfBean", 2, "parse error->" + paramaqlg.toString());
    }
    return localaqzm;
    return localaqzm;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = (aqzn)this.a.get(paramString);
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
      paramString = (aqzn)this.a.get(paramString);
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
    paramString = (aqzn)this.a.get(paramString);
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
    paramString = (aqzn)this.a.get(paramString);
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
 * Qualified Name:     aqzm
 * JD-Core Version:    0.7.0.1
 */