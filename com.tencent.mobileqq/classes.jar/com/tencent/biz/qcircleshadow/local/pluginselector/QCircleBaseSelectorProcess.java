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
    if (MobileQQ.sMobileQQ.getSharedPreferences("QCircle_crash_share", 0).getInt("QCircle_crash_count_" + paramInt, 0) >= QCircleConfigHelper.a())
    {
      QCirclePluginManager.a().a(paramInt);
      QLog.i("QCIRCLE_PLUGIN", 1, "crashValidEnable():net plugin ,current version:" + paramInt + ",crashed to many times");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.pluginselector.QCircleBaseSelectorProcess
 * JD-Core Version:    0.7.0.1
 */