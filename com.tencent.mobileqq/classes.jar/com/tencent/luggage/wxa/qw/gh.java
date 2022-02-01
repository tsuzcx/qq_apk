package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class gh
  extends com.tencent.luggage.wxa.qu.a
{
  public int a;
  public LinkedList<gi> b = new LinkedList();
  public int c;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      paramVarArgs.b(1, this.a);
      paramVarArgs.a(2, 8, this.b);
      paramVarArgs.b(3, this.c);
      return 0;
    }
    if (paramInt == 1) {
      return com.tencent.luggage.wxa.sw.a.b(1, this.a) + 0 + com.tencent.luggage.wxa.sw.a.a(2, 8, this.b) + com.tencent.luggage.wxa.sw.a.b(3, this.c);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
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
      gh localgh = (gh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return -1;
          }
          localgh.c = ((com.tencent.luggage.wxa.sx.a)localObject1).b(paramInt);
          return 0;
        }
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject1).i(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gi();
          localObject2 = new com.tencent.luggage.wxa.sx.a((byte[])localObject2, p);
          for (boolean bool = true; bool; bool = ((gi)localObject1).a((com.tencent.luggage.wxa.sx.a)localObject2, (com.tencent.luggage.wxa.qu.a)localObject1, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject2))) {}
          localgh.b.add(localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localgh.a = ((com.tencent.luggage.wxa.sx.a)localObject1).b(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.gh
 * JD-Core Version:    0.7.0.1
 */