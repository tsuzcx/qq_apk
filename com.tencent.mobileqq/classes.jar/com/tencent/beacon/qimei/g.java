package com.tencent.beacon.qimei;

import android.content.Context;
import com.tencent.beacon.core.d.a.a;
import com.tencent.beacon.core.d.m;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.info.b;
import com.tencent.beacon.core.protocol.common.RequestPackage;
import com.tencent.beacon.core.wup.JceStruct;
import java.util.LinkedHashMap;
import java.util.Map;

public class g
  extends com.tencent.beacon.core.d.a
{
  protected Context h = null;
  protected RequestPackage i = null;
  
  public g(Context paramContext, String paramString, a.a parama)
  {
    super(paramContext, 0, 102, paramString, parama);
    this.h = paramContext;
  }
  
  public void a(boolean paramBoolean)
  {
    a.a locala = this.g;
    if (locala != null) {
      locala.a(paramBoolean);
    }
  }
  
  public RequestPackage f()
  {
    d.a("[qimei] start", new Object[0]);
    Object localObject1 = this.i;
    if (localObject1 != null) {
      return localObject1;
    }
    try
    {
      localObject1 = a.a(this.h);
      if (localObject1 == null)
      {
        d.b("[qimei] qimeiInfo is null, return", new Object[0]);
        return null;
      }
      localObject1 = ((a)localObject1).d().toByteArray();
      Object localObject2 = b.b(this.c);
      this.i = m.a(this.a, (b)localObject2, (byte[])localObject1, 2, 3, this.f);
      if (c() == 102)
      {
        localObject1 = com.tencent.beacon.core.info.c.a(((b)localObject2).c());
        localObject2 = new LinkedHashMap();
        ((Map)localObject2).put("A141", QimeiSDK.getInstance().getBeaconIdInfo(this.c));
        ((Map)localObject2).put("A142", ((com.tencent.beacon.core.info.c)localObject1).l());
        ((Map)localObject2).put("A143", ((com.tencent.beacon.core.info.c)localObject1).j());
        ((Map)localObject2).put("A144", ((com.tencent.beacon.core.info.c)localObject1).i());
        this.i.reserved = com.tencent.beacon.core.e.c.a((Map)localObject2);
      }
      d.a("[qimei] QIMEI upload data: %s", new Object[] { this.i });
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        d.a(localThrowable);
      }
    }
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.qimei.g
 * JD-Core Version:    0.7.0.1
 */