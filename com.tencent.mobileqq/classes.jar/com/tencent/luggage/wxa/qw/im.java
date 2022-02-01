package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class im
  extends gu
{
  public LinkedList<ik> a = new LinkedList();
  public ip b;
  public String c;
  public String d;
  public int e;
  public int f;
  public int g;
  public int h;
  public boolean i;
  public String j;
  public int k;
  public int l;
  public com.tencent.luggage.wxa.qu.b m;
  public int n;
  public String o;
  public boolean q;
  public String r;
  public String s;
  public int t;
  public in u;
  
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
        paramVarArgs.a(2, 8, this.a);
        localObject1 = this.b;
        if (localObject1 != null)
        {
          paramVarArgs.c(3, ((ip)localObject1).d());
          this.b.a(paramVarArgs);
        }
        localObject1 = this.c;
        if (localObject1 != null) {
          paramVarArgs.a(4, (String)localObject1);
        }
        localObject1 = this.d;
        if (localObject1 != null) {
          paramVarArgs.a(5, (String)localObject1);
        }
        paramVarArgs.b(6, this.e);
        paramVarArgs.b(9, this.f);
        paramVarArgs.b(10, this.g);
        paramVarArgs.b(11, this.h);
        paramVarArgs.a(12, this.i);
        localObject1 = this.j;
        if (localObject1 != null) {
          paramVarArgs.a(13, (String)localObject1);
        }
        paramVarArgs.b(14, this.k);
        paramVarArgs.b(15, this.l);
        localObject1 = this.m;
        if (localObject1 != null) {
          paramVarArgs.a(16, (com.tencent.luggage.wxa.qu.b)localObject1);
        }
        paramVarArgs.b(17, this.n);
        localObject1 = this.o;
        if (localObject1 != null) {
          paramVarArgs.a(18, (String)localObject1);
        }
        paramVarArgs.a(19, this.q);
        localObject1 = this.r;
        if (localObject1 != null) {
          paramVarArgs.a(20, (String)localObject1);
        }
        localObject1 = this.s;
        if (localObject1 != null) {
          paramVarArgs.a(21, (String)localObject1);
        }
        paramVarArgs.b(22, this.t);
        localObject1 = this.u;
        if (localObject1 != null)
        {
          paramVarArgs.c(23, ((in)localObject1).d());
          this.u.a(paramVarArgs);
        }
        return 0;
      }
      throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: BaseResponse");
    }
    int i1;
    if (paramInt == 1)
    {
      if (this.z != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.z.d());
      } else {
        paramInt = 0;
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(2, 8, this.a);
      paramVarArgs = this.b;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.c(3, paramVarArgs.d());
      }
      paramVarArgs = this.c;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(4, paramVarArgs);
      }
      paramVarArgs = this.d;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.b(6, this.e) + com.tencent.luggage.wxa.sw.a.b(9, this.f) + com.tencent.luggage.wxa.sw.a.b(10, this.g) + com.tencent.luggage.wxa.sw.a.b(11, this.h) + com.tencent.luggage.wxa.sw.a.a(12, this.i);
      paramVarArgs = this.j;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(13, paramVarArgs);
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.b(14, this.k) + com.tencent.luggage.wxa.sw.a.b(15, this.l);
      paramVarArgs = this.m;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(16, paramVarArgs);
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.b(17, this.n);
      paramVarArgs = this.o;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(18, paramVarArgs);
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(19, this.q);
      paramVarArgs = this.r;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(20, paramVarArgs);
      }
      paramVarArgs = this.s;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(21, paramVarArgs);
      }
      i1 += com.tencent.luggage.wxa.sw.a.b(22, this.t);
      paramVarArgs = this.u;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.c(23, paramVarArgs.d());
      }
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.a.clear();
      paramVarArgs = new com.tencent.luggage.wxa.sx.a(paramVarArgs, p);
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
      localObject1 = (im)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      switch (paramInt)
      {
      case 7: 
      case 8: 
      default: 
        return -1;
      case 23: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new in();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((in)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((im)localObject1).u = ((in)localObject2);
          paramInt += 1;
        }
        return 0;
      case 22: 
        ((im)localObject1).t = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 21: 
        ((im)localObject1).s = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 20: 
        ((im)localObject1).r = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 19: 
        ((im)localObject1).q = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
        return 0;
      case 18: 
        ((im)localObject1).o = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 17: 
        ((im)localObject1).n = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 16: 
        ((im)localObject1).m = ((com.tencent.luggage.wxa.sx.a)localObject2).h(paramInt);
        return 0;
      case 15: 
        ((im)localObject1).l = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 14: 
        ((im)localObject1).k = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 13: 
        ((im)localObject1).j = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 12: 
        ((im)localObject1).i = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
        return 0;
      case 11: 
        ((im)localObject1).h = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 10: 
        ((im)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 9: 
        ((im)localObject1).f = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 6: 
        ((im)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 5: 
        ((im)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 4: 
        ((im)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 3: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ip();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((ip)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((im)localObject1).b = ((ip)localObject2);
          paramInt += 1;
        }
        return 0;
      case 2: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ik();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((ik)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((im)localObject1).a.add(localObject2);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
      i1 = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i1)
      {
        localObject3 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new aa();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (bool = true; bool; bool = ((aa)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((im)localObject1).z = ((aa)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.im
 * JD-Core Version:    0.7.0.1
 */