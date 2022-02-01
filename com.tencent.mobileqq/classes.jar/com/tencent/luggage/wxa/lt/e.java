package com.tencent.luggage.wxa.lt;

import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qz.o;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class e
  extends a<h>
{
  public static final int CTRL_INDEX = 63;
  public static final String NAME = "reportKeyValue";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    String str1 = ",";
    Object localObject1 = paramJSONObject.optJSONArray("dataArray");
    if (localObject1 == null)
    {
      paramh.a(paramInt, b("fail:invalid data"));
      return;
    }
    int i = paramJSONObject.optInt("version", -1);
    l locall = (l)paramh.b(l.class);
    if (locall == null)
    {
      o.b("MicroMsg.JsApiReportKeyValue", "config is Null!");
      paramh.a(paramInt, b("fail:interrupted"));
      return;
    }
    int j = 0;
    paramJSONObject = (JSONObject)localObject1;
    if (j < paramJSONObject.length()) {}
    for (;;)
    {
      try
      {
        localObject1 = paramJSONObject.getJSONObject(j);
        int n = ((JSONObject)localObject1).optInt("key");
        localObject1 = ((JSONObject)localObject1).optString("value");
        if (n > 0)
        {
          boolean bool = com.tencent.luggage.wxa.qz.af.c((String)localObject1);
          if (!bool)
          {
            if (n != 15496) {
              break label830;
            }
            localObject3 = paramJSONObject;
            Object localObject2 = localObject1;
            try
            {
              localObject6 = ((String)localObject1).split(Pattern.quote(str1));
              localObject3 = paramJSONObject;
              localObject2 = localObject1;
              Object localObject4 = new int[4];
              localObject4[0] = 17;
              localObject4[1] = 11;
              localObject4[2] = 9;
              localObject4[3] = 2;
              localObject3 = paramJSONObject;
              localObject2 = localObject1;
              i1 = localObject4.length;
              k = 0;
              m = 0;
              int i2;
              if (k < i1)
              {
                i2 = localObject4[k];
                str2 = localObject6[i2];
                localObject3 = paramJSONObject;
                localObject2 = localObject1;
                str3 = com.tencent.luggage.wxa.qz.af.b(str2);
                localObject2 = paramJSONObject;
              }
              int i3;
              localObject2 = localObject1;
            }
            catch (Exception paramJSONObject)
            {
              try
              {
                i3 = str3.length();
                if (i3 <= 1024) {
                  break label806;
                }
                try
                {
                  localObject6[i2] = str2.substring(0, 1024);
                  m = 1;
                }
                catch (Exception localException3)
                {
                  localObject3 = localObject1;
                  localObject2 = paramJSONObject;
                  continue;
                }
                localObject4 = paramJSONObject;
                localObject3 = localObject1;
                localObject2 = localObject4;
                if (m == 0) {
                  break label837;
                }
                localObject3 = StringUtils.join((Object[])localObject6, str1);
                paramJSONObject = (JSONObject)localObject4;
              }
              catch (Exception paramJSONObject)
              {
                Object localObject6;
                int i1;
                int k;
                int m;
                String str2;
                String str3;
                Object localObject5;
                localObject3 = localObject1;
                localObject1 = localJSONObject;
                continue;
              }
              paramJSONObject = paramJSONObject;
              localObject1 = localObject3;
              localObject3 = localObject2;
            }
            localObject5 = paramJSONObject;
            localObject1 = localObject2;
            try
            {
              o.b("MicroMsg.JsApiReportKeyValue", "modify 15496 too large string-fields, e=%s", new Object[] { localObject5 });
            }
            catch (Exception paramJSONObject)
            {
              continue;
            }
            localObject1 = paramJSONObject;
            localObject2 = (com.tencent.luggage.wxa.ot.d)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.d.class);
            if (localObject2 == null)
            {
              localObject1 = paramJSONObject;
              paramh.a(paramInt, b("fail:not supported"));
              return;
            }
            if (i >= 2)
            {
              localObject1 = paramJSONObject;
              localObject5 = (com.tencent.luggage.wxa.ed.d)paramh.q();
              localObject1 = paramJSONObject;
              localObject6 = ((com.tencent.luggage.wxa.ed.d)localObject5).j();
              localObject1 = paramJSONObject;
              str2 = ((c)localObject6).i();
              localObject1 = paramJSONObject;
              str3 = ((com.tencent.luggage.wxa.ed.d)localObject5).aa();
              localObject1 = paramJSONObject;
              k = ((com.tencent.luggage.wxa.ed.d)localObject5).b();
              localObject1 = paramJSONObject;
              m = ((com.tencent.luggage.wxa.ed.d)localObject5).ab() + 1;
              localObject1 = paramJSONObject;
              i1 = ((c)localObject6).c + 1000;
            }
            try
            {
              o.d("MicroMsg.JsApiReportKeyValue", "report kv_%d{instanceId=%s, appId=%s, appversion=%d, appstate=%d, apptype=%d, value=%s}", new Object[] { Integer.valueOf(n), str2, str3, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i1), localObject3 });
              ((com.tencent.luggage.wxa.ot.d)localObject2).a(n, new Object[] { str2, str3, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i1), localObject3 });
            }
            catch (Exception localException1)
            {
              localObject1 = paramJSONObject;
              continue;
            }
            o.d("MicroMsg.JsApiReportKeyValue", "report kv_%d{appId='%s',pkgVersion=%d,pkgDebugType=%d,value='%s'}", new Object[] { Integer.valueOf(n), paramh.getAppId(), Integer.valueOf(locall.S.pkgVersion), Integer.valueOf(locall.S.b + 1), localObject3 });
            ((com.tencent.luggage.wxa.ot.d)localObject2).a(n, new Object[] { paramh.getAppId(), Integer.valueOf(locall.S.pkgVersion), Integer.valueOf(locall.S.b + 1), localObject3 });
          }
        }
        localObject1 = paramJSONObject;
      }
      catch (Exception localException2)
      {
        localObject1 = paramJSONObject;
        paramJSONObject = localException2;
        localJSONObject = paramJSONObject;
        o.b("MicroMsg.JsApiReportKeyValue", "AppBrandComponent parse report value failed : %s", new Object[] { localJSONObject.getMessage() });
      }
      j += 1;
      paramJSONObject = (JSONObject)localObject1;
      break;
      paramh.a(paramInt, b("ok"));
      return;
      label806:
      k += 1;
      paramJSONObject = localJSONObject;
      continue;
      label830:
      JSONObject localJSONObject = paramJSONObject;
      Object localObject3 = localObject1;
      label837:
      paramJSONObject = localJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lt.e
 * JD-Core Version:    0.7.0.1
 */