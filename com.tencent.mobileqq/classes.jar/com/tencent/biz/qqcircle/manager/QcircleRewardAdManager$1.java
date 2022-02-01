package com.tencent.biz.qqcircle.manager;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper.HostEnvironmentLifeCycle;
import com.tencent.qphone.base.util.QLog;

class QcircleRewardAdManager$1
  extends HostUIHelper.HostEnvironmentLifeCycle
{
  QcircleRewardAdManager$1(QcircleRewardAdManager paramQcircleRewardAdManager, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Context paramContext, String paramString) {}
  
  public void onEnvironmentCreated(Context paramContext)
  {
    super.onEnvironmentCreated(paramContext);
    if (System.currentTimeMillis() - QcircleRewardAdManager.a(this.g) < 1000L) {
      return;
    }
    QcircleRewardAdManager.a(this.g, System.currentTimeMillis());
    try
    {
      QcircleRewardAdManager.a(this.g, paramContext, this.a, this.b, this.c, this.d, this.e, 0, this.f);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QcircleRewardAdManager", 1, paramContext, new Object[0]);
      HostUIHelper.closeHostEnvironment();
      paramContext = this.e.getResources().getString(2131895896);
      QcircleRewardAdManager.a(this.g, this.e, paramContext);
    }
  }
  
  public void onEnvironmentStop(Context paramContext)
  {
    super.onEnvironmentStop(paramContext);
    HostUIHelper.closeHostEnvironment();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QcircleRewardAdManager.1
 * JD-Core Version:    0.7.0.1
 */