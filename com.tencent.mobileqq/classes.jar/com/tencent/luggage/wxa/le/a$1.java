package com.tencent.luggage.wxa.le;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.nz.b;
import com.tencent.luggage.wxa.nz.b.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class a$1
  implements b.a
{
  private JSONObject e;
  
  a$1(a parama, String paramString1, c paramc, String paramString2) {}
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("downloadTaskId", this.c);
    ((Map)localObject).put("state", "progressUpdate");
    ((Map)localObject).put("progress", Integer.valueOf(paramInt));
    ((Map)localObject).put("totalBytesWritten", Long.valueOf(paramLong1));
    ((Map)localObject).put("totalBytesExpectedToWrite", Long.valueOf(paramLong2));
    localObject = new JSONObject((Map)localObject).toString();
    new a.a().b(this.b).b((String)localObject).a(a.a(this.d).a(this.c));
  }
  
  public void a(int paramInt, String paramString)
  {
    o.d("MicroMsg.BaseCreateDownloadTask", "onDownloadError  downloadTaskId = %s, errMsg = %d, error = %s", new Object[] { this.c, Integer.valueOf(paramInt), paramString });
    if (a.a(this.d, this.b, this.c)) {
      return;
    }
    this.d.a(this.b, this.c, paramString);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2, long paramLong, Map paramMap)
  {
    o.d("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode errMsg = %d, mimeType = %s, filePath = %s, statusCode = %d, dataLength = %d", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    if (!af.c(this.a))
    {
      paramString1 = com.tencent.luggage.wxa.ku.ah.a(this.b, new i(paramString2), this.a, null);
      if ((b.b != paramInt1) && ("ok".equals(paramString1)))
      {
        o.d("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode filePath %s", new Object[] { this.a });
        paramString1 = new HashMap();
        paramString1.put("downloadTaskId", this.c);
        paramString1.put("filePath", this.a);
        paramString1.put("dataLength", Long.valueOf(paramLong));
        paramString1.put("statusCode", Integer.valueOf(paramInt2));
        paramString1.put("state", "success");
        paramString2 = this.e;
        if (paramString2 != null) {
          paramString1.put("header", paramString2);
        }
        if ((paramMap != null) && (paramMap.size() > 0)) {
          paramString1.put("profile", paramMap);
        }
        paramString1 = new JSONObject(paramString1).toString();
        new a.a().b(this.b).b(paramString1).a(a.a(this.d).a(this.c));
        a.a(this.d).b(this.c);
        return;
      }
      if (a.a(this.d, this.b, this.c)) {
        return;
      }
      this.d.a(this.b, this.c, paramString1);
      return;
    }
    paramString2 = a.a(this.d, this.b, paramString2, paramString1);
    if ((paramInt1 != b.b) && (paramString2 != null))
    {
      o.d("MicroMsg.BaseCreateDownloadTask", "onDownloadResultWithCode localId %s", new Object[] { paramString2 });
      paramString1 = new HashMap();
      paramString1.put("downloadTaskId", this.c);
      paramString1.put("tempFilePath", paramString2);
      paramString1.put("dataLength", Long.valueOf(paramLong));
      paramString1.put("statusCode", Integer.valueOf(paramInt2));
      paramString1.put("state", "success");
      paramString2 = this.e;
      if (paramString2 != null) {
        paramString1.put("header", paramString2);
      }
      if ((paramMap != null) && (paramMap.size() > 0)) {
        paramString1.put("profile", paramMap);
      }
      paramString1 = new JSONObject(paramString1).toString();
      new a.a().b(this.b).b(paramString1).a(a.a(this.d).a(this.c));
      a.a(this.d).b(this.c);
      return;
    }
    if (a.a(this.d, this.b, this.c)) {
      return;
    }
    this.d.a(this.b, this.c, "download fail");
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    if (paramJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
    {
      if (!((com.tencent.luggage.wxa.nz.a)this.b.b(com.tencent.luggage.wxa.nz.a.class)).y) {
        return;
      }
      paramJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
      com.tencent.luggage.wxa.gz.a locala = new com.tencent.luggage.wxa.gz.a();
      locala.a.a = "download";
      locala.a.c = paramJSONObject;
      locala.a.b = this.c;
      com.tencent.luggage.wxa.qy.a.a.a(locala);
      return;
    }
    this.e = paramJSONObject;
    paramJSONObject = new HashMap();
    paramJSONObject.put("downloadTaskId", this.c);
    paramJSONObject.put("state", "headersReceived");
    paramJSONObject.put("header", this.e);
    paramJSONObject = new JSONObject(paramJSONObject).toString();
    new a.a().b(this.b).b(paramJSONObject).a(a.a(this.d).a(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.le.a.1
 * JD-Core Version:    0.7.0.1
 */