package com.tencent.luggage.wxa.lw;

import android.text.TextUtils;
import com.tencent.luggage.wxa.dp.a;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.jx.u;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class i
  extends u<h>
{
  public static final int CTRL_INDEX = 113;
  public static final String NAME = "getStorageInfoSync";
  
  public String a(h paramh, JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("storageId", 0);
    if (r.a(i)) {
      return b("fail:nonexistent storage space");
    }
    if ((paramh.d()) && (!TextUtils.isEmpty(paramh.getAppId())))
    {
      HashMap localHashMap = new HashMap();
      long l = System.currentTimeMillis();
      Object localObject;
      int j;
      int k;
      if (paramh.q().A().T != 1)
      {
        localObject = ((a)com.tencent.luggage.wxa.ba.e.a(a.class)).a(paramh.getAppId()).b(i, paramh.getAppId());
        paramJSONObject = (ArrayList)localObject[0];
        i = (int)Math.ceil(((Integer)localObject[1]).doubleValue() / 1000.0D);
        j = (int)Math.ceil(((Integer)localObject[2]).doubleValue() / 1000.0D);
        k = 2;
      }
      else
      {
        localObject = new j();
        ((j)localObject).a = paramh.getAppId();
        ((j)localObject).b = i;
        ((j)localObject).f();
        paramJSONObject = ((j)localObject).c;
        i = ((j)localObject).d;
        j = ((j)localObject).e;
        k = 1;
      }
      int m;
      if (paramJSONObject == null) {
        m = 0;
      } else {
        m = paramJSONObject.size();
      }
      q.a(k, 3, i * 1000, m, System.currentTimeMillis() - l, paramh);
      localHashMap.put("keys", paramJSONObject);
      localHashMap.put("currentSize", Integer.valueOf(i));
      localHashMap.put("limitSize", Integer.valueOf(j));
      return a("ok", localHashMap);
    }
    o.b("Luggage.FULL.JsApiGetStorageInfoSync", "invoke with storageId(%s) but service destroyed", new Object[] { Integer.valueOf(i) });
    return "fail:internal error";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.i
 * JD-Core Version:    0.7.0.1
 */