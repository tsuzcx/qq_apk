package com.tencent.luggage.wxa.nz;

import com.tencent.luggage.wxa.oa.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

class b$1
  implements a
{
  b$1(b paramb, String paramString, b.a parama) {}
  
  public void a(String paramString)
  {
    this.c.c.remove(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    o.d("MicroMsg.AppBrandNetworkDownload", "download start! filename %s, url %s", new Object[] { paramString1, paramString2 });
  }
  
  public void a(String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2)
  {
    this.b.a(paramInt, paramLong1, paramLong2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    o.b("MicroMsg.AppBrandNetworkDownload", "download error! errorMessage:%s, filename %s, url %s", new Object[] { paramString3, paramString1, paramString2 });
    b.a(this.c, this.a);
    this.b.a(b.b, paramString3);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, Map paramMap)
  {
    b.a(this.c, this.a);
    this.b.a(b.a, paramString2, paramString1, paramInt, paramLong, paramMap);
    o.d("MicroMsg.AppBrandNetworkDownload", "download success! filename %s, url %s", new Object[] { paramString1, paramString3 });
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.b.a(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.b.1
 * JD-Core Version:    0.7.0.1
 */