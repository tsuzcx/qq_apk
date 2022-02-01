package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class au
  extends gu
{
  public com.tencent.luggage.wxa.qu.b a;
  public com.tencent.luggage.wxa.qu.b b;
  public com.tencent.luggage.wxa.qu.b c;
  public int d;
  public int e;
  public com.tencent.luggage.wxa.qu.b f;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      if (this.z != null)
      {
        if (this.z != null)
        {
          paramVarArgs.c(1, this.z.d());
          this.z.a(paramVarArgs);
        }
        localObject1 = this.a;
        if (localObject1 != null) {
          paramVarArgs.a(2, (com.tencent.luggage.wxa.qu.b)localObject1);
        }
        localObject1 = this.b;
        if (localObject1 != null) {
          paramVarArgs.a(3, (com.tencent.luggage.wxa.qu.b)localObject1);
        }
        localObject1 = this.c;
        if (localObject1 != null) {
          paramVarArgs.a(4, (com.tencent.luggage.wxa.qu.b)localObject1);
        }
        paramVarArgs.b(5, this.d);
        paramVarArgs.b(6, this.e);
        localObject1 = this.f;
        if (localObject1 != null) {
          paramVarArgs.a(7, (com.tencent.luggage.wxa.qu.b)localObject1);
        }
        return 0;
      }
      throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: BaseResponse");
    }
    if (paramInt == 1)
    {
      if (this.z != null) {
        i = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.z.d());
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
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(7, paramVarArgs);
      }
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new com.tencent.luggage.wxa.sx.a((byte[])paramVarArgs[0], p);
      for (paramInt = gu.a(paramVarArgs); paramInt > 0; paramInt = gu.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.b();
        }
      }
      if (this.z != null) {
        return 0;
      }
      throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: BaseResponse");
    }
    if (paramInt == 3)
    {
      Object localObject2 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      localObject1 = (au)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 7: 
        ((au)localObject1).f = ((com.tencent.luggage.wxa.sx.a)localObject2).h(paramInt);
        return 0;
      case 6: 
        ((au)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 5: 
        ((au)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 4: 
        ((au)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).h(paramInt);
        return 0;
      case 3: 
        ((au)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).h(paramInt);
        return 0;
      case 2: 
        ((au)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).h(paramInt);
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject3 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new aa();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (boolean bool = true; bool; bool = ((aa)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((au)localObject1).z = ((aa)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.au
 * JD-Core Version:    0.7.0.1
 */