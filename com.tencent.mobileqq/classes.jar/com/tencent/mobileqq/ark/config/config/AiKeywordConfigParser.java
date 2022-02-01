package com.tencent.mobileqq.ark.config.config;

import android.text.TextUtils;
import com.tencent.mobileqq.ark.config.ArkJsdebuggerDownload;
import com.tencent.mobileqq.ark.config.ArkModuleApiFrequency;
import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AiKeywordConfigParser
  extends AiKeywordConfig
  implements IQStorageSafable<String>
{
  private void a(JSONObject paramJSONObject)
  {
    this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("ark_babyq_no_result_recommend_title");
    paramJSONObject = paramJSONObject.optJSONArray("ark_babyq_no_result_recommend_items");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        String str = paramJSONObject.optString(i);
        if (!TextUtils.isEmpty(str))
        {
          QLog.d("AiKeywordConfig", 1, new Object[] { "onParse ark_babyq_no_result_recommend_items itemStr = ", str });
          this.jdField_e_of_type_JavaUtilArrayList.add(str);
        }
        i += 1;
      }
    }
    QLog.d("AiKeywordConfig", 1, new Object[] { "onParse mArkBabyqNoResultRecommendItems list size =", Integer.valueOf(this.jdField_e_of_type_JavaUtilArrayList.size()) });
  }
  
  private void b(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("ark_babyq_input_hint_text_list");
    if (paramJSONObject != null)
    {
      int j = paramJSONObject.length();
      int i = 0;
      while (i < j)
      {
        String str = paramJSONObject.optString(i);
        if (!TextUtils.isEmpty(str))
        {
          QLog.d("AiKeywordConfig", 1, new Object[] { "onParse ark_babyq_input_hint_text_list itemStr = ", str });
          this.jdField_d_of_type_JavaUtilArrayList.add(str);
        }
        i += 1;
      }
    }
    QLog.d("AiKeywordConfig", 1, new Object[] { "onParse mArkBabyqInputHintTextList list size =", Integer.valueOf(this.jdField_d_of_type_JavaUtilArrayList.size()) });
  }
  
  private void c(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = paramJSONObject.optInt("singlecontext_singleapp_card_limit", 5);
    this.jdField_b_of_type_Int = paramJSONObject.optInt("ark_app_limit", 3);
    this.jdField_c_of_type_Int = paramJSONObject.optInt("ark_each_app_card_limit", 1);
    this.jdField_d_of_type_Int = paramJSONObject.optInt("ark_input_apps_limit", 3);
    this.jdField_e_of_type_Int = paramJSONObject.optInt("ark_input_each_context_apps_limit", 3);
    this.f = paramJSONObject.optInt("ark_babyq_card_limit_total", 10);
    this.g = paramJSONObject.optInt("ark_babyq_card_limit_per_app", 1);
    this.h = paramJSONObject.optInt("ark_babyq_guide_count_limit_per_day", 1);
    this.i = paramJSONObject.optInt("ark_babyq_guide_day_limit_total", 3);
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("ark_babyq_guide_hint_text");
    this.jdField_a_of_type_Long = paramJSONObject.optLong("ark_babyq_bubble_disappear_duration", 10000L);
  }
  
  private void d(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("ark_jsdebugger_download");
    if (paramJSONObject != null)
    {
      int j = paramJSONObject.length();
      int i = 0;
      while (i < j)
      {
        Object localObject = paramJSONObject.optJSONObject(i);
        if (localObject != null)
        {
          String str1 = ((JSONObject)localObject).optString("jscmd5");
          String str2 = ((JSONObject)localObject).optString("url");
          localObject = ((JSONObject)localObject).optString("md5");
          QLog.d("AiKeywordConfig", 1, new Object[] { "onParse jscomd5 = ", str1, "ur = ", str2, "md5 = ", localObject });
          if ((str1 != null) && (!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str2))) {
            this.jdField_c_of_type_JavaUtilArrayList.add(new ArkJsdebuggerDownload(str1, str2, (String)localObject));
          }
        }
        i += 1;
      }
    }
  }
  
  private void e(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("ark_module_api_frequency");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        Object localObject = paramJSONObject.optJSONObject(i);
        if (localObject != null)
        {
          String str1 = ((JSONObject)localObject).optString("module");
          String str2 = ((JSONObject)localObject).optString("api");
          long l1 = ((JSONObject)localObject).optLong("times", -1L);
          long l2 = ((JSONObject)localObject).optLong("period", -1L);
          QLog.d("AiKeywordConfig", 1, new Object[] { "onParse ark_module_api_frequency module = ", str1, "api = ", str2, "times = ", Long.valueOf(l1), "period = ", Long.valueOf(l2) });
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (l1 != -1L) && (l2 != -1L))
          {
            localObject = new ArkModuleApiFrequency(str1, str2, l1, l2);
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
          }
        }
        i += 1;
      }
    }
    QLog.d("AiKeywordConfig", 1, new Object[] { "onParse,mArkModuleApiFrequencyList list size =", Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) });
  }
  
  private void f(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("ark_navi_msg_appnames");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        String str = paramJSONObject.optString(i);
        if ((!TextUtils.isEmpty(str)) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(str)))
        {
          QLog.d("AiKeywordConfig", 1, new Object[] { "onParse ark_navi_msg_appnames appName = ", str });
          this.jdField_a_of_type_JavaUtilArrayList.add(str);
        }
        i += 1;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AiKeywordConfig", 1, "onParse,fileOrRes is null");
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_JavaLangString = paramString.optString("ark_ai_match_graytips_visibility");
      f(paramString);
      e(paramString);
      d(paramString);
      QLog.e("AiKeywordConfig", 1, new Object[] { "mArkJsdebuggerDownloadList list size =", Integer.valueOf(this.jdField_c_of_type_JavaUtilArrayList.size()) });
      c(paramString);
      b(paramString);
      a(paramString);
      paramString = new StringBuilder("onParse ark_ai_match_graytips_visibility=");
      paramString.append(this.jdField_a_of_type_JavaLangString);
      paramString.append(", singlecontext_singleapp_card_limit=");
      paramString.append(this.jdField_a_of_type_Int);
      paramString.append(", ark_app_limit=");
      paramString.append(this.jdField_b_of_type_Int);
      paramString.append(", ark_each_app_card_limit=");
      paramString.append(this.jdField_c_of_type_Int);
      paramString.append(", ark_input_apps_limit=");
      paramString.append(this.jdField_d_of_type_Int);
      paramString.append(", ark_input_each_context_apps_limit=");
      paramString.append(this.jdField_e_of_type_Int);
      paramString.append(", ark_babyq_card_limit_total=");
      paramString.append(this.f);
      paramString.append(", ark_babyq_card_limit_total=");
      paramString.append(this.g);
      paramString.append(", ark_babyq_guide_count_limit_per_day=");
      paramString.append(this.h);
      paramString.append(", ark_babyq_guide_hint_text=");
      paramString.append(this.jdField_b_of_type_JavaLangString);
      paramString.append(", ark_babyq_bubble_disappear_duration=");
      paramString.append(this.jdField_a_of_type_Long);
      paramString.append(", ark_babyq_no_result_recommend_title=");
      paramString.append(this.jdField_c_of_type_JavaLangString);
      QLog.i("AiKeywordConfig", 1, paramString.toString());
      return;
    }
    catch (JSONException paramString)
    {
      QLog.i("AiKeywordConfig", 1, String.format("onParse AiKeywordConfig onParse, parse json failed, err=%s", new Object[] { paramString.getMessage() }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.config.AiKeywordConfigParser
 * JD-Core Version:    0.7.0.1
 */