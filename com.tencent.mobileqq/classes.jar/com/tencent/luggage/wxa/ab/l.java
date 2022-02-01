package com.tencent.luggage.wxa.ab;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ak.h;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.u;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.h.p;
import com.tencent.luggage.wxa.l.d;
import com.tencent.luggage.wxa.l.e;
import com.tencent.luggage.wxa.l.j;
import com.tencent.luggage.wxa.l.k.a;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class l
  implements d
{
  private static final Pattern a = Pattern.compile("LOCAL:([^,]+)");
  private static final Pattern b = Pattern.compile("MPEGTS:(\\d+)");
  private final String c;
  private final u d;
  private final m e;
  private com.tencent.luggage.wxa.l.f f;
  private byte[] g;
  private int h;
  
  public l(String paramString, u paramu)
  {
    this.c = paramString;
    this.d = paramu;
    this.e = new m();
    this.g = new byte[1024];
  }
  
  private com.tencent.luggage.wxa.l.l a(long paramLong)
  {
    com.tencent.luggage.wxa.l.l locall = this.f.a(0, 3);
    locall.a(k.a(null, "text/vtt", null, -1, 0, this.c, null, paramLong));
    this.f.a();
    return locall;
  }
  
  private void a()
  {
    Object localObject2 = new m(this.g);
    label147:
    label185:
    p localp;
    try
    {
      h.a((m)localObject2);
      long l1 = 0L;
      long l2 = l1;
      for (;;)
      {
        localObject1 = ((m)localObject2).y();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label185;
        }
        if (((String)localObject1).startsWith("X-TIMESTAMP-MAP"))
        {
          Matcher localMatcher1 = a.matcher((CharSequence)localObject1);
          if (!localMatcher1.find()) {
            break label147;
          }
          Matcher localMatcher2 = b.matcher((CharSequence)localObject1);
          if (!localMatcher2.find()) {
            break;
          }
          l2 = h.a(localMatcher1.group(1));
          l1 = u.d(Long.parseLong(localMatcher2.group(1)));
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("X-TIMESTAMP-MAP doesn't contain media timestamp: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new p(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("X-TIMESTAMP-MAP doesn't contain local timestamp: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new p(((StringBuilder)localObject2).toString());
      Object localObject1 = h.b((m)localObject2);
      if (localObject1 == null)
      {
        a(0L);
        return;
      }
      long l3 = h.a(((Matcher)localObject1).group(1));
      l1 = this.d.b(u.e(l1 + l3 - l2));
      localObject1 = a(l1 - l3);
      this.e.a(this.g, this.h);
      ((com.tencent.luggage.wxa.l.l)localObject1).a(this.e, this.h);
      ((com.tencent.luggage.wxa.l.l)localObject1).a(l1, 1, this.h, 0, null);
      return;
    }
    catch (com.tencent.luggage.wxa.ad.f localf)
    {
      localp = new p(localf);
    }
    for (;;)
    {
      throw localp;
    }
  }
  
  public int a(e parame, j paramj)
  {
    int j = (int)parame.d();
    int i = this.h;
    paramj = this.g;
    if (i == paramj.length)
    {
      if (j != -1) {
        i = j;
      } else {
        i = paramj.length;
      }
      this.g = Arrays.copyOf(paramj, i * 3 / 2);
    }
    paramj = this.g;
    i = this.h;
    i = parame.a(paramj, i, paramj.length - i);
    if (i != -1)
    {
      this.h += i;
      if ((j == -1) || (this.h != j)) {
        return 0;
      }
    }
    a();
    return -1;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    throw new IllegalStateException();
  }
  
  public void a(com.tencent.luggage.wxa.l.f paramf)
  {
    this.f = paramf;
    paramf.a(new k.a(-9223372036854775807L));
  }
  
  public boolean a(e parame)
  {
    throw new IllegalStateException();
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ab.l
 * JD-Core Version:    0.7.0.1
 */