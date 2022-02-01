package com.tencent.luggage.wxa.ov;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.ou.h;
import com.tencent.luggage.wxa.ou.k;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.concurrent.ConcurrentHashMap;

public final class l
{
  private static final ConcurrentHashMap<String, com.tencent.luggage.wxa.ed.d> a = new ConcurrentHashMap();
  
  public static void a(com.tencent.luggage.wxa.ed.d paramd)
  {
    if (paramd != null)
    {
      if (TextUtils.isEmpty(paramd.aa())) {
        return;
      }
      a.put(paramd.aa(), paramd);
      paramd.al().a(new l.1(paramd));
    }
  }
  
  private static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong1, long paramLong2, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7)
  {
    if (o.c() > 1) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("report kv_14510{");
    localStringBuilder.append("appId='");
    localStringBuilder.append(paramString1);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appVersion=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", appState=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", appType=");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", networkType='");
    localStringBuilder.append(paramString2);
    localStringBuilder.append('\'');
    localStringBuilder.append(", functionName='");
    localStringBuilder.append(paramString3);
    localStringBuilder.append('\'');
    localStringBuilder.append(", url='");
    localStringBuilder.append(paramString4);
    localStringBuilder.append('\'');
    localStringBuilder.append(", method='");
    localStringBuilder.append(paramString5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sentsize=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", receivedsize=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(", statusCode=");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append(", result=");
    localStringBuilder.append(paramInt5);
    localStringBuilder.append(", costtime=");
    localStringBuilder.append(paramInt6);
    localStringBuilder.append(", dstPath=");
    localStringBuilder.append(paramString6);
    localStringBuilder.append(", contentType=");
    localStringBuilder.append(paramString7);
    localStringBuilder.append('}');
    o.e("MicroMsg.AppBrand.Report.kv_14510", localStringBuilder.toString());
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6)
  {
    if (com.tencent.luggage.wxa.qz.af.c(paramString1))
    {
      o.b("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report fail, appId is null, functionName:%s method:%s url:%s", new Object[] { paramString2, paramString3, paramString4 });
      return;
    }
    Object localObject2 = (com.tencent.luggage.wxa.ed.d)a.get(paramString1);
    if ((localObject2 != null) && (((com.tencent.luggage.wxa.ed.d)localObject2).j() != null))
    {
      if (((com.tencent.luggage.wxa.ed.d)localObject2).i() == null) {
        return;
      }
      Object localObject1 = ((com.tencent.luggage.wxa.ed.d)localObject2).j();
      localObject2 = ((com.tencent.luggage.wxa.ed.d)localObject2).i();
      if (localObject2 != null)
      {
        paramString4 = k.a(paramString4);
        int i = ((com.tencent.luggage.wxa.jj.l)localObject2).S.pkgVersion;
        int j = ((com.tencent.luggage.wxa.jj.l)localObject2).c() + 1;
        localObject2 = h.a(r.a());
        int k = ((com.tencent.luggage.wxa.do.c)localObject1).c + 1000;
        localObject1 = (com.tencent.luggage.wxa.ot.d)e.b(com.tencent.luggage.wxa.ot.d.class);
        if (localObject1 == null) {
          return;
        }
        ((com.tencent.luggage.wxa.ot.d)localObject1).a(14510, new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(j), localObject2, paramString2, paramString4, paramString3, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString5, paramString6, Integer.valueOf(k) });
        a(paramString1, i, j, k, (String)localObject2, paramString2, paramString4, paramString3, paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, paramString5, paramString6);
        return;
      }
      o.c("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report config is null. %s", new Object[] { paramString1 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ov.l
 * JD-Core Version:    0.7.0.1
 */