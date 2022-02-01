package com.tencent.luggage.wxa.qw;

public class l
  extends com.tencent.luggage.wxa.qu.a
{
  public long a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public String h;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    Object localObject;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      paramVarArgs.a(1, this.a);
      paramVarArgs.b(2, this.b);
      paramVarArgs.b(3, this.c);
      paramVarArgs.b(4, this.d);
      paramVarArgs.b(5, this.e);
      paramVarArgs.b(6, this.f);
      paramVarArgs.b(7, this.g);
      localObject = this.h;
      if (localObject != null) {
        paramVarArgs.a(8, (String)localObject);
      }
      return 0;
    }
    if (paramInt == 1)
    {
      int i = com.tencent.luggage.wxa.sw.a.a(1, this.a) + 0 + com.tencent.luggage.wxa.sw.a.b(2, this.b) + com.tencent.luggage.wxa.sw.a.b(3, this.c) + com.tencent.luggage.wxa.sw.a.b(4, this.d) + com.tencent.luggage.wxa.sw.a.b(5, this.e) + com.tencent.luggage.wxa.sw.a.b(6, this.f) + com.tencent.luggage.wxa.sw.a.b(7, this.g);
      paramVarArgs = this.h;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(8, paramVarArgs);
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
      l locall = (l)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 8: 
        locall.h = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 7: 
        locall.g = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 6: 
        locall.f = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 5: 
        locall.e = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 4: 
        locall.d = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 3: 
        locall.c = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 2: 
        locall.b = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      }
      locall.a = ((com.tencent.luggage.wxa.sx.a)localObject).g(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.l
 * JD-Core Version:    0.7.0.1
 */