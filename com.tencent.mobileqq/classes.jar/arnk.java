import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class arnk
{
  private static String jdField_a_of_type_JavaLangString = "skin_leba_tongyong_bg";
  public static HashMap<String, String> a;
  private static String b = "https://zb.vip.qq.com/v2/pages/themeMall?_wv=16778243&from=themeIcon";
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  @NonNull
  public static arnk a(String paramString)
  {
    arnk localarnk = new arnk();
    if (TextUtils.isEmpty(paramString))
    {
      localarnk.jdField_a_of_type_Boolean = false;
      return localarnk;
    }
    localarnk.jdField_a_of_type_Boolean = true;
    a(paramString);
    return localarnk;
  }
  
  private static void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONObject("android");
      JSONObject localJSONObject = paramString.getJSONObject("backgroundIconConfig");
      if (localJSONObject != null)
      {
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          jdField_a_of_type_JavaUtilHashMap.put(str, localJSONObject.getString(str));
        }
      }
      jdField_a_of_type_JavaLangString = paramString.getString("defaultIconName");
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    b = paramString.getString("themeStoreUrl");
  }
  
  public String a()
  {
    return b;
  }
  
  public String a(String paramString)
  {
    String str = (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = jdField_a_of_type_JavaLangString;
    }
    return paramString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arnk
 * JD-Core Version:    0.7.0.1
 */