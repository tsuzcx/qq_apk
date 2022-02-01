package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.pts_bind_action.ArticleBottomAdInfoBindUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.ReadInjoyAdBannerGameCell;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.ReadInjoyAdBannerPkCell;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.pts.api.ITemplateFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusBannerBigPicItemData
  extends AdData
{
  public String a;
  public boolean a;
  public String b = "";
  public String c;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  
  public ProteusBannerBigPicItemData()
  {
    super(10);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  private JSONObject a()
  {
    localJSONObject = new JSONObject();
    if (FastWeqAdUtils.b(this)) {
      return ReadInjoyAdBannerPkCell.a(localJSONObject, this);
    }
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameComponentType(this)) {
      return ReadInjoyAdBannerGameCell.a(localJSONObject, this);
    }
    try
    {
      bool = a(this);
      localObject3 = null;
      if (!bool) {
        return null;
      }
      bool = this.jdField_a_of_type_Boolean;
      if (bool) {
        localJSONObject.put("style_ID", "ReadInjoy_ad_banner_large_pic_location_cell");
      }
    }
    catch (JSONException localJSONException)
    {
      boolean bool;
      Object localObject1;
      Object localObject4;
      double d1;
      double d2;
      label139:
      label142:
      String str3;
      int i;
      long l;
      localJSONException.printStackTrace();
      return localJSONObject;
    }
    try
    {
      localObject1 = new double[2];
    }
    catch (Exception localException1)
    {
      break label139;
    }
    try
    {
      localObject4 = this.e;
      d1 = ParseUtil.a(this.d, 0.0D);
      d2 = ParseUtil.a((String)localObject4, 0.0D);
      if ((d2 == 0.0D) && (d1 == 0.0D)) {
        return null;
      }
      localObject1[0] = d1;
      localObject1[1] = d2;
    }
    catch (Exception localException2)
    {
      break label142;
      localObject3 = localException2;
      break label365;
      localObject3 = str2;
      Object localObject2 = str1;
      break label365;
    }
    localObject1 = null;
    if (localObject1 == null) {
      d1 = 0.0D;
    } else {
      d1 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getADDistanceByPos((double[])localObject1, BaseApplicationImpl.getContext());
    }
    localObject1 = this.h;
    localObject4 = this.b;
    str2 = this.f;
    str3 = this.jdField_c_of_type_JavaLangString;
    i = ParseUtil.a((String)localObject1, 3000);
    str1 = "";
    if (d1 <= 0.0D)
    {
      d1 = 0.0D;
      localObject1 = "";
    }
    else
    {
      d1 = Math.ceil(d1);
      localObject1 = localObject3;
    }
    localObject3 = new StringBuilder();
    if (d1 != 0.0D)
    {
      d2 = i;
      if (d1 <= d2)
      {
        if (d1 < 1000.0D)
        {
          ((StringBuilder)localObject3).append((int)d1);
          ((StringBuilder)localObject3).append('m');
          localObject1 = ((StringBuilder)localObject3).toString();
          localObject3 = localObject4;
        }
        else
        {
          if (d1 >= d2) {
            break label952;
          }
          l = Math.round(d1 / 1000.0D);
          if (l < 1000L)
          {
            ((StringBuilder)localObject3).append(l);
            ((StringBuilder)localObject3).append("km");
          }
          else
          {
            ((StringBuilder)localObject3).append("999km");
          }
          localObject1 = ((StringBuilder)localObject3).toString();
          localObject3 = localObject4;
        }
        label365:
        localObject4 = new JSONObject();
        ((JSONObject)localObject4).put("ad_Location", localObject1);
        ((JSONObject)localObject4).put("ad_Location_content", localObject3);
        ((JSONObject)localObject4).put("ad_url", str3);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("ad_Location", localObject4);
        localJSONObject.put("id_view_ad_locationView", localObject1);
        localJSONObject.put("id_mid_line", localObject1);
        break label456;
        localJSONObject.put("style_ID", "ReadInjoy_ad_banner_large_pic_cell");
        label456:
        bool = TextUtils.isEmpty(this.j);
        if (!bool)
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("text", this.j);
          i = this.r;
          if (i != 1)
          {
            if (i != 2)
            {
              ((JSONObject)localObject1).put("bottom_line_number", "2");
              ((JSONObject)localObject1).put("text_color", "#bbbbbb");
            }
            else
            {
              ((JSONObject)localObject1).put("bottom_line_number", "2");
              ((JSONObject)localObject1).put("text_color", "#a6a6a6");
            }
          }
          else
          {
            ((JSONObject)localObject1).put("bottom_line_number", "1");
            ((JSONObject)localObject1).put("text_color", "#a6a6a6");
          }
          localJSONObject.put("id_tv_title", localObject1);
        }
        if (!TextUtils.isEmpty(this.l))
        {
          localObject1 = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(this.l, 4);
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("image_url", ((URL)localObject1).toString());
          localJSONObject.put("id_ad_banner_bottom_imge", localObject3);
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("detail ad Bottom Pic adInconText:");
          ((StringBuilder)localObject1).append(this.L);
          QLog.d("ProteusBannerBigPicItemData", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = new JSONObject();
        i = this.r;
        if ((i != 1) && (i != 2))
        {
          ((JSONObject)localObject1).put("bottom_background_color", "#f8f8f8");
        }
        else
        {
          ((JSONObject)localObject1).put("bottom_background_color", "#ffffff");
          ((JSONObject)localObject1).put("bottom_border_color", "#e6e6e6");
          ((JSONObject)localObject1).put("bottom_border_width", "0.5");
        }
        localJSONObject.put("id_operate_area", localObject1);
        localJSONObject.put("id_ad_title", new JSONObject());
        localJSONObject.put("id_ad_title_rl", new JSONObject());
        if (!TextUtils.isEmpty(this.q))
        {
          localObject1 = new JSONObject();
          if ((this.jdField_a_of_type_Boolean) && (this.q.length() > 8)) {
            this.q = this.q.substring(0, 8).concat("...");
          }
          ((JSONObject)localObject1).put("text", this.q);
          i = this.r;
          if ((i != 1) && (i != 2)) {
            ((JSONObject)localObject1).put("text_color", "#000000");
          } else {
            ((JSONObject)localObject1).put("text_color", "#262626");
          }
          localJSONObject.put("id_tv_author", localObject1);
        }
        ArticleBottomAdInfoBindUtils.a(this, localJSONObject);
        return localJSONObject;
      }
    }
  }
  
  private boolean a(ProteusBannerBigPicItemData paramProteusBannerBigPicItemData)
  {
    return (!TextUtils.isEmpty(this.j)) && (!TextUtils.isEmpty(this.l)) && (!TextUtils.isEmpty(this.q));
  }
  
  public void a()
  {
    this.jdField_c_of_type_OrgJsonJSONObject = a();
    Object localObject;
    try
    {
      TemplateBean localTemplateBean = ((ITemplateFactory)QRoute.api(ITemplateFactory.class)).getTemplateBean("native_article", true, this.jdField_c_of_type_OrgJsonJSONObject);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localObject = null;
    }
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData
 * JD-Core Version:    0.7.0.1
 */