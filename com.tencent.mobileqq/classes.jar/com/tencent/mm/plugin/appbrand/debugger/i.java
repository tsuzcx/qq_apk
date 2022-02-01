package com.tencent.mm.plugin.appbrand.debugger;

import android.webkit.ValueCallback;
import com.eclipsesource.mmv8.V8Inspector;
import com.tencent.luggage.wxa.du.c;
import com.tencent.luggage.wxa.pc.l.a;
import com.tencent.luggage.wxa.qu.b;
import com.tencent.luggage.wxa.qw.jo;
import com.tencent.luggage.wxa.qw.jp;
import com.tencent.luggage.wxa.qw.jq;
import com.tencent.luggage.wxa.qw.jr;
import com.tencent.luggage.wxa.qw.js;
import com.tencent.luggage.wxa.qw.jt;
import com.tencent.luggage.wxa.qw.ju;
import com.tencent.luggage.wxa.qw.jz;
import com.tencent.luggage.wxa.qw.kb;
import com.tencent.luggage.wxa.qw.ke;
import com.tencent.luggage.wxa.qw.kg;
import com.tencent.luggage.wxa.qw.ki;
import com.tencent.luggage.wxa.qw.kj;
import com.tencent.luggage.wxa.qw.kk;
import com.tencent.luggage.wxa.qw.km;
import com.tencent.luggage.wxa.qw.kn;
import com.tencent.luggage.wxa.qw.kp;
import com.tencent.luggage.wxa.qw.kv;
import com.tencent.luggage.wxa.qw.kx;
import com.tencent.luggage.wxa.qw.ky;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.p;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import org.json.JSONArray;

public class i
{
  private static final Map<String, String[]> a = new HashMap();
  private k b;
  private e c;
  private m d;
  private p<Integer, Long> e = new p(100);
  private boolean f = false;
  private long g;
  private LinkedList<h> h = new LinkedList();
  private final int i = 5000;
  private int j = 0;
  private long k = 0L;
  private Timer l;
  
  static
  {
    a.put("publishHandler", new String[] { "String", "String", "String" });
    a.put("invokeHandler", new String[] { "String", "String", "Number" });
  }
  
  public i()
  {
    V8Inspector.setServer(new i.1(this));
  }
  
  private void a(long paramLong, String paramString)
  {
    js localjs = new js();
    localjs.a = paramLong;
    localjs.b = paramString;
    a(l.a(localjs, this.c, "chromeDevtoolsResult"));
  }
  
  private void a(jo paramjo)
  {
    if (this.c.y() == paramjo.a) {
      return;
    }
    if (paramjo.a) {
      this.c.b(true);
    } else {
      this.c.b(false);
    }
    this.d.b();
    this.d.e();
  }
  
  private void a(jp paramjp)
  {
    o.d("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, method: %s, call_id %d", new Object[] { paramjp.b, Integer.valueOf(paramjp.d) });
    String str = paramjp.b;
    LinkedList localLinkedList1 = paramjp.c;
    if (!a.containsKey(str))
    {
      o.c("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodWithArgs is null");
      return;
    }
    Object localObject = (String[])a.get(str);
    if (localLinkedList1.size() < localObject.length)
    {
      o.c("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodArgValueList.size() < methodArgList.size()");
      return;
    }
    LinkedList localLinkedList2 = new LinkedList();
    int m = 0;
    while (m < localObject.length)
    {
      if ("Number".equals(localObject[m])) {
        localLinkedList2.add(Integer.valueOf(af.a((String)localLinkedList1.get(m), 0)));
      } else if ("Boolean".equals(localObject[m])) {
        localLinkedList2.add(Boolean.valueOf((String)localLinkedList1.get(m)));
      } else {
        localLinkedList2.add(localLinkedList1.get(m));
      }
      m += 1;
    }
    long l1 = System.currentTimeMillis();
    localObject = null;
    m = -1;
    int n = str.hashCode();
    if (n != 574772027)
    {
      if ((n == 810169266) && (str.equals("invokeHandler"))) {
        m = 1;
      }
    }
    else if (str.equals("publishHandler")) {
      m = 0;
    }
    if (m != 0)
    {
      if (m != 1)
      {
        o.c("MicroMsg.RemoteDebugMsgMrg", "onCallInterface callMethod is null");
        return;
      }
      localObject = this.c.a().b((String)String.class.cast(localLinkedList2.get(0)), (String)String.class.cast(localLinkedList2.get(1)), ((Integer)Integer.class.cast(localLinkedList2.get(2))).intValue());
    }
    else
    {
      this.c.a().a((String)String.class.cast(localLinkedList2.get(0)), (String)String.class.cast(localLinkedList2.get(1)), a((String)String.class.cast(localLinkedList2.get(2))));
    }
    if (localObject != null) {
      localObject = String.valueOf(localObject);
    } else {
      localObject = "";
    }
    if (!af.c((String)localObject)) {
      a(paramjp.d, (String)localObject);
    }
    n = paramjp.d();
    if (localObject == null) {
      m = 0;
    } else {
      m = ((String)localObject).length();
    }
    j.a(str, localLinkedList1, l1, n, m);
  }
  
