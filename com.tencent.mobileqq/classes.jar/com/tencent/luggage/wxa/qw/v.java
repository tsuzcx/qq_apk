package com.tencent.luggage.wxa.qw;

public class v
  extends com.tencent.luggage.wxa.qu.a
{
  public String a;
  public String b;
  
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
      return i;
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
      v localv = (v)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return -1;
        }
        localv.b = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      }
      localv.a = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.v
 * JD-Core Version:    0.7.0.1
 */