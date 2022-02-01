package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import ois;
import oix;
import org.json.JSONException;
import org.json.JSONObject;
import tmh;
import uea;
import uiu;
import uiw;
import uki;
import usq;

public class ProteusBannerBigPicItemData
  extends AdData
{
  public String W = "";
  public String X = "";
  public String Y = "";
  public String Z = "";
  public String aa = "";
  public String ab = "";
  public String ac = "";
  public String ad = "";
  public boolean f;
  
  public ProteusBannerBigPicItemData()
  {
    super(10);
  }
  
  private JSONObject a()
  {
    Object localObject4 = null;
    String str1 = null;
    JSONObject localJSONObject = new JSONObject();
    Object localObject1;
    if (uki.b(this)) {
      localObject1 = uiw.a(localJSONObject, this);
    }
    for (;;)
    {
      return localObject1;
      if (uki.a(this)) {
        return uiu.a(localJSONObject, this);
      }
      localObject1 = str1;
      Object localObject5;
      try
      {
        if (!a(this)) {
          continue;
        }
        if (this.f) {
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
          label500:
          long l;
          label644:
          label685:
          label697:
          label732:
          localJSONException.printStackTrace();
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
        localObject1 = this.aa;
        d1 = oix.a(this.Z, 0.0D);
        d2 = oix.a((String)localObject1, 0.0D);
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
        label935:
        localObject3 = "";
        localObject4 = str1;
        break label212;
        break label348;
        break label500;
        break label644;
      }
    }
    if (localObject1 == null)
    {
      d1 = 0.0D;
      localObject1 = this.ad;
      localObject5 = this.X;
      str1 = this.ab;
      str2 = this.Y;
      i = oix.a((String)localObject1, 3000);
      if (d1 > 0.0D) {
        break label685;
      }
      localObject1 = "";
      d1 = 0.0D;
      localStringBuilder = new StringBuilder();
      if (d1 == 0.0D) {
        break label935;
      }
      if (d1 <= i) {
        break label697;
      }
      break label935;
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
        if (!TextUtils.isEmpty(this.b))
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("text", this.b);
        }
        switch (this.o)
        {
        case 1: 
          ((JSONObject)localObject1).put("bottom_line_number", "2");
          ((JSONObject)localObject1).put("text_color", "#bbbbbb");
          localJSONObject.put("id_tv_title", localObject1);
          if (!TextUtils.isEmpty(this.d))
          {
            localObject1 = usq.a(this.d, 4);
            localObject4 = new JSONObject();
            ((JSONObject)localObject4).put("image_url", ((URL)localObject1).toString());
            localJSONObject.put("id_ad_banner_bottom_imge", localObject4);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProteusBannerBigPicItemData", 2, "detail ad Bottom Pic adInconText:" + this.D);
          }
          localObject1 = new JSONObject();
          switch (this.o)
          {
          case 1: 
            ((JSONObject)localObject1).put("bottom_background_color", "#f8f8f8");
            localJSONObject.put("id_operate_area", localObject1);
            localJSONObject.put("id_ad_title", new JSONObject());
            localJSONObject.put("id_ad_title_rl", new JSONObject());
            if (!TextUtils.isEmpty(this.i))
            {
              localObject1 = new JSONObject();
              if ((this.f) && (this.i.length() > 8)) {
                this.i = this.i.substring(0, 8).concat("...");
              }
              ((JSONObject)localObject1).put("text", this.i);
            }
            switch (this.o)
            {
            case 1: 
              ((JSONObject)localObject1).put("text_color", "#000000");
              localJSONObject.put("id_tv_author", localObject1);
              uea.a(this, localJSONObject);
              break label955;
              d1 = ois.a((double[])localObject1, BaseApplicationImpl.getContext());
              break label140;
              d1 = Math.ceil(d1);
              localObject1 = localObject4;
              break label186;
              if (d1 >= 1000.0D) {
                break label732;
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
    label955:
    return localJSONObject;
  }
  
  private boolean a(ProteusBannerBigPicItemData paramProteusBannerBigPicItemData)
  {
    return (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.i));
  }
  
  public void a()
  {
    localObject3 = null;
    this.c = a();
    try
    {
      tmh localtmh = tmh.a("native_article", true);
      localObject1 = localObject3;
      if (localtmh != null) {
        localObject1 = localtmh.getTemplateBean(this.c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData
 * JD-Core Version:    0.7.0.1
 */