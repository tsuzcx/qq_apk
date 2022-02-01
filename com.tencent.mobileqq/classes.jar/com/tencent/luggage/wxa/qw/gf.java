package com.tencent.luggage.wxa.qw;

public class gf
  extends com.tencent.luggage.wxa.qu.a
{
  public boolean a;
  public String b;
  public String c;
  public int d;
  public int e;
  public String f;
  
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
        paramVarArgs.a(3, (String)localObject);
      }
      paramVarArgs.b(4, this.d);
      paramVarArgs.b(5, this.e);
      localObject = this.f;
      if (localObject != null) {
        paramVarArgs.a(6, (String)localObject);
      }
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
      i = i + com.tencent.luggage.wxa.sw.a.b(4, this.d) + com.tencent.luggage.wxa.sw.a.b(5, this.e);
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
      gf localgf = (gf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 6: 
        localgf.f = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 5: 
        localgf.e = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 4: 
        localgf.d = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 3: 
        localgf.c = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 2: 
        localgf.b = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      }
      localgf.a = ((com.tencent.luggage.wxa.sx.a)localObject).d(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.gf
 * JD-Core Version:    0.7.0.1
 */