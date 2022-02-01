package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.qu.b;
import java.util.LinkedList;

public class hp
  extends com.tencent.luggage.wxa.qu.a
{
  public int a;
  public b b;
  public b c;
  public b d;
  public b e;
  public hq f;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    Object localObject1;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      paramVarArgs.b(1, this.a);
      localObject1 = this.b;
      if (localObject1 != null) {
        paramVarArgs.a(2, (b)localObject1);
      }
      localObject1 = this.c;
      if (localObject1 != null) {
        paramVarArgs.a(3, (b)localObject1);
      }
      localObject1 = this.d;
      if (localObject1 != null) {
        paramVarArgs.a(4, (b)localObject1);
      }
      localObject1 = this.e;
      if (localObject1 != null) {
        paramVarArgs.a(5, (b)localObject1);
      }
      localObject1 = this.f;
      if (localObject1 != null)
      {
        paramVarArgs.c(6, ((hq)localObject1).d());
        this.f.a(paramVarArgs);
      }
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = com.tencent.luggage.wxa.sw.a.b(1, this.a) + 0;
      paramVarArgs = this.b;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(2, paramVarArgs);
      }
      paramVarArgs = this.c;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(3, paramVarArgs);
      }
      paramVarArgs = this.d;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(4, paramVarArgs);
      }
      paramVarArgs = this.e;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      paramVarArgs = this.f;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.c(6, paramVarArgs.d());
      }
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new com.tencent.luggage.wxa.sx.a((byte[])paramVarArgs[0], p);
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
      localObject1 = (hp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 6: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject2).i(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject3 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new hq();
          localObject3 = new com.tencent.luggage.wxa.sx.a((byte[])localObject3, p);
          for (boolean bool = true; bool; bool = ((hq)localObject2).a((com.tencent.luggage.wxa.sx.a)localObject3, (com.tencent.luggage.wxa.qu.a)localObject2, com.tencent.luggage.wxa.qu.a.a((com.tencent.luggage.wxa.sx.a)localObject3))) {}
          ((hp)localObject1).f = ((hq)localObject2);
          paramInt += 1;
        }
        return 0;
      case 5: 
        ((hp)localObject1).e = ((com.tencent.luggage.wxa.sx.a)localObject2).h(paramInt);
        return 0;
      case 4: 
        ((hp)localObject1).d = ((com.tencent.luggage.wxa.sx.a)localObject2).h(paramInt);
        return 0;
      case 3: 
        ((hp)localObject1).c = ((com.tencent.luggage.wxa.sx.a)localObject2).h(paramInt);
        return 0;
      case 2: 
        ((hp)localObject1).b = ((com.tencent.luggage.wxa.sx.a)localObject2).h(paramInt);
        return 0;
      }
      ((hp)localObject1).a = ((com.tencent.luggage.wxa.sx.a)localObject2).b(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.hp
 * JD-Core Version:    0.7.0.1
 */