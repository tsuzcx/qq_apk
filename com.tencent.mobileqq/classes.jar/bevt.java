import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class bevt
  extends berk
{
  public HashMap<String, String> a;
  public JSONObject a;
  
  public bevt(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    super(paramString, paramMiniAppBaseInfo);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static bevt a(String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!new File(paramString1).exists())) {
      return null;
    }
    paramString1 = new bevt(paramString1, paramMiniAppInfo);
    paramString1.a(paramString2);
    return paramString1;
  }
  
  private static HashMap<String, String> a(JSONArray paramJSONArray)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.optJSONObject(i);
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).optString("name");
          localObject = ((JSONObject)localObject).optString("root");
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
            localHashMap.put(str, localObject);
          }
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        this.b = belh.b(new File(e() + "/" + paramString, "game.json"));
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(this.b);
        JSONArray localJSONArray = this.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("subpackages");
        paramString = localJSONArray;
        if (localJSONArray == null) {
          paramString = this.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("subPackages");
        }
        this.jdField_a_of_type_JavaUtilHashMap = a(paramString);
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
      this.b = belh.b(new File(e(), "game.json"));
    }
  }
  
  public void a(String paramString, bevs parambevs)
  {
    bevk.a(beqy.a().a(), this, paramString, parambevs);
  }
  
  public String c(String paramString)
  {
    if (bely.a(paramString)) {
      return "";
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
        return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsValue(paramString)) {
        return paramString;
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bevt
 * JD-Core Version:    0.7.0.1
 */