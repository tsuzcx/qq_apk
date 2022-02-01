package com.huawei.hms.framework.network.grs.local;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static Map<String, b> a = new ConcurrentHashMap(16);
  private a b;
  
  public b(Context paramContext)
  {
    a(paramContext);
    a.put(paramContext.getPackageName(), this);
  }
  
  public static b a(String paramString)
  {
    return (b)a.get(paramString);
  }
  
  public com.huawei.hms.framework.network.grs.local.model.a a()
  {
    return this.b.a();
  }
  
  public String a(GrsBaseInfo paramGrsBaseInfo, String paramString1, String paramString2)
  {
    return this.b.a(paramGrsBaseInfo, paramString1, paramString2);
  }
  
  public Map<String, String> a(GrsBaseInfo paramGrsBaseInfo, String paramString)
  {
    return this.b.a(paramGrsBaseInfo, paramString);
  }
  
  public void a(Context paramContext)
  {
    this.b = new d(paramContext);
    if (!this.b.b()) {
      this.b = new c(paramContext);
    }
  }
  
  public void a(GrsBaseInfo paramGrsBaseInfo)
  {
    this.b.a(paramGrsBaseInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.local.b
 * JD-Core Version:    0.7.0.1
 */