package com.tencent.biz.pubaccount.readinjoy.ad.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import oag;
import oal;
import org.json.JSONException;
import org.json.JSONObject;
import rpu;
import sfd;

public class ProteusBannerVideoItemData
  extends AdData
{
  public long a;
  public boolean a;
  
  public ProteusBannerVideoItemData()
  {
    super(17);
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (oal.a(this)) {
      return oag.a(localJSONObject1, this);
    }
    for (;;)
    {
      try
      {
        localJSONObject1.put("style_ID", "ReadInjoy_ad_banner_video_cell");
        if (!TextUtils.isEmpty(this.j))
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("text", this.j);
          localJSONObject1.put("id_tv_title", localObject);
        }
        JSONObject localJSONObject2;
        if (!TextUtils.isEmpty(this.l))
        {
          localObject = sfd.a(this.l, 4);
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("image_url", ((URL)localObject).toString());
          localJSONObject1.put("id_ad_banner_bottom_imge", localJSONObject2);
        }
        Object localObject = new JSONObject();
        if (!TextUtils.isEmpty(this.L))
        {
          ((JSONObject)localObject).put("text", this.L);
          localJSONObject1.put("id_ad_dislike_button", localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ProteusBannerVideoItemData", 2, "detail ad Bottom Pic adInconText:" + this.L);
        }
        localJSONObject1.put("id_operate_area", new JSONObject());
        localJSONObject1.put("id_separator", new JSONObject());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("article_model", this);
        localJSONObject1.put("id_view_AdDownloadView", localObject);
        localJSONObject1.put("id_ad_title", new JSONObject());
        localJSONObject1.put("id_ad_title_rl", new JSONObject());
        localObject = null;
        if (!TextUtils.isEmpty(this.I))
        {
          localObject = this.I;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localJSONObject2 = new JSONObject();
            localJSONObject2.put("text", localObject);
            localJSONObject1.put("id_tv_author", localJSONObject2);
          }
          localObject = new JSONObject();
          ((JSONObject)localObject).put("article_model", this);
          localJSONObject1.put("id_ad_banner_bottom_video", localObject);
          return localJSONObject1;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return localJSONObject1;
      }
      if (!TextUtils.isEmpty(this.q)) {
        String str = this.q;
      }
    }
  }
  
  public void a()
  {
    localObject3 = null;
    this.b = a();
    try
    {
      rpu localrpu = rpu.a("native_article", true);
      localObject1 = localObject3;
      if (localrpu != null) {
        localObject1 = localrpu.getTemplateBean(this.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData
 * JD-Core Version:    0.7.0.1
 */