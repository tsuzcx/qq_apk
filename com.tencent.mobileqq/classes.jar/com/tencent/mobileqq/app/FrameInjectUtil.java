package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

public class FrameInjectUtil
{
  @ConfigInject(configPath="Foundation/QQActivity/src/main/resources/Inject_FrameFragmentTabConfig.yml", version=1)
  public static ArrayList<Class<? extends IFrameInjectInterface>> a = new ArrayList();
  
  static
  {
    a.add(FrameInjectImpl.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameInjectUtil
 * JD-Core Version:    0.7.0.1
 */