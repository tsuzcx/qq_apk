package com.tencent.mm.plugin.appbrand.jsruntime;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.eclipsesource.mmv8.ScriptPartObject;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.appbrand.v8.c;
import com.tencent.mm.appbrand.v8.e;
import com.tencent.mm.appbrand.v8.f;
import com.tencent.mm.appbrand.v8.n.b;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;

abstract class d
  implements g, k, l, n, q, r, t, u
{
  private long b = 0L;
  private w c;
  
  @NonNull
  protected abstract c a();
  
  public <T extends j> T a(Class<T> paramClass)
  {
    if (paramClass.isInstance(this)) {
      return this;
    }
    return null;
  }
  
  public ByteBuffer a(int paramInt, boolean paramBoolean)
  {
    return b().d().a(paramInt, paramBoolean);
  }
  
  public final void a(int paramInt, String paramString)
  {
    a().a(new d.5(this, paramInt, paramString));
  }
  
  public void a(int paramInt, ByteBuffer paramByteBuffer)
  {
    b().d().a(paramInt, paramByteBuffer);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    b().d().a(paramLong1, paramLong2);
  }
  
  public void a(g paramg, String paramString)
  {
    if ((paramg instanceof d))
    {
      b().a(paramString, ((d)paramg).b());
      return;
    }
    if (paramg == null) {
      paramg = null;
    } else {
      paramg = paramg.getClass().getName();
    }
    o.b("MicroMsg.AppBrandJ2V8Context", "shareObject with unsupported implementation %s", new Object[] { paramg });
  }
  
  public void a(@Nullable w paramw)
  {
    this.c = paramw;
  }
  
  public void a(@NonNull Runnable paramRunnable)
  {
    a(paramRunnable, false);
  }
  
  public void a(@NonNull Runnable paramRunnable, boolean paramBoolean)
  {
    a().a(paramRunnable, 0L, paramBoolean);
  }
  
  public void a(String paramString)
  {
    b().a(paramString);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    a(paramString1, paramString2, paramInt, paramString3, null);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, String paramString3, @Nullable n.a parama)
  {
    a().a(new d.6(this, parama, paramString1, paramInt, paramString2, paramString3));
  }
  
  public void a(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
  {
    b().a(paramString1, paramString2);
  }
  
  public void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    if (paramURL == null)
    {
      evaluateJavascript(paramString, paramValueCallback);
      return;
    }
    if (paramValueCallback == null) {
      paramValueCallback = null;
    } else {
      paramValueCallback = new d.2(this, paramValueCallback);
    }
    b().a(paramURL.toString(), paramString, paramValueCallback);
  }
  
  public void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback)
  {
    Object localObject = null;
    if (paramValueCallback == null) {
      paramValueCallback = null;
    } else {
      paramValueCallback = new d.3(this, paramValueCallback);
    }
    com.tencent.mm.appbrand.v8.n localn = b();
    if (paramURL == null) {
      paramURL = localObject;
    } else {
      paramURL = paramURL.toString();
    }
    localn.a(paramURL, paramString3, paramValueCallback, paramString1, paramString2, paramInt);
  }
  
  public void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, n.b paramb)
  {
    com.tencent.mm.appbrand.v8.n localn = b();
    if (paramURL == null) {
      paramURL = null;
    } else {
      paramURL = paramURL.toString();
    }
    localn.a(paramURL, paramString3, paramb, paramString1, paramString2, paramInt);
  }
  
  public void a(ArrayList<ScriptPartObject> paramArrayList, URL paramURL, String paramString1, String paramString2, n.b paramb)
  {
    com.tencent.mm.appbrand.v8.n localn = b();
    if (paramURL == null) {
      paramURL = null;
    } else {
      paramURL = paramURL.toString();
    }
    localn.a(paramArrayList, paramURL, paramb, paramString1, paramString2);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    b().a(paramObject, paramString, JavascriptInterface.class);
  }
  
  @NonNull
  protected abstract com.tencent.mm.appbrand.v8.n b();
  
  public void c(int paramInt)
  {
    a().a(paramInt);
  }
  
  public void d(int paramInt)
  {
    b().e().d(paramInt);
  }
  
  public void destroy()
  {
    a().a(new d.4(this));
    b().f();
  }
  
  public ByteBuffer e(int paramInt)
  {
    return b().e().c(paramInt);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    if (paramValueCallback == null) {
      paramValueCallback = null;
    } else {
      paramValueCallback = new d.1(this, paramValueCallback);
    }
    b().a(paramString, paramValueCallback);
  }
  
  public int f(int paramInt)
  {
    return b().e().a(paramInt);
  }
  
  public boolean g()
  {
    return a().o();
  }
  
  public void h()
  {
    a().n();
  }
  
  public long i()
  {
    return a().m();
  }
  
  public long j()
  {
    return b().c();
  }
  
  public long k()
  {
    return a().l();
  }
  
  public boolean l()
  {
    return a().j();
  }
  
  public String m()
  {
    return a().f();
  }
  
  public void n()
  {
    a().h();
  }
  
  public void o()
  {
    a().g();
  }
  
  public boolean p()
  {
    return b().d().b();
  }
  
  @Nullable
  public w q()
  {
    return this.c;
  }
  
  public int r()
  {
    return b().d().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.d
 * JD-Core Version:    0.7.0.1
 */