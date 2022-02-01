package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.SoftAdExpoStatManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class AdvertisementSoftInfo
{
  public String A;
  public String B;
  public String C;
  public String D;
  public String E;
  public String F;
  public String G;
  public String H;
  public String I;
  public String J;
  public String K;
  public String L;
  public String M;
  public String N;
  public String O;
  public String P;
  public String Q;
  public String R;
  public String S;
  public String T;
  public String U;
  public String V;
  public String W;
  public String X;
  public String Y;
  public int a;
  public long a;
  public String a;
  public volatile boolean a;
  public int b;
  public String b;
  public volatile boolean b;
  public int c;
  public String c;
  public volatile boolean c;
  public int d;
  public String d;
  public volatile boolean d;
  public int e;
  public String e;
  public int f;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public String z;
  
  public AdvertisementSoftInfo(String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    if (!TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementSoftInfo", 2, "softData = " + paramString);
      }
    }
    while (!QLog.isColorLevel()) {
      try
      {
        paramString = new JSONObject(new JSONObject(paramString).optString("SoftAd"));
        a(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementSoftInfo", 2, "AdvertisementSoftInfo = " + toString());
        }
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AdvertisementSoftInfo", 2, "AdvertisementSoftInfo Exception = " + paramString.getMessage());
          }
          paramString = null;
        }
      }
    }
    QLog.d("AdvertisementSoftInfo", 2, "softData = null");
  }
  
  public AdvertisementSoftInfo(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    a(paramJSONObject);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("sAdID");
        this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("adImg");
        this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("adTxt");
        this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("adAbb");
        this.jdField_e_of_type_JavaLangString = paramJSONObject.optString("buttonTxt");
        this.jdField_f_of_type_JavaLangString = paramJSONObject.optString("jmpUrl");
        this.g = paramJSONObject.optString("appScheme");
        this.h = paramJSONObject.optString("miniProgramUrl");
        this.jdField_a_of_type_Int = paramJSONObject.optInt("contentType");
        this.jdField_b_of_type_Int = paramJSONObject.optInt("video_percent");
        this.jdField_c_of_type_Int = paramJSONObject.optInt("sourceId");
        this.jdField_d_of_type_Int = paramJSONObject.optInt("bizPlatId");
        this.jdField_e_of_type_Int = paramJSONObject.optInt("goodsType");
        this.i = paramJSONObject.optString("goodsId");
        this.j = paramJSONObject.optString("goodsName");
        this.jdField_f_of_type_Int = paramJSONObject.optInt("accountId");
        this.k = paramJSONObject.optString("goodsPrice");
        this.l = paramJSONObject.optString("goodsPromotionPrice");
        this.m = paramJSONObject.optString("goodsPromotionTxt");
        this.L = paramJSONObject.optString("button");
        this.n = paramJSONObject.optString("extendInfo");
        paramJSONObject = new JSONObject(this.n);
        this.o = paramJSONObject.optString("game_pkg_name");
        this.p = paramJSONObject.optString("game_app_id");
        this.q = paramJSONObject.optString("game_app_name");
        this.r = paramJSONObject.optString("game_apk_url");
        this.s = paramJSONObject.optString("app_download_schema");
        this.t = paramJSONObject.optString("download_api_url");
        this.u = paramJSONObject.optString("downloadNum");
        this.v = paramJSONObject.optString("game_adtag");
        this.w = paramJSONObject.optString("__ADSTR__");
        this.x = paramJSONObject.optString("cmsid");
        this.y = paramJSONObject.optString("soft_video_style");
        this.A = paramJSONObject.optString("big_card_show_percent");
        this.B = paramJSONObject.optString("big_card_show_second");
        this.z = paramJSONObject.optString("big_card_show_type");
        this.K = paramJSONObject.optString("small_card_start_time");
        this.M = paramJSONObject.optString("bizPlatName");
        this.N = paramJSONObject.optString("showTs");
        this.O = paramJSONObject.optString("showType");
        this.P = paramJSONObject.optString("author_id");
        this.Q = paramJSONObject.optString("click_url");
        this.R = paramJSONObject.optString("expo_url");
        this.S = paramJSONObject.optString("expo_stat_key");
        this.jdField_a_of_type_Long = paramJSONObject.optLong("expo_stat_time");
        this.T = paramJSONObject.optString("liujinReportUrl");
        this.U = paramJSONObject.optString("ticket");
        if (TextUtils.isEmpty(this.U)) {
          this.U = paramJSONObject.optString("ad_encrypted_ticket");
        }
        this.V = paramJSONObject.optString("amsNfbUrl");
        SoftAdExpoStatManager.a().a(this.S, this.jdField_a_of_type_Long);
        this.W = paramJSONObject.optString("jump_type");
        this.C = paramJSONObject.optString("big_card_color");
        this.D = paramJSONObject.optString("big_card_exper_id");
        this.E = paramJSONObject.optString("big_card_show_time");
        this.F = paramJSONObject.optString("small_card_icon");
        this.G = paramJSONObject.optString("ad_txt");
        this.H = paramJSONObject.optString("use_ams_ui4.0");
        this.I = paramJSONObject.optString("adver_sign");
        this.J = paramJSONObject.optString("subject");
        this.X = paramJSONObject.optString("AmsCpsExpUrl");
        this.Y = paramJSONObject.optString("AmsCpsClickUrl");
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AdvertisementSoftInfo", 2, "AdvertisementSoftInfo Exception = " + paramJSONObject.getMessage());
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("AdvertisementSoftInfo", 2, "AdvertisementSoftInfo = " + toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo
 * JD-Core Version:    0.7.0.1
 */