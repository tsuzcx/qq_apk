package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ADVideoAppDownloadData
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public int f = 0;
  public int g;
  public String h;
  public String i = "";
  public String j = "";
  public AdvertisementInfo k;
  public boolean l;
  public WadlParams m;
  public String n;
  public AdData o;
  public GameAdComData p;
  public String q;
  public boolean r = false;
  
  public static ADVideoAppDownloadData a(AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean)
  {
    ADVideoAppDownloadData localADVideoAppDownloadData = null;
    Object localObject1 = null;
    if (paramAdvertisementInfo == null) {
      return null;
    }
    for (Object localObject2 = localADVideoAppDownloadData;; localObject2 = "")
    {
      Object localObject3;
      try
      {
        Object localObject4;
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getGameType(paramAdvertisementInfo) == 2)
        {
          localObject2 = localADVideoAppDownloadData;
          localObject4 = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
          localObject2 = localADVideoAppDownloadData;
          localADVideoAppDownloadData = new ADVideoAppDownloadData();
          localObject1 = localADVideoAppDownloadData;
          try
          {
            localADVideoAppDownloadData.l = true;
            localObject1 = localADVideoAppDownloadData;
            localADVideoAppDownloadData.a = ((JSONObject)localObject4).optString("game_app_id");
            localObject1 = localADVideoAppDownloadData;
            localADVideoAppDownloadData.d = ((JSONObject)localObject4).optString("game_pkg_name");
            localObject1 = localADVideoAppDownloadData;
            localADVideoAppDownloadData.e = ((JSONObject)localObject4).optString("game_app_name");
            localObject1 = localADVideoAppDownloadData;
            localADVideoAppDownloadData.c = ((JSONObject)localObject4).optString("game_apk_url");
            localObject1 = localADVideoAppDownloadData;
            localADVideoAppDownloadData.i = ((JSONObject)localObject4).optString("game_adtag");
            localObject1 = localADVideoAppDownloadData;
            localADVideoAppDownloadData.j = ((JSONObject)localObject4).optString("__ADSTR__");
            localObject1 = localADVideoAppDownloadData;
            localADVideoAppDownloadData.g = 0;
            localObject1 = localADVideoAppDownloadData;
            localADVideoAppDownloadData.f = 0;
            localObject1 = localADVideoAppDownloadData;
            localADVideoAppDownloadData.k = paramAdvertisementInfo;
            localObject1 = localADVideoAppDownloadData;
          }
          catch (JSONException localJSONException2)
          {
            localObject2 = localObject1;
            localObject1 = localJSONException2;
            break label486;
          }
        }
        localObject2 = localObject1;
        localObject3 = localObject1;
        if (paramAdvertisementInfo.mAdExt != null)
        {
          localObject2 = localObject1;
          JSONObject localJSONObject = new JSONObject(paramAdvertisementInfo.mAdExt);
          localObject2 = localObject1;
          localObject3 = new ADVideoAppDownloadData();
          localObject1 = localObject3;
          ((ADVideoAppDownloadData)localObject3).a = localJSONObject.optString("appid");
          if (paramBoolean)
          {
            localObject1 = localObject3;
            localObject2 = paramAdvertisementInfo.mAdRl;
          }
          else
          {
            localObject1 = localObject3;
            localObject2 = paramAdvertisementInfo.mAdDownloadApiUrl;
          }
          localObject1 = localObject3;
          ((ADVideoAppDownloadData)localObject3).b = ((String)localObject2);
          localObject1 = localObject3;
          ((ADVideoAppDownloadData)localObject3).d = localJSONObject.optString("pkg_name");
          localObject1 = localObject3;
          ((ADVideoAppDownloadData)localObject3).e = localJSONObject.optString("appname");
          localObject1 = localObject3;
          localObject2 = paramAdvertisementInfo.mAdvertisementExtInfo;
          if (localObject2 != null)
          {
            localObject1 = localObject3;
            if (paramAdvertisementInfo.mAdvertisementExtInfo.o == 32)
            {
              localObject1 = localObject3;
              if (!TextUtils.isEmpty(((ADVideoAppDownloadData)localObject3).b)) {
                continue;
              }
              localObject1 = localObject3;
              localObject2 = localJSONObject.optString("pkgurl");
              localObject1 = localObject3;
              ((ADVideoAppDownloadData)localObject3).c = ((String)localObject2);
              break label430;
            }
          }
          localObject1 = localObject3;
          localObject4 = localJSONObject.optString("pkgurl");
          localObject1 = localObject3;
          localObject2 = localObject4;
          if (TextUtils.isEmpty((CharSequence)localObject4))
          {
            localObject1 = localObject3;
            localObject2 = localJSONObject.optString("apk_url");
          }
          localObject1 = localObject3;
          ((ADVideoAppDownloadData)localObject3).c = ((String)localObject2);
          label430:
          localObject1 = localObject3;
          ((ADVideoAppDownloadData)localObject3).g = 0;
          localObject1 = localObject3;
          ((ADVideoAppDownloadData)localObject3).f = 0;
          localObject1 = localObject3;
          ((ADVideoAppDownloadData)localObject3).k = paramAdvertisementInfo;
          localObject1 = localObject3;
          if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdVia))
          {
            localObject1 = localObject3;
            ((ADVideoAppDownloadData)localObject3).h = paramAdvertisementInfo.mAdVia;
          }
        }
      }
      catch (JSONException localJSONException1)
      {
        label486:
        localJSONException1.printStackTrace();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getADVideoAppDownloadData exception :");
        ((StringBuilder)localObject3).append(localJSONException1.toString());
        QLog.d("ADVideoAppDownloadData", 1, ((StringBuilder)localObject3).toString());
        localObject3 = localObject2;
      }
      if (localObject3 != null) {
        ((ADVideoAppDownloadData)localObject3).q = paramAdvertisementInfo.mAdBtnTxt;
      }
      return localObject3;
    }
  }
  
  public static ADVideoAppDownloadData a(GameAdComData paramGameAdComData)
  {
    JSONObject localJSONObject = null;
    Object localObject3 = null;
    if (paramGameAdComData == null) {
      return null;
    }
    try
    {
      if (paramGameAdComData.u == null) {
        return localJSONObject;
      }
      localJSONObject = new JSONObject(paramGameAdComData.u);
      paramGameAdComData.I = new GameAdDownloadInfo(localJSONObject);
      Object localObject1 = new ADVideoAppDownloadData();
      try
      {
        ((ADVideoAppDownloadData)localObject1).a = paramGameAdComData.h;
        ((ADVideoAppDownloadData)localObject1).d = paramGameAdComData.e;
        ((ADVideoAppDownloadData)localObject1).e = paramGameAdComData.d;
        ((ADVideoAppDownloadData)localObject1).c = localJSONObject.optString("sGameDownloadUrl");
        ((ADVideoAppDownloadData)localObject1).g = 0;
        ((ADVideoAppDownloadData)localObject1).f = 0;
        ((ADVideoAppDownloadData)localObject1).l = true;
        ((ADVideoAppDownloadData)localObject1).p = paramGameAdComData;
        localJSONObject = new JSONObject(paramGameAdComData.F);
        ((ADVideoAppDownloadData)localObject1).j = localJSONObject.optString("ADSTR", "");
        ((ADVideoAppDownloadData)localObject1).i = localJSONObject.optString("ADTAG", "");
        ((ADVideoAppDownloadData)localObject1).q = paramGameAdComData.w;
        return localObject1;
      }
      catch (JSONException localJSONException2)
      {
        paramGameAdComData = (GameAdComData)localObject1;
        localObject1 = localJSONException2;
      }
      localObject2 = paramGameAdComData;
    }
    catch (JSONException localJSONException1)
    {
      paramGameAdComData = localObject3;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getADVideoAppDownloadData exception :");
      ((StringBuilder)localObject2).append(localJSONException1.toString());
      QLog.d("ADVideoAppDownloadData", 1, ((StringBuilder)localObject2).toString());
      localObject2 = paramGameAdComData;
    }
    return localObject2;
  }
  
  public static ADVideoAppDownloadData a(AdvertisementSoftInfo paramAdvertisementSoftInfo, int paramInt)
  {
    if (paramAdvertisementSoftInfo == null) {
      return null;
    }
    ADVideoAppDownloadData localADVideoAppDownloadData = new ADVideoAppDownloadData();
    localADVideoAppDownloadData.a = paramAdvertisementSoftInfo.z;
    localADVideoAppDownloadData.b = paramAdvertisementSoftInfo.B;
    localADVideoAppDownloadData.d = paramAdvertisementSoftInfo.y;
    localADVideoAppDownloadData.e = paramAdvertisementSoftInfo.A;
    localADVideoAppDownloadData.c = paramAdvertisementSoftInfo.B;
    localADVideoAppDownloadData.i = paramAdvertisementSoftInfo.F;
    localADVideoAppDownloadData.j = paramAdvertisementSoftInfo.G;
    boolean bool = false;
    localADVideoAppDownloadData.g = 0;
    localADVideoAppDownloadData.f = 0;
    if (paramInt != 0) {
      bool = true;
    }
    localADVideoAppDownloadData.l = bool;
    localADVideoAppDownloadData.q = paramAdvertisementSoftInfo.W;
    return localADVideoAppDownloadData;
  }
  
  public static String a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {
      return null;
    }
    try
    {
      if (paramVideoAdInfo.A != null)
      {
        paramVideoAdInfo = new JSONObject(paramVideoAdInfo.A).optString("pkg_name");
        return paramVideoAdInfo;
      }
    }
    catch (JSONException paramVideoAdInfo)
    {
      paramVideoAdInfo.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getADVideoAppDownloadData exception :");
      localStringBuilder.append(paramVideoAdInfo.toString());
      QLog.d("ADVideoAppDownloadData", 1, localStringBuilder.toString());
    }
    return null;
  }
  
  public boolean a()
  {
    return TextUtils.isEmpty(this.c) ^ true;
  }
  
  public boolean a(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    return (paramADVideoAppDownloadData != null) && (paramADVideoAppDownloadData.a.equals(this.a)) && (paramADVideoAppDownloadData.d.equals(this.d)) && (paramADVideoAppDownloadData.b.equals(this.b));
  }
  
  public boolean b()
  {
    return (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.b));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (ADVideoAppDownloadData)paramObject;
      String str = this.c;
      if (str != null)
      {
        if (!str.equals(paramObject.c)) {
          return false;
        }
      }
      else if (paramObject.c != null) {
        return false;
      }
      str = this.d;
      if (str != null) {
        return str.equals(paramObject.d);
      }
      return paramObject.d == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.c;
    int i2 = 0;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = this.d;
    if (str != null) {
      i2 = str.hashCode();
    }
    return i1 * 31 + i2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData
 * JD-Core Version:    0.7.0.1
 */