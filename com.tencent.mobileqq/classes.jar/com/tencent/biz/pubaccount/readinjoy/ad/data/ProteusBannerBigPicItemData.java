package com.tencent.biz.pubaccount.readinjoy.ad.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import nmf;
import nmk;
import oac;
import oae;
import oal;
import org.json.JSONException;
import org.json.JSONObject;
import rpu;
import sfd;

public class ProteusBannerBigPicItemData
  extends AdData
{
  public String a;
  public boolean a;
  public String b;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  
  public ProteusBannerBigPicItemData()
  {
    super(10);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  private JSONObject a()
  {
    Object localObject4 = null;
    String str1 = null;
    JSONObject localJSONObject = new JSONObject();
    Object localObject1;
    if (oal.b(this)) {
      localObject1 = oae.a(localJSONObject, this);
    }
    for (;;)
    {
      return localObject1;
      if (oal.a(this)) {
        return oac.a(localJSONObject, this);
      }
      localObject1 = str1;
      Object localObject5;
      try
      {
        if (!a(this)) {
          continue;
        }
        if (this.jdField_a_of_type_Boolean) {
          localJSONObject.put("style_ID", "ReadInjoy_ad_banner_large_pic_location_cell");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          double d1;
          double d2;
          label133:
          String str2;
          int i;
          label186:
          StringBuilder localStringBuilder;
          label212:
          long l;
          label640:
          label652:
          label687:
          localJSONException.printStackTrace();
          break;
          localJSONObject.put("style_ID", "ReadInjoy_ad_banner_large_pic_cell");
        }
      }
      try
      {
        localObject5 = new double[2];
      }
      catch (Exception localException1)
      {
        Object localObject2 = null;
        break label133;
      }
      try
      {
        localObject1 = this.e;
        d1 = nmk.a(this.d, 0.0D);
        d2 = nmk.a((String)localObject1, 0.0D);
        if (d2 == 0.0D)
        {
          localObject1 = str1;
          if (d1 == 0.0D) {}
        }
        else
        {
          localObject5[0] = d1;
          localObject5[1] = d2;
          localObject1 = localObject5;
        }
      }
      catch (Exception localException2)
      {
        Object localObject3 = localObject5;
        break label133;
        label796:
        localObject3 = "";
        localObject4 = str1;
        break label212;
      }
    }
    if (localObject1 == null)
    {
      d1 = 0.0D;
      localObject1 = this.h;
      localObject5 = this.jdField_b_of_type_JavaLangString;
      str1 = this.f;
      str2 = this.c;
      i = nmk.a((String)localObject1, 3000);
      if (d1 > 0.0D) {
        break label640;
      }
      localObject1 = "";
      d1 = 0.0D;
      localStringBuilder = new StringBuilder();
      if (d1 == 0.0D) {
        break label796;
      }
      if (d1 <= i) {
        break label652;
      }
      break label796;
    }
    do
    {
      for (;;)
      {
        localObject5 = new JSONObject();
        ((JSONObject)localObject5).put("ad_Location", localObject1);
        ((JSONObject)localObject5).put("ad_Location_content", localObject4);
        ((JSONObject)localObject5).put("ad_url", str2);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("ad_Location", localObject5);
        localJSONObject.put("id_view_ad_locationView", localObject1);
        localJSONObject.put("id_mid_line", localObject1);
        if (!TextUtils.isEmpty(this.j))
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("text", this.j);
          localJSONObject.put("id_tv_title", localObject1);
        }
        if (!TextUtils.isEmpty(this.l))
        {
          localObject1 = sfd.a(this.l, 4);
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("image_url", ((URL)localObject1).toString());
          localJSONObject.put("id_ad_banner_bottom_imge", localObject4);
        }
        localObject1 = new JSONObject();
        if (!TextUtils.isEmpty(this.L))
        {
          ((JSONObject)localObject1).put("text", this.L);
          localJSONObject.put("id_ad_dislike_button", localObject1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ProteusBannerBigPicItemData", 2, "detail ad Bottom Pic adInconText:" + this.L);
        }
        localJSONObject.put("id_operate_area", new JSONObject());
        localJSONObject.put("id_separator", new JSONObject());
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("article_model", this);
        localJSONObject.put("id_view_AdDownloadView", localObject1);
        localJSONObject.put("id_ad_title", new JSONObject());
        localJSONObject.put("id_ad_title_rl", new JSONObject());
        if (TextUtils.isEmpty(this.q)) {
          break label807;
        }
        localObject1 = new JSONObject();
        if ((this.jdField_a_of_type_Boolean) && (this.q.length() > 8)) {
          this.q = this.q.substring(0, 8).concat("...");
        }
        ((JSONObject)localObject1).put("text", this.q);
        localJSONObject.put("id_tv_author", localObject1);
        break label807;
        d1 = nmf.a((double[])localObject1, BaseApplicationImpl.getContext());
        break;
        d1 = Math.ceil(d1);
        localObject1 = localObject4;
        break label186;
        if (d1 >= 1000.0D) {
          break label687;
        }
        localStringBuilder.append((int)d1).append('m');
        localObject1 = localStringBuilder.toString();
        localObject4 = localObject5;
      }
      localObject4 = localObject5;
    } while (d1 >= i);
    l = Math.round(d1 / 1000.0D);
    if (l < 1000L) {
      localStringBuilder.append(l).append("km");
    }
    for (;;)
    {
      localObject1 = localStringBuilder.toString();
      localObject4 = localObject5;
      break;
      localStringBuilder.append("999km");
    }
    label807:
    return localJSONObject;
  }
  
  private boolean a(ProteusBannerBigPicItemData paramProteusBannerBigPicItemData)
  {
    return (!TextUtils.isEmpty(this.j)) && (!TextUtils.isEmpty(this.l)) && (!TextUtils.isEmpty(this.q));
  }
  
  public void a()
  {
    localObject3 = null;
    this.jdField_b_of_type_OrgJsonJSONObject = a();
    try
    {
      rpu localrpu = rpu.a("native_article", true);
      localObject1 = localObject3;
      if (localrpu != null) {
        localObject1 = localrpu.getTemplateBean(this.jdField_b_of_type_OrgJsonJSONObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerBigPicItemData
 * JD-Core Version:    0.7.0.1
 */