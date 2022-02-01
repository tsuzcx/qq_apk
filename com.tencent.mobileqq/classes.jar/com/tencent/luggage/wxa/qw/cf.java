package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.sw.b;
import java.util.LinkedList;

public class cf
  extends gu
{
  public hw a;
  public ma b;
  public ms c;
  public bh d;
  public mc e;
  public mz f;
  public nb g;
  public String h;
  public String i;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int j = 0;
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
          paramVarArgs.c(2, ((hw)localObject1).d());
          this.a.a(paramVarArgs);
        }
        localObject1 = this.b;
        if (localObject1 != null)
        {
          paramVarArgs.c(3, ((ma)localObject1).d());
          this.b.a(paramVarArgs);
        }
        localObject1 = this.c;
        if (localObject1 != null)
        {
          paramVarArgs.c(4, ((ms)localObject1).d());
          this.c.a(paramVarArgs);
        }
        localObject1 = this.d;
        if (localObject1 != null)
        {
          paramVarArgs.c(5, ((bh)localObject1).d());
          this.d.a(paramVarArgs);
        }
        localObject1 = this.e;
        if (localObject1 != null)
        {
          paramVarArgs.c(6, ((mc)localObject1).d());
          this.e.a(paramVarArgs);
        }
        localObject1 = this.f;
        if (localObject1 != null)
        {
          paramVarArgs.c(7, ((mz)localObject1).d());
          this.f.a(paramVarArgs);
        }
        localObject1 = this.g;
        if (localObject1 != null)
        {
          paramVarArgs.c(8, ((nb)localObject1).d());
          this.g.a(paramVarArgs);
        }
        localObject1 = this.h;
        if (localObject1 != null) {
          paramVarArgs.a(10, (String)localObject1);
        }
        localObject1 = this.i;
        if (localObject1 != null) {
          paramVarArgs.a(11, (String)localObject1);
        }
        return 0;
      }
      throw new b("Not all required fields were included: BaseResponse");
    }
    if (paramInt == 1)
    {
      if (this.z != null) {
        j = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.z.d());
      }
      paramVarArgs = this.a;
      paramInt = j;
      if (paramVarArgs != null) {
        paramInt = j + com.tencent.luggage.wxa.sw.a.c(2, paramVarArgs.d());
      }
      paramVarArgs = this.b;
      j = paramInt;
      if (paramVarArgs != null) {
        j = paramInt + com.tencent.luggage.wxa.sw.a.c(3, paramVarArgs.d());
      }
      paramVarArgs = this.c;
      paramInt = j;
      if (paramVarArgs != null) {
        paramInt = j + com.tencent.luggage.wxa.sw.a.c(4, paramVarArgs.d());
      }
      paramVarArgs = this.d;
      j = paramInt;
      if (paramVarArgs != null) {
        j = paramInt + com.tencent.luggage.wxa.sw.a.c(5, paramVarArgs.d());
      }
      paramVarArgs = this.e;
      paramInt = j;
      if (paramVarArgs != null) {
        paramInt = j + com.tencent.luggage.wxa.sw.a.c(6, paramVarArgs.d());
      }
      paramVarArgs = this.f;
      j = paramInt;
      if (paramVarArgs != null) {
        j = paramInt + com.tencent.luggage.wxa.sw.a.c(7, paramVarArgs.d());
      }
      paramVarArgs = this.g;
      paramInt = j;
      if (paramVarArgs != null) {
        paramInt = j + com.tencent.luggage.wxa.sw.a.c(8, paramVarArgs.d());
      }
      paramVarArgs = this.h;
      j = paramInt;
      if (paramVarArgs != null) {
        j = paramInt + com.tencent.luggage.wxa.sw.a.a(10, paramVarArgs);
      }
      paramVarArgs = this.i;
      paramInt = j;
      if (paramVarArgs != null) {
        paramInt = j + com.tencent.luggage.wxa.sw.a.a(11, paramVarArgs);
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
      if (this.z != null) {
        return 0;
      }
      throw new b("Not all required fields were included: BaseResponse");
    }
    if (paramInt == 3)
    {
      Object localObject2 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      localObject1 = (cf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      switch (paramInt)
      {
      case 9: 
      default: 
        return -1;
      case 11: 
        ((cf)localObject1).i = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 10: 
        ((cf)localObject1).h = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 8: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        j = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < j)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new nb();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((nb)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((cf)localObject1).g = ((nb)localObject2);
          paramInt += 1;
        }
        return 0;
      case 7: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        j = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < j)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new mz();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((mz)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((cf)localObject1).f = ((mz)localObject2);
          paramInt += 1;
        }
        return 0;
      case 6: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        j = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < j)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new mc();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((mc)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((cf)localObject1).e = ((mc)localObject2);
          paramInt += 1;
        }
        return 0;
      case 5: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        j = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < j)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bh();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((bh)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((cf)localObject1).d = ((bh)localObject2);
          paramInt += 1;
        }
        return 0;
      case 4: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        j = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < j)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ms();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((ms)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((cf)localObject1).c = ((ms)localObject2);
          paramInt += 1;
        }
        return 0;
      case 3: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        j = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < j)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ma();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((ma)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((cf)localObject1).b = ((ma)localObject2);
          paramInt += 1;
        }
        return 0;
      case 2: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        j = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < j)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new hw();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((hw)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((cf)localObject1).a = ((hw)localObject2);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
      j = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < j)
      {
        localObject3 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new aa();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (bool = true; bool; bool = ((aa)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((cf)localObject1).z = ((aa)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.cf
 * JD-Core Version:    0.7.0.1
 */