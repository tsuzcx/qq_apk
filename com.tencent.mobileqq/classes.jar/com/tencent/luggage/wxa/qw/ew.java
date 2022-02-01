package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class ew
  extends com.tencent.luggage.wxa.qu.a
{
  public String a;
  public int b;
  public String c;
  public LinkedList<String> d = new LinkedList();
  
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
      paramVarArgs.b(2, this.b);
      localObject = this.c;
      if (localObject != null) {
        paramVarArgs.a(3, (String)localObject);
      }
      paramVarArgs.a(4, 1, this.d);
      return 0;
    }
    if (paramInt == 1)
    {
      paramVarArgs = this.a;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.a(1, paramVarArgs);
      }
      i = paramInt + com.tencent.luggage.wxa.sw.a.b(2, this.b);
      paramVarArgs = this.c;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(3, paramVarArgs);
      }
      return paramInt + com.tencent.luggage.wxa.sw.a.a(4, 1, this.d);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.d.clear();
      paramVarArgs = new com.tencent.luggage.wxa.sx.a(paramVarArgs, p);
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
      ew localew = (ew)paramVarArgs[1];
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
            localew.d.add(((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt));
            return 0;
          }
          localew.c = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
          return 0;
        }
        localew.b = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      }
      localew.a = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.ew
 * JD-Core Version:    0.7.0.1
 */