  private void a(jr paramjr)
  {
    V8Inspector.onReceiveData(paramjr.a, paramjr.b);
  }
  
  private void a(jt paramjt)
  {
    d locald = new d();
    locald.a = paramjt.d();
    locald.b = System.currentTimeMillis();
    this.c.g().put(paramjt.b, locald);
  }
  
  private void a(jz paramjz)
  {
    o.e("MicroMsg.RemoteDebugMsgMrg", "onDomOp");
    int m = this.c.a().i().k().getCurrentPage().getCurrentPageView().getComponentId();
    if (paramjz.b != m)
    {
      o.c("MicroMsg.RemoteDebugMsgMrg", "onDomOp id not current webViewId %d/%d", new Object[] { Integer.valueOf(paramjz.b), Integer.valueOf(m) });
      return;
    }
    this.c.a().a("remoteDebugCommand", paramjz.a, null);
  }
  
  private void a(kb paramkb)
  {
    o.d("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback %d", new Object[] { Integer.valueOf(paramkb.b) });
    int m = paramkb.b;
    String str = paramkb.a;
    a locala = (a)this.c.w().remove(Integer.valueOf(m));
    if (locala == null) {
      return;
    }
    Object localObject = locala.a;
    if (localObject != null) {
      ((ValueCallback)localObject).onReceiveValue(str);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEvaluateCallback, callback id: ");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append(" ret: ");
    ((StringBuilder)localObject).append(str);
    o.e("MicroMsg.RemoteDebugMsgMrg", ((StringBuilder)localObject).toString());
    j.a(locala, paramkb.d());
  }
  
  private void a(ki paramki)
  {
    kj localkj = new kj();
    localkj.a = paramki.a;
    localkj.b = j.a();
    o.d("MicroMsg.RemoteDebugMsgMrg", "onPing netType %d", new Object[] { Integer.valueOf(localkj.b) });
    a(l.a(localkj, this.c, "pong"));
  }
  
  private void a(LinkedList<h> paramLinkedList, boolean paramBoolean)
  {
    try
    {
      a(paramLinkedList, paramBoolean, false);
      return;
    }
    finally
    {
      paramLinkedList = finally;
      throw paramLinkedList;
    }
  }
  
  private void a(LinkedList<h> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      boolean bool = af.a(paramLinkedList);
      if (bool) {
        return;
      }
      Object localObject = new km();
      ((km)localObject).a = this.c.b();
      ((km)localObject).c = this.c.d();
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        ((km)localObject).b.add(localh.b);
      }
      localObject = l.a(1006, (com.tencent.luggage.wxa.qu.a)localObject);
      if ((this.c.u()) && (!paramBoolean2))
      {
        o.e("MicroMsg.RemoteDebugMsgMrg", "sendMsg busy");
      }
      else
      {
        o.e("MicroMsg.RemoteDebugMsgMrg", "sendMsg size %d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
        this.b.a((jt)localObject);
      }
      if (paramBoolean1) {
        c(paramLinkedList);
      }
      this.d.a(((jt)localObject).a);
      this.c.m();
      if (!this.c.u()) {
        this.j = 0;
      }
      a((jt)localObject);
      return;
    }
    finally {}
    for (;;)
    {
      throw paramLinkedList;
    }
  }
  
