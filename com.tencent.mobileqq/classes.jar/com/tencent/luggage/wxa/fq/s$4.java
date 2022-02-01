package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.ht.a;
import com.tencent.luggage.wxa.qz.o;

final class s$4
  implements a
{
  public int a()
  {
    int i = o.c();
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 6) {
              return 6;
            }
          }
          else {
            return 5;
          }
        }
        else {
          return 4;
        }
      }
      else {
        return 3;
      }
    }
    return 2;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (paramInt < a()) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 7: 
      o.b(paramString1, paramString2, paramVarArgs);
      return;
    case 6: 
      o.b(paramString1, paramString2, paramVarArgs);
      return;
    case 5: 
      o.c(paramString1, paramString2, paramVarArgs);
      return;
    case 4: 
      o.d(paramString1, paramString2, paramVarArgs);
      return;
    case 3: 
      o.e(paramString1, paramString2, paramVarArgs);
      return;
    }
    o.f(paramString1, paramString2, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.s.4
 * JD-Core Version:    0.7.0.1
 */