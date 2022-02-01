package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdvertisementExtInfo
{
  public int a;
  public String a;
  public List<AdPKImageData> a;
  public boolean a;
  public int b;
  public String b;
  public List<String> b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public int m;
  public int n;
  public int o;
  public int p = 1;
  public int q;
  public int r;
  public int s;
  public int t;
  public int u;
  
  public AdvertisementExtInfo(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = "1";
    this.jdField_c_of_type_JavaLangString = "";
    int i2 = 0;
    this.s = 0;
    this.t = 5;
    this.jdField_g_of_type_JavaLangString = "1";
    this.u = 0;
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
        this.jdField_a_of_type_Int = paramString.optInt("AdSlideSpeed");
        this.jdField_b_of_type_Int = paramString.optInt("AdRepeatedFlag");
        this.jdField_c_of_type_Int = paramString.optInt("AdDistance");
        this.jdField_d_of_type_Int = paramString.optInt("RepeatedReqFlag");
        this.jdField_e_of_type_Int = paramString.optInt("KdPos");
        this.jdField_f_of_type_Int = paramString.optInt("refreshLastPos", 0);
        this.jdField_g_of_type_Int = paramString.optInt("refreshLastPosY", 10);
        this.jdField_h_of_type_Int = paramString.optInt("refreshLastPosZ", 10);
        this.jdField_b_of_type_JavaLangString = paramString.optString("button_flag", "1");
        this.jdField_i_of_type_Int = paramString.optInt("showAdType");
        this.r = paramString.optInt("normal_mask");
        this.s = paramString.optInt("bid_mask", 0);
        this.t = paramString.optInt("timer_duration", 5);
        this.jdField_c_of_type_JavaLangString = paramString.optString("pk_ad_vs_pic");
        this.jdField_j_of_type_Int = paramString.optInt("AdSource");
        this.jdField_k_of_type_Int = paramString.optInt("slide_effect1");
        this.l = paramString.optInt("slide_effect2");
        this.m = paramString.optInt("delivery_effect");
        this.jdField_d_of_type_JavaLangString = paramString.optString("img_coord");
        this.n = paramString.optInt("slideShowSlipAllowMs");
        this.o = paramString.optInt("slideImgDisplayMs");
        this.p = paramString.optInt("animated_type");
        this.jdField_e_of_type_JavaLangString = paramString.optString("resZipUrl");
        this.jdField_f_of_type_JavaLangString = paramString.optString("res_zip_md5");
        this.q = paramString.optInt("res_zip_version");
        this.u = paramString.optInt("is_video_new");
        this.jdField_a_of_type_JavaLangString = paramString.optString("ad_switchs");
        localObject1 = paramString.optJSONArray("container_ad_item");
        Object localObject2;
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
          i1 = 0;
          if (i1 < ((JSONArray)localObject1).length())
          {
            localObject2 = new AdPKImageData(((JSONArray)localObject1).getJSONObject(i1));
            this.jdField_a_of_type_JavaUtilList.add(localObject2);
            if (!QLog.isColorLevel()) {
              break label759;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("adPKImageData = ");
            localStringBuilder.append(((AdPKImageData)localObject2).toString());
            QLog.d("AdvertisementExtInfo", 2, localStringBuilder.toString());
            break label759;
          }
        }
        localObject1 = paramString.optJSONArray("img_urls");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          this.jdField_b_of_type_JavaUtilList = new ArrayList();
          i1 = i2;
          if (i1 < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).getString(i1);
            this.jdField_b_of_type_JavaUtilList.add(localObject2);
            if (!QLog.isColorLevel()) {
              break label766;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("imgUrlList = ");
            ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaUtilList.toString());
            QLog.d("AdvertisementExtInfo", 2, ((StringBuilder)localObject2).toString());
            break label766;
          }
        }
        this.jdField_h_of_type_JavaLangString = paramString.optString("liujinReportUrl");
        this.jdField_k_of_type_JavaLangString = paramString.optString("base_img");
        this.jdField_j_of_type_JavaLangString = paramString.optString("small_img");
        this.jdField_i_of_type_JavaLangString = paramString.optString("caption");
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
      label759:
      i1 += 1;
      continue;
      label766:
      i1 += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Int == 1;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("adSlideSpeed=");
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append("|");
    localStringBuffer.append("adRepeatedFlag=");
    localStringBuffer.append(this.jdField_b_of_type_Int);
    localStringBuffer.append("|");
    localStringBuffer.append("adDistance=");
    localStringBuffer.append(this.jdField_c_of_type_Int);
    localStringBuffer.append("|");
    localStringBuffer.append("repeatedReqFlag=");
    localStringBuffer.append(this.jdField_d_of_type_Int);
    localStringBuffer.append("|");
    localStringBuffer.append("kdPos=");
    localStringBuffer.append(this.jdField_e_of_type_Int);
    localStringBuffer.append("|");
    localStringBuffer.append("refreshLastPos=");
    localStringBuffer.append(this.jdField_f_of_type_Int);
    localStringBuffer.append("|");
    localStringBuffer.append("showAdType=");
    localStringBuffer.append(this.jdField_i_of_type_Int);
    localStringBuffer.append("|");
    localStringBuffer.append("buttonFlag=");
    localStringBuffer.append(this.jdField_b_of_type_JavaLangString);
    localStringBuffer.append("|");
    localStringBuffer.append("slidEffect1=");
    localStringBuffer.append(this.jdField_k_of_type_Int);
    localStringBuffer.append("|");
    localStringBuffer.append("slidEffect2=");
    localStringBuffer.append(this.l);
    localStringBuffer.append("|");
    localStringBuffer.append("deliveryEffect=");
    localStringBuffer.append(this.m);
    localStringBuffer.append("|");
    localStringBuffer.append("imgCoord=");
    localStringBuffer.append(this.jdField_d_of_type_JavaLangString);
    localStringBuffer.append("|");
    localStringBuffer.append("slideShowSlipAllowMs=");
    localStringBuffer.append(this.n);
    localStringBuffer.append("|");
    localStringBuffer.append("slideImgDisplayMs=");
    localStringBuffer.append(this.o);
    localStringBuffer.append("|");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo
 * JD-Core Version:    0.7.0.1
 */