package com.tencent.luggage.wxa.ro;

public class c<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  private com.tencent.luggage.wxa.rl.b[] a;
  private com.tencent.luggage.wxa.rm.c b = new com.tencent.luggage.wxa.rm.c();
  private int c = 0;
  private Object[] d;
  private e.a e = new c.1(this);
  private e.b f = new c.2(this);
  private b h;
  
  public c(com.tencent.luggage.wxa.rl.b... paramVarArgs)
  {
    this.a = paramVarArgs;
  }
  
  public _Ret a(_Var param_Var)
  {
    this.d = new Object[this.a.length];
    this.h = h.c();
    boolean bool = com.tencent.luggage.wxa.rs.a.a(this.h);
    int i = 0;
    if (bool) {
      com.tencent.luggage.wxa.rn.a.b("Vending.ParallelsFunctional", "Plz run ParallelsFunctional in pipeline!", new Object[0]);
    }
    com.tencent.luggage.wxa.rl.b[] arrayOfb = this.a;
    int k = arrayOfb.length;
    int j = 0;
    while (i < k)
    {
      com.tencent.luggage.wxa.rl.b localb = arrayOfb[i];
      h.a(param_Var).a(this.b).a(localb).a(this.f).a(this.e).a(new c.a(this, j));
      j += 1;
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ro.c
 * JD-Core Version:    0.7.0.1
 */