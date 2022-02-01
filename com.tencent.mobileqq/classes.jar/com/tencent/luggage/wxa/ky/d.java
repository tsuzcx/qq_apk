package com.tencent.luggage.wxa.ky;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.luggage.util.j;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.on.n;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.rtmp.TXLiveBase;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends com.tencent.luggage.wxa.kd.b
{
  private static final int CTRL_INDEX = 360;
  public static final String NAME = "insertLivePusher";
  private int a;
  
  private void a(Activity paramActivity, com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    int i = this.a;
    this.a = (i + 1);
    if (i > 5)
    {
      o.d("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, avoid dead loop");
      return;
    }
    n.b(paramc.getAppId(), new d.5(this, paramActivity, paramc, paramJSONObject, paramInt));
    if (!j.a(paramActivity, "android.permission.CAMERA", 117, "", ""))
    {
      o.d("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retCameraPermission");
      return;
    }
    if (!j.a(paramActivity, "android.permission.RECORD_AUDIO", 118, "", ""))
    {
      o.d("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retMicrophonePermission");
      return;
    }
    o.d("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, super.invoke");
    super.a(paramc, paramJSONObject, paramInt);
  }
  
  private void a(com.tencent.luggage.wxa.jx.c paramc, b paramb, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("backgroundImage");
    paramJSONObject = paramJSONObject.optString("backgroundMD5");
    if (af.c(str))
    {
      o.d("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, url is null");
      return;
    }
    com.tencent.luggage.wxa.pd.b.a(paramc, str, paramJSONObject, new d.2(this, paramb, str));
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
          o.c("MicroMsg.JsApiInsertLivePusher", "parseFilterImage, ignore exception:%s", new Object[] { paramJSONObject });
          return;
        }
      }
      if ((paramb.b.startsWith("http://")) || (paramb.b.startsWith("https://"))) {
        paramJSONObject.remove("filterImage");
      }
    }
  }
  
  private void b(com.tencent.luggage.wxa.jx.c paramc, b paramb, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("filterImage");
    if (af.c(paramJSONObject))
    {
      o.d("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, url is null");
      return;
    }
    com.tencent.luggage.wxa.pd.b.a(paramc, paramJSONObject, null, new d.3(this, paramb, paramJSONObject));
  }
  
  private void b(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (!(paramc.getContext() instanceof Activity))
    {
      o.c("MicroMsg.JsApiInsertLivePusher", "invokeAfterRequestPermission pageContext not activity");
      paramc.a(paramInt, b("fail"));
      n.a(paramc.getAppId());
      return;
    }
    this.a = 0;
    a((Activity)paramc.getContext(), paramc, paramJSONObject, paramInt);
  }
  
  private void c(com.tencent.luggage.wxa.jx.c paramc, b paramb, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("watermarkImage");
    paramJSONObject = paramJSONObject.optString("watermarkMD5");
    if (af.c(str))
    {
      o.d("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, url is null");
      return;
    }
    com.tencent.luggage.wxa.pd.b.a(paramc, str, paramJSONObject, new d.4(this, paramb));
  }
  
  protected int a(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("livePusherId");
  }
  
  protected View a(e parame, JSONObject paramJSONObject)
  {
    paramJSONObject = new b(parame.getContext());
    return new com.tencent.luggage.wxa.kt.b(parame.getContext(), paramJSONObject);
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    l.a();
    b(paramc, paramJSONObject, paramInt);
  }
  
  protected void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    o.d("MicroMsg.JsApiInsertLivePusher", "onInsertView livePusherId=%d", new Object[] { Integer.valueOf(paramInt) });
    if (!(paramView instanceof com.tencent.luggage.wxa.kt.b))
    {
      o.c("MicroMsg.JsApiInsertLivePusher", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    TXLiveBase.setAppVersion(String.format("weixin_%s", new Object[] { parame.getAppId() }));
    b localb = (b)((com.tencent.luggage.wxa.kt.b)paramView).a(b.class);
    if (localb == null)
    {
      o.b("MicroMsg.JsApiInsertLivePusher", "pusherView null");
      return;
    }
    d.1 local1 = new d.1(this, localb);
    d.6 local6 = new d.6(this, localb);
    d.7 local7 = new d.7(this, localb, parame);
    d.8 local8 = new d.8(this, localb, parame, local7);
    parame.a(local1);
    parame.a(local6);
    parame.a(local8);
    localb.a(new d.9(this, parame, local1, local6));
    com.tencent.luggage.wxa.iu.c.a(parame.getAppId(), local7);
    localb.a(new d.10(this, paramInt, parame));
    localb.a(new d.11(this, paramInt, parame));
    localb.a(new d.12(this, paramInt, parame));
    localb.a(new d.13(this, paramInt, parame));
    a(paramJSONObject, localb);
    localb.a(m.b(paramJSONObject));
    a(parame, localb, paramJSONObject);
    b(parame, localb, paramJSONObject);
    c(parame, localb, paramJSONObject);
    localb.setContentDescription(paramView.getContext().getString(2131886750));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.d
 * JD-Core Version:    0.7.0.1
 */