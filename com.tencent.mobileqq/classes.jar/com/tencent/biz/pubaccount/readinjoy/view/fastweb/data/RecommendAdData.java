package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdCommonBlurImageView.BlurDataModel;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.pts.api.ITemplateFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RecommendAdData
  extends AdData
{
  public int a = 2;
  public boolean b = false;
  private long c = 0L;
  private int d = 184;
  private JSONObject e;
  private int f;
  
  public RecommendAdData()
  {
    super(9);
  }
  
  private String a(String paramString, int paramInt)
  {
    int j = 0;
    i = 0;
    for (;;)
    {
      try
      {
        if (j >= paramString.length()) {
          continue;
        }
        if (String.valueOf(paramString.charAt(j)).getBytes().length != 1) {
          continue;
        }
        i += 1;
      }
      catch (Exception localException)
      {
        Object localObject;
        continue;
        i += 2;
        continue;
      }
      if ((j < paramString.length() - 1) && (i >= paramInt))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, j));
        ((StringBuilder)localObject).append("...");
        localObject = ((StringBuilder)localObject).toString();
        return localObject;
      }
      j += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RecommendAdData", 2, "getTitle error");
    }
    return paramString;
  }
  
  private JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      int i = this.f;
      Object localObject2;
      if (i == 1)
      {
        if (this.d == 185)
        {
          localJSONObject.put("style_ID", "ReadInjoy_native_author_article_ad_video_cell");
          localObject1 = new JSONObject();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(this.c / 60L);
          ((StringBuilder)localObject2).append(":");
          ((StringBuilder)localObject2).append(this.c % 60L);
          ((JSONObject)localObject1).put("video_time_txt", ((StringBuilder)localObject2).toString());
          localJSONObject.put("video_time", localObject1);
        }
        else
        {
          localJSONObject.put("style_ID", "ReadInjoy_native_author_article_ad_small_cell");
        }
        if (this.b) {
          localJSONObject.put("corner_radius_array", new JSONArray(new String[] { "0", "0", "6", "6" }));
        }
      }
      else if (this.d == 185)
      {
        localJSONObject.put("style_ID", "ReadInjoy_native_recommend_ad_video_cell");
        localObject1 = new JSONObject();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(this.c / 60L);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(this.c % 60L);
        ((JSONObject)localObject1).put("video_time_txt", ((StringBuilder)localObject2).toString());
        localJSONObject.put("video_time", localObject1);
      }
      else
      {
        localJSONObject.put("style_ID", "ReadInjoy_native_recommend_ad_small_cell");
      }
      boolean bool = TextUtils.isEmpty(this.l);
      if (!bool)
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("text", this.l);
        localJSONObject.put("id_recommend_title", localObject1);
      }
      if (!TextUtils.isEmpty(this.n))
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("article_model", this);
        localObject2 = new ReadInJoyAdCommonBlurImageView.BlurDataModel();
        ((ReadInJoyAdCommonBlurImageView.BlurDataModel)localObject2).a = this.n;
        ((ReadInJoyAdCommonBlurImageView.BlurDataModel)localObject2).b = this.n;
        if (this.f == 1) {
          ((ReadInJoyAdCommonBlurImageView.BlurDataModel)localObject2).c = 5;
        }
        ((JSONObject)localObject1).put("article_model", localObject2);
        localJSONObject.put("id_recommend_cover_img", localObject1);
      }
      Object localObject1 = new JSONObject();
      if (!TextUtils.isEmpty(this.ah))
      {
        ((JSONObject)localObject1).put("text", this.ah);
        localJSONObject.put("id_recommend_category_txt", localObject1);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("detail ad recommend adInconText:");
        ((StringBuilder)localObject1).append(this.ah);
        QLog.d("RecommendAdData", 2, ((StringBuilder)localObject1).toString());
      }
      if (!TextUtils.isEmpty(this.u))
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("text", a(this.u, 22));
        localJSONObject.put("id_recommend_account_name", localObject1);
      }
      if (!TextUtils.isEmpty(this.q))
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("jump_url", this.q);
        localJSONObject.put("id_native_recommend_small_container", localObject1);
      }
      localJSONObject.put("id_ad_dislike_button", new JSONObject());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
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
  
  public void a(int paramInt)
  {
    this.f = paramInt;
    a(this.e, this.a);
    a();
  }
  
  public boolean a(JSONObject paramJSONObject, int paramInt)
  {
    super.a(paramJSONObject, paramInt);
    this.e = paramJSONObject;
    this.a = paramInt;
    this.j = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(this);
    if (paramJSONObject != null)
    {
      this.d = paramJSONObject.optInt("material_id");
      this.c = paramJSONObject.optInt("media_duration");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData
 * JD-Core Version:    0.7.0.1
 */