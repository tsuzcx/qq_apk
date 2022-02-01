package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import obb;
import org.json.JSONException;
import org.json.JSONObject;
import syz;
import tws;
import uet;

public class RecommendAdData
  extends AdData
{
  private long f;
  public int w = 2;
  private int x = 184;
  
  public RecommendAdData()
  {
    super(9);
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
    JSONObject localJSONObject1 = new JSONObject();
    label452:
    for (;;)
    {
      try
      {
        if (this.x == 185)
        {
          localJSONObject1.put("style_ID", "ReadInjoy_native_recommend_ad_video_cell");
          Object localObject = new JSONObject();
          ((JSONObject)localObject).put("video_time_txt", "" + this.jdField_f_of_type_Long / 60L + ":" + this.jdField_f_of_type_Long % 60L);
          localJSONObject1.put("video_time", localObject);
          if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("text", this.jdField_b_of_type_JavaLangString);
            localJSONObject1.put("id_recommend_title", localObject);
          }
          if (!TextUtils.isEmpty(this.d))
          {
            localObject = uet.a(this.d, 4);
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("image_url", ((URL)localObject).toString());
            localJSONObject1.put("id_recommend_cover_img", localJSONObject2);
          }
          int j = 22;
          localObject = new JSONObject();
          if (!TextUtils.isEmpty(this.D))
          {
            ((JSONObject)localObject).put("text", this.D);
            localJSONObject1.put("id_recommend_category_txt", localObject);
          }
          if (QLog.isColorLevel()) {
            QLog.d("RecommendAdData", 2, "detail ad recommend adInconText:" + this.D);
          }
          int i = j;
          if (this.jdField_b_of_type_Int == 12)
          {
            i = j;
            if (!TextUtils.isEmpty(this.h))
            {
              localObject = new JSONObject();
              if (!obb.a(BaseApplicationImpl.getContext(), this.h)) {
                break label452;
              }
              ((JSONObject)localObject).put("text", "打开APP");
              localJSONObject1.put("id_recommend_category_download", localObject);
              i = 16;
            }
          }
          if (!TextUtils.isEmpty(this.i))
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("text", a(this.i, i));
            localJSONObject1.put("id_recommend_account_name", localObject);
          }
          if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("jump_url", this.jdField_f_of_type_JavaLangString);
            localJSONObject1.put("id_native_recommend_small_container", localObject);
          }
          localJSONObject1.put("id_ad_dislike_button", new JSONObject());
          return localJSONObject1;
        }
        else
        {
          localJSONObject1.put("style_ID", "ReadInjoy_native_recommend_ad_small_cell");
          continue;
        }
        localJSONException.put("text", "下载APP");
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return localJSONObject1;
      }
    }
  }
  
  public void a()
  {
    localObject3 = null;
    this.c = a();
    try
    {
      syz localsyz = syz.a("native_article", true);
      localObject1 = localObject3;
      if (localsyz != null) {
        localObject1 = localsyz.getTemplateBean(this.c);
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
    this.w = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = tws.a(this);
    if (paramJSONObject != null)
    {
      this.x = paramJSONObject.optInt("material_id");
      this.jdField_f_of_type_Long = paramJSONObject.optInt("media_duration");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData
 * JD-Core Version:    0.7.0.1
 */