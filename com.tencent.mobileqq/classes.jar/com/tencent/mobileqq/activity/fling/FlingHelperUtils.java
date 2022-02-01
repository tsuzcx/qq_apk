package com.tencent.mobileqq.activity.fling;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

public class FlingHelperUtils
{
  @ConfigInject(configPath="Foundation/QQCommon/src/main/resources/Inject_FlingGestureConfig.yml", version=1)
  public static ArrayList<Class<? extends FlingHelperUtils.IFlingHelperUtils>> injectClzList = new ArrayList();
  public static FlingHelperUtils.IFlingHelperUtils utils;
  
  static
  {
    injectClzList.add(TopGestureLayoutUtil.class);
    try
    {
      if (injectClzList.size() > 0)
      {
        utils = (FlingHelperUtils.IFlingHelperUtils)((Class)injectClzList.get(0)).newInstance();
        return;
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      localInstantiationException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.FlingHelperUtils
 * JD-Core Version:    0.7.0.1
 */