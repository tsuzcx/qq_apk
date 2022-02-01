package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.pts_bind_action.ArticleBottomAdInfoBindUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.ReadInjoyAdBannerVideoGameCell;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusBannerVideoItemData
  extends AdData
{
  public long f;
  public boolean f;
  public boolean g = false;
  
  public ProteusBannerVideoItemData()
  {
    super(17);
    this.jdField_f_of_type_Boolean = false;
    this.jdField_f_of_type_Long = 0L;
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (FastWeqAdUtils.a(this)) {
      return ReadInjoyAdBannerVideoGameCell.a(localJSONObject1, this);
    }
    try
    {
      localJSONObject1.put("style_ID", "ReadInjoy_ad_banner_video_cell");
      Object localObject;
      if (!TextUtils.isEmpty(this.b))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", this.b);
      }
      switch (this.p)
      {
      case 1: 
        ((JSONObject)localObject).put("bottom_line_number", "2");
        ((JSONObject)localObject).put("text_color", "#bbbbbb");
        for (;;)
        {
          localJSONObject1.put("id_tv_title", localObject);
          if (!TextUtils.isEmpty(this.d))
          {
            localObject = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(this.d, 4);
            localJSONObject2 = new JSONObject();
            localJSONObject2.put("image_url", ((URL)localObject).toString());
            localJSONObject1.put("id_ad_banner_bottom_imge", localJSONObject2);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProteusBannerVideoItemData", 2, "detail ad Bottom Pic adInconText:" + this.D);
          }
          localObject = new JSONObject();
          switch (this.p)
          {
          case 1: 
            ((JSONObject)localObject).put("bottom_background_color", "#f8f8f8");
            localJSONObject1.put("id_operate_area", localObject);
            localJSONObject1.put("id_ad_title", new JSONObject());
            localJSONObject1.put("id_ad_title_rl", new JSONObject());
            localObject = null;
            if (TextUtils.isEmpty(this.A)) {
              break label477;
            }
            localObject = this.A;
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              localJSONObject2 = new JSONObject();
              localJSONObject2.put("text", localObject);
            }
            switch (this.p)
            {
            case 1: 
              localJSONObject2.put("text_color", "#000000");
              localJSONObject1.put("id_tv_author", localJSONObject2);
              localObject = new JSONObject();
              ((JSONObject)localObject).put("article_model", this);
              localJSONObject1.put("id_ad_banner_bottom_video", localObject);
              ArticleBottomAdInfoBindUtils.a(this, localJSONObject1);
              return localJSONObject1;
              ((JSONObject)localObject).put("bottom_line_number", "1");
              ((JSONObject)localObject).put("text_color", "#a6a6a6");
            }
            break;
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        JSONObject localJSONObject2;
        localJSONException.printStackTrace();
        break;
        localJSONException.put("bottom_line_number", "2");
        localJSONException.put("text_color", "#a6a6a6");
        continue;
        localJSONException.put("bottom_background_color", "#ffffff");
        localJSONException.put("bottom_border_color", "#e6e6e6");
        localJSONException.put("bottom_border_width", "0.5");
        continue;
        label477:
        if (!TextUtils.isEmpty(this.i))
        {
          String str = this.i;
          continue;
          localJSONObject2.put("text_color", "#262626");
          continue;
          continue;
        }
      }
    }
    return localJSONObject1;
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
      this.a = ((TemplateBean)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData
 * JD-Core Version:    0.7.0.1
 */