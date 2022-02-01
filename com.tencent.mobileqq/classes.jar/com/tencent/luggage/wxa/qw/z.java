package com.tencent.luggage.wxa.qw;

public class z
  extends com.tencent.luggage.wxa.qu.a
{
  public com.tencent.luggage.wxa.qu.b a;
  public int b;
  public com.tencent.luggage.wxa.qu.b c;
  public int d;
  public com.tencent.luggage.wxa.qu.b e;
  public int f;
  
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
        if (this.c != null)
        {
          if (this.e != null)
          {
            if (localObject != null) {
              paramVarArgs.a(1, (com.tencent.luggage.wxa.qu.b)localObject);
            }
            paramVarArgs.b(2, this.b);
            localObject = this.c;
            if (localObject != null) {
              paramVarArgs.a(3, (com.tencent.luggage.wxa.qu.b)localObject);
            }
            paramVarArgs.b(4, this.d);
            localObject = this.e;
            if (localObject != null) {
              paramVarArgs.a(5, (com.tencent.luggage.wxa.qu.b)localObject);
            }
            paramVarArgs.b(6, this.f);
            return 0;
          }
          throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: DeviceType");
        }
        throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: DeviceID");
      }
      throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: SessionKey");
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
      i = paramInt + com.tencent.luggage.wxa.sw.a.b(4, this.d);
      paramVarArgs = this.e;
      paramInt = i;
      if (paramVarArgs != null) {
        paramInt = i + com.tencent.luggage.wxa.sw.a.a(5, paramVarArgs);
      }
      return paramInt + com.tencent.luggage.wxa.sw.a.b(6, this.f);
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
        if (this.c != null)
        {
          if (this.e != null) {
            return 0;
          }
          throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: DeviceType");
        }
        throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: DeviceID");
      }
      throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: SessionKey");
    }
    if (paramInt == 3)
    {
      localObject = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      z localz = (z)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 6: 
        localz.f = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 5: 
        localz.e = ((com.tencent.luggage.wxa.sx.a)localObject).h(paramInt);
        return 0;
      case 4: 
        localz.d = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      case 3: 
        localz.c = ((com.tencent.luggage.wxa.sx.a)localObject).h(paramInt);
        return 0;
      case 2: 
        localz.b = ((com.tencent.luggage.wxa.sx.a)localObject).b(paramInt);
        return 0;
      }
      localz.a = ((com.tencent.luggage.wxa.sx.a)localObject).h(paramInt);
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.z
 * JD-Core Version:    0.7.0.1
 */