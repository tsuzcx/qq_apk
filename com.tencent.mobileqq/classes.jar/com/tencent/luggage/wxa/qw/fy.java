package com.tencent.luggage.wxa.qw;

public class fy
  extends com.tencent.luggage.wxa.qu.a
{
  public String a;
  public String b;
  public int c;
  public int d;
  public String e;
  public String f;
  public boolean g;
  public boolean h;
  public int i;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int j = 0;
    Object localObject;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      localObject = this.a;
      if (localObject != null) {
        paramVarArgs.a(1, (String)localObject);
      }
      localObject = this.b;
      if (localObject != null) {
        paramVarArgs.a(2, (String)localObject);
      }
      paramVarArgs.b(3, this.c);
      paramVarArgs.b(4, this.d);
      localObject = this.e;
      if (localObject != null) {
        paramVarArgs.a(5, (String)localObject);
      }
      localObject = this.f;
      if (localObject != null) {
        paramVarArgs.a(6, (String)localObject);
      }
      paramVarArgs.a(20, this.g);
      paramVarArgs.a(21, this.h);
      paramVarArgs.b(22, this.i);
      return 0;
    }
    if (paramInt == 1)
    {
      paramVarArgs = this.a;
      paramInt = j;
      if (paramVarArgs != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.a(1, paramVarArgs);
      }
      paramVarArgs = this.b;
      j = paramInt;
      if (paramVarArgs != null) {
        j = paramInt + com.tencent.luggage.wxa.sw.a.a(2, paramVarArgs);
      }
      j = j + com.tencent.luggage.wxa.sw.a.b(3, this.c) + com.tencent.luggage.wxa.sw.a.b(4, this.d);
      paramVarArgs = this.e;
      paramInt = j;
      if (paramVarArgs != null) {
        paramInt = j + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      paramVarArgs = this.f;
      j = paramInt;
      if (paramVarArgs != null) {
        j = paramInt + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
      }
      return j + com.tencent.luggage.wxa.sw.a.a(20, this.g) + com.tencent.luggage.wxa.sw.a.a(21, this.h) + com.tencent.luggage.wxa.sw.a.b(22, this.i);
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
      fy localfy = (fy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          return -1;
        case 22: 
          localfy.i = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
          return 0;
        case 21: 
          localfy.h = ((com.tencent.luggage.wxa.sx.a)localObject).d(paramInt);
          return 0;
        }
        localfy.g = ((com.tencent.luggage.wxa.sx.a)localObject).d(paramInt);
        return 0;
      case 6: 
        localfy.f = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 5: 
        localfy.e = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 4: 
        localfy.d = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 3: 
        localfy.c = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 2: 
        localfy.b = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      }
      localfy.a = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.fy
 * JD-Core Version:    0.7.0.1
 */