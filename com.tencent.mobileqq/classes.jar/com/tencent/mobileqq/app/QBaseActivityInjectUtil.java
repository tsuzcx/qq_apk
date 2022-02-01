package com.tencent.mobileqq.app;

import com.tencent.mobileqq.app.lifecycle.BaseActivityInjectImpl;
import com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbackImpl;
import com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks;
import com.tencent.mobileqq.app.lifecycle.MiniAIOBaseActivityLifecycleCallback;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

public class QBaseActivityInjectUtil
{
  @ConfigInject(configPath="Foundation/QQActivity/src/main/resources/Inject_BaseActivityConfig.yml", version=1)
  public static ArrayList<Class<? extends BaseActivityLifecycleCallbacks>> globalCallbacks = new ArrayList();
  @ConfigInject(configPath="Foundation/QQActivity/src/main/resources/Inject_BaseActivityConfig.yml", version=1)
  public static ArrayList<Class<? extends IBaseActivityInjectInterface>> injectInterfaceClzList;
  @ConfigInject(configPath="Foundation/QQActivity/src/main/resources/Inject_BaseActivityConfig.yml", version=1)
  public static ArrayList<Class<? extends BaseActivityLifecycleCallbacks>> instanceCallbacks;
  
  static
  {
    globalCallbacks.add(BaseActivityLifecycleCallbackImpl.class);
    instanceCallbacks = new ArrayList();
    instanceCallbacks.add(MiniAIOBaseActivityLifecycleCallback.class);
    injectInterfaceClzList = new ArrayList();
    injectInterfaceClzList.add(BaseActivityInjectImpl.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QBaseActivityInjectUtil
 * JD-Core Version:    0.7.0.1
 */