package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.sw.b;
import java.util.LinkedList;

public class aa
  extends com.tencent.luggage.wxa.qu.a
{
  public int a;
  public hf b;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      if (this.b != null)
      {
        paramVarArgs.b(1, this.a);
        localObject1 = this.b;
        if (localObject1 != null)
        {
          paramVarArgs.c(2, ((hf)localObject1).d());
          this.b.a(paramVarArgs);
        }
        return 0;
      }
      throw new b("Not all required fields were included: ErrMsg");
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
      if (this.b != null) {
        return 0;
      }
      throw new b("Not all required fields were included: ErrMsg");
    }
    if (paramInt == 3)
    {
      Object localObject2 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      localObject1 = (aa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return -1;
        }
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new hf();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (boolean bool = true; bool; bool = ((hf)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((aa)localObject1).b = ((hf)localObject2);
          paramInt += 1;
        }
        return 0;
      }
      ((aa)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.aa
 * JD-Core Version:    0.7.0.1
 */