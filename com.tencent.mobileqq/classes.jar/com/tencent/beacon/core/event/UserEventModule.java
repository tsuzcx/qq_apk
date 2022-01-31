package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.a.c;
import com.tencent.beacon.core.b.a;
import com.tencent.beacon.core.b.d;
import com.tencent.beacon.core.d.i;
import com.tencent.beacon.core.strategy.StrategyQueryModule;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

public class UserEventModule
  extends com.tencent.beacon.core.b
{
  private static UserEventModule mInstance = null;
  private m sensorManager;
  private boolean uploadMode = true;
  
  protected UserEventModule(Context paramContext)
  {
    super(paramContext);
    com.tencent.beacon.core.b.b.a(this.mContext);
    EventStrategyBean.getInstance();
    this.sensorManager = new m();
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
  
  public void onAppResumed()
  {
    sensorEvent();
  }
  
  public void onAppStop() {}
  
  public void onModuleStarted()
  {
    super.onModuleStarted();
    com.tencent.beacon.core.d.b.b("[event] start userEvent module > heartbeat & launched", new Object[0]);
    new f(this.mContext).b();
    startAppLaunched();
  }
  
  public void sensorEvent()
  {
    this.sensorManager.a(this.mContext);
  }
  
  public void setUploadMode(boolean paramBoolean)
  {
    if (paramBoolean != this.uploadMode)
    {
      this.uploadMode = paramBoolean;
      if (this.uploadMode)
      {
        new f(this.mContext).b();
        startAppLaunched();
      }
    }
    else
    {
      return;
    }
    f.a(this.mContext);
  }
  
  public void startAppLaunched()
  {
    if (EventStrategyBean.getInstance().isLaunchEventSimple())
    {
      str = c.a(this.mContext).a("LAUEVE_DENGTA", "");
      if (i.a().equals(str))
      {
        com.tencent.beacon.core.d.b.a("[event] AppLaunchedEvent has been uploaded!", new Object[0]);
        return;
      }
    }
    if (d.a(this.mContext) == null)
    {
      com.tencent.beacon.core.d.b.d("[event] DeviceInfo is null then return", new Object[0]);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("A33", d.j(this.mContext));
    localHashMap.put("A133", d.f(this.mContext));
    localHashMap.put("A63", "Y");
    if (a.a(this.mContext))
    {
      localHashMap.put("A21", "Y");
      if (!StrategyQueryModule.getInstance(this.mContext).isAppFirstRun()) {
        break label338;
      }
      localHashMap.put("A45", "Y");
      label160:
      if (!a.g(this.mContext)) {
        break label352;
      }
      localHashMap.put("A66", "F");
      label181:
      localHashMap.put("A68", a.h(this.mContext));
      if (!a.a) {
        break label366;
      }
    }
    label338:
    label352:
    label366:
    for (String str = "Y";; str = "N")
    {
      localHashMap.put("A85", str);
      localHashMap.put("A9", d.e());
      localHashMap.put("A14", d.f());
      localHashMap.put("A20", d.g(this.mContext));
      localHashMap.put("A69", d.h(this.mContext));
      if (UserAction.onUserAction("rqd_applaunched", true, 0L, 0L, localHashMap, true)) {
        c.a(this.mContext).a().a("LAUEVE_DENGTA", i.a()).b();
      }
      sensorEvent();
      return;
      localHashMap.put("A21", "N");
      break;
      localHashMap.put("A45", "N");
      break label160;
      localHashMap.put("A66", "B");
      break label181;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.UserEventModule
 * JD-Core Version:    0.7.0.1
 */