package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.sw.b;
import java.util.LinkedList;

public class er
  extends gu
{
  public dy a;
  public String b;
  public LinkedList<hn> c = new LinkedList();
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public int i;
  public String j;
  public String k;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      if (this.z != null)
      {
        if (this.z != null)
        {
          paramVarArgs.c(1, this.z.d());
          this.z.a(paramVarArgs);
        }
        localObject1 = this.a;
        if (localObject1 != null)
        {
          paramVarArgs.c(2, ((dy)localObject1).d());
          this.a.a(paramVarArgs);
        }
        localObject1 = this.b;
        if (localObject1 != null) {
          paramVarArgs.a(3, (String)localObject1);
        }
        paramVarArgs.a(4, 8, this.c);
        localObject1 = this.d;
        if (localObject1 != null) {
          paramVarArgs.a(5, (String)localObject1);
        }
        localObject1 = this.e;
        if (localObject1 != null) {
          paramVarArgs.a(6, (String)localObject1);
        }
        localObject1 = this.f;
        if (localObject1 != null) {
          paramVarArgs.a(7, (String)localObject1);
        }
        localObject1 = this.g;
        if (localObject1 != null) {
          paramVarArgs.a(8, (String)localObject1);
        }
        localObject1 = this.h;
        if (localObject1 != null) {
          paramVarArgs.a(9, (String)localObject1);
        }
        paramVarArgs.b(10, this.i);
        localObject1 = this.j;
        if (localObject1 != null) {
          paramVarArgs.a(11, (String)localObject1);
        }
        localObject1 = this.k;
        if (localObject1 != null) {
          paramVarArgs.a(12, (String)localObject1);
        }
        return 0;
      }
      throw new b("Not all required fields were included: BaseResponse");
    }
    if (paramInt == 1)
    {
      if (this.z != null) {
        m = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.z.d());
      } else {
        m = 0;
      }
      paramVarArgs = this.a;
      paramInt = m;
      if (paramVarArgs != null) {
        paramInt = m + com.tencent.luggage.wxa.sw.a.c(2, paramVarArgs.d());
      }
      paramVarArgs = this.b;
      m = paramInt;
      if (paramVarArgs != null) {
        m = paramInt + com.tencent.luggage.wxa.sw.a.a(3, paramVarArgs);
      }
      m += com.tencent.luggage.wxa.sw.a.a(4, 8, this.c);
      paramVarArgs = this.d;
      paramInt = m;
      if (paramVarArgs != null) {
        paramInt = m + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      paramVarArgs = this.e;
      m = paramInt;
      if (paramVarArgs != null) {
        m = paramInt + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
      }
      paramVarArgs = this.f;
      paramInt = m;
      if (paramVarArgs != null) {
        paramInt = m + com.tencent.luggage.wxa.sw.a.a(7, paramVarArgs);
      }
      paramVarArgs = this.g;
      m = paramInt;
      if (paramVarArgs != null) {
        m = paramInt + com.tencent.luggage.wxa.sw.a.a(8, paramVarArgs);
      }
      paramVarArgs = this.h;
      paramInt = m;
      if (paramVarArgs != null) {
        paramInt = m + com.tencent.luggage.wxa.sw.a.a(9, paramVarArgs);
      }
      m = paramInt + com.tencent.luggage.wxa.sw.a.b(10, this.i);
      paramVarArgs = this.j;
      paramInt = m;
      if (paramVarArgs != null) {
        paramInt = m + com.tencent.luggage.wxa.sw.a.a(11, paramVarArgs);
      }
      paramVarArgs = this.k;
      m = paramInt;
      if (paramVarArgs != null) {
        m = paramInt + com.tencent.luggage.wxa.sw.a.a(12, paramVarArgs);
      }
      return m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.c.clear();
      paramVarArgs = new com.tencent.luggage.wxa.sx.a(paramVarArgs, p);
      for (paramInt = gu.a(paramVarArgs); paramInt > 0; paramInt = gu.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.b();
        }
      }
      if (this.z != null) {
        return 0;
      }
      throw new b("Not all required fields were included: BaseResponse");
    }
    int m = -1;
    if (paramInt == 3)
    {
      Object localObject2 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      localObject1 = (er)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 12: 
        ((er)localObject1).k = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 11: 
        ((er)localObject1).j = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 10: 
        ((er)localObject1).i = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 9: 
        ((er)localObject1).h = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 8: 
        ((er)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 7: 
        ((er)localObject1).f = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 6: 
        ((er)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 5: 
        ((er)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 4: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        m = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < m)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new hn();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((hn)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((er)localObject1).c.add(localObject2);
          paramInt += 1;
        }
        return 0;
      case 3: 
        ((er)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 2: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        m = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < m)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dy();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((dy)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((er)localObject1).a = ((dy)localObject2);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
      m = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < m)
      {
        localObject3 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new aa();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (bool = true; bool; bool = ((aa)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((er)localObject1).z = ((aa)localObject2);
        paramInt += 1;
      }
      m = 0;
    }
    return m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.er
 * JD-Core Version:    0.7.0.1
 */