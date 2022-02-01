import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqnw
{
  private static volatile aqnw jdField_a_of_type_Aqnw;
  private LinkedHashMap<String, aqnv> jdField_a_of_type_JavaUtilLinkedHashMap;
  
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
  
  private aqnv a(String paramString1, String paramString2)
  {
    aqnv localaqnv = new aqnv();
    localaqnv.a = paramString1;
    localaqnv.b = paramString2;
    if (!localaqnv.a()) {
      return null;
    }
    return (aqnv)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localaqnv.a());
  }
  
  public static aqnw a()
  {
    if (jdField_a_of_type_Aqnw == null) {}
    try
    {
      if (jdField_a_of_type_Aqnw == null)
      {
        jdField_a_of_type_Aqnw = new aqnw();
        jdField_a_of_type_Aqnw.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
        jdField_a_of_type_Aqnw.b(jdField_a_of_type_Aqnw.a());
      }
      return jdField_a_of_type_Aqnw;
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
      paramJSONObject = new aqnb(str).a(bmsg.a(paramJSONObject)).toString();
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
    Object localObject = apme.a("kArkMsgReplyConfig");
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
    aqnv localaqnv;
    if (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      localaqnv = new aqnv();
      localaqnv.a = localJSONObject.optString("app", "");
      localaqnv.b = localJSONObject.optString("view", "");
      localaqnv.c = localJSONObject.optString("title", "");
      localaqnv.d = localJSONObject.optString("tag", "");
      localaqnv.e = localJSONObject.optString("icon", "");
      localaqnv.f = localJSONObject.optString("action", "");
      localaqnv.g = localJSONObject.optString("jumpURL", "");
      if (localaqnv.a()) {
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
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localaqnv.a(), localaqnv);
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.toString();
    paramJSONObject = str;
    if (TextUtils.isEmpty(str)) {
      paramJSONObject = "{}";
    }
    apme.a("kArkMsgReplyConfig", paramJSONObject);
  }
  
  public LinkedHashMap a(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("app", "");
    String str2 = paramJSONObject.optString("view", "");
    aqnv localaqnv = a(str1, str2);
    Object localObject1;
    if (a(localaqnv.c))
    {
      localObject1 = a(paramJSONObject, localaqnv.c);
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramJSONObject.optString("prompt", "");
      }
      localObject1 = new LinkedHashMap();
      ((LinkedHashMap)localObject1).put("kArkMsgReplyApp", str1);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyView", str2);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyTitle", localObject2);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyTag", localaqnv.d);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyIcon", localaqnv.e);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyAction", localaqnv.f);
      if (!a(localaqnv.g)) {
        break label183;
      }
    }
    label183:
    for (paramJSONObject = a(paramJSONObject, localaqnv.g);; paramJSONObject = localaqnv.g)
    {
      ((LinkedHashMap)localObject1).put("kArkMsgReplyJumpUrl", paramJSONObject);
      return localObject1;
      localObject1 = localaqnv.c;
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
 * Qualified Name:     aqnw
 * JD-Core Version:    0.7.0.1
 */