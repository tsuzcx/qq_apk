package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.qu.b;
import java.util.LinkedList;

public class nm
  extends gt
{
  public String a;
  public String b;
  public int c;
  public b d;
  public String e;
  public int f;
  public String g;
  public String h;
  public int i;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int j = 0;
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
      if (localObject1 != null) {
        paramVarArgs.a(3, (String)localObject1);
      }
      paramVarArgs.b(4, this.c);
      localObject1 = this.d;
      if (localObject1 != null) {
        paramVarArgs.a(5, (b)localObject1);
      }
      localObject1 = this.e;
      if (localObject1 != null) {
        paramVarArgs.a(6, (String)localObject1);
      }
      paramVarArgs.b(7, this.f);
      localObject1 = this.g;
      if (localObject1 != null) {
        paramVarArgs.a(8, (String)localObject1);
      }
      localObject1 = this.h;
      if (localObject1 != null) {
        paramVarArgs.a(9, (String)localObject1);
      }
      paramVarArgs.b(10, this.i);
      return 0;
    }
    if (paramInt == 1)
    {
      if (this.B != null) {
        j = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.B.d());
      }
      paramVarArgs = this.a;
      paramInt = j;
      if (paramVarArgs != null) {
        paramInt = j + com.tencent.luggage.wxa.sw.a.a(2, paramVarArgs);
      }
      paramVarArgs = this.b;
      j = paramInt;
      if (paramVarArgs != null) {
        j = paramInt + com.tencent.luggage.wxa.sw.a.a(3, paramVarArgs);
      }
      j += com.tencent.luggage.wxa.sw.a.b(4, this.c);
      paramVarArgs = this.d;
      paramInt = j;
      if (paramVarArgs != null) {
        paramInt = j + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      paramVarArgs = this.e;
      j = paramInt;
      if (paramVarArgs != null) {
        j = paramInt + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
      }
      j += com.tencent.luggage.wxa.sw.a.b(7, this.f);
      paramVarArgs = this.g;
      paramInt = j;
      if (paramVarArgs != null) {
        paramInt = j + com.tencent.luggage.wxa.sw.a.a(8, paramVarArgs);
      }
      paramVarArgs = this.h;
      j = paramInt;
      if (paramVarArgs != null) {
        j = paramInt + com.tencent.luggage.wxa.sw.a.a(9, paramVarArgs);
      }
      return j + com.tencent.luggage.wxa.sw.a.b(10, this.i);
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
      localObject1 = (nm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 10: 
        ((nm)localObject1).i = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 9: 
        ((nm)localObject1).h = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 8: 
        ((nm)localObject1).g = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 7: 
        ((nm)localObject1).f = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 6: 
        ((nm)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 5: 
        ((nm)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).h(paramInt);
        return 0;
      case 4: 
        ((nm)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
        return 0;
      case 3: 
        ((nm)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      case 2: 
        ((nm)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).c(paramInt);
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
      j = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < j)
      {
        Object localObject3 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new z();
        localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
        for (boolean bool = true; bool; bool = ((z)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, gt.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
        ((nm)localObject1).B = ((z)localObject2);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.nm
 * JD-Core Version:    0.7.0.1
 */