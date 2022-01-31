import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class bgun
  extends ApkgBaseInfo
{
  public HashMap<String, String> a;
  public JSONObject a;
  
  public bgun(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    super(paramString, paramMiniAppBaseInfo);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static bgun a(String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!new File(paramString1).exists())) {
      return null;
    }
    paramString1 = new bgun(paramString1, paramMiniAppInfo);
    paramString1.init(paramString2);
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
  
  public void a(MiniAppInfo paramMiniAppInfo, String paramString, bgum parambgum)
  {
    bgud.a(paramMiniAppInfo, this, paramString, parambgum);
  }
  
  public String getRootPath(String paramString)
  {
    if (bglo.a(paramString)) {
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
  
  public String getWorkerPath(String paramString1, String paramString2)
  {
    return null;
  }
  
  public void init(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        this.mConfigStr = bgkv.b(new File(getApkgFolderPath() + "/" + paramString, "game.json"));
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(this.mConfigStr);
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
      this.mConfigStr = bgkv.b(new File(getApkgFolderPath(), "game.json"));
    }
  }
  
  public boolean isUrlResReady(String paramString, MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgun
 * JD-Core Version:    0.7.0.1
 */