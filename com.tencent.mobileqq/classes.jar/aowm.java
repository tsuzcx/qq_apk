import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class aowm
{
  private HashMap<String, aown> a = new HashMap();
  
  public static aowm a(aoko paramaoko)
  {
    aowm localaowm = new aowm();
    if (paramaoko != null) {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalNavigationConfBean", 2, "parse taskid->" + paramaoko.jdField_a_of_type_Int + " content->" + paramaoko.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaoko = new JSONObject(paramaoko.jdField_a_of_type_JavaLangString);
      Object localObject;
      if (paramaoko.has("emoji"))
      {
        localObject = paramaoko.optJSONObject("emoji");
        if (localObject != null)
        {
          aown localaown = new aown();
          localaown.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("switch", 0);
          localaown.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("iconUrl", "");
          localaown.b = ((JSONObject)localObject).optString("url", "");
          localaowm.a.put("emoji", localaown);
        }
      }
      if (paramaoko.has("wiki"))
      {
        paramaoko = paramaoko.optJSONObject("wiki");
        if (paramaoko != null)
        {
          localObject = new aown();
          ((aown)localObject).jdField_a_of_type_Int = paramaoko.optInt("switch", 0);
          ((aown)localObject).jdField_a_of_type_JavaLangString = paramaoko.optString("iconUrl", "");
          ((aown)localObject).b = paramaoko.optString("url", "");
          localaowm.a.put("wiki", localObject);
        }
      }
    }
    catch (Exception paramaoko)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VerticalNavigationConfBean", 2, "parse error->" + paramaoko.toString());
    }
    return localaowm;
    return localaowm;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = (aown)this.a.get(paramString);
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
      paramString = (aown)this.a.get(paramString);
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
    paramString = (aown)this.a.get(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_JavaLangString;
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
 * Qualified Name:     aowm
 * JD-Core Version:    0.7.0.1
 */