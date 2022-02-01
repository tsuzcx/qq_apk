package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import syz;
import tur;
import twh;
import uet;

public class ProteusBannerTriplePicItemData
  extends AdData
{
  public ProteusBannerTriplePicItemData()
  {
    super(24);
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (twh.a(this)) {
      return tur.a(localJSONObject1, this);
    }
    try
    {
      if (!a(this)) {
        return null;
      }
      localJSONObject1.put("style_ID", "ReadInjoy_ad_banner_triple_pic_cell");
      if (!TextUtils.isEmpty(this.b))
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("text", this.b);
        localJSONObject1.put("id_tv_title", localObject1);
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 2))
      {
        Object localObject3 = uet.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(0), 4);
        Object localObject2 = uet.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(1), 4);
        localObject1 = uet.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(2), 4);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("multi_img_url1", ((URL)localObject3).toString());
        localJSONObject1.put("id_multi_img_1", localJSONObject2);
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("multi_img_url2", ((URL)localObject2).toString());
        localJSONObject1.put("id_multi_img_2", localObject3);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("multi_img_url3", ((URL)localObject1).toString());
        localJSONObject1.put("id_multi_img_3", localObject2);
      }
      Object localObject1 = new JSONObject();
      if (!TextUtils.isEmpty(this.D))
      {
        ((JSONObject)localObject1).put("text", this.D);
        localJSONObject1.put("id_ad_dislike_button", localObject1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProteusBannerTriplePicItemData", 2, "detail ad Bottom Pic adInconText:" + this.D);
      }
      localJSONObject1.put("id_operate_area", new JSONObject());
      localJSONObject1.put("id_ad_triple_imge_container", new JSONObject());
      localJSONObject1.put("id_separator", new JSONObject());
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("article_model", this);
      localJSONObject1.put("id_view_AdDownloadView", localObject1);
      localJSONObject1.put("id_ad_title", new JSONObject());
      localJSONObject1.put("id_ad_title_rl", new JSONObject());
      if (!TextUtils.isEmpty(this.i))
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("text", this.i);
        localJSONObject1.put("id_tv_author", localObject1);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONObject1;
  }
  
  private boolean a(ProteusBannerTriplePicItemData paramProteusBannerTriplePicItemData)
  {
    return (!TextUtils.isEmpty(this.b)) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 2) && (!TextUtils.isEmpty(this.i));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerTriplePicItemData
 * JD-Core Version:    0.7.0.1
 */