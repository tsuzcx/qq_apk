package com.tencent.luggage.wxa.on;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ln.v;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.joor.Reflect;
import org.joor.ReflectException;

public class c
{
  private static final Map<Class<? extends com.tencent.luggage.wxa.jx.b>, Integer> a = new ConcurrentHashMap();
  private static final Map<Class<? extends com.tencent.luggage.wxa.jx.b>, String> b = new ConcurrentHashMap();
  private static final String[] l = { "createSocketTask", "createDownloadTask", "createRequestTask", "createUploadTask", "createUploadTaskAsync", "createRequestTaskAsync", "createUploadTaskAsync" };
  private final com.tencent.luggage.wxa.iu.d c;
  private final int d;
  private final boolean e;
  private final LinkedList<c.b> f = new LinkedList();
  private final Object g;
  private b h;
  private final byte[] i;
  private HashMap<String, b> j = new HashMap();
  private List<c.c> k = new ArrayList();
  
  public c(@NonNull com.tencent.luggage.wxa.iu.d paramd, int paramInt, boolean paramBoolean)
  {
    this.c = paramd;
    this.g = new byte[0];
    this.i = new byte[0];
    this.d = paramInt;
    this.e = paramBoolean;
    b localb = (b)paramd.a(b.class, false);
    if (localb == null) {
      o.b("MicroMsg.AppRuntimeApiPermissionController[permission]", "<init> get NULL permission from runtime");
    }
    a(localb);
    if ((d)paramd.a(d.class, false) != null)
    {
      this.j = ((d)paramd.a(d.class, false)).a();
      paramd = this.j;
      if (paramd == null) {
        paramInt = 0;
      } else {
        paramInt = paramd.size();
      }
      o.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "mPluginPermission size:%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  private int a(com.tencent.luggage.wxa.jx.c paramc, Class<? extends com.tencent.luggage.wxa.jx.b> paramClass, String paramString, int paramInt, boolean paramBoolean)
  {
    int m = this.d;
    String str1 = paramc.getAppId();
    if (m == -1)
    {
      o.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm on", new Object[] { str1, Integer.valueOf(paramInt) });
      return 1;
    }
    if (m == -2)
    {
      o.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm off", new Object[] { str1, Integer.valueOf(paramInt) });
      return 0;
    }
    if ((paramClass.isAssignableFrom(v.class)) && ((paramc instanceof u))) {
      return 1;
    }
    String str2 = b(paramClass);
    m = a.a(paramc, str2, paramString);
    if (m != -2147483648) {
      return m;
    }
    paramString = new com.tencent.luggage.wxa.ix.b[1];
    byte[] arrayOfByte = a(paramc, paramString);
    int n = a(arrayOfByte, paramInt);
    if (paramBoolean)
    {
      paramc = (j)paramc.a(j.class);
      if ((paramc != null) && (paramc.a(paramClass))) {
        m = 0;
      } else {
        m = 1;
      }
      if (m != 0) {
        o.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, apiName = %s, state = %s, ctrlIndex = %d, ctrlIndexLength %d, checkRet %d", new Object[] { str1, str2, paramString[0], Integer.valueOf(paramInt), Integer.valueOf(arrayOfByte.length), Integer.valueOf(n) });
      }
    }
    return n;
  }
  
  private static int a(Class<? extends com.tencent.luggage.wxa.jx.b> paramClass)
  {
    Object localObject = (Integer)a.get(paramClass);
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    int m = -1;
    try
    {
      int n = ((Integer)Reflect.on(paramClass).get("CTRL_INDEX")).intValue();
      m = n;
    }
    catch (ReflectException localReflectException)
    {
      label45:
      break label45;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Must declare CTRL_INDEX in JsApi Class: ");
    ((StringBuilder)localObject).append(paramClass.getName());
    junit.framework.a.a(((StringBuilder)localObject).toString(), true);
    a.put(paramClass, Integer.valueOf(m));
    return m;
  }
  
  private b a(String paramString)
  {
    synchronized (this.i)
    {
      if (this.j == null) {
        return null;
      }
      paramString = (b)this.j.get(paramString);
      return paramString;
    }
  }
  
  private void a(c.b paramb)
  {
    if (paramb == null) {
      return;
    }
    synchronized (this.f)
    {
      this.f.addLast(paramb);
      return;
    }
  }
  
  private byte[] a(com.tencent.luggage.wxa.jx.c paramc, @Nullable com.tencent.luggage.wxa.ix.b[] paramArrayOfb)
  {
    int m = this.d;
    if (m == -1) {
      return new byte[] { 1 };
    }
    if (m == -2) {
      return new byte[] { 0 };
    }
    Object localObject = d();
    if ((paramc instanceof com.tencent.luggage.wxa.iu.h))
    {
      paramc = c.2.a;
      com.tencent.luggage.wxa.ix.b localb = this.c.al().a();
      m = paramc[localb.ordinal()];
      if ((m != 1) && (m != 2) && (m != 3)) {
        paramc = ((b)localObject).a;
      } else {
        paramc = ((b)localObject).b;
      }
      localObject = paramc;
      if (paramArrayOfb != null)
      {
        localObject = paramc;
        if (paramArrayOfb.length >= 1)
        {
          paramArrayOfb[0] = localb;
          return paramc;
        }
      }
    }
    else
    {
      localObject = ((b)localObject).a;
    }
    return localObject;
  }
  
  private static String b(Class<? extends com.tencent.luggage.wxa.jx.b> paramClass)
  {
    Object localObject = (String)b.get(paramClass);
    if (!af.c((String)localObject)) {
      return localObject;
    }
    try
    {
      localObject = (String)Reflect.on(paramClass).get("NAME");
      b.put(paramClass, localObject);
      return localObject;
    }
    catch (ReflectException localReflectException)
    {
      label49:
      break label49;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Must declare NAME in JsApi Class: ");
    ((StringBuilder)localObject).append(paramClass.getName());
    junit.framework.a.a(((StringBuilder)localObject).toString(), true);
    return paramClass.getSimpleName();
  }
  
  private void b(com.tencent.luggage.wxa.jx.c paramc, String paramString)
  {
    if (paramc == null) {
      paramc = null;
    } else {
      paramc = (i)paramc.a(i.class);
    }
    if (paramc != null) {
      paramc.a(paramString);
    }
  }
  
  private void b(b paramb)
  {
    byte[] arrayOfByte1 = paramb.a;
    byte[] arrayOfByte2 = paramb.b;
    paramb = paramb.c;
    int m = 0;
    while (m < this.k.size())
    {
      ((c.c)this.k.get(m)).a(arrayOfByte1, arrayOfByte2, paramb);
      m += 1;
    }
  }
  
  private b d()
  {
    synchronized (this.g)
    {
      b localb = this.h;
      return localb;
    }
  }
  
  private void e()
  {
    synchronized (this.f)
    {
      this.f.clear();
      return;
    }
  }
  
  public int a(com.tencent.luggage.wxa.jx.c paramc, com.tencent.luggage.wxa.jx.b paramb, String paramString, boolean paramBoolean)
  {
    return a(paramc, paramb.getClass(), paramString, a(paramb.getClass()), paramBoolean);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NonNull
  public c.a a(com.tencent.luggage.wxa.jx.c paramc, com.tencent.luggage.wxa.jx.b paramb, String paramString, int paramInt, @Nullable c.b paramb1)
  {
    if ((paramb != null) && (paramc != null))
    {
      com.tencent.luggage.wxa.ix.b localb = this.c.al().a();
      int m = a(paramc, paramb, paramString, true);
      String str = paramc.getAppId();
      if (m == 6)
      {
        b(paramc, paramb.d());
        return c.a.b();
      }
      if (m == 1)
      {
        if (((paramc instanceof com.tencent.luggage.wxa.iu.h)) && (localb == com.tencent.luggage.wxa.ix.b.c) && (com.tencent.luggage.wxa.he.a.a(l, paramb.d()))) {
          return new c.a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramb.d(), localb.a(), "permission ok", "network api interrupted in suspend state" }));
        }
        return c.a.a();
      }
      if (m == 4)
      {
        if (com.tencent.luggage.wxa.oo.a.a(str, paramb.d())) {
          return c.a.a();
        }
        if (com.tencent.luggage.wxa.oo.a.a((com.tencent.luggage.wxa.jx.h)paramc, paramb.d())) {
          return c.a.a();
        }
        com.tencent.luggage.wxa.oo.a.a(new com.tencent.luggage.wxa.oo.d((com.tencent.luggage.wxa.iu.b)paramc, paramb.d(), paramString, paramInt), new c.1(this, paramb1));
        return c.a.e();
      }
      if (m == 7)
      {
        if (this.c.al().k()) {
          return c.a.a();
        }
        return new c.a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramb.d(), localb.a(), "permission ok", "jsapi permission required playing audio but current not playing audio in background state" }));
      }
      if (m == 8)
      {
        a(paramb1);
        return c.a.e();
      }
      return c.a.b();
    }
    return c.a.b();
  }
  
  public void a()
  {
    e();
  }
  
  public void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    synchronized (this.g)
    {
      b localb = this.h;
      if ((localb != null) && (localb.a.length > paramb.a.length))
      {
        o.b("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission, old %s, new %s, ignore", new Object[] { localb, paramb });
        return;
      }
      this.h = paramb;
      b(this.h);
      o.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission old %s, updated %s", new Object[] { localb, paramb });
      return;
    }
  }
  
  public void a(c.c paramc)
  {
    synchronized (this.g)
    {
      this.k.add(paramc);
      return;
    }
  }
  
  public boolean a(com.tencent.luggage.wxa.jx.c paramc, Class<? extends com.tencent.luggage.wxa.jx.b> paramClass)
  {
    int m = a(paramc, paramClass, null, a(paramClass), false);
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 4)
        {
          if (m != 6)
          {
            if (m != 7) {
              return m == 8;
            }
            return this.c.al().k();
          }
          b(paramc, b(paramClass));
        }
        return false;
      }
      return true;
    }
    return false;
  }
  
  public byte[] a(com.tencent.luggage.wxa.jx.c paramc)
  {
    return a(paramc, null);
  }
  
  public byte[] a(com.tencent.luggage.wxa.jx.c paramc, String paramString)
  {
    int m = this.d;
    if (m == -1) {
      return new byte[] { 1 };
    }
    if (m == -2) {
      return new byte[] { 0 };
    }
    if (af.c(paramString)) {
      return null;
    }
    paramString = a(paramString);
    if (paramString == null) {
      return null;
    }
    if ((paramc instanceof com.tencent.luggage.wxa.iu.h))
    {
      m = c.2.a[this.c.al().a().ordinal()];
      if ((m != 1) && (m != 2) && (m != 3)) {
        return paramString.a;
      }
      return paramString.b;
    }
    return paramString.a;
  }
  
  public Vector<byte[]> b()
  {
    synchronized (this.g)
    {
      if (this.h == null) {
        return null;
      }
      byte[] arrayOfByte1 = this.h.a;
      byte[] arrayOfByte2 = this.h.b;
      byte[] arrayOfByte3 = this.h.c;
      ??? = new Vector(3);
      ((Vector)???).addElement(arrayOfByte1);
      ((Vector)???).addElement(arrayOfByte2);
      ((Vector)???).addElement(arrayOfByte3);
      return ???;
    }
  }
  
  public void b(c.c paramc)
  {
    synchronized (this.g)
    {
      this.k.remove(paramc);
      return;
    }
  }
  
  public void c()
  {
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.f)
    {
      localLinkedList.addAll(this.f);
      this.f.clear();
      ??? = localLinkedList.iterator();
      while (((Iterator)???).hasNext()) {
        ((c.b)((Iterator)???).next()).a(c.a.a());
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.on.c
 * JD-Core Version:    0.7.0.1
 */