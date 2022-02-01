package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.qu.b;
import java.util.LinkedList;

public class il
  extends gt
{
  public String a;
  public int b;
  public LinkedList<ik> c = new LinkedList();
  public int d;
  public String e;
  public int f;
  public int g;
  public String h;
  public b i;
  public gb j;
  public int k;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int m = 0;
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
      paramVarArgs.b(3, this.b);
      paramVarArgs.a(4, 8, this.c);
      paramVarArgs.b(5, this.d);
      localObject1 = this.e;
      if (localObject1 != null) {
        paramVarArgs.a(6, (String)localObject1);
      }
      paramVarArgs.b(7, this.f);
      paramVarArgs.b(8, this.g);
      localObject1 = this.h;
      if (localObject1 != null) {
        paramVarArgs.a(9, (String)localObject1);
      }
      localObject1 = this.i;
      if (localObject1 != null) {
        paramVarArgs.a(10, (b)localObject1);
      }
      localObject1 = this.j;
      if (localObject1 != null)
      {
        paramVarArgs.c(11, ((gb)localObject1).d());
        this.j.a(paramVarArgs);
      }
      paramVarArgs.b(12, this.k);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = m;
      if (this.B != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.B.d());
      }
      paramVarArgs = this.a;
      m = paramInt;
      if (paramVarArgs != null) {
        m = paramInt + com.tencent.luggage.wxa.sw.a.a(2, paramVarArgs);
      }
      m = m + com.tencent.luggage.wxa.sw.a.b(3, this.b) + com.tencent.luggage.wxa.sw.a.a(4, 8, this.c) + com.tencent.luggage.wxa.sw.a.b(5, this.d);
      paramVarArgs = this.e;
      paramInt = m;
      if (paramVarArgs != null) {
        paramInt = m + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
      }
      m = paramInt + com.tencent.luggage.wxa.sw.a.b(7, this.f) + com.tencent.luggage.wxa.sw.a.b(8, this.g);
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
        paramInt = m + com.tencent.luggage.wxa.sw.a.c(11, paramVarArgs.d());
      }
      return paramInt + com.tencent.luggage.wxa.sw.a.b(12, this.k);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.c.clear();
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
      localObject1 = (il)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 12: 
        ((il)localObject1).k = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 11: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        m = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < m)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gb();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((gb)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((il)localObject1).j = ((gb)localObject2);
          paramInt += 1;
        }
        return 0;
      case 10: 
        ((il)localObject1).i = ((com.tencent.luggage.wxa.sx.a)localObject2).h(paramInt);
        return 0;
      case 9: 
        ((il)localObject1).h = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 8: 
        ((il)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 7: 
        ((il)localObject1).f = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 6: 
        ((il)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 5: 
        ((il)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 4: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        m = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < m)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ik();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((ik)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((il)localObject1).c.add(localObject2);
          paramInt += 1;
        }
        return 0;
      case 3: 
        ((il)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 2: 
        ((il)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
      m = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < m)
      {
        localObject3 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new z();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (bool = true; bool; bool = ((z)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((il)localObject1).B = ((z)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.il
 * JD-Core Version:    0.7.0.1
 */