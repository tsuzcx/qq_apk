package com.tencent.hippy.qq.module.tkd;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import pay;

@HippyNativeModule(name="TKDStatisticModule")
public class TKDSearchStatModule
  extends HippyNativeModuleBase
{
  private static final String EVENT_NAME = "eventName";
  private static final String TAG = "StatisticModule";
  
  public TKDSearchStatModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @NonNull
  HashMap<String, String> hippyMapToStringMap(@NonNull HippyMap paramHippyMap)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = paramHippyMap.keySet();
    if ((localObject1 != null) && (!((Set)localObject1).isEmpty()))
    {
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        Object localObject2 = paramHippyMap.get(str);
        if (localObject2 == null) {
          localHashMap.put(str, "");
        } else if ((localObject2 instanceof String)) {
          localHashMap.put(str, (String)localObject2);
        } else if ((localObject2 instanceof Number)) {
          localHashMap.put(str, "" + localObject2);
        } else if ((localObject2 instanceof Boolean)) {
          localHashMap.put(str, ((Boolean)localObject2).booleanValue() + "");
        } else {
          LogUtils.e("StatisticModule", "hippyMapToStringMap meets invalid type!!!" + localObject2.getClass());
        }
      }
    }
    return localHashMap;
  }
  
  @HippyMethod(name="statBeaconCommonEvent")
  public void statBeaconCommonEvent(String paramString1, HippyMap paramHippyMap, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramHippyMap == null)) {}
    do
    {
      return;
      paramHippyMap = hippyMapToStringMap(paramHippyMap);
    } while (paramHippyMap.size() <= 0);
    if (paramBoolean)
    {
      TKDSearchStatManager.getInstance().statBeaconCommonEvent(paramString1, paramHippyMap, paramString2, false);
      return;
    }
    TKDSearchStatManager.getInstance().statBeaconCommonEvent(paramString1, paramHippyMap, paramString2, true);
  }
  
  @HippyMethod(name="statBeaconEvent")
  public void statBeaconEvent(HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {}
    Object localObject;
    do
    {
      return;
      localObject = paramHippyMap.get("eventName");
      if (!(localObject instanceof String))
      {
        LogUtils.e("StatisticModule", "statBeaconEvent: invliad eventName!!!!");
        return;
      }
      paramHippyMap = hippyMapToStringMap(paramHippyMap);
      paramHippyMap.remove("eventName");
    } while (paramHippyMap.size() <= 0);
    paramHippyMap.put("qua", pay.d());
    paramHippyMap.put("qq", TKDAccountModule.getCurAccountInfo().qqNum);
    boolean bool1 = false;
    try
    {
      boolean bool2 = Boolean.parseBoolean((String)paramHippyMap.get("isRealTime"));
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    TKDSearchStatManager.getInstance().statWithBeacon((String)localObject, paramHippyMap, bool1);
  }
  
  @HippyMethod(name="userBehaviorStatistics")
  public void userBehaviorStatistics(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    TKDSearchStatManager.getInstance().userBehaviorStat(paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDSearchStatModule
 * JD-Core Version:    0.7.0.1
 */