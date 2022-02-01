package com.tencent.luggage.wxa.lg;

import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.nz.g.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class a$1
  implements g.a
{
  private JSONObject e;
  
  a$1(a parama, String paramString1, String paramString2, c paramc) {}
  
  public void a(int paramInt, String paramString)
  {
    o.d("MicroMsg.BaseCreateUploadTask", "onUploadResult uploadTaskId:%s, filePath:%s, result:%s, errMsg:%d", new Object[] { this.a, this.b, paramString, Integer.valueOf(paramInt) });
    if (a.a(this.d, this.c, this.a)) {
      return;
    }
    a.a(this.d, this.c, this.a, paramString);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    o.d("MicroMsg.BaseCreateUploadTask", "onUploadResultWithCode uploadTaskId:%s, filePath:%s, result:%s, errMsg:%d, statusCode %d", new Object[] { this.a, this.b, paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("data", paramString);
      localHashMap.put("statusCode", Integer.valueOf(paramInt2));
      localHashMap.put("uploadTaskId", this.a);
      localHashMap.put("state", "success");
      paramString = this.e;
      if (paramString != null) {
        localHashMap.put("header", paramString);
      }
      paramString = new JSONObject(localHashMap).toString();
      new a.a().b(this.c).b(paramString).a(a.a(this.d).a(this.a));
      a.a(this.d).b(this.a);
      return;
    }
    if (a.a(this.d, this.c, this.a)) {
      return;
    }
    a.a(this.d, this.c, this.a, paramString);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2)
  {
    paramString1 = new HashMap();
    paramString1.put("uploadTaskId", this.a);
    paramString1.put("state", "progressUpdate");
    paramString1.put("progress", Integer.valueOf(paramInt));
    paramString1.put("totalBytesSent", Long.valueOf(paramLong1));
    paramString1.put("totalBytesExpectedToSend", Long.valueOf(paramLong2));
    paramString1 = new JSONObject(paramString1).toString();
    new a.a().b(this.c).b(paramString1).a(a.a(this.d).a(this.a));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    if (paramJSONObject.optBoolean("__AppBrandRemoteDebugRequestHeader__"))
    {
      if (!((com.tencent.luggage.wxa.nz.a)this.c.b(com.tencent.luggage.wxa.nz.a.class)).y) {
        return;
      }
      paramJSONObject.remove("__AppBrandRemoteDebugRequestHeader__");
      com.tencent.luggage.wxa.gz.a locala = new com.tencent.luggage.wxa.gz.a();
      locala.a.a = "upload";
      locala.a.c = paramJSONObject;
      locala.a.b = this.a;
      com.tencent.luggage.wxa.qy.a.a.a(locala);
      return;
    }
    this.e = paramJSONObject;
    paramJSONObject = new HashMap();
    paramJSONObject.put("uploadTaskId", this.a);
    paramJSONObject.put("state", "headersReceived");
    paramJSONObject.put("header", this.e);
    paramJSONObject = new JSONObject(paramJSONObject).toString();
    new a.a().b(this.c).b(paramJSONObject).a(a.a(this.d).a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lg.a.1
 * JD-Core Version:    0.7.0.1
 */