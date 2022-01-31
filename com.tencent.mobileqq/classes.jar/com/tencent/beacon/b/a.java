package com.tencent.beacon.b;

import android.content.Context;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.a.f.g;
import com.tencent.beacon.a.f.h;
import java.util.Calendar;
import java.util.Map;

public final class a
  extends com.tencent.beacon.a.a
  implements f
{
  private static a c;
  private int b = 1;
  
  private a(Context paramContext)
  {
    super(paramContext);
    com.tencent.beacon.a.c.d.a(paramContext).a(this);
  }
  
  public static a j(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new a(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public final String a()
  {
    return b.a(this.a).a();
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new com.tencent.beacon.a.h.a(paramArrayOfByte);
        paramArrayOfByte = new c();
        paramArrayOfByte.a((com.tencent.beacon.a.h.a)localObject);
        localObject = paramArrayOfByte.a;
        if ((localObject != null) && (!((String)localObject).equals("")))
        {
          if (i == 0)
          {
            b.a(this.a).a(paramArrayOfByte.a);
            new e(this.a).a(paramArrayOfByte.a);
          }
          com.tencent.beacon.a.g.a.h("[qimei] update Qimei:%s  imei:%s  imsi:%s  aid:%s  mac:%s by server.", new Object[] { paramArrayOfByte.a, paramArrayOfByte.b, paramArrayOfByte.d, paramArrayOfByte.e, paramArrayOfByte.c });
          return;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        com.tencent.beacon.a.g.a.a(paramArrayOfByte);
        return;
      }
      i = 1;
    }
  }
  
  public final void a_()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = com.tencent.beacon.a.e.a.a().d();
        if (localObject1 != null)
        {
          localObject1 = (String)((Map)localObject1).get("updateQimei");
          if ((localObject1 != null) && ("n".equalsIgnoreCase((String)localObject1)))
          {
            i = 0;
            break label215;
            localObject1 = new e(this.a);
            int j = i;
            if (i != 0)
            {
              j = i;
              if (((e)localObject1).b()) {
                j = 0;
              }
            }
            if ("".equals(b.a(this.a).b())) {
              j = 1;
            }
            if (j == 0) {
              break;
            }
            Object localObject2 = com.tencent.beacon.a.e.a.a().d();
            if (localObject2 == null) {
              continue;
            }
            localObject2 = (String)((Map)localObject2).get("qimeiZeroPeak");
            if ((localObject2 == null) || (!"y".equalsIgnoreCase((String)localObject2)) || (Calendar.getInstance().get(11) != 0)) {
              continue;
            }
            i = 1;
            if (i != 0) {
              break;
            }
            localObject1 = new Runnable()
            {
              public final void run()
              {
                d locald = new d(a.a(a.this));
                this.a.a(locald);
                this.b.c();
              }
            };
            com.tencent.beacon.a.a.b.a().a((Runnable)localObject1);
            return;
          }
          if (localObject1 != null) {
            "y".equalsIgnoreCase((String)localObject1);
          }
        }
        i = 1;
        break label215;
        i = 0;
        continue;
        i = 0;
        continue;
        if (i == 0) {
          continue;
        }
      }
      catch (Exception localException)
      {
        com.tencent.beacon.a.g.a.d("[qimei] save GEN_QIMEI flag failed! ", new Object[0]);
        return;
      }
      label215:
      int i = 1;
    }
  }
  
  public final int g()
  {
    Object localObject = com.tencent.beacon.a.e.a.a().d();
    if (localObject != null)
    {
      localObject = (String)((Map)localObject).get("maxQIMEIQueryOneDay");
      if ((localObject != null) && (!((String)localObject).trim().equals("")))
      {
        int i = this.b;
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
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.b.a
 * JD-Core Version:    0.7.0.1
 */