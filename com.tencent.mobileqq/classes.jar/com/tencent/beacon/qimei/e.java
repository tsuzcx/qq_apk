package com.tencent.beacon.qimei;

import android.content.Context;
import com.tencent.beacon.core.a.g.a;
import com.tencent.beacon.core.d.k;
import com.tencent.beacon.core.e.j;
import java.util.Calendar;
import java.util.Map;

public class e
{
  private static e a;
  private int b = 1;
  private Context c;
  private IAsyncQimeiListener d;
  private Runnable e = new b(this);
  private final g.a f = new c(this);
  
  public e(Context paramContext)
  {
    this.c = paramContext;
    d locald = new d(this);
    k.a(paramContext).a(103, locald);
  }
  
  public static e a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new e(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    com.tencent.beacon.core.e.d.a("[qimei] update qimei: " + paramString, new Object[0]);
    Qimei localQimei = a.a(this.c).b();
    Map localMap = i.a(paramString);
    if (localMap != null)
    {
      localQimei = new Qimei((String)localMap.get("A3"), (String)localMap.get("A153"), localMap);
      i.b(this.c, localQimei.toString());
    }
    a.a(this.c).a(localQimei);
    i.a(this.c, paramString);
    paramString = this.d;
    if (paramString != null) {}
    try
    {
      paramString.onQimeiDispatch(localQimei);
      this.d = null;
      return;
    }
    catch (Exception paramString)
    {
      com.tencent.beacon.core.e.d.a(paramString);
    }
  }
  
  protected void a(IAsyncQimeiListener paramIAsyncQimeiListener)
  {
    this.d = paramIAsyncQimeiListener;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return;
    }
    try
    {
      paramArrayOfByte = new com.tencent.beacon.core.wup.a(paramArrayOfByte);
      QimeiPackage localQimeiPackage = new QimeiPackage();
      localQimeiPackage.readFrom(paramArrayOfByte);
      boolean bool = j.b(localQimeiPackage.qimei);
      if (!bool)
      {
        com.tencent.beacon.core.e.d.d("[qimei] Async return qimei: %s", new Object[] { localQimeiPackage.qimei });
        a(localQimeiPackage.qimei);
        com.tencent.beacon.core.a.g.a().a(this.f);
        i.a(this.c);
      }
      com.tencent.beacon.core.e.d.h("[qimei] update Qimei:%s  imei:%s  imsi:%s  aid:%s  mac:%s by server.", new Object[] { localQimeiPackage.qimei, localQimeiPackage.imei, localQimeiPackage.imsi, localQimeiPackage.androidId, localQimeiPackage.mac });
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      com.tencent.beacon.core.e.d.a(paramArrayOfByte);
    }
  }
  
  public boolean a()
  {
    String str = com.tencent.beacon.core.strategy.g.b(this.c).a("qimeiZeroPeak");
    return (str != null) && ("y".equalsIgnoreCase(str)) && (Calendar.getInstance().get(11) == 0);
  }
  
  public boolean b()
  {
    boolean bool = true;
    String str = com.tencent.beacon.core.strategy.g.b(this.c).a("updateQimei");
    if ("n".equalsIgnoreCase(str)) {
      bool = false;
    }
    while (!"y".equalsIgnoreCase(str)) {
      return bool;
    }
    return true;
  }
  
  public void c()
  {
    d();
    if (j.b(a.a(this.c).c())) {
      com.tencent.beacon.core.a.g.a().a(this.c, this.f);
    }
  }
  
  public void d()
  {
    try
    {
      boolean bool2 = b();
      boolean bool1 = bool2;
      if (bool2)
      {
        boolean bool3 = i.b(this.c);
        bool1 = bool2;
        if (!bool3) {
          bool1 = false;
        }
      }
      if (!"".equals(a.a(this.c).a()))
      {
        bool2 = com.tencent.beacon.core.info.a.k(this.c);
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      com.tencent.beacon.core.e.d.a("[module] QIMEI query module > %S", new Object[] { Boolean.valueOf(bool1) });
      if ((bool1) && (!a()) && (k.a(this.c).f())) {
        com.tencent.beacon.core.a.d.a().a(112, this.e, 0L, 60000L);
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.core.e.d.b("[qimei] save GEN_QIMEI flag failed! ", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.qimei.e
 * JD-Core Version:    0.7.0.1
 */