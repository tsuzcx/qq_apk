package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class hs
  extends gt
{
  public String a;
  public LinkedList<Integer> b = new LinkedList();
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
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
      paramVarArgs.a(3, 2, this.b);
      localObject1 = this.c;
      if (localObject1 != null) {
        paramVarArgs.a(4, (String)localObject1);
      }
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
      i += com.tencent.luggage.wxa.sw.a.a(3, 2, this.b);
      paramVarArgs = this.c;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(4, paramVarArgs);
      }
      paramVarArgs = this.d;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      paramVarArgs = this.e;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
      }
      paramVarArgs = this.f;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(7, paramVarArgs);
      }
      paramVarArgs = this.g;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(8, paramVarArgs);
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
      localObject1 = (hs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 8: 
        ((hs)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 7: 
        ((hs)localObject1).f = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 6: 
        ((hs)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 5: 
        ((hs)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 4: 
        ((hs)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 3: 
        ((hs)localObject1).b.add(Integer.valueOf(((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt)));
        return 0;
      case 2: 
        ((hs)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
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
        ((hs)localObject1).B = ((z)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.hs
 * JD-Core Version:    0.7.0.1
 */