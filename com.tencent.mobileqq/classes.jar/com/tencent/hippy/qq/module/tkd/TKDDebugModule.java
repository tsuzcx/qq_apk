package com.tencent.hippy.qq.module.tkd;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

@HippyNativeModule(name="TKDDebugModule")
public class TKDDebugModule
  extends HippyNativeModuleBase
{
  private static final String TAG = "TKDDebugModule";
  
  public TKDDebugModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="eventLog")
  public void eventLog(HippyMap paramHippyMap)
  {
    String str1 = paramHippyMap.getString("bussiness");
    String str2 = paramHippyMap.getString("group");
    String str3 = paramHippyMap.getString("massage");
    String str4 = paramHippyMap.getString("detail");
    String str5 = paramHippyMap.getString("owner");
    int i = paramHippyMap.getInt("result");
    if (QLog.isColorLevel()) {
      QLog.d("TKDDebugModule", 2, String.format(Locale.CHINESE, "business=%s group=%s message=%s detail=%s owner=%s result=%d", new Object[] { str1, str2, str3, str4, str5, Integer.valueOf(i) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDDebugModule
 * JD-Core Version:    0.7.0.1
 */