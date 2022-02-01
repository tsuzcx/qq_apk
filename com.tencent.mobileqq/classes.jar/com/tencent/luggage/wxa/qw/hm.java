package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.sw.b;
import java.util.LinkedList;

public class hm
  extends gu
{
  public LinkedList<dr> a = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      if (this.z != null)
      {
        if (this.z != null)
        {
          paramVarArgs.c(1, this.z.d());
          this.z.a(paramVarArgs);
        }
        paramVarArgs.a(2, 8, this.a);
        return 0;
      }
      throw new b("Not all required fields were included: BaseResponse");
    }
    if (paramInt == 1)
    {
      paramInt = i;
      if (this.z != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.z.d());
      }
      return paramInt + com.tencent.luggage.wxa.sw.a.a(2, 8, this.a);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.a.clear();
      paramVarArgs = new com.tencent.luggage.wxa.sx.a(paramVarArgs, p);
      for (paramInt = gu.a(paramVarArgs); paramInt > 0; paramInt = gu.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.b();
        }
      }
      if (this.z != null) {
        return 0;
      }
      throw new b("Not all required fields were included: BaseResponse");
    }
    if (paramInt == 3)
    {
      Object localObject1 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      hm localhm = (hm)paramVarArgs[1];
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
          localObject1 = new dr();
          localObject2 = new com.tencent.luggage.wxa.sx.a((byte[])localObject2, p);
          for (bool = true; bool; bool = ((dr)localObject1).a((com.tencent.luggage.wxa.sx.a)localObject2, (com.tencent.luggage.wxa.qu.a)localObject1, gu.a((com.tencent.luggage.wxa.sx.a)localObject2))) {}
          localhm.a.add(localObject1);
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
        localObject1 = new aa();
        localObject2 = new com.tencent.luggage.wxa.sx.a((byte[])localObject2, p);
        for (bool = true; bool; bool = ((aa)localObject1).a((com.tencent.luggage.wxa.sx.a)localObject2, (com.tencent.luggage.wxa.qu.a)localObject1, gu.a((com.tencent.luggage.wxa.sx.a)localObject2))) {}
        localhm.z = ((aa)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.hm
 * JD-Core Version:    0.7.0.1
 */