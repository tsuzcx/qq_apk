package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class iw
  extends gt
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public String f;
  public int g;
  public String h;
  
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
      paramVarArgs.b(2, this.a);
      paramVarArgs.b(3, this.b);
      paramVarArgs.b(4, this.c);
      paramVarArgs.b(5, this.d);
      paramVarArgs.b(6, this.e);
      localObject1 = this.f;
      if (localObject1 != null) {
        paramVarArgs.a(7, (String)localObject1);
      }
      paramVarArgs.b(8, this.g);
      localObject1 = this.h;
      if (localObject1 != null) {
        paramVarArgs.a(9, (String)localObject1);
      }
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i;
      if (this.B != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.B.d());
      }
      i = paramInt + com.tencent.luggage.wxa.sw.a.b(2, this.a) + com.tencent.luggage.wxa.sw.a.b(3, this.b) + com.tencent.luggage.wxa.sw.a.b(4, this.c) + com.tencent.luggage.wxa.sw.a.b(5, this.d) + com.tencent.luggage.wxa.sw.a.b(6, this.e);
      paramVarArgs = this.f;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(7, paramVarArgs);
      }
      i = paramInt + com.tencent.luggage.wxa.sw.a.b(8, this.g);
      paramVarArgs = this.h;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(9, paramVarArgs);
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
      localObject1 = (iw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 9: 
        ((iw)localObject1).h = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 8: 
        ((iw)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 7: 
        ((iw)localObject1).f = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 6: 
        ((iw)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 5: 
        ((iw)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 4: 
        ((iw)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 3: 
        ((iw)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 2: 
        ((iw)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject3 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new z();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (boolean bool = true; bool; bool = ((z)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((iw)localObject1).B = ((z)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.iw
 * JD-Core Version:    0.7.0.1
 */