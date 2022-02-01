package com.tencent.mobileqq.auto.engine.lib;

import java.util.HashMap;
import java.util.Map;

public class ASEngineConstants$LoadAction
{
  public static final int PLUGIN_PRELOAD_INSTALL = 1000;
  public static final int PLUGIN_START_ACTIVITY = 1001;
  public static final int PLUGIN_START_WITH_INSTALL = 1002;
  public static final Map<Integer, Integer> sAction = new HashMap();
  
  static
  {
    Map localMap = sAction;
    Integer localInteger = Integer.valueOf(1000);
    localMap.put(localInteger, localInteger);
    localMap = sAction;
    localInteger = Integer.valueOf(1001);
    localMap.put(localInteger, localInteger);
    localMap = sAction;
    localInteger = Integer.valueOf(1002);
    localMap.put(localInteger, localInteger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.lib.ASEngineConstants.LoadAction
 * JD-Core Version:    0.7.0.1
 */