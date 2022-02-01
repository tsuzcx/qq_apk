package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.sw.b;
import java.util.LinkedList;

public class cz
  extends gu
{
  public ld a;
  public String b;
  public int c;
  public int d;
  public String e;
  public LinkedList<fm> f = new LinkedList();
  public int g;
  public String h;
  public String i;
  public int j;
  public String k;
  public String l;
  public String m;
  public String n;
  public int o;
  public int q;
  public fm r;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
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
        localObject1 = this.b;
        if (localObject1 != null) {
          paramVarArgs.a(3, (String)localObject1);
        }
        paramVarArgs.b(4, this.c);
        paramVarArgs.b(5, this.d);
        localObject1 = this.e;
        if (localObject1 != null) {
          paramVarArgs.a(6, (String)localObject1);
        }
        paramVarArgs.a(7, 8, this.f);
        paramVarArgs.b(8, this.g);
        localObject1 = this.h;
        if (localObject1 != null) {
          paramVarArgs.a(9, (String)localObject1);
        }
        localObject1 = this.i;
        if (localObject1 != null) {
          paramVarArgs.a(10, (String)localObject1);
        }
        paramVarArgs.b(11, this.j);
        localObject1 = this.k;
        if (localObject1 != null) {
          paramVarArgs.a(12, (String)localObject1);
        }
        localObject1 = this.l;
        if (localObject1 != null) {
          paramVarArgs.a(13, (String)localObject1);
        }
        localObject1 = this.m;
        if (localObject1 != null) {
          paramVarArgs.a(14, (String)localObject1);
        }
        localObject1 = this.n;
        if (localObject1 != null) {
          paramVarArgs.a(15, (String)localObject1);
        }
        paramVarArgs.b(16, this.o);
        paramVarArgs.b(17, this.q);
        localObject1 = this.r;
        if (localObject1 != null)
        {
          paramVarArgs.c(18, ((fm)localObject1).d());
          this.r.a(paramVarArgs);
        }
        return 0;
      }
      throw new b("Not all required fields were included: BaseResponse");
    }
    int i1;
    if (paramInt == 1)
    {
      if (this.z != null) {
        i1 = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.z.d());
      } else {
        i1 = 0;
      }
      paramVarArgs = this.a;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.c(2, paramVarArgs.d());
      }
      paramVarArgs = this.b;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(3, paramVarArgs);
      }
      i1 = i1 + com.tencent.luggage.wxa.sw.a.b(4, this.c) + com.tencent.luggage.wxa.sw.a.b(5, this.d);
      paramVarArgs = this.e;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(7, 8, this.f) + com.tencent.luggage.wxa.sw.a.b(8, this.g);
      paramVarArgs = this.h;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(9, paramVarArgs);
      }
      paramVarArgs = this.i;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(10, paramVarArgs);
      }
      i1 += com.tencent.luggage.wxa.sw.a.b(11, this.j);
      paramVarArgs = this.k;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(12, paramVarArgs);
      }
      paramVarArgs = this.l;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(13, paramVarArgs);
      }
      paramVarArgs = this.m;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(14, paramVarArgs);
      }
      paramVarArgs = this.n;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(15, paramVarArgs);
      }
      i1 = i1 + com.tencent.luggage.wxa.sw.a.b(16, this.o) + com.tencent.luggage.wxa.sw.a.b(17, this.q);
      paramVarArgs = this.r;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.c(18, paramVarArgs.d());
      }
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.f.clear();
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
      localObject1 = (cz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 18: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fm();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((fm)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((cz)localObject1).r = ((fm)localObject2);
          paramInt += 1;
        }
        return 0;
      case 17: 
        ((cz)localObject1).q = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 16: 
        ((cz)localObject1).o = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 15: 
        ((cz)localObject1).n = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 14: 
        ((cz)localObject1).m = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 13: 
        ((cz)localObject1).l = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 12: 
        ((cz)localObject1).k = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 11: 
        ((cz)localObject1).j = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 10: 
        ((cz)localObject1).i = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 9: 
        ((cz)localObject1).h = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 8: 
        ((cz)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 7: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fm();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((fm)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((cz)localObject1).f.add(localObject2);
          paramInt += 1;
        }
        return 0;
      case 6: 
        ((cz)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 5: 
        ((cz)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 4: 
        ((cz)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 3: 
        ((cz)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 2: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ld();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((ld)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((cz)localObject1).a = ((ld)localObject2);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
      i1 = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i1)
      {
        localObject3 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new aa();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (bool = true; bool; bool = ((aa)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((cz)localObject1).z = ((aa)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.cz
 * JD-Core Version:    0.7.0.1
 */