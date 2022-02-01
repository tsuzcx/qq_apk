package com.tencent.mobileqq.app.automator.step;

import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQZoneStartupMonitor;

public class CheckQZoneOatFile
  extends AsyncStep
{
  protected int doStep()
  {
    if ((BaseApplicationImpl.sProcessId == 1) && (19 < Build.VERSION.SDK_INT)) {
      ((IQZoneStartupMonitor)QRoute.api(IQZoneStartupMonitor.class)).monitor();
    }
    return super.doStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckQZoneOatFile
 * JD-Core Version:    0.7.0.1
 */