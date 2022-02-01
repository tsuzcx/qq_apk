package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class ik
  extends com.tencent.luggage.wxa.qu.a
{
  public String a;
  public int b;
  public int c;
  public int d;
  public int e;
  public String f;
  public LinkedList<ey> g = new LinkedList();
  public int h;
  public String i;
  public int j;
  public int k;
  public String l;
  public String m;
  public int n;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      localObject1 = this.a;
      if (localObject1 != null) {
        paramVarArgs.a(1, (String)localObject1);
      }
      paramVarArgs.b(2, this.b);
      paramVarArgs.b(3, this.c);
      paramVarArgs.b(4, this.d);
      paramVarArgs.b(5, this.e);
      localObject1 = this.f;
      if (localObject1 != null) {
        paramVarArgs.a(6, (String)localObject1);
      }
      paramVarArgs.a(7, 8, this.g);
      paramVarArgs.b(8, this.h);
      localObject1 = this.i;
      if (localObject1 != null) {
        paramVarArgs.a(9, (String)localObject1);
      }
      paramVarArgs.b(10, this.j);
      paramVarArgs.b(11, this.k);
      localObject1 = this.l;
      if (localObject1 != null) {
        paramVarArgs.a(12, (String)localObject1);
      }
      localObject1 = this.m;
      if (localObject1 != null) {
        paramVarArgs.a(13, (String)localObject1);
      }
      paramVarArgs.b(14, this.n);
      return 0;
    }
    int i1;
    if (paramInt == 1)
    {
      paramVarArgs = this.a;
      if (paramVarArgs != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.a(1, paramVarArgs);
      } else {
        paramInt = 0;
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.b(2, this.b) + com.tencent.luggage.wxa.sw.a.b(3, this.c) + com.tencent.luggage.wxa.sw.a.b(4, this.d) + com.tencent.luggage.wxa.sw.a.b(5, this.e);
      paramVarArgs = this.f;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(7, 8, this.g) + com.tencent.luggage.wxa.sw.a.b(8, this.h);
      paramVarArgs = this.i;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(9, paramVarArgs);
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.b(10, this.j) + com.tencent.luggage.wxa.sw.a.b(11, this.k);
      paramVarArgs = this.l;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(12, paramVarArgs);
      }
      paramVarArgs = this.m;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(13, paramVarArgs);
      }
      return i1 + com.tencent.luggage.wxa.sw.a.b(14, this.n);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.g.clear();
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
      localObject1 = (ik)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 14: 
        ((ik)localObject1).n = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 13: 
        ((ik)localObject1).m = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 12: 
        ((ik)localObject1).l = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 11: 
        ((ik)localObject1).k = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 10: 
        ((ik)localObject1).j = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 9: 
        ((ik)localObject1).i = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 8: 
        ((ik)localObject1).h = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 7: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          Object localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ey();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (boolean bool = true; bool; bool = ((ey)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ik)localObject1).g.add(localObject2);
          paramInt += 1;
        }
        return 0;
      case 6: 
        ((ik)localObject1).f = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 5: 
        ((ik)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 4: 
        ((ik)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 3: 
        ((ik)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 2: 
        ((ik)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      }
      ((ik)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.ik
 * JD-Core Version:    0.7.0.1
 */