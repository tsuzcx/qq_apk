import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class arpd
{
  private HashMap<String, arpe> a = new HashMap();
  
  public static arpd a(araj paramaraj)
  {
    arpd localarpd = new arpd();
    if (paramaraj != null) {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalNavigationConfBean", 2, "parse taskid->" + paramaraj.jdField_a_of_type_Int + " content->" + paramaraj.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaraj = new JSONObject(paramaraj.jdField_a_of_type_JavaLangString);
      Object localObject;
      if (paramaraj.has("emoji"))
      {
        localObject = paramaraj.optJSONObject("emoji");
        if (localObject != null)
        {
          arpe localarpe = new arpe();
          localarpe.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("switch", 0);
          localarpe.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("iconUrl", "");
          localarpe.b = ((JSONObject)localObject).optString("url", "");
          localarpd.a.put("emoji", localarpe);
        }
      }
      if (paramaraj.has("heihua"))
      {
        paramaraj = paramaraj.optJSONObject("heihua");
        if (paramaraj != null)
        {
          localObject = new arpe();
          ((arpe)localObject).jdField_a_of_type_Int = paramaraj.optInt("switch", 0);
          ((arpe)localObject).jdField_a_of_type_JavaLangString = paramaraj.optString("iconUrl", "");
          ((arpe)localObject).b = paramaraj.optString("url", "");
          ((arpe)localObject).c = paramaraj.optString("name", "");
          localarpd.a.put("heihua", localObject);
        }
      }
    }
    catch (Exception paramaraj)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VerticalNavigationConfBean", 2, "parse error->" + paramaraj.toString());
    }
    return localarpd;
    return localarpd;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = (arpe)this.a.get(paramString);
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
      paramString = (arpe)this.a.get(paramString);
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
    paramString = (arpe)this.a.get(paramString);
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
    paramString = (arpe)this.a.get(paramString);
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
 * Qualified Name:     arpd
 * JD-Core Version:    0.7.0.1
 */