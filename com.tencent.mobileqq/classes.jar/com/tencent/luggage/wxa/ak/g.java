package com.tencent.luggage.wxa.ak;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ad.b;
import com.tencent.luggage.wxa.ao.m;
import java.util.ArrayList;
import java.util.List;

public final class g
  extends b
{
  private final f a = new f();
  private final m b = new m();
  private final e.a c = new e.a();
  private final a d = new a();
  private final List<d> e = new ArrayList();
  
  public g()
  {
    super("WebvttDecoder");
  }
  
  private static int a(m paramm)
  {
    int i = -1;
    int j = 0;
    while (i == -1)
    {
      j = paramm.d();
      String str = paramm.y();
      if (str == null) {
        i = 0;
      } else if ("STYLE".equals(str)) {
        i = 2;
      } else if ("NOTE".startsWith(str)) {
        i = 1;
      } else {
        i = 3;
      }
    }
    paramm.c(j);
    return i;
  }
  
  private static void b(m paramm)
  {
    while (!TextUtils.isEmpty(paramm.y())) {}
  }
  
  protected i b(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    this.b.a(paramArrayOfByte, paramInt);
    this.c.a();
    this.e.clear();
    h.a(this.b);
    while (!TextUtils.isEmpty(this.b.y())) {}
    paramArrayOfByte = new ArrayList();
    for (;;)
    {
      paramInt = a(this.b);
      if (paramInt == 0) {
        break;
      }
      if (paramInt == 1)
      {
        b(this.b);
      }
      else if (paramInt == 2)
      {
        if (paramArrayOfByte.isEmpty())
        {
          this.b.y();
          d locald = this.d.a(this.b);
          if (locald != null) {
            this.e.add(locald);
          }
        }
        else
        {
          throw new com.tencent.luggage.wxa.ad.f("A style block was found after the first cue.");
        }
      }
      else if ((paramInt == 3) && (this.a.a(this.b, this.c, this.e)))
      {
        paramArrayOfByte.add(this.c.b());
        this.c.a();
      }
    }
    return new i(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ak.g
 * JD-Core Version:    0.7.0.1
 */