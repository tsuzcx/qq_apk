package com.tencent.luggage.wxa.mw;

import android.util.Size;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.kp.f;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.pd.w;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONArray;
import org.json.JSONObject;

public class d
  extends a
{
  private static final int CTRL_INDEX = 807;
  public static final String NAME = "updateXWebCamera";
  
  public boolean a(c paramc, f paramf, JSONObject paramJSONObject)
  {
    o.d("MicroMsg.JsApiUpdateXWebCamera", "update xweb camera view");
    if (paramf == null)
    {
      o.c("MicroMsg.JsApiUpdateXWebCamera", "the camera view is null");
      return false;
    }
    int i = paramJSONObject.optInt("cameraId");
    String str1 = paramJSONObject.optString("devicePosition", "back");
    String str2 = paramJSONObject.optString("flash", "auto");
    boolean bool = paramJSONObject.optBoolean("needOutput", false);
    paramf.setAppId(paramc.getAppId());
    paramf.a(str1, false);
    paramf.setFlash(str2);
    paramf.setNeedOutput(bool);
    JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
    int j = g.a(localJSONObject, "width", 0);
    int k = g.a(localJSONObject, "height", 0);
    o.e("MicroMsg.JsApiUpdateXWebCamera", "onUpdateView cameraId: %d, devicePosition: %s,flash: %s,width： %d,height： %d", new Object[] { Integer.valueOf(i), str1, str2, Integer.valueOf(j), Integer.valueOf(k) });
    if ((j != 0) && (k != 0)) {
      bool = paramf.a(j, k, false);
    } else {
      bool = false;
    }
    if ((paramc instanceof u))
    {
      paramc = w.a((u)paramc);
      paramf.setDisplayScreenSize(new Size(paramc[0], paramc[1]));
    }
    paramc = paramJSONObject.optString("mode");
    if (!af.c(paramc)) {
      paramf.setMode(paramc);
    }
    paramc = paramJSONObject.optJSONArray("scanArea");
    if ((paramc != null) && (paramc.length() == 4))
    {
      o.d("MicroMsg.JsApiUpdateXWebCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { paramc, Integer.valueOf(paramc.length()) });
      paramf.a(g.c(paramc.optInt(0)), g.c(paramc.optInt(1)), g.c(paramc.optInt(2)), g.c(paramc.optInt(3)));
    }
    paramf.setScanFreq(paramJSONObject.optInt("scanFreq"));
    if (bool)
    {
      paramf.g();
      paramf.a();
      return true;
    }
    paramf.j();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mw.d
 * JD-Core Version:    0.7.0.1
 */