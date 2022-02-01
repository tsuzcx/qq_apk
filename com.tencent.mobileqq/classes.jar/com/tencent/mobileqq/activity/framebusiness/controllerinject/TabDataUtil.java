package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

public class TabDataUtil
{
  @ConfigInject(configPath="Foundation/QQActivity/src/main/resources/Inject_TabData.yml", version=1)
  public static ArrayList<Class<? extends ITabDataUtil>> a = new ArrayList();
  
  static
  {
    a.add(com.tencent.mobileqq.utils.tab.TabDataUtil.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataUtil
 * JD-Core Version:    0.7.0.1
 */