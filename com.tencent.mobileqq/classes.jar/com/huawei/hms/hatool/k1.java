package com.huawei.hms.hatool;

import android.content.Context;

public class k1
{
  public k a;
  public k b;
  public Context c;
  public String d;
  
  public k1(Context paramContext)
  {
    if (paramContext != null) {
      this.c = paramContext.getApplicationContext();
    }
    this.a = new k();
    this.b = new k();
  }
  
  public k1 a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Builder.setCollectURL(int type,String collectURL) is execute.TYPE : ");
    ((StringBuilder)localObject).append(paramInt);
    y.c("hmsSdk", ((StringBuilder)localObject).toString());
    localObject = paramString;
    if (!t0.b(paramString)) {
      localObject = "";
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        y.f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
        return this;
      }
      paramString = this.b;
    }
    else
    {
      paramString = this.a;
    }
    paramString.b((String)localObject);
    return this;
  }
  
  public k1 a(String paramString)
  {
    y.c("hmsSdk", "Builder.setAppID is execute");
    this.d = paramString;
    return this;
  }
  
  @Deprecated
  public k1 a(boolean paramBoolean)
  {
    y.c("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
    this.a.j().a(paramBoolean);
    this.b.j().a(paramBoolean);
    return this;
  }
  
  public void a()
  {
    if (this.c == null)
    {
      y.b("hmsSdk", "analyticsConf create(): context is null,create failed!");
      return;
    }
    y.c("hmsSdk", "Builder.create() is execute.");
    h1 localh1 = new h1("_hms_config_tag");
    localh1.b(new k(this.a));
    localh1.a(new k(this.b));
    f1.a().a(this.c);
    g1.a().a(this.c);
    m1.c().a(localh1);
    f1.a().a(this.d);
  }
  
  @Deprecated
  public k1 b(boolean paramBoolean)
  {
    y.c("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
    this.a.j().b(paramBoolean);
    this.b.j().b(paramBoolean);
    return this;
  }
  
  @Deprecated
  public k1 c(boolean paramBoolean)
  {
    y.c("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
    this.a.j().c(paramBoolean);
    this.b.j().c(paramBoolean);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.k1
 * JD-Core Version:    0.7.0.1
 */