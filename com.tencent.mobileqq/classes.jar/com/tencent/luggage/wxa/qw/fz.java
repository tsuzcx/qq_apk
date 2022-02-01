package com.tencent.luggage.wxa.qw;

public class fz
  extends com.tencent.luggage.wxa.qu.a
{
  public String a;
  public String b;
  public boolean c;
  public boolean d;
  public String e;
  public String f;
  public String g;
  
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
      paramVarArgs.a(3, this.c);
      paramVarArgs.a(4, this.d);
      localObject = this.e;
      if (localObject != null) {
        paramVarArgs.a(5, (String)localObject);
      }
      localObject = this.f;
      if (localObject != null) {
        paramVarArgs.a(6, (String)localObject);
      }
      localObject = this.g;
      if (localObject != null) {
        paramVarArgs.a(7, (String)localObject);
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
      paramVarArgs = this.b;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(2, paramVarArgs);
      }
      i = i + com.tencent.luggage.wxa.sw.a.a(3, this.c) + com.tencent.luggage.wxa.sw.a.a(4, this.d);
      paramVarArgs = this.e;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      paramVarArgs = this.f;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
      }
      paramVarArgs = this.g;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(7, paramVarArgs);
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
      fz localfz = (fz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 7: 
        localfz.g = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 6: 
        localfz.f = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 5: 
        localfz.e = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 4: 
        localfz.d = ((com.tencent.luggage.wxa.sx.a)localObject).d(paramInt);
        return 0;
      case 3: 
        localfz.c = ((com.tencent.luggage.wxa.sx.a)localObject).d(paramInt);
        return 0;
      case 2: 
        localfz.b = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      }
      localfz.a = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.fz
 * JD-Core Version:    0.7.0.1
 */