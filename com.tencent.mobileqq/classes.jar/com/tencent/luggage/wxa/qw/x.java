package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class x
  extends com.tencent.luggage.wxa.qu.a
{
  public String a;
  public String b;
  public LinkedList<w> c = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      localObject1 = this.a;
      if (localObject1 != null) {
        paramVarArgs.a(1, (String)localObject1);
      }
      localObject1 = this.b;
      if (localObject1 != null) {
        paramVarArgs.a(2, (String)localObject1);
      }
      paramVarArgs.a(3, 8, this.c);
      return 0;
    }
    if (paramInt == 1)
    {
      paramVarArgs = this.a;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.a(1, paramVarArgs);
      }
      paramVarArgs = this.b;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(2, paramVarArgs);
      }
      return i + com.tencent.luggage.wxa.sw.a.a(3, 8, this.c);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.c.clear();
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
      Object localObject2 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      localObject1 = (x)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return -1;
          }
          paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject3 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new w();
            localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
            for (boolean bool = true; bool; bool = ((w)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
            ((x)localObject1).c.add(localObject2);
            paramInt += 1;
          }
          return 0;
        }
        ((x)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      }
      ((x)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.x
 * JD-Core Version:    0.7.0.1
 */