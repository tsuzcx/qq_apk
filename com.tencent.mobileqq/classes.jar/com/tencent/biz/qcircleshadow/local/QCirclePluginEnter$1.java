package com.tencent.biz.qcircleshadow.local;

import android.content.Context;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitBean;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import vvh;
import vvi;
import vvj;
import vvq;
import vwj;

public final class QCirclePluginEnter$1
  implements Runnable
{
  public QCirclePluginEnter$1(QCirclePluginInitBean paramQCirclePluginInitBean, Context paramContext) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    QLog.i("QCIRCLE_PLUGIN", 1, "enterQCirclePlugin():wait for thread cost:" + (l - this.jdField_a_of_type_ComTencentBizQcircleshadowLibQCirclePluginInitBean.getStartTime()));
    if (QzoneConfig.isQCirclePluginDisable())
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "enterQCirclePlugin():QCircle plugin disable");
      return;
    }
    vvq.a();
    Object localObject = vwj.a().a(true);
    if (localObject != null)
    {
      vvj.a().a((QCirclePluginInfo)localObject);
      QLog.i("QCIRCLE_PLUGIN", 1, "enterQCirclePlugin():get net plugin success version:" + ((QCirclePluginInfo)localObject).version);
    }
    localObject = vvq.a().a();
    if ((localObject == null) || (((vvi)localObject).a() == null))
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "enterQCirclePlugin():failed because no plugin info");
      return;
    }
    vvh.a(this.jdField_a_of_type_AndroidContentContext, (vvi)localObject, 1002, this.jdField_a_of_type_ComTencentBizQcircleshadowLibQCirclePluginInitBean);
    QLog.i("QCIRCLE_PLUGIN", 1, "enterQCirclePlugin(): load cost:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCirclePluginEnter.1
 * JD-Core Version:    0.7.0.1
 */