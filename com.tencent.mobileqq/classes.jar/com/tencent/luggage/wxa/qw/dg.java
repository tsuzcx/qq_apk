package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class dg
  extends gt
{
  public String a;
  public me b;
  public mf c;
  public mg d;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      if (this.B != null)
      {
        paramVarArgs.c(1, this.B.d());
        this.B.a(paramVarArgs);
      }
      localObject1 = this.a;
      if (localObject1 != null) {
        paramVarArgs.a(2, (String)localObject1);
      }
      localObject1 = this.b;
      if (localObject1 != null)
      {
        paramVarArgs.c(3, ((me)localObject1).d());
        this.b.a(paramVarArgs);
      }
      localObject1 = this.c;
      if (localObject1 != null)
      {
        paramVarArgs.c(6, ((mf)localObject1).d());
        this.c.a(paramVarArgs);
      }
      localObject1 = this.d;
      if (localObject1 != null)
      {
        paramVarArgs.c(7, ((mg)localObject1).d());
        this.d.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1)
    {
      if (this.B != null) {
        i = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.B.d());
      }
      paramVarArgs = this.a;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(2, paramVarArgs);
      }
      paramVarArgs = this.b;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.c(3, paramVarArgs.d());
      }
      paramVarArgs = this.c;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.c(6, paramVarArgs.d());
      }
      paramVarArgs = this.d;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.c(7, paramVarArgs.d());
      }
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new com.tencent.luggage.wxa.sx.a((byte[])paramVarArgs[0], p);
      for (paramInt = gt.a(paramVarArgs); paramInt > 0; paramInt = gt.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.b();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject2 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      localObject1 = (dg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 6)
            {
              if (paramInt != 7) {
                return -1;
              }
              paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
              i = paramVarArgs.size();
              paramInt = 0;
              while (paramInt < i)
              {
                localObject3 = (byte[])paramVarArgs.get(paramInt);
                localObject2 = new mg();
                localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
                for (bool = true; bool; bool = ((mg)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
                ((dg)localObject1).d = ((mg)localObject2);
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
              localObject2 = new mf();
              localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
              for (bool = true; bool; bool = ((mf)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
              ((dg)localObject1).c = ((mf)localObject2);
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
            localObject2 = new me();
            localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
            for (bool = true; bool; bool = ((me)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
            ((dg)localObject1).b = ((me)localObject2);
            paramInt += 1;
          }
          return 0;
        }
        ((dg)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject3 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new z();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (bool = true; bool; bool = ((z)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((dg)localObject1).B = ((z)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.dg
 * JD-Core Version:    0.7.0.1
 */