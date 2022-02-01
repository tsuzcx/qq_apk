package com.tencent.luggage.wxa.kp;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class l$1
  implements Runnable
{
  l$1(l paraml, JSONObject paramJSONObject, c paramc, int paramInt) {}
  
  public void run()
  {
    int i = this.a.optInt("cameraId");
    String str = this.a.optString("type");
    o.d("MicroMsg.JsApiOperateCamera", "cameraId=%d type=%s", new Object[] { Integer.valueOf(i), str });
    Object localObject = a.a().a(i);
    if (localObject == null)
    {
      this.b.a(this.c, this.d.b("fail:no such camera"));
      return;
    }
    ((e)localObject).setOperateCallBack(new l.1.1(this));
    i = -1;
    switch (str.hashCode())
    {
    default: 
      break;
    case 1985172309: 
      if (str.equals("setZoom")) {
        i = 1;
      }
      break;
    case 1484838379: 
      if (str.equals("takePhoto")) {
        i = 0;
      }
      break;
    case -374265034: 
      if (str.equals("listenFrameChange")) {
        i = 4;
      }
      break;
    case -1391995149: 
      if (str.equals("stopRecord")) {
        i = 3;
      }
      break;
    case -1909077165: 
      if (str.equals("startRecord")) {
        i = 2;
      }
      break;
    case -2144140699: 
      if (str.equals("closeFrameChange")) {
        i = 5;
      }
      break;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5)
              {
                o.c("MicroMsg.JsApiOperateCamera", "operateType not supported: %s", new Object[] { str });
                this.b.a(this.c, this.d.b("fail:operateType not supported"));
                return;
              }
              ((e)localObject).k();
              this.b.a(this.c, this.d.b("ok"));
              return;
            }
            str = this.a.optString("size");
            ((e)localObject).a(this.b, str);
            return;
          }
          ((e)localObject).setCompressRecord(this.a.optBoolean("compressed"));
          ((e)localObject).n();
          return;
        }
        ((e)localObject).m();
        return;
      }
      float f = ((e)localObject).a((float)this.a.optDouble("zoom"));
      if (f < 1.0F)
      {
        this.b.a(this.c, this.d.b("fail: zoom multiple not support"));
        return;
      }
      localObject = new HashMap(1);
      ((Map)localObject).put("zoom", Float.valueOf(f));
      this.b.a(this.c, this.d.a("ok", (Map)localObject));
      return;
    }
    ((e)localObject).setQuality(this.a.optString("quality", "high"));
    ((e)localObject).h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kp.l.1
 * JD-Core Version:    0.7.0.1
 */