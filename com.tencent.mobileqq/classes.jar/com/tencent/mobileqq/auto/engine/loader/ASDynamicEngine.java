package com.tencent.mobileqq.auto.engine.loader;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants.AppName;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants.BusinessKeyToUUID;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.auto.engine.lib.delegateimpl.ASEngineImpl;
import com.tencent.mobileqq.auto.engine.lib.delegateimpl.ASToastImpl;
import com.tencent.mobileqq.auto.engine.loader.net.ASNetInfoManger;
import com.tencent.mobileqq.auto.engine.loader.parse.ASPluginInfoParseActuator;
import com.tencent.mobileqq.auto.engine.loader.selector.ASPluginSelectorNetProcess;
import com.tencent.mobileqq.auto.engine.loader.selector.ASPluginSelectorSupportProcess;
import com.tencent.mobileqq.auto.engine.loader.selector.ASPluginSelectorWnsProcess;
import com.tencent.mobileqq.auto.engine.loader.selector.ASSelectorChain;
import com.tencent.mobileqq.auto.engine.loader.selector.ASSelectorNativeProcess;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class ASDynamicEngine
{
  private static final ConcurrentHashMap<String, ASDynamicEngine> a = new ConcurrentHashMap();
  private final ASEngineConfig b;
  private final ASPluginInfoParseActuator c;
  private final ASSelectorChain d;
  private volatile boolean e;
  private volatile ASPluginBean f;
  private boolean g;
  private boolean h;
  private ASNetInfoManger i;
  private boolean j;
  
  private ASDynamicEngine(ASEngineConfig paramASEngineConfig)
  {
    this.b = paramASEngineConfig;
    a.put(paramASEngineConfig.a(), this);
    this.i = new ASNetInfoManger();
    this.c = new ASPluginInfoParseActuator(this.b.a());
    this.d = new ASSelectorChain();
    this.f = this.d.a(this.b.a());
    m();
    l();
    o();
    k();
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "ASDynamicEngine";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ASDynamicEngine_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static ASDynamicEngine b(ASEngineConfig paramASEngineConfig)
  {
    if (!a.containsKey(paramASEngineConfig.a())) {
      try
      {
        if (!a.containsKey(paramASEngineConfig.a()))
        {
          ASDynamicEngine localASDynamicEngine = new ASDynamicEngine(paramASEngineConfig);
          a.put(paramASEngineConfig.a(), localASDynamicEngine);
        }
      }
      finally {}
    }
    return (ASDynamicEngine)a.get(paramASEngineConfig.a());
  }
  
  public static ASDynamicEngine b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (a.containsKey(paramString))) {
      return (ASDynamicEngine)a.get(paramString);
    }
    return null;
  }
  
  public static void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      String str = d(paramString);
      Object localObject2 = ASDynamicEngineFactory.a(str);
      if (((ASDynamicEngine)localObject2).g()) {
        return;
      }
      int k = ((ASDynamicEngine)localObject2).b().getVersionCode();
      SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("AS_SHARE_PREFERENCE", 0);
      int m = ((ASDynamicEngine)localObject2).b().getVersionCode();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("AS_CRASH_COUNT_");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(m);
      localObject1 = ((StringBuilder)localObject1).toString();
      m = localSharedPreferences.getInt((String)localObject1, 0) + 1;
      localSharedPreferences.edit().putInt((String)localObject1, m).apply();
      if (m >= QCircleConfigHelper.am()) {
        ((ASDynamicEngine)localObject2).a().a(k, str);
      }
      str = a(str);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("crashCount: ");
      ((StringBuilder)localObject2).append(m);
      ((StringBuilder)localObject2).append(" crashVersion:");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append(" key:");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("---------");
      ((StringBuilder)localObject2).append(paramString);
      QLog.i(str, 1, ((StringBuilder)localObject2).toString());
      return;
    }
    catch (Exception paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("check stack exception:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("ASDynamicEngine", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  private static String d(@NonNull String paramString)
  {
    if (paramString.toLowerCase().contains("flashshow")) {
      return "flash-show-app";
    }
    if (paramString.toLowerCase().contains("qcircle")) {
      return "qcircle-app";
    }
    return "";
  }
  
  private void k()
  {
    if (!g()) {
      return;
    }
    String str = (String)ASEngineConstants.AppName.sAPP.get(this.b.a());
    if (TextUtils.isEmpty(str))
    {
      QLog.d(a(this.b.a()), 1, "appName is empty");
      return;
    }
    try
    {
      Object localObject1 = Class.forName(str);
      localObject2 = ((Class)localObject1).newInstance();
      ((Class)localObject1).getMethod("init", new Class[] { Application.class }).invoke(localObject2, new Object[] { MobileQQ.sMobileQQ });
      localObject1 = a(this.b.a());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("init success:");
      ((StringBuilder)localObject2).append(str);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Object localObject2 = a(this.b.a());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init failed:");
      localStringBuilder.append(str);
      QLog.d((String)localObject2, 1, localStringBuilder.toString(), localException);
    }
  }
  
  private void l()
  {
    if (!g()) {
      ASEngineConstants.BusinessKeyToUUID.sUUID.put(this.b.a(), this.f.getUUid());
    }
  }
  
  private void m()
  {
    ASInject.g().setToastDelegate(new ASToastImpl()).setAsEngineDelegate(new ASEngineImpl());
  }
  
  private void n()
  {
    this.f = new ASPluginBean().setBusinessKey(this.b.a()).setType("TYPE_NATIVE").setVersionCode(ASEngineUtils.a());
  }
  
  private void o()
  {
    ThreadManager.excute(new ASDynamicEngine.1(this), 64, null, true);
  }
  
  private void p()
  {
    if (this.e) {
      return;
    }
    ConcurrentHashMap localConcurrentHashMap = e();
    if (this.b.b() != null) {
      this.d.a(this.b.b());
    }
    this.d.a(new ASPluginSelectorSupportProcess()).a(new ASPluginSelectorWnsProcess((ASPluginBean)localConcurrentHashMap.get("TYPE_NATIVE"))).a(new ASPluginSelectorNetProcess((ASPluginBean)localConcurrentHashMap.get("TYPE_NET"), (ASPluginBean)localConcurrentHashMap.get("TYPE_NATIVE"))).a(new ASSelectorNativeProcess((ASPluginBean)localConcurrentHashMap.get("TYPE_NATIVE")));
    this.e = true;
  }
  
  private String q()
  {
    if ("TYPE_NATIVE".equals(this.f.getType())) {
      return "A";
    }
    if ("TYPE_NET".equals(this.f.getType())) {
      return "N";
    }
    if ("TYPE_DEBUG".equals(this.f.getType())) {
      return "T";
    }
    return "U";
  }
  
  public ASNetInfoManger a()
  {
    return this.i;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public ASPluginBean b()
  {
    return this.f;
  }
  
  public boolean b(boolean paramBoolean)
  {
    String str = a(this.b.a());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setForceNative:");
    localStringBuilder.append(paramBoolean);
    QLog.d(str, 1, localStringBuilder.toString());
    n();
    k();
    this.j = paramBoolean;
    return paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean c()
  {
    return this.g;
  }
  
  public boolean d()
  {
    String str = a(this.b.a());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("forceNative:");
    localStringBuilder.append(this.j);
    QLog.d(str, 1, localStringBuilder.toString());
    return this.j;
  }
  
  public ConcurrentHashMap<String, ASPluginBean> e()
  {
    return this.c.a();
  }
  
  public ASEngineConfig f()
  {
    return this.b;
  }
  
  public boolean g()
  {
    Object localObject = this.f;
    boolean bool2 = false;
    boolean bool1;
    if ((localObject != null) && ("TYPE_NATIVE".equals(this.f.getType()))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localObject = a(this.b.a());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isNative:");
    localStringBuilder.append(bool1);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    if (!bool1)
    {
      bool1 = bool2;
      if (!this.j) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public String h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QUA.getQUA3());
    localStringBuilder.append("_");
    localStringBuilder.append(i());
    return localStringBuilder.toString();
  }
  
  public String i()
  {
    String str = q();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.f.getVersionCode());
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public boolean j()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine
 * JD-Core Version:    0.7.0.1
 */