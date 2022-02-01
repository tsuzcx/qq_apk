package com.tencent.biz.qcircleshadow.local.pluginselector;

import android.content.SharedPreferences;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginManager;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public abstract class QCircleBaseSelectorProcess
  implements IPluginSelectorProcess
{
  protected boolean a(int paramInt)
  {
    Object localObject = MobileQQ.sMobileQQ.getSharedPreferences("QCircle_crash_share", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircle_crash_count_");
    localStringBuilder.append(paramInt);
    if (((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0) >= QCircleConfigHelper.c())
    {
      QCirclePluginManager.a().a(paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("crashValidEnable():net plugin ,current version:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",crashed to many times");
      QLog.i("QCIRCLE_PLUGIN", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginselector.QCircleBaseSelectorProcess
 * JD-Core Version:    0.7.0.1
 */