package com.tencent.luggage.wxa.mh;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.ma.h;
import com.tencent.luggage.wxa.mg.b.j;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
  extends a
{
  public static final int CTRL_INDEX = 482;
  public static final String NAME = "loadVideoResource";
  
  private void a(c paramc, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt1 != -5)
    {
      if (paramInt1 != -4)
      {
        if (paramInt1 != -3)
        {
          if (paramInt1 != -2)
          {
            if (paramInt1 != -1) {
              localObject = "";
            } else {
              localObject = "args illegal";
            }
          }
          else {
            localObject = "downloading";
          }
        }
        else {
          localObject = "start download fail";
        }
      }
      else {
        localObject = "create file fail";
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cdn download fail errCode:");
      ((StringBuilder)localObject).append(paramInt2);
      localObject = ((StringBuilder)localObject).toString();
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("errMsg", localObject);
    localHashMap.put("resource", paramString);
    paramString = new JSONObject(localHashMap).toString();
    new b.j().b(paramc).b(paramString).a();
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      paramc.a(paramInt, b("fail:data nil"));
      o.c("MicroMsg.JsApiLoadVideoResource", "data is null");
      return;
    }
    paramJSONObject = paramJSONObject.optJSONArray("resources");
    if ((paramJSONObject != null) && (paramJSONObject.length() != 0))
    {
      int i = 0;
      int k;
      for (int j = 0; i < paramJSONObject.length(); j = k)
      {
        String str = paramJSONObject.optString(i, "");
        o.e("MicroMsg.JsApiLoadVideoResource", "preLoadVideo videoUrl:%s", new Object[] { str });
        if (af.c(str)) {
          o.c("MicroMsg.JsApiLoadVideoResource", "videoUrl i nil");
        }
        for (;;)
        {
          k = j + 1;
          break;
          k = j;
          if (e.a(h.class) == null) {
            break;
          }
          int m = ((h)e.a(h.class)).a(str, new b.1(this, paramc));
          k = j;
          if (m == 0) {
            break;
          }
          o.d("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo genPreLoad fail ret = %s, videoUrl = %s", new Object[] { Integer.valueOf(m), str });
          a(paramc, str, m, 0);
        }
        i += 1;
      }
      if ((j != 0) && (j == paramJSONObject.length())) {
        paramc.a(paramInt, b("fail"));
      }
      return;
    }
    o.c("MicroMsg.JsApiLoadVideoResource", "dataArr nil");
    paramc.a(paramInt, b("fail:dataArr nil"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mh.b
 * JD-Core Version:    0.7.0.1
 */