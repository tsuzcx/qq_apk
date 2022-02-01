package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.luggage.wxa.jx.d;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;
import java.util.List;

class w$3
  implements JavaCallback
{
  w$3(w paramw, WeakReference paramWeakReference1, List paramList, WeakReference paramWeakReference2) {}
  
  public Object invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    paramV8Object = paramV8Array.getString(0);
    String str = paramV8Array.getString(1);
    int i = paramV8Array.getInteger(2);
    if (this.a.get() != null)
    {
      paramV8Array = (d)this.a.get();
      List localList = this.b;
      if ((localList != null) && (localList.contains(paramV8Object))) {
        return paramV8Array.a(paramV8Object, str, i, false, new w.3.2(this));
      }
      o.b("MicroMsg.V8EngineWorkerManager", "hy: calling not permitted api: %s", new Object[] { paramV8Object });
      paramV8Array.a(i, paramV8Array.c(paramV8Object, "fail:not supported"), new w.3.1(this));
      return "fail:not supported";
    }
    o.c("MicroMsg.V8EngineWorkerManager", "hy: component lost. stop dispatch");
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.w.3
 * JD-Core Version:    0.7.0.1
 */