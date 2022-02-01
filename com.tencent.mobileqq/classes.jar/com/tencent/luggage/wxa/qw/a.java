package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.qu.b;

public class a
  extends com.tencent.luggage.wxa.qu.a
{
  public boolean a;
  public boolean b;
  public int c;
  public boolean d;
  public b e;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    Object localObject;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      paramVarArgs.a(1, this.a);
      paramVarArgs.a(2, this.b);
      paramVarArgs.b(3, this.c);
      paramVarArgs.a(4, this.d);
      localObject = this.e;
      if (localObject != null) {
        paramVarArgs.a(5, (b)localObject);
      }
      return 0;
    }
    if (paramInt == 1)
    {
      int i = com.tencent.luggage.wxa.sw.a.a(1, this.a) + 0 + com.tencent.luggage.wxa.sw.a.a(2, this.b) + com.tencent.luggage.wxa.sw.a.b(3, this.c) + com.tencent.luggage.wxa.sw.a.a(4, this.d);
      paramVarArgs = this.e;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
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
      a locala = (a)paramVarArgs[1];
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
              locala.e = ((com.tencent.luggage.wxa.sx.a)localObject).h(paramInt);
              return 0;
            }
            locala.d = ((com.tencent.luggage.wxa.sx.a)localObject).d(paramInt);
            return 0;
          }
          locala.c = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
          return 0;
        }
        locala.b = ((com.tencent.luggage.wxa.sx.a)localObject).d(paramInt);
        return 0;
      }
      locala.a = ((com.tencent.luggage.wxa.sx.a)localObject).d(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.a
 * JD-Core Version:    0.7.0.1
 */