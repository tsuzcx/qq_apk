package com.tencent.luggage.wxa.ew;

import com.tencent.luggage.wxa.sw.b;
import java.util.LinkedList;

public class f
  extends com.tencent.luggage.wxa.qu.a
{
  public String a;
  public String b;
  public int c;
  public String d;
  public String e;
  public String f;
  public String g;
  public LinkedList<String> h = new LinkedList();
  public String i;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int j = 0;
    Object localObject;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      localObject = this.a;
      if (localObject != null)
      {
        if (this.b != null)
        {
          if (localObject != null) {
            paramVarArgs.a(1, (String)localObject);
          }
          localObject = this.b;
          if (localObject != null) {
            paramVarArgs.a(2, (String)localObject);
          }
          paramVarArgs.b(3, this.c);
          localObject = this.d;
          if (localObject != null) {
            paramVarArgs.a(4, (String)localObject);
          }
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
          paramVarArgs.a(8, 1, this.h);
          localObject = this.i;
          if (localObject != null) {
            paramVarArgs.a(9, (String)localObject);
          }
          return 0;
        }
        throw new b("Not all required fields were included: nickname");
      }
      throw new b("Not all required fields were included: openId");
    }
    if (paramInt == 1)
    {
      paramVarArgs = this.a;
      paramInt = j;
      if (paramVarArgs != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.a(1, paramVarArgs);
      }
      paramVarArgs = this.b;
      j = paramInt;
      if (paramVarArgs != null) {
        j = paramInt + com.tencent.luggage.wxa.sw.a.a(2, paramVarArgs);
      }
      j += com.tencent.luggage.wxa.sw.a.b(3, this.c);
      paramVarArgs = this.d;
      paramInt = j;
      if (paramVarArgs != null) {
        paramInt = j + com.tencent.luggage.wxa.sw.a.a(4, paramVarArgs);
      }
      paramVarArgs = this.e;
      j = paramInt;
      if (paramVarArgs != null) {
        j = paramInt + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      paramVarArgs = this.f;
      paramInt = j;
      if (paramVarArgs != null) {
        paramInt = j + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
      }
      paramVarArgs = this.g;
      j = paramInt;
      if (paramVarArgs != null) {
        j = paramInt + com.tencent.luggage.wxa.sw.a.a(7, paramVarArgs);
      }
      j += com.tencent.luggage.wxa.sw.a.a(8, 1, this.h);
      paramVarArgs = this.i;
      paramInt = j;
      if (paramVarArgs != null) {
        paramInt = j + com.tencent.luggage.wxa.sw.a.a(9, paramVarArgs);
      }
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.h.clear();
      paramVarArgs = new com.tencent.luggage.wxa.sx.a(paramVarArgs, p);
      for (paramInt = com.tencent.luggage.wxa.qu.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.luggage.wxa.qu.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.b();
        }
      }
      if (this.a != null)
      {
        if (this.b != null) {
          return 0;
        }
        throw new b("Not all required fields were included: nickname");
      }
      throw new b("Not all required fields were included: openId");
    }
    if (paramInt == 3)
    {
      localObject = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 9: 
        localf.i = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 8: 
        localf.h.add(((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt));
        return 0;
      case 7: 
        localf.g = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 6: 
        localf.f = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 5: 
        localf.e = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 4: 
        localf.d = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 3: 
        localf.c = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 2: 
        localf.b = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      }
      localf.a = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ew.f
 * JD-Core Version:    0.7.0.1
 */