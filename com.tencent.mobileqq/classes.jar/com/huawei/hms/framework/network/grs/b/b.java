package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static Map<String, b> a = new ConcurrentHashMap(16);
  private a b;
  
  public b(Context paramContext, GrsBaseInfo paramGrsBaseInfo, boolean paramBoolean)
  {
    a(paramContext, paramBoolean);
    Map localMap = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append(paramGrsBaseInfo.uniqueCode());
    localMap.put(localStringBuilder.toString(), this);
  }
  
  public static b a(String paramString, GrsBaseInfo paramGrsBaseInfo)
  {
    Map localMap = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramGrsBaseInfo.uniqueCode());
    return (b)localMap.get(localStringBuilder.toString());
  }
  
  public static void a(Context paramContext, GrsBaseInfo paramGrsBaseInfo)
  {
    paramContext = a(paramContext.getPackageName(), paramGrsBaseInfo);
    if (paramContext != null)
    {
      paramContext = paramContext.a();
      if (paramContext != null)
      {
        Logger.i("LocalManagerProxy", "appGrs is not null and clear services.");
        paramContext.a();
      }
    }
  }
  
  public com.huawei.hms.framework.network.grs.local.model.a a()
  {
    return this.b.a();
  }
  
  public String a(Context paramContext, com.huawei.hms.framework.network.grs.a.a parama, GrsBaseInfo paramGrsBaseInfo, String paramString1, String paramString2, boolean paramBoolean)
  {
    return this.b.a(paramContext, parama, paramGrsBaseInfo, paramString1, paramString2, paramBoolean);
  }
  
  public Map<String, String> a(Context paramContext, com.huawei.hms.framework.network.grs.a.a parama, GrsBaseInfo paramGrsBaseInfo, String paramString, boolean paramBoolean)
  {
    return this.b.a(paramContext, parama, paramGrsBaseInfo, paramString, paramBoolean);
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    this.b = new d(paramContext, paramBoolean);
    if (!this.b.c()) {
      this.b = new c(paramContext, paramBoolean);
    }
  }
  
  public void a(GrsBaseInfo paramGrsBaseInfo)
  {
    this.b.a(paramGrsBaseInfo);
  }
  
  public Set<String> b()
  {
    return this.b.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.b.b
 * JD-Core Version:    0.7.0.1
 */