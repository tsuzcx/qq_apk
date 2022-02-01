package com.huawei.hms.stats;

import android.content.Context;

public class bt$a
{
  p a;
  p b;
  Context c;
  String d;
  
  public bt$a(Context paramContext)
  {
    if (paramContext != null) {
      this.c = paramContext.getApplicationContext();
    }
    this.a = new p();
    this.b = new p();
  }
  
  public a a(int paramInt, String paramString)
  {
    af.b("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + paramInt);
    String str = paramString;
    if (!bc.a(paramString)) {
      str = "";
    }
    switch (paramInt)
    {
    default: 
      af.c("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
      return this;
    case 0: 
      this.a.b(str);
      return this;
    }
    this.b.b(str);
    return this;
  }
  
  public a a(String paramString)
  {
    af.b("hmsSdk", "Builder.setAppID is execute");
    this.d = paramString;
    return this;
  }
  
  public void a()
  {
    if (this.c == null)
    {
      af.d("hmsSdk", "analyticsConf create(): context is null,create failed!");
      return;
    }
    af.b("hmsSdk", "Builder.create() is execute.");
    bq localbq = new bq("_hms_config_tag");
    localbq.c(new p(this.a));
    localbq.a(new p(this.b));
    bo.a().a(this.c);
    bp.a().a(this.c);
    bv.a().a(localbq);
    bo.a().b(this.d);
  }
  
  public void a(boolean paramBoolean)
  {
    af.b("hmsSdk", "Builder.refresh() is execute.");
    p localp1 = new p(this.b);
    p localp2 = new p(this.a);
    bq localbq = bv.a().b();
    if (localbq == null) {
      af.c("hmsSdk", "HiAnalyticsInstance.Builder.Refresh(): calling refresh before create. TAG: _hms_config_tag has no instance. ");
    }
    do
    {
      return;
      localbq.a(1, localp1);
      localbq.a(0, localp2);
      if (this.d != null) {
        bo.a().b(this.d);
      }
    } while (!paramBoolean);
    bo.a().a("_hms_config_tag");
  }
  
  @Deprecated
  public a b(boolean paramBoolean)
  {
    af.b("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
    this.a.b().c(paramBoolean);
    this.b.b().c(paramBoolean);
    return this;
  }
  
  @Deprecated
  public a c(boolean paramBoolean)
  {
    af.b("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
    this.a.b().b(paramBoolean);
    this.b.b().b(paramBoolean);
    return this;
  }
  
  @Deprecated
  public a d(boolean paramBoolean)
  {
    af.b("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
    this.a.b().a(paramBoolean);
    this.b.b().a(paramBoolean);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.bt.a
 * JD-Core Version:    0.7.0.1
 */