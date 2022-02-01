package com.tencent.luggage.wxa.a;

import java.util.Iterator;
import java.util.List;

class b$l
  implements b.f
{
  private boolean a;
  private String b;
  
  public b$l(boolean paramBoolean, String paramString)
  {
    this.a = paramBoolean;
    this.b = paramString;
  }
  
  public boolean a(b.p paramp, h.al paramal)
  {
    if ((this.a) && (this.b == null)) {
      paramp = paramal.a();
    } else {
      paramp = this.b;
    }
    Object localObject = paramal.v;
    boolean bool = false;
    if (localObject != null)
    {
      paramal = paramal.v.b().iterator();
      int i = 0;
      for (;;)
      {
        j = i;
        if (!paramal.hasNext()) {
          break;
        }
        localObject = (h.al)paramal.next();
        if ((paramp == null) || (((h.al)localObject).a().equals(paramp))) {
          i += 1;
        }
      }
    }
    int j = 1;
    if (j == 1) {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    if (this.a) {
      return String.format("only-of-type <%s>", new Object[] { this.b });
    }
    return String.format("only-child", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.b.l
 * JD-Core Version:    0.7.0.1
 */