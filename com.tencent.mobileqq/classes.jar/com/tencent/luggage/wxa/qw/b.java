package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class b
  extends gt
{
  public LinkedList<d> a = new LinkedList();
  
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
      paramVarArgs.a(2, 8, this.a);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i;
      if (this.B != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.B.d());
      }
      return paramInt + com.tencent.luggage.wxa.sw.a.a(2, 8, this.a);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.a.clear();
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
      b localb = (b)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return -1;
        }
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject1).i(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new d();
          localObject2 = new com.tencent.luggage.wxa.sx.a((byte[])localObject2, p);
          for (bool = true; bool; bool = ((d)localObject1).a((com.tencent.luggage.wxa.sx.a)localObject2, (com.tencent.luggage.wxa.qu.a)localObject1, gt.a((com.tencent.luggage.wxa.sx.a)localObject2))) {}
          localb.a.add(localObject1);
          paramInt += 1;
        }
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
        localb.B = ((z)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.b
 * JD-Core Version:    0.7.0.1
 */