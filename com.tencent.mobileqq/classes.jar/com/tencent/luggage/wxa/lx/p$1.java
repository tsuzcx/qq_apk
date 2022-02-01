package com.tencent.luggage.wxa.lx;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

class p$1
  implements Runnable
{
  p$1(p paramp, JSONObject paramJSONObject, com.tencent.luggage.wxa.jx.c paramc, int paramInt) {}
  
  public void run()
  {
    p.a(this.d, (float)this.a.optDouble("value"));
    if ((!Float.isNaN(p.a(this.d))) && (p.a(this.d) >= 0.0F) && (p.a(this.d) <= 1.0F))
    {
      Object localObject = this.b.getContext();
      if (localObject == null)
      {
        this.b.a(this.c, this.d.b("fail"));
        o.b("MicroMsg.JsApiSetScreenBrightness", "context is null, invoke fail!");
        return;
      }
      if (!(this.b.getContext() instanceof Activity))
      {
        o.b("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
        this.b.a(this.c, this.d.b("fail:context is not activity"));
        return;
      }
      localObject = (Activity)localObject;
      WindowManager.LayoutParams localLayoutParams = ((Activity)localObject).getWindow().getAttributes();
      if (Float.isNaN(p.b(this.d)))
      {
        p.b(this.d, localLayoutParams.screenBrightness);
        com.tencent.luggage.wxa.iu.c.a(this.b.getAppId(), new p.1.1(this, localLayoutParams, (Activity)localObject));
      }
      float f2 = p.a(this.d);
      float f1 = 0.01F;
      if (f2 >= 0.01F) {
        f1 = p.a(this.d);
      }
      localLayoutParams.screenBrightness = f1;
      ((Activity)localObject).getWindow().setAttributes(localLayoutParams);
      this.b.a(this.c, this.d.b("ok"));
      return;
    }
    this.b.a(this.c, this.d.b("fail:value invalid"));
    o.b("MicroMsg.JsApiSetScreenBrightness", "value invalid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.p.1
 * JD-Core Version:    0.7.0.1
 */