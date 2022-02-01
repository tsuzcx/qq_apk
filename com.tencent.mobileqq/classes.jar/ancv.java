import android.text.TextUtils;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class ancv
{
  private static final HashMap<String, Integer> a = new HashMap();
  private static final HashMap<String, String> b = new HashMap();
  
  public static int a(String paramString)
  {
    Integer localInteger = (Integer)a.get(paramString);
    if (localInteger != null)
    {
      QLog.i("CmShow_CmShowDataHelper", 1, "getCmShowModel uin:" + paramString + " model:" + localInteger);
      return localInteger.intValue();
    }
    return 0;
  }
  
  public static String a(CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    if (paramPlayActionConfig == null) {
      return null;
    }
    Object localObject = (String)b.get(paramPlayActionConfig.a());
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    for (;;)
    {
      int i;
      JSONObject localJSONObject;
      String str4;
      try
      {
        localObject = new JSONObject((String)localObject);
        ((JSONObject)localObject).put("loop", paramPlayActionConfig.a);
        ((JSONObject)localObject).put("needRestore", paramPlayActionConfig.jdField_b_of_type_Boolean);
        ((JSONObject)localObject).put("taskId", paramPlayActionConfig.jdField_b_of_type_Int);
        JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("sprites");
        int j = localJSONArray.length();
        i = 0;
        if (i >= j) {
          break label262;
        }
        localJSONObject = localJSONArray.optJSONObject(i);
        String str1 = localJSONObject.optString("action");
        String str2 = localJSONObject.optString("preAction");
        String str3 = localJSONObject.optString("mainAction");
        str4 = localJSONObject.optString("postAction");
        if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4))) {
          break label269;
        }
        if (paramPlayActionConfig.c == 1) {
          localJSONObject.put("action", str2);
        } else if (paramPlayActionConfig.c == 2) {
          localJSONObject.put("action", str3);
        }
      }
      catch (Exception paramPlayActionConfig)
      {
        QLog.e("CmShow_CmShowDataHelper", 1, "getCacheActionJs e:" + paramPlayActionConfig);
        return null;
      }
      if (paramPlayActionConfig.c == 3)
      {
        localJSONObject.put("action", str4);
        break label271;
        label262:
        paramPlayActionConfig = ((JSONObject)localObject).toString();
        return paramPlayActionConfig;
        label269:
        return null;
      }
      label271:
      i += 1;
    }
  }
  
  public static void a()
  {
    b.clear();
    a.clear();
  }
  
  public static void a(CmShowRenderView.PlayActionConfig paramPlayActionConfig, String paramString)
  {
    if (paramPlayActionConfig == null) {
      return;
    }
    b.put(paramPlayActionConfig.a(), paramString);
  }
  
  public static void a(String paramString, int paramInt)
  {
    QLog.i("CmShow_CmShowDataHelper", 1, "setCmshowModel uin:" + paramString + " model:" + paramInt);
    a.put(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ancv
 * JD-Core Version:    0.7.0.1
 */