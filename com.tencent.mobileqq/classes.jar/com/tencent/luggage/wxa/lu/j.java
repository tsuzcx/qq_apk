package com.tencent.luggage.wxa.lu;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.luggage.wxa.id.a;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.ku.f.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.sc.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class j
{
  private static final HashMap<String, HandlerThread> d = new HashMap();
  private SensorManager a;
  private Handler b;
  private String c = null;
  
  public j(String paramString)
  {
    this.b = new Handler(a(paramString).getLooper());
  }
  
  private static HandlerThread a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MicroMsg.UnitSensor.");
    ((StringBuilder)localObject).append(paramString);
    String str = ((StringBuilder)localObject).toString();
    synchronized (d)
    {
      localObject = (HandlerThread)d.get(str);
      paramString = (String)localObject;
      if (localObject == null)
      {
        paramString = d.e(str, 5);
        d.put(str, paramString);
      }
      if (paramString.getLooper() == null) {
        paramString.start();
      }
      return paramString;
    }
  }
  
  public f.a a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, j.a parama, String paramString, List<Integer> paramList)
  {
    this.c = paramString;
    boolean bool1 = paramJSONObject.optBoolean("enable");
    int i = paramJSONObject.optInt("interval", 200);
    o.d("MicroMsg.UnitSensor", "sessionId:%s,interval:%s,enable:%b", new Object[] { paramString, Integer.valueOf(i), Boolean.valueOf(bool1) });
    if (this.a == null) {
      this.a = ((SensorManager)r.a().getSystemService("sensor"));
    }
    if (this.a == null)
    {
      o.d("MicroMsg.UnitSensor", "getSystemService(SENSOR_SERVICE) failed.");
      return new f.a("fail:null system service", new Object[0]);
    }
    Object localObject2 = new ArrayList();
    paramJSONObject = paramList.iterator();
    while (paramJSONObject.hasNext())
    {
      int j = ((Integer)paramJSONObject.next()).intValue();
      paramList = this.a.getDefaultSensor(j);
      if (paramList == null)
      {
        o.d("MicroMsg.UnitSensor", "get sensor failed.");
        return new f.a("fail:null sensor", new Object[0]);
      }
      ((List)localObject2).add(paramList);
    }
    paramList = "ok";
    if (bool1)
    {
      Object localObject1 = a.a().a(paramString);
      paramJSONObject = (JSONObject)localObject1;
      if (localObject1 == null) {
        paramJSONObject = a.a().a(paramString, true);
      }
      if ((j.a)paramJSONObject.b("sensor_event_listener", null) != null)
      {
        o.c("MicroMsg.UnitSensor", "register failed, sensorEventListener has already registered.");
        return new f.a("fail, has enable, should stop pre operation", new Object[0]);
      }
      com.tencent.luggage.wxa.iu.c.a(paramc.getAppId(), parama);
      paramJSONObject.a("sensor_event_listener", parama);
      localObject1 = ((List)localObject2).iterator();
      bool1 = false;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Sensor)((Iterator)localObject1).next();
        boolean bool2 = this.a.registerListener(parama, (Sensor)localObject2, i.a(i), this.b);
        bool1 = bool2;
        if (!bool2) {
          bool1 = bool2;
        }
      }
      if (!bool1)
      {
        this.a.unregisterListener(parama);
        parama.a(true);
        com.tencent.luggage.wxa.iu.c.b(paramc.getAppId(), parama);
        paramJSONObject.b();
        a.a().b(paramString);
      }
      o.d("MicroMsg.UnitSensor", "register sensor finished(s : %s, r : %s).", new Object[] { paramString, Boolean.valueOf(bool1) });
      if (bool1) {
        paramc = paramList;
      } else {
        paramc = "fail:system error";
      }
      return new f.a(paramc, new Object[0]);
    }
    paramJSONObject = a.a().b(paramString);
    if (paramJSONObject == null)
    {
      o.d("MicroMsg.UnitSensor", "unregister sensor event listener failed, keyValueSet do not exist.");
      return new f.a("fail:fail to disable, not enable?", new Object[0]);
    }
    parama = (j.a)paramJSONObject.b("sensor_event_listener", null);
    if (parama == null)
    {
      o.d("MicroMsg.UnitSensor", "unregister sensor event listener failed, listener do not exist.");
      return new f.a("fail:fail to disable, not enable?", new Object[0]);
    }
    this.a.unregisterListener(parama);
    com.tencent.luggage.wxa.iu.c.b(paramc.getAppId(), parama);
    parama.a(true);
    paramJSONObject.b();
    o.d("MicroMsg.UnitSensor", "unregister sensor finished(%s).", new Object[] { paramString });
    return new f.a("ok", new Object[0]);
  }
  
  public void a(j.a parama)
  {
    this.a.unregisterListener(parama);
    if (!TextUtils.isEmpty(this.c)) {
      a.a().b(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lu.j
 * JD-Core Version:    0.7.0.1
 */