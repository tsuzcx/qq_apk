package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.pts_bind_action.ArticleBottomAdInfoBindUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.ReadInjoyAdBannerVideoGameCell;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.pts.api.ITemplateFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusBannerVideoItemData
  extends AdData
{
  public boolean a = false;
  public boolean b = false;
  public long c = 0L;
  
  public ProteusBannerVideoItemData()
  {
    super(17);
  }
  
  private JSONObject b()
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isGameComponentType(this)) {
      return ReadInjoyAdBannerVideoGameCell.a(localJSONObject1, this);
    }
    try
    {
      localJSONObject1.put("style_ID", "ReadInjoy_ad_banner_video_cell");
      boolean bool = TextUtils.isEmpty(this.l);
      if (!bool)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", this.l);
        i = this.aD;
        if (i != 1)
        {
          if (i != 2)
          {
            ((JSONObject)localObject).put("bottom_line_number", "2");
            ((JSONObject)localObject).put("text_color", "#bbbbbb");
          }
          else
          {
            ((JSONObject)localObject).put("bottom_line_number", "2");
            ((JSONObject)localObject).put("text_color", "#a6a6a6");
          }
        }
        else
        {
          ((JSONObject)localObject).put("bottom_line_number", "1");
          ((JSONObject)localObject).put("text_color", "#a6a6a6");
        }
        localJSONObject1.put("id_tv_title", localObject);
      }
      JSONObject localJSONObject2;
      if (!TextUtils.isEmpty(this.n))
      {
        localObject = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(this.n, 4);
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("image_url", ((URL)localObject).toString());
        localJSONObject1.put("id_ad_banner_bottom_imge", localJSONObject2);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("detail ad Bottom Pic adInconText:");
        ((StringBuilder)localObject).append(this.ah);
        QLog.d("ProteusBannerVideoItemData", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new JSONObject();
      int i = this.aD;
      if ((i != 1) && (i != 2))
      {
        ((JSONObject)localObject).put("bottom_background_color", "#f8f8f8");
      }
      else
      {
        ((JSONObject)localObject).put("bottom_background_color", "#ffffff");
        ((JSONObject)localObject).put("bottom_border_color", "#e6e6e6");
        ((JSONObject)localObject).put("bottom_border_width", "0.5");
      }
      localJSONObject1.put("id_operate_area", localObject);
      localJSONObject1.put("id_ad_title", new JSONObject());
      localJSONObject1.put("id_ad_title_rl", new JSONObject());
      localObject = null;
      if (!TextUtils.isEmpty(this.X)) {
        localObject = this.X;
      } else if (!TextUtils.isEmpty(this.u)) {
        localObject = this.u;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("text", localObject);
        i = this.aD;
        if ((i != 1) && (i != 2)) {
          localJSONObject2.put("text_color", "#000000");
        } else {
          localJSONObject2.put("text_color", "#262626");
        }
        localJSONObject1.put("id_tv_author", localJSONObject2);
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("article_model", this);
      localJSONObject1.put("id_ad_banner_bottom_video", localObject);
      ArticleBottomAdInfoBindUtils.a(this, localJSONObject1);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject1;
  }
  
  public void a()
  {
    this.bb = b();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData
 * JD-Core Version:    0.7.0.1
 */