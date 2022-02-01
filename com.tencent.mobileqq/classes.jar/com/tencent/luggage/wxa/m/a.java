package com.tencent.luggage.wxa.m;

import android.util.Pair;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.l.l;
import java.util.Collections;

final class a
  extends d
{
  private static final int[] b = { 5512, 11025, 22050, 44100 };
  private boolean c;
  private boolean d;
  private int e;
  
  public a(l paraml)
  {
    super(paraml);
  }
  
  protected void a(m paramm, long paramLong)
  {
    if (this.e == 2)
    {
      i = paramm.b();
      this.a.a(paramm, i);
      this.a.a(paramLong, 1, i, 0, null);
      return;
    }
    int i = paramm.g();
    if ((i == 0) && (!this.d))
    {
      byte[] arrayOfByte = new byte[paramm.b()];
      paramm.a(arrayOfByte, 0, arrayOfByte.length);
      paramm = com.tencent.luggage.wxa.ao.d.a(arrayOfByte);
      paramm = k.a(null, "audio/mp4a-latm", null, -1, -1, ((Integer)paramm.second).intValue(), ((Integer)paramm.first).intValue(), Collections.singletonList(arrayOfByte), null, 0, null);
      this.a.a(paramm);
      this.d = true;
      return;
    }
    if ((this.e != 10) || (i == 1))
    {
      i = paramm.b();
      this.a.a(paramm, i);
      this.a.a(paramLong, 1, i, 0, null);
    }
  }
  
  protected boolean a(m paramm)
  {
    if (!this.c)
    {
      int i = paramm.g();
      this.e = (i >> 4 & 0xF);
      int j = this.e;
      if (j == 2)
      {
        paramm = k.a(null, "audio/mpeg", null, -1, -1, 1, b[(i >> 2 & 0x3)], null, null, 0, null);
        this.a.a(paramm);
        this.d = true;
      }
      else if ((j != 7) && (j != 8))
      {
        if (j != 10)
        {
          paramm = new StringBuilder();
          paramm.append("Audio format not supported: ");
          paramm.append(this.e);
          throw new d.a(paramm.toString());
        }
      }
      else
      {
        if (this.e == 7) {
          paramm = "audio/g711-alaw";
        } else {
          paramm = "audio/g711-mlaw";
        }
        if ((i & 0x1) == 1) {
          i = 2;
        } else {
          i = 3;
        }
        paramm = k.a(null, paramm, null, -1, -1, 1, 8000, i, null, null, 0, null);
        this.a.a(paramm);
        this.d = true;
      }
      this.c = true;
      return true;
    }
    paramm.d(1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.m.a
 * JD-Core Version:    0.7.0.1
 */