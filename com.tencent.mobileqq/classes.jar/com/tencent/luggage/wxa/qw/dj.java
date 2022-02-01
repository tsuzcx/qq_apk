package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.sw.b;
import java.util.LinkedList;

public class dj
  extends gu
{
  public ld a;
  public LinkedList<mi> b = new LinkedList();
  public mi c;
  public String d;
  public int e;
  public String f;
  public String g;
  public String h;
  public String i;
  public int j;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int k = 0;
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
          paramVarArgs.c(2, ((ld)localObject1).d());
          this.a.a(paramVarArgs);
        }
        paramVarArgs.a(3, 8, this.b);
        localObject1 = this.c;
        if (localObject1 != null)
        {
          paramVarArgs.c(4, ((mi)localObject1).d());
          this.c.a(paramVarArgs);
        }
        localObject1 = this.d;
        if (localObject1 != null) {
          paramVarArgs.a(5, (String)localObject1);
        }
        paramVarArgs.b(6, this.e);
        localObject1 = this.f;
        if (localObject1 != null) {
          paramVarArgs.a(7, (String)localObject1);
        }
        localObject1 = this.g;
        if (localObject1 != null) {
          paramVarArgs.a(8, (String)localObject1);
        }
        localObject1 = this.h;
        if (localObject1 != null) {
          paramVarArgs.a(9, (String)localObject1);
        }
        localObject1 = this.i;
        if (localObject1 != null) {
          paramVarArgs.a(10, (String)localObject1);
        }
        paramVarArgs.b(11, this.j);
        return 0;
      }
      throw new b("Not all required fields were included: BaseResponse");
    }
    if (paramInt == 1)
    {
      paramInt = k;
      if (this.z != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.z.d());
      }
      paramVarArgs = this.a;
      k = paramInt;
      if (paramVarArgs != null) {
        k = paramInt + com.tencent.luggage.wxa.sw.a.c(2, paramVarArgs.d());
      }
      k += com.tencent.luggage.wxa.sw.a.a(3, 8, this.b);
      paramVarArgs = this.c;
      paramInt = k;
      if (paramVarArgs != null) {
        paramInt = k + com.tencent.luggage.wxa.sw.a.c(4, paramVarArgs.d());
      }
      paramVarArgs = this.d;
      k = paramInt;
      if (paramVarArgs != null) {
        k = paramInt + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      k += com.tencent.luggage.wxa.sw.a.b(6, this.e);
      paramVarArgs = this.f;
      paramInt = k;
      if (paramVarArgs != null) {
        paramInt = k + com.tencent.luggage.wxa.sw.a.a(7, paramVarArgs);
      }
      paramVarArgs = this.g;
      k = paramInt;
      if (paramVarArgs != null) {
        k = paramInt + com.tencent.luggage.wxa.sw.a.a(8, paramVarArgs);
      }
      paramVarArgs = this.h;
      paramInt = k;
      if (paramVarArgs != null) {
        paramInt = k + com.tencent.luggage.wxa.sw.a.a(9, paramVarArgs);
      }
      paramVarArgs = this.i;
      k = paramInt;
      if (paramVarArgs != null) {
        k = paramInt + com.tencent.luggage.wxa.sw.a.a(10, paramVarArgs);
      }
      return k + com.tencent.luggage.wxa.sw.a.b(11, this.j);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.b.clear();
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
      Object localObject2 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      localObject1 = (dj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 11: 
        ((dj)localObject1).j = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 10: 
        ((dj)localObject1).i = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 9: 
        ((dj)localObject1).h = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 8: 
        ((dj)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 7: 
        ((dj)localObject1).f = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 6: 
        ((dj)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 5: 
        ((dj)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 4: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        k = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < k)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new mi();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((mi)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((dj)localObject1).c = ((mi)localObject2);
          paramInt += 1;
        }
        return 0;
      case 3: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        k = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < k)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new mi();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((mi)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((dj)localObject1).b.add(localObject2);
          paramInt += 1;
        }
        return 0;
      case 2: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        k = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < k)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ld();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((ld)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((dj)localObject1).a = ((ld)localObject2);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
      k = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < k)
      {
        localObject3 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new aa();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (bool = true; bool; bool = ((aa)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((dj)localObject1).z = ((aa)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.dj
 * JD-Core Version:    0.7.0.1
 */