package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;

public class h1
{
  public String a;
  public m b;
  
  public h1(String paramString)
  {
    this.a = paramString;
    this.b = new m(paramString);
    i.c().a(this.a, this.b);
  }
  
  public void a(int paramInt)
  {
    y.a("hmsSdk", "HiAnalyticsInstance.onReport() is execute.TAG: %s,TYPE: %d", new Object[] { this.a, Integer.valueOf(paramInt) });
    g1.a().a(this.a, paramInt);
  }
  
  public void a(int paramInt, String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    y.a("hmsSdk", "HiAnalyticsInstance.onEvent(int type, String eventId, Map<String, String> mapValue) is execute.TAG: %s,TYPE: %d", new Object[] { this.a, Integer.valueOf(paramInt) });
    if ((!q0.a(paramString)) && (c(paramInt)))
    {
      LinkedHashMap<String, String> localLinkedHashMap = paramLinkedHashMap;
      if (!q0.a(paramLinkedHashMap))
      {
        paramLinkedHashMap = new StringBuilder();
        paramLinkedHashMap.append("onEvent() parameter mapValue will be cleared.TAG: ");
        paramLinkedHashMap.append(this.a);
        paramLinkedHashMap.append(", TYPE: ");
        paramLinkedHashMap.append(paramInt);
        y.e("hmsSdk", paramLinkedHashMap.toString());
        localLinkedHashMap = null;
      }
      g1.a().a(this.a, paramInt, paramString, localLinkedHashMap);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("onEvent() parameters check fail. Nothing will be recorded.TAG: ");
    paramString.append(this.a);
    paramString.append(", TYPE: ");
    paramString.append(paramInt);
    y.e("hmsSdk", paramString.toString());
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("HiAnalyticsInstance.onEvent(eventId, mapValue) is execute.TAG : ");
    ((StringBuilder)localObject).append(this.a);
    y.c("hmsSdk", ((StringBuilder)localObject).toString());
    if (paramContext == null)
    {
      y.e("hmsSdk", "context is null in onevent ");
      return;
    }
    if ((!q0.a(paramString1)) && (c(0)))
    {
      localObject = paramString2;
      if (!q0.a("value", paramString2, 65536))
      {
        paramString2 = new StringBuilder();
        paramString2.append("onEvent() parameter VALUE is overlong, content will be cleared.TAG: ");
        paramString2.append(this.a);
        y.e("hmsSdk", paramString2.toString());
        localObject = "";
      }
      g1.a().a(this.a, paramContext, paramString1, (String)localObject);
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("onEvent() parameters check fail. Nothing will be recorded.TAG: ");
    paramContext.append(this.a);
    y.e("hmsSdk", paramContext.toString());
  }
  
  public void a(k paramk)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : ");
    localStringBuilder.append(this.a);
    y.c("hmsSdk", localStringBuilder.toString());
    if (paramk == null)
    {
      y.e("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
      this.b.a(null);
      return;
    }
    this.b.a(paramk);
  }
  
  public final k b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return null;
          }
          return this.b.a();
        }
        return this.b.d();
      }
      return this.b.b();
    }
    return this.b.c();
  }
  
  public void b(k paramk)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: ");
    localStringBuilder.append(this.a);
    y.c("hmsSdk", localStringBuilder.toString());
    if (paramk == null)
    {
      this.b.b(null);
      y.e("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
      return;
    }
    this.b.b(paramk);
  }
  
  public final boolean c(int paramInt)
  {
    if (paramInt == 2) {
      if ("_default_config_tag".equals(this.a)) {}
    }
    for (Object localObject = "verifyURL(): type: preins. Only default config can report Pre-install data.";; localObject = ((StringBuilder)localObject).toString())
    {
      y.e("hmsSdk", (String)localObject);
      return false;
      return true;
      localObject = b(paramInt);
      if ((localObject != null) && (!TextUtils.isEmpty(((k)localObject).h()))) {
        return true;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("verifyURL(): URL check failed. type: ");
      ((StringBuilder)localObject).append(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.h1
 * JD-Core Version:    0.7.0.1
 */