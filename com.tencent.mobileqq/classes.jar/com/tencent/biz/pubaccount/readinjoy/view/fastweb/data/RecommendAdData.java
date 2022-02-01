package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyBottomAdVideoUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdCommonBlurImageView.BlurDataModel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class RecommendAdData
  extends AdData
{
  private long f;
  public int y = 2;
  private int z = 184;
  
  public RecommendAdData()
  {
    super(9);
    this.jdField_f_of_type_Long = 0L;
  }
  
  private String a(String paramString, int paramInt)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      String str1 = paramString;
      for (;;)
      {
        try
        {
          if (j < paramString.length())
          {
            if (String.valueOf(paramString.charAt(j)).getBytes().length != 1) {
              continue;
            }
            i += 1;
            if ((j >= paramString.length() - 1) || (i < paramInt)) {
              continue;
            }
            str1 = paramString.substring(0, j) + "...";
          }
        }
        catch (Exception localException)
        {
          String str2 = paramString;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("RecommendAdData", 2, "getTitle error");
        }
        return str1;
        i += 2;
      }
      j += 1;
    }
    return paramString;
  }
  
  private JSONObject a()
  {
    localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2;
      if (this.z == 185)
      {
        localJSONObject1.put("style_ID", "ReadInjoy_native_recommend_ad_video_cell");
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("video_time_txt", "" + this.jdField_f_of_type_Long / 60L + ":" + this.jdField_f_of_type_Long % 60L);
        localJSONObject1.put("video_time", localJSONObject2);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(this.b))
        {
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("text", this.b);
          localJSONObject1.put("id_recommend_title", localJSONObject2);
        }
        if (!TextUtils.isEmpty(this.d))
        {
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("article_model", this);
          ReadInJoyAdCommonBlurImageView.BlurDataModel localBlurDataModel = new ReadInJoyAdCommonBlurImageView.BlurDataModel();
          localBlurDataModel.a = this.d;
          localBlurDataModel.b = this.d;
          localJSONObject2.put("article_model", localBlurDataModel);
          localJSONObject1.put("id_recommend_cover_img", localJSONObject2);
        }
        localJSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(this.D))
        {
          localJSONObject2.put("text", this.D);
          localJSONObject1.put("id_recommend_category_txt", localJSONObject2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("RecommendAdData", 2, "detail ad recommend adInconText:" + this.D);
        }
        if (!TextUtils.isEmpty(this.i))
        {
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("text", a(this.i, 22));
          localJSONObject1.put("id_recommend_account_name", localJSONObject2);
        }
        if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
        {
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("jump_url", this.jdField_f_of_type_JavaLangString);
          localJSONObject1.put("id_native_recommend_small_container", localJSONObject2);
        }
        localJSONObject1.put("id_ad_dislike_button", new JSONObject());
        return localJSONObject1;
        localJSONObject1.put("style_ID", "ReadInjoy_native_recommend_ad_small_cell");
      }
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
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
    this.y = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ReadInJoyBottomAdVideoUtil.a(this);
    if (paramJSONObject != null)
    {
      this.z = paramJSONObject.optInt("material_id");
      this.jdField_f_of_type_Long = paramJSONObject.optInt("media_duration");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData
 * JD-Core Version:    0.7.0.1
 */