package com.tencent.luggage.wxa.hw;

import com.tencent.luggage.wxa.qz.o;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static final d c = new d();
  private ConcurrentHashMap<Class<? extends a>, c> a = new ConcurrentHashMap();
  private d.a b = null;
  
  private <T extends a> T c(Class<T> paramClass)
  {
    Object localObject = (c)this.a.get(paramClass);
    int i;
    if ((!paramClass.isInterface()) && (Modifier.isAbstract(paramClass.getModifiers())))
    {
      o.c("MicroMsg.ServiceHub", "Did you call service by using the service implementation class ?? Use interface class instead!! Carl is warning u!");
      i = 1;
    }
    else
    {
      i = 0;
    }
    d.a locala = null;
    if (localObject != null)
    {
      localObject = ((c)localObject).a();
    }
    else
    {
      o.b("MicroMsg.ServiceHub", "Service(%s) not found!!! ", new Object[] { paramClass });
      localObject = locala;
      if (i != 0)
      {
        o.b("MicroMsg.ServiceHub", "This error must cause by using implementation class to call service! Use interface instead! Understand?");
        localObject = locala;
      }
    }
    locala = this.b;
    if (locala != null) {
      locala.a(paramClass, (a)localObject);
    }
    return localObject;
  }
  
  public <T extends a> T a(Class<T> paramClass)
  {
    return c(paramClass);
  }
  
  public void a(d.a parama)
  {
    this.b = parama;
  }
  
  public <T extends a, N extends T> void a(Class<T> paramClass, N paramN)
  {
    a(paramClass, new e(paramN));
  }
  
  public <T extends a, N extends T> void a(Class<T> paramClass, c<N> paramc)
  {
    this.a.put(paramClass, paramc);
    if ((paramc instanceof b)) {
      ((b)paramc).c();
    }
    d.a locala = this.b;
    if (locala != null) {
      locala.a(paramClass, paramc);
    }
    o.d("MicroMsg.ServiceHub", "register service %s %s", new Object[] { paramClass, paramc });
  }
  
  public void b(Class<? extends a> paramClass)
  {
    c localc = (c)this.a.remove(paramClass);
    if ((localc instanceof b)) {
      ((b)localc).d();
    }
    d.a locala = this.b;
    if (locala != null) {
      locala.b(paramClass, localc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hw.d
 * JD-Core Version:    0.7.0.1
 */