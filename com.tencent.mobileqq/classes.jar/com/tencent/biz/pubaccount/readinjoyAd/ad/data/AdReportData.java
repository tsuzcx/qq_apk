package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import org.json.JSONObject;

public class AdReportData
{
  boolean a;
  private AppInterface b;
  private Context c;
  private int d;
  private int e;
  private AdvertisementInfo f;
  private VideoAdInfo g;
  private long h = 0L;
  private String i;
  private String j;
  private JSONObject k;
  private int l = 0;
  private JSONObject m;
  private Bundle n;
  private JSONObject o;
  private JSONObject p;
  private JSONObject q;
  private JSONObject r;
  private int s;
  private int t = 1;
  private Integer u;
  private boolean v;
  private ActionEntity w;
  private ReportAction x;
  
  public AdReportData a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public AdReportData a(long paramLong)
  {
    this.h = paramLong;
    return this;
  }
  
  public AdReportData a(Context paramContext)
  {
    this.c = paramContext;
    return this;
  }
  
  public AdReportData a(Bundle paramBundle)
  {
    this.n = paramBundle;
    return this;
  }
  
  public AdReportData a(ActionEntity paramActionEntity)
  {
    this.w = paramActionEntity;
    return this;
  }
  
  public AdReportData a(ReportAction paramReportAction)
  {
    this.x = paramReportAction;
    return this;
  }
  
  public AdReportData a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.f = paramAdvertisementInfo;
    return this;
  }
  
  public AdReportData a(AppInterface paramAppInterface)
  {
    this.b = paramAppInterface;
    return this;
  }
  
  public AdReportData a(VideoAdInfo paramVideoAdInfo)
  {
    this.g = paramVideoAdInfo;
    return this;
  }
  
  public AdReportData a(Integer paramInteger)
  {
    if (paramInteger != null) {
      this.t = paramInteger.intValue();
    }
    return this;
  }
  
  public AdReportData a(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public AdReportData a(JSONObject paramJSONObject)
  {
    this.k = paramJSONObject;
    return this;
  }
  
  public AdReportData a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    return this;
  }
  
  public AppInterface a()
  {
    return this.b;
  }
  
  public Context b()
  {
    return this.c;
  }
  
  public AdReportData b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public AdReportData b(Integer paramInteger)
  {
    this.u = paramInteger;
    return this;
  }
  
  public AdReportData b(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public AdReportData b(JSONObject paramJSONObject)
  {
    this.m = paramJSONObject;
    return this;
  }
  
  public AdReportData b(boolean paramBoolean)
  {
    this.v = paramBoolean;
    return this;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public AdReportData c(int paramInt)
  {
    this.l = paramInt;
    return this;
  }
  
  public AdReportData c(JSONObject paramJSONObject)
  {
    this.o = paramJSONObject;
    return this;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public AdReportData d(int paramInt)
  {
    this.s = paramInt;
    return this;
  }
  
  public AdReportData d(JSONObject paramJSONObject)
  {
    this.q = paramJSONObject;
    return this;
  }
  
  public int e()
  {
    return this.s;
  }
  
  public AdReportData e(JSONObject paramJSONObject)
  {
    this.r = paramJSONObject;
    return this;
  }
  
  public boolean f()
  {
    return this.a;
  }
  
  public AdvertisementInfo g()
  {
    return this.f;
  }
  
  public VideoAdInfo h()
  {
    return this.g;
  }
  
  public long i()
  {
    return this.h;
  }
  
  public String j()
  {
    return this.i;
  }
  
  public String k()
  {
    return this.j;
  }
  
  public JSONObject l()
  {
    return this.k;
  }
  
  public int m()
  {
    if (this.l <= 0)
    {
      AdvertisementInfo localAdvertisementInfo = this.f;
      if ((localAdvertisementInfo != null) && (localAdvertisementInfo.clickPos > 0)) {
        this.l = this.f.clickPos;
      }
    }
    return this.l;
  }
  
  public JSONObject n()
  {
    return this.m;
  }
  
  public Bundle o()
  {
    return this.n;
  }
  
  public JSONObject p()
  {
    return this.o;
  }
  
  public JSONObject q()
  {
    return this.p;
  }
  
  public JSONObject r()
  {
    if (this.r == null) {
      this.r = new JSONObject();
    }
    return this.r;
  }
  
  public JSONObject s()
  {
    return this.q;
  }
  
  public Integer t()
  {
    return Integer.valueOf(this.t);
  }
  
  public boolean u()
  {
    return this.v;
  }
  
  public ActionEntity v()
  {
    return this.w;
  }
  
  public Integer w()
  {
    return this.u;
  }
  
  public ReportAction x()
  {
    return this.x;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData
 * JD-Core Version:    0.7.0.1
 */