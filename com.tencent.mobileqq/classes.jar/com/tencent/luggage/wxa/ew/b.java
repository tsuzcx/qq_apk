package com.tencent.luggage.wxa.ew;

import java.util.LinkedList;

public class b
  extends com.tencent.luggage.wxa.qu.a
{
  public String a;
  public boolean b;
  public String c;
  public String d;
  public int e;
  public LinkedList<a> f = new LinkedList();
  public boolean g;
  public boolean h;
  public int i = 0;
  public long j;
  public int k = 0;
  public String l;
  public boolean m;
  public int n;
  public String o;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      localObject1 = this.a;
      if (localObject1 != null)
      {
        if (localObject1 != null) {
          paramVarArgs.a(1, (String)localObject1);
        }
        paramVarArgs.a(2, this.b);
        localObject1 = this.c;
        if (localObject1 != null) {
          paramVarArgs.a(3, (String)localObject1);
        }
        localObject1 = this.d;
        if (localObject1 != null) {
          paramVarArgs.a(4, (String)localObject1);
        }
        paramVarArgs.b(5, this.e);
        paramVarArgs.a(6, 8, this.f);
        paramVarArgs.a(7, this.g);
        paramVarArgs.a(8, this.h);
        paramVarArgs.b(9, this.i);
        paramVarArgs.a(10, this.j);
        paramVarArgs.b(11, this.k);
        localObject1 = this.l;
        if (localObject1 != null) {
          paramVarArgs.a(12, (String)localObject1);
        }
        paramVarArgs.a(13, this.m);
        paramVarArgs.b(14, this.n);
        localObject1 = this.o;
        if (localObject1 != null) {
          paramVarArgs.a(15, (String)localObject1);
        }
        return 0;
      }
      throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: appId");
    }
    if (paramInt == 1)
    {
      paramVarArgs = this.a;
      if (paramVarArgs != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.a(1, paramVarArgs);
      } else {
        paramInt = 0;
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(2, this.b);
      paramVarArgs = this.c;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(3, paramVarArgs);
      }
      paramVarArgs = this.d;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(4, paramVarArgs);
      }
      i1 = i1 + com.tencent.luggage.wxa.sw.a.b(5, this.e) + com.tencent.luggage.wxa.sw.a.a(6, 8, this.f) + com.tencent.luggage.wxa.sw.a.a(7, this.g) + com.tencent.luggage.wxa.sw.a.a(8, this.h) + com.tencent.luggage.wxa.sw.a.b(9, this.i) + com.tencent.luggage.wxa.sw.a.a(10, this.j) + com.tencent.luggage.wxa.sw.a.b(11, this.k);
      paramVarArgs = this.l;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(12, paramVarArgs);
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(13, this.m) + com.tencent.luggage.wxa.sw.a.b(14, this.n);
      paramVarArgs = this.o;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(15, paramVarArgs);
      }
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.f.clear();
      paramVarArgs = new com.tencent.luggage.wxa.sx.a(paramVarArgs, p);
      for (paramInt = com.tencent.luggage.wxa.qu.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.luggage.wxa.qu.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.b();
        }
      }
      if (this.a != null) {
        return 0;
      }
      throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: appId");
    }
    int i1 = -1;
    if (paramInt == 3)
    {
      Object localObject2 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      localObject1 = (b)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 15: 
        ((b)localObject1).o = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 14: 
        ((b)localObject1).n = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 13: 
        ((b)localObject1).m = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
        return 0;
      case 12: 
        ((b)localObject1).l = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 11: 
        ((b)localObject1).k = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 10: 
        ((b)localObject1).j = ((com.tencent.luggage.wxa.sx.a)localObject2).g(paramInt);
        return 0;
      case 9: 
        ((b)localObject1).i = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 8: 
        ((b)localObject1).h = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
        return 0;
      case 7: 
        ((b)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
        return 0;
      case 6: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          Object localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new a();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (boolean bool = true; bool; bool = ((a)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((b)localObject1).f.add(localObject2);
          paramInt += 1;
        }
        return 0;
      case 5: 
        ((b)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 4: 
        ((b)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 3: 
        ((b)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 2: 
        ((b)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
        return 0;
      }
      i1 = 0;
      ((b)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
    }
    return i1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ew.b
 * JD-Core Version:    0.7.0.1
 */