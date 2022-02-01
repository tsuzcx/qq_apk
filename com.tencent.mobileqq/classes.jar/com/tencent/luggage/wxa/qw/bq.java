package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.qu.b;
import java.util.LinkedList;

public class bq
  extends com.tencent.luggage.wxa.qu.a
{
  public int a;
  public String b;
  public String c;
  public int d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public int l;
  public int m;
  public int n;
  public b o;
  public LinkedList<ds> q = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      paramVarArgs.b(1, this.a);
      localObject1 = this.b;
      if (localObject1 != null) {
        paramVarArgs.a(2, (String)localObject1);
      }
      localObject1 = this.c;
      if (localObject1 != null) {
        paramVarArgs.a(3, (String)localObject1);
      }
      paramVarArgs.b(4, this.d);
      localObject1 = this.e;
      if (localObject1 != null) {
        paramVarArgs.a(5, (String)localObject1);
      }
      localObject1 = this.f;
      if (localObject1 != null) {
        paramVarArgs.a(6, (String)localObject1);
      }
      localObject1 = this.g;
      if (localObject1 != null) {
        paramVarArgs.a(7, (String)localObject1);
      }
      localObject1 = this.h;
      if (localObject1 != null) {
        paramVarArgs.a(8, (String)localObject1);
      }
      localObject1 = this.i;
      if (localObject1 != null) {
        paramVarArgs.a(10, (String)localObject1);
      }
      localObject1 = this.j;
      if (localObject1 != null) {
        paramVarArgs.a(11, (String)localObject1);
      }
      localObject1 = this.k;
      if (localObject1 != null) {
        paramVarArgs.a(12, (String)localObject1);
      }
      paramVarArgs.b(13, this.l);
      paramVarArgs.b(14, this.m);
      paramVarArgs.b(15, this.n);
      localObject1 = this.o;
      if (localObject1 != null) {
        paramVarArgs.a(16, (b)localObject1);
      }
      paramVarArgs.a(17, 8, this.q);
      return 0;
    }
    int i1;
    if (paramInt == 1)
    {
      i1 = com.tencent.luggage.wxa.sw.a.b(1, this.a) + 0;
      paramVarArgs = this.b;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(2, paramVarArgs);
      }
      paramVarArgs = this.c;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(3, paramVarArgs);
      }
      i1 += com.tencent.luggage.wxa.sw.a.b(4, this.d);
      paramVarArgs = this.e;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      paramVarArgs = this.f;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
      }
      paramVarArgs = this.g;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(7, paramVarArgs);
      }
      paramVarArgs = this.h;
      i1 = paramInt;
      if (paramVarArgs != null) {
        i1 = paramInt + com.tencent.luggage.wxa.sw.a.a(8, paramVarArgs);
      }
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
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(12, paramVarArgs);
      }
      i1 = paramInt + com.tencent.luggage.wxa.sw.a.b(13, this.l) + com.tencent.luggage.wxa.sw.a.b(14, this.m) + com.tencent.luggage.wxa.sw.a.b(15, this.n);
      paramVarArgs = this.o;
      paramInt = i1;
      if (paramVarArgs != null) {
        paramInt = i1 + com.tencent.luggage.wxa.sw.a.a(16, paramVarArgs);
      }
      return paramInt + com.tencent.luggage.wxa.sw.a.a(17, 8, this.q);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.q.clear();
      paramVarArgs = new com.tencent.luggage.wxa.sx.a(paramVarArgs, p);
      for (paramInt = com.tencent.luggage.wxa.qu.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.luggage.wxa.qu.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.b();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject2 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      localObject1 = (bq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 9: 
      default: 
        return -1;
      case 17: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i1 = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i1)
        {
          Object localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ds();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (boolean bool = true; bool; bool = ((ds)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((bq)localObject1).q.add(localObject2);
          paramInt += 1;
        }
        return 0;
      case 16: 
        ((bq)localObject1).o = ((com.tencent.luggage.wxa.sx.a)localObject2).h(paramInt);
        return 0;
      case 15: 
        ((bq)localObject1).n = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 14: 
        ((bq)localObject1).m = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 13: 
        ((bq)localObject1).l = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 12: 
        ((bq)localObject1).k = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 11: 
        ((bq)localObject1).j = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 10: 
        ((bq)localObject1).i = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 8: 
        ((bq)localObject1).h = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 7: 
        ((bq)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 6: 
        ((bq)localObject1).f = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 5: 
        ((bq)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 4: 
        ((bq)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 3: 
        ((bq)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 2: 
        ((bq)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      }
      ((bq)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.bq
 * JD-Core Version:    0.7.0.1
 */