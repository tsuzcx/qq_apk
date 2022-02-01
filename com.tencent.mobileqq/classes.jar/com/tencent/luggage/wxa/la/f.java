package com.tencent.luggage.wxa.la;

import android.text.TextUtils;
import com.tencent.luggage.wxa.nl.g;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import org.json.JSONObject;

public final class f
  extends a
{
  private static final int CTRL_INDEX = 351;
  private static final String NAME = "navigateToDevMiniProgram";
  
  public void a(com.tencent.luggage.wxa.iu.b paramb, JSONObject paramJSONObject, int paramInt)
  {
    String str1 = paramJSONObject.optString("appId");
    String str3 = paramJSONObject.optString("downloadURL");
    String str4 = paramJSONObject.optString("checkSumMd5");
    b localb = b.a(paramJSONObject.optString("envVersion"), b.b);
    String str2 = paramJSONObject.optString("relativeURL");
    String str5 = paramJSONObject.optString("extoptions");
    if (af.c(str1))
    {
      paramb.a(paramInt, b("fail:appID is empty"));
      return;
    }
    if ((b.b == localb) && (!TextUtils.isEmpty(str4))) {
      try
      {
        g.a().a(str1, 1, str5);
        if (ac.a().a(str1, 1, str3, str4)) {
          i.a(str1, 1);
        }
      }
      catch (Exception localException)
      {
        o.b("Luggage.JsApiNavigateToDevMiniProgram", "invoke with appId:%s, callbackId:%d, precondition(appId:%s) for dev failed by exception:%s", new Object[] { paramb.getAppId(), Integer.valueOf(paramInt), str1, localException });
      }
    }
    c.a locala = new c.a();
    locala.a = paramJSONObject.optInt("scene", 0);
    locala.b = paramJSONObject.optString("sceneNote");
    locala.c = paramJSONObject.optInt("preScene", 0);
    locala.d = paramJSONObject.optString("preSceneNote");
    m_().a(paramb, str1, localb.d, str2, locala, paramJSONObject, new f.1(this, paramb, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.la.f
 * JD-Core Version:    0.7.0.1
 */