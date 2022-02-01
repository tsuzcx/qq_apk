package com.tencent.luggage.wxa.jx;

import android.util.SparseArray;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.qz.af;
import org.json.JSONArray;
import org.json.JSONObject;

public final class aw
  extends a<com.tencent.luggage.wxa.iu.b>
{
  public static final int CTRL_INDEX = 215;
  public static final String NAME = "updatePerfData";
  private static final SparseArray<Integer> a = new SparseArray();
  
  static
  {
    a.put("firstRenderTime".hashCode(), Integer.valueOf(301));
    a.put("reRenderTime".hashCode(), Integer.valueOf(302));
    a.put("webview2AppServiceTotalTime".hashCode(), Integer.valueOf(402));
    a.put("webview2AppServiceDataSize".hashCode(), Integer.valueOf(403));
    a.put("webview2AppServiceNativeTime".hashCode(), Integer.valueOf(404));
    a.put("appService2WebviewTotalTime".hashCode(), Integer.valueOf(405));
    a.put("appService2WebviewDataSize".hashCode(), Integer.valueOf(406));
    a.put("appService2WebviewNativeTime".hashCode(), Integer.valueOf(407));
  }
  
  public void a(com.tencent.luggage.wxa.iu.b paramb, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optJSONArray("dataArray");
    if ((com.tencent.luggage.wxa.om.b.b((d)paramb.q())) && (paramJSONObject != null))
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        Object localObject = paramJSONObject.optJSONObject(i);
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).optString("key");
          localObject = ((JSONObject)localObject).optString("value");
          if (!af.c(str))
          {
            Integer localInteger = (Integer)a.get(str.hashCode());
            if (localInteger != null) {
              com.tencent.luggage.wxa.om.b.a((d)paramb.q(), localInteger.intValue(), (String)localObject);
            } else {
              com.tencent.luggage.wxa.om.b.a((d)paramb.q(), str, (String)localObject);
            }
          }
        }
        i += 1;
      }
      paramb.a(paramInt, b("ok"));
      return;
    }
    paramb.a(paramInt, b("fail"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.aw
 * JD-Core Version:    0.7.0.1
 */