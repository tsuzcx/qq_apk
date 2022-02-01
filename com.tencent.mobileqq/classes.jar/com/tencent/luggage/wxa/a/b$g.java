package com.tencent.luggage.wxa.a;

import java.util.Iterator;
import java.util.List;

class b$g
  implements b.f
{
  private int a;
  private int b;
  private boolean c;
  private boolean d;
  private String e;
  
  b$g(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
    this.e = paramString;
  }
  
  public boolean a(b.p paramp, h.al paramal)
  {
    if ((this.d) && (this.e == null)) {
      paramp = paramal.a();
    } else {
      paramp = this.e;
    }
    Object localObject = paramal.v;
    boolean bool2 = false;
    boolean bool1 = false;
    int i;
    if (localObject != null)
    {
      localObject = paramal.v.b().iterator();
      j = 0;
      i = 0;
      for (;;)
      {
        m = j;
        k = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        h.al localal = (h.al)((Iterator)localObject).next();
        k = j;
        if (localal == paramal) {
          k = i;
        }
        if (paramp != null)
        {
          j = k;
          if (!localal.a().equals(paramp)) {}
        }
        else
        {
          i += 1;
          j = k;
        }
      }
    }
    int m = 0;
    int k = 1;
    if (this.c) {
      i = m + 1;
    } else {
      i = k - m;
    }
    int j = this.a;
    if (j == 0)
    {
      if (i == this.b) {
        bool1 = true;
      }
      return bool1;
    }
    k = this.b;
    bool1 = bool2;
    if ((i - k) % j == 0) {
      if (Integer.signum(i - k) != 0)
      {
        bool1 = bool2;
        if (Integer.signum(i - this.b) != Integer.signum(this.a)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    String str;
    if (this.c) {
      str = "";
    } else {
      str = "last-";
    }
    if (this.d) {
      return String.format("nth-%schild(%dn%+d of type <%s>)", new Object[] { str, Integer.valueOf(this.a), Integer.valueOf(this.b), this.e });
    }
    return String.format("nth-%schild(%dn%+d)", new Object[] { str, Integer.valueOf(this.a), Integer.valueOf(this.b) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.b.g
 * JD-Core Version:    0.7.0.1
 */