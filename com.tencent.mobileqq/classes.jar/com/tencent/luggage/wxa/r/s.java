package com.tencent.luggage.wxa.r;

import com.tencent.luggage.wxa.ae.g;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.l.f;
import com.tencent.luggage.wxa.l.l;
import java.util.List;

final class s
{
  private final List<k> a;
  private final l[] b;
  
  public s(List<k> paramList)
  {
    this.a = paramList;
    this.b = new l[paramList.size()];
  }
  
  public void a(long paramLong, m paramm)
  {
    g.a(paramLong, paramm, this.b);
  }
  
  public void a(f paramf, v.d paramd)
  {
    int i = 0;
    while (i < this.b.length)
    {
      paramd.a();
      l locall = paramf.a(paramd.b(), 3);
      k localk = (k)this.a.get(i);
      String str = localk.f;
      boolean bool;
      if ((!"application/cea-608".equals(str)) && (!"application/cea-708".equals(str))) {
        bool = false;
      } else {
        bool = true;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid closed caption mime type provided: ");
      ((StringBuilder)localObject).append(str);
      a.a(bool, ((StringBuilder)localObject).toString());
      if (localk.a != null) {
        localObject = localk.a;
      } else {
        localObject = paramd.c();
      }
      locall.a(k.a((String)localObject, str, null, -1, localk.x, localk.y, localk.z, null));
      this.b[i] = locall;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.s
 * JD-Core Version:    0.7.0.1
 */