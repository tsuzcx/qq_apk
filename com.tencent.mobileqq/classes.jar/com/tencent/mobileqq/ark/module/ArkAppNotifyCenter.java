package com.tencent.mobileqq.ark.module;

import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.api.notify.GdtNotify;
import com.tencent.mobileqq.ark.api.notify.TroopNotify;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class ArkAppNotifyCenter
{
  public static final String TAG = "ArkAppNotifyCenter";
  static boolean inited = false;
  private static final Object lock;
  @ConfigInject(configPath="Business/qqark-impl/src/main/resources/Inject_ArkAppNotifyCenter.yml", version=1)
  private static final HashMap<String, Class<? extends IAppNotifyCallback>> notifyClasses;
  private static final HashMap<String, IAppNotifyCallback> notifyRegs = new HashMap();
  
  static
  {
    notifyClasses = new HashMap();
    notifyClasses.put("com.tencent.qqvip_ams_push", GdtNotify.class);
    notifyClasses.put("com.tencent.syh.render", GdtNotify.class);
    notifyClasses.put("com.tencent.syh.ad", GdtNotify.class);
    notifyClasses.put("com.tencent.gwh.illustrated", GdtNotify.class);
    notifyClasses.put("com.tencent.gwh.graphic", GdtNotify.class);
    notifyClasses.put("com.tencent.gwh.video", GdtNotify.class);
    notifyClasses.put("com.tencent.cmshow.mp", GdtNotify.class);
    notifyClasses.put("com.tencent.carecomic.update", GdtNotify.class);
    notifyClasses.put("com.tencent.carecomic.normal", GdtNotify.class);
    notifyClasses.put("com.tencent.qqcomic.care", GdtNotify.class);
    notifyClasses.put("com.tencent.pcg.qzone.qqcps", GdtNotify.class);
    notifyClasses.put("com.tencent.weather", GdtNotify.class);
    notifyClasses.put("com.tencent.tangram.test", GdtNotify.class);
    notifyClasses.put("com.tencent.tangram.card", GdtNotify.class);
    notifyClasses.put("com.tencent.mobileqq.reading", GdtNotify.class);
    notifyClasses.put("com.tencent.gdt.funPlayView", GdtNotify.class);
    notifyClasses.put("com.tencent.gdt.IllustratedView", GdtNotify.class);
    notifyClasses.put("com.tencent.gdt.label", GdtNotify.class);
    notifyClasses.put("com.tencent.gdt.gouwu", GdtNotify.class);
    notifyClasses.put("com.tencent.yundong", GdtNotify.class);
    notifyClasses.put("com.tencent.test.troopapp", TroopNotify.class);
    notifyClasses.put("com.tencent.troopapp", TroopNotify.class);
    lock = new Object();
    Log.i("ArkAppNotifyCenter", "ArkAppNotifyCenter.cinit");
    init();
  }
  
  public static void init()
  {
    if (inited) {
      return;
    }
    synchronized (lock)
    {
      if (inited) {
        return;
      }
      inited = true;
      HashMap localHashMap = new HashMap();
      Iterator localIterator = notifyClasses.entrySet().iterator();
      for (;;)
      {
        Map.Entry localEntry;
        IAppNotifyCallback localIAppNotifyCallback1;
        if (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          IAppNotifyCallback localIAppNotifyCallback2 = (IAppNotifyCallback)localHashMap.get(localEntry.getValue());
          localIAppNotifyCallback1 = localIAppNotifyCallback2;
          if (localIAppNotifyCallback2 != null) {}
        }
        try
        {
          localIAppNotifyCallback1 = (IAppNotifyCallback)((Class)localEntry.getValue()).newInstance();
          localHashMap.put(localEntry.getValue(), localIAppNotifyCallback1);
          notifyRegs.put(localEntry.getKey(), localIAppNotifyCallback1);
        }
        catch (Exception localException) {}
      }
      return;
    }
  }
  
  public static boolean notify(String paramString1, String paramString2, String paramString3)
  {
    IAppNotifyCallback localIAppNotifyCallback = (IAppNotifyCallback)notifyRegs.get(paramString1);
    if (localIAppNotifyCallback != null)
    {
      ThreadManager.getSubThreadHandler().post(new ArkAppNotifyCenter.1(localIAppNotifyCallback, paramString1, paramString2, paramString3));
      return true;
    }
    return false;
  }
  
  public static void setNotify(String paramString, IAppNotifyCallback paramIAppNotifyCallback)
  {
    if (paramIAppNotifyCallback != null)
    {
      notifyRegs.put(paramString, paramIAppNotifyCallback);
      return;
    }
    notifyRegs.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppNotifyCenter
 * JD-Core Version:    0.7.0.1
 */