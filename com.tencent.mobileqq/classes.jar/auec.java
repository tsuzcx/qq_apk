import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class auec
{
  public static auea a(Intent paramIntent)
  {
    String[] arrayOfString1 = null;
    int j = 0;
    if ((paramIntent == null) || (!paramIntent.hasExtra("q_qssistant_str_name"))) {
      return null;
    }
    auea localauea = aueb.a(paramIntent.getStringExtra("q_qssistant_openaction"));
    localauea.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("q_qssistant_str_name");
    localauea.b = paramIntent.getStringExtra("q_qssistant_str_scheme");
    localauea.e = paramIntent.getStringExtra("q_qssistant_str_package");
    localauea.c = paramIntent.getStringExtra("q_qssistant_str_server");
    localauea.d = paramIntent.getStringExtra("q_qssistant_str_action");
    localauea.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("q_qssistant_openenable", false);
    localauea.g = paramIntent.getStringExtra("q_qssistant_jump_host");
    if (paramIntent.hasExtra("q_qssistant_extra_field_key"))
    {
      String[] arrayOfString2 = paramIntent.getStringArrayExtra("q_qssistant_extra_field_key");
      int i = j;
      if (paramIntent.hasExtra("q_qssistant_extra_field_value"))
      {
        arrayOfString1 = paramIntent.getStringArrayExtra("q_qssistant_extra_field_value");
        i = j;
      }
      if (i < arrayOfString2.length)
      {
        HashMap localHashMap = localauea.jdField_a_of_type_JavaUtilHashMap;
        String str = arrayOfString2[i];
        if ((arrayOfString1 == null) || (arrayOfString1.length <= i)) {}
        for (paramIntent = "";; paramIntent = arrayOfString1[i])
        {
          localHashMap.put(str, paramIntent);
          i += 1;
          break;
        }
      }
    }
    return localauea;
  }
  
  public static auea a(JSONObject paramJSONObject)
  {
    int i = 0;
    if ((paramJSONObject == null) || (!paramJSONObject.has("str_name"))) {
      return null;
    }
    Object localObject = paramJSONObject.optString("str_name", "");
    String str1 = paramJSONObject.optString("str_scheme", "");
    String str2 = paramJSONObject.optString("str_server", "");
    String str3 = paramJSONObject.optString("str_action", "");
    String str4 = paramJSONObject.optString("str_package", "");
    boolean bool = paramJSONObject.optBoolean("openenable", false);
    String str5 = paramJSONObject.optString("openaction", "");
    auea localauea = aueb.a(str5);
    localauea.jdField_a_of_type_JavaLangString = ((String)localObject);
    if (!baip.a(str1)) {
      localauea.b = str1;
    }
    if (!baip.a(str2)) {
      localauea.c = str2;
    }
    if (!baip.a(str3)) {
      localauea.d = str3;
    }
    if (!baip.a(str4)) {
      localauea.e = str4;
    }
    localauea.jdField_a_of_type_Boolean = bool;
    if (!baip.a(str5)) {
      localauea.f = str5;
    }
    if (paramJSONObject.has("extra_field_key"))
    {
      localObject = paramJSONObject.optJSONArray("extra_field_key");
      if (paramJSONObject.has("extra_field_value")) {
        paramJSONObject = paramJSONObject.optJSONArray("extra_field_value");
      }
    }
    for (;;)
    {
      if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
        if (i < ((JSONArray)localObject).length())
        {
          str2 = ((JSONArray)localObject).optString(i, null);
          if (!baip.a(str2)) {
            if ((paramJSONObject == null) || (paramJSONObject.length() <= i)) {
              break label288;
            }
          }
        }
      }
      label288:
      for (str1 = paramJSONObject.optString(i, null);; str1 = null)
      {
        localauea.jdField_a_of_type_JavaUtilHashMap.put(str2, str1);
        i += 1;
        break;
        return localauea;
      }
      paramJSONObject = null;
      continue;
      paramJSONObject = null;
      localObject = null;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("MOBILEQQ_QASSISTANT_CONFIG", 4).getString("QASSISTANT_CONTEXT" + paramQQAppInterface.getCurrentAccountUin(), "");
  }
  
  public static List<auea> a(String paramString, List<String> paramList)
  {
    int j = 0;
    Object localObject1;
    if (baip.a(paramString))
    {
      localObject1 = null;
      return localObject1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigUtils", 2, "parseJson  strJson = " + paramString);
    }
    ArrayList localArrayList = new ArrayList();
    label230:
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString);
        if (((JSONObject)localObject2).has("qassistantconfigs"))
        {
          localObject1 = ((JSONObject)localObject2).getJSONArray("qassistantconfigs");
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            auea localauea = a(((JSONArray)localObject1).getJSONObject(i));
            if (localauea == null) {
              break label230;
            }
            localArrayList.add(localauea);
            break label230;
          }
        }
        localObject1 = localArrayList;
        if (!((JSONObject)localObject2).has("qassistantsupporthost")) {
          break;
        }
        localObject1 = localArrayList;
        if (paramList == null) {
          break;
        }
        paramList.clear();
        localObject2 = ((JSONObject)localObject2).getJSONArray("qassistantsupporthost");
        int i = j;
        localObject1 = localArrayList;
        if (i >= ((JSONArray)localObject2).length()) {
          break;
        }
        paramList.add(((JSONArray)localObject2).getString(i));
        i += 1;
        continue;
        i += 1;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
        QLog.e("QAssistantConfigUtils", 2, "parseJson has exception strJson = " + paramString, paramList);
        return localArrayList;
      }
    }
  }
  
  public static void a(auea paramauea, boolean paramBoolean, Intent paramIntent)
  {
    if ((paramauea == null) || (paramIntent == null)) {
      return;
    }
    paramIntent.putExtra("q_qssistant_debug_mode", paramBoolean);
    if (paramauea.jdField_a_of_type_JavaLangString == null)
    {
      localObject = "";
      label28:
      paramIntent.putExtra("q_qssistant_str_name", (String)localObject);
      if (paramauea.b != null) {
        break label290;
      }
      localObject = "";
      label48:
      paramIntent.putExtra("q_qssistant_str_scheme", (String)localObject);
      if (paramauea.e != null) {
        break label299;
      }
      localObject = "";
      label68:
      paramIntent.putExtra("q_qssistant_str_package", (String)localObject);
      if (paramauea.c != null) {
        break label308;
      }
      localObject = "";
      label88:
      paramIntent.putExtra("q_qssistant_str_server", (String)localObject);
      if (paramauea.d != null) {
        break label317;
      }
      localObject = "";
      label108:
      paramIntent.putExtra("q_qssistant_str_action", (String)localObject);
      paramIntent.putExtra("q_qssistant_openenable", paramauea.jdField_a_of_type_Boolean);
      if (paramauea.f != null) {
        break label326;
      }
      localObject = "";
      label139:
      paramIntent.putExtra("q_qssistant_openaction", (String)localObject);
      if (paramauea.g != null) {
        break label335;
      }
    }
    String[] arrayOfString1;
    String[] arrayOfString2;
    label290:
    label299:
    label308:
    label317:
    label326:
    label335:
    for (Object localObject = "";; localObject = paramauea.g)
    {
      paramIntent.putExtra("q_qssistant_jump_host", (String)localObject);
      int i = paramauea.jdField_a_of_type_JavaUtilHashMap.size();
      if (i <= 0) {
        break;
      }
      arrayOfString1 = new String[i];
      arrayOfString2 = new String[i];
      Iterator localIterator = paramauea.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        paramauea = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        arrayOfString1[i] = paramauea;
        paramauea = (auea)localObject;
        if (localObject == null) {
          paramauea = "";
        }
        arrayOfString2[i] = paramauea;
        i += 1;
      }
      localObject = paramauea.jdField_a_of_type_JavaLangString;
      break label28;
      localObject = paramauea.b;
      break label48;
      localObject = paramauea.e;
      break label68;
      localObject = paramauea.c;
      break label88;
      localObject = paramauea.d;
      break label108;
      localObject = paramauea.f;
      break label139;
    }
    paramIntent.putExtra("q_qssistant_extra_field_key", arrayOfString1);
    paramIntent.putExtra("q_qssistant_extra_field_value", arrayOfString2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramString == null) {
      return;
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("MOBILEQQ_QASSISTANT_CONFIG", 4).edit();
    localEditor.putString("QASSISTANT_CONTEXT" + paramQQAppInterface.getCurrentAccountUin(), paramString);
    localEditor.apply();
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAssistantConfigUtils", 2, "reportQAssistantJumpMonitor host: " + paramString1 + " openAction: " + paramString2 + " result: " + paramInt);
    }
    HashMap localHashMap = new HashMap();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localHashMap.put("host", str);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localHashMap.put("openJumpAction", paramString1);
    localHashMap.put("result", paramInt + "");
    paramString1 = awrn.a(BaseApplication.getContext());
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString1.a(null, "qAudioAssistantJumpMonitor", bool, 0L, 0L, localHashMap, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auec
 * JD-Core Version:    0.7.0.1
 */