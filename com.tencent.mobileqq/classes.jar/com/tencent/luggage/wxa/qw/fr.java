package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.sw.b;
import java.util.LinkedList;

public class fr
  extends gu
{
  public LinkedList<fs> a = new LinkedList();
  public String b;
  public String c;
  public String d;
  public boolean e;
  public boolean f;
  public boolean g;
  
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
        paramVarArgs.a(3, 8, this.a);
        localObject1 = this.b;
        if (localObject1 != null) {
          paramVarArgs.a(4, (String)localObject1);
        }
        localObject1 = this.c;
        if (localObject1 != null) {
          paramVarArgs.a(5, (String)localObject1);
        }
        localObject1 = this.d;
        if (localObject1 != null) {
          paramVarArgs.a(6, (String)localObject1);
        }
        paramVarArgs.a(8, this.e);
        paramVarArgs.a(9, this.f);
        paramVarArgs.a(10, this.g);
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
      i = paramInt + com.tencent.luggage.wxa.sw.a.a(3, 8, this.a);
      paramVarArgs = this.b;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(4, paramVarArgs);
      }
      paramVarArgs = this.c;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      paramVarArgs = this.d;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
      }
      return paramInt + com.tencent.luggage.wxa.sw.a.a(8, this.e) + com.tencent.luggage.wxa.sw.a.a(9, this.f) + com.tencent.luggage.wxa.sw.a.a(10, this.g);
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
      Object localObject2 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      localObject1 = (fr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      switch (paramInt)
      {
      case 2: 
      case 7: 
      default: 
        return -1;
      case 10: 
        ((fr)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
        return 0;
      case 9: 
        ((fr)localObject1).f = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
        return 0;
      case 8: 
        ((fr)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
        return 0;
      case 6: 
        ((fr)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 5: 
        ((fr)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 4: 
        ((fr)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 3: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fs();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((fs)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((fr)localObject1).a.add(localObject2);
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
        ((fr)localObject1).z = ((aa)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.fr
 * JD-Core Version:    0.7.0.1
 */