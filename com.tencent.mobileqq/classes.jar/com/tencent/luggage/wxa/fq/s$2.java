package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ry.b.a;

final class s$2
  implements b.a
{
  private final int[] a = { 6, 6, 0, 1, 2, 3, 4, 5 };
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (!a(paramString1, paramInt)) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 7: 
      o.a(paramString1, paramString2);
      return;
    case 6: 
      o.b(paramString1, paramString2);
      return;
    case 5: 
      o.c(paramString1, paramString2);
      return;
    case 4: 
      o.d(paramString1, paramString2);
      return;
    case 3: 
      o.e(paramString1, paramString2);
      return;
    }
    o.f(paramString1, paramString2);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return (paramInt >= 2) && (paramInt <= 7) && (this.a[paramInt] >= o.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.s.2
 * JD-Core Version:    0.7.0.1
 */