package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class cu
  extends gt
{
  public int a;
  public String b;
  public int c;
  public String d;
  public int e;
  public int f;
  public String g;
  public boolean h = false;
  public fx i;
  public String j;
  public LinkedList<fl> k = new LinkedList();
  public int l;
  public String m;
  public String n;
  public boolean o;
  public boolean q;
  public int r;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      if (this.B != null)
      {
        paramVarArgs.c(1, this.B.d());
        this.B.a(paramVarArgs);
      }
      paramVarArgs.b(2, this.a);
      localObject1 = this.b;
      if (localObject1 != null) {
        paramVarArgs.a(3, (String)localObject1);
      }
      paramVarArgs.b(4, this.c);
      localObject1 = this.d;
      if (localObject1 != null) {
        paramVarArgs.a(5, (String)localObject1);
      }
      paramVarArgs.b(6, this.e);
      paramVarArgs.b(7, this.f);
      localObject1 = this.g;
      if (localObject1 != null) {
        paramVarArgs.a(8, (String)localObject1);
      }
      paramVarArgs.a(9, this.h);
      localObject1 = this.i;
      if (localObject1 != null)
      {
        paramVarArgs.c(10, ((fx)localObject1).d());
        this.i.a(paramVarArgs);
      }
      localObject1 = this.j;
      if (localObject1 != null) {
        paramVarArgs.a(11, (String)localObject1);
      }
      paramVarArgs.a(12, 8, this.k);
      paramVarArgs.b(13, this.l);
      localObject1 = this.m;
      if (localObject1 != null) {
        paramVarArgs.a(14, (String)localObject1);
      }
      localObject1 = this.n;
      if (localObject1 != null) {
        paramVarArgs.a(15, (String)localObject1);
      }
      paramVarArgs.a(16, this.o);
      paramVarArgs.a(17, this.q);
      paramVarArgs.b(18, this.r);
      return 0;
    }
    int i1;
    if (paramInt == 1)
    {
      if (this.B != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.B.d());
      } else {
        paramInt = 0;
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.b(2, this.a);
      paramVarArgs = this.b;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(3, paramVarArgs);
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.b(4, this.c);
      paramVarArgs = this.d;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.b(6, this.e) + com.tencent.luggage.wxa.sw.a.b(7, this.f);
      paramVarArgs = this.g;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(8, paramVarArgs);
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(9, this.h);
      paramVarArgs = this.i;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.c(10, paramVarArgs.d());
      }
      paramVarArgs = this.j;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(11, paramVarArgs);
      }
      i1 = i1 + com.tencent.luggage.wxa.sw.a.a(12, 8, this.k) + com.tencent.luggage.wxa.sw.a.b(13, this.l);
      paramVarArgs = this.m;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(14, paramVarArgs);
      }
      paramVarArgs = this.n;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(15, paramVarArgs);
      }
      return i1 + com.tencent.luggage.wxa.sw.a.a(16, this.o) + com.tencent.luggage.wxa.sw.a.a(17, this.q) + com.tencent.luggage.wxa.sw.a.b(18, this.r);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.k.clear();
      paramVarArgs = new com.tencent.luggage.wxa.sx.a(paramVarArgs, p);
      for (paramInt = gt.a(paramVarArgs); paramInt > 0; paramInt = gt.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.b();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject2 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      localObject1 = (cu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 18: 
        ((cu)localObject1).r = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 17: 
        ((cu)localObject1).q = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
        return 0;
      case 16: 
        ((cu)localObject1).o = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
        return 0;
      case 15: 
        ((cu)localObject1).n = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 14: 
        ((cu)localObject1).m = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 13: 
        ((cu)localObject1).l = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 12: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fl();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((fl)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((cu)localObject1).k.add(localObject2);
          paramInt += 1;
        }
        return 0;
      case 11: 
        ((cu)localObject1).j = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 10: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fx();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((fx)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((cu)localObject1).i = ((fx)localObject2);
          paramInt += 1;
        }
        return 0;
      case 9: 
        ((cu)localObject1).h = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
        return 0;
      case 8: 
        ((cu)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 7: 
        ((cu)localObject1).f = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 6: 
        ((cu)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 5: 
        ((cu)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 4: 
        ((cu)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 3: 
        ((cu)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 2: 
        ((cu)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
      i1 = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i1)
      {
        localObject3 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new z();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (bool = true; bool; bool = ((z)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((cu)localObject1).B = ((z)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.cu
 * JD-Core Version:    0.7.0.1
 */