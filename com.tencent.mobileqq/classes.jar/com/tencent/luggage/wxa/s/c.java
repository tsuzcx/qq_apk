package com.tencent.luggage.wxa.s;

import android.util.Log;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.p;
import com.tencent.luggage.wxa.l.e;

final class c
{
  public static b a(e parame)
  {
    a.a(parame);
    m localm = new m(16);
    if (c.a.a(parame, localm).a != x.f("RIFF")) {
      return null;
    }
    parame.c(localm.a, 0, 4);
    localm.c(0);
    int i = localm.n();
    if (i != x.f("WAVE"))
    {
      parame = new StringBuilder();
      parame.append("Unsupported RIFF format: ");
      parame.append(i);
      Log.e("WavHeaderReader", parame.toString());
      return null;
    }
    for (c.a locala = c.a.a(parame, localm); locala.a != x.f("fmt "); locala = c.a.a(parame, localm)) {
      parame.c((int)locala.b);
    }
    boolean bool;
    if (locala.b >= 16L) {
      bool = true;
    } else {
      bool = false;
    }
    a.b(bool);
    parame.c(localm.a, 0, 16);
    localm.c(0);
    i = localm.i();
    int j = localm.i();
    int k = localm.u();
    int m = localm.u();
    int n = localm.i();
    int i1 = localm.i();
    int i2 = j * i1 / 8;
    if (n == i2)
    {
      i2 = x.b(i1);
      if (i2 == 0)
      {
        parame = new StringBuilder();
        parame.append("Unsupported WAV bit depth: ");
        parame.append(i1);
        Log.e("WavHeaderReader", parame.toString());
        return null;
      }
      if ((i != 1) && (i != 65534))
      {
        parame = new StringBuilder();
        parame.append("Unsupported WAV format type: ");
        parame.append(i);
        Log.e("WavHeaderReader", parame.toString());
        return null;
      }
      parame.c((int)locala.b - 16);
      return new b(j, k, m, n, i1, i2);
    }
    parame = new StringBuilder();
    parame.append("Expected block alignment: ");
    parame.append(i2);
    parame.append("; got: ");
    parame.append(n);
    parame = new p(parame.toString());
    for (;;)
    {
      throw parame;
    }
  }
  
  public static void a(e parame, b paramb)
  {
    a.a(parame);
    a.a(paramb);
    parame.a();
    m localm = new m(8);
    c.a locala = c.a.a(parame, localm);
    while (locala.a != x.f("data"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Ignoring unknown WAV chunk: ");
      localStringBuilder.append(locala.a);
      Log.w("WavHeaderReader", localStringBuilder.toString());
      long l = locala.b + 8L;
      if (locala.a == x.f("RIFF")) {
        l = 12L;
      }
      if (l <= 2147483647L)
      {
        parame.b((int)l);
        locala = c.a.a(parame, localm);
      }
      else
      {
        parame = new StringBuilder();
        parame.append("Chunk is too large (~2GB+) to skip; id: ");
        parame.append(locala.a);
        throw new p(parame.toString());
      }
    }
    parame.b(8);
    paramb.a(parame.c(), locala.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.s.c
 * JD-Core Version:    0.7.0.1
 */