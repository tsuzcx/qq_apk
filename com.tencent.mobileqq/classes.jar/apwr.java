import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class apwr
{
  private static volatile apwr jdField_a_of_type_Apwr;
  private LinkedHashMap<String, apwq> jdField_a_of_type_JavaUtilLinkedHashMap;
  
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
  
  private apwq a(String paramString1, String paramString2)
  {
    apwq localapwq = new apwq();
    localapwq.a = paramString1;
    localapwq.b = paramString2;
    if (!localapwq.a()) {
      return null;
    }
    return (apwq)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localapwq.a());
  }
  
  public static apwr a()
  {
    if (jdField_a_of_type_Apwr == null) {}
    try
    {
      if (jdField_a_of_type_Apwr == null)
      {
        jdField_a_of_type_Apwr = new apwr();
        jdField_a_of_type_Apwr.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
        jdField_a_of_type_Apwr.b(jdField_a_of_type_Apwr.a());
      }
      return jdField_a_of_type_Apwr;
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
      paramJSONObject = new apvw(str).a(bkys.a(paramJSONObject));
      if (paramJSONObject == null)
      {
        ArkAppCenter.c("ArkMsgReplyConfigMgr", "getContentByPath error: object == null");
        return "";
      }
      paramJSONObject = paramJSONObject.toString();
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
    Object localObject = aoth.a("kArkMsgReplyConfig");
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
    apwq localapwq;
    if (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      localapwq = new apwq();
      localapwq.a = localJSONObject.optString("app", "");
      localapwq.b = localJSONObject.optString("view", "");
      localapwq.c = localJSONObject.optString("title", "");
      localapwq.d = localJSONObject.optString("tag", "");
      localapwq.e = localJSONObject.optString("icon", "");
      localapwq.f = localJSONObject.optString("action", "");
      localapwq.g = localJSONObject.optString("jumpURL", "");
      if (localapwq.a()) {
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
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localapwq.a(), localapwq);
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.toString();
    paramJSONObject = str;
    if (TextUtils.isEmpty(str)) {
      paramJSONObject = "{}";
    }
    aoth.a("kArkMsgReplyConfig", paramJSONObject);
  }
  
  public LinkedHashMap a(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("app", "");
    String str2 = paramJSONObject.optString("view", "");
    apwq localapwq = a(str1, str2);
    if (localapwq == null)
    {
      ArkAppCenter.c("ArkMsgReplyConfigMgr", "getReplyConfigFromMsg: config is null, return empty map");
      return new LinkedHashMap();
    }
    Object localObject1;
    if (a(localapwq.c))
    {
      localObject1 = a(paramJSONObject, localapwq.c);
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramJSONObject.optString("prompt", "");
      }
      localObject1 = new LinkedHashMap();
      ((LinkedHashMap)localObject1).put("kArkMsgReplyApp", str1);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyView", str2);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyTitle", localObject2);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyTag", localapwq.d);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyIcon", localapwq.e);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyAction", localapwq.f);
      if (!a(localapwq.g)) {
        break label203;
      }
    }
    label203:
    for (paramJSONObject = a(paramJSONObject, localapwq.g);; paramJSONObject = localapwq.g)
    {
      ((LinkedHashMap)localObject1).put("kArkMsgReplyJumpUrl", paramJSONObject);
      return localObject1;
      localObject1 = localapwq.c;
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
 * Qualified Name:     apwr
 * JD-Core Version:    0.7.0.1
 */