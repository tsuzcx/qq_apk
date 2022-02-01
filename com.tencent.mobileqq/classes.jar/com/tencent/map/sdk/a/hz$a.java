package com.tencent.map.sdk.a;

import com.tencent.map.sdk.service.protocol.jce.conf.FileUpdateRsp;
import java.lang.ref.WeakReference;
import java.util.List;

public final class hz$a
  extends Thread
{
  private final WeakReference<hz> a;
  private final String b;
  private final hh c;
  
  public hz$a(hz paramhz, String paramString, hh paramhh)
  {
    this.a = new WeakReference(paramhz);
    this.b = paramString;
    this.c = paramhh;
  }
  
  public final void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (hz)this.a.get();
      List localList = hz.a((hz)localObject, this.b, this.c);
      int i = 0;
      if (localList != null)
      {
        if (((hz)localObject).a)
        {
          if ((hz.a((hz)localObject, hz.a((hz)localObject), hz.b((hz)localObject))) && (hz.a((hz)localObject, hz.c((hz)localObject), hz.d((hz)localObject)))) {}
          while (i < localList.size())
          {
            hz.a((hz)localObject, (FileUpdateRsp)localList.get(i));
            i += 1;
            continue;
            ((hz)localObject).a = false;
            hz.a((hz)localObject, false);
            return;
          }
        }
        hz.a((hz)localObject, true);
        return;
      }
      ((hz)localObject).a = false;
      hz.a((hz)localObject, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.hz.a
 * JD-Core Version:    0.7.0.1
 */