package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdvertisementExtInfo
{
  public int A;
  public int B;
  public int C;
  public String D;
  public int E;
  public String F;
  public String G;
  public String H;
  public String I;
  public String J;
  public String a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public boolean j;
  public String k = "1";
  public int l;
  public List<AdPKImageData> m;
  public String n = "";
  public int o;
  public int p;
  public int q;
  public int r;
  public String s;
  public int t;
  public int u;
  public List<String> v;
  public int w = 1;
  public String x;
  public String y;
  public int z;
  
  public AdvertisementExtInfo(String paramString)
  {
    int i2 = 0;
    this.B = 0;
    this.C = 5;
    this.D = "1";
    this.E = 0;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementExtInfo", 2, "adExt = null");
      }
      return;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("adExt = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("AdvertisementExtInfo", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      int i1;
      try
      {
        paramString = new JSONObject(paramString);
        this.b = paramString.optInt("AdSlideSpeed");
        this.c = paramString.optInt("AdRepeatedFlag");
        this.d = paramString.optInt("AdDistance");
        this.e = paramString.optInt("RepeatedReqFlag");
        this.f = paramString.optInt("KdPos");
        this.g = paramString.optInt("refreshLastPos", 0);
        this.h = paramString.optInt("refreshLastPosY", 10);
        this.i = paramString.optInt("refreshLastPosZ", 10);
        this.k = paramString.optString("button_flag", "1");
        this.l = paramString.optInt("showAdType");
        this.A = paramString.optInt("normal_mask");
        this.B = paramString.optInt("bid_mask", 0);
        this.C = paramString.optInt("timer_duration", 5);
        this.n = paramString.optString("pk_ad_vs_pic");
        this.o = paramString.optInt("AdSource");
        this.p = paramString.optInt("slide_effect1");
        this.q = paramString.optInt("slide_effect2");
        this.r = paramString.optInt("delivery_effect");
        this.s = paramString.optString("img_coord");
        this.t = paramString.optInt("slideShowSlipAllowMs");
        this.u = paramString.optInt("slideImgDisplayMs");
        this.w = paramString.optInt("animated_type");
        this.x = paramString.optString("resZipUrl");
        this.y = paramString.optString("res_zip_md5");
        this.z = paramString.optInt("res_zip_version");
        this.E = paramString.optInt("is_video_new");
        this.a = paramString.optString("ad_switchs");
        localObject1 = paramString.optJSONArray("container_ad_item");
        Object localObject2;
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          this.m = new ArrayList();
          i1 = 0;
          if (i1 < ((JSONArray)localObject1).length())
          {
            localObject2 = new AdPKImageData(((JSONArray)localObject1).getJSONObject(i1));
            this.m.add(localObject2);
            if (!QLog.isColorLevel()) {
              break label773;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("adPKImageData = ");
            localStringBuilder.append(((AdPKImageData)localObject2).toString());
            QLog.d("AdvertisementExtInfo", 2, localStringBuilder.toString());
            break label773;
          }
        }
        localObject1 = paramString.optJSONArray("img_urls");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          this.v = new ArrayList();
          i1 = i2;
          if (i1 < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).getString(i1);
            this.v.add(localObject2);
            if (!QLog.isColorLevel()) {
              break label780;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("imgUrlList = ");
            ((StringBuilder)localObject2).append(this.v.toString());
            QLog.d("AdvertisementExtInfo", 2, ((StringBuilder)localObject2).toString());
            break label780;
          }
        }
        this.F = paramString.optString("liujinReportUrl");
        this.I = paramString.optString("base_img");
        this.H = paramString.optString("small_img");
        this.G = paramString.optString("caption");
        this.J = paramString.optString("social_visibility_txt");
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("advertisementExtInfo Exception = ");
          ((StringBuilder)localObject1).append(paramString.getMessage());
          QLog.e("AdvertisementExtInfo", 2, ((StringBuilder)localObject1).toString());
        }
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("advertisementExtInfo = ");
        paramString.append(toString());
        QLog.d("AdvertisementExtInfo", 2, paramString.toString());
      }
      return;
      label773:
      i1 += 1;
      continue;
      label780:
      i1 += 1;
    }
  }
  
  public boolean a()
  {
    return this.c == 1;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("adSlideSpeed=");
    localStringBuffer.append(this.b);
    localStringBuffer.append("|");
    localStringBuffer.append("adRepeatedFlag=");
    localStringBuffer.append(this.c);
    localStringBuffer.append("|");
    localStringBuffer.append("adDistance=");
    localStringBuffer.append(this.d);
    localStringBuffer.append("|");
    localStringBuffer.append("repeatedReqFlag=");
    localStringBuffer.append(this.e);
    localStringBuffer.append("|");
    localStringBuffer.append("kdPos=");
    localStringBuffer.append(this.f);
    localStringBuffer.append("|");
    localStringBuffer.append("refreshLastPos=");
    localStringBuffer.append(this.g);
    localStringBuffer.append("|");
    localStringBuffer.append("showAdType=");
    localStringBuffer.append(this.l);
    localStringBuffer.append("|");
    localStringBuffer.append("buttonFlag=");
    localStringBuffer.append(this.k);
    localStringBuffer.append("|");
    localStringBuffer.append("slidEffect1=");
    localStringBuffer.append(this.p);
    localStringBuffer.append("|");
    localStringBuffer.append("slidEffect2=");
    localStringBuffer.append(this.q);
    localStringBuffer.append("|");
    localStringBuffer.append("deliveryEffect=");
    localStringBuffer.append(this.r);
    localStringBuffer.append("|");
    localStringBuffer.append("imgCoord=");
    localStringBuffer.append(this.s);
    localStringBuffer.append("|");
    localStringBuffer.append("slideShowSlipAllowMs=");
    localStringBuffer.append(this.t);
    localStringBuffer.append("|");
    localStringBuffer.append("slideImgDisplayMs=");
    localStringBuffer.append(this.u);
    localStringBuffer.append("|");
    localStringBuffer.append("socialVisibilityTxt=");
    localStringBuffer.append(this.J);
    localStringBuffer.append("|");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo
 * JD-Core Version:    0.7.0.1
 */