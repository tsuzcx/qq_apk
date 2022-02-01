package com.tencent.luggage.wxa.qw;

public class lo
  extends com.tencent.luggage.wxa.qu.a
{
  public String a;
  public int b;
  public int c;
  public long d;
  public boolean e;
  public String f;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
    Object localObject;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      localObject = this.a;
      if (localObject != null) {
        paramVarArgs.a(1, (String)localObject);
      }
      paramVarArgs.b(2, this.b);
      paramVarArgs.b(3, this.c);
      paramVarArgs.a(4, this.d);
      paramVarArgs.a(5, this.e);
      localObject = this.f;
      if (localObject != null) {
        paramVarArgs.a(6, (String)localObject);
      }
      return 0;
    }
    if (paramInt == 1)
    {
      paramVarArgs = this.a;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.a(1, paramVarArgs);
      }
      i = paramInt + com.tencent.luggage.wxa.sw.a.b(2, this.b) + com.tencent.luggage.wxa.sw.a.b(3, this.c) + com.tencent.luggage.wxa.sw.a.a(4, this.d) + com.tencent.luggage.wxa.sw.a.a(5, this.e);
      paramVarArgs = this.f;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
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
      localObject = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      lo locallo = (lo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 6: 
        locallo.f = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 5: 
        locallo.e = ((com.tencent.luggage.wxa.sx.a)localObject).d(paramInt);
        return 0;
      case 4: 
        locallo.d = ((com.tencent.luggage.wxa.sx.a)localObject).g(paramInt);
        return 0;
      case 3: 
        locallo.c = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 2: 
        locallo.b = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      }
      locallo.a = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.lo
 * JD-Core Version:    0.7.0.1
 */