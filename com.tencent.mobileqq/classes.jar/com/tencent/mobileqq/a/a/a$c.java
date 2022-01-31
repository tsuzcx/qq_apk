package com.tencent.mobileqq.a.a;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.core.net.j;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

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
    if ((this.b) && (this.c != null) && (j.a(this.c))) {
      a.b = true;
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
    if ((this.b) && (this.c != null)) {
      if (!"00000".equals(this.c.h)) {
        break label235;
      }
    }
    label235:
    for (int i = 2;; i = 1)
    {
      if (j.a(this.c))
      {
        a.b = true;
        QLog.i("ConnQualityStat", 1, "conn is cross oper!!! " + this.c.toString());
        HashMap localHashMap = new HashMap();
        localHashMap.put("uin", String.valueOf(MsfCore.sCore.getAccountCenter().i()));
        localHashMap.put("netType", String.valueOf(i));
        localHashMap.put("region", this.c.i);
        localHashMap.put("oper", this.c.j);
        localHashMap.put("vip", this.c.c());
        localHashMap.put("uintime", String.valueOf(MsfCore.sCore.getAccountCenter().i() + "_" + i + "_" + System.currentTimeMillis()));
        if (MsfService.getCore().getStatReporter() != null) {
          MsfService.getCore().getStatReporter().a("msf.event.NetConnDontMatched", true, 0L, 0L, localHashMap, false, false);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */