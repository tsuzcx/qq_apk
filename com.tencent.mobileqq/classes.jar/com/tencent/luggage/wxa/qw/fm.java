package com.tencent.luggage.wxa.qw;

public class fm
  extends com.tencent.luggage.wxa.qu.a
{
  public String a;
  public String b;
  public String c;
  public String d;
  public int e;
  public int f;
  
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
      localObject = this.b;
      if (localObject != null) {
        paramVarArgs.a(2, (String)localObject);
      }
      localObject = this.c;
      if (localObject != null) {
        paramVarArgs.a(3, (String)localObject);
      }
      localObject = this.d;
      if (localObject != null) {
        paramVarArgs.a(4, (String)localObject);
      }
      paramVarArgs.b(5, this.e);
      paramVarArgs.b(6, this.f);
      return 0;
    }
    if (paramInt == 1)
    {
      paramVarArgs = this.a;
      if (paramVarArgs != null) {
        i = 0 + com.tencent.luggage.wxa.sw.a.a(1, paramVarArgs);
      }
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
      return paramInt + com.tencent.luggage.wxa.sw.a.b(5, this.e) + com.tencent.luggage.wxa.sw.a.b(6, this.f);
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
      fm localfm = (fm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 6: 
        localfm.f = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 5: 
        localfm.e = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 4: 
        localfm.d = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 3: 
        localfm.c = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 2: 
        localfm.b = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      }
      localfm.a = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.fm
 * JD-Core Version:    0.7.0.1
 */