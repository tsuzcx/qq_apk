package com.tencent.luggage.wxa.lx;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import androidx.core.app.NotificationManagerCompat;
import com.tencent.luggage.util.j;
import com.tencent.luggage.wxa.jx.bd;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.oq.c.c;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.pd.w;
import com.tencent.luggage.wxa.qz.n;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.HashMap;
import java.util.Map;

public class k<C extends com.tencent.luggage.wxa.iu.b>
  extends i<C>
{
  public static final int CTRL_INDEX = 40;
  public static final String NAME = "getSystemInfo";
  
  private void a(Map<String, Object> paramMap, com.tencent.luggage.wxa.iu.b paramb)
  {
    paramb = (b)paramb.a(b.class);
    float f;
    if (paramb == null) {
      f = 1.0F;
    } else {
      f = paramb.a();
    }
    paramMap.put("fontSizeSetting", Integer.valueOf(Math.round(f * 16.0F)));
  }
  
  private void a(Map<String, Object> paramMap, com.tencent.luggage.wxa.iu.b paramb, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap(6);
    paramb = paramb.y().getSafeAreaInsets();
    if (paramb != null)
    {
      int i = g.a(paramb.left);
      int j = g.a(paramb.top);
      paramInt1 = g.a(Math.min(paramb.right, paramInt1));
      paramInt2 = g.a(Math.min(paramb.bottom, paramInt2));
      localHashMap.put("left", Integer.valueOf(i));
      localHashMap.put("top", Integer.valueOf(j));
      localHashMap.put("right", Integer.valueOf(paramInt1));
      localHashMap.put("bottom", Integer.valueOf(paramInt2));
      localHashMap.put("width", Integer.valueOf(paramInt1 - i));
      localHashMap.put("height", Integer.valueOf(paramInt2 - j));
      paramMap.put("safeArea", localHashMap);
    }
  }
  
  private int b(C paramC)
  {
    Object localObject = bd.a(paramC);
    if ((localObject != null) && (((u)localObject).ai() != null))
    {
      i = ((u)localObject).ai().getDrawnStatusBarHeight();
      if (i != 0) {
        return i;
      }
    }
    localObject = paramC.y().getStatusBar();
    String str = paramC.getAppId();
    int i = 0;
    o.b("Luggage.FULL.JsApiGetSystemInfoLU", "getIntersectStatusBarHeight with component(%s %s), use windowStatusBar[%s]", new Object[] { str, paramC.getClass().getName(), localObject });
    if (localObject != null) {
      i = ((c.c)localObject).a;
    }
    return i;
  }
  
  private void b(Map<String, Object> paramMap, com.tencent.luggage.wxa.iu.b paramb)
  {
    HashMap localHashMap = new HashMap();
    Context localContext = paramb.getContext();
    paramb = Boolean.valueOf(false);
    if (localContext != null)
    {
      Object localObject = (WifiManager)localContext.getApplicationContext().getSystemService("wifi");
      if (localObject != null) {
        localHashMap.put("wifiEnabled", Boolean.valueOf(((WifiManager)localObject).isWifiEnabled()));
      } else {
        localHashMap.put("wifiEnabled", paramb);
      }
      localHashMap.put("notificationAuthorized", Boolean.valueOf(NotificationManagerCompat.from(localContext).areNotificationsEnabled()));
      localObject = (LocationManager)localContext.getSystemService("location");
      if (localObject != null) {
        localHashMap.put("locationEnabled", Boolean.valueOf(((LocationManager)localObject).isProviderEnabled("gps")));
      } else {
        localHashMap.put("locationEnabled", paramb);
      }
      try
      {
        localHashMap.put("locationAuthorized", Boolean.valueOf(j.a(localContext, "android.permission.ACCESS_FINE_LOCATION")));
        localHashMap.put("cameraAuthorized", Boolean.valueOf(j.a(localContext, "android.permission.CAMERA")));
        localHashMap.put("microphoneAuthorized", Boolean.valueOf(j.a(localContext, "android.permission.RECORD_AUDIO")));
      }
      catch (Exception localException)
      {
        o.b("Luggage.FULL.JsApiGetSystemInfoLU", "check permissions exception", new Object[] { localException });
        localHashMap.put("locationAuthorized", paramb);
        localHashMap.put("cameraAuthorized", paramb);
        localHashMap.put("microphoneAuthorized", paramb);
      }
    }
    else
    {
      localHashMap.put("wifiEnabled", paramb);
      localHashMap.put("notificationAuthorized", paramb);
      localHashMap.put("locationEnabled", paramb);
      localHashMap.put("locationAuthorized", paramb);
      localHashMap.put("cameraAuthorized", paramb);
      localHashMap.put("microphoneAuthorized", paramb);
    }
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter != null) {
      localHashMap.put("bluetoothEnabled", Boolean.valueOf(localBluetoothAdapter.isEnabled()));
    } else {
      localHashMap.put("bluetoothEnabled", paramb);
    }
    o.d("Luggage.FULL.JsApiGetSystemInfoLU", "check permissions:%s", new Object[] { localHashMap });
    paramMap.putAll(localHashMap);
  }
  
  protected Map<String, Object> a(C paramC)
  {
    Map localMap = super.a(paramC);
    int[] arrayOfInt = w.a(paramC);
    localMap.put("windowWidth", Integer.valueOf(g.a(arrayOfInt[0])));
    localMap.put("windowHeight", Integer.valueOf(g.a(arrayOfInt[1])));
    arrayOfInt = w.a(paramC);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    localMap.put("screenWidth", Integer.valueOf(g.a(i)));
    localMap.put("screenHeight", Integer.valueOf(g.a(j)));
    localMap.put("pixelRatio", Float.valueOf(g.a()));
    localMap.put("statusBarHeight", Integer.valueOf(g.a(b(paramC))));
    localMap.put("language", n.a(paramC.getContext()));
    localMap.put("version", com.tencent.luggage.wxa.qz.d.a(null, 654316592));
    if ((paramC.q() != null) && (paramC.q().A() != null)) {
      localMap.put("benchmarkLevel", Integer.valueOf(((com.tencent.luggage.wxa.do.d)paramC.q().A()).z));
    }
    localMap.put("screenTop", Integer.valueOf(g.a(w.b(paramC))));
    int k = paramC.getContext().getResources().getConfiguration().orientation;
    if (2 == k) {
      localMap.put("deviceOrientation", "landscape");
    } else if (1 == k) {
      localMap.put("deviceOrientation", "portrait");
    }
    a(localMap, paramC);
    b(localMap, paramC);
    a(localMap, paramC, i, j);
    a(paramC, localMap);
    return localMap;
  }
  
  protected void a(C paramC, Map<String, Object> paramMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.k
 * JD-Core Version:    0.7.0.1
 */