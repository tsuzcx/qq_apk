package com.tencent.luggage.wxa.du;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.webkit.JavascriptInterface;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.dq.d.a;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.ku.t;
import com.tencent.luggage.wxa.ku.t.b;
import com.tencent.luggage.wxa.pd.m;
import com.tencent.luggage.wxa.pd.m.a;
import com.tencent.luggage.wxa.qt.c;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.h.a;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.jsruntime.g;
import com.tencent.mm.plugin.appbrand.jsruntime.s;
import com.tencent.mm.plugin.appbrand.jsruntime.u;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a<SERVICE extends com.tencent.luggage.wxa.iu.h>
  implements com.tencent.luggage.wxa.dq.d, t.b
{
  protected final SERVICE c;
  private final s d;
  private final g e;
  private final SparseIntArray f = new SparseIntArray();
  
  protected a(@NonNull SERVICE paramSERVICE, @NonNull s params)
  {
    this.c = paramSERVICE;
    this.d = params;
    this.e = params.f();
  }
  
  private void a(@NonNull g paramg, @NonNull String paramString1, @NonNull String paramString2)
  {
    long l1 = System.currentTimeMillis();
    com.tencent.luggage.wxa.qt.a locala = new com.tencent.luggage.wxa.qt.a();
    com.tencent.luggage.wxa.pc.i locali = new com.tencent.luggage.wxa.pc.i();
    com.tencent.luggage.wxa.iu.d locald = e().q();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1.replace('/', '_'));
    localStringBuilder.append("_");
    localStringBuilder.append(this.c.getAppId());
    m.a(locald, paramg, paramString1, localStringBuilder.toString(), this.c.q().A().S.md5, 0, paramString2, m.a.b, new a.3(this, locali, locala));
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectAppScript with appID(%s), contextId(%d), appScriptPath(%s), succeed(%b)", new Object[] { this.c.getAppId(), Integer.valueOf(paramg.d()), paramString1, Boolean.valueOf(locala.a) });
    long l2 = System.currentTimeMillis();
    paramg = new d.a();
    paramg.a = paramString1;
    paramg.b = paramString2;
    paramg.c = com.tencent.luggage.wxa.qz.af.b(paramString2).length();
    a(paramg, locala.a, l1, l2, locali.a);
  }
  
  private void b(@NonNull g paramg, @NonNull String paramString1, @NonNull String paramString2)
  {
    long l1 = System.currentTimeMillis();
    com.tencent.luggage.wxa.qt.a locala = new com.tencent.luggage.wxa.qt.a();
    com.tencent.luggage.wxa.pc.i locali = new com.tencent.luggage.wxa.pc.i();
    com.tencent.luggage.wxa.iu.h localh = e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v");
    localStringBuilder.append(a(e()));
    m.a(localh, paramg, paramString1, paramString1, localStringBuilder.toString(), d(), paramString2, m.a.a, new a.5(this, locali, locala));
    long l2 = System.currentTimeMillis();
    paramg = new d.a();
    paramg.a = paramString1;
    paramg.b = paramString2;
    paramg.c = paramString2.length();
    a(paramg, locala.a, l1, l2, locali.a);
  }
  
  protected abstract int a(@NonNull SERVICE paramSERVICE);
  
  @CallSuper
  protected int a(@NonNull g paramg, @NonNull String paramString)
  {
    long l1 = System.currentTimeMillis();
    com.tencent.luggage.wxa.qt.a locala = new com.tencent.luggage.wxa.qt.a();
    c localc = new c();
    Object localObject = ad.b(e().q());
    if (localObject == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript pkgListReader is null, err, appId(%s) scriptPath(%s)", new Object[] { this.c.getAppId(), paramString });
      return 0;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.appcache.h)localObject).c(paramString);
    if (localObject == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript, scriptFileInfo is null, appId(%s) scriptPath(%s)", new Object[] { this.c.getAppId(), paramString });
      return 0;
    }
    com.tencent.luggage.wxa.pc.i locali = new com.tencent.luggage.wxa.pc.i();
    m.a(e().q(), paramg, paramString, (h.a)localObject, new a.4(this, locala, locali, localc));
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript with appID(%s), contextId(%d), appScriptPath(%s), succeed(%b)", new Object[] { this.c.getAppId(), Integer.valueOf(paramg.d()), paramString, Boolean.valueOf(locala.a) });
    long l2 = System.currentTimeMillis();
    paramg = new d.a();
    paramg.a = paramString;
    paramg.b = null;
    paramg.c = localc.a;
    paramg.d = ((h.a)localObject).d;
    paramg.e = ((h.a)localObject).e;
    a(paramg, locala.a, l1, l2, locali.a);
    return localc.a;
  }
  
  @CallSuper
  protected g a()
  {
    return this.d.f();
  }
  
  protected final g a(int paramInt)
  {
    return this.d.a(paramInt);
  }
  
  protected String a(@NonNull SERVICE paramSERVICE, @NonNull String paramString)
  {
    paramSERVICE = ad.a(paramSERVICE.q(), paramString);
    if (!TextUtils.isEmpty(paramSERVICE)) {
      return paramSERVICE;
    }
    throw new com.tencent.mm.plugin.appbrand.appcache.o(paramString);
  }
  
  public void a(@NonNull d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, @Nullable Object paramObject) {}
  
  protected void a(@NonNull SERVICE paramSERVICE, @NonNull g paramg)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "beforeEvaluateScriptFile appId:%s, contextId:%d", new Object[] { paramSERVICE.getAppId(), Integer.valueOf(paramg.d()) });
  }
  
  public void a(@Nullable String paramString, @NonNull d.a[] paramArrayOfa, @NonNull boolean[] paramArrayOfBoolean, @NonNull Object[] paramArrayOfObject, long paramLong1, long paramLong2) {}
  
  @JavascriptInterface
  public final int alloc()
  {
    int i = allocEmpty();
    if (i <= 0) {
      return i;
    }
    g localg = a(i);
    try
    {
      Object localObject = b(this.c);
      try
      {
        b(localg, c(), (String)localObject);
        return localg.d();
      }
      catch (Exception localException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("alloc::injectSdkScript::");
        ((StringBuilder)localObject).append(c());
        com.tencent.luggage.wxa.qz.o.a("MicroMsg.AppBrandJSContextInterface[multicontext]", localException, ((StringBuilder)localObject).toString(), new Object[0]);
        throw localException;
      }
      return 0;
    }
    catch (com.tencent.mm.plugin.appbrand.appcache.o localo)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "inject sdk %s", new Object[] { localo.getMessage() });
    }
  }
  
  @JavascriptInterface
  public final int allocEmpty()
  {
    g localg = a();
    if (localg == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "alloc with appID(%s), allocJsContext failed", new Object[] { this.c.getAppId() });
      return -2;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: created context id is %d", new Object[] { Integer.valueOf(localg.d()) });
    localg.setJsExceptionHandler(new a.1(this, localg));
    this.e.a(localg, "WeixinJSContext");
    JSONObject localJSONObject;
    if (this.c.q() == null) {
      localJSONObject = this.c.K();
    } else {
      localJSONObject = this.c.j();
    }
    localg.evaluateJavascript(String.format(Locale.US, "var __wxConfig = %s;", new Object[] { localJSONObject.toString() }), null);
    return localg.d();
  }
  
  protected abstract String b(@NonNull SERVICE paramSERVICE);
  
  @CallSuper
  protected void b()
  {
    this.d.e().a(this.e, "WeixinJSContext");
  }
  
  protected abstract String c();
  
  @JavascriptInterface
  public final int create(String paramString)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s)", new Object[] { this.c.getAppId(), paramString });
    if (com.tencent.luggage.wxa.qz.af.c(paramString))
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), nil appScriptPath", new Object[] { this.c.getAppId() });
      return -1;
    }
    int i = alloc();
    if (i <= 0) {
      return i;
    }
    g localg = this.d.a(i);
    i = evaluateScriptFile(i, paramString);
    if (i != 1)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), appScriptPath(%s), eval ret = %d", new Object[] { this.c.getAppId(), paramString, Integer.valueOf(i) });
      return -1;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s), success with contextId(%d)", new Object[] { this.c.getAppId(), paramString, Integer.valueOf(localg.d()) });
    return localg.d();
  }
  
  protected int d()
  {
    return 1;
  }
  
  @JavascriptInterface
  public final void destroy(int paramInt)
  {
    this.d.b(paramInt);
  }
  
  protected final SERVICE e()
  {
    return this.c;
  }
  
  @JavascriptInterface
  public final int evaluateScriptFile(int paramInt, String paramString)
  {
    Object localObject1 = this.c.getAppId();
    i = 0;
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d) appScriptPath(%s)", new Object[] { localObject1, Integer.valueOf(paramInt), paramString });
    localObject1 = this.d.a(paramInt);
    if (localObject1 == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d), appScriptPath(%s), get null context", new Object[] { this.c.getAppId(), Integer.valueOf(paramInt), paramString });
      return -1;
    }
    if (((g)localObject1).c())
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) scriptPath(%s), but want to inject main-context", new Object[] { this.c.getAppId(), paramString });
      return -1;
    }
    if (this.f.get(paramInt, 0) <= 0)
    {
      a(this.c, (g)localObject1);
      this.f.put(paramInt, 1);
    }
    if (this.c.getJsRuntime().a(u.class) == null)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile without v8, appID(%s) contextId(%s) scriptPath(%s)", new Object[] { this.c.getAppId(), Integer.valueOf(paramInt), paramString });
      try
      {
        Object localObject2 = a(this.c, paramString);
        try
        {
          a((g)localObject1, paramString, (String)localObject2);
          return 1;
        }
        catch (Exception localException1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("evaluateScriptFile::injectAppScript::");
          ((StringBuilder)localObject2).append(paramString);
          com.tencent.luggage.wxa.qz.o.a("MicroMsg.AppBrandJSContextInterface[multicontext]", localException1, ((StringBuilder)localObject2).toString(), new Object[0]);
          throw localException1;
        }
        try
        {
          int j = a(localo, paramString);
          paramInt = i;
          if (j > 0) {
            paramInt = 1;
          }
          return paramInt;
        }
        catch (Exception localException2)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("evaluateScriptFile::injectWxaScript::");
          ((StringBuilder)localObject2).append(paramString);
          com.tencent.luggage.wxa.qz.o.a("MicroMsg.AppBrandJSContextInterface[multicontext]", localException2, ((StringBuilder)localObject2).toString(), new Object[0]);
          throw localException2;
        }
      }
      catch (com.tencent.mm.plugin.appbrand.appcache.o localo)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile without v8, with appID(%s) contextId(%d), appScriptPath(%s), %s", new Object[] { this.c.getAppId(), Integer.valueOf(paramInt), paramString, localo.getMessage() });
        return 0;
      }
    }
  }
  
  @JavascriptInterface
  public void loadJsFilesWithOptions(int paramInt, String paramString1, String paramString2)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles appId[%s] contextId[%d] paths[%s] options[%s]", new Object[] { this.c.getAppId(), Integer.valueOf(paramInt), paramString1, paramString2 });
    g localg = this.d.a(paramInt);
    if (localg == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles appId[%s] contextId[%d] get NULL context", new Object[] { this.c.getAppId(), Integer.valueOf(paramInt) });
      return;
    }
    if (this.f.get(paramInt, 0) <= 0)
    {
      a(this.c, localg);
      this.f.put(paramInt, 1);
    }
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString1);
      String str;
      try
      {
        if (!TextUtils.isEmpty(paramString2)) {
          JSONObject localJSONObject = new JSONObject(paramString2);
        }
      }
      catch (JSONException localJSONException)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles parse options appId[%s] contextId[%d] options[%s] e=%s", new Object[] { this.c.getAppId(), Integer.valueOf(paramInt), paramString2, localJSONException });
        str = null;
      }
      com.tencent.luggage.wxa.qz.af.d();
      if (str == null) {
        str = null;
      } else {
        str = str.optString("key");
      }
      try
      {
        t.a(this.c.q(), localJSONArray, localg, this.c.z(), str, new a.2(this, paramInt, paramString1, paramString2));
        return;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFileWithOptions appId[%s] contextId[%d] paths[%s] options[%s], get exception %s", new Object[] { this.c.getAppId(), Integer.valueOf(paramInt), paramString1, paramString2, localThrowable });
        return;
      }
      return;
    }
    catch (JSONException paramString1)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles parse json appId[%s] context[%d] e=%s", new Object[] { this.c.getAppId(), Integer.valueOf(paramInt), paramString1 });
    }
  }
  
  @JavascriptInterface
  public void loadLibFiles(int paramInt, String paramString)
  {
    g localg = a(paramInt);
    if (localg == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get NULL context by id[%d], appId[%s]", new Object[] { Integer.valueOf(paramInt), this.c.getAppId() });
      return;
    }
    try
    {
      Object localObject = new JSONArray(paramString);
      n localn = this.c.A();
      if (localn == null)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get NULL LibReader, id[%d], appId[%s]", new Object[] { Integer.valueOf(paramInt), this.c.getAppId() });
        return;
      }
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        paramString = ((JSONArray)localObject).optString(i);
        String str1;
        if (TextUtils.isEmpty(paramString))
        {
          com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get EMPTY name by index[%d] id[%d] appId[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), this.c.getAppId() });
        }
        else
        {
          str1 = localn.a(paramString);
          if (TextUtils.isEmpty(str1)) {
            com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get EMPTY script by name[%s] id[%d] appId[%s]", new Object[] { paramString, Integer.valueOf(paramInt), this.c.getAppId() });
          }
        }
        try
        {
          paramString.getClass();
          String str2 = (String)paramString;
          str1.getClass();
          b(localg, str2, (String)str1);
          i += 1;
        }
        catch (Exception localException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("loadLibFiles::injectSdkScript::");
          ((StringBuilder)localObject).append(paramString);
          com.tencent.luggage.wxa.qz.o.a("MicroMsg.AppBrandJSContextInterface[multicontext]", localException, ((StringBuilder)localObject).toString(), new Object[0]);
          throw localException;
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles parse paths failed, id[%d] appId[%s] e=%s", new Object[] { Integer.valueOf(paramInt), this.c.getAppId(), paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.du.a
 * JD-Core Version:    0.7.0.1
 */