  private int[] a(String paramString)
  {
    int m = 0;
    localObject2 = new int[0];
    Object localObject1 = localObject2;
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      localObject1 = localObject2;
      paramString = new int[localJSONArray.length()];
      for (;;)
      {
        localObject1 = paramString;
        localObject2 = paramString;
        if (m >= localJSONArray.length()) {
          break;
        }
        localObject1 = paramString;
        paramString[m] = localJSONArray.getInt(m);
        m += 1;
      }
      return localObject2;
    }
    catch (Exception paramString)
    {
      o.b("MicroMsg.RemoteDebugMsgMrg", paramString.getMessage());
      localObject2 = localObject1;
    }
  }
  
  private void b(LinkedList<ju> paramLinkedList)
  {
    if (af.a(paramLinkedList))
    {
      o.c("MicroMsg.RemoteDebugMsgMrg", "handleMsg list is null");
      return;
    }
    Iterator localIterator = a(paramLinkedList).iterator();
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      int m = 0;
      if (!bool) {
        break;
      }
      Object localObject = (ju)localIterator.next();
      byte[] arrayOfByte;
      if (l.a(((ju)localObject).e)) {
        arrayOfByte = com.tencent.luggage.wxa.gl.j.b(((ju)localObject).d.c());
      } else {
        arrayOfByte = ((ju)localObject).d.c();
      }
      localObject = ((ju)localObject).c;
      switch (((String)localObject).hashCode())
      {
      default: 
        break;
      case 1319027697: 
        if (((String)localObject).equals("breakpoint")) {
          m = 3;
        }
        break;
      case 95766211: 
        if (((String)localObject).equals("domOp")) {
          m = 4;
        }
        break;
      case 52537216: 
        if (((String)localObject).equals("chromeDevtools")) {
          m = 5;
        }
        break;
      case 3441010: 
        if (((String)localObject).equals("ping")) {
          m = 2;
        }
        break;
      case -217209181: 
        if (((String)localObject).equals("evaluateJavascriptResult")) {
          m = 1;
        }
        break;
      case -1680221061: 
        if (((String)localObject).equals("callInterface")) {
          break label259;
        }
      }
      m = -1;
      label259:
      if (m != 0)
      {
        if (m != 1)
        {
          if (m != 2)
          {
            if (m != 3)
            {
              if (m != 4)
              {
                if (m == 5) {
                  a((jr)new jr().a(arrayOfByte));
                }
              }
              else {
                a((jz)new jz().a(arrayOfByte));
              }
            }
            else {
              a((jo)new jo().a(arrayOfByte));
            }
          }
          else {
            a((ki)new ki().a(arrayOfByte));
          }
        }
        else {
          a((kb)new kb().a(arrayOfByte));
        }
      }
      else {
        a((jp)new jp().a(arrayOfByte));
      }
    }
    o.d("MicroMsg.RemoteDebugMsgMrg", "handleMsg size %d, ack %d", new Object[] { Integer.valueOf(paramLinkedList.size()), Integer.valueOf(this.c.d()) });
    this.c.d(paramLinkedList.size());
    a();
  }
  
  private void c(LinkedList<h> paramLinkedList)
  {
    try
    {
      o.e("MicroMsg.RemoteDebugMsgMrg", "addToSendingMsg");
      boolean bool = af.a(paramLinkedList);
      if (bool) {
        return;
      }
      this.c.f().addAll(paramLinkedList);
      return;
    }
    finally {}
  }
  
  private void k()
  {
    long l1 = System.currentTimeMillis();
    synchronized (this.c.z())
    {
      if ((this.f) && (l1 - this.g < 32L)) {
        return;
      }
      this.g = l1;
      if (af.a(this.h)) {
        return;
      }
      this.f = true;
      int m = (int)(16L - (System.currentTimeMillis() - this.c.l()));
      if (m <= 0) {
        m = 16;
      }
      com.tencent.luggage.wxa.pd.d.a().a(new i.3(this), m);
      return;
    }
  }
  
  private void l()
  {
    this.c.c(4);
    this.b.a(1000, "quit");
  }
  
  public LinkedList<ju> a(LinkedList<ju> paramLinkedList)
  {
    if (paramLinkedList == null) {
      return null;
    }
    try
    {
      LinkedList localLinkedList1 = new LinkedList();
      LinkedList localLinkedList2 = new LinkedList();
      this.c.h().addAll(paramLinkedList);
      Collections.sort(this.c.h(), new i.2(this));
      int m = this.c.d();
      paramLinkedList = this.c.h().iterator();
      while (paramLinkedList.hasNext())
      {
        ju localju = (ju)paramLinkedList.next();
        if (localju != null) {
          if (localju.a <= m)
          {
            localLinkedList2.add(localju);
          }
          else
          {
            if (localju.a - m != 1) {
              break;
            }
            localLinkedList1.add(localju);
            m = localju.a;
          }
        }
      }
      this.c.a(m);
      this.c.h().removeAll(localLinkedList1);
      this.c.h().removeAll(localLinkedList2);
      o.e("MicroMsg.RemoteDebugMsgMrg", "getHandleMsgList size: %d", new Object[] { Integer.valueOf(localLinkedList1.size()) });
      return localLinkedList1;
    }
    finally {}
    for (;;)
    {
      throw paramLinkedList;
    }
  }
  
  public void a()
  {
    int m = 0;
    try
    {
      while (m < this.c.h().size())
      {
        int n;
        if (m == 0) {
          n = this.c.d();
        } else {
          n = ((ju)this.c.h().get(m - 1)).a;
        }
        int i1 = ((ju)this.c.h().get(m)).a;
        if (n - i1 != 1) {
          a(n + 1, i1 - 1);
        }
        m += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    o.d("MicroMsg.RemoteDebugMsgMrg", "sync minSeq %d, maxSeq %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > paramInt2) {
      return;
    }
    long l1 = System.currentTimeMillis();
    if ((this.e.b(Integer.valueOf(paramInt1)) != null) && (l1 - ((Long)this.e.b(Integer.valueOf(paramInt1))).longValue() < 3000L))
    {
      o.d("MicroMsg.RemoteDebugMsgMrg", "sync too fast!");
      return;
    }
    this.e.a(Integer.valueOf(paramInt1), Long.valueOf(l1));
    Object localObject = new kx();
    ((kx)localObject).a = this.c.b();
    ((kx)localObject).b = paramInt1;
    ((kx)localObject).c = paramInt2;
    localObject = l.a(1005, (com.tencent.luggage.wxa.qu.a)localObject);
    this.b.a((jt)localObject);
    this.c.s();
  }
  
  public void a(int paramInt, String paramString)
  {
    jq localjq = new jq();
    localjq.b = paramInt;
    localjq.a = paramString;
    a(l.a(localjq, this.c, "callInterfaceResult"));
  }
  
  public void a(ke paramke)
  {
    b(paramke.a);
  }
  
  public void a(kk paramkk)
  {
    paramkk.a = "WeixinJSCore";
    Iterator localIterator = a.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((String[])a.get(str)).length > 5)
      {
        o.b("MicroMsg.RemoteDebugMsgMrg", "Interface method only support five arguments!");
      }
      else
      {
        kg localkg = new kg();
        localkg.a = str;
        int m = 0;
        while (m < ((String[])a.get(str)).length)
        {
          localkg.b.add(((String[])a.get(str))[m]);
          m += 1;
        }
        paramkk.b.add(localkg);
      }
    }
  }
  
  public void a(kn paramkn, jt paramjt)
  {
    if (!l.a(this.c, paramjt, paramkn.a, this.d, this)) {
      return;
    }
    o.e("MicroMsg.RemoteDebugMsgMrg", "onSendMsgResult %d/%d", new Object[] { Integer.valueOf(paramkn.b), Integer.valueOf(paramkn.c) });
    this.c.a(paramkn.b, paramkn.c);
    b(paramkn.b, paramkn.c);
  }
  
  public void a(ky paramky, jt paramjt)
  {
    o.e("MicroMsg.RemoteDebugMsgMrg", "onSync");
    if (!l.a(this.c, paramjt, paramky.a, this.d, this)) {
      return;
    }
    b(paramky.b);
    this.c.b(paramky.c);
    g();
  }
  
  public void a(h paramh)
  {
    if (!this.c.G()) {
      synchronized (this.c.z())
      {
        if ((System.currentTimeMillis() - this.c.l() > 16L) && (!this.f)) {
          break label74;
        }
        this.h.add(paramh);
        k();
        return;
      }
    }
    label74:
    ??? = new LinkedList();
    ((LinkedList)???).add(paramh);
    a((LinkedList)???, true);
  }
  
  public void a(k paramk, e parame, m paramm)
  {
    this.b = paramk;
    this.c = parame;
    this.d = paramm;
  }
  
  public void b()
  {
    try
    {
      boolean bool = this.c.u();
      if (bool) {
        return;
      }
      long l1 = System.currentTimeMillis();
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.c.f().iterator();
      int m = 0;
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        if (l1 - localh.a > 5000L)
        {
          localh.a();
          localLinkedList.add(localh);
          m += localh.c;
          if ((m >= 65536L) || (localLinkedList.size() > 800))
          {
            o.d("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
            a(localLinkedList, false);
            localLinkedList.clear();
          }
        }
      }
      if (!af.a(localLinkedList))
      {
        o.d("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", new Object[] { Integer.valueOf(localLinkedList.size()) });
        a(localLinkedList, false);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    try
    {
      o.e("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg with min max");
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.c.f().iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        if (localh.b == null) {
          localLinkedList.add(localh);
        } else if ((localh.b.a >= paramInt1) && (localh.b.a <= paramInt2)) {
          localLinkedList.add(localh);
        }
      }
      this.c.f().removeAll(localLinkedList);
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean c()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.k;
      int m = this.j;
      if (l1 - l2 < m) {
        return false;
      }
      this.k = l1;
      if (this.j < 5000) {
        this.j += 1000;
      } else {
        this.j = 2000;
      }
      LinkedList localLinkedList = new LinkedList();
      Object localObject2 = this.c.f().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        h localh = (h)((Iterator)localObject2).next();
        if (l1 - localh.a > 5000L)
        {
          localh.a();
          localLinkedList.add(localh);
          a(localLinkedList, false, true);
          return true;
        }
      }
      if (this.c.f().size() > 0)
      {
        localObject2 = (h)this.c.f().get(0);
        ((h)localObject2).a();
        localLinkedList.add(localObject2);
        a(localLinkedList, false, true);
        return true;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void d()
  {
    o.d("MicroMsg.RemoteDebugMsgMrg", "quit");
    Object localObject = new kv();
    ((kv)localObject).a = this.c.b();
    localObject = l.a(1004, (com.tencent.luggage.wxa.qu.a)localObject);
    this.b.a((jt)localObject);
  }
  
  public void e()
  {
    o.d("MicroMsg.RemoteDebugMsgMrg", "onQuit");
    l();
    this.d.g();
  }
  
  public void f()
  {
    o.d("MicroMsg.RemoteDebugMsgMrg", "onQuitSilent");
    l();
    this.d.a();
  }
  
  public void g()
  {
    try
    {
      o.e("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg");
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.c.f().iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        if (localh.b == null) {
          localLinkedList.add(localh);
        } else if (localh.b.a <= this.c.e()) {
          localLinkedList.add(localh);
        }
      }
      this.c.f().removeAll(localLinkedList);
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void h()
  {
    o.d("MicroMsg.RemoteDebugMsgMrg", "onClose");
    Timer localTimer = this.l;
    if (localTimer != null) {
      localTimer.cancel();
    }
  }
  
  public void i()
  {
    h();
    this.l = new Timer();
    i.4 local4 = new i.4(this);
    this.l.schedule(local4, 100L, 1000L);
  }
  
  public void j()
  {
    Object localObject = new kp();
    ((kp)localObject).a = this.c.b();
    ((kp)localObject).b = this.c.d();
    localObject = l.a(1001, (com.tencent.luggage.wxa.qu.a)localObject);
    this.b.a((jt)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.i
 * JD-Core Version:    0.7.0.1
 */