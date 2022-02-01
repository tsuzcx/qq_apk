package com.tencent.luggage.wxa.jj;

import android.database.Cursor;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ha.g;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rb.a.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class s
  extends g
{
  public static final a.a w = g.a(g.class);
  private s.f A;
  private List<Object> B = null;
  private s.b C;
  private s.a y;
  private s.c z;
  
  private static JSONObject a(String paramString)
  {
    if (af.c(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (JSONException paramString)
    {
      o.a("MicroMsg.AppBrand.WxaAttributes", paramString, "createJsonObjectOrNull", new Object[0]);
    }
    return null;
  }
  
  protected a.a a()
  {
    return w;
  }
  
  public void a(Cursor paramCursor)
  {
    super.a(paramCursor);
    this.y = null;
    this.z = null;
    this.A = null;
    this.B = null;
    this.C = null;
  }
  
  public s.a c()
  {
    if (this.y == null) {
      this.y = s.a.a(this.n);
    }
    return this.y;
  }
  
  @NonNull
  public s.c d()
  {
    if (this.z == null) {
      localObject1 = null;
    }
    try
    {
      localObject2 = new JSONObject(this.r);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label27:
      Object localObject3;
      boolean bool2;
      int i;
      boolean bool1;
      break label27;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new JSONObject();
    }
    this.z = new s.c();
    localObject3 = ((JSONObject)localObject2).optJSONObject("NewSetting");
    Object localObject1 = localObject3;
    if (localObject3 == null) {
      localObject1 = new JSONObject();
    }
    this.z.a.a = ((JSONObject)localObject1).optInt("MaxLocalstorageSize", 5);
    this.z.a.b = ((JSONObject)localObject1).optInt("OpendataMaxLocalstorageSize", 5);
    this.z.a.c = ((JSONObject)localObject1).optInt("MaxCodeSize", 5);
    this.z.a.d = ((JSONObject)localObject1).optInt("ExpendedMaxWebviewDepth", 5);
    this.z.a.e = ((JSONObject)localObject1).optInt("MaxBackgroundLifespan", 600);
    this.z.a.f = ((JSONObject)localObject1).optInt("MaxRequestConcurrent", 5);
    this.z.a.g = ((JSONObject)localObject1).optInt("MaxUploadConcurrent", 5);
    this.z.a.h = ((JSONObject)localObject1).optInt("MaxDownloadConcurrent", 5);
    this.z.a.i = ((JSONObject)localObject1).optInt("MaxWebsocketConnect", 2);
    localObject3 = this.z.a;
    bool2 = true;
    ((s.c.a)localObject3).j = ((JSONObject)localObject1).optInt("MaxWorkerConcurrent", 1);
    localObject3 = this.z.a;
    i = 0;
    if (((JSONObject)localObject1).optInt("WebsocketSkipPortCheck", 0) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((s.c.a)localObject3).k = bool1;
    localObject3 = this.z.a;
    if (((JSONObject)localObject1).optInt("TLSSkipHostnameCheck", 0) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((s.c.a)localObject3).l = bool1;
    this.z.a.m = ((JSONObject)localObject1).optInt("MaxFileStorageSize", 10);
    this.z.a.n = ((JSONObject)localObject1).optInt("BackgroundNetworkInterruptedTimeout", 5);
    localObject3 = this.z.a;
    if (((JSONObject)localObject1).optInt("CanKeepAliveByAudioPlay", 0) > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((s.c.a)localObject3).o = bool1;
    this.z.a.p = ((JSONObject)localObject1).optInt("LifeSpanBeforeSuspend", 5);
    this.z.a.q = ((JSONObject)localObject1).optInt("LifeSpanAfterSuspend", 300);
    localObject3 = this.z.a;
    if (((JSONObject)localObject1).optInt("ScanCodeEnableZZM", 0) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((s.c.a)localObject3).r = bool1;
    localObject3 = this.z.a;
    if (((JSONObject)localObject1).optInt("CanPreFetchData", 0) > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((s.c.a)localObject3).s = bool1;
    localObject3 = this.z.a;
    if (((JSONObject)localObject1).optInt("CanPeriodFetchData", 0) > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((s.c.a)localObject3).t = bool1;
    this.z.a.u = ((JSONObject)localObject1).optInt("PeriodFetchData", 0);
    this.z.a.v = ((JSONObject)localObject1).optInt("PeriodFetchDataDay", 7);
    this.z.a.w = ((JSONObject)localObject1).optInt("GuaranteeFlag", 0);
    localObject3 = this.z.a;
    if (((JSONObject)localObject1).optInt("CanShowLoadingAdvert", 0) > 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    ((s.c.a)localObject3).x = bool1;
    this.z.a.y = ((JSONObject)localObject1).optInt("BrandOfficialLabel", 0);
    this.z.a.z = ((JSONObject)localObject1).optLong("OpenWxaWaitUpdateMaxMicSec", 13000L);
    this.z.a.A = ((JSONObject)localObject1).optLong("OpenWxaWaitUpdateMaxMicSecForWeakNet", 10000L);
    this.z.a.B = ((JSONObject)localObject1).optLong("OpenWxaWaitUpdateMinMicSec", 0L);
    this.z.a.C = ((JSONObject)localObject1).optLong("NextTryOpenWxaDisMicSec", 10000L);
    localObject1 = ((JSONObject)localObject2).optJSONArray("NewCategories");
    if (localObject1 != null)
    {
      this.z.b = new LinkedList();
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        if (localObject2 != null) {
          this.z.b.add(new Pair(((JSONObject)localObject2).optString("first"), ((JSONObject)localObject2).optString("second")));
        }
        i += 1;
      }
    }
    return this.z;
  }
  
  public s.f e()
  {
    if ((this.A == null) && (!af.c(this.o)))
    {
      s.f localf = s.f.a(this.o);
      this.A = localf;
      return localf;
    }
    return this.A;
  }
  
  public String f()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("NickName", this.e);
    localHashMap.put("BrandIconURL", this.g);
    localHashMap.put("BigHeadImgUrl", this.i);
    localHashMap.put("SmallHeadImgUrl", this.j);
    localHashMap.put("Signature", this.k);
    localHashMap.put("WxAppOpt", Integer.valueOf(this.l));
    localHashMap.put("RegisterSource", a(this.m));
    localHashMap.put("WxaAppInfo", a(this.n));
    localHashMap.put("WxaAppVersionInfo", a(this.o));
    localHashMap.put("BindWxaInfo", a(this.q));
    localHashMap.put("WxaAppDynamic", a(this.r));
    localHashMap.put("MMBizMenu", a(this.v));
    return new JSONObject(localHashMap).toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WxaAttributes{field_username='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", field_appId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", field_nickname='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", field_signature='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", field_registerSource='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append(", field_appInfo='");
    localStringBuilder.append(this.n);
    localStringBuilder.append('\'');
    localStringBuilder.append(", field_versionInfo='");
    localStringBuilder.append(this.o);
    localStringBuilder.append('\'');
    localStringBuilder.append(", field_bindWxaInfo='");
    localStringBuilder.append(this.q);
    localStringBuilder.append('\'');
    localStringBuilder.append(", field_dynamicInfo='");
    localStringBuilder.append(this.r);
    localStringBuilder.append('\'');
    localStringBuilder.append(", field_bizMenu='");
    localStringBuilder.append(this.v);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.s
 * JD-Core Version:    0.7.0.1
 */