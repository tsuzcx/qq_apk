package com.tencent.luggage.wxa.ak;

import com.tencent.luggage.wxa.ad.a;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class b
  extends com.tencent.luggage.wxa.ad.b
{
  private static final int a = x.f("payl");
  private static final int b = x.f("sttg");
  private static final int c = x.f("vttc");
  private final m d = new m();
  private final e.a e = new e.a();
  
  public b()
  {
    super("Mp4WebvttDecoder");
  }
  
  private static a a(m paramm, e.a parama, int paramInt)
  {
    parama.a();
    while (paramInt > 0) {
      if (paramInt >= 8)
      {
        int i = paramm.n();
        int j = paramm.n();
        i -= 8;
        String str = new String(paramm.a, paramm.d(), i);
        paramm.d(i);
        i = paramInt - 8 - i;
        if (j == b)
        {
          f.a(str, parama);
          paramInt = i;
        }
        else
        {
          paramInt = i;
          if (j == a)
          {
            f.a(null, str.trim(), parama, Collections.emptyList());
            paramInt = i;
          }
        }
      }
      else
      {
        throw new com.tencent.luggage.wxa.ad.f("Incomplete vtt cue box header found.");
      }
    }
    return parama.b();
  }
  
  protected c b(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    this.d.a(paramArrayOfByte, paramInt);
    paramArrayOfByte = new ArrayList();
    while (this.d.b() > 0) {
      if (this.d.b() >= 8)
      {
        paramInt = this.d.n();
        if (this.d.n() == c) {
          paramArrayOfByte.add(a(this.d, this.e, paramInt - 8));
        } else {
          this.d.d(paramInt - 8);
        }
      }
      else
      {
        throw new com.tencent.luggage.wxa.ad.f("Incomplete Mp4Webvtt Top Level box header found.");
      }
    }
    return new c(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ak.b
 * JD-Core Version:    0.7.0.1
 */