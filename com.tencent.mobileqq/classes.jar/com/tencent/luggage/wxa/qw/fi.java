package com.tencent.luggage.wxa.qw;

import com.tencent.luggage.wxa.qu.b;
import java.util.LinkedList;

public class fi
  extends com.tencent.luggage.wxa.qu.a
{
  public LinkedList<b> a = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      ((com.tencent.luggage.wxa.tc.a)paramVarArgs[0]).a(1, 6, this.a);
      return 0;
    }
    if (paramInt == 1) {
      return com.tencent.luggage.wxa.sw.a.a(1, 6, this.a) + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.a.clear();
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
      fi localfi = (fi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      if (paramInt != 1) {
        return -1;
      }
      localfi.a.add(locala.h(paramInt));
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.fi
 * JD-Core Version:    0.7.0.1
 */