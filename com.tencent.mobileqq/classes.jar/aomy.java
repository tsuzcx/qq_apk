import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class aomy
{
  private static volatile aomy jdField_a_of_type_Aomy;
  private LinkedHashMap<String, aomx> jdField_a_of_type_JavaUtilLinkedHashMap;
  
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
  
  private aomx a(String paramString1, String paramString2)
  {
    aomx localaomx = new aomx();
    localaomx.a = paramString1;
    localaomx.b = paramString2;
    if (!localaomx.a()) {
      return null;
    }
    return (aomx)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localaomx.a());
  }
  
  public static aomy a()
  {
    if (jdField_a_of_type_Aomy == null) {}
    try
    {
      if (jdField_a_of_type_Aomy == null)
      {
        jdField_a_of_type_Aomy = new aomy();
        jdField_a_of_type_Aomy.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
        jdField_a_of_type_Aomy.b(jdField_a_of_type_Aomy.a());
      }
      return jdField_a_of_type_Aomy;
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
      paramJSONObject = new aomd(str).a(bkdw.a(paramJSONObject)).toString();
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
    Object localObject = anly.a("kArkMsgReplyConfig");
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
    aomx localaomx;
    if (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      localaomx = new aomx();
      localaomx.a = localJSONObject.optString("app", "");
      localaomx.b = localJSONObject.optString("view", "");
      localaomx.c = localJSONObject.optString("title", "");
      localaomx.d = localJSONObject.optString("tag", "");
      localaomx.e = localJSONObject.optString("icon", "");
      localaomx.f = localJSONObject.optString("action", "");
      localaomx.g = localJSONObject.optString("jumpURL", "");
      if (localaomx.a()) {
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
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localaomx.a(), localaomx);
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.toString();
    paramJSONObject = str;
    if (TextUtils.isEmpty(str)) {
      paramJSONObject = "{}";
    }
    anly.a("kArkMsgReplyConfig", paramJSONObject);
  }
  
  public LinkedHashMap a(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("app", "");
    String str2 = paramJSONObject.optString("view", "");
    aomx localaomx = a(str1, str2);
    Object localObject1;
    if (a(localaomx.c))
    {
      localObject1 = a(paramJSONObject, localaomx.c);
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramJSONObject.optString("prompt", "");
      }
      localObject1 = new LinkedHashMap();
      ((LinkedHashMap)localObject1).put("kArkMsgReplyApp", str1);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyView", str2);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyTitle", localObject2);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyTag", localaomx.d);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyIcon", localaomx.e);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyAction", localaomx.f);
      if (!a(localaomx.g)) {
        break label183;
      }
    }
    label183:
    for (paramJSONObject = a(paramJSONObject, localaomx.g);; paramJSONObject = localaomx.g)
    {
      ((LinkedHashMap)localObject1).put("kArkMsgReplyJumpUrl", paramJSONObject);
      return localObject1;
      localObject1 = localaomx.c;
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
 * Qualified Name:     aomy
 * JD-Core Version:    0.7.0.1
 */