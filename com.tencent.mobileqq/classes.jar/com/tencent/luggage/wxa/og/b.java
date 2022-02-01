package com.tencent.luggage.wxa.og;

import com.tencent.luggage.wxa.hv.i;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.oe.c;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b
  extends com.tencent.luggage.wxa.oe.d
{
  private l a = null;
  
  private l a(h paramh)
  {
    if (this.a == null)
    {
      Object localObject = paramh.q();
      if ((paramh.q().z() instanceof t))
      {
        paramh = ((t)((com.tencent.luggage.wxa.iu.d)localObject).z()).d();
        int i = 0;
        while (i < paramh.size())
        {
          localObject = (com.tencent.mm.plugin.appbrand.appstorage.o)paramh.get(i);
          if ((localObject instanceof l))
          {
            this.a = ((l)localObject);
            break;
          }
          i += 1;
        }
      }
      throw new IllegalStateException("getFlattenFileSystem not LuggageFileSystemRegistry");
    }
    return this.a;
  }
  
  public int a()
  {
    return 7;
  }
  
  protected String a(i parami, c paramc)
  {
    Object localObject = a(paramc.a());
    if (localObject != null)
    {
      localObject = ((l)localObject).l(parami.optString("path"));
    }
    else
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.GetFullPathOfFlatFSSync", "getFlattenFileSystem null");
      localObject = null;
    }
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.GetFullPathOfFlatFSSync", "path:%s fullPath:%s", new Object[] { parami.optString("path"), localObject });
    parami = new HashMap();
    parami.put("fullPath", localObject);
    return paramc.a(parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.og.b
 * JD-Core Version:    0.7.0.1
 */