package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.sw.b;
import java.util.LinkedList;

public class ia
  extends gu
{
  public t a;
  public int b;
  public s c;
  public String d;
  public String e;
  public String f;
  public String g;
  public LinkedList<u> h = new LinkedList();
  public String i;
  public String j;
  public v k;
  public LinkedList<v> l = new LinkedList();
  public String m;
  public jk n;
  public boolean o;
  public String q;
  public r r;
  
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
          paramVarArgs.c(2, ((t)localObject1).d());
          this.a.a(paramVarArgs);
        }
        paramVarArgs.b(3, this.b);
        localObject1 = this.c;
        if (localObject1 != null)
        {
          paramVarArgs.c(4, ((s)localObject1).d());
          this.c.a(paramVarArgs);
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
        paramVarArgs.a(9, 8, this.h);
        localObject1 = this.i;
        if (localObject1 != null) {
          paramVarArgs.a(10, (String)localObject1);
        }
        localObject1 = this.j;
        if (localObject1 != null) {
          paramVarArgs.a(11, (String)localObject1);
        }
        localObject1 = this.k;
        if (localObject1 != null)
        {
          paramVarArgs.c(12, ((v)localObject1).d());
          this.k.a(paramVarArgs);
        }
        paramVarArgs.a(13, 8, this.l);
        localObject1 = this.m;
        if (localObject1 != null) {
          paramVarArgs.a(14, (String)localObject1);
        }
        localObject1 = this.n;
        if (localObject1 != null)
        {
          paramVarArgs.c(15, ((jk)localObject1).d());
          this.n.a(paramVarArgs);
        }
        paramVarArgs.a(16, this.o);
        localObject1 = this.q;
        if (localObject1 != null) {
          paramVarArgs.a(17, (String)localObject1);
        }
        localObject1 = this.r;
        if (localObject1 != null)
        {
          paramVarArgs.c(19, ((r)localObject1).d());
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
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.z.d());
      } else {
        paramInt = 0;
      }
      paramVarArgs = this.a;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.c(2, paramVarArgs.d());
      }
      i1 += com.tencent.luggage.wxa.sw.a.b(3, this.b);
      paramVarArgs = this.c;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.c(4, paramVarArgs.d());
      }
      paramVarArgs = this.d;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      paramVarArgs = this.e;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
      }
      paramVarArgs = this.f;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(7, paramVarArgs);
      }
      paramVarArgs = this.g;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(8, paramVarArgs);
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(9, 8, this.h);
      paramVarArgs = this.i;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(10, paramVarArgs);
      }
      paramVarArgs = this.j;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(11, paramVarArgs);
      }
      paramVarArgs = this.k;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.c(12, paramVarArgs.d());
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(13, 8, this.l);
      paramVarArgs = this.m;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(14, paramVarArgs);
      }
      paramVarArgs = this.n;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.c(15, paramVarArgs.d());
      }
      i1 += com.tencent.luggage.wxa.sw.a.a(16, this.o);
      paramVarArgs = this.q;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(17, paramVarArgs);
      }
      paramVarArgs = this.r;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.c(19, paramVarArgs.d());
      }
      return i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.h.clear();
      this.l.clear();
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
      localObject1 = (ia)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject3;
      boolean bool;
      switch (paramInt)
      {
      case 18: 
      default: 
        return -1;
      case 19: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new r();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((r)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ia)localObject1).r = ((r)localObject2);
          paramInt += 1;
        }
        return 0;
      case 17: 
        ((ia)localObject1).q = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 16: 
        ((ia)localObject1).o = ((com.tencent.luggage.wxa.sx.a)localObject2).d(paramInt);
        return 0;
      case 15: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new jk();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((jk)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ia)localObject1).n = ((jk)localObject2);
          paramInt += 1;
        }
        return 0;
      case 14: 
        ((ia)localObject1).m = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 13: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new v();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((v)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ia)localObject1).l.add(localObject2);
          paramInt += 1;
        }
        return 0;
      case 12: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new v();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((v)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ia)localObject1).k = ((v)localObject2);
          paramInt += 1;
        }
        return 0;
      case 11: 
        ((ia)localObject1).j = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 10: 
        ((ia)localObject1).i = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 9: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new u();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((u)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ia)localObject1).h.add(localObject2);
          paramInt += 1;
        }
        return 0;
      case 8: 
        ((ia)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 7: 
        ((ia)localObject1).f = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 6: 
        ((ia)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 5: 
        ((ia)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 4: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new s();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((s)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ia)localObject1).c = ((s)localObject2);
          paramInt += 1;
        }
        return 0;
      case 3: 
        ((ia)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 2: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new t();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (bool = true; bool; bool = ((t)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gu.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((ia)localObject1).a = ((t)localObject2);
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
        ((ia)localObject1).z = ((aa)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.ia
 * JD-Core Version:    0.7.0.1
 */