package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.sw.b;
import java.util.LinkedList;

public class fd
  extends gu
{
  public la a;
  public as b;
  public lb c;
  public nr d;
  
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
          paramVarArgs.c(2, ((la)localObject1).d());
          this.a.a(paramVarArgs);
        }
        localObject1 = this.b;
        if (localObject1 != null)
        {
          paramVarArgs.c(3, ((as)localObject1).d());
          this.b.a(paramVarArgs);
        }
        localObject1 = this.c;
        if (localObject1 != null)
        {
          paramVarArgs.c(4, ((lb)localObject1).d());
          this.c.a(paramVarArgs);
        }
        localObject1 = this.d;
        if (localObject1 != null)
        {
          paramVarArgs.c(5, ((nr)localObject1).d());
          this.d.a(paramVarArgs);
        }
        return 0;
      }
      throw new b("Not all required fields were included: BaseResponse");
    }
    if (paramInt == 1)
    {
      if (this.z != null) {
        i = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.z.d());
      }
      paramVarArgs = this.a;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.c(2, paramVarArgs.d());
      }
      paramVarArgs = this.b;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.c(3, paramVarArgs.d());
      }
      paramVarArgs = this.c;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.c(4, paramVarArgs.d());
      }
      paramVarArgs = this.d;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.c(5, paramVarArgs.d());
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
      localObject1 = (fd)paramVarArgs[1];
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
              paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
              i = paramVarArgs.size();
              paramInt = 0;
              while (paramInt < i)
              {
                localObject3 = (byte[])paramVarArgs.get(paramInt);
                localObject2 = new nr();
                localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
                for (bool = true; bool; bool = ((nr)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
                ((fd)localObject1).d = ((nr)localObject2);
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
              localObject2 = new lb();
              localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
              for (bool = true; bool; bool = ((lb)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
              ((fd)localObject1).c = ((lb)localObject2);
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
            localObject2 = new as();
            localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
            for (bool = true; bool; bool = ((as)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
            ((fd)localObject1).b = ((as)localObject2);
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
          localObject2 = new la();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((la)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((fd)localObject1).a = ((la)localObject2);
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
        ((fd)localObject1).z = ((aa)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.fd
 * JD-Core Version:    0.7.0.1
 */