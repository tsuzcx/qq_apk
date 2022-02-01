package com.tencent.biz.pubaccount.ecshopassit.conf;

import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EcshopConfBean
{
  public int a;
  public EcshopConfBean.PromotionConfBean a;
  public String a;
  public ArrayList<EcshopConfBean.TabConfBean> a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  
  public EcshopConfBean()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "#FFFFFF";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitConfEcshopConfBean$PromotionConfBean = new EcshopConfBean.PromotionConfBean();
  }
  
  public static EcshopConfBean a(String paramString)
  {
    int i = 0;
    EcshopConfBean localEcshopConfBean = new EcshopConfBean();
    if (!StringUtil.a(paramString)) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localEcshopConfBean.jdField_b_of_type_Int = paramString.optInt("jump_tab_id", 2);
        localEcshopConfBean.jdField_c_of_type_Int = paramString.optInt("tab_switch");
        localEcshopConfBean.jdField_b_of_type_JavaLangString = paramString.optString("tab_background", "#FFFFFF");
        localEcshopConfBean.jdField_d_of_type_Int = paramString.optInt("is_preload");
        localEcshopConfBean.jdField_a_of_type_Int = paramString.optInt("ark_report_switch", 1);
        localEcshopConfBean.jdField_a_of_type_JavaLangString = paramString.optString("btn_txt");
        localEcshopConfBean.jdField_c_of_type_JavaLangString = paramString.optString("minus_view_titie_url", "https://i.gtimg.cn/channel/imglib/202005/upload_0130d1d150ac825d9804c01c17955272.png");
        localEcshopConfBean.jdField_d_of_type_JavaLangString = paramString.optString("recommend_title_url", "https://i.gtimg.cn/channel/imglib/202005/upload_d10f6014892e80a6195c5a965a6b8ac0.png");
        Object localObject1 = paramString.optJSONArray("tabs");
        Object localObject2;
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          localObject2 = new ArrayList(((JSONArray)localObject1).length());
          if (i < ((JSONArray)localObject1).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject1).optJSONObject(i);
            EcshopConfBean.TabConfBean localTabConfBean = new EcshopConfBean.TabConfBean();
            localTabConfBean.jdField_a_of_type_Int = localJSONObject.optInt("tabid");
            localTabConfBean.jdField_c_of_type_JavaLangString = localJSONObject.optString("icon_normal");
            localTabConfBean.jdField_d_of_type_JavaLangString = localJSONObject.optString("icon_selected");
            localTabConfBean.e = localJSONObject.optString("textcolor_normal", "#CCCCCC");
            localTabConfBean.f = localJSONObject.optString("textcolor_selected", "#000000");
            localTabConfBean.jdField_b_of_type_JavaLangString = localJSONObject.optString("jump_url", "https://h5.qianbao.qq.com/qqshop/index?_wwv=128&_wv=7");
            localTabConfBean.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
            localTabConfBean.jdField_b_of_type_Int = localJSONObject.optInt("page_type", 0);
            localTabConfBean.g = localJSONObject.optString("min_app_version", "8.3.3");
            if (!((ArrayList)localObject2).contains(localTabConfBean)) {
              ((ArrayList)localObject2).add(localTabConfBean);
            }
          }
          else
          {
            localEcshopConfBean.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
          }
        }
        else
        {
          localObject1 = paramString.optJSONObject("promotion");
          if (localObject1 != null)
          {
            paramString = localEcshopConfBean.jdField_a_of_type_ComTencentBizPubaccountEcshopassitConfEcshopConfBean$PromotionConfBean;
            paramString.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("begin_time");
            paramString.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("end_time");
            paramString.jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).optString("rain_url");
            paramString.jdField_d_of_type_JavaLangString = ((JSONObject)localObject1).optString("rain_icon_url");
            paramString.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("is_preload");
            localObject2 = ((JSONObject)localObject1).optJSONObject("warm_up");
            if (localObject2 != null)
            {
              paramString.jdField_a_of_type_JavaUtilMap.put("bottom_bg_url", ((JSONObject)localObject2).optString("bottom_bg_url"));
              paramString.jdField_a_of_type_JavaUtilMap.put("bottom_ani_url", ((JSONObject)localObject2).optString("bottom_ani_url"));
              paramString.jdField_a_of_type_JavaUtilMap.put("discount_bg_url", ((JSONObject)localObject2).optString("discount_bg_url"));
              paramString.jdField_a_of_type_JavaUtilMap.put("detail_bg_url", ((JSONObject)localObject2).optString("detail_bg_url"));
              paramString.jdField_a_of_type_JavaUtilMap.put("detail_logo_url", ((JSONObject)localObject2).optString("detail_logo_url"));
            }
            localObject1 = ((JSONObject)localObject1).optJSONObject("high_tide");
            if (localObject1 != null)
            {
              paramString.jdField_b_of_type_JavaUtilMap.put("top_bg_url", ((JSONObject)localObject1).optString("top_bg_url"));
              paramString.jdField_b_of_type_JavaUtilMap.put("bottom_bg_url", ((JSONObject)localObject1).optString("bottom_bg_url"));
              paramString.jdField_b_of_type_JavaUtilMap.put("bottom_ani_url", ((JSONObject)localObject1).optString("bottom_ani_url"));
              paramString.jdField_b_of_type_JavaUtilMap.put("discount_bg_url", ((JSONObject)localObject1).optString("discount_bg_url"));
              paramString.jdField_b_of_type_JavaUtilMap.put("detail_bg_url", ((JSONObject)localObject1).optString("detail_bg_url"));
            }
          }
          return localEcshopConfBean;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return localEcshopConfBean;
      }
      i += 1;
    }
  }
  
  public EcshopConfBean.TabConfBean a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      EcshopConfBean.TabConfBean localTabConfBean = (EcshopConfBean.TabConfBean)localIterator.next();
      if (localTabConfBean.jdField_a_of_type_Int == paramInt) {
        return localTabConfBean;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfBean
 * JD-Core Version:    0.7.0.1
 */