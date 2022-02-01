package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class ad
  extends gt
{
  public int a;
  public LinkedList<cm> b = new LinkedList();
  public int c;
  
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
      paramVarArgs.b(2, this.a);
      paramVarArgs.a(3, 8, this.b);
      paramVarArgs.b(4, this.c);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i;
      if (this.B != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.B.d());
      }
      return paramInt + com.tencent.luggage.wxa.sw.a.b(2, this.a) + com.tencent.luggage.wxa.sw.a.a(3, 8, this.b) + com.tencent.luggage.wxa.sw.a.b(4, this.c);
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
      Object localObject1 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      ad localad = (ad)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return -1;
            }
            localad.c = ((com.tencent.luggage.wxa.sx.a)localObject1).b(paramInt);
            return 0;
          }
          paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject1).i(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cm();
            localObject2 = new com.tencent.luggage.wxa.sx.a((byte[])localObject2, p);
            for (bool = true; bool; bool = ((cm)localObject1).a((com.tencent.luggage.wxa.sx.a)localObject2, (com.tencent.luggage.wxa.qu.a)localObject1, gt.a((com.tencent.luggage.wxa.sx.a)localObject2))) {}
            localad.b.add(localObject1);
            paramInt += 1;
          }
          return 0;
        }
        localad.a = ((com.tencent.luggage.wxa.sx.a)localObject1).b(paramInt);
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject1).i(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new z();
        localObject2 = new com.tencent.luggage.wxa.sx.a((byte[])localObject2, p);
        for (bool = true; bool; bool = ((z)localObject1).a((com.tencent.luggage.wxa.sx.a)localObject2, (com.tencent.luggage.wxa.qu.a)localObject1, gt.a((com.tencent.luggage.wxa.sx.a)localObject2))) {}
        localad.B = ((z)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.ad
 * JD-Core Version:    0.7.0.1
 */