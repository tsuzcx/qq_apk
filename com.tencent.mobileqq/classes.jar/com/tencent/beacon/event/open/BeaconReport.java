package com.tencent.beacon.event.open;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.base.util.BeaconLogger;
import com.tencent.beacon.base.util.e;
import com.tencent.beacon.core.info.BeaconPubParams;
import com.tencent.beacon.module.BeaconModule;
import com.tencent.beacon.module.EventModule;
import com.tencent.beacon.module.ModuleName;
import com.tencent.beacon.qimei.IAsyncQimeiListener;
import com.tencent.beacon.qimei.Qimei;
import com.tencent.beacon.qimei.QimeiSDK;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class BeaconReport
{
  private static volatile BeaconReport a;
  private static String b = "";
  private Context c;
  private boolean d;
  private String e;
  private BeaconConfig f;
  private boolean g;
  private String h;
  
  private void a()
  {
    com.tencent.beacon.base.util.c.a(this.g);
    Object localObject = this.f;
    if (localObject != null)
    {
      com.tencent.beacon.base.util.c.a("BeaconReport", ((BeaconConfig)localObject).toString(), new Object[0]);
      com.tencent.beacon.base.net.c.b.a(this.f.getConfigHost(), this.f.getUploadHost());
      d();
      com.tencent.beacon.a.c.c.d().a(this.f.isEnableQmsp());
    }
    com.tencent.beacon.base.net.d locald = com.tencent.beacon.base.net.d.c();
    Context localContext = this.c;
    localObject = this.f;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((BeaconConfig)localObject).getHttpAdapter();
    }
    locald.a(localContext, (com.tencent.beacon.base.net.adapter.a)localObject);
    com.tencent.beacon.a.d.a.a().a(this.c);
    com.tencent.beacon.a.c.b.f();
  }
  
  private void b()
  {
    com.tencent.beacon.a.c.c localc = com.tencent.beacon.a.c.c.d();
    localc.a(this.c);
    localc.d(this.e);
    QimeiSDK.getInstance().setAppKey(this.e);
    localc.a(this.h);
  }
  
  private void c()
  {
    ModuleName[] arrayOfModuleName = ModuleName.values();
    int k = arrayOfModuleName.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      ModuleName localModuleName = arrayOfModuleName[i];
      try
      {
        localObject2 = com.tencent.beacon.event.c.c.e(localModuleName.getClassName());
        BeaconModule.a.put(localModuleName, localObject2);
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("init Module error: ");
        ((StringBuilder)localObject2).append(localException.getMessage());
        com.tencent.beacon.base.util.c.b(((StringBuilder)localObject2).toString(), new Object[0]);
        com.tencent.beacon.base.util.c.a(localException);
      }
      i += 1;
    }
    k = arrayOfModuleName.length;
    i = j;
    while (i < k)
    {
      Object localObject1 = arrayOfModuleName[i];
      localObject1 = (BeaconModule)BeaconModule.a.get(localObject1);
      if (localObject1 != null) {
        ((BeaconModule)localObject1).a(this.c);
      }
      i += 1;
    }
    QimeiSDK.getInstance().init(this.c);
  }
  
  private void d()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("u_c_a_e", Boolean.valueOf(this.f.isAuditEnable()));
    ((Map)localObject).put("u_c_b_e", Boolean.valueOf(this.f.isBidEnable()));
    ((Map)localObject).put("u_c_m_e", Boolean.valueOf(this.f.isCollectMACEnable()));
    ((Map)localObject).put("u_c_i_e", Boolean.valueOf(this.f.isCollectIMEIEnable()));
    ((Map)localObject).put("u_c_a_i_e", Boolean.valueOf(this.f.isCollectAndroidIdEnable()));
    ((Map)localObject).put("u_c_p_i_e", Boolean.valueOf(this.f.isCollectProcessInfoEnable()));
    ((Map)localObject).put("u_c_d_s", Integer.valueOf(this.f.getMaxDBCount()));
    ((Map)localObject).put("u_c_p_s", Boolean.valueOf(this.f.isPagePathEnable()));
    localObject = new com.tencent.beacon.a.a.c(8, (Map)localObject);
    com.tencent.beacon.a.a.b.a().b((com.tencent.beacon.a.a.c)localObject);
    localObject = new HashMap();
    ((Map)localObject).put("s_e_e", Boolean.valueOf(this.f.isEventReportEnable()));
    localObject = new com.tencent.beacon.a.a.c(7, (Map)localObject);
    com.tencent.beacon.a.a.b.a().b((com.tencent.beacon.a.a.c)localObject);
    localObject = new HashMap();
    ((Map)localObject).put("u_c_r_p", Long.valueOf(this.f.getRealtimePollingTime()));
    ((Map)localObject).put("u_c_n_p", Long.valueOf(this.f.getNormalPollingTIme()));
    com.tencent.beacon.a.a.b.a().b(new com.tencent.beacon.a.a.c(11, (Map)localObject));
  }
  
  public static BeaconReport getInstance()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new BeaconReport();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static String getSoPath()
  {
    return b;
  }
  
  public static void setSoPath(String paramString)
  {
    b = paramString;
  }
  
  public BeaconPubParams getCommonParams(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return BeaconPubParams.getPubParams(paramContext);
  }
  
  public String getOAID()
  {
    return f.p().y();
  }
  
  @Nullable
  public Qimei getQimei()
  {
    return QimeiSDK.getInstance().getQimei();
  }
  
  public void getQimei(IAsyncQimeiListener paramIAsyncQimeiListener)
  {
    QimeiSDK.getInstance().getQimei(paramIAsyncQimeiListener);
  }
  
  @Nullable
  public Qimei getRtQimei(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    com.tencent.beacon.a.c.c.d().a(paramContext.getApplicationContext());
    return QimeiSDK.getInstance().getQimei();
  }
  
  public String getSDKVersion()
  {
    return "4.1.22";
  }
  
  public EventResult report(BeaconEvent paramBeaconEvent)
  {
    try
    {
      if (TextUtils.isEmpty(paramBeaconEvent.getCode())) {
        return EventResult.a.a(106);
      }
      paramBeaconEvent = BeaconEvent.newBuilder(paramBeaconEvent).build();
      Object localObject = (EventModule)com.tencent.beacon.a.c.c.d().a(ModuleName.EVENT);
      if ((localObject != null) && (((EventModule)localObject).d())) {
        return ((EventModule)localObject).a(paramBeaconEvent);
      }
      localObject = new HashMap();
      ((Map)localObject).put("b_e", paramBeaconEvent);
      com.tencent.beacon.a.a.b.a().a(new com.tencent.beacon.a.a.c(6, (Map)localObject));
      paramBeaconEvent = new EventResult(0, -1L, "Beacon SDK not init beaconEvent add to cache!");
      return paramBeaconEvent;
    }
    catch (Throwable paramBeaconEvent)
    {
      com.tencent.beacon.base.util.c.a(paramBeaconEvent);
      com.tencent.beacon.a.b.d.b().a("598", "error while report", paramBeaconEvent);
    }
    return new EventResult(199, -1L, "REPORT ERROR");
  }
  
  public void resumeReport()
  {
    com.tencent.beacon.base.util.c.a("BeaconReport", "resume report by user.", new Object[0]);
    com.tencent.beacon.a.b.a.a().b();
    com.tencent.beacon.base.net.d.c().e();
  }
  
  public void setAdditionalParams(String paramString, @NonNull Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("i_c_ad", new HashMap(paramMap));
    localHashMap.put("i_c_ak", paramString);
    paramString = new com.tencent.beacon.a.a.c(3, localHashMap);
    com.tencent.beacon.a.a.b.a().b(paramString);
  }
  
  public void setAdditionalParams(@NonNull Map<String, String> paramMap)
  {
    setAdditionalParams(this.e, paramMap);
  }
  
  public void setAppVersion(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      com.tencent.beacon.a.c.b.a = paramString;
    }
  }
  
  public void setChannelID(String paramString)
  {
    this.h = paramString;
    com.tencent.beacon.a.c.c.d().a(paramString);
  }
  
  public void setCollectAndroidID(boolean paramBoolean)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("u_c_a_i_e", Boolean.valueOf(paramBoolean));
    localObject = new com.tencent.beacon.a.a.c(8, (Map)localObject);
    com.tencent.beacon.a.a.b.a().b((com.tencent.beacon.a.a.c)localObject);
  }
  
  public void setCollectImei(boolean paramBoolean)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("u_c_i_e", Boolean.valueOf(paramBoolean));
    localObject = new com.tencent.beacon.a.a.c(8, (Map)localObject);
    com.tencent.beacon.a.a.b.a().b((com.tencent.beacon.a.a.c)localObject);
  }
  
  public void setCollectMac(boolean paramBoolean)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("u_c_m_e", Boolean.valueOf(paramBoolean));
    localObject = new com.tencent.beacon.a.a.c(8, (Map)localObject);
    com.tencent.beacon.a.a.b.a().b((com.tencent.beacon.a.a.c)localObject);
  }
  
  public void setCollectProcessInfo(boolean paramBoolean)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("u_c_p_i_e", Boolean.valueOf(paramBoolean));
    localObject = new com.tencent.beacon.a.a.c(8, (Map)localObject);
    com.tencent.beacon.a.a.b.a().b((com.tencent.beacon.a.a.c)localObject);
  }
  
  public void setLogAble(boolean paramBoolean)
  {
    this.g = paramBoolean;
    com.tencent.beacon.base.util.c.a(paramBoolean);
  }
  
  public void setLogger(BeaconLogger paramBeaconLogger)
  {
    com.tencent.beacon.base.util.c.a(paramBeaconLogger);
  }
  
  @Deprecated
  public void setOAID(String paramString) {}
  
  public void setOmgID(String paramString)
  {
    QimeiSDK.getInstance().setOmgId(paramString);
  }
  
  public void setQQ(String paramString)
  {
    com.tencent.beacon.a.c.b.a(paramString);
  }
  
  public void setStrictMode(boolean paramBoolean)
  {
    e.a.set(paramBoolean);
  }
  
  public void setUserID(String paramString)
  {
    setUserID(this.e, paramString);
  }
  
  public void setUserID(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("i_c_ak", paramString1);
    localHashMap.put("i_c_u_i", paramString2);
    paramString1 = new com.tencent.beacon.a.a.c(4, localHashMap);
    com.tencent.beacon.a.a.b.a().b(paramString1);
  }
  
  public void start(@NonNull Context paramContext, @NonNull String paramString, @Nullable BeaconConfig paramBeaconConfig)
  {
    for (;;)
    {
      try
      {
        bool = this.d;
        if (bool) {
          return;
        }
        e.a("Context", paramContext);
        this.c = paramContext.getApplicationContext();
        e.a("AppKey", paramString);
        this.e = paramString;
        this.f = paramBeaconConfig;
        com.tencent.beacon.a.c.c.d().a(paramContext);
        paramContext = com.tencent.beacon.a.b.d.b();
        if ((paramBeaconConfig != null) && (paramBeaconConfig.isForceEnableAtta()))
        {
          bool = true;
          paramContext.a(bool);
          ((Application)this.c).registerActivityLifecycleCallbacks(new com.tencent.beacon.b.b());
          com.tencent.beacon.a.b.a.a().a(new c(this));
          this.d = true;
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void stopReport(boolean paramBoolean)
  {
    com.tencent.beacon.base.util.c.a("BeaconReport", "stop report by user.", new Object[0]);
    com.tencent.beacon.a.b.a.a().a(paramBoolean);
    com.tencent.beacon.base.net.d.c().close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.open.BeaconReport
 * JD-Core Version:    0.7.0.1
 */