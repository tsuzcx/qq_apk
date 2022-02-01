package com.tencent.biz.qcircleshadow.local;

import android.content.Context;
import com.tencent.biz.qcircleshadow.lib.QCircleInitInject;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitBean;
import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import vvh;
import vvi;
import vvj;
import vvq;
import vwj;

public final class QCirclePluginEnter$2
  implements Runnable
{
  public QCirclePluginEnter$2(ILoadPluginDelegate paramILoadPluginDelegate, Context paramContext) {}
  
  public void run()
  {
    if (QzoneConfig.isQCirclePluginDisable())
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "preloadQCirclePlugin():WNS disable");
      return;
    }
    QCircleInitInject.g().injectPluginCallback(this.jdField_a_of_type_ComTencentBizQcircleshadowLibDelegateILoadPluginDelegate);
    vvq.a();
    Object localObject = vwj.a().a(true);
    if (localObject != null)
    {
      vvj.a().a((QCirclePluginInfo)localObject);
      QLog.i("QCIRCLE_PLUGIN", 1, "preloadQCirclePlugin():get net plugin success" + ((QCirclePluginInfo)localObject).version);
    }
    localObject = vvq.a().a();
    if ((localObject == null) || (((vvi)localObject).a() == null))
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "preloadQCirclePlugin():failed because no plugin info");
      return;
    }
    QCirclePluginInitBean localQCirclePluginInitBean = new QCirclePluginInitBean();
    localQCirclePluginInitBean.setStartTime(System.currentTimeMillis());
    localQCirclePluginInitBean.setLoadAction(1000);
    vvh.a(this.jdField_a_of_type_AndroidContentContext, (vvi)localObject, 1000, localQCirclePluginInitBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCirclePluginEnter.2
 * JD-Core Version:    0.7.0.1
 */