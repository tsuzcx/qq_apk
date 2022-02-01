package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.ReadInjoyAdBannerInnerGameCell;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdInnerUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyBottomAdVideoUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusInnerData
  extends AdData
{
  private int A;
  private int B = 1;
  private String X = "";
  public ProteusInnerData.InnerFormItem a;
  private boolean f;
  public int y = -1;
  public int z = 0;
  
  public ProteusInnerData()
  {
    super(22);
    this.jdField_A_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData$InnerFormItem = null;
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    if (FastWeqAdUtils.a(this)) {
      return ReadInjoyAdBannerInnerGameCell.a(localJSONObject, this);
    }
    if (this.jdField_A_of_type_Int == 2) {
      return b(localJSONObject);
    }
    if (this.jdField_A_of_type_Int == 1) {
      return a(localJSONObject);
    }
    if (this.jdField_A_of_type_Int == 3) {
      return c(localJSONObject);
    }
    return d(localJSONObject);
  }
  
  private JSONObject a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_large_pic_cell");
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("text", this.jdField_b_of_type_JavaLangString);
          paramJSONObject.put("id_ad_title", localObject);
        }
        if (!TextUtils.isEmpty(this.d))
        {
          localObject = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(this.d, 4);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("image_url", ((URL)localObject).toString());
          paramJSONObject.put("id_ad_banner_inner_imge", localJSONObject);
        }
        Object localObject = new JSONObject();
        if (!TextUtils.isEmpty(this.D))
        {
          ((JSONObject)localObject).put("text", this.D);
          paramJSONObject.put("id_ad_dislike_button", localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ProteusInnerData", 2, "detail ad inner largeStyle Pic adInconText:" + this.D);
        }
        paramJSONObject.put("id_ad_banner_inner_large_root", new JSONObject());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("article_model", this);
        if (this.f)
        {
          paramJSONObject.put("id_operate_edit_area", localObject);
          return paramJSONObject;
        }
        paramJSONObject.put("id_operate_app_area", localObject);
        paramJSONObject.put("id_view_AdDownloadView", localObject);
        localObject = new JSONObject();
        if (!TextUtils.isEmpty(this.i))
        {
          ((JSONObject)localObject).put("text", this.i);
          paramJSONObject.put("id_app_name", localObject);
          return paramJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return paramJSONObject;
      }
      if (!TextUtils.isEmpty(this.jdField_A_of_type_JavaLangString)) {
        localJSONException.put("text", this.jdField_A_of_type_JavaLangString);
      }
    }
  }
  
  private JSONObject b(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_small_pic_cell");
      Object localObject;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", this.jdField_b_of_type_JavaLangString);
        paramJSONObject.put("id_inner_title", localObject);
      }
      if (!TextUtils.isEmpty(this.d))
      {
        localObject = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(this.d, 4);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("image_url", ((URL)localObject).toString());
        paramJSONObject.put("id_inner_small_img", localJSONObject);
      }
      if (!TextUtils.isEmpty(this.D))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", this.D);
        paramJSONObject.put("id_inner_ad_name", localObject);
      }
      if (!TextUtils.isEmpty(this.jdField_A_of_type_JavaLangString))
      {
        localObject = new JSONObject();
        if (!TextUtils.isEmpty(this.D)) {
          break label272;
        }
        ((JSONObject)localObject).put("text", ReadInJoyAdInnerUtils.a(this.jdField_A_of_type_JavaLangString, 16));
      }
      for (;;)
      {
        paramJSONObject.put("id_inner_name", localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ProteusInnerData", 2, "detail ad inner smallStyle Pic adInconText:" + this.D);
        }
        paramJSONObject.put("id_ad_banner_inner_small_root", new JSONObject());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("article_model", this);
        if (!this.f) {
          break;
        }
        paramJSONObject.put("id_operate_edit_area", localObject);
        return paramJSONObject;
        label272:
        ((JSONObject)localObject).put("text", ReadInJoyAdInnerUtils.a(this.jdField_A_of_type_JavaLangString, 12));
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
  
  private void c(JSONObject paramJSONObject)
  {
    this.X = paramJSONObject.optString("pop_sheet");
    try
    {
      Object localObject1 = new JSONObject(this.X);
      Object localObject2 = ((JSONObject)localObject1).optJSONObject("formContent").optJSONArray("items");
      paramJSONObject = ((JSONObject)localObject1).optJSONObject("formContent").optJSONObject("submitButton");
      localObject2 = ((JSONArray)localObject2).optJSONObject(0);
      int i = ((JSONObject)localObject2).optInt("regexType");
      localObject1 = ((JSONObject)localObject1).optJSONObject("formContent").getJSONObject("formRegex").getString("" + i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData$InnerFormItem = new ProteusInnerData.InnerFormItem(this, ((JSONObject)localObject2).optInt("regexType"), ((JSONObject)localObject2).optString("name"), ((JSONObject)localObject2).optString("placeholder"), paramJSONObject.optString("text"), (JSONObject)localObject2, Pattern.compile((String)localObject1));
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private JSONObject d(JSONObject paramJSONObject)
  {
    for (;;)
    {
      Object localObject4;
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
        String str1;
        if (this.jdField_b_of_type_OrgJsonJSONObject != null)
        {
          int i = this.jdField_b_of_type_OrgJsonJSONObject.optInt("goodsType");
          String str3 = this.jdField_b_of_type_OrgJsonJSONObject.optString("goodsPromotionPrice", "");
          localObject1 = this.jdField_b_of_type_OrgJsonJSONObject.optString("goodsPrice", "");
          localObject4 = this.jdField_b_of_type_OrgJsonJSONObject.optString("goodsPromotionTxt", "");
          str1 = this.jdField_b_of_type_OrgJsonJSONObject.optString("buttonTxt", "");
          if ((i == 1) || (!TextUtils.isEmpty(str3)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
            break label797;
          }
          localObject3 = "";
          if ((!TextUtils.isEmpty(str3)) || (!TextUtils.isEmpty((CharSequence)localObject3)) || (!TextUtils.isEmpty((CharSequence)localObject1)) || (!TextUtils.isEmpty(str1))) {
            break label794;
          }
          str1 = "文章同款";
          if (i != 1)
          {
            JSONObject localJSONObject = new JSONObject();
            String str2 = this.jdField_b_of_type_OrgJsonJSONObject.optString("button");
            localObject4 = str2;
            if (TextUtils.isEmpty(str2)) {
              localObject4 = "详情";
            }
            localJSONObject.put("text_button", localObject4);
            paramJSONObject.put("id_inner_ad_button", localJSONObject);
            if (!TextUtils.isEmpty(str3))
            {
              localObject4 = new JSONObject();
              ((JSONObject)localObject4).put("text_price", str3);
              paramJSONObject.put("id_inner_ad_price", localObject4);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject4 = new JSONObject();
              ((JSONObject)localObject4).put("text_ad_tag", localObject1);
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
            if ((TextUtils.isEmpty(str3)) && (TextUtils.isEmpty((CharSequence)localObject3)) && (TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str1)))
            {
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("text_default_color", "#99000000");
              ((JSONObject)localObject1).put("text_default", str1);
              paramJSONObject.put("id_inner_default_label", localObject1);
            }
            paramJSONObject.put("id_inner_ad_sale_price_container", new JSONObject());
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("title_text_color", "#000000");
            ((JSONObject)localObject1).put("text_title", this.jdField_b_of_type_OrgJsonJSONObject.optString("goodsName", ""));
            paramJSONObject.put("id_inner_title", localObject1);
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("image_url", ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(this.jdField_b_of_type_OrgJsonJSONObject.optString("adImg", ""), 4).toString());
            if (!f()) {
              break label787;
            }
            localObject1 = "8.0";
            ((JSONObject)localObject3).put("ad_icon_radius", localObject1);
            paramJSONObject.put("id_inner_small_img", localObject3);
          }
        }
        else
        {
          paramJSONObject.put("id_bottom_operation", new JSONObject());
          return paramJSONObject;
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("article_model", this);
        paramJSONObject.put("id_view_AdDownloadView", localObject1);
        if (TextUtils.isEmpty(str1)) {
          continue;
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("text_default_color", "#99000000");
        ((JSONObject)localObject1).put("text_default", str1);
        paramJSONObject.put("id_inner_default_label", localObject1);
        continue;
        localObject2 = "2.0";
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return paramJSONObject;
      }
      label787:
      continue;
      label794:
      continue;
      label797:
      Object localObject3 = localObject2;
      Object localObject2 = localObject4;
    }
  }
  
  public void a()
  {
    localObject3 = null;
    this.c = a();
    try
    {
      TemplateFactory localTemplateFactory = TemplateFactory.a("native_article", true);
      localObject1 = localObject3;
      if (localTemplateFactory != null) {
        localObject1 = localTemplateFactory.getTemplateBean(this.c);
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
  
  public boolean a(JSONObject paramJSONObject, int paramInt)
  {
    super.a(paramJSONObject, paramInt);
    if (paramJSONObject != null)
    {
      this.X = paramJSONObject.optString("pop_sheet");
      Object localObject = paramJSONObject.opt("soft_ad_data");
      if ((localObject instanceof JSONObject))
      {
        this.q = ((JSONObject)localObject).optInt("open_float_switch");
        this.N = ((JSONObject)localObject).optString("cmsid");
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
            this.B = ((JSONObject)localObject).optInt("pos_type");
            this.y = ((JSONObject)localObject).optInt("para_pos");
            a("para_pos", Integer.valueOf(this.y));
            if ((((JSONObject)localObject).optInt("has_sheet") == 1) && (!this.jdField_b_of_type_Boolean))
            {
              bool = true;
              this.f = bool;
              this.H = ((JSONObject)localObject).optString("cash_tag");
              paramInt = ((JSONObject)localObject).optInt("style");
            }
          }
          catch (Exception paramJSONObject)
          {
            boolean bool;
            paramInt = 0;
          }
          try
          {
            if (this.f) {
              c(paramJSONObject);
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ReadInJoyBottomAdVideoUtil.a(this);
            if (this.r == 1) {
              paramInt = 4;
            }
            if ((this.B != 2) && ((this.B != 1) || (this.y <= 0))) {
              break label366;
            }
            if ((paramInt == 2) || (paramInt == 1) || (paramInt == 3)) {
              this.jdField_A_of_type_Int = paramInt;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ProteusInnerData", 1, "fillSpecialData->" + this);
            }
            return true;
          }
          catch (Exception paramJSONObject)
          {
            break label359;
          }
          bool = false;
          continue;
          label359:
          paramJSONObject.printStackTrace();
          continue;
          label366:
          if (paramInt != 4) {
            break;
          }
          this.jdField_A_of_type_Int = paramInt;
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
    return this.jdField_A_of_type_Int == 1;
  }
  
  public boolean c()
  {
    return this.jdField_A_of_type_Int == 2;
  }
  
  public boolean d()
  {
    return this.jdField_A_of_type_Int == 3;
  }
  
  public boolean e()
  {
    return this.jdField_A_of_type_Int == 4;
  }
  
  public boolean f()
  {
    return (e()) && (this.jdField_b_of_type_OrgJsonJSONObject != null) && (this.jdField_b_of_type_OrgJsonJSONObject.optInt("goodsType", -1) == 1);
  }
  
  public boolean g()
  {
    return FastWeqAdUtils.a(this);
  }
  
  public boolean h()
  {
    return this.B == 2;
  }
  
  public String toString()
  {
    return "ProteusInnerData[formId:" + this.z + ",  style:" + this.jdField_A_of_type_Int + ",  pos_type:" + this.B + ",  para_pos:" + this.y + ",\n formItem:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData$InnerFormItem + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData
 * JD-Core Version:    0.7.0.1
 */