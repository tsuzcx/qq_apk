package com.tencent.luggage.wxa.le;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.kd.h;
import com.tencent.luggage.wxa.nz.b;
import com.tencent.luggage.wxa.nz.b.a;
import com.tencent.luggage.wxa.nz.b.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.rc.d;
import com.tencent.mars.cdn.CronetLogic;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class a
  implements h
{
  protected boolean a = false;
  private b.b b;
  private com.tencent.luggage.wxa.kd.a c;
  private final AtomicBoolean d = new AtomicBoolean(false);
  
  public a(b.b paramb, com.tencent.luggage.wxa.kd.a parama)
  {
    this.b = paramb;
    this.c = parama;
  }
  
  private void a(@NonNull com.tencent.luggage.wxa.jx.c paramc)
  {
    Object localObject = this.b;
    if (localObject != null) {
      this.a = ((b.b)localObject).a(paramc.getAppId());
    }
    if (this.a)
    {
      localObject = (com.tencent.luggage.wxa.nz.a)paramc.b(com.tencent.luggage.wxa.nz.a.class);
      CronetLogic.initializeNativeLib();
      if (localObject == null)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.BaseCreateDownloadTask", "setupRequestMode config not found, setUserCertVerify false appId(%s)", new Object[] { paramc.getAppId() });
        CronetLogic.setUserCertVerify(false);
        return;
      }
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BaseCreateDownloadTask", "setupRequestMode(%b),appId(%s)", new Object[] { Boolean.valueOf(((com.tencent.luggage.wxa.nz.a)localObject).A), paramc.getAppId() });
      CronetLogic.setUserCertVerify(((com.tencent.luggage.wxa.nz.a)localObject).A);
    }
  }
  
  private boolean a(com.tencent.luggage.wxa.jx.c paramc, String paramString)
  {
    paramc = com.tencent.luggage.wxa.nz.c.b().a(paramc.getAppId());
    if ((paramc != null) && (paramc.b(paramString)))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BaseCreateDownloadTask", "download abort %s", new Object[] { paramString });
      return true;
    }
    return false;
  }
  
  private String b(com.tencent.luggage.wxa.jx.c paramc, String paramString1, String paramString2)
  {
    String str2 = d.d(paramString2);
    String str1 = str2;
    if (af.c(str2))
    {
      str1 = str2;
      if ("audio/mp4".equals(paramString2)) {
        str1 = "mp4";
      }
    }
    paramString2 = new com.tencent.luggage.wxa.pc.i();
    if (paramc.getFileSystem().a(new com.tencent.luggage.wxa.rt.i(paramString1), str1, true, paramString2) != com.tencent.mm.plugin.appbrand.appstorage.j.a) {
      return null;
    }
    return (String)paramString2.a;
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, com.tencent.luggage.wxa.nz.a parama, boolean paramBoolean, JSONObject paramJSONObject, int paramInt, Map<String, String> paramMap, b.a parama1, String paramString)
  {
    b localb = com.tencent.luggage.wxa.nz.c.b().a(paramc.getAppId());
    if (localb == null)
    {
      localb = new b(paramc, this.a);
      com.tencent.luggage.wxa.nz.c.b().a(paramc.getAppId(), localb);
      paramc = localb;
    }
    else
    {
      paramc = localb;
    }
    if (paramc != null)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BaseCreateDownloadTask", "before do download, checkDomains = %b, timeout %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
      int i = parama.s;
      if (paramBoolean) {
        parama = parama.n;
      } else {
        parama = null;
      }
      paramc.a(paramJSONObject, paramInt, paramMap, parama, i, parama1, paramString, "createDownloadTask");
    }
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, String paramString1, String paramString2)
  {
    com.tencent.luggage.wxa.qz.o.c("MicroMsg.BaseCreateDownloadTask", "sendFailMsg, downloadTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("downloadTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a.a().b(paramc).b(paramString2).a(this.c.a(paramString1));
    this.c.b(paramString1);
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, String paramString)
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.BaseCreateDownloadTask", "JsApiCreateDownloadTask");
    if (!this.d.getAndSet(true)) {
      a(paramc);
    }
    paramc.getAppId();
    a.1 local1 = new a.1(this, paramJSONObject.optString("filePath"), paramc, paramString);
    com.tencent.luggage.wxa.nz.a locala = (com.tencent.luggage.wxa.nz.a)paramc.b(com.tencent.luggage.wxa.nz.a.class);
    Map localMap = com.tencent.luggage.wxa.nz.j.a(paramJSONObject, locala);
    String str = paramJSONObject.optString("url");
    if (af.c(str))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BaseCreateDownloadTask", "url is null");
      a(paramc, paramString, "url is null or nil");
      return;
    }
    boolean bool;
    if (paramJSONObject.optBoolean("__skipDomainCheck__")) {
      bool = false;
    } else {
      bool = locala.b;
    }
    if ((bool) && (!com.tencent.luggage.wxa.nz.j.a(locala.n, str)))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BaseCreateDownloadTask", "not in domain url %s", new Object[] { str });
      a(paramc, paramString, "url not in domain list");
      return;
    }
    if (locala.j <= 0) {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BaseCreateDownloadTask", "maxDownloadConcurrent <= 0 ");
    }
    int j = paramJSONObject.optInt("timeout", 0);
    int i = j;
    if (j <= 0) {
      i = com.tencent.luggage.wxa.nz.j.a(locala, 3);
    }
    if (i > 0) {
      j = i;
    } else {
      j = 60000;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.BaseCreateDownloadTask", "lm:configTimeout: %d,timeout: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    a(paramc, locala, bool, paramJSONObject, j, localMap, local1, paramString);
  }
  
  public String x_()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.luggage.wxa.nz.c.b().a());
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public String y_()
  {
    return "downloadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.le.a
 * JD-Core Version:    0.7.0.1
 */