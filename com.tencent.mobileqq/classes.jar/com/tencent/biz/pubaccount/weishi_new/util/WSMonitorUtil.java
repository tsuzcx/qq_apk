package com.tencent.biz.pubaccount.weishi_new.util;

import android.app.Activity;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;

public class WSMonitorUtil
{
  public static void a(Activity paramActivity) {}
  
  public static void a(Activity paramActivity, String paramString)
  {
    DropFrameMonitor.a().a(paramString);
  }
  
  public static void a(String paramString)
  {
    DropFrameMonitor.a().a(paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSMonitorUtil
 * JD-Core Version:    0.7.0.1
 */