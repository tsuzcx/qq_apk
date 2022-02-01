package com.tencent.mm.appbrand.v8;

import android.os.Looper;
import android.util.SparseArray;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Function;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.luggage.wxa.qz.o;

class u
  extends p
{
  private int a = 0;
  private final SparseArray<u.b> b = new SparseArray();
  private volatile Looper c;
  private final boolean d = false;
  
  private int a(n paramn, V8Function paramV8Function, int paramInt, V8Array paramV8Array)
  {
    this.a += 1;
    if ((paramn.a() instanceof b)) {
      paramn = new u.c(this, paramn, this.a, paramV8Function, paramV8Array, false, paramInt);
    } else {
      paramn = new u.a(this, paramn, this.a, paramV8Function, paramV8Array, false, paramInt);
    }
    paramn.a();
    this.b.put(this.a, paramn);
    return this.a;
  }
  
  private void a(int paramInt)
  {
    u.b localb = (u.b)this.b.get(paramInt);
    if (localb != null)
    {
      localb.b();
      this.b.remove(paramInt);
    }
  }
  
  private int b(n paramn, V8Function paramV8Function, int paramInt, V8Array paramV8Array)
  {
    this.a += 1;
    if ((paramn.a() instanceof b)) {
      paramn = new u.c(this, paramn, this.a, paramV8Function, paramV8Array, true, paramInt);
    } else {
      paramn = new u.a(this, paramn, this.a, paramV8Function, paramV8Array, true, paramInt);
    }
    paramn.a();
    this.b.put(this.a, paramn);
    return this.a;
  }
  
  private static int b(String paramString, int paramInt)
  {
    if (paramString != null) {
      try
      {
        if (paramString.length() <= 0) {
          return paramInt;
        }
        int i = Integer.decode(paramString).intValue();
        return i;
      }
      catch (NumberFormatException paramString)
      {
        o.a("MicroMsg.J2V8.V8DirectApiTimer", paramString, "", new Object[0]);
      }
    }
    return paramInt;
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.b.size())
    {
      ((u.b)this.b.valueAt(i)).b();
      i += 1;
    }
    this.b.clear();
    Looper localLooper = this.c;
    if ((localLooper != null) && (Looper.getMainLooper() != localLooper))
    {
      localLooper.quit();
      this.c = null;
    }
  }
  
  protected void a(n paramn, V8Object paramV8Object)
  {
    if (!(paramn.a() instanceof b)) {
      this.c = Looper.getMainLooper();
    }
    if (((paramn.a() instanceof i)) && (((i)paramn.a()).k()))
    {
      o.d("MicroMsg.J2V8.V8DirectApiTimer", "hy: node env do not need java imp timer");
      return;
    }
    o.d("MicroMsg.J2V8.V8DirectApiTimer", "hy: not node. need to inject direct timer");
    paramV8Object.registerJavaMethod(new u.1(this, paramn), "setTimeout");
    paramV8Object.registerJavaMethod(new u.2(this, paramn), "setInterval");
    paramV8Object.registerJavaMethod(new u.3(this), "clearTimeout");
    paramV8Object.registerJavaMethod(new u.4(this), "clearInterval");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.u
 * JD-Core Version:    0.7.0.1
 */