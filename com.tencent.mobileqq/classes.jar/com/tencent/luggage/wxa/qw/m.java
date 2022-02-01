package com.tencent.luggage.wxa.qw;

public class m
  extends com.tencent.luggage.wxa.qu.a
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public boolean k;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      paramVarArgs.b(1, this.a);
      paramVarArgs.b(2, this.b);
      paramVarArgs.b(3, this.c);
      paramVarArgs.b(4, this.d);
      paramVarArgs.b(5, this.e);
      paramVarArgs.b(6, this.f);
      paramVarArgs.b(7, this.g);
      paramVarArgs.b(8, this.h);
      paramVarArgs.b(9, this.i);
      paramVarArgs.b(10, this.j);
      paramVarArgs.a(11, this.k);
      return 0;
    }
    if (paramInt == 1) {
      return com.tencent.luggage.wxa.sw.a.b(1, this.a) + 0 + com.tencent.luggage.wxa.sw.a.b(2, this.b) + com.tencent.luggage.wxa.sw.a.b(3, this.c) + com.tencent.luggage.wxa.sw.a.b(4, this.d) + com.tencent.luggage.wxa.sw.a.b(5, this.e) + com.tencent.luggage.wxa.sw.a.b(6, this.f) + com.tencent.luggage.wxa.sw.a.b(7, this.g) + com.tencent.luggage.wxa.sw.a.b(8, this.h) + com.tencent.luggage.wxa.sw.a.b(9, this.i) + com.tencent.luggage.wxa.sw.a.b(10, this.j) + com.tencent.luggage.wxa.sw.a.a(11, this.k);
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
      com.tencent.luggage.wxa.sx.a locala = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 11: 
        localm.k = locala.d(paramInt);
        return 0;
      case 10: 
        localm.j = locala.b(paramInt);
        return 0;
      case 9: 
        localm.i = locala.b(paramInt);
        return 0;
      case 8: 
        localm.h = locala.b(paramInt);
        return 0;
      case 7: 
        localm.g = locala.b(paramInt);
        return 0;
      case 6: 
        localm.f = locala.b(paramInt);
        return 0;
      case 5: 
        localm.e = locala.b(paramInt);
        return 0;
      case 4: 
        localm.d = locala.b(paramInt);
        return 0;
      case 3: 
        localm.c = locala.b(paramInt);
        return 0;
      case 2: 
        localm.b = locala.b(paramInt);
        return 0;
      }
      localm.a = locala.b(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.m
 * JD-Core Version:    0.7.0.1
 */