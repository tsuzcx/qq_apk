package com.tencent.luggage.wxa.qw;

public class bi
  extends com.tencent.luggage.wxa.qu.a
{
  public String a;
  public int b;
  public int c;
  public com.tencent.luggage.wxa.qu.b d;
  public String e;
  public String f;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
    Object localObject;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      localObject = this.a;
      if (localObject != null)
      {
        if (this.d != null)
        {
          if (this.f != null)
          {
            if (localObject != null) {
              paramVarArgs.a(1, (String)localObject);
            }
            paramVarArgs.b(2, this.b);
            paramVarArgs.b(3, this.c);
            localObject = this.d;
            if (localObject != null) {
              paramVarArgs.a(4, (com.tencent.luggage.wxa.qu.b)localObject);
            }
            localObject = this.e;
            if (localObject != null) {
              paramVarArgs.a(5, (String)localObject);
            }
            localObject = this.f;
            if (localObject != null) {
              paramVarArgs.a(6, (String)localObject);
            }
            return 0;
          }
          throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: EventInfo");
        }
        throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: Data");
      }
      throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: AppId");
    }
    if (paramInt == 1)
    {
      paramVarArgs = this.a;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.a(1, paramVarArgs);
      }
      i = paramInt + com.tencent.luggage.wxa.sw.a.b(2, this.b) + com.tencent.luggage.wxa.sw.a.b(3, this.c);
      paramVarArgs = this.d;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(4, paramVarArgs);
      }
      paramVarArgs = this.e;
      i = paramInt;
      if (paramVarArgs != null) {
        i = paramInt + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      paramVarArgs = this.f;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(6, paramVarArgs);
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
      if (this.a != null)
      {
        if (this.d != null)
        {
          if (this.f != null) {
            return 0;
          }
          throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: EventInfo");
        }
        throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: Data");
      }
      throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: AppId");
    }
    if (paramInt == 3)
    {
      localObject = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      bi localbi = (bi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 6: 
        localbi.f = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 5: 
        localbi.e = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
        return 0;
      case 4: 
        localbi.d = ((com.tencent.luggage.wxa.sx.a)localObject).h(paramInt);
        return 0;
      case 3: 
        localbi.c = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 2: 
        localbi.b = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      }
      localbi.a = ((com.tencent.luggage.wxa.sx.a)localObject).c(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.bi
 * JD-Core Version:    0.7.0.1
 */