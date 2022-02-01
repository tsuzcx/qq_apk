package com.tencent.biz.qcircleshadow.local;

import android.content.Context;
import com.tencent.biz.qcircleshadow.lib.QCircleInitInject;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitBean;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginTrace;
import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.QCircleConfig;

final class QCirclePluginEnter$2
  implements Runnable
{
  QCirclePluginEnter$2(ILoadPluginDelegate paramILoadPluginDelegate, Context paramContext) {}
  
  public void run()
  {
    if (QCircleConfig.isQCirclePluginDisable())
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "preloadQCirclePlugin():WNS disable");
      return;
    }
    QCirclePluginTrace localQCirclePluginTrace = new QCirclePluginTrace();
    localQCirclePluginTrace.traceStart("qcircle_init_info");
    QCircleInitInject.g().injectPluginCallback(this.val$callback);
    QCirclePluginEnterManger localQCirclePluginEnterManger = QCircleShadow.a().a();
    localQCirclePluginTrace.traceEnd("qcircle_init_info");
    if ((localQCirclePluginEnterManger != null) && (localQCirclePluginEnterManger.getPluginInfo() != null))
    {
      QCirclePluginInitBean localQCirclePluginInitBean = new QCirclePluginInitBean();
      localQCirclePluginInitBean.setStartTime(System.currentTimeMillis());
      localQCirclePluginInitBean.setLoadAction(1000);
      localQCirclePluginInitBean.setTrace(localQCirclePluginTrace);
      QCirclePluginEnter.access$000(this.val$context, localQCirclePluginEnterManger, localQCirclePluginInitBean.getLoadAction(), localQCirclePluginInitBean);
      return;
    }
    QLog.i("QCIRCLE_PLUGIN", 1, "preloadQCirclePlugin():failed because no plugin info");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCirclePluginEnter.2
 * JD-Core Version:    0.7.0.1
 */