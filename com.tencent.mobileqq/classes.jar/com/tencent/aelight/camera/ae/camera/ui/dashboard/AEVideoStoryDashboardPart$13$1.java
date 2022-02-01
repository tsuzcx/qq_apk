package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import eipc.EIPCResult;
import org.light.device.OfflineConfig;

class AEVideoStoryDashboardPart$13$1
  implements Runnable
{
  AEVideoStoryDashboardPart$13$1(AEVideoStoryDashboardPart.13 param13, EIPCResult paramEIPCResult) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.data.getString("KEY_ENV_INFO"));
    ((StringBuilder)localObject).append(", PerfLevel: ");
    ((StringBuilder)localObject).append(OfflineConfig.getPhonePerfLevel(BaseApplicationImpl.getContext()));
    localObject = ((StringBuilder)localObject).toString();
    AEVideoStoryDashboardPart.i(this.b.a).setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.13.1
 * JD-Core Version:    0.7.0.1
 */