package com.tencent.biz.pubaccount.readinjoy.ad.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import noy;
import npd;
import odj;
import odl;
import odv;
import org.json.JSONException;
import org.json.JSONObject;
import sfq;
import swu;

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
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  private JSONObject a()
  {
    Object localObject4 = null;
    String str1 = null;
    JSONObject localJSONObject = new JSONObject();
    Object localObject1;
    if (odv.b(this)) {
      localObject1 = odl.a(localJSONObject, this);
    }
    for (;;)
    {
      return localObject1;
      if (odv.a(this)) {
        return odj.a(localJSONObject, this);
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
          label140:
          String str2;
          int i;
          label186:
          StringBuilder localStringBuilder;
          label212:
          label348:
          label763:
          long l;
          label540:
          label728:
          localJSONException.printStackTrace();
          label775:
          label810:
          break;
          localJSONObject.put("style_ID", "ReadInjoy_ad_banner_large_pic_cell");
          continue;
          localJSONException.put("bottom_line_number", "1");
          localJSONException.put("text_color", "#a6a6a6");
          continue;
          localJSONException.put("bottom_line_number", "2");
          localJSONException.put("text_color", "#a6a6a6");
          continue;
          localJSONException.put("bottom_background_color", "#ffffff");
          localJSONException.put("bottom_border_color", "#e6e6e6");
          localJSONException.put("bottom_border_width", "0.5");
          continue;
          localJSONException.put("text_color", "#262626");
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
        d1 = npd.a(this.d, 0.0D);
        d2 = npd.a((String)localObject1, 0.0D);
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
        label1014:
        localObject3 = "";
        localObject4 = str1;
        break label212;
        break label348;
        break label540;
        break label728;
      }
    }
    if (localObject1 == null)
    {
      d1 = 0.0D;
      localObject1 = this.h;
      localObject5 = this.b;
      str1 = this.f;
      str2 = this.jdField_c_of_type_JavaLangString;
      i = npd.a((String)localObject1, 3000);
      if (d1 > 0.0D) {
        break label763;
      }
      localObject1 = "";
      d1 = 0.0D;
      localStringBuilder = new StringBuilder();
      if (d1 == 0.0D) {
        break label1014;
      }
      if (d1 <= i) {
        break label775;
      }
      break label1014;
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
        }
        switch (this.p)
        {
        case 1: 
          ((JSONObject)localObject1).put("bottom_line_number", "2");
          ((JSONObject)localObject1).put("text_color", "#bbbbbb");
          localJSONObject.put("id_tv_title", localObject1);
          if (!TextUtils.isEmpty(this.l))
          {
            localObject1 = swu.a(this.l, 4);
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
          localObject1 = new JSONObject();
          switch (this.p)
          {
          case 1: 
            ((JSONObject)localObject1).put("bottom_background_color", "#f8f8f8");
            localJSONObject.put("id_operate_area", localObject1);
            localJSONObject.put("id_separator", new JSONObject());
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("article_model", this);
            localJSONObject.put("id_view_AdDownloadView", localObject1);
            localJSONObject.put("id_ad_title", new JSONObject());
            localJSONObject.put("id_ad_title_rl", new JSONObject());
            if (TextUtils.isEmpty(this.q)) {
              break label1034;
            }
            localObject1 = new JSONObject();
            if ((this.jdField_a_of_type_Boolean) && (this.q.length() > 8)) {
              this.q = this.q.substring(0, 8).concat("...");
            }
            ((JSONObject)localObject1).put("text", this.q);
            switch (this.p)
            {
            case 1: 
              ((JSONObject)localObject1).put("text_color", "#000000");
              localJSONObject.put("id_tv_author", localObject1);
              break label1034;
              d1 = noy.a((double[])localObject1, BaseApplicationImpl.getContext());
              break label140;
              d1 = Math.ceil(d1);
              localObject1 = localObject4;
              break label186;
              if (d1 >= 1000.0D) {
                break label810;
              }
              localStringBuilder.append((int)d1).append('m');
              localObject1 = localStringBuilder.toString();
              localObject4 = localObject5;
            }
            break;
          }
          break;
        }
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
    label1034:
    return localJSONObject;
  }
  
  private boolean a(ProteusBannerBigPicItemData paramProteusBannerBigPicItemData)
  {
    return (!TextUtils.isEmpty(this.j)) && (!TextUtils.isEmpty(this.l)) && (!TextUtils.isEmpty(this.q));
  }
  
  public void a()
  {
    localObject3 = null;
    this.jdField_c_of_type_OrgJsonJSONObject = a();
    try
    {
      sfq localsfq = sfq.a("native_article", true);
      localObject1 = localObject3;
      if (localsfq != null) {
        localObject1 = localsfq.getTemplateBean(this.jdField_c_of_type_OrgJsonJSONObject);
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerBigPicItemData
 * JD-Core Version:    0.7.0.1
 */