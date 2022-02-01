package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import com.tencent.mobileqq.mini.notify.MiniAppNotify.IMiniAppNotifyListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "appid", "", "kotlin.jvm.PlatformType", "scene", "", "via", "event", "timestamp", "", "onNotify"}, k=3, mv={1, 1, 16})
final class RIJMiniProgrameReporter$miniAppNotifyListener$1
  implements MiniAppNotify.IMiniAppNotifyListener
{
  public static final 1 a = new 1();
  
  public final void onNotify(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    QLog.d("KandianMergeManager", 1, "appid: " + paramString1 + " scene: " + paramInt + " via: " + paramString2 + " event: " + paramString3 + " timestamp: " + paramLong);
    if (paramInt != 2103) {
      return;
    }
    RIJMiniProgrameReporter.a.e(paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJMiniProgrameReporter.miniAppNotifyListener.1
 * JD-Core Version:    0.7.0.1
 */