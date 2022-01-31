import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class aosd
{
  private HashMap<String, aose> a = new HashMap();
  
  public static aosd a(aogf paramaogf)
  {
    aosd localaosd = new aosd();
    if (paramaogf != null) {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalNavigationConfBean", 2, "parse taskid->" + paramaogf.jdField_a_of_type_Int + " content->" + paramaogf.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaogf = new JSONObject(paramaogf.jdField_a_of_type_JavaLangString);
      Object localObject;
      if (paramaogf.has("emoji"))
      {
        localObject = paramaogf.optJSONObject("emoji");
        if (localObject != null)
        {
          aose localaose = new aose();
          localaose.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("switch", 0);
          localaose.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("iconUrl", "");
          localaose.b = ((JSONObject)localObject).optString("url", "");
          localaosd.a.put("emoji", localaose);
        }
      }
      if (paramaogf.has("wiki"))
      {
        paramaogf = paramaogf.optJSONObject("wiki");
        if (paramaogf != null)
        {
          localObject = new aose();
          ((aose)localObject).jdField_a_of_type_Int = paramaogf.optInt("switch", 0);
          ((aose)localObject).jdField_a_of_type_JavaLangString = paramaogf.optString("iconUrl", "");
          ((aose)localObject).b = paramaogf.optString("url", "");
          localaosd.a.put("wiki", localObject);
        }
      }
    }
    catch (Exception paramaogf)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VerticalNavigationConfBean", 2, "parse error->" + paramaogf.toString());
    }
    return localaosd;
    return localaosd;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = (aose)this.a.get(paramString);
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
      paramString = (aose)this.a.get(paramString);
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
    paramString = (aose)this.a.get(paramString);
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
 * Qualified Name:     aosd
 * JD-Core Version:    0.7.0.1
 */