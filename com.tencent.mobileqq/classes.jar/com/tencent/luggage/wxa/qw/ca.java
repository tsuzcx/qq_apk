package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class ca
  extends com.tencent.luggage.wxa.qu.a
{
  public int a;
  public String b;
  public String c;
  public int d;
  public int e;
  public boolean f;
  public boolean g;
  public gs h;
  public String i;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      paramVarArgs.b(1, this.a);
      localObject1 = this.b;
      if (localObject1 != null) {
        paramVarArgs.a(2, (String)localObject1);
      }
      localObject1 = this.c;
      if (localObject1 != null) {
        paramVarArgs.a(3, (String)localObject1);
      }
      paramVarArgs.b(4, this.d);
      paramVarArgs.b(5, this.e);
      paramVarArgs.a(6, this.f);
      paramVarArgs.a(7, this.g);
      localObject1 = this.h;
      if (localObject1 != null)
      {
        paramVarArgs.c(20, ((gs)localObject1).d());
        this.h.a(paramVarArgs);
      }
      localObject1 = this.i;
      if (localObject1 != null) {
        paramVarArgs.a(21, (String)localObject1);
      }
      return 0;
    }
    int j;
    if (paramInt == 1)
    {
      j = com.tencent.luggage.wxa.sw.a.b(1, this.a) + 0;
      paramVarArgs = this.b;
      paramInt = j;
      if (paramVarArgs != null) {
        paramInt = j + com.tencent.luggage.wxa.sw.a.a(2, paramVarArgs);
      }
      paramVarArgs = this.c;
      j = paramInt;
      if (paramVarArgs != null) {
        j = paramInt + com.tencent.luggage.wxa.sw.a.a(3, paramVarArgs);
      }
      j = j + com.tencent.luggage.wxa.sw.a.b(4, this.d) + com.tencent.luggage.wxa.sw.a.b(5, this.e) + com.tencent.luggage.wxa.sw.a.a(6, this.f) + com.tencent.luggage.wxa.sw.a.a(7, this.g);
      paramVarArgs = this.h;
      paramInt = j;
      if (paramVarArgs != null) {
        paramInt = j + com.tencent.luggage.wxa.sw.a.c(20, paramVarArgs.d());
      }
      paramVarArgs = this.i;
      j = paramInt;
      if (paramVarArgs != null) {
        j = paramInt + com.tencent.luggage.wxa.sw.a.a(21, paramVarArgs);
      }
      return j;
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
      localObject1 = (ca)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      if (paramInt != 20)
      {
        if (paramInt != 21)
        {
          switch (paramInt)
          {
          default: 
            return -1;
          case 7: 
            ((ca)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
            return 0;
          case 6: 
            ((ca)localObject1).f = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
            return 0;
          case 5: 
            ((ca)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
            return 0;
          case 4: 
            ((ca)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
            return 0;
          case 3: 
            ((ca)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
            return 0;
          case 2: 
            ((ca)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
            return 0;
          }
          ((ca)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
          return 0;
        }
        ((ca)localObject1).i = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
      j = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < j)
      {
        Object localObject3 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new gs();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (boolean bool = true; bool; bool = ((gs)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((ca)localObject1).h = ((gs)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.ca
 * JD-Core Version:    0.7.0.1
 */