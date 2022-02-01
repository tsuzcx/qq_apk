package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class ec
  extends gt
{
  public String a;
  public String b;
  public LinkedList<String> c = new LinkedList();
  public String d;
  public String e;
  public String f;
  public String g;
  public int h;
  public String i;
  public LinkedList<String> j = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int k = 0;
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
        paramVarArgs.a(3, (String)localObject1);
      }
      paramVarArgs.a(4, 1, this.c);
      localObject1 = this.d;
      if (localObject1 != null) {
        paramVarArgs.a(5, (String)localObject1);
      }
      localObject1 = this.e;
      if (localObject1 != null) {
        paramVarArgs.a(6, (String)localObject1);
      }
      localObject1 = this.f;
      if (localObject1 != null) {
        paramVarArgs.a(7, (String)localObject1);
      }
      localObject1 = this.g;
      if (localObject1 != null) {
        paramVarArgs.a(8, (String)localObject1);
      }
      paramVarArgs.b(9, this.h);
      localObject1 = this.i;
      if (localObject1 != null) {
        paramVarArgs.a(10, (String)localObject1);
      }
      paramVarArgs.a(11, 1, this.j);
      return 0;
    }
    if (paramInt == 1)
    {
      if (this.B != null) {
        k = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.B.d());
      }
      paramVarArgs = this.a;
      paramInt = k;
      if (paramVarArgs != null) {
        paramInt = k + com.tencent.luggage.wxa.sw.a.a(2, paramVarArgs);
      }
      paramVarArgs = this.b;
      k = paramInt;
      if (paramVarArgs != null) {
        k = paramInt + com.tencent.luggage.wxa.sw.a.a(3, paramVarArgs);
      }
      k += com.tencent.luggage.wxa.sw.a.a(4, 1, this.c);
      paramVarArgs = this.d;
      paramInt = k;
      if (paramVarArgs != null) {
        paramInt = k + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      paramVarArgs = this.e;
      k = paramInt;
      if (paramVarArgs != null) {
        k = paramInt + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
      }
      paramVarArgs = this.f;
      paramInt = k;
      if (paramVarArgs != null) {
        paramInt = k + com.tencent.luggage.wxa.sw.a.a(7, paramVarArgs);
      }
      paramVarArgs = this.g;
      k = paramInt;
      if (paramVarArgs != null) {
        k = paramInt + com.tencent.luggage.wxa.sw.a.a(8, paramVarArgs);
      }
      k += com.tencent.luggage.wxa.sw.a.b(9, this.h);
      paramVarArgs = this.i;
      paramInt = k;
      if (paramVarArgs != null) {
        paramInt = k + com.tencent.luggage.wxa.sw.a.a(10, paramVarArgs);
      }
      return paramInt + com.tencent.luggage.wxa.sw.a.a(11, 1, this.j);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.c.clear();
      this.j.clear();
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
      localObject1 = (ec)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 11: 
        ((ec)localObject1).j.add(((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt));
        return 0;
      case 10: 
        ((ec)localObject1).i = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 9: 
        ((ec)localObject1).h = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 8: 
        ((ec)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 7: 
        ((ec)localObject1).f = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 6: 
        ((ec)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 5: 
        ((ec)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 4: 
        ((ec)localObject1).c.add(((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt));
        return 0;
      case 3: 
        ((ec)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 2: 
        ((ec)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
      k = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < k)
      {
        Object localObject3 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new z();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (boolean bool = true; bool; bool = ((z)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((ec)localObject1).B = ((z)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.ec
 * JD-Core Version:    0.7.0.1
 */