package com.tencent.luggage.wxa.om;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"DefaultLocale"})
public class b
{
  protected static final SparseArray<b.a> a = new SparseArray();
  
  public static void a(d paramd)
  {
    String str = paramd.aa();
    o.e("MicroMsg.AppBrandPerformanceManager", "startMonitoring, appId: %s", new Object[] { str });
    b.a locala2 = (b.a)a.get(str.hashCode());
    b.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new b.a(paramd);
      a.put(str.hashCode(), locala1);
    }
    locala1.a();
  }
  
  public static void a(d paramd, int paramInt, String paramString)
  {
    String str = paramd.aa();
    paramd = paramd.p();
    if (paramd == null)
    {
      paramd = com.tencent.luggage.wxa.id.a.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str.hashCode());
      localStringBuilder.append("performance_data");
      paramd.a(localStringBuilder.toString(), true).a(String.valueOf(paramInt), paramString);
      return;
    }
    paramd.a(paramInt, paramString);
  }
  
  public static void a(d paramd, String paramString1, String paramString2)
  {
    String str = paramd.aa();
    paramd = paramd.p();
    if (paramd == null)
    {
      paramd = com.tencent.luggage.wxa.id.a.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str.hashCode());
      localStringBuilder.append("performance_custom_data");
      paramd.a(localStringBuilder.toString(), true).a(paramString1, paramString2);
      return;
    }
    paramd.a(paramString1, paramString2);
  }
  
  public static void a(String paramString)
  {
    o.e("MicroMsg.AppBrandPerformanceManager", "stopMonitoring, appId: %s", new Object[] { paramString });
    int i = paramString.hashCode();
    paramString = (b.a)a.get(i);
    if (paramString != null)
    {
      a.remove(i);
      paramString.b();
    }
  }
  
  public static boolean b(d paramd)
  {
    paramd = (a)paramd.b(a.class);
    return (paramd != null) && (paramd.a);
  }
  
  public static void c(d paramd)
  {
    d(paramd);
    e(paramd);
  }
  
  private static void d(d paramd)
  {
    Object localObject1 = paramd.aa();
    paramd = paramd.p();
    Object localObject2 = com.tencent.luggage.wxa.id.a.a();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((String)localObject1).hashCode());
    ((StringBuilder)localObject3).append("performance_data");
    localObject1 = ((com.tencent.luggage.wxa.id.a)localObject2).b(((StringBuilder)localObject3).toString());
    if (paramd == null)
    {
      o.b("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData panel is not ready.");
      return;
    }
    if (localObject1 == null)
    {
      o.e("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData cache is empty.");
      return;
    }
    localObject2 = ((a.b)localObject1).a().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      String str = (String)((a.b)localObject1).c((String)localObject3);
      if (str != null) {
        paramd.a(af.a((String)localObject3, 0), str);
      }
    }
  }
  
  private static void e(d paramd)
  {
    Object localObject1 = paramd.aa();
    paramd = paramd.p();
    Object localObject2 = com.tencent.luggage.wxa.id.a.a();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((String)localObject1).hashCode());
    ((StringBuilder)localObject3).append("performance_custom_data");
    localObject1 = ((com.tencent.luggage.wxa.id.a)localObject2).b(((StringBuilder)localObject3).toString());
    if (paramd == null)
    {
      o.b("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData panel is not ready.");
      return;
    }
    if (localObject1 == null)
    {
      o.e("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData cache is empty.");
      return;
    }
    localObject2 = ((a.b)localObject1).a().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      String str = (String)((a.b)localObject1).c((String)localObject3);
      if (str != null) {
        paramd.a((String)localObject3, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.om.b
 * JD-Core Version:    0.7.0.1
 */