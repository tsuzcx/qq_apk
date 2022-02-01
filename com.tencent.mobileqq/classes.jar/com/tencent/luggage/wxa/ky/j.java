package com.tencent.luggage.wxa.ky;

import android.view.View;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.kd.d;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;

public class j
  extends d
{
  private static final int CTRL_INDEX = 361;
  public static final String NAME = "updateLivePusher";
  
  private void a(c paramc, b paramb, JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("backgroundImage"))
      {
        String str = paramJSONObject.getString("backgroundImage");
        paramJSONObject = paramJSONObject.optString("backgroundMD5");
        if (af.c(str))
        {
          o.d("MicroMsg.JsApiUpdateLivePusher", "convertBackgroundImageToLocalPath, url is null");
          return;
        }
        com.tencent.luggage.wxa.pd.b.a(paramc, str, paramJSONObject, new j.1(this, paramb, str));
        return;
      }
    }
    catch (JSONException paramc)
    {
      o.d("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "backgroundImage", paramc.getLocalizedMessage() });
    }
  }
  
  private void a(JSONObject paramJSONObject, b paramb)
  {
    if (paramJSONObject.has("filterImage"))
    {
      paramb.b = paramJSONObject.optString("filterImage", paramb.b);
      paramb.c = paramJSONObject.optString("filterImageMd5", null);
      if (af.c(paramb.b)) {
        try
        {
          paramJSONObject.put("filterImage", "");
          return;
        }
        catch (JSONException paramJSONObject)
        {
          o.c("MicroMsg.JsApiUpdateLivePusher", "parseFilterImage, ignore exception:%s", new Object[] { paramJSONObject });
          return;
        }
      }
      if ((paramb.b.startsWith("http://")) || (paramb.b.startsWith("https://"))) {
        paramJSONObject.remove("filterImage");
      }
    }
  }
  
  private void b(c paramc, b paramb, JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("filterImage"))
      {
        paramJSONObject = paramJSONObject.getString("filterImage");
        if (af.c(paramJSONObject))
        {
          o.d("MicroMsg.JsApiUpdateLivePusher", "convertFilterImageToLocalPath, url is null");
          return;
        }
        com.tencent.luggage.wxa.pd.b.a(paramc, paramJSONObject, null, new j.2(this, paramb, paramJSONObject));
        return;
      }
    }
    catch (JSONException paramc)
    {
      o.d("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "filterImage", paramc.getLocalizedMessage() });
    }
  }
  
  private void c(c paramc, b paramb, JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("watermarkImage"))
      {
        String str = paramJSONObject.getString("watermarkImage");
        paramJSONObject = paramJSONObject.optString("watermarkMD5");
        if (af.c(str))
        {
          o.d("MicroMsg.JsApiUpdateLivePusher", "convertWatermarkImageToLocalPath, url is null");
          return;
        }
        com.tencent.luggage.wxa.pd.b.a(paramc, str, paramJSONObject, new j.3(this, paramb));
        return;
      }
    }
    catch (JSONException paramc)
    {
      o.d("MicroMsg.JsApiUpdateLivePusher", "onUpdateView param=%s exp=%s", new Object[] { "watermarkImage", paramc.getLocalizedMessage() });
    }
  }
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("livePusherId");
  }
  
  protected boolean a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    o.d("MicroMsg.JsApiUpdateLivePusher", "onUpdateView : livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof com.tencent.luggage.wxa.kt.b))
    {
      o.c("MicroMsg.JsApiUpdateLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    paramView = (View)((com.tencent.luggage.wxa.kt.b)paramView).a(View.class);
    if (!(paramView instanceof b))
    {
      o.b("MicroMsg.JsApiUpdateLivePusher", "targetView not AppBrandLivePusherView");
      return false;
    }
    paramView = (b)paramView;
    a(paramJSONObject, paramView);
    paramView.b(m.b(paramJSONObject));
    a(parame, paramView, paramJSONObject);
    b(parame, paramView, paramJSONObject);
    c(parame, paramView, paramJSONObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.j
 * JD-Core Version:    0.7.0.1
 */