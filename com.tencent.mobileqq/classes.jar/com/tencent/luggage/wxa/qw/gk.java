package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.sw.b;
import java.util.LinkedList;

public class gk
  extends gu
{
  public gh a;
  public int b;
  public String c;
  public int d;
  public String e;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      if (this.a != null)
      {
        if (this.z != null)
        {
          localObject1 = this.a;
          if (localObject1 != null)
          {
            paramVarArgs.c(1, ((gh)localObject1).d());
            this.a.a(paramVarArgs);
          }
          paramVarArgs.b(2, this.b);
          if (this.z != null)
          {
            paramVarArgs.c(3, this.z.d());
            this.z.a(paramVarArgs);
          }
          localObject1 = this.c;
          if (localObject1 != null) {
            paramVarArgs.a(4, (String)localObject1);
          }
          paramVarArgs.b(5, this.d);
          localObject1 = this.e;
          if (localObject1 != null) {
            paramVarArgs.a(6, (String)localObject1);
          }
          return 0;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      throw new b("Not all required fields were included: rcptinfolist");
    }
    if (paramInt == 1)
    {
      paramVarArgs = this.a;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.c(1, paramVarArgs.d());
      }
      i = paramInt + com.tencent.luggage.wxa.sw.a.b(2, this.b);
      paramInt = i;
      if (this.z != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.c(3, this.z.d());
      }
      paramVarArgs = this.c;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(4, paramVarArgs);
      }
      i += com.tencent.luggage.wxa.sw.a.b(5, this.d);
      paramVarArgs = this.e;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
      }
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new com.tencent.luggage.wxa.sx.a((byte[])paramVarArgs[0], p);
      for (paramInt = gu.a(paramVarArgs); paramInt > 0; paramInt = gu.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.b();
        }
      }
      if (this.a != null)
      {
        if (this.z != null) {
          return 0;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      throw new b("Not all required fields were included: rcptinfolist");
    }
    if (paramInt == 3)
    {
      Object localObject2 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      localObject1 = (gk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 6: 
        ((gk)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 5: 
        ((gk)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 4: 
        ((gk)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 3: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aa();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((aa)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((gk)localObject1).z = ((aa)localObject2);
          paramInt += 1;
        }
        return 0;
      case 2: 
        ((gk)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject3 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new gh();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (bool = true; bool; bool = ((gh)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((gk)localObject1).a = ((gh)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.gk
 * JD-Core Version:    0.7.0.1
 */