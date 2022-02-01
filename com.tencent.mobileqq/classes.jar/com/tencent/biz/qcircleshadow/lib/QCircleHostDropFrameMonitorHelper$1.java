package com.tencent.biz.qcircleshadow.lib;

import android.app.Activity;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qapmsdk.base.listener.ILooperListener;
import com.tencent.qapmsdk.base.meta.LooperMeta;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

final class QCircleHostDropFrameMonitorHelper$1
  implements ILooperListener
{
  public void onBeforeReport(@Nullable LooperMeta paramLooperMeta)
  {
    QLog.d("QAPM_looper_GetStackRunnable", 4, "onBeforeReport");
    if ((QCircleHostDropFrameMonitorHelper.access$000(paramLooperMeta)) && (QCircleHostDropFrameMonitorHelper.access$100() != null) && (HostUIHelper.getShadowTopContext() != null) && (((Activity)HostUIHelper.getShadowTopContext()).getWindow() != null) && (((Activity)HostUIHelper.getShadowTopContext()).getWindow().getDecorView() != null))
    {
      QLog.d("QAPM_looper_GetStackRunnable", 4, "onBlockLooper");
      QCircleHostDropFrameMonitorHelper.access$100().onBlockLooper((FrameLayout)((Activity)HostUIHelper.getShadowTopContext()).getWindow().getDecorView(), paramLooperMeta.getLooperParams());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper.1
 * JD-Core Version:    0.7.0.1
 */