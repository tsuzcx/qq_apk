import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class armm
{
  private HashMap<String, armn> a = new HashMap();
  
  public static armm a(aqxa paramaqxa)
  {
    armm localarmm = new armm();
    if (paramaqxa != null) {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalNavigationConfBean", 2, "parse taskid->" + paramaqxa.jdField_a_of_type_Int + " content->" + paramaqxa.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaqxa = new JSONObject(paramaqxa.jdField_a_of_type_JavaLangString);
      Object localObject;
      if (paramaqxa.has("emoji"))
      {
        localObject = paramaqxa.optJSONObject("emoji");
        if (localObject != null)
        {
          armn localarmn = new armn();
          localarmn.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("switch", 0);
          localarmn.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("iconUrl", "");
          localarmn.b = ((JSONObject)localObject).optString("url", "");
          localarmm.a.put("emoji", localarmn);
        }
      }
      if (paramaqxa.has("heihua"))
      {
        paramaqxa = paramaqxa.optJSONObject("heihua");
        if (paramaqxa != null)
        {
          localObject = new armn();
          ((armn)localObject).jdField_a_of_type_Int = paramaqxa.optInt("switch", 0);
          ((armn)localObject).jdField_a_of_type_JavaLangString = paramaqxa.optString("iconUrl", "");
          ((armn)localObject).b = paramaqxa.optString("url", "");
          ((armn)localObject).c = paramaqxa.optString("name", "");
          localarmm.a.put("heihua", localObject);
        }
      }
    }
    catch (Exception paramaqxa)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VerticalNavigationConfBean", 2, "parse error->" + paramaqxa.toString());
    }
    return localarmm;
    return localarmm;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = (armn)this.a.get(paramString);
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
      paramString = (armn)this.a.get(paramString);
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
    paramString = (armn)this.a.get(paramString);
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
    paramString = (armn)this.a.get(paramString);
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
 * Qualified Name:     armm
 * JD-Core Version:    0.7.0.1
 */