package com.tencent.luggage.wxa.lh;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

public class h
  extends d
{
  public static final int CTRL_INDEX = 352;
  public static final String NAME = "startHCE";
  private Class<?> a = null;
  private Activity b = null;
  private Application.ActivityLifecycleCallbacks c = null;
  private ResultReceiver d;
  private com.tencent.luggage.wxa.jx.c e = null;
  private int f = -1;
  private JSONObject g;
  private int h;
  private long i = -1L;
  private Timer j;
  private final Object k = new Object();
  private boolean l = false;
  private ResultReceiver m = new h.6(this, s.a(Looper.getMainLooper()));
  
  public h(Class<?> paramClass)
  {
    if (paramClass == null)
    {
      this.a = HCEService.class;
      return;
    }
    this.a = paramClass;
  }
  
  private void a(int paramInt, String paramString)
  {
    o.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCEUI onResult errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt));
    if (paramInt == 0)
    {
      f();
      return;
    }
    com.tencent.luggage.wxa.li.c.a(this.e.getAppId(), paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail: ");
    localStringBuilder.append(paramString);
    a(a(localStringBuilder.toString(), localHashMap));
  }
  
  private void a(String paramString)
  {
    o.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback result: %s", new Object[] { paramString });
    com.tencent.luggage.wxa.jx.c localc = this.e;
    if (localc != null) {
      localc.a(this.f, paramString);
    }
    if ((this.b != null) && (this.c != null))
    {
      o.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback unregister lifecycle callback");
      this.b.getApplication().unregisterActivityLifecycleCallbacks(this.c);
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    synchronized (this.k)
    {
      boolean bool = this.l;
      if (!bool) {
        this.l = true;
      }
      if (bool)
      {
        o.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEFinish has finished, return");
        return;
      }
      if (b.a())
      {
        o.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
        return;
      }
      ??? = new HashMap();
      int n = (int)(System.currentTimeMillis() - this.i);
      if (this.j != null)
      {
        o.e("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE timer cancel");
        this.j.cancel();
      }
      if ((paramString1 != null) && (!paramString1.equals(this.e.getAppId())))
      {
        o.b("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCESevice callback appId invalid, appId: %s", new Object[] { paramString1 });
        ((Map)???).put("errCode", Integer.valueOf(13010));
        com.tencent.luggage.wxa.li.c.a(this.e.getAppId(), 13010, n);
        a(a("fail: unknown error", (Map)???));
        return;
      }
      o.d("MicroMsg.JsApiNFCStartHCE", "alvinluo HCE start HCEService callback onRefreshed errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString2 });
      if (paramInt == 0)
      {
        b.a(this.e.getAppId());
        ((Map)???).put("errCode", Integer.valueOf(0));
        a(a("ok", (Map)???));
      }
      else
      {
        ((Map)???).put("errCode", Integer.valueOf(paramInt));
        paramString1 = new StringBuilder();
        paramString1.append("fail: ");
        paramString1.append(paramString2);
        a(a(paramString1.toString(), (Map)???));
      }
      com.tencent.luggage.wxa.li.c.a(this.e.getAppId(), paramInt, n);
      h();
      return;
    }
  }
  
  private void c()
  {
    if (!(this.e.getContext() instanceof Activity))
    {
      a(b("fail: unknown error"));
      return;
    }
    this.b = ((Activity)this.e.getContext());
    this.c = new h.2(this);
    this.b.getApplication().registerActivityLifecycleCallbacks(this.c);
    this.d = new h.3(this, s.a(Looper.getMainLooper()));
    a.a.a(this.b, this.d);
    a.a.b();
    ComponentName localComponentName = new ComponentName(this.b, HCEService.class.getCanonicalName());
    a.a.a(localComponentName);
    a.a.a();
  }
  
  private void f()
  {
    Object localObject = new HashMap();
    ArrayList localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = this.g.getJSONArray("aid_list");
      int i1 = localJSONArray.length();
      o.d("MicroMsg.JsApiNFCStartHCE", "alvinluo mData: %s, aidList: %s, length: %d", new Object[] { this.g.toString(), localJSONArray.toString(), Integer.valueOf(i1) });
      int n = 0;
      while (n < i1)
      {
        localArrayList.add(localJSONArray.get(n).toString());
        n += 1;
      }
      com.tencent.luggage.wxa.iu.c.a(this.e.getAppId(), new h.4(this));
      localObject = new Intent(this.b, this.a);
      ((Intent)localObject).putExtra("HCE_Result_Receiver", this.m);
      ((Intent)localObject).putExtra("key_appid", this.e.getAppId());
      ((Intent)localObject).putExtra("key_time_limit", this.h);
      ((Intent)localObject).putStringArrayListExtra("key_aid_list", localArrayList);
      b.a(false);
      this.b.startService((Intent)localObject);
      this.i = System.currentTimeMillis();
      localObject = new h.5(this);
      this.j = new Timer();
      this.j.schedule((TimerTask)localObject, 10000L);
      return;
    }
    catch (Exception localException)
    {
      label240:
      break label240;
    }
    ((Map)localObject).put("errCode", Integer.valueOf(13003));
    a(a("fail: aid_list invalid", (Map)localObject));
    com.tencent.luggage.wxa.li.c.a(this.e.getAppId(), 13003);
  }
  
  private void g()
  {
    synchronized (this.k)
    {
      boolean bool = this.l;
      if (!bool) {
        this.l = true;
      }
      if (bool)
      {
        o.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has finished, return");
        return;
      }
      if (b.a())
      {
        o.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
        return;
      }
      o.d("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCEService overtime, expect time limit: %d seconds", new Object[] { Integer.valueOf(10) });
      h();
      ??? = this.e;
      if (??? != null) {
        com.tencent.luggage.wxa.li.c.a(((com.tencent.luggage.wxa.jx.c)???).getAppId(), 13007, -2);
      }
      ??? = new HashMap();
      ((Map)???).put("errCode", Integer.valueOf(13007));
      a(a("fail: start HCEService failed", (Map)???));
      return;
    }
  }
  
  private void h()
  {
    b.a(true);
  }
  
  public void a(com.tencent.luggage.wxa.jx.c arg1, JSONObject paramJSONObject, int paramInt)
  {
    o.d("MicroMsg.JsApiNFCStartHCE", "alvinluo appbrand start HCE, data: %s", new Object[] { paramJSONObject.toString() });
    this.e = ???;
    this.f = paramInt;
    this.g = paramJSONObject;
    synchronized (this.k)
    {
      this.l = false;
      if (this.a == null)
      {
        a(b("fail: HostApduService is nil"));
        return;
      }
      this.h = this.g.optInt("time_limit", 1500);
      a(new h.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lh.h
 * JD-Core Version:    0.7.0.1
 */