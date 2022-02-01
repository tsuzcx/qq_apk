package com.huawei.hms.stats;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;

public class bq
{
  public s a;
  private String b;
  
  public bq(String paramString)
  {
    this.b = paramString;
    this.a = new s(paramString);
    n.a().a(this.b, this.a);
  }
  
  private p b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return this.a.b();
    case 3: 
      return this.a.d();
    case 1: 
      return this.a.a();
    }
    return this.a.c();
  }
  
  private boolean c(int paramInt)
  {
    if (paramInt == 2)
    {
      if (!"_default_config_tag".equals(this.b))
      {
        af.c("hmsSdk", "verifyURL(): type: preins. Only default config can report Pre-install data.");
        return false;
      }
      return true;
    }
    p localp = b(paramInt);
    if ((localp == null) || (TextUtils.isEmpty(localp.h())))
    {
      af.c("hmsSdk", "verifyURL(): URL check failed. type: " + paramInt);
      return false;
    }
    return true;
  }
  
  public void a(int paramInt)
  {
    af.a("hmsSdk", "HiAnalyticsInstance.onReport() is execute.TAG: %s,TYPE: %d", new Object[] { this.b, Integer.valueOf(paramInt) });
    bp.a().a(this.b, paramInt);
  }
  
  public void a(int paramInt, p paramp)
  {
    Object localObject = null;
    if (paramp == null) {
      af.a("hmsSdk", "HiAnalyticsInstanceImpl.refresh(). Parameter config is null.TAG : %s , TYPE : %d", new Object[] { this.b, Integer.valueOf(paramInt) });
    }
    for (paramp = localObject;; paramp = new p(paramp))
    {
      af.a("hmsSdk", "HiAnalyticsInstanceImpl.refresh() is executed.TAG : %s , TYPE : %d", new Object[] { this.b, Integer.valueOf(paramInt) });
      switch (paramInt)
      {
      default: 
        af.c("hmsSdk", "refresh(): HiAnalyticsType can only be OPERATION ,MAINTAIN or DIFF_PRIVACY.");
        return;
      }
    }
    c(paramp);
    an.a().a(this.b);
    return;
    a(paramp);
    return;
    b(paramp);
    return;
    d(paramp);
  }
  
  public void a(int paramInt, String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    af.a("hmsSdk", "HiAnalyticsInstance.onEvent(int type, String eventId, Map<String, String> mapValue) is execute.TAG: %s,TYPE: %d", new Object[] { this.b, Integer.valueOf(paramInt) });
    if ((az.a(paramString)) || (!c(paramInt)))
    {
      af.c("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.b + ", TYPE: " + paramInt);
      return;
    }
    LinkedHashMap<String, String> localLinkedHashMap = paramLinkedHashMap;
    if (!az.a(paramLinkedHashMap))
    {
      af.c("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.b + ", TYPE: " + paramInt);
      localLinkedHashMap = null;
    }
    bp.a().a(this.b, paramInt, paramString, localLinkedHashMap);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    af.b("hmsSdk", "HiAnalyticsInstance.onEvent(eventId, mapValue) is execute.TAG : " + this.b);
    if (paramContext == null)
    {
      af.c("hmsSdk", "context is null in onevent ");
      return;
    }
    if ((az.a(paramString1)) || (!c(0)))
    {
      af.c("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.b);
      return;
    }
    String str = paramString2;
    if (!az.a("value", paramString2, 65536))
    {
      af.c("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.b);
      str = "";
    }
    bp.a().a(this.b, paramContext, paramString1, str);
  }
  
  public void a(p paramp)
  {
    af.b("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.b);
    if (paramp == null)
    {
      af.c("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
      this.a.a(null);
      return;
    }
    this.a.a(paramp);
  }
  
  public void b(p paramp)
  {
    af.b("hmsSdk", "HiAnalyticsInstanceImpl.setDiffConf() is executed.TAG : " + this.b);
    if (paramp == null)
    {
      af.c("hmsSdk", "HiAnalyticsInstanceImpl.setDiffConf(): config for diffPrivacy is null!");
      this.a.d(null);
      return;
    }
    this.a.d(paramp);
  }
  
  public void c(p paramp)
  {
    af.b("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.b);
    if (paramp == null)
    {
      this.a.b(null);
      af.c("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
      return;
    }
    this.a.b(paramp);
  }
  
  public void d(p paramp)
  {
    af.b("hmsSdk", "HiAnalyticsInstanceImpl.setPreInstallConf() is executed.TAG: " + this.b);
    if (paramp == null)
    {
      af.c("hmsSdk", "HiAnalyticsInstanceImpl.setPreInstallConf(): config for PRE-INSTALL is null!");
      this.a.c(null);
      return;
    }
    this.a.c(paramp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.bq
 * JD-Core Version:    0.7.0.1
 */