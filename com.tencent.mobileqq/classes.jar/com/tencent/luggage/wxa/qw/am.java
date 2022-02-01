package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class am
  extends com.tencent.luggage.wxa.qu.a
{
  public String a;
  public int b;
  public String c;
  public int d;
  public LinkedList<al> e = new LinkedList();
  
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
      paramVarArgs.b(2, this.b);
      localObject1 = this.c;
      if (localObject1 != null) {
        paramVarArgs.a(3, (String)localObject1);
      }
      paramVarArgs.b(4, this.d);
      paramVarArgs.a(5, 8, this.e);
      return 0;
    }
    if (paramInt == 1)
    {
      paramVarArgs = this.a;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.a(1, paramVarArgs);
      }
      i = paramInt + com.tencent.luggage.wxa.sw.a.b(2, this.b);
      paramVarArgs = this.c;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(3, paramVarArgs);
      }
      return paramInt + com.tencent.luggage.wxa.sw.a.b(4, this.d) + com.tencent.luggage.wxa.sw.a.a(5, 8, this.e);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.e.clear();
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
      localObject1 = (am)paramVarArgs[1];
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
              paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
              i = paramVarArgs.size();
              paramInt = 0;
              while (paramInt < i)
              {
                Object localObject3 = (byte[])paramVarArgs.get(paramInt);
                localObject2 = new al();
                localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
                for (boolean bool = true; bool; bool = ((al)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
                ((am)localObject1).e.add(localObject2);
                paramInt += 1;
              }
              return 0;
            }
            ((am)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
            return 0;
          }
          ((am)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
          return 0;
        }
        ((am)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      }
      ((am)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.am
 * JD-Core Version:    0.7.0.1
 */