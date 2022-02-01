package com.tencent.luggage.wxa.r;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e
  implements v.c
{
  private final int a;
  private final List<com.tencent.luggage.wxa.h.k> b;
  
  public e()
  {
    this(0);
  }
  
  public e(int paramInt)
  {
    this(paramInt, Collections.emptyList());
  }
  
  public e(int paramInt, List<com.tencent.luggage.wxa.h.k> paramList)
  {
    this.a = paramInt;
    Object localObject = paramList;
    if (!a(32))
    {
      localObject = paramList;
      if (paramList.isEmpty()) {
        localObject = Collections.singletonList(com.tencent.luggage.wxa.h.k.a(null, "application/cea-608", 0, null));
      }
    }
    this.b = ((List)localObject);
  }
  
  private s a(v.b paramb)
  {
    if (a(32)) {
      return new s(this.b);
    }
    com.tencent.luggage.wxa.ao.m localm = new com.tencent.luggage.wxa.ao.m(paramb.d);
    paramb = this.b;
    while (localm.b() > 0)
    {
      int i = localm.g();
      int k = localm.g();
      int m = localm.d();
      if (i == 134)
      {
        ArrayList localArrayList = new ArrayList();
        int n = localm.g();
        i = 0;
        for (;;)
        {
          paramb = localArrayList;
          if (i >= (n & 0x1F)) {
            break;
          }
          String str = localm.e(3);
          int i1 = localm.g();
          int j;
          if ((i1 & 0x80) != 0) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0)
          {
            j = i1 & 0x3F;
            paramb = "application/cea-708";
          }
          else
          {
            paramb = "application/cea-608";
            j = 1;
          }
          localArrayList.add(com.tencent.luggage.wxa.h.k.a(null, paramb, null, -1, 0, str, j, null));
          localm.d(2);
          i += 1;
        }
      }
      localm.c(m + k);
    }
    return new s(paramb);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt & this.a) != 0;
  }
  
  public SparseArray<v> a()
  {
    return new SparseArray();
  }
  
  public v a(int paramInt, v.b paramb)
  {
    if (paramInt != 2)
    {
      if ((paramInt != 3) && (paramInt != 4))
      {
        if (paramInt != 15)
        {
          if (paramInt != 21)
          {
            if (paramInt != 27)
            {
              if (paramInt != 36)
              {
                if (paramInt != 89)
                {
                  if (paramInt != 138)
                  {
                    if (paramInt != 129)
                    {
                      if (paramInt == 130) {
                        break label127;
                      }
                      if (paramInt != 134)
                      {
                        if (paramInt != 135) {
                          return null;
                        }
                      }
                      else
                      {
                        if (a(16)) {
                          return null;
                        }
                        return new r(new t());
                      }
                    }
                    return new o(new b(paramb.b));
                  }
                  label127:
                  return new o(new f(paramb.b));
                }
                return new o(new g(paramb.c));
              }
              return new o(new k(a(paramb)));
            }
            if (a(4)) {
              return null;
            }
            return new o(new j(a(paramb), a(1), a(8)));
          }
          return new o(new l());
        }
        if (a(2)) {
          return null;
        }
        return new o(new d(false, paramb.b));
      }
      return new o(new m(paramb.b));
    }
    return new o(new i());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.e
 * JD-Core Version:    0.7.0.1
 */