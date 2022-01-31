package com.tencent.mobileqq.ark;

import aakl;
import aakm;
import aalb;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
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
  private aalb jdField_a_of_type_Aalb;
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
    jdField_a_of_type_Int = SharedPreUtils.ap(BaseApplicationImpl.sApplication, str);
    n = SharedPreUtils.h(BaseApplicationImpl.sApplication, str);
    if ((jdField_a_of_type_Boolean) && (!jdField_b_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_c_of_type_Boolean = bool;
      if (jdField_b_of_type_Boolean) {
        ArkAppCenter.b("ArkApp.AI", "ArkAiAppCenter isServerDisable");
      }
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictMgr = new ArkAiDictMgr(paramArkAppCenter.b());
      this.jdField_a_of_type_Aalb = new aalb(paramArkAppCenter.b());
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
    this.jdField_a_of_type_Aalb.a();
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
    j = this.jdField_a_of_type_Aalb.a(paramString);
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
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ArkAppCenter.b("ArkApp.AI", "updateArkAiKeywordConfig, keywordCfgJsonStr is empty");
      return;
    }
    label24:
    Object localObject8;
    JSONArray localJSONArray;
    label249:
    Object localObject2;
    label317:
    label324:
    label1143:
    do
    {
      JSONObject localJSONObject;
      do
      {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        jdField_a_of_type_JavaUtilList.clear();
        jdField_b_of_type_JavaUtilList.clear();
        Object localObject5;
        Object localObject7;
        Object localObject6;
        try
        {
          localObject4 = new JSONObject((String)localObject1);
          localObject5 = ((JSONObject)localObject4).optJSONArray("ark_server_keyword_configs");
          localObject3 = ((JSONObject)localObject4).optString("ark_ai_match_graytips_visibility");
          localObject8 = ((JSONObject)localObject4).optJSONArray("meta_white_url_config");
          localObject7 = ((JSONObject)localObject4).optJSONArray("meta_black_url_config");
          localObject6 = ((JSONObject)localObject4).optJSONArray("ark_navi_msg_appnames");
          localJSONArray = ((JSONObject)localObject4).optJSONArray("ark_module_api_frequency");
          localJSONObject = ((JSONObject)localObject4).optJSONObject("app_global_url_config");
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
            break;
          }
          QLog.d("ArkApp.ArkAppContainer.checkUrl", 4, String.format("jsonslist:%s,%s,%s,%s,%s", new Object[] { localObject5, localObject1, localObject8, localObject7, localObject6 }));
        }
        catch (JSONException localJSONException)
        {
          ArkAppCenter.b("ArkApp.AI", String.format("updateArkAiKeywordConfig, parse json failed, err=%s", new Object[] { localJSONException.getMessage() }));
          return;
        }
        if (i1 < ((JSONArray)localObject8).length())
        {
          localObject1 = ((JSONArray)localObject8).getString(i1);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1880;
          }
          jdField_a_of_type_JavaUtilList.add(localObject1);
          break label1880;
        }
        if (localObject7 != null)
        {
          i1 = 0;
          if (i1 < ((JSONArray)localObject7).length())
          {
            localObject2 = ((JSONArray)localObject7).getString(i1);
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label1887;
            }
            jdField_b_of_type_JavaUtilList.add(localObject2);
            break label1887;
          }
        }
        if (localObject6 != null)
        {
          if (!QLog.isDebugVersion()) {
            break label1894;
          }
          QLog.d("ArkApp.ArkAppContainer.checkUrl", 4, "naviLen:" + ((JSONArray)localObject6).length());
          break label1894;
          if (i1 < ((JSONArray)localObject6).length())
          {
            localObject2 = ((JSONArray)localObject6).optString(i1);
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (jdField_e_of_type_JavaUtilList.contains(localObject2))) {
              break label1899;
            }
            jdField_e_of_type_JavaUtilList.add(localObject2);
            break label1899;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp.ArkAppContainer.checkUrl", 2, "sArkUrlWhiteList=" + jdField_a_of_type_JavaUtilList + "sArkUrlBlackList=" + jdField_b_of_type_JavaUtilList + "\n naviAppNames=" + jdField_e_of_type_JavaUtilList);
        }
        if (localObject5 != null) {
          break label1906;
        }
        ArkAppCenter.b("ArkApp.AI", "updateArkAiKeywordConfig, ark_server_keyword_configs is empty");
        return;
        if (i1 < ((JSONArray)localObject5).length())
        {
          localObject2 = ((JSONArray)localObject5).optJSONObject(i1);
          if (localObject2 == null) {
            break label1911;
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
            break label1911;
          }
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((ArkAiAppCenter.ArkAiKeywordConfig)localObject3).jdField_a_of_type_JavaLangString, localObject3);
          break label1911;
        }
        ArkRecommendController.jdField_a_of_type_Int = ((JSONObject)localObject4).optInt("singlecontext_singleapp_card_limit", 5);
        ArkRecommendController.jdField_b_of_type_Int = ((JSONObject)localObject4).optInt("ark_app_limit", 3);
        ArkRecommendController.jdField_c_of_type_Int = ((JSONObject)localObject4).optInt("ark_each_app_card_limit", 1);
        ArkRecommendController.d = ((JSONObject)localObject4).optInt("ark_input_apps_limit", 3);
        ArkRecommendController.e = ((JSONObject)localObject4).optInt("ark_input_each_context_apps_limit", 3);
        jdField_b_of_type_Int = ((JSONObject)localObject4).optInt("ark_search_report_rate", 100);
        ArkRecommendController.f = ((JSONObject)localObject4).optInt("ark_babyq_card_limit_total", 10);
        ArkRecommendController.g = ((JSONObject)localObject4).optInt("ark_babyq_card_limit_per_app", 1);
        ArkRecommendController.i = ((JSONObject)localObject4).optInt("ark_babyq_guide_count_limit_per_day", 1);
        ArkRecommendController.j = ((JSONObject)localObject4).optInt("ark_babyq_guide_day_limit_total", 3);
        ArkRecommendController.jdField_a_of_type_JavaLangString = ((JSONObject)localObject4).optString("ark_babyq_guide_hint_text", ArkRecommendController.jdField_a_of_type_JavaLangString);
        ArkRecommendController.jdField_a_of_type_Long = ((JSONObject)localObject4).optLong("ark_babyq_bubble_disappear_duration", 10000L);
        localObject2 = ((JSONObject)localObject4).optJSONArray("ark_babyq_input_hint_text_list");
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
        {
          localObject2 = ((JSONArray)localObject2).optString(new Random().nextInt(((JSONArray)localObject2).length()));
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ArkRecommendController.jdField_b_of_type_JavaLangString = (String)localObject2;
          }
        }
        ArkRecommendController.jdField_c_of_type_JavaLangString = ((JSONObject)localObject4).optString("ark_babyq_no_result_recommend_title");
        localObject2 = ((JSONObject)localObject4).optJSONArray("ark_babyq_no_result_recommend_items");
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
          if (ArkRecommendController.jdField_a_of_type_JavaUtilArrayList == null)
          {
            ArkRecommendController.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            break label1918;
            if (i1 < ((JSONArray)localObject2).length())
            {
              localObject3 = ((JSONArray)localObject2).optString(i1);
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break label1923;
              }
              ArkRecommendController.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
              break label1923;
            }
          }
          else
          {
            ArkRecommendController.jdField_a_of_type_JavaUtilArrayList.clear();
            break label1918;
          }
        }
        ArkRecommendController.k = ((JSONObject)localObject4).optInt("ark_babyq_gray_tip_total_limit", 1);
        localObject2 = ((JSONObject)localObject4).optJSONArray("ark_babyq_gray_tip_configs");
        if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
          break label1949;
        }
        if (ArkRecommendController.jdField_a_of_type_JavaUtilHashMap == null) {
          ArkRecommendController.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        int i3;
        int i4;
        while (ArkRecommendController.jdField_b_of_type_JavaUtilHashMap == null)
        {
          ArkRecommendController.jdField_b_of_type_JavaUtilHashMap = new HashMap();
          break label1930;
          if (i1 >= ((JSONArray)localObject2).length()) {
            break label1949;
          }
          localObject3 = ((JSONArray)localObject2).optJSONObject(i1);
          if (localObject3 == null) {
            break label1942;
          }
          i3 = ((JSONObject)localObject3).optInt("type");
          i4 = ((JSONObject)localObject3).optInt("limit");
          if (i3 != 4) {
            break label1399;
          }
          localObject3 = ((JSONObject)localObject3).optJSONArray("tips_array");
          if ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0)) {
            break label1942;
          }
          i2 = 0;
          if (i2 >= ((JSONArray)localObject3).length()) {
            break label1942;
          }
          localObject7 = ((JSONArray)localObject3).optJSONObject(i2);
          if (localObject7 == null) {
            break label1935;
          }
          localObject4 = ((JSONObject)localObject7).optString("prefix");
          localObject5 = ((JSONObject)localObject7).optString("keyword");
          localObject6 = ((JSONObject)localObject7).optString("postfix");
          localObject7 = ((JSONObject)localObject7).optString("app");
          if ((TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty((CharSequence)localObject5)) || (TextUtils.isEmpty((CharSequence)localObject6)) || (TextUtils.isEmpty((CharSequence)localObject7))) {
            break label1935;
          }
          localObject8 = new ArkRecommendController.ArkAtBabyqGrayTipConfig();
          ((ArkRecommendController.ArkAtBabyqGrayTipConfig)localObject8).jdField_a_of_type_Int = i3;
          ((ArkRecommendController.ArkAtBabyqGrayTipConfig)localObject8).jdField_b_of_type_Int = i4;
          ((ArkRecommendController.ArkAtBabyqGrayTipConfig)localObject8).jdField_a_of_type_JavaLangString = ((String)localObject4 + (String)localObject5 + (String)localObject6);
          ((ArkRecommendController.ArkAtBabyqGrayTipConfig)localObject8).jdField_b_of_type_JavaLangString = ((String)localObject7);
          ArkRecommendController.jdField_b_of_type_JavaUtilHashMap.put(localObject5, localObject8);
          break label1935;
          ArkRecommendController.jdField_a_of_type_JavaUtilHashMap.clear();
        }
        ArkRecommendController.jdField_b_of_type_JavaUtilHashMap.clear();
        break label1930;
        if (i3 <= 0) {
          break label1942;
        }
        localObject3 = ((JSONObject)localObject3).optString("tip");
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label1942;
        }
        Object localObject4 = new ArkRecommendController.ArkAtBabyqGrayTipConfig();
        ((ArkRecommendController.ArkAtBabyqGrayTipConfig)localObject4).jdField_a_of_type_Int = i3;
        ((ArkRecommendController.ArkAtBabyqGrayTipConfig)localObject4).jdField_b_of_type_Int = i4;
        ((ArkRecommendController.ArkAtBabyqGrayTipConfig)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject3);
        ArkRecommendController.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(((ArkRecommendController.ArkAtBabyqGrayTipConfig)localObject4).jdField_a_of_type_Int), localObject4);
        break label1942;
        if (i1 < localJSONArray.length())
        {
          localObject2 = localJSONArray.optJSONObject(i1);
          if (localObject2 == null) {
            break label1959;
          }
          localObject4 = ((JSONObject)localObject2).optString("module");
          localObject5 = ((JSONObject)localObject2).optString("api");
          long l1 = ((JSONObject)localObject2).optLong("times", -1L);
          long l2 = ((JSONObject)localObject2).optLong("period", -1L);
          if ((TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty((CharSequence)localObject5)) || (l1 == -1L) || (l2 == -1L)) {
            break label1959;
          }
          localObject3 = (List)jdField_a_of_type_JavaUtilMap.get(localObject4);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = new ArrayList();
            jdField_a_of_type_JavaUtilMap.put(localObject4, localObject2);
          }
          ((List)localObject2).add(new ArkAiAppCenter.ApiFrequencyConfig(this, (String)localObject5, l1, l2));
          break label1959;
        }
      } while (localJSONObject == null);
      ArkAppCenter.a(true);
      if (!ArkAppCenter.jdField_b_of_type_Boolean) {
        break;
      }
      localObject2 = localJSONObject.optJSONArray("white");
      if (localObject2 != null)
      {
        i2 = ((JSONArray)localObject2).length();
        localObject3 = new String[i2];
        i1 = 0;
        if (i1 < i2)
        {
          localObject3[i1] = ((JSONArray)localObject2).optString(i1, "");
          if (!QLog.isColorLevel()) {
            break label1966;
          }
          QLog.d("ArkApp.AI", 2, String.format("updateArkAiKeywordConfig.appGlobalUrlConfig.white.%s", new Object[] { localObject3[i1] }));
          break label1966;
        }
        ArkAppCenter.a().post(new aakl(this, (String[])localObject3));
      }
      localObject2 = localJSONObject.optJSONArray("black");
    } while (localObject2 == null);
    label411:
    label1214:
    label1399:
    int i2 = ((JSONArray)localObject2).length();
    label536:
    label1470:
    Object localObject3 = new String[i2];
    label1027:
    label1687:
    int i1 = 0;
    for (;;)
    {
      if (i1 < i2)
      {
        localObject3[i1] = ((JSONArray)localObject2).optString(i1, "");
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp.AI", 2, String.format("updateArkAiKeywordConfig.appGlobalUrlConfig.black.%s", new Object[] { localObject3[i1] }));
        }
      }
      else
      {
        ArkAppCenter.a().post(new aakm(this, (String[])localObject3));
        return;
        if (!QLog.isColorLevel()) {
          break label24;
        }
        QLog.d("ArkApp.AI", 2, String.format("updateArkAiKeywordConfig.setupArkEnvironment.failed", new Object[0]));
        return;
        if (localObject8 == null) {
          break label317;
        }
        i1 = 0;
        break label249;
        label1880:
        i1 += 1;
        break label249;
        label1887:
        i1 += 1;
        break label324;
        label1894:
        i1 = 0;
        break label411;
        label1899:
        i1 += 1;
        break label411;
        label1906:
        i1 = 0;
        break label536;
        label1911:
        i1 += 1;
        break label536;
        label1918:
        i1 = 0;
        break label1027;
        label1923:
        i1 += 1;
        break label1027;
        label1930:
        i1 = 0;
        break label1143;
        label1935:
        i2 += 1;
        break label1214;
        label1942:
        i1 += 1;
        break label1143;
        label1949:
        if (localJSONArray == null) {
          break;
        }
        i1 = 0;
        break label1470;
        label1959:
        i1 += 1;
        break label1470;
        label1966:
        i1 += 1;
        break label1687;
      }
      i1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppCenter
 * JD-Core Version:    0.7.0.1
 */