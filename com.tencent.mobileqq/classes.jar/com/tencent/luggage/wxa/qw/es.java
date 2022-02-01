package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.qu.b;
import java.util.LinkedList;

public class es
  extends gt
{
  public String a;
  public b b;
  public String c;
  public int d;
  public int e;
  public md f;
  public int g;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
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
      if (localObject1 != null) {
        paramVarArgs.a(3, (b)localObject1);
      }
      localObject1 = this.c;
      if (localObject1 != null) {
        paramVarArgs.a(4, (String)localObject1);
      }
      paramVarArgs.b(5, this.d);
      paramVarArgs.b(6, this.e);
      localObject1 = this.f;
      if (localObject1 != null)
      {
        paramVarArgs.c(7, ((md)localObject1).d());
        this.f.a(paramVarArgs);
      }
      paramVarArgs.b(8, this.g);
      return 0;
    }
    if (paramInt == 1)
    {
      if (this.B != null) {
        i = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.B.d());
      }
      paramVarArgs = this.a;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(2, paramVarArgs);
      }
      paramVarArgs = this.b;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(3, paramVarArgs);
      }
      paramVarArgs = this.c;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(4, paramVarArgs);
      }
      i = paramInt + com.tencent.luggage.wxa.sw.a.b(5, this.d) + com.tencent.luggage.wxa.sw.a.b(6, this.e);
      paramVarArgs = this.f;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.c(7, paramVarArgs.d());
      }
      return paramInt + com.tencent.luggage.wxa.sw.a.b(8, this.g);
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
      localObject1 = (es)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 8: 
        ((es)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 7: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new md();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((md)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((es)localObject1).f = ((md)localObject2);
          paramInt += 1;
        }
        return 0;
      case 6: 
        ((es)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 5: 
        ((es)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 4: 
        ((es)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 3: 
        ((es)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).h(paramInt);
        return 0;
      case 2: 
        ((es)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject3 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new z();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (bool = true; bool; bool = ((z)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((es)localObject1).B = ((z)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.es
 * JD-Core Version:    0.7.0.1
 */