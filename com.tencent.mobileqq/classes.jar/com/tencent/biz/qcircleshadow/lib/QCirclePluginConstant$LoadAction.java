package com.tencent.biz.qcircleshadow.lib;

import java.util.HashMap;
import java.util.Map;

public class QCirclePluginConstant$LoadAction
{
  public static final int PLUGIN_PRELOAD_INSTALL = 1000;
  public static final int PLUGIN_PRE_START_PPS = 1005;
  public static final int PLUGIN_START_ACTIVITY = 1002;
  public static final int PLUGIN_START_SCHEME = 1003;
  public static final int PLUGIN_START_WITH_INSTALL = 1004;
  public static final Map<Integer, Integer> sAction = new HashMap();
  
  static
  {
    sAction.put(Integer.valueOf(1000), Integer.valueOf(1000));
    sAction.put(Integer.valueOf(1002), Integer.valueOf(1002));
    sAction.put(Integer.valueOf(1003), Integer.valueOf(1003));
    sAction.put(Integer.valueOf(1004), Integer.valueOf(1004));
    sAction.put(Integer.valueOf(1005), Integer.valueOf(1005));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCirclePluginConstant.LoadAction
 * JD-Core Version:    0.7.0.1
 */