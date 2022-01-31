package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import nmf;
import org.json.JSONException;
import org.json.JSONObject;
import rpu;
import sfd;

public class RecommendAdData
  extends AdData
{
  public int a;
  
  public RecommendAdData()
  {
    super(9);
    this.jdField_a_of_type_Int = 2;
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
      localJSONObject1.put("style_ID", "ReadInjoy_native_recommend_ad_small_cell");
      if (!TextUtils.isEmpty(this.j))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("text", this.j);
        localJSONObject1.put("id_recommend_title", localObject);
      }
      if (!TextUtils.isEmpty(this.l))
      {
        localObject = sfd.a(this.l, 4);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("image_url", ((URL)localObject).toString());
        localJSONObject1.put("id_recommend_cover_img", localJSONObject2);
      }
      int j = 22;
      Object localObject = new JSONObject();
      if (!TextUtils.isEmpty(this.L))
      {
        ((JSONObject)localObject).put("text", this.L);
        localJSONObject1.put("id_recommend_category_txt", localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecommendAdData", 2, "detail ad recommend adInconText:" + this.L);
      }
      int i = j;
      if (this.d == 12)
      {
        i = j;
        if (!TextUtils.isEmpty(this.p))
        {
          localObject = new JSONObject();
          if (!nmf.a(BaseApplicationImpl.getContext(), this.p)) {
            break label353;
          }
          ((JSONObject)localObject).put("text", "打开APP");
        }
      }
      for (;;)
      {
        localJSONObject1.put("id_recommend_category_download", localObject);
        i = 16;
        if (!TextUtils.isEmpty(this.q))
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("text", a(this.q, i));
          localJSONObject1.put("id_recommend_account_name", localObject);
        }
        if (!TextUtils.isEmpty(this.n))
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("jump_url", this.n);
          localJSONObject1.put("id_native_recommend_small_container", localObject);
        }
        localJSONObject1.put("id_ad_dislike_button", new JSONObject());
        return localJSONObject1;
        label353:
        ((JSONObject)localObject).put("text", "下载APP");
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = ((TemplateBean)localObject1);
    }
  }
  
  public boolean a(JSONObject paramJSONObject, int paramInt)
  {
    super.a(paramJSONObject, paramInt);
    this.jdField_a_of_type_Int = paramInt;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData
 * JD-Core Version:    0.7.0.1
 */