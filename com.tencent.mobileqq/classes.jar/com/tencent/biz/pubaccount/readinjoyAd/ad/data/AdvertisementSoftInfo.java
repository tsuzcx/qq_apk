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
  public String Z;
  public volatile boolean a = false;
  public String aa;
  public String ab;
  public String ac;
  public String ad;
  public long ae;
  public String af;
  public String ag;
  public String ah;
  public String ai;
  public String aj;
  public String ak;
  public volatile boolean b = false;
  public volatile boolean c = false;
  public volatile boolean d = false;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public int m;
  public int n;
  public int o;
  public int p;
  public int q;
  public String r;
  public String s;
  public int t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public String z;
  
  public AdvertisementSoftInfo(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("softData = ");
        localStringBuilder.append(paramString);
        QLog.d("AdvertisementSoftInfo", 2, localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = null;
      try
      {
        paramString = new JSONObject(new JSONObject(paramString).optString("SoftAd"));
      }
      catch (Exception localException)
      {
        paramString = localStringBuilder;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("AdvertisementSoftInfo Exception = ");
          paramString.append(localException.getMessage());
          QLog.e("AdvertisementSoftInfo", 2, paramString.toString());
          paramString = localStringBuilder;
        }
      }
      a(paramString);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("AdvertisementSoftInfo = ");
        paramString.append(toString());
        QLog.d("AdvertisementSoftInfo", 2, paramString.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AdvertisementSoftInfo", 2, "softData = null");
    }
  }
  
  public AdvertisementSoftInfo(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      this.e = paramJSONObject.optString("sAdID");
      this.f = paramJSONObject.optString("adImg");
      this.h = paramJSONObject.optString("adTxt");
      this.g = paramJSONObject.optString("adAbb");
      this.i = paramJSONObject.optString("buttonTxt");
      this.j = paramJSONObject.optString("jmpUrl");
      this.k = paramJSONObject.optString("appScheme");
      this.l = paramJSONObject.optString("miniProgramUrl");
      this.m = paramJSONObject.optInt("contentType");
      this.n = paramJSONObject.optInt("video_percent");
      this.o = paramJSONObject.optInt("sourceId");
      this.p = paramJSONObject.optInt("bizPlatId");
      this.q = paramJSONObject.optInt("goodsType");
      this.r = paramJSONObject.optString("goodsId");
      this.s = paramJSONObject.optString("goodsName");
      this.t = paramJSONObject.optInt("accountId");
      this.u = paramJSONObject.optString("goodsPrice");
      this.v = paramJSONObject.optString("goodsPromotionPrice");
      this.w = paramJSONObject.optString("goodsPromotionTxt");
      this.W = paramJSONObject.optString("button");
      this.x = paramJSONObject.optString("extendInfo");
      paramJSONObject = new JSONObject(this.x);
      this.y = paramJSONObject.optString("game_pkg_name");
      this.z = paramJSONObject.optString("game_app_id");
      this.A = paramJSONObject.optString("game_app_name");
      this.B = paramJSONObject.optString("game_apk_url");
      this.C = paramJSONObject.optString("app_download_schema");
      this.D = paramJSONObject.optString("download_api_url");
      this.E = paramJSONObject.optString("downloadNum");
      this.F = paramJSONObject.optString("game_adtag");
      this.G = paramJSONObject.optString("__ADSTR__");
      this.H = paramJSONObject.optString("cmsid");
      this.I = paramJSONObject.optString("soft_video_style");
      this.K = paramJSONObject.optString("big_card_show_percent");
      this.L = paramJSONObject.optString("big_card_show_second");
      this.J = paramJSONObject.optString("big_card_show_type");
      this.V = paramJSONObject.optString("small_card_start_time");
      this.X = paramJSONObject.optString("bizPlatName");
      this.Y = paramJSONObject.optString("showTs");
      this.Z = paramJSONObject.optString("showType");
      this.aa = paramJSONObject.optString("author_id");
      this.ab = paramJSONObject.optString("click_url");
      this.ac = paramJSONObject.optString("expo_url");
      this.ad = paramJSONObject.optString("expo_stat_key");
      this.ae = paramJSONObject.optLong("expo_stat_time");
      this.af = paramJSONObject.optString("liujinReportUrl");
      this.ag = paramJSONObject.optString("ticket");
      if (TextUtils.isEmpty(this.ag)) {
        this.ag = paramJSONObject.optString("ad_encrypted_ticket");
      }
      this.ah = paramJSONObject.optString("amsNfbUrl");
      SoftAdExpoStatManager.a().a(this.ad, this.ae);
      this.ai = paramJSONObject.optString("jump_type");
      this.M = paramJSONObject.optString("big_card_color");
      this.N = paramJSONObject.optString("big_card_exper_id");
      this.O = paramJSONObject.optString("big_card_show_time");
      this.P = paramJSONObject.optString("small_card_icon");
      this.Q = paramJSONObject.optString("ad_txt");
      this.R = paramJSONObject.optString("use_ams_ui4.0");
      this.S = paramJSONObject.optString("adver_sign");
      this.T = paramJSONObject.optString("subject");
      this.aj = paramJSONObject.optString("AmsCpsExpUrl");
      this.ak = paramJSONObject.optString("AmsCpsClickUrl");
      this.U = paramJSONObject.optString("big_card_material");
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AdvertisementSoftInfo Exception = ");
        localStringBuilder.append(paramJSONObject.getMessage());
        QLog.e("AdvertisementSoftInfo", 2, localStringBuilder.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("AdvertisementSoftInfo = ");
      paramJSONObject.append(toString());
      QLog.d("AdvertisementSoftInfo", 2, paramJSONObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo
 * JD-Core Version:    0.7.0.1
 */