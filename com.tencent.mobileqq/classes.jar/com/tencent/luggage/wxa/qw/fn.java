package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class fn
  extends com.tencent.luggage.wxa.qu.a
{
  public LinkedList<String> a = new LinkedList();
  public LinkedList<String> b = new LinkedList();
  public LinkedList<String> c = new LinkedList();
  public LinkedList<String> d = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      paramVarArgs.a(5, 1, this.a);
      paramVarArgs.a(6, 1, this.b);
      paramVarArgs.a(7, 1, this.c);
      paramVarArgs.a(8, 1, this.d);
      return 0;
    }
    if (paramInt == 1) {
      return com.tencent.luggage.wxa.sw.a.a(5, 1, this.a) + 0 + com.tencent.luggage.wxa.sw.a.a(6, 1, this.b) + com.tencent.luggage.wxa.sw.a.a(7, 1, this.c) + com.tencent.luggage.wxa.sw.a.a(8, 1, this.d);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.a.clear();
      this.b.clear();
      this.c.clear();
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
      com.tencent.luggage.wxa.sx.a locala = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      fn localfn = (fn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      if (paramInt != 5)
      {
        if (paramInt != 6)
        {
          if (paramInt != 7)
          {
            if (paramInt != 8) {
              return -1;
            }
            localfn.d.add(locala.c(paramInt));
            return 0;
          }
          localfn.c.add(locala.c(paramInt));
          return 0;
        }
        localfn.b.add(locala.c(paramInt));
        return 0;
      }
      localfn.a.add(locala.c(paramInt));
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.fn
 * JD-Core Version:    0.7.0.1
 */