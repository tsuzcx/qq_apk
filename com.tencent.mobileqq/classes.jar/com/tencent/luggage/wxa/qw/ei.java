package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class ei
  extends com.tencent.luggage.wxa.qu.a
{
  public String a;
  public String b;
  public String c;
  public LinkedList<String> d = new LinkedList();
  public int e;
  public int f;
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
      localObject = this.c;
      if (localObject != null) {
        paramVarArgs.a(3, (String)localObject);
      }
      paramVarArgs.a(4, 1, this.d);
      paramVarArgs.b(5, this.e);
      paramVarArgs.b(6, this.f);
      localObject = this.g;
      if (localObject != null) {
        paramVarArgs.a(7, (String)localObject);
      }
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
      i = i + com.tencent.luggage.wxa.sw.a.a(4, 1, this.d) + com.tencent.luggage.wxa.sw.a.b(5, this.e) + com.tencent.luggage.wxa.sw.a.b(6, this.f);
      paramVarArgs = this.g;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(7, paramVarArgs);
      }
      return paramInt;
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
      ei localei = (ei)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 7: 
        localei.g = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 6: 
        localei.f = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 5: 
        localei.e = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 4: 
        localei.d.add(((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt));
        return 0;
      case 3: 
        localei.c = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 2: 
        localei.b = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      }
      localei.a = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.ei
 * JD-Core Version:    0.7.0.1
 */