package com.huawei.hms.framework.network.grs;

import android.content.Context;
import java.util.Map;

public class GrsClient
{
  private d grsClientGlobal;
  
  public GrsClient(Context paramContext, GrsBaseInfo paramGrsBaseInfo)
  {
    if ((paramContext != null) && (paramGrsBaseInfo != null))
    {
      this.grsClientGlobal = e.a(paramGrsBaseInfo, paramContext);
      return;
    }
    throw new NullPointerException("invalid init params for context is null or GrsBaseInfo instance is null Object.");
  }
  
  public void ayncGetGrsUrl(String paramString1, String paramString2, IQueryUrlCallBack paramIQueryUrlCallBack)
  {
    this.grsClientGlobal.a(paramString1, paramString2, paramIQueryUrlCallBack);
  }
  
  public void ayncGetGrsUrls(String paramString, IQueryUrlsCallBack paramIQueryUrlsCallBack)
  {
    this.grsClientGlobal.a(paramString, paramIQueryUrlsCallBack);
  }
  
  public void clearSp()
  {
    this.grsClientGlobal.b();
  }
  
  public boolean forceExpire()
  {
    return this.grsClientGlobal.c();
  }
  
  public String synGetGrsUrl(String paramString1, String paramString2)
  {
    return this.grsClientGlobal.a(paramString1, paramString2);
  }
  
  public Map<String, String> synGetGrsUrls(String paramString)
  {
    return this.grsClientGlobal.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.GrsClient
 * JD-Core Version:    0.7.0.1
 */