package com.tencent.biz.pubaccount.readinjoy.ad.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.regex.Pattern;
import obo;
import odk;
import odv;
import oec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sfq;
import swu;

public class ProteusInnerData
  extends AdData
{
  public int a;
  private String jdField_a_of_type_JavaLangString = "";
  public obo a;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private int x = 1;
  private int y = 1;
  
  public ProteusInnerData()
  {
    super(22);
    this.jdField_a_of_type_Int = -1;
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    if (odv.a(this)) {
      return odk.a(localJSONObject, this);
    }
    if (this.x == 2) {
      return b(localJSONObject);
    }
    if (this.x == 1) {
      return a(localJSONObject);
    }
    if (this.x == 3) {
      return c(localJSONObject);
    }
    return d(localJSONObject);
  }
  
  private JSONObject a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_large_pic_cell");
      if (!TextUtils.isEmpty(this.j))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", this.j);
        paramJSONObject.put("id_ad_title", localObject);
      }
      if (!TextUtils.isEmpty(this.l))
      {
        localObject = swu.a(this.l, 4);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("image_url", ((URL)localObject).toString());
        paramJSONObject.put("id_ad_banner_inner_imge", localJSONObject);
      }
      Object localObject = new JSONObject();
      if (!TextUtils.isEmpty(this.L))
      {
        ((JSONObject)localObject).put("text", this.L);
        paramJSONObject.put("id_ad_dislike_button", localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProteusInnerData", 2, "detail ad inner largeStyle Pic adInconText:" + this.L);
      }
      paramJSONObject.put("id_ad_banner_inner_large_root", new JSONObject());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("article_model", this);
      if (this.jdField_a_of_type_Boolean)
      {
        paramJSONObject.put("id_operate_edit_area", localObject);
        return paramJSONObject;
      }
      paramJSONObject.put("id_operate_app_area", localObject);
      paramJSONObject.put("id_view_AdDownloadView", localObject);
      if (!TextUtils.isEmpty(this.I))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", this.I);
        paramJSONObject.put("id_app_name", localObject);
        return paramJSONObject;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramJSONObject;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("pop_sheet");
    try
    {
      Object localObject1 = new JSONObject(this.jdField_a_of_type_JavaLangString);
      Object localObject2 = ((JSONObject)localObject1).optJSONObject("formContent").optJSONArray("items");
      paramJSONObject = ((JSONObject)localObject1).optJSONObject("formContent").optJSONObject("submitButton");
      localObject2 = ((JSONArray)localObject2).optJSONObject(0);
      int i = ((JSONObject)localObject2).optInt("regexType");
      localObject1 = ((JSONObject)localObject1).optJSONObject("formContent").getJSONObject("formRegex").getString("" + i);
      this.jdField_a_of_type_Obo = new obo(this, ((JSONObject)localObject2).optInt("regexType"), ((JSONObject)localObject2).optString("name"), ((JSONObject)localObject2).optString("placeholder"), paramJSONObject.optString("text"), (JSONObject)localObject2, Pattern.compile((String)localObject1));
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private JSONObject b(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_small_pic_cell");
      Object localObject;
      if (!TextUtils.isEmpty(this.j))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", this.j);
        paramJSONObject.put("id_inner_title", localObject);
      }
      if (!TextUtils.isEmpty(this.l))
      {
        localObject = swu.a(this.l, 4);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("image_url", ((URL)localObject).toString());
        paramJSONObject.put("id_inner_small_img", localJSONObject);
      }
      if (!TextUtils.isEmpty(this.L))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", this.L);
        paramJSONObject.put("id_inner_ad_name", localObject);
      }
      if (!TextUtils.isEmpty(this.I))
      {
        localObject = new JSONObject();
        if (!TextUtils.isEmpty(this.L)) {
          break label262;
        }
        ((JSONObject)localObject).put("text", oec.a(this.I, 16));
      }
      for (;;)
      {
        paramJSONObject.put("id_inner_name", localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ProteusInnerData", 2, "detail ad inner smallStyle Pic adInconText:" + this.L);
        }
        paramJSONObject.put("id_ad_banner_inner_small_root", new JSONObject());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("article_model", this);
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        paramJSONObject.put("id_operate_edit_area", localObject);
        return paramJSONObject;
        label262:
        ((JSONObject)localObject).put("text", oec.a(this.I, 12));
      }
      paramJSONObject.put("id_view_AdDownloadView", localJSONException);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return paramJSONObject;
    }
    return paramJSONObject;
  }
  
  private JSONObject c(JSONObject paramJSONObject)
  {
    paramJSONObject = b(paramJSONObject);
    try
    {
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_recommend_small_pic_cell");
      return paramJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramJSONObject;
  }
  
  private JSONObject d(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_soft_ad_cell");
        paramJSONObject.put("id_ad_banner_inner_small_root", new JSONObject());
        paramJSONObject.put("id_inner_main_area", new JSONObject());
        paramJSONObject.put("id_inner_button_area", new JSONObject());
        paramJSONObject.put("id_area_right_of_img", new JSONObject());
        paramJSONObject.put("id_inner_default_label", new JSONObject());
        paramJSONObject.put("id_label_article_separator_line_bottom", new JSONObject());
        paramJSONObject.put("id_inner_ad_sale_price_container", new JSONObject());
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("container_background_color", "#f7f7f7");
        paramJSONObject.put("id_ad_banner_inner_small_root", localObject1);
        if (this.jdField_b_of_type_OrgJsonJSONObject != null)
        {
          int i = this.jdField_b_of_type_OrgJsonJSONObject.optInt("goodsType");
          String str2 = this.jdField_b_of_type_OrgJsonJSONObject.optString("goodsPromotionPrice", "");
          localObject2 = this.jdField_b_of_type_OrgJsonJSONObject.optString("goodsPrice", "");
          localObject1 = this.jdField_b_of_type_OrgJsonJSONObject.optString("goodsPromotionTxt", "");
          Object localObject4 = this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonTxt", "");
          if ((i == 1) || (!TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
            break label785;
          }
          localObject3 = "";
          localObject1 = localObject4;
          if (TextUtils.isEmpty(str2))
          {
            localObject1 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject3))
            {
              localObject1 = localObject4;
              if (TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject1 = localObject4;
                if (TextUtils.isEmpty((CharSequence)localObject4)) {
                  localObject1 = "文章同款";
                }
              }
            }
          }
          if (i != 1)
          {
            localObject4 = new JSONObject();
            ((JSONObject)localObject4).put("text_button", this.jdField_b_of_type_OrgJsonJSONObject.optString("button", "购买"));
            paramJSONObject.put("id_inner_ad_button", localObject4);
            if (!TextUtils.isEmpty(str2))
            {
              localObject4 = new JSONObject();
              ((JSONObject)localObject4).put("text_price", str2);
              paramJSONObject.put("id_inner_ad_price", localObject4);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject4 = new JSONObject();
              ((JSONObject)localObject4).put("text_ad_tag", localObject2);
              paramJSONObject.put("id_inner_ad_tag", localObject4);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              localObject4 = new JSONObject();
              ((JSONObject)localObject4).put("text_sale_price", localObject3);
              ((JSONObject)localObject4).put("sale_price_color", "#99000000");
              paramJSONObject.put("id_inner_ad_sale_price", localObject4);
              localObject4 = new JSONObject();
              ((JSONObject)localObject4).put("sale_price_line_color", "#c2c2c2");
              paramJSONObject.put("id_inner_ad_sale_price_line", localObject4);
            }
            if ((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty((CharSequence)localObject3)) && (TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
            {
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("text_default_color", "#99000000");
              ((JSONObject)localObject2).put("text_default", localObject1);
              paramJSONObject.put("id_inner_default_label", localObject2);
            }
            paramJSONObject.put("id_inner_ad_sale_price_container", new JSONObject());
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("title_text_color", "#000000");
            ((JSONObject)localObject1).put("text_title", this.jdField_b_of_type_OrgJsonJSONObject.optString("goodsName", ""));
            paramJSONObject.put("id_inner_title", localObject1);
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("image_url", swu.a(this.jdField_b_of_type_OrgJsonJSONObject.optString("adImg", ""), 4).toString());
            if (!e()) {
              break label778;
            }
            localObject1 = "8.0";
            ((JSONObject)localObject2).put("ad_icon_radius", localObject1);
            paramJSONObject.put("id_inner_small_img", localObject2);
          }
        }
        else
        {
          paramJSONObject.put("id_bottom_operation", new JSONObject());
          return paramJSONObject;
        }
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("article_model", this);
        paramJSONObject.put("id_view_AdDownloadView", localObject2);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("text_default_color", "#99000000");
        ((JSONObject)localObject2).put("text_default", localObject1);
        paramJSONObject.put("id_inner_default_label", localObject2);
        continue;
        str1 = "2.0";
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return paramJSONObject;
      }
      label778:
      String str1;
      continue;
      label785:
      Object localObject3 = localObject2;
      Object localObject2 = str1;
    }
  }
  
  public void a()
  {
    localObject3 = null;
    this.jdField_c_of_type_OrgJsonJSONObject = a();
    try
    {
      sfq localsfq = sfq.a("native_article", true);
      localObject1 = localObject3;
      if (localsfq != null) {
        localObject1 = localsfq.getTemplateBean(this.jdField_c_of_type_OrgJsonJSONObject);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject1;
        localJSONException.printStackTrace();
        Object localObject2 = localObject3;
      }
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = ((TemplateBean)localObject1);
    }
  }
  
  public boolean a()
  {
    return this.x == 1;
  }
  
  public boolean a(JSONObject paramJSONObject, int paramInt)
  {
    super.a(paramJSONObject, paramInt);
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("pop_sheet");
      Object localObject = paramJSONObject.opt("soft_ad_data");
      if ((localObject instanceof JSONObject))
      {
        this.q = ((JSONObject)localObject).optInt("open_float_switch");
        this.V = ((JSONObject)localObject).optString("cmsid");
        localObject = ((JSONObject)localObject).opt("soft_ad");
        if ((localObject instanceof JSONObject)) {
          this.jdField_b_of_type_OrgJsonJSONObject = ((JSONObject)localObject);
        }
      }
      localObject = paramJSONObject.optString("inner_ad");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProteusInnerData", 1, "fillSpecialData->inner_ad:" + (String)localObject);
        }
        for (;;)
        {
          try
          {
            localObject = new JSONObject((String)localObject);
            this.y = ((JSONObject)localObject).optInt("pos_type");
            this.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("para_pos");
            a("para_pos", Integer.valueOf(this.jdField_a_of_type_Int));
            if ((((JSONObject)localObject).optInt("has_sheet") == 1) && (!this.jdField_c_of_type_Boolean))
            {
              bool = true;
              this.jdField_a_of_type_Boolean = bool;
              this.P = ((JSONObject)localObject).optString("cash_tag");
              paramInt = ((JSONObject)localObject).optInt("style");
              i = paramInt;
            }
          }
          catch (Exception paramJSONObject)
          {
            boolean bool;
            paramInt = 0;
          }
          try
          {
            if (this.jdField_a_of_type_Boolean)
            {
              a(paramJSONObject);
              i = paramInt;
            }
            if (this.r == 1) {
              i = 4;
            }
            if ((this.y != 2) && ((this.y != 1) || (this.jdField_a_of_type_Int <= 0))) {
              break label367;
            }
            if ((i == 2) || (i == 1) || (i == 3)) {
              this.x = i;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ProteusInnerData", 1, "fillSpecialData->" + this);
            }
            return true;
          }
          catch (Exception paramJSONObject)
          {
            break label358;
          }
          bool = false;
          continue;
          label358:
          paramJSONObject.printStackTrace();
          int i = paramInt;
          continue;
          label367:
          if (i != 4) {
            break;
          }
          this.x = i;
        }
        if (QLog.isColorLevel()) {
          QLog.e("ProteusInnerData", 1, "fillSpecialData->check available fail");
        }
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ProteusInnerData", 1, "fillSpecialData->inner_ad empty");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ProteusInnerData", 1, "fillSpecialData->jsonObject null");
    }
    return false;
  }
  
  public boolean b()
  {
    return this.x == 2;
  }
  
  public boolean c()
  {
    return this.x == 3;
  }
  
  public boolean d()
  {
    return this.x == 4;
  }
  
  public boolean e()
  {
    return (d()) && (this.jdField_b_of_type_OrgJsonJSONObject != null) && (this.jdField_b_of_type_OrgJsonJSONObject.optInt("goodsType", -1) == 1);
  }
  
  public boolean f()
  {
    return this.y == 2;
  }
  
  public String toString()
  {
    return "ProteusInnerData[formId:" + this.jdField_b_of_type_Int + ",  style:" + this.x + ",  pos_type:" + this.y + ",  para_pos:" + this.jdField_a_of_type_Int + ",\n formItem:" + this.jdField_a_of_type_Obo + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData
 * JD-Core Version:    0.7.0.1
 */