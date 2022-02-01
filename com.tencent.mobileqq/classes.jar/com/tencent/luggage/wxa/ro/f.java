package com.tencent.luggage.wxa.ro;

import android.util.Pair;
import com.tencent.luggage.wxa.rp.g;
import com.tencent.luggage.wxa.rr.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class f<_Var>
  implements d<_Var>
{
  private Object A;
  com.tencent.luggage.wxa.rp.f a = new com.tencent.luggage.wxa.rp.f(this.g, this.r);
  private volatile boolean b = false;
  private volatile f.d c = f.d.a;
  private boolean d = false;
  private Queue<f.a> e = new LinkedList();
  private volatile com.tencent.luggage.wxa.rp.d f = this.g;
  private volatile com.tencent.luggage.wxa.rp.d g = g.a();
  private volatile boolean h;
  private volatile Object i;
  private volatile Object j;
  private f.a k;
  private f.a l;
  private int m = 0;
  private long n = -1L;
  private boolean o = false;
  private b p = new f.b(this);
  private com.tencent.luggage.wxa.rp.d q;
  private com.tencent.luggage.wxa.rp.f.a r = new f.1(this);
  private List<Pair<e.b, com.tencent.luggage.wxa.rp.d>> s;
  private List<Pair<e.a, com.tencent.luggage.wxa.rp.d>> t;
  private List<Pair<e.c, com.tencent.luggage.wxa.rp.d>> u;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private Object y;
  private Object z;
  
  private <_Ret> d<_Ret> a(com.tencent.luggage.wxa.rl.b<_Ret, _Var> paramb, boolean paramBoolean)
  {
    d();
    this.e.add(new f.a(paramb, this.f, this.n, paramBoolean));
    this.n = -1L;
    if (this.c == f.d.a) {
      return this;
    }
    if (this.c != f.d.b) {
      return this;
    }
    j();
    return this;
  }
  
  private void a(Pair<e.a, com.tencent.luggage.wxa.rp.d> paramPair, Object paramObject)
  {
    a((com.tencent.luggage.wxa.rp.d)paramPair.second, new f.3(this, paramPair, paramObject));
  }
  
  private void a(e.a parama, com.tencent.luggage.wxa.rp.d paramd)
  {
    e();
    if (this.t == null) {
      this.t = new LinkedList();
    }
    parama = new Pair(parama, paramd);
    if (this.w)
    {
      a(parama, this.z);
      return;
    }
    this.t.add(parama);
  }
  
  private void a(e.b paramb, com.tencent.luggage.wxa.rp.d paramd)
  {
    e();
    if (this.s == null) {
      this.s = new LinkedList();
    }
    Pair localPair = new Pair(paramb, paramd);
    this.s.add(new Pair(paramb, paramd));
    if (this.x) {
      b(localPair, this.A);
    }
  }
  
  private void a(e.c paramc, com.tencent.luggage.wxa.rp.d paramd)
  {
    e();
    j();
    if (this.u == null) {
      this.u = new LinkedList();
    }
    paramc = new Pair(paramc, paramd);
    if (this.v)
    {
      c(paramc, this.y);
      return;
    }
    this.u.add(paramc);
  }
  
  private void a(com.tencent.luggage.wxa.rp.d paramd, Runnable paramRunnable)
  {
    if (paramd == null)
    {
      com.tencent.luggage.wxa.rn.a.a("Vending.Pipeline", "Default scheduler %s is not available!!!", new Object[] { this.g });
      return;
    }
    paramd.a(paramRunnable);
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      if ((this.c != f.d.e) && (this.c != f.d.f))
      {
        if ((paramBoolean) && (this.e.size() > 0)) {
          com.tencent.luggage.wxa.rn.a.b("Vending.Pipeline", "Pipe is not finish and be interrupt! %s pipes did not run", new Object[] { Integer.valueOf(this.e.size()) });
        }
        this.c = f.d.e;
        this.e.clear();
        c(null);
        if (this.q != null) {
          this.q.a();
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  private d<_Var> b(Object... paramVarArgs)
  {
    if (this.c != f.d.a) {
      return this;
    }
    this.c = f.d.b;
    if (paramVarArgs.length == 0) {
      paramVarArgs = null;
    } else if (paramVarArgs.length == 1) {
      paramVarArgs = paramVarArgs[0];
    } else {
      paramVarArgs = k.b(paramVarArgs);
    }
    c(paramVarArgs);
    j();
    return this;
  }
  
  private static String b(Object paramObject)
  {
    if (paramObject != null) {
      return String.valueOf(paramObject.hashCode());
    }
    return null;
  }
  
  private void b(Pair<e.b, com.tencent.luggage.wxa.rp.d> paramPair, Object paramObject)
  {
    a((com.tencent.luggage.wxa.rp.d)paramPair.second, new f.4(this, paramPair, paramObject));
  }
  
  private void c(Pair<e.c, com.tencent.luggage.wxa.rp.d> paramPair, Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("object is not right: ");
    ((StringBuilder)localObject).append(paramObject);
    localObject = new RuntimeException(((StringBuilder)localObject).toString());
    new com.tencent.luggage.wxa.rp.f((com.tencent.luggage.wxa.rp.d)paramPair.second, null).a(new f.5(this, paramPair, paramObject, (RuntimeException)localObject), null, this.o);
  }
  
  private void c(Object paramObject)
  {
    try
    {
      this.i = paramObject;
      this.h = true;
      com.tencent.luggage.wxa.rn.a.d("Vending.Pipeline", "set input(%s)", new Object[] { b(paramObject) });
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  private void d()
  {
    if (!this.b) {
      return;
    }
    throw new f.c("This Pipeline(%s) has terminate and do not allow any next().", new Object[] { this });
  }
  
  private e<_Var> e()
  {
    this.b = true;
    return this;
  }
  
  private void f()
  {
    try
    {
      if (this.d)
      {
        this.m += 1;
        com.tencent.luggage.wxa.rn.a.c("Vending.Pipeline", "Functional %s, gonna retry %s.", new Object[] { this.k.a.toString(), Integer.valueOf(this.m) });
        this.d = false;
        i();
      }
      else
      {
        this.m = 0;
      }
      return;
    }
    finally {}
  }
  
  private Object g()
  {
    try
    {
      Object localObject1 = this.i;
      this.j = this.i;
      this.i = null;
      this.h = false;
      com.tencent.luggage.wxa.rn.a.d("Vending.Pipeline", "pop input(%s)", new Object[] { b(localObject1) });
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  private Object h()
  {
    try
    {
      Object localObject1 = this.i;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  private void i()
  {
    ((LinkedList)this.e).add(0, this.k);
    c(this.j);
  }
  
  private void j()
  {
    if (this.c != f.d.b) {
      return;
    }
    this.c = f.d.c;
    Object localObject2 = (f.a)this.e.peek();
    if (localObject2 == null)
    {
      if (this.b)
      {
        this.c = f.d.f;
        this.y = g();
        this.v = true;
        localObject1 = this.u;
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            c((Pair)((Iterator)localObject1).next(), this.y);
          }
        }
      }
      else
      {
        this.c = f.d.b;
      }
      return;
    }
    Object localObject1 = ((f.a)localObject2).a;
    com.tencent.luggage.wxa.rp.d locald = ((f.a)localObject2).b;
    long l1 = ((f.a)localObject2).c;
    boolean bool = ((f.a)localObject2).d;
    if (this.c == f.d.d)
    {
      com.tencent.luggage.wxa.rn.a.c("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeueFunctionAndInvoke and waiting resume() call", new Object[0]);
      return;
    }
    this.l = ((f.a)this.e.poll());
    this.a.a(locald);
    localObject2 = g();
    if (l1 < 0L)
    {
      this.a.a((com.tencent.luggage.wxa.rl.b)localObject1, localObject2, bool);
      return;
    }
    this.q = g.a();
    this.q.a(new f.6(this, (com.tencent.luggage.wxa.rl.b)localObject1, localObject2, bool), l1);
  }
  
  private boolean k()
  {
    return this.l != null;
  }
  
  private boolean l()
  {
    return this.p == h.b();
  }
  
  public <_Ret> d<_Ret> a(com.tencent.luggage.wxa.rl.b<_Ret, _Var> paramb)
  {
    try
    {
      paramb = a(paramb, this.o);
      return paramb;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public d<_Var> a(com.tencent.luggage.wxa.rm.b paramb)
  {
    junit.framework.a.a("keeper should not be null!", paramb);
    paramb.a(this);
    return this;
  }
  
  public d<_Var> a(d.a<_Var> parama)
  {
    try
    {
      b(new Object[0]);
      a(new f.2(this, parama), true);
      return this;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public d<_Var> a(String paramString)
  {
    if (paramString == null)
    {
      junit.framework.a.a("schedulerTypeString should not be null!", paramString);
      return this;
    }
    this.f = g.b(paramString);
    junit.framework.a.a("mCurrentScheduler should not be null!", this.f);
    return this;
  }
  
  public d<_Var> a(Object... paramVarArgs)
  {
    try
    {
      paramVarArgs = b(paramVarArgs);
      return paramVarArgs;
    }
    finally
    {
      paramVarArgs = finally;
      throw paramVarArgs;
    }
  }
  
  public e<_Var> a(e.a parama)
  {
    try
    {
      a(parama, this.g);
      return this;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public e<_Var> a(e.b paramb)
  {
    try
    {
      a(paramb, this.g);
      return this;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public e<_Var> a(e.c<_Var> paramc)
  {
    try
    {
      a(paramc, this.g);
      return this;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public e<_Var> a(com.tencent.luggage.wxa.rp.d paramd, e.a parama)
  {
    try
    {
      a(parama, paramd);
      return this;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public e<_Var> a(com.tencent.luggage.wxa.rp.d paramd, e.c<_Var> paramc)
  {
    try
    {
      a(paramc, paramd);
      return this;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public void a()
  {
    c();
  }
  
  public b b()
  {
    return this.p;
  }
  
  public <_Ret> d<_Ret> b(com.tencent.luggage.wxa.rl.b<_Ret, _Var> paramb)
  {
    return a("Vending.LOGIC").a(paramb);
  }
  
  public <_Ret> d<_Ret> c(com.tencent.luggage.wxa.rl.b<_Ret, _Var> paramb)
  {
    return a("Vending.HEAVY_WORK").a(paramb);
  }
  
  public void c()
  {
    a(true);
  }
  
  public <_Ret> d<_Ret> d(com.tencent.luggage.wxa.rl.b<_Ret, _Var> paramb)
  {
    return a("Vending.UI").a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ro.f
 * JD-Core Version:    0.7.0.1
 */