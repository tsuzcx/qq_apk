package com.tencent.mm.appbrand.v8;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.ScriptPartObject;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class n
{
  private final c a;
  @NonNull
  private final f b;
  private final e c;
  private final LinkedList<p> d = new LinkedList();
  private final FutureTask<V8Context> e;
  private V8Object f = null;
  
  n(@NonNull c paramc, f paramf, @NonNull n.a parama)
  {
    this.a = paramc;
    this.e = new FutureTask(new n.1(this, parama));
    paramc.a(this.e);
    paramc = paramf;
    if (paramf == null) {
      paramc = new v();
    }
    this.b = paramc;
    this.c = new k(this);
    g();
  }
  
  private static List<Method> a(Class<?> paramClass, Class<? extends Annotation> paramClass1)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramClass != Object.class)
    {
      Iterator localIterator = new ArrayList(Arrays.asList(paramClass.getDeclaredMethods())).iterator();
      while (localIterator.hasNext())
      {
        Method localMethod = (Method)localIterator.next();
        if ((paramClass1 == null) || (localMethod.isAnnotationPresent(paramClass1))) {
          localArrayList.add(localMethod);
        }
      }
      paramClass = paramClass.getSuperclass();
    }
    return localArrayList;
  }
  
  private void b(Object paramObject, String paramString, Class<? extends Annotation> paramClass)
  {
    Object localObject = a(paramObject.getClass(), paramClass);
    paramClass = b().newV8Object();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Method localMethod = (Method)((Iterator)localObject).next();
      paramClass.registerJavaMethod(paramObject, localMethod.getName(), localMethod.getName(), localMethod.getParameterTypes());
    }
    b().add(paramString, paramClass);
    paramClass.release();
  }
  
  private void g()
  {
    this.a.a(new n.7(this), false);
  }
  
  public c a()
  {
    return this.a;
  }
  
  public void a(int paramInt, h paramh)
  {
    this.a.a(paramInt, paramh);
  }
  
  public void a(Object paramObject, String paramString, Class<? extends Annotation> paramClass)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.a.a(new n.2(this, paramObject, paramString, paramClass));
  }
  
  public void a(String paramString)
  {
    this.a.a(new n.5(this, paramString));
  }
  
  public void a(String paramString, JavaCallback paramJavaCallback)
  {
    this.a.a(new n.12(this, paramJavaCallback, paramString));
  }
  
  public void a(String paramString, JavaVoidCallback paramJavaVoidCallback)
  {
    this.a.a(new n.13(this, paramJavaVoidCallback, paramString));
  }
  
  public void a(String paramString, n.b paramb)
  {
    this.a.a(new n.8(this, paramb, paramString));
  }
  
  public void a(String paramString, n paramn)
  {
    this.a.a(new n.4(this, paramString, paramn));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.a(new n.6(this, paramString1, paramString2));
  }
  
  public void a(String paramString1, String paramString2, n.b paramb)
  {
    this.a.a(new n.9(this, paramString1, paramb, paramString2));
  }
  
  public void a(String paramString1, String paramString2, n.b paramb, String paramString3, String paramString4, int paramInt)
  {
    this.a.a(new n.10(this, paramString1, paramb, paramInt, paramString2, paramString3, paramString4));
  }
  
  public void a(ArrayList<ScriptPartObject> paramArrayList, String paramString1, n.b paramb, String paramString2, String paramString3)
  {
    this.a.a(new n.11(this, paramString1, paramb, paramArrayList, paramString2, paramString3));
  }
  
  public V8Context b()
  {
    try
    {
      V8Context localV8Context = (V8Context)this.e.get(10L, TimeUnit.SECONDS);
      return localV8Context;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.J2V8.V8ContextEngine", localException, "getV8Context failed", new Object[0]);
    }
    return null;
  }
  
  public long c()
  {
    return b().getPtr();
  }
  
  public f d()
  {
    return this.b;
  }
  
  public e e()
  {
    return this.c;
  }
  
  public void f()
  {
    this.a.b(new n.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.n
 * JD-Core Version:    0.7.0.1
 */