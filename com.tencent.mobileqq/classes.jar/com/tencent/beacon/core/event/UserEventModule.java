package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.a.f;
import com.tencent.beacon.core.c;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.info.a;
import com.tencent.beacon.core.info.e;
import com.tencent.beacon.core.strategy.StrategyQueryModule;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

public class UserEventModule
  extends c
{
  private static UserEventModule mInstance;
  private v sensorManager;
  private boolean uploadMode = true;
  
  protected UserEventModule(Context paramContext)
  {
    super(paramContext);
    com.tencent.beacon.core.info.b.b(this.mContext);
    EventStrategyBean.getInstance();
    this.sensorManager = new v();
  }
  
  public static UserEventModule getInstance()
  {
    try
    {
      UserEventModule localUserEventModule = mInstance;
      return localUserEventModule;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static UserEventModule getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new UserEventModule(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  public void onAppHotLaunch()
  {
    sensorEvent();
  }
  
  public void onAppStop()
  {
    this.sensorManager.c(this.mContext);
  }
  
  public void onModuleStarted()
  {
    super.onModuleStarted();
    d.a("[event] start userEvent module > heartbeat & launched", new Object[0]);
    new m(this.mContext).a(false);
    startAppLaunched();
  }
  
  public void sensorEvent()
  {
    this.sensorManager.b(this.mContext);
  }
  
  public void setUploadMode(boolean paramBoolean)
  {
    if (paramBoolean != this.uploadMode)
    {
      this.uploadMode = paramBoolean;
      if (this.uploadMode)
      {
        new m(this.mContext).a(false);
        startAppLaunched();
      }
    }
    else
    {
      return;
    }
    m.a(this.mContext);
  }
  
  public void startAppLaunched()
  {
    if (EventStrategyBean.getInstance().isLaunchEventSimple())
    {
      str = f.a(this.mContext).a("LAUEVE_DENGTA", "");
      if (com.tencent.beacon.core.e.b.a().equals(str))
      {
        d.d("[event] AppLaunchedEvent has been uploaded!", new Object[0]);
        return;
      }
    }
    e locale = e.d(this.mContext);
    if (locale == null)
    {
      d.b("[event] DeviceInfo is null then return", new Object[0]);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("A33", locale.k(this.mContext));
    localHashMap.put("A133", locale.a(this.mContext));
    localHashMap.put("A63", "Y");
    if (a.j(this.mContext))
    {
      localHashMap.put("A21", "Y");
      if (!StrategyQueryModule.getInstance(this.mContext).isAppFirstRun()) {
        break label351;
      }
      localHashMap.put("A45", "Y");
      label164:
      if (!a.h(this.mContext)) {
        break label365;
      }
      localHashMap.put("A66", "F");
      label185:
      localHashMap.put("A68", "" + a.b(this.mContext));
      if (!a.f) {
        break label379;
      }
    }
    label351:
    label365:
    label379:
    for (String str = "Y";; str = "N")
    {
      localHashMap.put("A85", str);
      localHashMap.put("A9", locale.d());
      localHashMap.put("A14", locale.q());
      localHashMap.put("A20", locale.p(this.mContext));
      localHashMap.put("A69", locale.q(this.mContext));
      if (UserAction.onUserAction("rqd_applaunched", true, 0L, 0L, localHashMap, true)) {
        f.a(this.mContext).b().a("LAUEVE_DENGTA", com.tencent.beacon.core.e.b.a()).a();
      }
      sensorEvent();
      return;
      localHashMap.put("A21", "N");
      break;
      localHashMap.put("A45", "N");
      break label164;
      localHashMap.put("A66", "B");
      break label185;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.UserEventModule
 * JD-Core Version:    0.7.0.1
 */