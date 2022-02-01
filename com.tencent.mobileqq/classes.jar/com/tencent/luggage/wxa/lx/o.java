package com.tencent.luggage.wxa.lx;

import android.app.Activity;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.jx.a;
import org.json.JSONObject;

public class o
  extends a
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "setKeepScreenOn";
  private static boolean c = false;
  PowerManager.WakeLock a;
  private com.tencent.luggage.wxa.jx.c b;
  private c.c d;
  
  private boolean f()
  {
    try
    {
      if (this.b.getContext() == null)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiSetKeepScreenOn", "acquire fail, server context is nul");
        return false;
      }
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiSetKeepScreenOn", "acquire ok");
      Activity localActivity = (Activity)this.b.getContext();
      if (this.a == null) {
        this.a = ((PowerManager)localActivity.getSystemService("power")).newWakeLock(536870922, "MicroMsg.JsApiSetKeepScreenOn");
      }
      if (!this.a.isHeld())
      {
        this.a.acquire();
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiSetKeepScreenOn", "wakeLock acquire");
      }
      else
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiSetKeepScreenOn", "wakeLock has held ");
      }
      return true;
    }
    finally {}
  }
  
  private boolean g()
  {
    try
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiSetKeepScreenOn", "release");
      if ((this.a != null) && (this.a.isHeld()))
      {
        this.a.release();
        this.a = null;
        return true;
      }
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiSetKeepScreenOn", "wakeLock is  null");
      return false;
    }
    finally {}
  }
  
  private boolean h()
  {
    try
    {
      if (this.a != null)
      {
        bool = this.a.isHeld();
        if (bool)
        {
          bool = true;
          break label28;
        }
      }
      boolean bool = false;
      label28:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn data is null");
      paramc.a(paramInt, b("fail:data is null"));
      return;
    }
    if (paramc.getContext() == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is nul");
      paramc.a(paramInt, b("fail:context is null"));
      return;
    }
    if (!(paramc.getContext() instanceof Activity))
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is not activity, don't do invoke");
      paramc.a(paramInt, b("fail:context is null"));
      return;
    }
    boolean bool = paramJSONObject.optBoolean("keepScreenOn", false);
    c = bool;
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, keepScreenOn:%b, appId:%s", new Object[] { Boolean.valueOf(bool), paramc.getAppId() });
    try
    {
      this.b = paramc;
      if (bool)
      {
        if (this.d == null) {
          this.d = new o.1(this, paramc);
        }
        com.tencent.luggage.wxa.iu.c.a(paramc.getAppId(), this.d);
        bool = f();
      }
      else
      {
        if (!h()) {
          break label253;
        }
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiSetKeepScreenOn", "reset screen off");
        bool = g();
      }
      if (bool)
      {
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn ok");
        paramc.a(paramInt, b("ok"));
        return;
      }
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn fail");
      paramc.a(paramInt, b("fail"));
      return;
      label253:
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiSetKeepScreenOn", "fail, has not set screen");
      paramc.a(paramInt, b("fail:has not set screen"));
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.o
 * JD-Core Version:    0.7.0.1
 */