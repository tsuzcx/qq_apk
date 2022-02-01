package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class ek
  extends gt
{
  public String a;
  public LinkedList<String> b = new LinkedList();
  public int c;
  public int d;
  public md e;
  
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
      paramVarArgs.a(3, 1, this.b);
      paramVarArgs.b(4, this.c);
      paramVarArgs.b(5, this.d);
      localObject1 = this.e;
      if (localObject1 != null)
      {
        paramVarArgs.c(6, ((md)localObject1).d());
        this.e.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i;
      if (this.B != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.B.d());
      }
      paramVarArgs = this.a;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(2, paramVarArgs);
      }
      i = i + com.tencent.luggage.wxa.sw.a.a(3, 1, this.b) + com.tencent.luggage.wxa.sw.a.b(4, this.c) + com.tencent.luggage.wxa.sw.a.b(5, this.d);
      paramVarArgs = this.e;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.c(6, paramVarArgs.d());
      }
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.b.clear();
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
      localObject1 = (ek)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 6: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new md();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((md)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ek)localObject1).e = ((md)localObject2);
          paramInt += 1;
        }
        return 0;
      case 5: 
        ((ek)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 4: 
        ((ek)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 3: 
        ((ek)localObject1).b.add(((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt));
        return 0;
      case 2: 
        ((ek)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
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
        ((ek)localObject1).B = ((z)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.ek
 * JD-Core Version:    0.7.0.1
 */