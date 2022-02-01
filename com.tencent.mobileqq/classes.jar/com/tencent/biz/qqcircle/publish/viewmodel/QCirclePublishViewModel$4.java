package com.tencent.biz.qqcircle.publish.viewmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper.HostEnvironmentLifeCycle;

class QCirclePublishViewModel$4
  extends HostUIHelper.HostEnvironmentLifeCycle
{
  QCirclePublishViewModel$4(QCirclePublishViewModel paramQCirclePublishViewModel, Intent paramIntent) {}
  
  public void onEnvironmentCreated(Context paramContext)
  {
    QCircleHostLauncher.startWithPublicFragmentActivityForPeak(paramContext, this.a, QCircleHostClassHelper.getPublicFragmentActivityForPeakClass(), QCircleHostClassHelper.getAEVideoPreviewFragmentClass());
  }
  
  public void onEnvironmentStop(Context paramContext)
  {
    super.onEnvironmentStop(paramContext);
    HostUIHelper.closeHostEnvironment();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel.4
 * JD-Core Version:    0.7.0.1
 */