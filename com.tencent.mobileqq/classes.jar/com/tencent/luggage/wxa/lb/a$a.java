package com.tencent.luggage.wxa.lb;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.n;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a$a
  extends n
{
  public static final int CTRL_INDEX = 468;
  public static final String NAME = "onLoadSubPackageTaskStateChange";
  
  private static void b(c paramc, String paramString1, String paramString2, String paramString3)
  {
    b(paramc, paramString1, paramString2, paramString3, -1, -1L, -1L);
  }
  
  private static void b(c paramc, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong1, long paramLong2)
  {
    o.d("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: formatEventCallback taskId: %s, state: %s, progress: %d, currentWritten: %d, totalWritten: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("taskId", paramString1);
    localHashMap.put("state", paramString2);
    localHashMap.put("moduleName", paramString3);
    if (paramInt >= 0) {
      localHashMap.put("progress", Integer.valueOf(paramInt));
    }
    if (paramLong1 >= 0L) {
      localHashMap.put("totalBytesWritten", Long.valueOf(paramLong1));
    }
    if (paramLong2 >= 0L) {
      localHashMap.put("totalBytesExpectedToWrite", Long.valueOf(paramLong2));
    }
    paramString1 = new JSONObject(localHashMap).toString();
    new a().a(paramc).a(paramString1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lb.a.a
 * JD-Core Version:    0.7.0.1
 */