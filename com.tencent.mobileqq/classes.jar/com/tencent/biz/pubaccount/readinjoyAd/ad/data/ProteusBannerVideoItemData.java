package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import suz;
import tks;
import tov;
import tpp;
import tye;

public class ProteusBannerVideoItemData
  extends AdData
{
  public long f;
  public boolean f;
  public boolean g;
  
  public ProteusBannerVideoItemData()
  {
    super(17);
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (tpp.a(this)) {
      return tov.a(localJSONObject1, this);
    }
    for (;;)
    {
      JSONObject localJSONObject2;
      try
      {
        localJSONObject1.put("style_ID", "ReadInjoy_ad_banner_video_cell");
        Object localObject;
        if (!TextUtils.isEmpty(this.b))
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("text", this.b);
        }
        switch (this.o)
        {
        case 1: 
          ((JSONObject)localObject).put("bottom_line_number", "2");
          ((JSONObject)localObject).put("text_color", "#bbbbbb");
          localJSONObject1.put("id_tv_title", localObject);
          if (!TextUtils.isEmpty(this.d))
          {
            localObject = tye.a(this.d, 4);
            localJSONObject2 = new JSONObject();
            localJSONObject2.put("image_url", ((URL)localObject).toString());
            localJSONObject1.put("id_ad_banner_bottom_imge", localJSONObject2);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProteusBannerVideoItemData", 2, "detail ad Bottom Pic adInconText:" + this.D);
          }
          localObject = new JSONObject();
          switch (this.o)
          {
          case 1: 
            ((JSONObject)localObject).put("bottom_background_color", "#f8f8f8");
            localJSONObject1.put("id_operate_area", localObject);
            localJSONObject1.put("id_ad_title", new JSONObject());
            localJSONObject1.put("id_ad_title_rl", new JSONObject());
            localObject = null;
            if (TextUtils.isEmpty(this.A)) {
              break label463;
            }
            localObject = this.A;
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              localJSONObject2 = new JSONObject();
              localJSONObject2.put("text", localObject);
            }
            switch (this.o)
            {
            case 1: 
              localJSONObject2.put("text_color", "#000000");
              localJSONObject1.put("id_tv_author", localJSONObject2);
              localObject = new JSONObject();
              ((JSONObject)localObject).put("article_model", this);
              localJSONObject1.put("id_ad_banner_bottom_video", localObject);
              tks.a(this, localJSONObject1);
              return localJSONObject1;
            }
            break;
          }
          break;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return localJSONObject1;
      }
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
      label463:
      if (!TextUtils.isEmpty(this.i))
      {
        String str = this.i;
        continue;
        localJSONObject2.put("text_color", "#262626");
        continue;
        continue;
      }
    }
  }
  
  public void a()
  {
    localObject3 = null;
    this.c = a();
    try
    {
      suz localsuz = suz.a("native_article", true);
      localObject1 = localObject3;
      if (localsuz != null) {
        localObject1 = localsuz.getTemplateBean(this.c);
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData
 * JD-Core Version:    0.7.0.1
 */