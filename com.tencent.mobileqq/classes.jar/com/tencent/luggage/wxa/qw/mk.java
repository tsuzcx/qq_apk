package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.qu.b;

public class mk
  extends com.tencent.luggage.wxa.qu.a
{
  public boolean a;
  public String b;
  public b c;
  public int d;
  public int e;
  public int f;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    Object localObject;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      paramVarArgs.a(1, this.a);
      localObject = this.b;
      if (localObject != null) {
        paramVarArgs.a(2, (String)localObject);
      }
      localObject = this.c;
      if (localObject != null) {
        paramVarArgs.a(3, (b)localObject);
      }
      paramVarArgs.b(4, this.d);
      paramVarArgs.b(5, this.e);
      paramVarArgs.b(6, this.f);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = com.tencent.luggage.wxa.sw.a.a(1, this.a) + 0;
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
      return i + com.tencent.luggage.wxa.sw.a.b(4, this.d) + com.tencent.luggage.wxa.sw.a.b(5, this.e) + com.tencent.luggage.wxa.sw.a.b(6, this.f);
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
      localObject = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      mk localmk = (mk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 6: 
        localmk.f = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 5: 
        localmk.e = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 4: 
        localmk.d = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 3: 
        localmk.c = ((com.tencent.luggage.wxa.sx.a)localObject).h(paramInt);
        return 0;
      case 2: 
        localmk.b = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      }
      localmk.a = ((com.tencent.luggage.wxa.sx.a)localObject).d(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.mk
 * JD-Core Version:    0.7.0.1
 */