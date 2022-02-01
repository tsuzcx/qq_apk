package com.tencent.luggage.wxa.jx;

import android.os.Build.VERSION;
import androidx.annotation.CallSuper;
import com.tencent.luggage.wxa.do.d;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.mm.plugin.appbrand.appcache.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class am
  extends u<b>
{
  private static final int CTRL_INDEX = 97;
  private static final String NAME = "getPublicLibVersion";
  
  public String a(b paramb, JSONObject paramJSONObject)
  {
    if (!paramb.d()) {
      return b("fail js context not running");
    }
    return a("ok", a(paramb));
  }
  
  @CallSuper
  protected Map<String, Object> a(b paramb)
  {
    HashMap localHashMap = new HashMap();
    d locald = (d)paramb.b(d.class);
    int i = locald.S.b;
    boolean bool2 = true;
    boolean bool1;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localHashMap.put("appDebug", Boolean.valueOf(bool1));
    localHashMap.put("appMd5", com.tencent.luggage.wxa.qz.af.b(locald.S.md5));
    localHashMap.put("appVersion", Integer.valueOf(locald.S.pkgVersion));
    paramb = paramb.A();
    if (paramb != null)
    {
      paramb = (com.tencent.mm.plugin.appbrand.appcache.af)paramb.f();
      if (paramb.b != 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localHashMap.put("libDebug", Boolean.valueOf(bool1));
      localHashMap.put("libMd5", com.tencent.luggage.wxa.qz.af.b(paramb.md5));
      localHashMap.put("libVersion", Integer.valueOf(paramb.pkgVersion));
    }
    localHashMap.put("system", "android");
    localHashMap.put("systemVersion", Integer.valueOf(Build.VERSION.SDK_INT));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.am
 * JD-Core Version:    0.7.0.1
 */