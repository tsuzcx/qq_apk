package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class et
  extends gu
{
  public dy a;
  public com.tencent.luggage.wxa.qu.b b;
  public hn c;
  public String d;
  public String e;
  public az f;
  public boolean g;
  public String h;
  public String i;
  public String j;
  public jc k;
  public f l;
  
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
          paramVarArgs.a(3, (com.tencent.luggage.wxa.qu.b)localObject1);
        }
        localObject1 = this.c;
        if (localObject1 != null)
        {
          paramVarArgs.c(4, ((hn)localObject1).d());
          this.c.a(paramVarArgs);
        }
        localObject1 = this.d;
        if (localObject1 != null) {
          paramVarArgs.a(5, (String)localObject1);
        }
        localObject1 = this.e;
        if (localObject1 != null) {
          paramVarArgs.a(6, (String)localObject1);
        }
        localObject1 = this.f;
        if (localObject1 != null)
        {
          paramVarArgs.c(7, ((az)localObject1).d());
          this.f.a(paramVarArgs);
        }
        paramVarArgs.a(8, this.g);
        localObject1 = this.h;
        if (localObject1 != null) {
          paramVarArgs.a(9, (String)localObject1);
        }
        localObject1 = this.i;
        if (localObject1 != null) {
          paramVarArgs.a(10, (String)localObject1);
        }
        localObject1 = this.j;
        if (localObject1 != null) {
          paramVarArgs.a(11, (String)localObject1);
        }
        localObject1 = this.k;
        if (localObject1 != null)
        {
          paramVarArgs.c(12, ((jc)localObject1).d());
          this.k.a(paramVarArgs);
        }
        localObject1 = this.l;
        if (localObject1 != null)
        {
          paramVarArgs.c(13, ((f)localObject1).d());
          this.l.a(paramVarArgs);
        }
        return 0;
      }
      throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: BaseResponse");
    }
    int m;
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
      paramVarArgs = this.c;
      paramInt = m;
      if (paramVarArgs != null) {
        paramInt = m + com.tencent.luggage.wxa.sw.a.c(4, paramVarArgs.d());
      }
      paramVarArgs = this.d;
      m = paramInt;
      if (paramVarArgs != null) {
        m = paramInt + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      paramVarArgs = this.e;
      paramInt = m;
      if (paramVarArgs != null) {
        paramInt = m + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
      }
      paramVarArgs = this.f;
      m = paramInt;
      if (paramVarArgs != null) {
        m = paramInt + com.tencent.luggage.wxa.sw.a.c(7, paramVarArgs.d());
      }
      m += com.tencent.luggage.wxa.sw.a.a(8, this.g);
      paramVarArgs = this.h;
      paramInt = m;
      if (paramVarArgs != null) {
        paramInt = m + com.tencent.luggage.wxa.sw.a.a(9, paramVarArgs);
      }
      paramVarArgs = this.i;
      m = paramInt;
      if (paramVarArgs != null) {
        m = paramInt + com.tencent.luggage.wxa.sw.a.a(10, paramVarArgs);
      }
      paramVarArgs = this.j;
      paramInt = m;
      if (paramVarArgs != null) {
        paramInt = m + com.tencent.luggage.wxa.sw.a.a(11, paramVarArgs);
      }
      paramVarArgs = this.k;
      m = paramInt;
      if (paramVarArgs != null) {
        m = paramInt + com.tencent.luggage.wxa.sw.a.c(12, paramVarArgs.d());
      }
      paramVarArgs = this.l;
      paramInt = m;
      if (paramVarArgs != null) {
        paramInt = m + com.tencent.luggage.wxa.sw.a.c(13, paramVarArgs.d());
      }
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new com.tencent.luggage.wxa.sx.a((byte[])paramVarArgs[0], p);
      for (paramInt = gu.a(paramVarArgs); paramInt > 0; paramInt = gu.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.b();
        }
      }
      if (this.z != null) {
        return 0;
      }
      throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: BaseResponse");
    }
    if (paramInt == 3)
    {
      Object localObject2 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      localObject1 = (et)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 13: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        m = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < m)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new f();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((f)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((et)localObject1).l = ((f)localObject2);
          paramInt += 1;
        }
        return 0;
      case 12: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        m = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < m)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new jc();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((jc)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((et)localObject1).k = ((jc)localObject2);
          paramInt += 1;
        }
        return 0;
      case 11: 
        ((et)localObject1).j = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 10: 
        ((et)localObject1).i = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 9: 
        ((et)localObject1).h = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 8: 
        ((et)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
        return 0;
      case 7: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        m = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < m)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new az();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((az)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((et)localObject1).f = ((az)localObject2);
          paramInt += 1;
        }
        return 0;
      case 6: 
        ((et)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 5: 
        ((et)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
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
          ((et)localObject1).c = ((hn)localObject2);
          paramInt += 1;
        }
        return 0;
      case 3: 
        ((et)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).h(paramInt);
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
          ((et)localObject1).a = ((dy)localObject2);
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
        ((et)localObject1).z = ((aa)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.et
 * JD-Core Version:    0.7.0.1
 */