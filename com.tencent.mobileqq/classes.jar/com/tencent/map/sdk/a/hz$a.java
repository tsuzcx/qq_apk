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
    hz localhz;
    List localList;
    if ((this.a != null) && (this.a.get() != null))
    {
      localhz = (hz)this.a.get();
      localList = hz.a(localhz, this.b, this.c);
      if (localList == null) {
        break label132;
      }
      if (!localhz.a) {
        break label126;
      }
      if ((!hz.a(localhz, hz.a(localhz), hz.b(localhz))) || (!hz.a(localhz, hz.c(localhz), hz.d(localhz))))
      {
        localhz.a = false;
        hz.a(localhz, false);
      }
    }
    else
    {
      return;
    }
    int i = 0;
    while (i < localList.size())
    {
      hz.a(localhz, (FileUpdateRsp)localList.get(i));
      i += 1;
    }
    label126:
    hz.a(localhz, true);
    return;
    label132:
    localhz.a = false;
    hz.a(localhz, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.hz.a
 * JD-Core Version:    0.7.0.1
 */