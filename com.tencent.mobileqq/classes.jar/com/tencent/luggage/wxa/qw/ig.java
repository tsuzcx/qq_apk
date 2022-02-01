package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.sw.b;
import java.util.LinkedList;

public class ig
  extends gu
{
  public t a;
  public int b;
  public x c;
  public String d;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
    Object localObject1;
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
        localObject1 = this.a;
        if (localObject1 != null)
        {
          paramVarArgs.c(2, ((t)localObject1).d());
          this.a.a(paramVarArgs);
        }
        paramVarArgs.b(3, this.b);
        localObject1 = this.c;
        if (localObject1 != null)
        {
          paramVarArgs.c(4, ((x)localObject1).d());
          this.c.a(paramVarArgs);
        }
        localObject1 = this.d;
        if (localObject1 != null) {
          paramVarArgs.a(5, (String)localObject1);
        }
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
      paramVarArgs = this.a;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.c(2, paramVarArgs.d());
      }
      i += com.tencent.luggage.wxa.sw.a.b(3, this.b);
      paramVarArgs = this.c;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.c(4, paramVarArgs.d());
      }
      paramVarArgs = this.d;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new com.tencent.luggage.wxa.sx.a((byte[])paramVarArgs[0], p);
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
      Object localObject2 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      localObject1 = (ig)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
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
              ((ig)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
              return 0;
            }
            paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
            i = paramVarArgs.size();
            paramInt = 0;
            while (paramInt < i)
            {
              localObject3 = (byte[])paramVarArgs.get(paramInt);
              localObject2 = new x();
              localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
              for (bool = true; bool; bool = ((x)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
              ((ig)localObject1).c = ((x)localObject2);
              paramInt += 1;
            }
            return 0;
          }
          ((ig)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
          return 0;
        }
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new t();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((t)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ig)localObject1).a = ((t)localObject2);
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
        localObject2 = new aa();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (bool = true; bool; bool = ((aa)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((ig)localObject1).z = ((aa)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.ig
 * JD-Core Version:    0.7.0.1
 */