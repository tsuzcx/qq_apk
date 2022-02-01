package com.tencent.luggage.wxa.qw;

public class bg
  extends com.tencent.luggage.wxa.qu.a
{
  public int a;
  public int b;
  public int c;
  public String d;
  public String e;
  public String f;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    Object localObject;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      paramVarArgs.b(1, this.a);
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
      localObject = this.f;
      if (localObject != null) {
        paramVarArgs.a(6, (String)localObject);
      }
      return 0;
    }
    if (paramInt == 1)
    {
      int i = com.tencent.luggage.wxa.sw.a.b(1, this.a) + 0 + com.tencent.luggage.wxa.sw.a.b(2, this.b) + com.tencent.luggage.wxa.sw.a.b(3, this.c);
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
      bg localbg = (bg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 6: 
        localbg.f = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 5: 
        localbg.e = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 4: 
        localbg.d = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 3: 
        localbg.c = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 2: 
        localbg.b = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      }
      localbg.a = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.bg
 * JD-Core Version:    0.7.0.1
 */