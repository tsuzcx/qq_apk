package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class ao
  extends com.tencent.luggage.wxa.qu.a
{
  public String a;
  public int b;
  public int c;
  public String d;
  public String e;
  public String f;
  public String g;
  public LinkedList<Integer> h = new LinkedList();
  public String i;
  public int j;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int k = 0;
    Object localObject;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      localObject = this.a;
      if (localObject != null) {
        paramVarArgs.a(1, (String)localObject);
      }
      paramVarArgs.b(2, this.b);
      paramVarArgs.b(3, this.c);
      localObject = this.d;
      if (localObject != null) {
        paramVarArgs.a(4, (String)localObject);
      }
      localObject = this.e;
      if (localObject != null) {
        paramVarArgs.a(5, (String)localObject);
      }
      localObject = this.f;
      if (localObject != null) {
        paramVarArgs.a(6, (String)localObject);
      }
      localObject = this.g;
      if (localObject != null) {
        paramVarArgs.a(7, (String)localObject);
      }
      paramVarArgs.a(8, 2, this.h);
      localObject = this.i;
      if (localObject != null) {
        paramVarArgs.a(9, (String)localObject);
      }
      paramVarArgs.b(11, this.j);
      return 0;
    }
    if (paramInt == 1)
    {
      paramVarArgs = this.a;
      paramInt = k;
      if (paramVarArgs != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.a(1, paramVarArgs);
      }
      k = paramInt + com.tencent.luggage.wxa.sw.a.b(2, this.b) + com.tencent.luggage.wxa.sw.a.b(3, this.c);
      paramVarArgs = this.d;
      paramInt = k;
      if (paramVarArgs != null) {
        paramInt = k + com.tencent.luggage.wxa.sw.a.a(4, paramVarArgs);
      }
      paramVarArgs = this.e;
      k = paramInt;
      if (paramVarArgs != null) {
        k = paramInt + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      paramVarArgs = this.f;
      paramInt = k;
      if (paramVarArgs != null) {
        paramInt = k + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
      }
      paramVarArgs = this.g;
      k = paramInt;
      if (paramVarArgs != null) {
        k = paramInt + com.tencent.luggage.wxa.sw.a.a(7, paramVarArgs);
      }
      k += com.tencent.luggage.wxa.sw.a.a(8, 2, this.h);
      paramVarArgs = this.i;
      paramInt = k;
      if (paramVarArgs != null) {
        paramInt = k + com.tencent.luggage.wxa.sw.a.a(9, paramVarArgs);
      }
      return paramInt + com.tencent.luggage.wxa.sw.a.b(11, this.j);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
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
      localObject = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      ao localao = (ao)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 10: 
      default: 
        return -1;
      case 11: 
        localao.j = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 9: 
        localao.i = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 8: 
        localao.h.add(Integer.valueOf(((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt)));
        return 0;
      case 7: 
        localao.g = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 6: 
        localao.f = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 5: 
        localao.e = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 4: 
        localao.d = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 3: 
        localao.c = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 2: 
        localao.b = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      }
      localao.a = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.ao
 * JD-Core Version:    0.7.0.1
 */