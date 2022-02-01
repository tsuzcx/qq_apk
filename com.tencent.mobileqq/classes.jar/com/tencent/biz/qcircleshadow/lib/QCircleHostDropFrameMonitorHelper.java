package com.tencent.biz.qcircleshadow.lib;

import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;

public class QCircleHostDropFrameMonitorHelper
{
  public static void startMonitorScene(String paramString)
  {
    DropFrameMonitor.a().a(paramString);
  }
  
  public static void stopMonitorScene(String paramString, boolean paramBoolean)
  {
    DropFrameMonitor.a().a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper
 * JD-Core Version:    0.7.0.1
 */