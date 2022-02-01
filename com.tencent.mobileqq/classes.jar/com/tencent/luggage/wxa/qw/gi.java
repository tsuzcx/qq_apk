package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.sw.b;
import java.util.LinkedList;

public class gi
  extends com.tencent.luggage.wxa.qu.a
{
  public int a;
  public hf b;
  public hf c;
  public hf d;
  public hf e;
  public hf f;
  public hf g;
  public hf h;
  public hf i;
  public hf j;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      if (this.c != null)
      {
        if (this.d != null)
        {
          if (this.e != null)
          {
            if (this.f != null)
            {
              if (this.g != null)
              {
                if (this.h != null)
                {
                  if (this.i != null)
                  {
                    paramVarArgs.b(1, this.a);
                    localObject1 = this.b;
                    if (localObject1 != null)
                    {
                      paramVarArgs.c(2, ((hf)localObject1).d());
                      this.b.a(paramVarArgs);
                    }
                    localObject1 = this.c;
                    if (localObject1 != null)
                    {
                      paramVarArgs.c(3, ((hf)localObject1).d());
                      this.c.a(paramVarArgs);
                    }
                    localObject1 = this.d;
                    if (localObject1 != null)
                    {
                      paramVarArgs.c(4, ((hf)localObject1).d());
                      this.d.a(paramVarArgs);
                    }
                    localObject1 = this.e;
                    if (localObject1 != null)
                    {
                      paramVarArgs.c(5, ((hf)localObject1).d());
                      this.e.a(paramVarArgs);
                    }
                    localObject1 = this.f;
                    if (localObject1 != null)
                    {
                      paramVarArgs.c(6, ((hf)localObject1).d());
                      this.f.a(paramVarArgs);
                    }
                    localObject1 = this.g;
                    if (localObject1 != null)
                    {
                      paramVarArgs.c(7, ((hf)localObject1).d());
                      this.g.a(paramVarArgs);
                    }
                    localObject1 = this.h;
                    if (localObject1 != null)
                    {
                      paramVarArgs.c(8, ((hf)localObject1).d());
                      this.h.a(paramVarArgs);
                    }
                    localObject1 = this.i;
                    if (localObject1 != null)
                    {
                      paramVarArgs.c(9, ((hf)localObject1).d());
                      this.i.a(paramVarArgs);
                    }
                    localObject1 = this.j;
                    if (localObject1 != null)
                    {
                      paramVarArgs.c(10, ((hf)localObject1).d());
                      this.j.a(paramVarArgs);
                    }
                    return 0;
                  }
                  throw new b("Not all required fields were included: phone");
                }
                throw new b("Not all required fields were included: name");
              }
              throw new b("Not all required fields were included: detail");
            }
            throw new b("Not all required fields were included: zipcode");
          }
          throw new b("Not all required fields were included: district");
        }
        throw new b("Not all required fields were included: city");
      }
      throw new b("Not all required fields were included: province");
    }
    int k;
    if (paramInt == 1)
    {
      k = com.tencent.luggage.wxa.sw.a.b(1, this.a) + 0;
      paramVarArgs = this.b;
      paramInt = k;
      if (paramVarArgs != null) {
        paramInt = k + com.tencent.luggage.wxa.sw.a.c(2, paramVarArgs.d());
      }
      paramVarArgs = this.c;
      k = paramInt;
      if (paramVarArgs != null) {
        k = paramInt + com.tencent.luggage.wxa.sw.a.c(3, paramVarArgs.d());
      }
      paramVarArgs = this.d;
      paramInt = k;
      if (paramVarArgs != null) {
        paramInt = k + com.tencent.luggage.wxa.sw.a.c(4, paramVarArgs.d());
      }
      paramVarArgs = this.e;
      k = paramInt;
      if (paramVarArgs != null) {
        k = paramInt + com.tencent.luggage.wxa.sw.a.c(5, paramVarArgs.d());
      }
      paramVarArgs = this.f;
      paramInt = k;
      if (paramVarArgs != null) {
        paramInt = k + com.tencent.luggage.wxa.sw.a.c(6, paramVarArgs.d());
      }
      paramVarArgs = this.g;
      k = paramInt;
      if (paramVarArgs != null) {
        k = paramInt + com.tencent.luggage.wxa.sw.a.c(7, paramVarArgs.d());
      }
      paramVarArgs = this.h;
      paramInt = k;
      if (paramVarArgs != null) {
        paramInt = k + com.tencent.luggage.wxa.sw.a.c(8, paramVarArgs.d());
      }
      paramVarArgs = this.i;
      k = paramInt;
      if (paramVarArgs != null) {
        k = paramInt + com.tencent.luggage.wxa.sw.a.c(9, paramVarArgs.d());
      }
      paramVarArgs = this.j;
      paramInt = k;
      if (paramVarArgs != null) {
        paramInt = k + com.tencent.luggage.wxa.sw.a.c(10, paramVarArgs.d());
      }
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new com.tencent.luggage.wxa.sx.a((byte[])paramVarArgs[0], p);
      for (paramInt = com.tencent.luggage.wxa.qu.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.luggage.wxa.qu.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.b();
        }
      }
      if (this.c != null)
      {
        if (this.d != null)
        {
          if (this.e != null)
          {
            if (this.f != null)
            {
              if (this.g != null)
              {
                if (this.h != null)
                {
                  if (this.i != null) {
                    return 0;
                  }
                  throw new b("Not all required fields were included: phone");
                }
                throw new b("Not all required fields were included: name");
              }
              throw new b("Not all required fields were included: detail");
            }
            throw new b("Not all required fields were included: zipcode");
          }
          throw new b("Not all required fields were included: district");
        }
        throw new b("Not all required fields were included: city");
      }
      throw new b("Not all required fields were included: province");
    }
    if (paramInt == 3)
    {
      Object localObject2 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      localObject1 = (gi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 10: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        k = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < k)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new hf();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((hf)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((gi)localObject1).j = ((hf)localObject2);
          paramInt += 1;
        }
        return 0;
      case 9: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        k = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < k)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new hf();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((hf)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((gi)localObject1).i = ((hf)localObject2);
          paramInt += 1;
        }
        return 0;
      case 8: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        k = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < k)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new hf();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((hf)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((gi)localObject1).h = ((hf)localObject2);
          paramInt += 1;
        }
        return 0;
      case 7: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        k = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < k)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new hf();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((hf)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((gi)localObject1).g = ((hf)localObject2);
          paramInt += 1;
        }
        return 0;
      case 6: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        k = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < k)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new hf();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((hf)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((gi)localObject1).f = ((hf)localObject2);
          paramInt += 1;
        }
        return 0;
      case 5: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        k = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < k)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new hf();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((hf)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((gi)localObject1).e = ((hf)localObject2);
          paramInt += 1;
        }
        return 0;
      case 4: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        k = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < k)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new hf();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((hf)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((gi)localObject1).d = ((hf)localObject2);
          paramInt += 1;
        }
        return 0;
      case 3: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        k = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < k)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new hf();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((hf)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((gi)localObject1).c = ((hf)localObject2);
          paramInt += 1;
        }
        return 0;
      case 2: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        k = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < k)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new hf();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((hf)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((gi)localObject1).b = ((hf)localObject2);
          paramInt += 1;
        }
        return 0;
      }
      ((gi)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.gi
 * JD-Core Version:    0.7.0.1
 */