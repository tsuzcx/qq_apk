package com.tencent.mobileqq.a.a;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class a$c
{
  private static final String a = "msf.event.NetConnDontMatched";
  private boolean b = false;
  private d c;
  private boolean d = false;
  
  public static c a()
  {
    return a.c.a.a();
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    if (!paramBoolean) {
      a.b = false;
    }
    if (this.b)
    {
      d locald = this.c;
      if ((locald != null) && (com.tencent.mobileqq.msf.core.net.j.a(locald))) {
        a.b = true;
      }
    }
  }
  
  public void a(boolean paramBoolean, d paramd)
  {
    this.b = paramBoolean;
    this.c = paramd;
    this.d = false;
    a.b = false;
  }
  
  public void b()
  {
    if (this.b)
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        int i;
        if ("00000".equals(((d)localObject).h)) {
          i = 2;
        } else {
          i = 1;
        }
        if (com.tencent.mobileqq.msf.core.net.j.a(this.c))
        {
          a.b = true;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("conn is cross oper!!! ");
          ((StringBuilder)localObject).append(this.c.toString());
          QLog.i("ConnQualityStat", 1, ((StringBuilder)localObject).toString());
          localObject = new HashMap();
          ((HashMap)localObject).put("uin", String.valueOf(MsfCore.sCore.getAccountCenter().i()));
          ((HashMap)localObject).put("netType", String.valueOf(i));
          ((HashMap)localObject).put("region", this.c.i);
          ((HashMap)localObject).put("oper", this.c.j);
          ((HashMap)localObject).put("vip", this.c.c());
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(MsfCore.sCore.getAccountCenter().i());
          localStringBuilder.append("_");
          localStringBuilder.append(i);
          localStringBuilder.append("_");
          localStringBuilder.append(System.currentTimeMillis());
          ((HashMap)localObject).put("uintime", String.valueOf(localStringBuilder.toString()));
          if (MsfService.getCore().getStatReporter() != null) {
            MsfService.getCore().getStatReporter().a("msf.event.NetConnDontMatched", true, 0L, 0L, (Map)localObject, false, false);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */