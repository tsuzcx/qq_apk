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
  public String d;
  public int e;
  public String f;
  public SparseArray<TextFilterConfig.TextTemplateConfig> g;
  public SparseArray<TextFilterConfig.ColorTemplateConfig> h;
  public boolean i;
  public boolean j;
  public int k;
  
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
    this.d = paramString;
    Object localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.StoryCfg.name(), "1|1");
    this.j = true;
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    int n = 0;
    Object localObject2;
    if (!bool)
    {
      localObject2 = new Integer[2];
      if (((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser((String)localObject1, (Integer[])localObject2) > 1)
      {
        if (localObject2[1].intValue() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        this.j = bool;
      }
    }
    this.g = new SparseArray();
    this.h = new SparseArray();
    if (TextUtils.isEmpty(paramString))
    {
      this.i = false;
      return;
    }
    for (;;)
    {
      int m;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.optInt("is_enable", 0) == 1)
        {
          bool = true;
          this.i = bool;
          this.e = paramString.optInt("bid");
          this.f = paramString.optString("template_manager", "TemplateManager");
          this.k = paramString.optInt("bg_alpha", 80);
          localObject1 = paramString.optJSONArray("template");
          if (localObject1 != null)
          {
            m = 0;
            if (m < ((JSONArray)localObject1).length())
            {
              localObject2 = ((JSONArray)localObject1).optJSONObject(m);
              if (localObject2 == null) {
                break label677;
              }
              TextFilterConfig.TextTemplateConfig localTextTemplateConfig = new TextFilterConfig.TextTemplateConfig();
              localTextTemplateConfig.a = ((JSONObject)localObject2).optInt("id");
              localTextTemplateConfig.b = ((JSONObject)localObject2).optString("report_id");
              localTextTemplateConfig.c = ((JSONObject)localObject2).optString("name");
              localTextTemplateConfig.d = ((JSONObject)localObject2).optInt("color_template_id");
              if (((JSONObject)localObject2).optInt("is_support_other_color") != 1) {
                break label665;
              }
              bool = true;
              localTextTemplateConfig.e = bool;
              localTextTemplateConfig.f = ((JSONObject)localObject2).optString("text_color");
              localTextTemplateConfig.j = ((JSONObject)localObject2).optString("background_color");
              localTextTemplateConfig.g = ((JSONObject)localObject2).optInt("max_text_count");
              if (((JSONObject)localObject2).optInt("is_dynamictmp") != 1) {
                break label671;
              }
              bool = true;
              localTextTemplateConfig.i = bool;
              localTextTemplateConfig.h = ((JSONObject)localObject2).optString("res_name");
              localTextTemplateConfig.m = ((JSONObject)localObject2).optInt("bid", 0);
              localTextTemplateConfig.k = ((JSONObject)localObject2).optString("music_file");
              localTextTemplateConfig.l = ((JSONObject)localObject2).optString("pcm_music_file");
              localTextTemplateConfig.o = ((JSONObject)localObject2).optJSONObject("hint");
              localTextTemplateConfig.n = ((JSONObject)localObject2).optString("image_url");
              localTextTemplateConfig.p = ((JSONObject)localObject2).optJSONObject("extra_json_config");
              this.g.put(localTextTemplateConfig.a, localTextTemplateConfig);
              break label677;
            }
          }
          paramString = paramString.optJSONArray("color_template");
          if (paramString != null)
          {
            m = n;
            if (m < paramString.length())
            {
              localObject1 = paramString.optJSONObject(m);
              if (localObject1 != null)
              {
                localObject2 = new TextFilterConfig.ColorTemplateConfig();
                ((TextFilterConfig.ColorTemplateConfig)localObject2).a = ((JSONObject)localObject1).optInt("id");
                ((TextFilterConfig.ColorTemplateConfig)localObject2).b = ((JSONObject)localObject1).optString("report_id");
                ((TextFilterConfig.ColorTemplateConfig)localObject2).c = ((JSONObject)localObject1).optString("background_color");
                ((TextFilterConfig.ColorTemplateConfig)localObject2).d = ((JSONObject)localObject1).optString("background_color2");
                ((TextFilterConfig.ColorTemplateConfig)localObject2).e = ((JSONObject)localObject1).optString("background_color3");
                ((TextFilterConfig.ColorTemplateConfig)localObject2).f = ((JSONObject)localObject1).optString("text_color");
                ((TextFilterConfig.ColorTemplateConfig)localObject2).g = ((JSONObject)localObject1).optJSONObject("extra_json_config");
                this.h.put(((TextFilterConfig.ColorTemplateConfig)localObject2).a, localObject2);
              }
              m += 1;
              continue;
            }
          }
        }
        bool = false;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("read TextFilter Config", 2, paramString.getMessage());
        }
        if (this.j) {
          bool = this.i;
        }
        return;
      }
      continue;
      label665:
      bool = false;
      continue;
      label671:
      bool = false;
      continue;
      label677:
      m += 1;
    }
  }
  
  public String b()
  {
    return "key_for_text_filter_cfg_version";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.config.TextFilterConfig
 * JD-Core Version:    0.7.0.1
 */