package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class ak
  extends com.tencent.luggage.wxa.qu.a
{
  public LinkedList<lz> a = new LinkedList();
  public LinkedList<lz> b = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      paramVarArgs.a(1, 8, this.a);
      paramVarArgs.a(2, 8, this.b);
      return 0;
    }
    if (paramInt == 1) {
      return com.tencent.luggage.wxa.sw.a.a(1, 8, this.a) + 0 + com.tencent.luggage.wxa.sw.a.a(2, 8, this.b);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.a.clear();
      this.b.clear();
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
      Object localObject1 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      ak localak = (ak)paramVarArgs[1];
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
          localObject1 = new lz();
          localObject2 = new com.tencent.luggage.wxa.sx.a((byte[])localObject2, p);
          for (bool = true; bool; bool = ((lz)localObject1).a((com.tencent.luggage.wxa.sx.a)localObject2, (com.tencent.luggage.wxa.qu.a)localObject1, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject2))) {}
          localak.b.add(localObject1);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject1).i(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new lz();
        localObject2 = new com.tencent.luggage.wxa.sx.a((byte[])localObject2, p);
        for (bool = true; bool; bool = ((lz)localObject1).a((com.tencent.luggage.wxa.sx.a)localObject2, (com.tencent.luggage.wxa.qu.a)localObject1, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject2))) {}
        localak.a.add(localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.ak
 * JD-Core Version:    0.7.0.1
 */