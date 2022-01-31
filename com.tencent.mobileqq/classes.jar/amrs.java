import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class amrs
{
  private static volatile amrs jdField_a_of_type_Amrs;
  private LinkedHashMap<String, amrr> jdField_a_of_type_JavaUtilLinkedHashMap;
  
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
  
  private amrr a(String paramString1, String paramString2)
  {
    amrr localamrr = new amrr();
    localamrr.a = paramString1;
    localamrr.b = paramString2;
    if (!localamrr.a()) {
      return null;
    }
    return (amrr)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localamrr.a());
  }
  
  public static amrs a()
  {
    if (jdField_a_of_type_Amrs == null) {}
    try
    {
      if (jdField_a_of_type_Amrs == null)
      {
        jdField_a_of_type_Amrs = new amrs();
        jdField_a_of_type_Amrs.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
        jdField_a_of_type_Amrs.b(jdField_a_of_type_Amrs.a());
      }
      return jdField_a_of_type_Amrs;
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
      paramJSONObject = new amqx(str).a(bhxn.a(paramJSONObject)).toString();
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
    Object localObject = alqy.a("kArkMsgReplyConfig");
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
    amrr localamrr;
    if (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      localamrr = new amrr();
      localamrr.a = localJSONObject.optString("app", "");
      localamrr.b = localJSONObject.optString("view", "");
      localamrr.c = localJSONObject.optString("title", "");
      localamrr.d = localJSONObject.optString("tag", "");
      localamrr.e = localJSONObject.optString("icon", "");
      localamrr.f = localJSONObject.optString("action", "");
      localamrr.g = localJSONObject.optString("jumpURL", "");
      if (localamrr.a()) {
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
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localamrr.a(), localamrr);
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.toString();
    paramJSONObject = str;
    if (TextUtils.isEmpty(str)) {
      paramJSONObject = "{}";
    }
    alqy.a("kArkMsgReplyConfig", paramJSONObject);
  }
  
  public LinkedHashMap a(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("app", "");
    String str2 = paramJSONObject.optString("view", "");
    amrr localamrr = a(str1, str2);
    Object localObject1;
    if (a(localamrr.c))
    {
      localObject1 = a(paramJSONObject, localamrr.c);
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramJSONObject.optString("prompt", "");
      }
      localObject1 = new LinkedHashMap();
      ((LinkedHashMap)localObject1).put("kArkMsgReplyApp", str1);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyView", str2);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyTitle", localObject2);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyTag", localamrr.d);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyIcon", localamrr.e);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyAction", localamrr.f);
      if (!a(localamrr.g)) {
        break label183;
      }
    }
    label183:
    for (paramJSONObject = a(paramJSONObject, localamrr.g);; paramJSONObject = localamrr.g)
    {
      ((LinkedHashMap)localObject1).put("kArkMsgReplyJumpUrl", paramJSONObject);
      return localObject1;
      localObject1 = localamrr.c;
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
 * Qualified Name:     amrs
 * JD-Core Version:    0.7.0.1
 */