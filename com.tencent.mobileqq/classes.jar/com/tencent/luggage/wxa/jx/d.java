package com.tencent.luggage.wxa.jx;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ba.b;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.pd.p;
import com.tencent.luggage.wxa.pd.p.a;
import com.tencent.luggage.wxa.pd.p.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import org.joor.Reflect;
import org.json.JSONObject;

public abstract class d
  implements c
{
  private final Object b = new byte[0];
  private i c;
  protected final Map<String, m> c_ = new ConcurrentHashMap();
  private l d = b();
  private Handler e;
  private final AtomicBoolean f = new AtomicBoolean(false);
  private volatile c.b g;
  private com.tencent.mm.plugin.appbrand.appstorage.o h = new g();
  @TargetApi(21)
  private final ConcurrentLinkedDeque<j> i = new ConcurrentLinkedDeque();
  private final LinkedHashSet<k> j = new LinkedHashSet();
  private final com.tencent.luggage.wxa.hw.d k = new com.tencent.luggage.wxa.hw.d();
  private boolean l;
  private SparseArray<com.tencent.mm.plugin.appbrand.jsruntime.o> m = new SparseArray(5);
  private boolean n = false;
  
  public d()
  {
    com.tencent.luggage.wxa.bb.a.a(new d.1(this));
    a_(false);
  }
  
  private String a()
  {
    return "WeixinJSCoreAndroid";
  }
  
  private String a(m paramm, String paramString, int paramInt, com.tencent.mm.plugin.appbrand.jsruntime.o paramo, @Nullable Looper paramLooper)
  {
    boolean bool = e();
    int i1 = 1;
    if ((!bool) && (!d()))
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandComponentImpl", "invoke log[%s] api[%s], callbackId[%d], component not running", new Object[] { H(), paramm.d(), Integer.valueOf(paramInt) });
      return c(paramm.d(), "fail:interrupted");
    }
    paramo = new d.4(this, paramString, paramm, paramInt, paramo, paramLooper);
    paramLooper = this.g;
    if ((paramLooper != null) && (paramLooper.a(paramm, paramString, paramInt, paramo))) {
      paramInt = i1;
    } else {
      paramInt = 0;
    }
    if (paramInt == 0) {
      paramo.a();
    }
    if (!TextUtils.isEmpty(paramo.b())) {
      return paramo.b();
    }
    return "";
  }
  
  private String a(m paramm, JSONObject paramJSONObject)
  {
    if (p.a(getJsRuntime(), paramm, paramJSONObject, (p.a)b(p.a.class)) == p.b.b) {
      return paramm.b("fail:convert native buffer parameter fail. native buffer exceed size limit.");
    }
    return null;
  }
  
  private String a(m paramm, JSONObject paramJSONObject, int paramInt, com.tencent.mm.plugin.appbrand.jsruntime.o paramo)
  {
    try
    {
      if ((paramm instanceof u))
      {
        if (paramm.e()) {
          return ((u)paramm).a(this, paramJSONObject, paramo);
        }
        return ((u)paramm).a(this, paramJSONObject);
      }
      if ((paramm instanceof a))
      {
        String str = a(paramm, paramJSONObject);
        if (str == null) {
          if (paramm.e()) {
            ((a)paramm).a(this, paramJSONObject, paramInt, paramo);
          } else {
            ((a)paramm).a(this, paramJSONObject, paramInt);
          }
        }
        return str;
      }
      return "";
    }
    catch (Throwable paramJSONObject)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandComponentImpl", "invokeTheJsApi with name[%s], get exception %s", new Object[] { paramm, paramJSONObject });
      throw paramJSONObject;
    }
    catch (ClassCastException paramJSONObject)
    {
      com.tencent.luggage.wxa.qz.o.a("MicroMsg.AppBrandComponentImpl", paramJSONObject, paramJSONObject.getMessage(), new Object[0]);
    }
    return paramm.b("fail:internal error invalid js component");
  }
  
  private JSONObject a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new JSONObject();
    }
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandComponentImpl", paramString.getMessage());
    }
    return null;
  }
  
  private void a(m paramm, String paramString1, int paramInt, String paramString2)
  {
    c.b localb = this.g;
    if (localb == null) {
      return;
    }
    localb.a(paramm, paramString1, paramInt, paramString2);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.jsruntime.o paramo, int paramInt, String paramString)
  {
    paramo.evaluateJavascript(String.format(Locale.US, "typeof %s !== 'undefined' && %s.invokeCallbackHandler(%d, %s)", new Object[] { a(), a(), Integer.valueOf(paramInt), paramString }), null);
  }
  
  private l b()
  {
    return new l(this);
  }
  
  private void b(int paramInt, String paramString)
  {
    c.b localb = this.g;
    if (localb == null) {
      return;
    }
    localb.a(paramInt, paramString);
  }
  
  private void f()
  {
    synchronized (this.b)
    {
      i locali = this.c;
      this.c = null;
      if (locali != null) {
        locali.destroy();
      }
      return;
    }
  }
  
  private void i()
  {
    HandlerThread localHandlerThread = com.tencent.luggage.wxa.sc.d.d("AppBrandAsyncJSThread", 5);
    localHandlerThread.start();
    this.e = new Handler(localHandlerThread.getLooper());
  }
  
  private void j()
  {
    Handler localHandler = this.e;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.e.getLooper().quit();
    }
  }
  
  /* Error */
  private boolean k()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 77	com/tencent/luggage/wxa/jx/d:n	Z
    //   4: ifeq +5 -> 9
    //   7: iconst_1
    //   8: ireturn
    //   9: ldc_w 328
    //   12: invokestatic 337	org/joor/Reflect:on	(Ljava/lang/Class;)Lorg/joor/Reflect;
    //   15: ldc_w 339
    //   18: invokevirtual 343	org/joor/Reflect:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   21: checkcast 345	java/lang/ThreadLocal
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 348	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   29: ifnonnull +14 -> 43
    //   32: aload_1
    //   33: aload_0
    //   34: invokevirtual 351	com/tencent/luggage/wxa/jx/d:getAsyncHandler	()Landroid/os/Handler;
    //   37: invokevirtual 326	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   40: invokevirtual 354	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   43: aload_0
    //   44: iconst_1
    //   45: putfield 77	com/tencent/luggage/wxa/jx/d:n	Z
    //   48: aload_0
    //   49: getfield 77	com/tencent/luggage/wxa/jx/d:n	Z
    //   52: ifeq +11 -> 63
    //   55: ldc 127
    //   57: ldc_w 356
    //   60: invokestatic 358	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: iconst_1
    //   64: ireturn
    //   65: astore_1
    //   66: goto +37 -> 103
    //   69: astore_1
    //   70: ldc 127
    //   72: ldc_w 360
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: aload_1
    //   82: aastore
    //   83: invokestatic 147	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload_0
    //   87: getfield 77	com/tencent/luggage/wxa/jx/d:n	Z
    //   90: ifeq +11 -> 101
    //   93: ldc 127
    //   95: ldc_w 356
    //   98: invokestatic 358	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: iconst_0
    //   102: ireturn
    //   103: aload_0
    //   104: getfield 77	com/tencent/luggage/wxa/jx/d:n	Z
    //   107: ifeq +11 -> 118
    //   110: ldc 127
    //   112: ldc_w 356
    //   115: invokestatic 358	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	d
    //   24	9	1	localThreadLocal	java.lang.ThreadLocal
    //   65	1	1	localObject	Object
    //   69	50	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   9	43	65	finally
    //   43	48	65	finally
    //   70	86	65	finally
    //   9	43	69	java/lang/Throwable
    //   43	48	69	java/lang/Throwable
  }
  
  private Handler m()
  {
    if (this.e == null) {
      i();
    }
    return this.e;
  }
  
  @CallSuper
  public void E()
  {
    M();
    N();
  }
  
  protected String H()
  {
    return "";
  }
  
  public final boolean L()
  {
    return this.l;
  }
  
  public final void M()
  {
    synchronized (this.d)
    {
      if (this.c == null)
      {
        this.c = h();
        this.c.addJavascriptInterface(this.d, "WeixinJSCore");
        if (!TextUtils.isEmpty("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);")) {
          this.c.evaluateJavascript("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);", null);
        }
        r_();
      }
      return;
    }
  }
  
  public final void N()
  {
    if (!this.f.getAndSet(true))
    {
      Map localMap = g();
      if (localMap == null)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandComponentImpl", "!! get NULL jsApiPool when createJsApiPool() called, make sure your logic !!");
        return;
      }
      this.c_.putAll(localMap);
    }
  }
  
  public String[] O()
  {
    ArrayList localArrayList = new ArrayList(500);
    Iterator localIterator = this.c_.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((localEntry.getValue() instanceof a)) && (!((a)localEntry.getValue()).b())) {
        localArrayList.add(localEntry.getKey());
      }
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public <T extends b> T a(Class<T> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    b localb2 = (b)this.k.a(paramClass);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb2 = e.a(paramClass);
      localb1 = localb2;
      if (localb2 != null)
      {
        localb1 = localb2;
        if (!paramClass.isAssignableFrom(localb2.getClass())) {
          localb1 = null;
        }
      }
    }
    return localb1;
  }
  
  public final String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    return a(paramString1, paramString2, paramInt, paramBoolean, null);
  }
  
  public final String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, com.tencent.mm.plugin.appbrand.jsruntime.o paramo)
  {
    m localm = (m)this.c_.get(paramString1);
    int i1 = 0;
    if (localm == null)
    {
      a(paramInt, c(paramString1, "fail:not supported"));
      if (c(paramString1)) {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandComponentImpl", "invokeHandler, api: %s not support", new Object[] { paramString1 });
      }
      return "fail:not supported";
    }
    long l1 = System.currentTimeMillis();
    boolean bool = localm instanceof a;
    Object localObject;
    if (paramo == null) {
      localObject = getJsRuntime();
    } else {
      localObject = paramo;
    }
    String str = "";
    if (bool)
    {
      if (paramo != null) {
        this.m.put(paramInt, paramo);
      }
      if (((a)localm).b())
      {
        if (paramBoolean)
        {
          com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandComponentImpl", "hy: should be called in js thread but called in async thread");
          return "";
        }
        a(localm, paramString2, paramInt, (com.tencent.mm.plugin.appbrand.jsruntime.o)localObject, null);
        paramo = str;
      }
      else if ((paramBoolean) && (k()))
      {
        a(localm, paramString2, paramInt, (com.tencent.mm.plugin.appbrand.jsruntime.o)localObject, m().getLooper());
        paramo = str;
      }
      else
      {
        m().post(new d.3(this, localm, paramString2, paramInt, (com.tencent.mm.plugin.appbrand.jsruntime.o)localObject));
        paramo = str;
      }
    }
    else
    {
      if (paramBoolean)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandComponentImpl", "hy: is sync but called in async thread");
        return "";
      }
      paramo = a(localm, paramString2, paramInt, (com.tencent.mm.plugin.appbrand.jsruntime.o)localObject, null);
    }
    if (c(paramString1))
    {
      localObject = H();
      if (paramString2 == null) {
        paramInt = i1;
      } else {
        paramInt = paramString2.length();
      }
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandComponentImpl", "invokeHandler, tag: %s, api: %s, data size: %d, time: %d", new Object[] { localObject, paramString1, Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis() - l1) });
    }
    return paramo;
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, paramString, null);
  }
  
  public void a(int paramInt, String paramString, com.tencent.mm.plugin.appbrand.jsruntime.o paramo)
  {
    if ((!e()) && (!d()))
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandComponentImpl", "callback but destroyed, callbackId %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    String str = paramString;
    if (af.c(paramString)) {
      str = "{}";
    }
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandComponentImpl", "callbackId: %d, data size: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(str.length()) });
    paramString = (com.tencent.mm.plugin.appbrand.jsruntime.o)this.m.get(paramInt);
    Object localObject = this.b;
    n localn = null;
    if (paramo != null) {
      paramString = paramo;
    }
    try
    {
      if (paramo == this.c)
      {
        localn = (n)this.c.a(n.class);
        paramString = paramo;
        break label184;
        if (paramString == null)
        {
          paramo = this.c;
          paramString = paramo;
          if (paramo != null)
          {
            localn = (n)this.c.a(n.class);
            paramString = paramo;
          }
        }
        else
        {
          this.m.remove(paramInt);
        }
      }
      label184:
      if (paramString == null)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandComponentImpl", "callback but get NULL JsRuntime, callbackId:%d", new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      if (localn != null) {
        localn.a(paramInt, str);
      } else {
        a(paramString, paramInt, str);
      }
      b(paramInt, str);
      return;
    }
    finally
    {
      label245:
      break label245;
    }
    throw paramString;
  }
  
  public final void a(ah paramah)
  {
    a(paramah, getJsRuntime());
  }
  
  public void a(ah paramah, com.tencent.mm.plugin.appbrand.jsruntime.o paramo)
  {
    c.b localb = this.g;
    if (localb == null)
    {
      a(paramah.d(), paramah.c(), paramah.e(), paramo);
      return;
    }
    localb.a(paramah, new d.2(this, paramah, paramo));
  }
  
  public void a(ah paramah, int[] paramArrayOfInt)
  {
    a(paramah.d(), paramah.c(), paramArrayOfInt);
  }
  
  public void a(@Nullable c.b paramb)
  {
    this.g = paramb;
  }
  
  public void a(j paramj)
  {
    this.i.add(paramj);
  }
  
  public final <T extends b> void a(Class<T> paramClass, T paramT)
  {
    this.k.a(paramClass, paramT);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    t.a(paramRunnable);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 0);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    a(paramString1, paramString2, paramInt, getJsRuntime());
  }
  
  public void a(String paramString1, String paramString2, int paramInt, com.tencent.mm.plugin.appbrand.jsruntime.o paramo)
  {
    if ((!e()) && (!d())) {
      return;
    }
    Object localObject = paramo;
    if (paramo == null) {
      localObject = getJsRuntime();
    }
    az.a((com.tencent.mm.plugin.appbrand.jsruntime.o)localObject, paramString1, paramString2, paramInt);
  }
  
  public void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    a(paramString1, paramString2);
  }
  
  public void a(Collection<j> paramCollection)
  {
    this.i.addAll(paramCollection);
  }
  
  public boolean a(k paramk)
  {
    if (paramk == null) {
      return false;
    }
    synchronized (this.j)
    {
      this.j.add(paramk);
      return true;
    }
  }
  
  protected final void a_(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  @NonNull
  public <T extends j> T b(@NonNull Class<T> paramClass)
  {
    Object localObject2 = this.i.descendingIterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (j)((Iterator)localObject2).next();
      if (paramClass.isInstance(localObject1)) {
        break label40;
      }
    }
    Object localObject1 = null;
    label40:
    localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = (j)Reflect.on(paramClass).create().get();
      if (localObject2 == null) {}
    }
    catch (Exception localException2)
    {
      label72:
      label79:
      break label79;
    }
    try
    {
      a((j)localObject2);
    }
    catch (Exception localException1)
    {
      break label72;
    }
    localObject1 = localObject2;
    break label79;
    return localObject2;
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandComponentImpl", "Make sure %s has default constructor", new Object[] { paramClass.getName() });
    localObject2 = localObject1;
    return localObject2;
  }
  
  public final String b(String paramString1, String paramString2, int paramInt)
  {
    return a(paramString1, paramString2, paramInt, false);
  }
  
  public void b(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return;
    }
    long l1 = paramLong;
    if (paramLong < 0L) {
      l1 = 0L;
    }
    t.a(paramRunnable, l1);
  }
  
  public <T extends k> T c(@NonNull Class<T> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    synchronized (this.j)
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        if (paramClass.isInstance(localk)) {
          return localk;
        }
      }
      return null;
    }
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public String c(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramString2);
    localHashMap.put("errMsg", localStringBuilder.toString());
    return new JSONObject(localHashMap).toString();
  }
  
  protected boolean c(String paramString)
  {
    return true;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public final Handler getAsyncHandler()
  {
    return m();
  }
  
  public int getComponentId()
  {
    return hashCode();
  }
  
  @NonNull
  public com.tencent.mm.plugin.appbrand.widget.dialog.l getDialogContainer()
  {
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandComponentImpl", "getDialogContainer return dummy impl");
    return com.tencent.mm.plugin.appbrand.widget.dialog.l.a;
  }
  
  public com.tencent.mm.plugin.appbrand.appstorage.o getFileSystem()
  {
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandComponentImpl", "getFileSystem return dummy impl");
    return this.h;
  }
  
  public final i getJsRuntime()
  {
    synchronized (this.b)
    {
      i locali = this.c;
      return locali;
    }
  }
  
  @CallSuper
  public void l()
  {
    j();
    this.d.a();
    this.c_.clear();
    this.d = null;
    this.g = null;
    f();
  }
  
  protected void r_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.d
 * JD-Core Version:    0.7.0.1
 */