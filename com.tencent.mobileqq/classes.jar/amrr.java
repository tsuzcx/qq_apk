import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class amrr
{
  private static volatile amrr jdField_a_of_type_Amrr;
  private LinkedHashMap<String, amrq> jdField_a_of_type_JavaUtilLinkedHashMap;
  
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
  
  private amrq a(String paramString1, String paramString2)
  {
    amrq localamrq = new amrq();
    localamrq.a = paramString1;
    localamrq.b = paramString2;
    if (!localamrq.a()) {
      return null;
    }
    return (amrq)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localamrq.a());
  }
  
  public static amrr a()
  {
    if (jdField_a_of_type_Amrr == null) {}
    try
    {
      if (jdField_a_of_type_Amrr == null)
      {
        jdField_a_of_type_Amrr = new amrr();
        jdField_a_of_type_Amrr.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
        jdField_a_of_type_Amrr.b(jdField_a_of_type_Amrr.a());
      }
      return jdField_a_of_type_Amrr;
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
      paramJSONObject = new amqw(str).a(bhye.a(paramJSONObject)).toString();
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
    Object localObject = alqx.a("kArkMsgReplyConfig");
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
    amrq localamrq;
    if (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      localamrq = new amrq();
      localamrq.a = localJSONObject.optString("app", "");
      localamrq.b = localJSONObject.optString("view", "");
      localamrq.c = localJSONObject.optString("title", "");
      localamrq.d = localJSONObject.optString("tag", "");
      localamrq.e = localJSONObject.optString("icon", "");
      localamrq.f = localJSONObject.optString("action", "");
      localamrq.g = localJSONObject.optString("jumpURL", "");
      if (localamrq.a()) {
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
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localamrq.a(), localamrq);
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.toString();
    paramJSONObject = str;
    if (TextUtils.isEmpty(str)) {
      paramJSONObject = "{}";
    }
    alqx.a("kArkMsgReplyConfig", paramJSONObject);
  }
  
  public LinkedHashMap a(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("app", "");
    String str2 = paramJSONObject.optString("view", "");
    amrq localamrq = a(str1, str2);
    Object localObject1;
    if (a(localamrq.c))
    {
      localObject1 = a(paramJSONObject, localamrq.c);
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramJSONObject.optString("prompt", "");
      }
      localObject1 = new LinkedHashMap();
      ((LinkedHashMap)localObject1).put("kArkMsgReplyApp", str1);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyView", str2);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyTitle", localObject2);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyTag", localamrq.d);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyIcon", localamrq.e);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyAction", localamrq.f);
      if (!a(localamrq.g)) {
        break label183;
      }
    }
    label183:
    for (paramJSONObject = a(paramJSONObject, localamrq.g);; paramJSONObject = localamrq.g)
    {
      ((LinkedHashMap)localObject1).put("kArkMsgReplyJumpUrl", paramJSONObject);
      return localObject1;
      localObject1 = localamrq.c;
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
 * Qualified Name:     amrr
 * JD-Core Version:    0.7.0.1
 */