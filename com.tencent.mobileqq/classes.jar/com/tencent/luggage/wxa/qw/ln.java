package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class ln
  extends com.tencent.luggage.wxa.qu.a
{
  public String a;
  public int b;
  public String c;
  public ic d;
  public m e;
  public fn f;
  public g g;
  public l h;
  public i i;
  public LinkedList<ap> j = new LinkedList();
  public String k;
  public String l;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int m = 0;
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      localObject1 = this.a;
      if (localObject1 != null) {
        paramVarArgs.a(1, (String)localObject1);
      }
      paramVarArgs.b(2, this.b);
      localObject1 = this.c;
      if (localObject1 != null) {
        paramVarArgs.a(3, (String)localObject1);
      }
      localObject1 = this.d;
      if (localObject1 != null)
      {
        paramVarArgs.c(4, ((ic)localObject1).d());
        this.d.a(paramVarArgs);
      }
      localObject1 = this.e;
      if (localObject1 != null)
      {
        paramVarArgs.c(5, ((m)localObject1).d());
        this.e.a(paramVarArgs);
      }
      localObject1 = this.f;
      if (localObject1 != null)
      {
        paramVarArgs.c(6, ((fn)localObject1).d());
        this.f.a(paramVarArgs);
      }
      localObject1 = this.g;
      if (localObject1 != null)
      {
        paramVarArgs.c(7, ((g)localObject1).d());
        this.g.a(paramVarArgs);
      }
      localObject1 = this.h;
      if (localObject1 != null)
      {
        paramVarArgs.c(8, ((l)localObject1).d());
        this.h.a(paramVarArgs);
      }
      localObject1 = this.i;
      if (localObject1 != null)
      {
        paramVarArgs.c(11, ((i)localObject1).d());
        this.i.a(paramVarArgs);
      }
      paramVarArgs.a(12, 8, this.j);
      localObject1 = this.k;
      if (localObject1 != null) {
        paramVarArgs.a(13, (String)localObject1);
      }
      localObject1 = this.l;
      if (localObject1 != null) {
        paramVarArgs.a(14, (String)localObject1);
      }
      return 0;
    }
    if (paramInt == 1)
    {
      paramVarArgs = this.a;
      paramInt = m;
      if (paramVarArgs != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.a(1, paramVarArgs);
      }
      m = paramInt + com.tencent.luggage.wxa.sw.a.b(2, this.b);
      paramVarArgs = this.c;
      paramInt = m;
      if (paramVarArgs != null) {
        paramInt = m + com.tencent.luggage.wxa.sw.a.a(3, paramVarArgs);
      }
      paramVarArgs = this.d;
      m = paramInt;
      if (paramVarArgs != null) {
        m = paramInt + com.tencent.luggage.wxa.sw.a.c(4, paramVarArgs.d());
      }
      paramVarArgs = this.e;
      paramInt = m;
      if (paramVarArgs != null) {
        paramInt = m + com.tencent.luggage.wxa.sw.a.c(5, paramVarArgs.d());
      }
      paramVarArgs = this.f;
      m = paramInt;
      if (paramVarArgs != null) {
        m = paramInt + com.tencent.luggage.wxa.sw.a.c(6, paramVarArgs.d());
      }
      paramVarArgs = this.g;
      paramInt = m;
      if (paramVarArgs != null) {
        paramInt = m + com.tencent.luggage.wxa.sw.a.c(7, paramVarArgs.d());
      }
      paramVarArgs = this.h;
      m = paramInt;
      if (paramVarArgs != null) {
        m = paramInt + com.tencent.luggage.wxa.sw.a.c(8, paramVarArgs.d());
      }
      paramVarArgs = this.i;
      paramInt = m;
      if (paramVarArgs != null) {
        paramInt = m + com.tencent.luggage.wxa.sw.a.c(11, paramVarArgs.d());
      }
      m = paramInt + com.tencent.luggage.wxa.sw.a.a(12, 8, this.j);
      paramVarArgs = this.k;
      paramInt = m;
      if (paramVarArgs != null) {
        paramInt = m + com.tencent.luggage.wxa.sw.a.a(13, paramVarArgs);
      }
      paramVarArgs = this.l;
      m = paramInt;
      if (paramVarArgs != null) {
        m = paramInt + com.tencent.luggage.wxa.sw.a.a(14, paramVarArgs);
      }
      return m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.j.clear();
      paramVarArgs = new com.tencent.luggage.wxa.sx.a(paramVarArgs, p);
      for (paramInt = com.tencent.luggage.wxa.qu.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.luggage.wxa.qu.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.b();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject2 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      localObject1 = (ln)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      switch (paramInt)
      {
      case 9: 
      case 10: 
      default: 
        return -1;
      case 14: 
        ((ln)localObject1).l = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 13: 
        ((ln)localObject1).k = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 12: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        m = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < m)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ap();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((ap)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ln)localObject1).j.add(localObject2);
          paramInt += 1;
        }
        return 0;
      case 11: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        m = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < m)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new i();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((i)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ln)localObject1).i = ((i)localObject2);
          paramInt += 1;
        }
        return 0;
      case 8: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        m = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < m)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new l();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((l)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ln)localObject1).h = ((l)localObject2);
          paramInt += 1;
        }
        return 0;
      case 7: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        m = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < m)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new g();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((g)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ln)localObject1).g = ((g)localObject2);
          paramInt += 1;
        }
        return 0;
      case 6: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        m = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < m)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fn();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((fn)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ln)localObject1).f = ((fn)localObject2);
          paramInt += 1;
        }
        return 0;
      case 5: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        m = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < m)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new m();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((m)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ln)localObject1).e = ((m)localObject2);
          paramInt += 1;
        }
        return 0;
      case 4: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        m = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < m)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ic();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((ic)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ln)localObject1).d = ((ic)localObject2);
          paramInt += 1;
        }
        return 0;
      case 3: 
        ((ln)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 2: 
        ((ln)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      }
      ((ln)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.ln
 * JD-Core Version:    0.7.0.1
 */