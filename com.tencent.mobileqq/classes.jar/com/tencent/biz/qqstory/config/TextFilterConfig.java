package com.tencent.biz.qqstory.config;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.common.config.CommonConfigBase;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TextFilterConfig
  extends CommonConfigBase
{
  public SparseArray<TextFilterConfig.TextTemplateConfig> a;
  public boolean a;
  public int b;
  public SparseArray<TextFilterConfig.ColorTemplateConfig> b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  
  public TextFilterConfig(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public String a()
  {
    return "key_for_text_filter_cfg";
  }
  
  public void a(String paramString)
  {
    int j = 0;
    this.jdField_b_of_type_JavaLangString = paramString;
    Object localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.StoryCfg.name(), "1|1");
    this.jdField_b_of_type_Boolean = true;
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new Integer[2];
      if (((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser((String)localObject1, (Integer[])localObject2) > 1) {
        if (localObject2[1].intValue() != 1) {
          break label125;
        }
      }
    }
    label125:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
      this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.optInt("is_enable", 0) != 1) {
          break label654;
        }
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
        this.jdField_b_of_type_Int = paramString.optInt("bid");
        this.jdField_c_of_type_JavaLangString = paramString.optString("template_manager", "TemplateManager");
        this.jdField_c_of_type_Int = paramString.optInt("bg_alpha", 80);
        localObject1 = paramString.optJSONArray("template");
        if (localObject1 != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject2 == null) {
              break label647;
            }
            TextFilterConfig.TextTemplateConfig localTextTemplateConfig = new TextFilterConfig.TextTemplateConfig();
            localTextTemplateConfig.jdField_a_of_type_Int = ((JSONObject)localObject2).optInt("id");
            localTextTemplateConfig.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("report_id");
            localTextTemplateConfig.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("name");
            localTextTemplateConfig.jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("color_template_id");
            if (((JSONObject)localObject2).optInt("is_support_other_color") != 1) {
              break label660;
            }
            bool = true;
            localTextTemplateConfig.jdField_a_of_type_Boolean = bool;
            localTextTemplateConfig.jdField_c_of_type_JavaLangString = ((JSONObject)localObject2).optString("text_color");
            localTextTemplateConfig.e = ((JSONObject)localObject2).optString("background_color");
            localTextTemplateConfig.jdField_c_of_type_Int = ((JSONObject)localObject2).optInt("max_text_count");
            if (((JSONObject)localObject2).optInt("is_dynamictmp") != 1) {
              break label666;
            }
            bool = true;
            localTextTemplateConfig.jdField_b_of_type_Boolean = bool;
            localTextTemplateConfig.jdField_d_of_type_JavaLangString = ((JSONObject)localObject2).optString("res_name");
            localTextTemplateConfig.jdField_d_of_type_Int = ((JSONObject)localObject2).optInt("bid", 0);
            localTextTemplateConfig.f = ((JSONObject)localObject2).optString("music_file");
            localTextTemplateConfig.g = ((JSONObject)localObject2).optString("pcm_music_file");
            localTextTemplateConfig.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject2).optJSONObject("hint");
            localTextTemplateConfig.h = ((JSONObject)localObject2).optString("image_url");
            localTextTemplateConfig.jdField_b_of_type_OrgJsonJSONObject = ((JSONObject)localObject2).optJSONObject("extra_json_config");
            this.jdField_a_of_type_AndroidUtilSparseArray.put(localTextTemplateConfig.jdField_a_of_type_Int, localTextTemplateConfig);
            break label647;
          }
        }
        paramString = paramString.optJSONArray("color_template");
        if (paramString != null)
        {
          i = j;
          if (i < paramString.length())
          {
            localObject1 = paramString.optJSONObject(i);
            if (localObject1 != null)
            {
              localObject2 = new TextFilterConfig.ColorTemplateConfig();
              ((TextFilterConfig.ColorTemplateConfig)localObject2).jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("id");
              ((TextFilterConfig.ColorTemplateConfig)localObject2).jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("report_id");
              ((TextFilterConfig.ColorTemplateConfig)localObject2).jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("background_color");
              ((TextFilterConfig.ColorTemplateConfig)localObject2).jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).optString("background_color2");
              ((TextFilterConfig.ColorTemplateConfig)localObject2).jdField_d_of_type_JavaLangString = ((JSONObject)localObject1).optString("background_color3");
              ((TextFilterConfig.ColorTemplateConfig)localObject2).e = ((JSONObject)localObject1).optString("text_color");
              ((TextFilterConfig.ColorTemplateConfig)localObject2).jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject1).optJSONObject("extra_json_config");
              this.jdField_b_of_type_AndroidUtilSparseArray.put(((TextFilterConfig.ColorTemplateConfig)localObject2).jdField_a_of_type_Int, localObject2);
            }
            i += 1;
            continue;
          }
        }
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("read TextFilter Config", 2, paramString.getMessage());
        }
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      return;
      label647:
      i += 1;
      continue;
      label654:
      bool = false;
      continue;
      label660:
      bool = false;
      continue;
      label666:
      bool = false;
    }
  }
  
  public String b()
  {
    return "key_for_text_filter_cfg_version";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.config.TextFilterConfig
 * JD-Core Version:    0.7.0.1
 */