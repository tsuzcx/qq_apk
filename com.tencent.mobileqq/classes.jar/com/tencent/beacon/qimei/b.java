package com.tencent.beacon.qimei;

import android.content.Context;
import com.tencent.beacon.core.c.i;
import com.tencent.beacon.core.d.h;
import java.util.Calendar;
import java.util.Map;

public final class b
{
  private static b b;
  private int a = 1;
  private Context c;
  private IAsyncQimeiListener d;
  private Runnable e = new b.1(this);
  
  private b(Context paramContext)
  {
    this.c = paramContext;
    QimeiSDK.getInstance().setQimeiModule(this);
    b.2 local2 = new b.2(this);
    i.a(paramContext).a(103, local2);
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new b(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public final void a()
  {
    for (;;)
    {
      try
      {
        Object localObject = com.tencent.beacon.core.strategy.a.a().d();
        if (localObject != null)
        {
          localObject = (String)((Map)localObject).get("updateQimei4QQ");
          if ((localObject != null) && ("n".equalsIgnoreCase((String)localObject)))
          {
            i = 0;
            break label236;
            boolean bool2 = bool1;
            if (bool1)
            {
              bool2 = bool1;
              if (d.b(this.c)) {
                bool2 = false;
              }
            }
            if ("".equals(a.a(this.c).b())) {
              bool2 = true;
            }
            com.tencent.beacon.core.d.b.b("[module] QIMEI query module > %S", new Object[] { Boolean.valueOf(bool2) });
            if (!bool2) {
              break;
            }
            localObject = com.tencent.beacon.core.strategy.a.a().d();
            if (localObject == null) {
              continue;
            }
            localObject = (String)((Map)localObject).get("qimeiZeroPeak4QQ");
            if ((localObject == null) || (!"y".equalsIgnoreCase((String)localObject)) || (Calendar.getInstance().get(11) != 0)) {
              continue;
            }
            i = 1;
            if ((i != 0) || (!i.a(this.c).a())) {
              break;
            }
            com.tencent.beacon.core.a.b.b().a(112, this.e, 0L, 60000L);
            return;
          }
          if (localObject != null) {
            "y".equalsIgnoreCase((String)localObject);
          }
        }
        int i = 1;
        break label236;
        bool1 = false;
        continue;
        i = 0;
        continue;
        if (i == 0) {
          continue;
        }
      }
      catch (Exception localException)
      {
        com.tencent.beacon.core.d.b.d("[qimei] save GEN_QIMEI flag failed! ", new Object[0]);
        return;
      }
      label236:
      boolean bool1 = true;
    }
  }
  
  protected final void a(IAsyncQimeiListener paramIAsyncQimeiListener)
  {
    this.d = paramIAsyncQimeiListener;
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return;
    }
    try
    {
      paramArrayOfByte = new com.tencent.beacon.core.wup.a(paramArrayOfByte);
      QimeiPackage localQimeiPackage = new QimeiPackage();
      localQimeiPackage.readFrom(paramArrayOfByte);
      if (!h.a(localQimeiPackage.qimei))
      {
        if (this.d != null)
        {
          com.tencent.beacon.core.d.b.a("[qimei] Async return qimei: %s", new Object[] { localQimeiPackage.qimei });
          this.d.onQimeiDispatch(localQimeiPackage.qimei);
          this.d = null;
        }
        a.a(this.c).a(localQimeiPackage.qimei);
        d.a(this.c, localQimeiPackage.qimei);
      }
      com.tencent.beacon.core.d.b.h("[qimei] update Qimei:%s  imei:%s  imsi:%s  aid:%s  mac:%s by server.", new Object[] { localQimeiPackage.qimei, localQimeiPackage.imei, localQimeiPackage.imsi, localQimeiPackage.androidId, localQimeiPackage.mac });
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      com.tencent.beacon.core.d.b.a(paramArrayOfByte);
    }
  }
  
  public final int b()
  {
    Object localObject = com.tencent.beacon.core.strategy.a.a().d();
    if (localObject != null)
    {
      localObject = (String)((Map)localObject).get("maxQIMEIQueryOneDay");
      if ((localObject != null) && (!((String)localObject).trim().equals("")))
      {
        int i = this.a;
        try
        {
          int j = Integer.valueOf((String)localObject).intValue();
          return j;
        }
        catch (Exception localException)
        {
          return i;
        }
      }
    }
    return this.a;
  }
  
  public final String c()
  {
    return a.a(this.c).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.qimei.b
 * JD-Core Version:    0.7.0.1
 */