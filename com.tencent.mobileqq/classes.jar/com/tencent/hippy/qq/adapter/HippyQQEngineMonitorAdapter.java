package com.tencent.hippy.qq.adapter;

import android.view.View;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.List;

public class HippyQQEngineMonitorAdapter
  implements HippyEngineMonitorAdapter
{
  public boolean needReportBridgeANR()
  {
    return false;
  }
  
  public void reportBridgeANR(String paramString) {}
  
  public void reportClickEvent(Object paramObject, boolean paramBoolean)
  {
    if (((paramObject instanceof View)) && (paramBoolean)) {
      VideoReport.reportEvent("clck", (View)paramObject, null);
    }
  }
  
  public void reportDoCallNatives(String paramString1, String paramString2) {}
  
  public void reportEngineLoadResult(int paramInt1, int paramInt2, List<HippyEngineMonitorEvent> paramList, Throwable paramThrowable) {}
  
  public void reportEngineLoadStart() {}
  
  public void reportGestureEventCallStack(String paramString1, String paramString2) {}
  
  public void reportModuleLoadComplete(HippyRootView paramHippyRootView, int paramInt, List<HippyEngineMonitorEvent> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQEngineMonitorAdapter
 * JD-Core Version:    0.7.0.1
 */