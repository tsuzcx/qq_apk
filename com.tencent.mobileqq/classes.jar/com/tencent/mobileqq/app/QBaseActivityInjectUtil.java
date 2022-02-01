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
  public static ArrayList<Class<? extends BaseActivityLifecycleCallbacks>> a = new ArrayList();
  @ConfigInject(configPath="Foundation/QQActivity/src/main/resources/Inject_BaseActivityConfig.yml", version=1)
  public static ArrayList<Class<? extends BaseActivityLifecycleCallbacks>> b;
  @ConfigInject(configPath="Foundation/QQActivity/src/main/resources/Inject_BaseActivityConfig.yml", version=1)
  public static ArrayList<Class<? extends IBaseActivityInjectInterface>> c;
  
  static
  {
    a.add(BaseActivityLifecycleCallbackImpl.class);
    b = new ArrayList();
    b.add(MiniAIOBaseActivityLifecycleCallback.class);
    c = new ArrayList();
    c.add(BaseActivityInjectImpl.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QBaseActivityInjectUtil
 * JD-Core Version:    0.7.0.1
 */