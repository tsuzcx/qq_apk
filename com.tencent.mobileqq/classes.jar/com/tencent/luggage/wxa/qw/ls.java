package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class ls
  extends com.tencent.luggage.wxa.qu.a
{
  public int a;
  public int b;
  public String c;
  public String d;
  public int e;
  public LinkedList<ap> f = new LinkedList();
  public k g;
  public LinkedList<kz> h = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      paramVarArgs.b(1, this.a);
      paramVarArgs.b(2, this.b);
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
      localObject1 = this.g;
      if (localObject1 != null)
      {
        paramVarArgs.c(7, ((k)localObject1).d());
        this.g.a(paramVarArgs);
      }
      paramVarArgs.a(36, 8, this.h);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = com.tencent.luggage.wxa.sw.a.b(1, this.a) + 0 + com.tencent.luggage.wxa.sw.a.b(2, this.b);
      paramVarArgs = this.c;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(3, paramVarArgs);
      }
      paramVarArgs = this.d;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(4, paramVarArgs);
      }
      i = i + com.tencent.luggage.wxa.sw.a.b(5, this.e) + com.tencent.luggage.wxa.sw.a.a(6, 8, this.f);
      paramVarArgs = this.g;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.c(7, paramVarArgs.d());
      }
      return paramInt + com.tencent.luggage.wxa.sw.a.a(36, 8, this.h);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.f.clear();
      this.h.clear();
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
      localObject1 = (ls)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      if (paramInt != 36)
      {
        switch (paramInt)
        {
        default: 
          return -1;
        case 7: 
          paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject3 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new k();
            localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
            for (bool = true; bool; bool = ((k)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
            ((ls)localObject1).g = ((k)localObject2);
            paramInt += 1;
          }
          return 0;
        case 6: 
          paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject3 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ap();
            localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
            for (bool = true; bool; bool = ((ap)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
            ((ls)localObject1).f.add(localObject2);
            paramInt += 1;
          }
          return 0;
        case 5: 
          ((ls)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
          return 0;
        case 4: 
          ((ls)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
          return 0;
        case 3: 
          ((ls)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
          return 0;
        case 2: 
          ((ls)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
          return 0;
        }
        ((ls)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject3 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new kz();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (bool = true; bool; bool = ((kz)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((ls)localObject1).h.add(localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.ls
 * JD-Core Version:    0.7.0.1
 */