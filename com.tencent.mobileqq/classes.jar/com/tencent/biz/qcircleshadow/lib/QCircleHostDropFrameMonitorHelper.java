package com.tencent.biz.qcircleshadow.lib;

import com.tencent.qapmsdk.base.listener.ILooperListener;
import com.tencent.qapmsdk.base.meta.LooperMeta;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import org.json.JSONException;
import org.json.JSONObject;

public class QCircleHostDropFrameMonitorHelper
{
  private static final int MAX_BLOCK_TIME = 500;
  private static QCircleHostDropFrameMonitorHelper.BlockLooperListener mBlockListener;
  private static ILooperListener mILooperListener = new QCircleHostDropFrameMonitorHelper.1();
  
  private static boolean isCostTimeTriggerReport(LooperMeta paramLooperMeta)
  {
    if (paramLooperMeta != null) {}
    for (;;)
    {
      try
      {
        if (paramLooperMeta.getLooperParams().getInt("cost_time") > 500)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isCostTimeTriggerReport:");
          localStringBuilder.append(paramLooperMeta.getLooperParams().getInt("cost_time"));
          localStringBuilder.append("，isBlockListener null:");
          localStringBuilder.append(mBlockListener);
          if (localStringBuilder.toString() != null) {
            break label101;
          }
          bool = true;
          QLog.d("QAPM_looper_GetStackRunnable", 4, new Object[] { Boolean.valueOf(bool) });
          return true;
        }
      }
      catch (JSONException paramLooperMeta)
      {
        paramLooperMeta.printStackTrace();
      }
      return false;
      label101:
      boolean bool = false;
    }
  }
  
  public static void removeLooperListener()
  {
    mBlockListener = null;
  }
  
  public static void setLooperListener(QCircleHostDropFrameMonitorHelper.BlockLooperListener paramBlockLooperListener)
  {
    mBlockListener = paramBlockLooperListener;
    MagnifierSDK.a().a(mILooperListener);
  }
  
  public static void startMonitorScene(String paramString)
  {
    DropFrameMonitor.a().a(paramString);
  }
  
  public static void stopMonitorScene(String paramString, boolean paramBoolean)
  {
    DropFrameMonitor.a().a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper
 * JD-Core Version:    0.7.0.1
 */