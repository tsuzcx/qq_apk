package com.tencent.mobileqq.auto.engine.loader.selector;

import android.content.SharedPreferences;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngineFactory;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.auto.engine.loader.net.ASNetInfoManger;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public abstract class ASBaseSelectorProcess
  implements IPluginSelector<ASPluginBean>
{
  protected boolean a(ASPluginBean paramASPluginBean)
  {
    Object localObject = MobileQQ.sMobileQQ.getSharedPreferences("AS_SHARE_PREFERENCE", 0);
    int i = paramASPluginBean.getVersionCode();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AS_CRASH_COUNT_");
    localStringBuilder.append(paramASPluginBean.getBusinessKey());
    localStringBuilder.append(i);
    if (((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0) >= QCircleConfigHelper.am())
    {
      ASDynamicEngineFactory.a(paramASPluginBean.getBusinessKey()).a().a(i, paramASPluginBean.getBusinessKey());
      paramASPluginBean = ASDynamicEngine.a(paramASPluginBean.getBusinessKey());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("crashValidEnable():net plugin ,current version:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",crashed to many times");
      QLog.i(paramASPluginBean, 1, ((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.selector.ASBaseSelectorProcess
 * JD-Core Version:    0.7.0.1
 */