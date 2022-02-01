package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class de
  extends gt
{
  public double a;
  public double b;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      if (this.B != null)
      {
        paramVarArgs.c(1, this.B.d());
        this.B.a(paramVarArgs);
      }
      paramVarArgs.a(2, this.a);
      paramVarArgs.a(3, this.b);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i;
      if (this.B != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.B.d());
      }
      return paramInt + com.tencent.luggage.wxa.sw.a.a(2, this.a) + com.tencent.luggage.wxa.sw.a.a(3, this.b);
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
      Object localObject1 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      de localde = (de)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return -1;
          }
          localde.b = ((com.tencent.luggage.wxa.sx.a)localObject1).e(paramInt);
          return 0;
        }
        localde.a = ((com.tencent.luggage.wxa.sx.a)localObject1).e(paramInt);
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject1).i(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new z();
        localObject2 = new com.tencent.luggage.wxa.sx.a((byte[])localObject2, p);
        for (boolean bool = true; bool; bool = ((z)localObject1).a((com.tencent.luggage.wxa.sx.a)localObject2, (com.tencent.luggage.wxa.qu.a)localObject1, gt.a((com.tencent.luggage.wxa.sx.a)localObject2))) {}
        localde.B = ((z)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.de
 * JD-Core Version:    0.7.0.1
 */