import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
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

public class banl
{
  private static int a(String paramString)
  {
    if (bhsr.a(paramString)) {}
    do
    {
      return 0;
      if (paramString.equalsIgnoreCase("scan")) {
        return 8;
      }
      if (paramString.equalsIgnoreCase("openreadinjoy")) {
        return 11;
      }
      if (paramString.equalsIgnoreCase("qassistantnearby")) {
        return 14;
      }
      if (paramString.equalsIgnoreCase("qsettings")) {
        return 6;
      }
      if (paramString.equalsIgnoreCase("searchpage")) {
        return 7;
      }
      if (paramString.equalsIgnoreCase("qinterest")) {
        return 12;
      }
      if (paramString.equalsIgnoreCase("ecchat")) {
        return 16;
      }
      if (paramString.equalsIgnoreCase("confessmsg")) {
        return 17;
      }
      if (paramString.equalsIgnoreCase("weishi")) {
        return 18;
      }
    } while (!paramString.equalsIgnoreCase("qqgame"));
    return 19;
  }
  
  public static banj a(Intent paramIntent)
  {
    String[] arrayOfString1 = null;
    int j = 0;
    if ((paramIntent == null) || (!paramIntent.hasExtra("q_qssistant_str_name"))) {
      return null;
    }
    banj localbanj = bank.a(paramIntent.getStringExtra("q_qssistant_openaction"));
    localbanj.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("q_qssistant_str_name");
    localbanj.b = paramIntent.getStringExtra("q_qssistant_str_scheme");
    localbanj.e = paramIntent.getStringExtra("q_qssistant_str_package");
    localbanj.c = paramIntent.getStringExtra("q_qssistant_str_server");
    localbanj.d = paramIntent.getStringExtra("q_qssistant_str_action");
    localbanj.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("q_qssistant_openenable", false);
    localbanj.g = paramIntent.getStringExtra("q_qssistant_jump_host");
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
        HashMap localHashMap = localbanj.jdField_a_of_type_JavaUtilHashMap;
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
    return localbanj;
  }
  
  public static banj a(JSONObject paramJSONObject)
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
    banj localbanj = bank.a(str5);
    localbanj.jdField_a_of_type_JavaLangString = ((String)localObject);
    if (!bhsr.a(str1)) {
      localbanj.b = str1;
    }
    if (!bhsr.a(str2)) {
      localbanj.c = str2;
    }
    if (!bhsr.a(str3)) {
      localbanj.d = str3;
    }
    if (!bhsr.a(str4)) {
      localbanj.e = str4;
    }
    localbanj.jdField_a_of_type_Boolean = bool;
    if (!bhsr.a(str5)) {
      localbanj.f = str5;
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
          if (!bhsr.a(str2)) {
            if ((paramJSONObject == null) || (paramJSONObject.length() <= i)) {
              break label288;
            }
          }
        }
      }
      label288:
      for (str1 = paramJSONObject.optString(i, null);; str1 = null)
      {
        localbanj.jdField_a_of_type_JavaUtilHashMap.put(str2, str1);
        i += 1;
        break;
        return localbanj;
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
  
  public static List<banj> a(String paramString, List<String> paramList)
  {
    int j = 0;
    Object localObject1;
    if (bhsr.a(paramString))
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
            banj localbanj = a(((JSONArray)localObject1).getJSONObject(i));
            if (localbanj == null) {
              break label230;
            }
            localArrayList.add(localbanj);
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
  
  public static void a(banj parambanj, boolean paramBoolean, Intent paramIntent)
  {
    if ((parambanj == null) || (paramIntent == null)) {
      return;
    }
    paramIntent.putExtra("q_qssistant_debug_mode", paramBoolean);
    if (parambanj.jdField_a_of_type_JavaLangString == null)
    {
      localObject = "";
      label29:
      paramIntent.putExtra("q_qssistant_str_name", (String)localObject);
      if (parambanj.b != null) {
        break label291;
      }
      localObject = "";
      label49:
      paramIntent.putExtra("q_qssistant_str_scheme", (String)localObject);
      if (parambanj.e != null) {
        break label300;
      }
      localObject = "";
      label69:
      paramIntent.putExtra("q_qssistant_str_package", (String)localObject);
      if (parambanj.c != null) {
        break label309;
      }
      localObject = "";
      label89:
      paramIntent.putExtra("q_qssistant_str_server", (String)localObject);
      if (parambanj.d != null) {
        break label318;
      }
      localObject = "";
      label109:
      paramIntent.putExtra("q_qssistant_str_action", (String)localObject);
      paramIntent.putExtra("q_qssistant_openenable", parambanj.jdField_a_of_type_Boolean);
      if (parambanj.f != null) {
        break label327;
      }
      localObject = "";
      label140:
      paramIntent.putExtra("q_qssistant_openaction", (String)localObject);
      if (parambanj.g != null) {
        break label336;
      }
    }
    String[] arrayOfString1;
    String[] arrayOfString2;
    label291:
    label300:
    label309:
    label318:
    label327:
    label336:
    for (Object localObject = "";; localObject = parambanj.g)
    {
      paramIntent.putExtra("q_qssistant_jump_host", (String)localObject);
      int i = parambanj.jdField_a_of_type_JavaUtilHashMap.size();
      if (i <= 0) {
        break;
      }
      arrayOfString1 = new String[i];
      arrayOfString2 = new String[i];
      Iterator localIterator = parambanj.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        parambanj = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        arrayOfString1[i] = parambanj;
        parambanj = (banj)localObject;
        if (localObject == null) {
          parambanj = "";
        }
        arrayOfString2[i] = parambanj;
        i += 1;
      }
      localObject = parambanj.jdField_a_of_type_JavaLangString;
      break label29;
      localObject = parambanj.b;
      break label49;
      localObject = parambanj.e;
      break label69;
      localObject = parambanj.c;
      break label89;
      localObject = parambanj.d;
      break label109;
      localObject = parambanj.f;
      break label140;
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
  
  public static void a(String paramString)
  {
    String str2 = Build.BRAND;
    String str1 = str2;
    if (bhsr.a(str2)) {
      str1 = Build.MANUFACTURER;
    }
    if (bhsr.a(str1)) {
      str1 = Build.PRODUCT;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAssistantConfigUtils", 2, "reportQAssistantJump openAction: " + paramString + " strBrand: " + str1);
      }
      str2 = "" + a(paramString);
      if (str1 == null) {}
      for (paramString = "";; paramString = str1)
      {
        bdll.b(null, "dc00898", "", "", "0X800A99A", "0X800A99A", 0, 0, str2, "", paramString, Build.MODEL);
        return;
      }
    }
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
    paramString1 = bdmc.a(BaseApplication.getContext());
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString1.a(null, "qAudioAssistantJumpMonitor", bool, 0L, 0L, localHashMap, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     banl
 * JD-Core Version:    0.7.0.1
 */