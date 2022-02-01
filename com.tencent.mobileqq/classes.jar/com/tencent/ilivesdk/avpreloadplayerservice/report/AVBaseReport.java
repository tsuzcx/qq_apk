package com.tencent.ilivesdk.avpreloadplayerservice.report;

import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class AVBaseReport
  implements AVReportInterface
{
  protected Map<String, String> a = new HashMap();
  HttpInterface b;
  private LogInterface c = null;
  
  private String c()
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("_dc=");
    ((StringBuilder)localObject2).append(Math.random());
    Object localObject3 = this.a.entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject3).next();
      ((StringBuilder)localObject2).append("&");
      ((StringBuilder)localObject2).append((String)((Map.Entry)localObject1).getKey());
      ((StringBuilder)localObject2).append("=");
      if (((Map.Entry)localObject1).getValue() == null) {
        localObject1 = " ";
      } else {
        localObject1 = (String)((Map.Entry)localObject1).getValue();
      }
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    Object localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("https://h.trace.qq.com/kv?");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = this.c;
    if (localObject2 != null)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("AVReport | send=");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((LogInterface)localObject2).d("AVReport", ((StringBuilder)localObject3).toString(), new Object[0]);
    }
    return localObject1;
  }
  
  public abstract void a();
  
  public void a(HttpInterface paramHttpInterface)
  {
    this.b = paramHttpInterface;
  }
  
  public void a(LogInterface paramLogInterface)
  {
    this.c = paramLogInterface;
    this.b.init(new AVBaseReport.1(this, paramLogInterface));
    a();
  }
  
  public void b()
  {
    c();
    this.b.post("https://h.trace.qq.com/kv", this.a, new AVBaseReport.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadplayerservice.report.AVBaseReport
 * JD-Core Version:    0.7.0.1
 */