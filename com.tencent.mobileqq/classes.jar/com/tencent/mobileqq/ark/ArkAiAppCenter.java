package com.tencent.mobileqq.ark;

import aayg;
import aayh;
import aayw;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAiAppCenter
{
  public static int a;
  public static String a;
  public static List a;
  public static Map a;
  public static ConcurrentHashMap a;
  public static boolean a;
  public static int b;
  public static String b;
  public static List b;
  public static Map b;
  public static boolean b;
  public static List c;
  public static boolean c;
  public static List d;
  public static boolean d;
  private static List e;
  public static boolean e;
  public static boolean f;
  public static boolean g;
  public static volatile boolean h;
  public static volatile boolean i;
  public static boolean j;
  public static boolean k;
  public static boolean l;
  public static boolean m;
  public static boolean n;
  private static boolean o;
  private static boolean p;
  private aayw jdField_a_of_type_Aayw;
  private ArkAiDictMgr jdField_a_of_type_ComTencentMobileqqArkArkAiDictMgr;
  private ArkAppCenter jdField_a_of_type_ComTencentMobileqqArkArkAppCenter;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    if ((jdField_a_of_type_Boolean) && (!jdField_b_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_c_of_type_Boolean = bool;
      f = true;
      g = true;
      jdField_a_of_type_Int = 0;
      jdField_b_of_type_Int = 100;
      o = true;
      p = true;
      n = true;
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      jdField_a_of_type_JavaUtilList = new ArrayList();
      jdField_b_of_type_JavaUtilList = new ArrayList();
      jdField_a_of_type_JavaUtilMap = new HashMap();
      jdField_b_of_type_JavaUtilMap = new HashMap();
      jdField_c_of_type_JavaUtilList = new ArrayList();
      jdField_d_of_type_JavaUtilList = new ArrayList();
      jdField_e_of_type_JavaUtilList = new ArrayList();
      if (Build.MODEL.contains("Android SDK built for x86")) {
        i = true;
      }
      String str1 = Build.CPU_ABI;
      String str2 = Build.CPU_ABI2;
      if ((!i) && ((a(str1).booleanValue()) || (a(str2).booleanValue()))) {
        h = true;
      }
      return;
    }
  }
  
  public ArkAiAppCenter(ArkAppCenter paramArkAppCenter)
  {
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppCenter = paramArkAppCenter;
    jdField_a_of_type_Boolean = a(paramArkAppCenter.b());
    String str = paramArkAppCenter.b().getCurrentAccountUin();
    jdField_b_of_type_Boolean = SharedPreUtils.c(BaseApplicationImpl.sApplication, str);
    jdField_d_of_type_Boolean = SharedPreUtils.d(BaseApplicationImpl.sApplication, str);
    jdField_e_of_type_Boolean = SharedPreUtils.e(BaseApplicationImpl.sApplication, str);
    f = SharedPreUtils.f(BaseApplicationImpl.sApplication, str);
    g = SharedPreUtils.g(BaseApplicationImpl.sApplication, str);
    jdField_a_of_type_Int = SharedPreUtils.an(BaseApplicationImpl.sApplication, str);
    n = SharedPreUtils.h(BaseApplicationImpl.sApplication, str);
    if ((jdField_a_of_type_Boolean) && (!jdField_b_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_c_of_type_Boolean = bool;
      if (jdField_b_of_type_Boolean) {
        ArkAppCenter.b("ArkApp.AI", "ArkAiAppCenter isServerDisable");
      }
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictMgr = new ArkAiDictMgr(paramArkAppCenter.b());
      this.jdField_a_of_type_Aayw = new aayw(paramArkAppCenter.b());
      d();
      a();
      c();
      a(SharedPreUtils.m(BaseApplicationImpl.getApplication()));
      return;
    }
  }
  
  private static Boolean a(String paramString)
  {
    if ((paramString.equalsIgnoreCase("armeabi-v7a")) || (paramString.equalsIgnoreCase("arm64-v8a"))) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public static String a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localQQAppInterface == null) {
      return "";
    }
    return localQQAppInterface.getCurrentAccountUin();
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "open";; str = "close")
    {
      SharePreferenceUtils.a(BaseApplication.getContext(), "ark_https_switch_" + a(), str);
      return;
    }
  }
  
  public static boolean a()
  {
    return o;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_Boolean = paramQQAppInterface.getPreferences().getBoolean("ARKAI_TURNON", true);
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(String paramString)
  {
    return (jdField_b_of_type_JavaUtilList != null) && (jdField_e_of_type_JavaUtilList.contains(paramString));
  }
  
  public static String b()
  {
    return SharePreferenceUtils.a(BaseApplication.getContext(), "ark_https_switch_" + a()).toString();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
    if ((jdField_a_of_type_Boolean) && (!jdField_b_of_type_Boolean)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      jdField_c_of_type_Boolean = paramBoolean;
      if (jdField_c_of_type_Boolean) {
        ((ArkAppCenter)paramQQAppInterface.getManager(120)).a().d();
      }
      return;
    }
  }
  
  public static boolean b()
  {
    return p;
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictMgr.b();
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      ArkAppCenter.b("ArkApp.AI", "getArkStringConfig, dictConfigJsonString is empty");
      return "";
    }
    try
    {
      paramString1 = new JSONObject(paramString1).optString(paramString2);
      if (!TextUtils.isEmpty(paramString1))
      {
        ArkAppCenter.b("ArkApp.AI", String.format("getArkStringConfig, " + paramString2 + "=%s", new Object[] { paramString1 }));
        return paramString1;
      }
    }
    catch (JSONException paramString1)
    {
      ArkAppCenter.b("ArkApp.AI", String.format("getArkStringConfig, parse json failed, err=%s", new Object[] { paramString1.getMessage() }));
      return "";
    }
    ArkAppCenter.b("ArkApp.AI", "getArkStringConfig, " + paramString2 + "is empty");
    return "";
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aayw.a();
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    jdField_a_of_type_Boolean = paramBoolean;
    paramQQAppInterface.getPreferences().edit().putBoolean("ARKAI_TURNON", jdField_a_of_type_Boolean).commit();
    if ((jdField_a_of_type_Boolean) && (!jdField_b_of_type_Boolean)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      jdField_c_of_type_Boolean = paramBoolean;
      if (!jdField_c_of_type_Boolean) {
        break;
      }
      d();
      return;
    }
  }
  
  public void a(String paramString)
  {
    k = a(paramString, "ark_map_transfer_struct");
    l = a(paramString, "ark_terms_dialog_switch");
    jdField_a_of_type_JavaLangString = a(paramString, "ark_terms_url");
    jdField_b_of_type_JavaLangString = a(paramString, "ark_terms_text");
    j = this.jdField_a_of_type_Aayw.a(paramString);
    m = a(paramString, "ark_android_https_switch");
    a(m);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString1))
    {
      ArkAppCenter.b("ArkApp.AI", "getArkBoolConfig, dictConfigJsonString is empty");
      return false;
    }
    try
    {
      paramString1 = new JSONObject(paramString1).optString(paramString2);
      if (!TextUtils.isEmpty(paramString1))
      {
        ArkAppCenter.b("ArkApp.AI", String.format("getArkBoolConfig, " + paramString2 + "=%s", new Object[] { paramString1 }));
        if (!paramString1.equals("true")) {
          break label154;
        }
      }
      else
      {
        ArkAppCenter.b("ArkApp.AI", "getArkBoolConfig, " + paramString2 + " is empty");
        return false;
      }
    }
    catch (JSONException paramString1)
    {
      ArkAppCenter.b("ArkApp.AI", String.format("getArkBoolConfig, parse json failed, err=%s", new Object[] { paramString1.getMessage() }));
      return false;
    }
    for (;;)
    {
      return bool;
      label154:
      bool = false;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictMgr.d();
  }
  
  public void c()
  {
    Object localObject1 = SharedPreUtils.m(BaseApplicationImpl.getApplication());
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      ArkAppCenter.b("ArkApp.AI", "updateArkAiKeywordConfig, keywordCfgJsonStr is empty");
    }
    label259:
    label421:
    label1966:
    label2094:
    label2101:
    label2106:
    for (;;)
    {
      return;
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      jdField_a_of_type_JavaUtilList.clear();
      jdField_b_of_type_JavaUtilList.clear();
      Object localObject5;
      Object localObject6;
      Object localObject3;
      Object localObject9;
      Object localObject8;
      Object localObject7;
      JSONArray localJSONArray2;
      Object localObject4;
      JSONArray localJSONArray1;
      int i1;
      try
      {
        localObject5 = new JSONObject((String)localObject1);
        localObject6 = ((JSONObject)localObject5).optJSONArray("ark_server_keyword_configs");
        localObject3 = ((JSONObject)localObject5).optString("ark_ai_match_graytips_visibility");
        localObject9 = ((JSONObject)localObject5).optJSONArray("meta_white_url_config");
        localObject8 = ((JSONObject)localObject5).optJSONArray("meta_black_url_config");
        localObject7 = ((JSONObject)localObject5).optJSONArray("ark_navi_msg_appnames");
        localJSONArray2 = ((JSONObject)localObject5).optJSONArray("ark_module_api_frequency");
        localObject4 = ((JSONObject)localObject5).optJSONObject("app_global_url_config");
        localJSONArray1 = ((JSONObject)localObject5).optJSONArray("ark_jsdebugger_download");
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          ArkAppCenter.b("ArkApp.AI", "updateArkAiKeywordConfig, ark_ai_match_graytips_visibility is empty");
          localObject1 = "false";
        }
        ArkAppCenter.b("ArkApp.AI", "updateArkAiKeywordConfig, ark_ai_match_graytips_visibility cfgGTipSwitch=" + (String)localObject1);
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqArkArkAppCenter.a();
        SharedPreUtils.j(BaseApplicationImpl.getApplication(), (String)localObject1, ((QQAppInterface)localObject3).c());
        if (!QLog.isDebugVersion()) {
          break label1991;
        }
        QLog.d("ArkApp.ArkAppContainer.checkUrl", 4, String.format("jsonslist:%s,%s,%s,%s,%s", new Object[] { localObject6, localObject1, localObject9, localObject8, localObject7 }));
      }
      catch (JSONException localJSONException)
      {
        ArkAppCenter.b("ArkApp.AI", String.format("updateArkAiKeywordConfig, parse json failed, err=%s", new Object[] { localJSONException.getMessage() }));
        return;
      }
      label327:
      label334:
      Object localObject2;
      int i2;
      if (i1 < ((JSONArray)localObject9).length())
      {
        localObject1 = ((JSONArray)localObject9).getString(i1);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          jdField_a_of_type_JavaUtilList.add(localObject1);
        }
      }
      else
      {
        if (localObject8 != null)
        {
          i1 = 0;
          if (i1 < ((JSONArray)localObject8).length())
          {
            localObject2 = ((JSONArray)localObject8).getString(i1);
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label2008;
            }
            jdField_b_of_type_JavaUtilList.add(localObject2);
            break label2008;
          }
        }
        if (localObject7 != null)
        {
          if (!QLog.isDebugVersion()) {
            break label2015;
          }
          QLog.d("ArkApp.ArkAppContainer.checkUrl", 4, "naviLen:" + ((JSONArray)localObject7).length());
          break label2015;
          if (i1 < ((JSONArray)localObject7).length())
          {
            localObject2 = ((JSONArray)localObject7).optString(i1);
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (jdField_e_of_type_JavaUtilList.contains(localObject2))) {
              break label2020;
            }
            jdField_e_of_type_JavaUtilList.add(localObject2);
            break label2020;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp.ArkAppContainer.checkUrl", 2, "sArkUrlWhiteList=" + jdField_a_of_type_JavaUtilList + "sArkUrlBlackList=" + jdField_b_of_type_JavaUtilList + "\n naviAppNames=" + jdField_e_of_type_JavaUtilList);
        }
        if (localObject6 != null) {
          break label2027;
        }
        ArkAppCenter.b("ArkApp.AI", "updateArkAiKeywordConfig, ark_server_keyword_configs is empty");
        return;
        if (i1 < ((JSONArray)localObject6).length())
        {
          localObject2 = ((JSONArray)localObject6).optJSONObject(i1);
          if (localObject2 == null) {
            break label2032;
          }
          localObject3 = new ArkAiAppCenter.ArkAiKeywordConfig(this);
          ((ArkAiAppCenter.ArkAiKeywordConfig)localObject3).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("context", "");
          ((ArkAiAppCenter.ArkAiKeywordConfig)localObject3).jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("type", "");
          boolean bool = ((JSONObject)localObject2).optBoolean("enable", false);
          ((ArkAiAppCenter.ArkAiKeywordConfig)localObject3).jdField_c_of_type_JavaLangString = ((JSONObject)localObject2).optString("regex", "");
          ((ArkAiAppCenter.ArkAiKeywordConfig)localObject3).d = ((JSONObject)localObject2).optString("tips", "");
          if ((TextUtils.isEmpty(((ArkAiAppCenter.ArkAiKeywordConfig)localObject3).jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(((ArkAiAppCenter.ArkAiKeywordConfig)localObject3).jdField_b_of_type_JavaLangString)) || (!bool) || (TextUtils.isEmpty(((ArkAiAppCenter.ArkAiKeywordConfig)localObject3).jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(((ArkAiAppCenter.ArkAiKeywordConfig)localObject3).d)))
          {
            ArkAppCenter.b("ArkApp.AI", String.format("updateArkAiKeywordConfig, invalid config info, type=%s, contextSize=%d, enable=%s, pattern=%s, tip=%s", new Object[] { ((ArkAiAppCenter.ArkAiKeywordConfig)localObject3).jdField_a_of_type_JavaLangString, ((ArkAiAppCenter.ArkAiKeywordConfig)localObject3).jdField_b_of_type_JavaLangString, Boolean.valueOf(bool), ((ArkAiAppCenter.ArkAiKeywordConfig)localObject3).jdField_c_of_type_JavaLangString, ((ArkAiAppCenter.ArkAiKeywordConfig)localObject3).d }));
            break label2032;
          }
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((ArkAiAppCenter.ArkAiKeywordConfig)localObject3).jdField_a_of_type_JavaLangString, localObject3);
          break label2032;
        }
        ArkRecommendController.jdField_a_of_type_Int = ((JSONObject)localObject5).optInt("singlecontext_singleapp_card_limit", 5);
        ArkRecommendController.jdField_b_of_type_Int = ((JSONObject)localObject5).optInt("ark_app_limit", 3);
        ArkRecommendController.jdField_c_of_type_Int = ((JSONObject)localObject5).optInt("ark_each_app_card_limit", 1);
        ArkRecommendController.d = ((JSONObject)localObject5).optInt("ark_input_apps_limit", 3);
        ArkRecommendController.e = ((JSONObject)localObject5).optInt("ark_input_each_context_apps_limit", 3);
        jdField_b_of_type_Int = ((JSONObject)localObject5).optInt("ark_search_report_rate", 100);
        ArkRecommendController.f = ((JSONObject)localObject5).optInt("ark_babyq_card_limit_total", 10);
        ArkRecommendController.g = ((JSONObject)localObject5).optInt("ark_babyq_card_limit_per_app", 1);
        ArkRecommendController.i = ((JSONObject)localObject5).optInt("ark_babyq_guide_count_limit_per_day", 1);
        ArkRecommendController.j = ((JSONObject)localObject5).optInt("ark_babyq_guide_day_limit_total", 3);
        ArkRecommendController.jdField_a_of_type_JavaLangString = ((JSONObject)localObject5).optString("ark_babyq_guide_hint_text", ArkRecommendController.jdField_a_of_type_JavaLangString);
        ArkRecommendController.jdField_a_of_type_Long = ((JSONObject)localObject5).optLong("ark_babyq_bubble_disappear_duration", 10000L);
        localObject2 = ((JSONObject)localObject5).optJSONArray("ark_babyq_input_hint_text_list");
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
        {
          localObject2 = ((JSONArray)localObject2).optString(new Random().nextInt(((JSONArray)localObject2).length()));
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ArkRecommendController.jdField_b_of_type_JavaLangString = (String)localObject2;
          }
        }
        ArkRecommendController.jdField_c_of_type_JavaLangString = ((JSONObject)localObject5).optString("ark_babyq_no_result_recommend_title");
        localObject2 = ((JSONObject)localObject5).optJSONArray("ark_babyq_no_result_recommend_items");
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
          if (ArkRecommendController.jdField_a_of_type_JavaUtilArrayList == null)
          {
            ArkRecommendController.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            break label2039;
            if (i1 < ((JSONArray)localObject2).length())
            {
              localObject3 = ((JSONArray)localObject2).optString(i1);
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break label2044;
              }
              ArkRecommendController.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
              break label2044;
            }
          }
          else
          {
            ArkRecommendController.jdField_a_of_type_JavaUtilArrayList.clear();
            break label2039;
          }
        }
        ArkRecommendController.k = ((JSONObject)localObject5).optInt("ark_babyq_gray_tip_total_limit", 1);
        localObject2 = ((JSONObject)localObject5).optJSONArray("ark_babyq_gray_tip_configs");
        if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
          break label2070;
        }
        if (ArkRecommendController.jdField_a_of_type_JavaUtilHashMap == null) {
          ArkRecommendController.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        int i3;
        int i4;
        while (ArkRecommendController.jdField_b_of_type_JavaUtilHashMap == null)
        {
          ArkRecommendController.jdField_b_of_type_JavaUtilHashMap = new HashMap();
          break label2051;
          if (i1 >= ((JSONArray)localObject2).length()) {
            break label2070;
          }
          localObject3 = ((JSONArray)localObject2).optJSONObject(i1);
          if (localObject3 == null) {
            break label2063;
          }
          i3 = ((JSONObject)localObject3).optInt("type");
          i4 = ((JSONObject)localObject3).optInt("limit");
          if (i3 != 4) {
            break label1409;
          }
          localObject3 = ((JSONObject)localObject3).optJSONArray("tips_array");
          if ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0)) {
            break label2063;
          }
          i2 = 0;
          label1224:
          if (i2 >= ((JSONArray)localObject3).length()) {
            break label2063;
          }
          localObject8 = ((JSONArray)localObject3).optJSONObject(i2);
          if (localObject8 == null) {
            break label2056;
          }
          localObject5 = ((JSONObject)localObject8).optString("prefix");
          localObject6 = ((JSONObject)localObject8).optString("keyword");
          localObject7 = ((JSONObject)localObject8).optString("postfix");
          localObject8 = ((JSONObject)localObject8).optString("app");
          if ((TextUtils.isEmpty((CharSequence)localObject5)) || (TextUtils.isEmpty((CharSequence)localObject6)) || (TextUtils.isEmpty((CharSequence)localObject7)) || (TextUtils.isEmpty((CharSequence)localObject8))) {
            break label2056;
          }
          localObject9 = new ArkRecommendController.ArkAtBabyqGrayTipConfig();
          ((ArkRecommendController.ArkAtBabyqGrayTipConfig)localObject9).jdField_a_of_type_Int = i3;
          ((ArkRecommendController.ArkAtBabyqGrayTipConfig)localObject9).jdField_b_of_type_Int = i4;
          ((ArkRecommendController.ArkAtBabyqGrayTipConfig)localObject9).jdField_a_of_type_JavaLangString = ((String)localObject5 + (String)localObject6 + (String)localObject7);
          ((ArkRecommendController.ArkAtBabyqGrayTipConfig)localObject9).jdField_b_of_type_JavaLangString = ((String)localObject8);
          ArkRecommendController.jdField_b_of_type_JavaUtilHashMap.put(localObject6, localObject9);
          break label2056;
          ArkRecommendController.jdField_a_of_type_JavaUtilHashMap.clear();
        }
        ArkRecommendController.jdField_b_of_type_JavaUtilHashMap.clear();
        break label2051;
        if (i3 <= 0) {
          break label2063;
        }
        localObject3 = ((JSONObject)localObject3).optString("tip");
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label2063;
        }
        localObject5 = new ArkRecommendController.ArkAtBabyqGrayTipConfig();
        ((ArkRecommendController.ArkAtBabyqGrayTipConfig)localObject5).jdField_a_of_type_Int = i3;
        ((ArkRecommendController.ArkAtBabyqGrayTipConfig)localObject5).jdField_b_of_type_Int = i4;
        ((ArkRecommendController.ArkAtBabyqGrayTipConfig)localObject5).jdField_a_of_type_JavaLangString = ((String)localObject3);
        ArkRecommendController.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(((ArkRecommendController.ArkAtBabyqGrayTipConfig)localObject5).jdField_a_of_type_Int), localObject5);
        break label2063;
        label1480:
        if (i1 < localJSONArray2.length())
        {
          localObject2 = localJSONArray2.optJSONObject(i1);
          if (localObject2 == null) {
            break label2080;
          }
          localObject5 = ((JSONObject)localObject2).optString("module");
          localObject6 = ((JSONObject)localObject2).optString("api");
          long l1 = ((JSONObject)localObject2).optLong("times", -1L);
          long l2 = ((JSONObject)localObject2).optLong("period", -1L);
          if ((TextUtils.isEmpty((CharSequence)localObject5)) || (TextUtils.isEmpty((CharSequence)localObject6)) || (l1 == -1L) || (l2 == -1L)) {
            break label2080;
          }
          localObject3 = (List)jdField_a_of_type_JavaUtilMap.get(localObject5);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = new ArrayList();
            jdField_a_of_type_JavaUtilMap.put(localObject5, localObject2);
          }
          ((List)localObject2).add(new ArkAiAppCenter.ApiFrequencyConfig(this, (String)localObject6, l1, l2));
          break label2080;
        }
        label1653:
        if (localObject4 != null)
        {
          ArkAppCenter.a(true);
          if (!ArkAppCenter.jdField_b_of_type_Boolean) {
            break label1966;
          }
          localObject2 = ((JSONObject)localObject4).optJSONArray("white");
          if (localObject2 != null)
          {
            i2 = ((JSONArray)localObject2).length();
            localObject3 = new String[i2];
            i1 = 0;
            if (i1 < i2)
            {
              localObject3[i1] = ((JSONArray)localObject2).optString(i1, "");
              if (!QLog.isColorLevel()) {
                break label2087;
              }
              QLog.d("ArkApp.AI", 2, String.format("updateArkAiKeywordConfig.appGlobalUrlConfig.white.%s", new Object[] { localObject3[i1] }));
              break label2087;
            }
            ArkAppCenter.a().post(new aayg(this, (String[])localObject3));
          }
          localObject2 = ((JSONObject)localObject4).optJSONArray("black");
          if (localObject2 != null)
          {
            i2 = ((JSONArray)localObject2).length();
            localObject3 = new String[i2];
            i1 = 0;
            label1791:
            if (i1 < i2)
            {
              localObject3[i1] = ((JSONArray)localObject2).optString(i1, "");
              if (!QLog.isColorLevel()) {
                break label2094;
              }
              QLog.d("ArkApp.AI", 2, String.format("updateArkAiKeywordConfig.appGlobalUrlConfig.black.%s", new Object[] { localObject3[i1] }));
              break label2094;
            }
            ArkAppCenter.a().post(new aayh(this, (String[])localObject3));
          }
        }
        label1856:
        if (localJSONArray1 != null)
        {
          i2 = localJSONArray1.length();
          i1 = 0;
        }
      }
      for (;;)
      {
        if (i1 >= i2) {
          break label2106;
        }
        localObject4 = localJSONArray1.optJSONObject(i1);
        if (localObject4 != null)
        {
          localObject2 = ((JSONObject)localObject4).optString("jscmd5");
          localObject3 = ((JSONObject)localObject4).optString("url");
          localObject4 = ((JSONObject)localObject4).optString("md5");
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
          {
            jdField_b_of_type_JavaUtilMap.put(localObject2, new Pair(localObject3, localObject4));
            break label2101;
            if (!QLog.isColorLevel()) {
              break label1856;
            }
            QLog.d("ArkApp.AI", 2, String.format("updateArkAiKeywordConfig.setupArkEnvironment.failed", new Object[0]));
            break label1856;
            break;
            label1991:
            if (localObject9 == null) {
              break label327;
            }
            i1 = 0;
            break label259;
            i1 += 1;
            break label259;
            label2008:
            i1 += 1;
            break label334;
            label2015:
            i1 = 0;
            break label421;
            label2020:
            i1 += 1;
            break label421;
            label2027:
            i1 = 0;
            break label546;
            label2032:
            i1 += 1;
            break label546;
            label2039:
            i1 = 0;
            break label1037;
            label2044:
            i1 += 1;
            break label1037;
            i1 = 0;
            break label1153;
            i2 += 1;
            break label1224;
            i1 += 1;
            break label1153;
            if (localJSONArray2 == null) {
              break label1653;
            }
            i1 = 0;
            break label1480;
            i1 += 1;
            break label1480;
            i1 += 1;
            break label1697;
            i1 += 1;
            break label1791;
          }
        }
        i1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppCenter
 * JD-Core Version:    0.7.0.1
 */