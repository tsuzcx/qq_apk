import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class aoip
{
  private static volatile aoip jdField_a_of_type_Aoip;
  private LinkedHashMap<String, aoio> jdField_a_of_type_JavaUtilLinkedHashMap;
  
  public static int a(String paramString1, String paramString2)
  {
    if (("com.tencent.structmsg".equals(paramString1)) && ("news".equals(paramString2))) {
      return 11;
    }
    if (("com.tencent.structmsg".equals(paramString1)) && ("video".equals(paramString2))) {
      return 12;
    }
    if (("com.tencent.structmsg".equals(paramString1)) && ("music".equals(paramString2))) {
      return 13;
    }
    if (("com.tencent.map".equals(paramString1)) && ("LocationShare".equals(paramString2))) {
      return 14;
    }
    return 10;
  }
  
  private aoio a(String paramString1, String paramString2)
  {
    aoio localaoio = new aoio();
    localaoio.a = paramString1;
    localaoio.b = paramString2;
    if (!localaoio.a()) {
      return null;
    }
    return (aoio)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localaoio.a());
  }
  
  public static aoip a()
  {
    if (jdField_a_of_type_Aoip == null) {}
    try
    {
      if (jdField_a_of_type_Aoip == null)
      {
        jdField_a_of_type_Aoip = new aoip();
        jdField_a_of_type_Aoip.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
        jdField_a_of_type_Aoip.b(jdField_a_of_type_Aoip.a());
      }
      return jdField_a_of_type_Aoip;
    }
    finally {}
  }
  
  private String a(JSONObject paramJSONObject, String paramString)
  {
    String str = paramString;
    try
    {
      if (a(paramString)) {
        str = paramString.substring("jsonpath:".length());
      }
      paramJSONObject = new aohu(str).a(bjzp.a(paramJSONObject)).toString();
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      ArkAppCenter.c("ArkMsgReplyConfigMgr", "getContentByPath exception");
    }
    return "";
  }
  
  private JSONObject a()
  {
    Object localObject = anhp.a("kArkMsgReplyConfig");
    try
    {
      localObject = new JSONObject((String)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      ArkAppCenter.c("ArkMsgReplyConfigMgr", "loadConfig exception");
    }
    return null;
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.startsWith("jsonpath:")) {
      return false;
    }
    return true;
  }
  
  private void b(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    if (paramJSONObject == null) {}
    do
    {
      return;
      paramJSONObject = paramJSONObject.optJSONArray("messageReplyConfig");
      QLog.i("ArkMsgReplyConfigMgr", 1, "ArkMsgReplyConfigMgr=" + paramJSONObject);
    } while (paramJSONObject == null);
    int i = 0;
    label47:
    aoio localaoio;
    if (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      localaoio = new aoio();
      localaoio.a = localJSONObject.optString("app", "");
      localaoio.b = localJSONObject.optString("view", "");
      localaoio.c = localJSONObject.optString("title", "");
      localaoio.d = localJSONObject.optString("tag", "");
      localaoio.e = localJSONObject.optString("icon", "");
      localaoio.f = localJSONObject.optString("action", "");
      localaoio.g = localJSONObject.optString("jumpURL", "");
      if (localaoio.a()) {
        break label183;
      }
      ArkAppCenter.c("ArkMsgReplyConfigMgr", "parseConfig, item is invalid");
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label183:
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localaoio.a(), localaoio);
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.toString();
    paramJSONObject = str;
    if (TextUtils.isEmpty(str)) {
      paramJSONObject = "{}";
    }
    anhp.a("kArkMsgReplyConfig", paramJSONObject);
  }
  
  public LinkedHashMap a(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("app", "");
    String str2 = paramJSONObject.optString("view", "");
    aoio localaoio = a(str1, str2);
    Object localObject1;
    if (a(localaoio.c))
    {
      localObject1 = a(paramJSONObject, localaoio.c);
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramJSONObject.optString("prompt", "");
      }
      localObject1 = new LinkedHashMap();
      ((LinkedHashMap)localObject1).put("kArkMsgReplyApp", str1);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyView", str2);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyTitle", localObject2);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyTag", localaoio.d);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyIcon", localaoio.e);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyAction", localaoio.f);
      if (!a(localaoio.g)) {
        break label183;
      }
    }
    label183:
    for (paramJSONObject = a(paramJSONObject, localaoio.g);; paramJSONObject = localaoio.g)
    {
      ((LinkedHashMap)localObject1).put("kArkMsgReplyJumpUrl", paramJSONObject);
      return localObject1;
      localObject1 = localaoio.c;
      break;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    b(paramJSONObject);
    c(paramJSONObject);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoip
 * JD-Core Version:    0.7.0.1
 */