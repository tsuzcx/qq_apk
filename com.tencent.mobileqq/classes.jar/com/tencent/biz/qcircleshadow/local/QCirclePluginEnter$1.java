package com.tencent.biz.qcircleshadow.local;

import android.content.Context;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitBean;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import vgn;
import vgo;
import vgp;
import vgw;
import vho;

public final class QCirclePluginEnter$1
  implements Runnable
{
  public QCirclePluginEnter$1(Context paramContext, QCirclePluginInitBean paramQCirclePluginInitBean) {}
  
  public void run()
  {
    if (QzoneConfig.isQCirclePluginDisable())
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "enterQCirclePlugin():QCircle plugin disable");
      return;
    }
    vgw.a();
    Object localObject = vho.a().a(true);
    if (localObject != null)
    {
      vgp.a().a(((QCirclePluginInfo)localObject).pluginZipPath, ((QCirclePluginInfo)localObject).pluginManagerPath, ((QCirclePluginInfo)localObject).version);
      QLog.i("QCIRCLE_PLUGIN", 1, "enterQCirclePlugin():get net plugin success version:" + ((QCirclePluginInfo)localObject).version);
    }
    localObject = vgw.a().a();
    if ((localObject == null) || (((vgo)localObject).a() == null))
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "enterQCirclePlugin():failed because no plugin info");
      return;
    }
    vgn.a(this.jdField_a_of_type_AndroidContentContext, (vgo)localObject, 1002, this.jdField_a_of_type_ComTencentBizQcircleshadowLibQCirclePluginInitBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCirclePluginEnter.1
 * JD-Core Version:    0.7.0.1
 */