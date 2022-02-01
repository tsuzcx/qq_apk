package com.tencent.luggage.wxa.qw;

public class dv
  extends com.tencent.luggage.wxa.qu.a
{
  public int a;
  public String b;
  public int c;
  public int d;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    Object localObject;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      paramVarArgs.b(1, this.a);
      localObject = this.b;
      if (localObject != null) {
        paramVarArgs.a(2, (String)localObject);
      }
      paramVarArgs.b(3, this.c);
      paramVarArgs.b(4, this.d);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = com.tencent.luggage.wxa.sw.a.b(1, this.a) + 0;
      paramVarArgs = this.b;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(2, paramVarArgs);
      }
      return paramInt + com.tencent.luggage.wxa.sw.a.b(3, this.c) + com.tencent.luggage.wxa.sw.a.b(4, this.d);
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
      dv localdv = (dv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return -1;
            }
            localdv.d = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
            return 0;
          }
          localdv.c = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
          return 0;
        }
        localdv.b = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      }
      localdv.a = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.dv
 * JD-Core Version:    0.7.0.1
 */