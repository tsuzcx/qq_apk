package com.tencent.luggage.wxa.ro;

public class h
{
  private static final a a = new a();
  
  public static final <_Ret1, _Ret2, _Var> c<com.tencent.luggage.wxa.rr.c<_Ret1, _Ret2>, _Var> a(com.tencent.luggage.wxa.rl.b<_Ret1, _Var> paramb, com.tencent.luggage.wxa.rl.b<_Ret2, _Var> paramb1)
  {
    return new c(new com.tencent.luggage.wxa.rl.b[] { paramb, paramb1 });
  }
  
  public static final d<Void> a()
  {
    return new f().a(new Object[0]);
  }
  
  public static final <_Var> d<_Var> a(d.a<_Var> parama)
  {
    return new f().a(parama);
  }
  
  public static final <Var1> d<Var1> a(Var1 paramVar1)
  {
    return new f().a(new Object[] { paramVar1 });
  }
  
  public static final <Var1, Var2> d<com.tencent.luggage.wxa.rr.c<Var1, Var2>> a(Var1 paramVar1, Var2 paramVar2)
  {
    return new f().a(new Object[] { paramVar1, paramVar2 });
  }
  
  public static final void a(b paramb, Object... paramVarArgs)
  {
    if (paramb == null)
    {
      com.tencent.luggage.wxa.rn.a.b("Vending.QuickAccess", "dummy mario", new Object[0]);
      return;
    }
    if (paramVarArgs.length > 0)
    {
      paramb.a(paramVarArgs);
      return;
    }
    paramb.b();
  }
  
  public static final <_Var> void a(e<_Var> parame)
  {
    b localb = c();
    parame.a(new h.2(localb)).a(new h.1(localb));
  }
  
  public static final b b()
  {
    d locald = g.a().b();
    if (locald != null) {
      return locald.b();
    }
    return a;
  }
  
  public static <$1> com.tencent.luggage.wxa.rr.b<$1> b($1 param$1)
  {
    return com.tencent.luggage.wxa.rr.a.a(param$1);
  }
  
  public static final b c()
  {
    b localb = b();
    if (localb != null)
    {
      localb.a();
      return localb;
    }
    com.tencent.luggage.wxa.rn.a.b("Vending.QuickAccess", "dummy mario", new Object[0]);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ro.h
 * JD-Core Version:    0.7.0.1
 */