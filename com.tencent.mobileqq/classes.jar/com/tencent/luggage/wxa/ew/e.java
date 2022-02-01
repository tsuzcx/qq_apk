package com.tencent.luggage.wxa.ew;

import com.tencent.luggage.wxa.sw.b;

public class e
  extends com.tencent.luggage.wxa.qu.a
{
  public String a;
  public int b;
  public int c;
  public String d;
  public String e;
  public int f;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
    Object localObject;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      localObject = this.a;
      if (localObject != null)
      {
        if (localObject != null) {
          paramVarArgs.a(1, (String)localObject);
        }
        paramVarArgs.b(2, this.b);
        paramVarArgs.b(3, this.c);
        localObject = this.d;
        if (localObject != null) {
          paramVarArgs.a(4, (String)localObject);
        }
        localObject = this.e;
        if (localObject != null) {
          paramVarArgs.a(5, (String)localObject);
        }
        paramVarArgs.b(6, this.f);
        return 0;
      }
      throw new b("Not all required fields were included: sessionKey");
    }
    if (paramInt == 1)
    {
      paramVarArgs = this.a;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.a(1, paramVarArgs);
      }
      i = paramInt + com.tencent.luggage.wxa.sw.a.b(2, this.b) + com.tencent.luggage.wxa.sw.a.b(3, this.c);
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
      return i + com.tencent.luggage.wxa.sw.a.b(6, this.f);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new com.tencent.luggage.wxa.sx.a((byte[])paramVarArgs[0], p);
      for (paramInt = com.tencent.luggage.wxa.qu.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.luggage.wxa.qu.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.b();
        }
      }
      if (this.a != null) {
        return 0;
      }
      throw new b("Not all required fields were included: sessionKey");
    }
    if (paramInt == 3)
    {
      localObject = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 6: 
        locale.f = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 5: 
        locale.e = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 4: 
        locale.d = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 3: 
        locale.c = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 2: 
        locale.b = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      }
      locale.a = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ew.e
 * JD-Core Version:    0.7.0.1
 */