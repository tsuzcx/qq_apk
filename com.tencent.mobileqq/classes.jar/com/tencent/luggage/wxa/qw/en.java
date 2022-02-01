package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.sw.b;
import java.util.LinkedList;

public class en
  extends gu
{
  public dy a;
  public LinkedList<hn> b = new LinkedList();
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public f h;
  
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
          paramVarArgs.c(2, ((dy)localObject1).d());
          this.a.a(paramVarArgs);
        }
        paramVarArgs.a(3, 8, this.b);
        localObject1 = this.c;
        if (localObject1 != null) {
          paramVarArgs.a(4, (String)localObject1);
        }
        localObject1 = this.d;
        if (localObject1 != null) {
          paramVarArgs.a(5, (String)localObject1);
        }
        localObject1 = this.e;
        if (localObject1 != null) {
          paramVarArgs.a(6, (String)localObject1);
        }
        localObject1 = this.f;
        if (localObject1 != null) {
          paramVarArgs.a(7, (String)localObject1);
        }
        localObject1 = this.g;
        if (localObject1 != null) {
          paramVarArgs.a(8, (String)localObject1);
        }
        localObject1 = this.h;
        if (localObject1 != null)
        {
          paramVarArgs.c(9, ((f)localObject1).d());
          this.h.a(paramVarArgs);
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
      i += com.tencent.luggage.wxa.sw.a.a(3, 8, this.b);
      paramVarArgs = this.c;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(4, paramVarArgs);
      }
      paramVarArgs = this.d;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      paramVarArgs = this.e;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
      }
      paramVarArgs = this.f;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(7, paramVarArgs);
      }
      paramVarArgs = this.g;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(8, paramVarArgs);
      }
      paramVarArgs = this.h;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.c(9, paramVarArgs.d());
      }
      return i;
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
      localObject1 = (en)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 9: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new f();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((f)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((en)localObject1).h = ((f)localObject2);
          paramInt += 1;
        }
        return 0;
      case 8: 
        ((en)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 7: 
        ((en)localObject1).f = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 6: 
        ((en)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 5: 
        ((en)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 4: 
        ((en)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 3: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new hn();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((hn)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((en)localObject1).b.add(localObject2);
          paramInt += 1;
        }
        return 0;
      case 2: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dy();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((dy)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((en)localObject1).a = ((dy)localObject2);
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
        ((en)localObject1).z = ((aa)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.en
 * JD-Core Version:    0.7.0.1
 */