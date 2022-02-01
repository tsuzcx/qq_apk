package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.ReadInjoyAdBannerInnerGameCell;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.pts.api.ITemplateFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.math.RoundingMode;
import java.net.URL;
import java.text.NumberFormat;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusInnerData
  extends AdData
{
  public int a = -1;
  public int b = 0;
  public ProteusInnerData.InnerFormItem c = null;
  private int d = 1;
  private int e = 1;
  private String f = "";
  private boolean g;
  
  public ProteusInnerData()
  {
    super(22);
  }
  
  private String a(String paramString)
  {
    if (b(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("已售");
      localStringBuilder.append(d(paramString));
      localStringBuilder.append("件");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private void a(JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString)
  {
    paramJSONObject1.put("author_recommend_tag_img", "rij_ad_tag_author");
    paramJSONObject2.put("id_ad_author_tag_img", paramJSONObject1);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.equalsIgnoreCase("京东"))
    {
      paramJSONObject1 = new JSONObject();
      paramJSONObject1.put("jd_tag_img", "rij_jd_tag_img");
      paramJSONObject2.put("id_ad_jd_tag_img", paramJSONObject1);
      return;
    }
    if (paramString.equalsIgnoreCase("拼多多"))
    {
      paramJSONObject1 = new JSONObject();
      paramJSONObject1.put("pdd_tag_img", "rij_pdd_tag_img");
      paramJSONObject2.put("id_ad_pdd_tag_img", paramJSONObject1);
    }
  }
  
  private void a(JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString1, String paramString2)
  {
    paramJSONObject1.put("article_model", this);
    paramJSONObject2.put("id_view_AdDownloadView", paramJSONObject1);
    paramJSONObject1 = new JSONObject();
    paramJSONObject1.put("title_text_color", "#000000");
    paramJSONObject1.put("text_title", paramString2);
    paramJSONObject2.put("id_inner_title", paramJSONObject1);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramJSONObject1 = new JSONObject();
      paramJSONObject1.put("text_default_color", "#99000000");
      paramJSONObject1.put("text_default", paramString1);
      paramJSONObject2.put("id_inner_default_label", paramJSONObject1);
    }
  }
  
  private void a(JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    String str = paramString5;
    if (TextUtils.isEmpty(paramString5)) {
      str = "详情";
    }
    paramJSONObject1.put("text_button", str);
    paramJSONObject2.put("id_inner_ad_button", paramJSONObject1);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramJSONObject1 = new JSONObject();
      paramJSONObject1.put("text_price", paramString1);
      paramJSONObject2.put("id_inner_ad_price", paramJSONObject1);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramJSONObject1 = new JSONObject();
      paramJSONObject1.put("text_ad_tag", paramString2);
      paramJSONObject2.put("id_inner_ad_tag", paramJSONObject1);
    }
    if (b(paramString7))
    {
      paramJSONObject1.put("saleText", a(paramString7));
      paramJSONObject2.put("id_inner_ad_sale_num", paramJSONObject1);
    }
    else if ((!TextUtils.isEmpty(paramString3)) && (!paramString3.equalsIgnoreCase(paramString1)))
    {
      paramJSONObject1 = new JSONObject();
      paramJSONObject1.put("text_sale_price", paramString3);
      paramJSONObject1.put("sale_price_color", "#99000000");
      paramJSONObject2.put("id_inner_ad_sale_price", paramJSONObject1);
      paramJSONObject1 = new JSONObject();
      paramJSONObject1.put("sale_price_line_color", "#c2c2c2");
      paramJSONObject2.put("id_inner_ad_sale_price_line", paramJSONObject1);
    }
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString3)) && (TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString4)))
    {
      paramJSONObject1 = new JSONObject();
      paramJSONObject1.put("text_default_color", "#99000000");
      paramJSONObject1.put("text_default", paramString4);
      paramJSONObject2.put("id_inner_default_label", paramJSONObject1);
    }
    paramJSONObject1 = new JSONObject();
    paramJSONObject1.put("title_text_color", "#000000");
    paramJSONObject1.put("text_title", paramString9);
    paramJSONObject2.put("id_inner_title", paramJSONObject1);
    if (paramString8.equalsIgnoreCase("1"))
    {
      a(paramJSONObject1, paramJSONObject2, paramString6);
    }
    else if (paramString8.equalsIgnoreCase("2"))
    {
      paramJSONObject2.remove("id_inner_title");
      paramJSONObject2.put("rich_text_line", 2);
      paramJSONObject2.put("richtext_title", paramString9);
    }
    paramJSONObject2.put("id_inner_ad_sale_price_container", new JSONObject());
  }
  
  private boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        int i = Integer.parseInt(paramString);
        bool1 = bool2;
        if (i > 100) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private void c(JSONObject paramJSONObject)
  {
    this.f = paramJSONObject.optString("pop_sheet");
    try
    {
      Object localObject2 = new JSONObject(this.f);
      Object localObject1 = ((JSONObject)localObject2).optJSONObject("formContent").optJSONArray("items");
      paramJSONObject = ((JSONObject)localObject2).optJSONObject("formContent").optJSONObject("submitButton");
      localObject1 = ((JSONArray)localObject1).optJSONObject(0);
      int i = ((JSONObject)localObject1).optInt("regexType");
      localObject2 = ((JSONObject)localObject2).optJSONObject("formContent").getJSONObject("formRegex");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      localObject2 = ((JSONObject)localObject2).getString(localStringBuilder.toString());
      this.c = new ProteusInnerData.InnerFormItem(this, ((JSONObject)localObject1).optInt("regexType"), ((JSONObject)localObject1).optString("name"), ((JSONObject)localObject1).optString("placeholder"), paramJSONObject.optString("text"), (JSONObject)localObject1, Pattern.compile((String)localObject2));
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private String d(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      NumberFormat localNumberFormat = NumberFormat.getNumberInstance();
      localNumberFormat.setMaximumFractionDigits(1);
      localNumberFormat.setRoundingMode(RoundingMode.HALF_UP);
      if (i < 10000) {
        return String.valueOf(i);
      }
      if (i < 99990000)
      {
        double d1 = i * 100;
        Double.isNaN(d1);
        d1 = d1 / 100.0D / 10000.0D;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localNumberFormat.format(d1));
        localStringBuilder.append("万");
        return localStringBuilder.toString();
      }
      return "9999万+";
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  private JSONObject d(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_large_pic_cell");
      boolean bool = TextUtils.isEmpty(this.l);
      if (!bool)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", this.l);
        paramJSONObject.put("id_ad_title", localObject);
      }
      if (!TextUtils.isEmpty(this.n))
      {
        localObject = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(this.n, 4);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("image_url", ((URL)localObject).toString());
        paramJSONObject.put("id_ad_banner_inner_imge", localJSONObject);
      }
      Object localObject = new JSONObject();
      if (!TextUtils.isEmpty(this.ah))
      {
        ((JSONObject)localObject).put("text", this.ah);
        paramJSONObject.put("id_ad_dislike_button", localObject);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("detail ad inner largeStyle Pic adInconText:");
        ((StringBuilder)localObject).append(this.ah);
        QLog.d("ProteusInnerData", 2, ((StringBuilder)localObject).toString());
      }
      paramJSONObject.put("id_ad_banner_inner_large_root", new JSONObject());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("article_model", this);
      if (this.g)
      {
        paramJSONObject.put("id_operate_edit_area", localObject);
        return paramJSONObject;
      }
      paramJSONObject.put("id_operate_app_area", localObject);
      paramJSONObject.put("id_view_AdDownloadView", localObject);
      localObject = new JSONObject();
      if (!TextUtils.isEmpty(this.u)) {
        ((JSONObject)localObject).put("text", this.u);
      } else if (!TextUtils.isEmpty(this.X)) {
        ((JSONObject)localObject).put("text", this.X);
      }
      paramJSONObject.put("id_app_name", localObject);
      return paramJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramJSONObject;
  }
  
  private JSONObject e(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_small_pic_cell");
      boolean bool = TextUtils.isEmpty(this.l);
      if (!bool)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", this.l);
        paramJSONObject.put("id_inner_title", localObject);
      }
      if (!TextUtils.isEmpty(this.n))
      {
        localObject = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(this.n, 4);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("image_url", ((URL)localObject).toString());
        paramJSONObject.put("id_inner_small_img", localJSONObject);
      }
      if (!TextUtils.isEmpty(this.ah))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", this.ah);
        paramJSONObject.put("id_inner_ad_name", localObject);
      }
      if (!TextUtils.isEmpty(this.X))
      {
        localObject = new JSONObject();
        if (TextUtils.isEmpty(this.ah)) {
          ((JSONObject)localObject).put("text", ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).processTextLength(this.X, 16));
        } else {
          ((JSONObject)localObject).put("text", ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).processTextLength(this.X, 12));
        }
        paramJSONObject.put("id_inner_name", localObject);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("detail ad inner smallStyle Pic adInconText:");
        ((StringBuilder)localObject).append(this.ah);
        QLog.d("ProteusInnerData", 2, ((StringBuilder)localObject).toString());
      }
      paramJSONObject.put("id_ad_banner_inner_small_root", new JSONObject());
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("article_model", this);
      if (this.g)
      {
        paramJSONObject.put("id_operate_edit_area", localObject);
        return paramJSONObject;
      }
      paramJSONObject.put("id_view_AdDownloadView", localObject);
      return paramJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramJSONObject;
  }
  
  private JSONObject f(JSONObject paramJSONObject)
  {
    paramJSONObject = e(paramJSONObject);
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
  
  private JSONObject g(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
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
        if (this.aE != null)
        {
          int i = this.aE.optInt("goodsType");
          Object localObject2 = this.aE.optString("goodsPromotionPrice", "");
          localObject1 = this.aE.optString("goodsPrice", "");
          String str3 = this.aE.optString("goodsPromotionTxt", "");
          Object localObject5 = this.aE.optString("buttonTxt", "");
          Object localObject4 = this.aE.optString("button");
          localObject3 = h(this.aE);
          String str4 = ((JSONObject)localObject3).optString("source_type", "");
          String str5 = ((JSONObject)localObject3).optString("sales", "");
          String str6 = ((JSONObject)localObject3).optString("line_number_kol", "1");
          String str2 = ((JSONObject)localObject3).optString("button_txt_kol", "");
          String str7 = this.aE.optString("goodsName", "");
          if ((i != 1) && (TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            localObject3 = "";
            localObject2 = localObject1;
            localObject1 = localObject5;
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = localObject5;
              if (TextUtils.isEmpty((CharSequence)localObject3))
              {
                localObject1 = localObject5;
                if (TextUtils.isEmpty(str3))
                {
                  localObject1 = localObject5;
                  if (TextUtils.isEmpty((CharSequence)localObject5)) {
                    localObject1 = "文章同款";
                  }
                }
              }
            }
            localObject5 = new JSONObject();
            if (i != 1)
            {
              if ((!TextUtils.isEmpty(str6)) && (!TextUtils.isEmpty(str2)))
              {
                paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_kol_soft_ad_cell");
                localObject1 = str2;
                localObject4 = localObject1;
              }
              else
              {
                paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_soft_ad_cell");
              }
              a((JSONObject)localObject5, paramJSONObject, (String)localObject2, str3, (String)localObject3, (String)localObject1, (String)localObject4, str4, str5, str6, str7);
            }
            else
            {
              paramJSONObject.put("style_ID", "ReadInjoy_ad_banner_inner_soft_ad_cell");
              a((JSONObject)localObject5, paramJSONObject, (String)localObject1, str7);
            }
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("image_url", ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(this.aE.optString("adImg", ""), 4).toString());
            if (!f()) {
              break label587;
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
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return paramJSONObject;
      }
      Object localObject3 = localException;
      continue;
      label587:
      String str1 = "2.0";
    }
  }
  
  private JSONObject h(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("extendInfo");
    if (TextUtils.isEmpty(paramJSONObject)) {
      return new JSONObject();
    }
    try
    {
      paramJSONObject = new JSONObject(paramJSONObject);
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.d("ProteusInnerData", 1, "getExtendInfo error", paramJSONObject);
    }
    return new JSONObject();
  }
  
  private JSONObject q()
  {
    JSONObject localJSONObject = new JSONObject();
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameComponentType(this)) {
      return ReadInjoyAdBannerInnerGameCell.a(localJSONObject, this);
    }
    int i = this.d;
    if (i == 2) {
      return e(localJSONObject);
    }
    if (i == 1) {
      return d(localJSONObject);
    }
    if (i == 3) {
      return f(localJSONObject);
    }
    return g(localJSONObject);
  }
  
  public void a()
  {
    this.bb = q();
    Object localObject;
    try
    {
      TemplateBean localTemplateBean = ((ITemplateFactory)QRoute.api(ITemplateFactory.class)).getTemplateBean("native_article", true, this.bb);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localObject = null;
    }
    if (localObject != null) {
      this.bd = localObject;
    }
  }
  
  public boolean a(JSONObject paramJSONObject, int paramInt)
  {
    super.a(paramJSONObject, paramInt);
    Object localObject;
    if (paramJSONObject != null)
    {
      this.f = paramJSONObject.optString("pop_sheet");
      localObject = paramJSONObject.opt("soft_ad_data");
      if ((localObject instanceof JSONObject))
      {
        localObject = (JSONObject)localObject;
        this.aF = ((JSONObject)localObject).optInt("open_float_switch");
        this.aH = ((JSONObject)localObject).optString("cmsid");
        localObject = ((JSONObject)localObject).opt("soft_ad");
        if ((localObject instanceof JSONObject)) {
          this.aE = ((JSONObject)localObject);
        }
      }
      localObject = paramJSONObject.optString("inner_ad");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("fillSpecialData->inner_ad:");
          localStringBuilder.append((String)localObject);
          QLog.d("ProteusInnerData", 1, localStringBuilder.toString());
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        this.e = ((JSONObject)localObject).optInt("pos_type");
        this.a = ((JSONObject)localObject).optInt("para_pos");
        a("para_pos", Integer.valueOf(this.a));
        if ((((JSONObject)localObject).optInt("has_sheet") != 1) || (this.ab)) {
          break label466;
        }
        bool = true;
        this.g = bool;
        this.al = ((JSONObject)localObject).optString("cash_tag");
        paramInt = ((JSONObject)localObject).optInt("style");
        try
        {
          if (this.g) {
            c(paramJSONObject);
          }
          this.j = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(this);
        }
        catch (Exception paramJSONObject) {}
        paramJSONObject.printStackTrace();
      }
      catch (Exception paramJSONObject)
      {
        paramInt = 0;
      }
      if (this.aG == 1) {
        paramInt = 4;
      }
      int i = this.e;
      if ((i != 2) && ((i != 1) || (this.a <= 0)))
      {
        if (paramInt == 4)
        {
          this.d = paramInt;
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.e("ProteusInnerData", 1, "fillSpecialData->check available fail");
          }
          return false;
        }
      }
      else if ((paramInt == 2) || (paramInt == 1) || (paramInt == 3)) {
        this.d = paramInt;
      }
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("fillSpecialData->");
        paramJSONObject.append(this);
        QLog.d("ProteusInnerData", 1, paramJSONObject.toString());
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.e("ProteusInnerData", 1, "fillSpecialData->inner_ad empty");
      }
      return false;
      if (QLog.isColorLevel()) {
        QLog.e("ProteusInnerData", 1, "fillSpecialData->jsonObject null");
      }
      return false;
      label466:
      boolean bool = false;
    }
  }
  
  public boolean b()
  {
    return this.d == 1;
  }
  
  public boolean c()
  {
    return this.d == 2;
  }
  
  public boolean d()
  {
    return this.d == 3;
  }
  
  public boolean e()
  {
    return this.d == 4;
  }
  
  public boolean f()
  {
    return (e()) && (this.aE != null) && (this.aE.optInt("goodsType", -1) == 1);
  }
  
  public boolean g()
  {
    return ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameComponentType(this);
  }
  
  public boolean h()
  {
    return this.e == 2;
  }
  
  public String i()
  {
    return h(this.aE).optString("daihuo_id");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ProteusInnerData[formId:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",  style:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",  pos_type:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",  para_pos:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",\n formItem:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData
 * JD-Core Version:    0.7.0.1
 */