package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class fa
  extends gt
{
  public String a;
  public lc b;
  public int c;
  public mu d;
  public ly e;
  public np f;
  public mp g;
  public mv h;
  public int i;
  public String j;
  public String k;
  public boolean l;
  public boolean m;
  public mw n;
  
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
      localObject1 = this.a;
      if (localObject1 != null) {
        paramVarArgs.a(2, (String)localObject1);
      }
      localObject1 = this.b;
      if (localObject1 != null)
      {
        paramVarArgs.c(3, ((lc)localObject1).d());
        this.b.a(paramVarArgs);
      }
      paramVarArgs.b(4, this.c);
      localObject1 = this.d;
      if (localObject1 != null)
      {
        paramVarArgs.c(5, ((mu)localObject1).d());
        this.d.a(paramVarArgs);
      }
      localObject1 = this.e;
      if (localObject1 != null)
      {
        paramVarArgs.c(6, ((ly)localObject1).d());
        this.e.a(paramVarArgs);
      }
      localObject1 = this.f;
      if (localObject1 != null)
      {
        paramVarArgs.c(7, ((np)localObject1).d());
        this.f.a(paramVarArgs);
      }
      localObject1 = this.g;
      if (localObject1 != null)
      {
        paramVarArgs.c(8, ((mp)localObject1).d());
        this.g.a(paramVarArgs);
      }
      localObject1 = this.h;
      if (localObject1 != null)
      {
        paramVarArgs.c(9, ((mv)localObject1).d());
        this.h.a(paramVarArgs);
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
      paramVarArgs.a(13, this.l);
      paramVarArgs.a(14, this.m);
      localObject1 = this.n;
      if (localObject1 != null)
      {
        paramVarArgs.c(15, ((mw)localObject1).d());
        this.n.a(paramVarArgs);
      }
      return 0;
    }
    int i1;
    if (paramInt == 1)
    {
      if (this.B != null) {
        i1 = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.B.d());
      } else {
        i1 = 0;
      }
      paramVarArgs = this.a;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(2, paramVarArgs);
      }
      paramVarArgs = this.b;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.c(3, paramVarArgs.d());
      }
      i1 += com.tencent.luggage.wxa.sw.a.b(4, this.c);
      paramVarArgs = this.d;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.c(5, paramVarArgs.d());
      }
      paramVarArgs = this.e;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.c(6, paramVarArgs.d());
      }
      paramVarArgs = this.f;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.c(7, paramVarArgs.d());
      }
      paramVarArgs = this.g;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.c(8, paramVarArgs.d());
      }
      paramVarArgs = this.h;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.c(9, paramVarArgs.d());
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.b(10, this.i);
      paramVarArgs = this.j;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(11, paramVarArgs);
      }
      paramVarArgs = this.k;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(12, paramVarArgs);
      }
      i1 = i1 + com.tencent.luggage.wxa.sw.a.a(13, this.l) + com.tencent.luggage.wxa.sw.a.a(14, this.m);
      paramVarArgs = this.n;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.c(15, paramVarArgs.d());
      }
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new com.tencent.luggage.wxa.sx.a((byte[])paramVarArgs[0], p);
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
      localObject1 = (fa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 15: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new mw();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((mw)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((fa)localObject1).n = ((mw)localObject2);
          paramInt += 1;
        }
        return 0;
      case 14: 
        ((fa)localObject1).m = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
        return 0;
      case 13: 
        ((fa)localObject1).l = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
        return 0;
      case 12: 
        ((fa)localObject1).k = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 11: 
        ((fa)localObject1).j = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 10: 
        ((fa)localObject1).i = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 9: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new mv();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((mv)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((fa)localObject1).h = ((mv)localObject2);
          paramInt += 1;
        }
        return 0;
      case 8: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new mp();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((mp)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((fa)localObject1).g = ((mp)localObject2);
          paramInt += 1;
        }
        return 0;
      case 7: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new np();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((np)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((fa)localObject1).f = ((np)localObject2);
          paramInt += 1;
        }
        return 0;
      case 6: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ly();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((ly)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((fa)localObject1).e = ((ly)localObject2);
          paramInt += 1;
        }
        return 0;
      case 5: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new mu();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((mu)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((fa)localObject1).d = ((mu)localObject2);
          paramInt += 1;
        }
        return 0;
      case 4: 
        ((fa)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 3: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new lc();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((lc)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((fa)localObject1).b = ((lc)localObject2);
          paramInt += 1;
        }
        return 0;
      case 2: 
        ((fa)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
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
        ((fa)localObject1).B = ((z)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.fa
 * JD-Core Version:    0.7.0.1
 */