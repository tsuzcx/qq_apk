package com.tencent.luggage.wxa.qw;

import java.util.LinkedList;

public class br
  extends gu
{
  public int a;
  public LinkedList<Integer> b = new LinkedList();
  public LinkedList<bq> c = new LinkedList();
  public LinkedList<bn> d = new LinkedList();
  public LinkedList<com.tencent.luggage.wxa.qu.b> e = new LinkedList();
  public LinkedList<com.tencent.luggage.wxa.qu.b> f = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
    if (paramInt == 0)
    {
      paramVarArgs = (com.tencent.luggage.wxa.tc.a)paramVarArgs[0];
      if (this.z != null)
      {
        if (this.z != null)
        {
          paramVarArgs.c(1, this.z.d());
          this.z.a(paramVarArgs);
        }
        paramVarArgs.b(2, this.a);
        paramVarArgs.a(3, 2, this.b);
        paramVarArgs.a(4, 8, this.c);
        paramVarArgs.a(5, 8, this.d);
        paramVarArgs.a(6, 6, this.e);
        paramVarArgs.a(7, 6, this.f);
        return 0;
      }
      throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: BaseResponse");
    }
    if (paramInt == 1)
    {
      paramInt = i;
      if (this.z != null) {
        paramInt = 0 + com.tencent.luggage.wxa.sw.a.c(1, this.z.d());
      }
      return paramInt + com.tencent.luggage.wxa.sw.a.b(2, this.a) + com.tencent.luggage.wxa.sw.a.a(3, 2, this.b) + com.tencent.luggage.wxa.sw.a.a(4, 8, this.c) + com.tencent.luggage.wxa.sw.a.a(5, 8, this.d) + com.tencent.luggage.wxa.sw.a.a(6, 6, this.e) + com.tencent.luggage.wxa.sw.a.a(7, 6, this.f);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.b.clear();
      this.c.clear();
      this.d.clear();
      this.e.clear();
      this.f.clear();
      paramVarArgs = new com.tencent.luggage.wxa.sx.a(paramVarArgs, p);
      for (paramInt = gu.a(paramVarArgs); paramInt > 0; paramInt = gu.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.b();
        }
      }
      if (this.z != null) {
        return 0;
      }
      throw new com.tencent.luggage.wxa.sw.b("Not all required fields were included: BaseResponse");
    }
    if (paramInt == 3)
    {
      Object localObject1 = (com.tencent.luggage.wxa.sx.a)paramVarArgs[0];
      br localbr = (br)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 7: 
        localbr.f.add(((com.tencent.luggage.wxa.sx.a)localObject1).h(paramInt));
        return 0;
      case 6: 
        localbr.e.add(((com.tencent.luggage.wxa.sx.a)localObject1).h(paramInt));
        return 0;
      case 5: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject1).i(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bn();
          localObject2 = new com.tencent.luggage.wxa.sx.a((byte[])localObject2, p);
          for (bool = true; bool; bool = ((bn)localObject1).a((com.tencent.luggage.wxa.sx.a)localObject2, (com.tencent.luggage.wxa.qu.a)localObject1, gu.a((com.tencent.luggage.wxa.sx.a)localObject2))) {}
          localbr.d.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 4: 
        paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject1).i(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bq();
          localObject2 = new com.tencent.luggage.wxa.sx.a((byte[])localObject2, p);
          for (bool = true; bool; bool = ((bq)localObject1).a((com.tencent.luggage.wxa.sx.a)localObject2, (com.tencent.luggage.wxa.qu.a)localObject1, gu.a((com.tencent.luggage.wxa.sx.a)localObject2))) {}
          localbr.c.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 3: 
        localbr.b.add(Integer.valueOf(((com.tencent.luggage.wxa.sx.a)localObject1).b(paramInt)));
        return 0;
      case 2: 
        localbr.a = ((com.tencent.luggage.wxa.sx.a)localObject1).b(paramInt);
        return 0;
      }
      paramVarArgs = ((com.tencent.luggage.wxa.sx.a)localObject1).i(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aa();
        localObject2 = new com.tencent.luggage.wxa.sx.a((byte[])localObject2, p);
        for (bool = true; bool; bool = ((aa)localObject1).a((com.tencent.luggage.wxa.sx.a)localObject2, (com.tencent.luggage.wxa.qu.a)localObject1, gu.a((com.tencent.luggage.wxa.sx.a)localObject2))) {}
        localbr.z = ((aa)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qw.br
 * JD-Core Version:    0.7.0.1
 */