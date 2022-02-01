package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.sw.b;
import java.util.LinkedList;

public class ky
  extends com.tencent.luggage.wxa.qu.a
{
  public jn a;
  public LinkedList<ju> b = new LinkedList();
  public int c;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      localObject1 = this.a;
      if (localObject1 != null)
      {
        if (localObject1 != null)
        {
          paramVarArgs.c(1, ((jn)localObject1).d());
          this.a.a(paramVarArgs);
        }
        paramVarArgs.a(2, 8, this.b);
        paramVarArgs.b(3, this.c);
        return 0;
      }
      throw new b("Not all required fields were included: base_response");
    }
    if (paramInt == 1)
    {
      paramVarArgs = this.a;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.c(1, paramVarArgs.d());
      }
      return paramInt + com.tencent.luggage.wxa.sw.a.a(2, 8, this.b) + com.tencent.luggage.wxa.sw.a.b(3, this.c);
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
      if (this.a != null) {
        return 0;
      }
      throw new b("Not all required fields were included: base_response");
    }
    if (paramInt == 3)
    {
      Object localObject2 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      localObject1 = (ky)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return -1;
          }
          ((ky)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
          return 0;
        }
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ju();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((ju)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ky)localObject1).b.add(localObject2);
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
        localObject2 = new jn();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (bool = true; bool; bool = ((jn)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((ky)localObject1).a = ((jn)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.ky
 * JD-Core Version:    0.7.0.1
 */