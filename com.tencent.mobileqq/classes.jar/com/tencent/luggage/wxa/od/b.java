package com.tencent.luggage.wxa.od;

import android.webkit.JavascriptInterface;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.oe.b.a;
import com.tencent.luggage.wxa.oe.d;
import com.tencent.luggage.wxa.oe.e;
import com.tencent.luggage.wxa.oe.e.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.f;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class b
  implements b.a, e.a
{
  private final h b;
  private final com.tencent.mm.plugin.appbrand.jsruntime.i c;
  private final Map<Integer, Integer> d;
  private final c e;
  
  public b(h paramh, com.tencent.mm.plugin.appbrand.jsruntime.i parami)
  {
    this.b = paramh;
    this.c = parami;
    this.e = c.a(this, paramh);
    this.d = new ConcurrentHashMap();
  }
  
  public void a()
  {
    o.d("MicroMsg.NodeJavaBroker", "shutdown");
    Iterator localIterator = this.d.entrySet().iterator();
    while (localIterator.hasNext()) {
      unListen(((Integer)((Map.Entry)localIterator.next()).getKey()).intValue());
    }
    this.d.clear();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt <= 0) {
      return;
    }
    paramString = String.format("typeof gNodeController != 'undefined' && gNodeController.javaResp(%d, %s);", new Object[] { Integer.valueOf(paramInt), paramString });
    this.c.evaluateJavascript(paramString, null);
  }
  
  public void a(int paramInt, Map<String, Object> paramMap)
  {
    com.tencent.luggage.util.g.a(paramMap);
    paramMap = String.format("typeof gNodeController != 'undefined' && gNodeController.javaOnTrigger(%d, %s);", new Object[] { Integer.valueOf(paramInt), new com.tencent.luggage.wxa.hv.i(paramMap).toString() });
    this.c.evaluateJavascript(paramMap, null);
  }
  
  @JavascriptInterface
  public void listen(int paramInt1, int paramInt2)
  {
    e locale = this.e.a(paramInt1);
    if (locale == null)
    {
      o.b("MicroMsg.NodeJavaBroker", "listen listenerProxy null");
      return;
    }
    locale.a(paramInt2);
    this.d.put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
  }
  
  @JavascriptInterface
  public void req(int paramInt1, String paramString, int paramInt2)
  {
    o.f("MicroMsg.NodeJavaBroker", "req: cmd:%d args:%s respId:%d", new Object[] { Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2) });
    Object localObject = a.a(paramInt1);
    if ((!a) && (localObject == null)) {
      throw new AssertionError();
    }
    if ((localObject instanceof com.tencent.luggage.wxa.oe.b))
    {
      localObject = (com.tencent.luggage.wxa.oe.b)localObject;
      paramString = new b.1(this, paramInt2, (com.tencent.luggage.wxa.oe.b)localObject, paramString);
      if (((com.tencent.luggage.wxa.oe.b)localObject).c())
      {
        paramString.run();
        return;
      }
      if (((com.tencent.luggage.wxa.oe.b)localObject).b())
      {
        f.a.a(paramString);
        return;
      }
      f.a.c(paramString);
      return;
    }
    throw new IllegalStateException("req asynchronously, but target cmd not async!");
  }
  
  @JavascriptInterface
  public String reqSync(int paramInt, String paramString)
  {
    o.f("MicroMsg.NodeJavaBroker", "reqSync: cmd:%d args:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    com.tencent.luggage.wxa.oe.a locala = a.a(paramInt);
    if ((!a) && (locala == null)) {
      throw new AssertionError();
    }
    if ((locala instanceof d)) {
      return ((d)locala).a(paramString, new com.tencent.luggage.wxa.oe.c(this.b));
    }
    throw new IllegalStateException("req synchronously, but target cmd not sync!");
  }
  
  @JavascriptInterface
  public void unListen(int paramInt)
  {
    Object localObject = (Integer)this.d.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      return;
    }
    int i = ((Integer)localObject).intValue();
    o.f("MicroMsg.NodeJavaBroker", "unListen: listenerType:%d listenerId:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    localObject = this.e.a(i);
    if (localObject == null)
    {
      o.b("MicroMsg.NodeJavaBroker", "unListen listenerProxy null");
      return;
    }
    ((e)localObject).b(paramInt);
    this.d.remove(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.od.b
 * JD-Core Version:    0.7.0.1
 */