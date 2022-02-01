package com.tencent.luggage.wxa.qb;

import com.tencent.luggage.wxa.iu.ab;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.iu.j;
import com.tencent.luggage.wxa.pc.c;
import com.tencent.mm.appbrand.v8.w;
import com.tencent.mm.appbrand.v8.w.a;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import java.util.ArrayList;

public class a
  extends j
{
  public a(h paramh)
  {
    super(paramh);
  }
  
  protected w.a a(String paramString)
  {
    return new b.a(super.a(paramString), ab.a(c().q(), paramString, c().r()), c().getAppId(), c().C());
  }
  
  protected void a(ArrayList<w.a> paramArrayList, String paramString)
  {
    super.a(paramArrayList, paramString);
    paramString = new StringBuilder();
    paramString.append(c().s());
    paramString.append("shared_buffer.js");
    paramArrayList.add(new b.a(paramString.toString(), c.a("wxa_library/shared_buffer.js"), null, c().getAppId(), c().C()));
    paramString = new StringBuilder();
    paramString.append(c().s());
    paramString.append("android.js");
    paramArrayList.add(new b.a(paramString.toString(), c.a("wxa_library/android.js"), null, c().getAppId(), c().C()));
    paramString = new StringBuilder();
    paramString.append(c().s());
    paramString.append("WAWorker.js");
    paramArrayList.add(new b.a(paramString.toString(), c().A().a("WAWorker.js"), null, c().getAppId(), c().C()));
    paramString = ab.a(c());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c().s());
    localStringBuilder.append("WASourceMap.js");
    paramArrayList.add(new w.a(localStringBuilder.toString(), paramString));
    paramString = ab.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(c().s());
    localStringBuilder.append("sourcemapSysinfo");
    paramArrayList.add(new w.a(localStringBuilder.toString(), paramString));
  }
  
  protected w b()
  {
    return new b(f());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qb.a
 * JD-Core Version:    0.7.0.1
 */