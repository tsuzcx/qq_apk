package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class ir
  extends com.tencent.luggage.wxa.qu.a
{
  public int a;
  public ft b;
  public fu c;
  public e d;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      paramVarArgs.b(1, this.a);
      localObject1 = this.b;
      if (localObject1 != null)
      {
        paramVarArgs.c(2, ((ft)localObject1).d());
        this.b.a(paramVarArgs);
      }
      localObject1 = this.c;
      if (localObject1 != null)
      {
        paramVarArgs.c(3, ((fu)localObject1).d());
        this.c.a(paramVarArgs);
      }
      localObject1 = this.d;
      if (localObject1 != null)
      {
        paramVarArgs.c(4, ((e)localObject1).d());
        this.d.a(paramVarArgs);
      }
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = com.tencent.luggage.wxa.sw.a.b(1, this.a) + 0;
      paramVarArgs = this.b;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.c(2, paramVarArgs.d());
      }
      paramVarArgs = this.c;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.c(3, paramVarArgs.d());
      }
      paramVarArgs = this.d;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.c(4, paramVarArgs.d());
      }
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new com.tencent.luggage.wxa.sx.a((byte[])paramVarArgs[0], p);
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
      localObject1 = (ir)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      if (paramInt != 1)
      {
        Object localObject3;
        boolean bool;
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return -1;
            }
            paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
            i = paramVarArgs.size();
            paramInt = 0;
            while (paramInt < i)
            {
              localObject3 = (byte[])paramVarArgs.get(paramInt);
              localObject2 = new e();
              localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
              for (bool = true; bool; bool = ((e)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
              ((ir)localObject1).d = ((e)localObject2);
              paramInt += 1;
            }
            return 0;
          }
          paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject3 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fu();
            localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
            for (bool = true; bool; bool = ((fu)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
            ((ir)localObject1).c = ((fu)localObject2);
            paramInt += 1;
          }
          return 0;
        }
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ft();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((ft)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ir)localObject1).b = ((ft)localObject2);
          paramInt += 1;
        }
        return 0;
      }
      ((ir)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.ir
 * JD-Core Version:    0.7.0.1
 */