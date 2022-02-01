package com.tencent.luggage.wxa.qw;

public class mj
  extends com.tencent.luggage.wxa.qu.a
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  
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
      return 0;
    }
    if (paramInt == 1) {
      return com.tencent.luggage.wxa.sw.a.b(1, this.a) + 0 + com.tencent.luggage.wxa.sw.a.b(2, this.b) + com.tencent.luggage.wxa.sw.a.b(3, this.c) + com.tencent.luggage.wxa.sw.a.b(4, this.d) + com.tencent.luggage.wxa.sw.a.b(5, this.e);
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
      mj localmj = (mj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return -1;
              }
              localmj.e = locala.b(paramInt);
              return 0;
            }
            localmj.d = locala.b(paramInt);
            return 0;
          }
          localmj.c = locala.b(paramInt);
          return 0;
        }
        localmj.b = locala.b(paramInt);
        return 0;
      }
      localmj.a = locala.b(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.mj
 * JD-Core Version:    0.7.0.1
 */