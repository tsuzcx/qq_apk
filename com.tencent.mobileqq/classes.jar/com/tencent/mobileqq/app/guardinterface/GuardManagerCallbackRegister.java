package com.tencent.mobileqq.app.guardinterface;

import com.tencent.mobileqq.app.guardcallback.CommonProcessor;
import com.tencent.mobileqq.app.guardcallback.MemoryReportProcessor;
import com.tencent.mobileqq.app.guardcallback.PatchProcessor;
import com.tencent.mobileqq.app.guardcallback.SplashProcessor;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

public class GuardManagerCallbackRegister
{
  @ConfigInject(configPath="Foundation/QQActivity/src/main/resources/Inject_GuardManagerConfig.yml", version=1)
  public static ArrayList<Class<? extends IGuardInterface>> a = new ArrayList();
  
  static
  {
    a.add(MemoryReportProcessor.class);
    a.add(SplashProcessor.class);
    a.add(PatchProcessor.class);
    a.add(CommonProcessor.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.guardinterface.GuardManagerCallbackRegister
 * JD-Core Version:    0.7.0.1
 */