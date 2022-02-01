package com.tencent.luggage.wxa.lg;

import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.kd.h;
import com.tencent.luggage.wxa.nz.g;
import com.tencent.luggage.wxa.nz.j;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.rc.d;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;

public class a
  implements h
{
  private com.tencent.luggage.wxa.kd.a a;
  
  public a(com.tencent.luggage.wxa.kd.a parama)
  {
    this.a = parama;
  }
  
  private void a(c paramc, String paramString1, String paramString2)
  {
    com.tencent.luggage.wxa.qz.o.c("MicroMsg.BaseCreateUploadTask", "sendFailMsg, uploadTaskId = %s, errMsg = %s", new Object[] { paramString1, paramString2 });
    HashMap localHashMap = new HashMap();
    localHashMap.put("uploadTaskId", paramString1);
    localHashMap.put("state", "fail");
    localHashMap.put("errMsg", paramString2);
    paramString2 = new JSONObject(localHashMap).toString();
    new a.a().b(paramc).b(paramString2).a(this.a.a(paramString1));
    this.a.b(paramString1);
  }
  
  private boolean a(c paramc, String paramString)
  {
    paramc = com.tencent.luggage.wxa.nz.i.b().a(paramc.getAppId());
    if ((paramc != null) && (paramc.b(paramString)))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BaseCreateUploadTask", "upload abort %s", new Object[] { paramString });
      return true;
    }
    return false;
  }
  
  public void a(c paramc, JSONObject paramJSONObject, String paramString)
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.BaseCreateUploadTask", "JsApiCreateUploadTask");
    String str3 = paramc.getAppId();
    String str1 = paramJSONObject.optString("filePath");
    if (af.c(str1))
    {
      a(paramc, paramString, "filePath is null");
      return;
    }
    Object localObject = paramc.getFileSystem().g(str1);
    if ((localObject != null) && (((com.tencent.luggage.wxa.rt.i)localObject).j()))
    {
      localObject = ((com.tencent.luggage.wxa.rt.i)localObject).l();
      String str2 = d.b(str1);
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.BaseCreateUploadTask", "upload appId(%s) tempFilePath(%s) realFilePath(%s)", new Object[] { paramc.getAppId(), str1, localObject });
      a.1 local1 = new a.1(this, paramString, (String)localObject, paramc);
      com.tencent.luggage.wxa.nz.a locala = (com.tencent.luggage.wxa.nz.a)paramc.b(com.tencent.luggage.wxa.nz.a.class);
      Map localMap = j.a(paramJSONObject, locala);
      String str4 = paramJSONObject.optString("url");
      if (af.c(str4))
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.BaseCreateUploadTask", "url is null");
        a(paramc, paramString, "url is null or nil");
        return;
      }
      boolean bool;
      if (paramJSONObject.optBoolean("__skipDomainCheck__")) {
        bool = false;
      } else {
        bool = locala.b;
      }
      if ((bool) && (!j.a(locala.m, str4)))
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.BaseCreateUploadTask", "not in domain url %s", new Object[] { str4 });
        a(paramc, paramString, "url not in domain list");
        return;
      }
      if (locala.i <= 0) {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.BaseCreateUploadTask", "concurrent <= 0 ");
      }
      int j = paramJSONObject.optInt("timeout", 0);
      int i = j;
      if (j <= 0) {
        i = j.a(locala, 2);
      }
      if (i <= 0) {
        i = 60000;
      }
      if (com.tencent.luggage.wxa.nz.i.b().a(str3) == null)
      {
        paramc = new g(paramc);
        com.tencent.luggage.wxa.nz.i.b().a(str3, paramc);
      }
      else
      {
        paramc = com.tencent.luggage.wxa.nz.i.b().a(str3);
      }
      str1 = FilenameUtils.getName(str1);
      if (paramc != null)
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.BaseCreateUploadTask", "before do upload, checkDomains = %b, timeout %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        if (!bool)
        {
          paramc.a(i, str2, (String)localObject, paramJSONObject, localMap, null, local1, paramString, "createUploadTask", str1);
          return;
        }
        paramc.a(i, str2, (String)localObject, paramJSONObject, localMap, locala.m, local1, paramString, "createUploadTask", str1);
      }
      return;
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.BaseCreateUploadTask", "upload appId(%s) tempFilePath(%s), found no real file", new Object[] { paramc.getAppId(), str1 });
    a(paramc, paramString, "fail:file doesn't exist");
  }
  
  public String x_()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.luggage.wxa.nz.i.b().a());
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public String y_()
  {
    return "uploadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lg.a
 * JD-Core Version:    0.7.0.1
 */