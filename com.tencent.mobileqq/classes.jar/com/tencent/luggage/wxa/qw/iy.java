package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class iy
  extends gt
{
  public String a;
  public int b;
  public boolean c;
  public int d;
  
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
      paramVarArgs.b(3, this.b);
      paramVarArgs.a(4, this.c);
      paramVarArgs.b(5, this.d);
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
      return i + com.tencent.luggage.wxa.sw.a.b(3, this.b) + com.tencent.luggage.wxa.sw.a.a(4, this.c) + com.tencent.luggage.wxa.sw.a.b(5, this.d);
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
      Object localObject2 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      localObject1 = (iy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return -1;
              }
              ((iy)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
              return 0;
            }
            ((iy)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
            return 0;
          }
          ((iy)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
          return 0;
        }
        ((iy)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
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
        ((iy)localObject1).B = ((z)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.iy
 * JD-Core Version:    0.7.0.1
 */