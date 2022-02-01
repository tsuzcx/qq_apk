package com.tencent.mm.appbrand.v8;

import android.content.Context;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Function;
import com.eclipsesource.mmv8.V8ScriptException;
import com.tencent.luggage.wxa.jx.d;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class w
{
  private final AtomicInteger a = new AtomicInteger(0);
  private final ConcurrentHashMap<Integer, n> b = new ConcurrentHashMap();
  private x c;
  private f d = new w.6(this);
  
  public w(@NonNull x paramx)
  {
    this.c = paramx;
  }
  
  private void a(int paramInt, n paramn, @Nullable WeakReference<d> paramWeakReference, @Nullable List<String> paramList)
  {
    WeakReference localWeakReference = new WeakReference(paramn);
    paramn.a("postMessage", new w.2(this, paramInt));
    if (paramWeakReference != null) {
      paramn.a("workerInvokeJsApi", new w.3(this, paramWeakReference, paramList, localWeakReference));
    }
  }
  
  private void a(n paramn, String paramString)
  {
    if (paramn.b().getType("onmessage") != 7) {
      return;
    }
    try
    {
      V8Function localV8Function = (V8Function)paramn.b().get("onmessage");
      V8Array localV8Array = paramn.b().newV8Array();
      localV8Array.push(paramString);
      localV8Function.call(paramn.b().getGlobalObject(), localV8Array);
      localV8Function.release();
      localV8Array.release();
      return;
    }
    catch (V8ScriptException paramString)
    {
      o.a("MicroMsg.V8EngineWorkerManager", paramString, "hy: js exception in worker!", new Object[0]);
      a(paramn, paramString.getMessage(), paramString.getJSStackTrace());
    }
  }
  
  private void a(n paramn, String paramString, ValueCallback<String> paramValueCallback)
  {
    if (paramn != null)
    {
      if (paramValueCallback != null)
      {
        paramn.a(paramString, new w.4(this, paramValueCallback));
        return;
      }
      paramn.a(paramString, null);
      return;
    }
    o.c("MicroMsg.V8EngineWorkerManager", "hy: engine context released");
  }
  
  private void a(n paramn, String paramString1, String paramString2)
  {
    o.b("MicroMsg.V8EngineWorkerManager", "handleException(%s), stackTrace : %s", new Object[] { paramString1, paramString2 });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("message", paramString1);
      localJSONObject.put("stack", paramString2);
    }
    catch (JSONException paramString1)
    {
      o.b("MicroMsg.V8EngineWorkerManager", Log.getStackTraceString(paramString1));
    }
    paramn.a(String.format("WeixinWorker.errorHandler(%s)", new Object[] { localJSONObject }), null);
  }
  
  public int a(ArrayList<w.a> paramArrayList, d paramd, List<String> paramList)
  {
    int i = this.a.addAndGet(1);
    c.a locala = new c.a();
    locala.i = new WeakReference(paramd);
    Object localObject = z.b(locala);
    ((z)localObject).b(this.d);
    localObject = ((z)localObject).b(1);
    a(paramd.getContext(), (n)localObject, paramd);
    a(i, (n)localObject, locala.i, paramList);
    ((n)localObject).a(1, new w.1(this, (n)localObject));
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramd = (w.a)paramArrayList.next();
        if ((paramd != null) && (paramd.a())) {
          a((n)localObject, paramd);
        }
      }
    }
    this.b.put(Integer.valueOf(i), localObject);
    return i;
  }
  
  public void a()
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      ((n)localIterator.next()).a().g();
    }
  }
  
  public void a(int paramInt)
  {
    n localn = (n)this.b.remove(Integer.valueOf(paramInt));
    if (localn != null) {
      localn.f();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    n localn = (n)this.b.get(Integer.valueOf(paramInt));
    if (localn == null) {
      return;
    }
    localn.a().a(new w.5(this, localn, paramString));
  }
  
  protected void a(@NonNull Context paramContext, @NonNull n paramn, d paramd)
  {
    o.b("MicroMsg.V8EngineWorkerManager", "hy: not support bind native in nano case");
  }
  
  protected void a(n paramn, w.a parama)
  {
    o.d("MicroMsg.V8EngineWorkerManager", "hy: evaluating %s", new Object[] { parama.a });
    paramn.a(parama.a, parama.b, null);
  }
  
  public void b()
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      ((n)localIterator.next()).a().h();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      ((n)localIterator.next()).a().i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.w
 * JD-Core Version:    0.7.0.1
 */