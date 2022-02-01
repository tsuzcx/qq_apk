package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class ko
  extends com.tencent.luggage.wxa.qu.a
{
  public kk a;
  public jx b;
  public String c;
  public String d;
  public String e;
  public int f;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      localObject1 = this.a;
      if (localObject1 != null)
      {
        paramVarArgs.c(1, ((kk)localObject1).d());
        this.a.a(paramVarArgs);
      }
      localObject1 = this.b;
      if (localObject1 != null)
      {
        paramVarArgs.c(2, ((jx)localObject1).d());
        this.b.a(paramVarArgs);
      }
      localObject1 = this.c;
      if (localObject1 != null) {
        paramVarArgs.a(3, (String)localObject1);
      }
      localObject1 = this.d;
      if (localObject1 != null) {
        paramVarArgs.a(4, (String)localObject1);
      }
      localObject1 = this.e;
      if (localObject1 != null) {
        paramVarArgs.a(5, (String)localObject1);
      }
      paramVarArgs.b(6, this.f);
      return 0;
    }
    if (paramInt == 1)
    {
      paramVarArgs = this.a;
      if (paramVarArgs != null) {
        i = 0 + com.tencent.luggage.wxa.sw.a.c(1, paramVarArgs.d());
      }
      paramVarArgs = this.b;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.c(2, paramVarArgs.d());
      }
      paramVarArgs = this.c;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(3, paramVarArgs);
      }
      paramVarArgs = this.d;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(4, paramVarArgs);
      }
      paramVarArgs = this.e;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      return i + com.tencent.luggage.wxa.sw.a.b(6, this.f);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new com.tencent.luggage.wxa.sx.a((byte[])paramVarArgs[0], p);
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
      localObject1 = (ko)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 6: 
        ((ko)localObject1).f = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 5: 
        ((ko)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 4: 
        ((ko)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 3: 
        ((ko)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 2: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new jx();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((jx)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ko)localObject1).b = ((jx)localObject2);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject3 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new kk();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (bool = true; bool; bool = ((kk)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((ko)localObject1).a = ((kk)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.ko
 * JD-Core Version:    0.7.0.1
 */