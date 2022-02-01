package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class jc
  extends com.tencent.luggage.wxa.qu.a
{
  public LinkedList<jd> a = new LinkedList();
  public boolean b;
  public int c;
  public int d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      paramVarArgs.a(1, 8, this.a);
      paramVarArgs.a(2, this.b);
      paramVarArgs.b(3, this.c);
      paramVarArgs.b(4, this.d);
      localObject1 = this.e;
      if (localObject1 != null) {
        paramVarArgs.a(5, (String)localObject1);
      }
      localObject1 = this.f;
      if (localObject1 != null) {
        paramVarArgs.a(6, (String)localObject1);
      }
      localObject1 = this.g;
      if (localObject1 != null) {
        paramVarArgs.a(7, (String)localObject1);
      }
      localObject1 = this.h;
      if (localObject1 != null) {
        paramVarArgs.a(8, (String)localObject1);
      }
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = com.tencent.luggage.wxa.sw.a.a(1, 8, this.a) + 0 + com.tencent.luggage.wxa.sw.a.a(2, this.b) + com.tencent.luggage.wxa.sw.a.b(3, this.c) + com.tencent.luggage.wxa.sw.a.b(4, this.d);
      paramVarArgs = this.e;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      paramVarArgs = this.f;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
      }
      paramVarArgs = this.g;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(7, paramVarArgs);
      }
      paramVarArgs = this.h;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(8, paramVarArgs);
      }
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.a.clear();
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
      localObject1 = (jc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 8: 
        ((jc)localObject1).h = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 7: 
        ((jc)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 6: 
        ((jc)localObject1).f = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 5: 
        ((jc)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 4: 
        ((jc)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 3: 
        ((jc)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 2: 
        ((jc)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject3 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new jd();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (boolean bool = true; bool; bool = ((jd)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((jc)localObject1).a.add(localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.jc
 * JD-Core Version:    0.7.0.1
 */