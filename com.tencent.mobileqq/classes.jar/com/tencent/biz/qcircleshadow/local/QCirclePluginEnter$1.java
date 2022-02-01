package com.tencent.biz.qcircleshadow.local;

import android.content.Context;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitBean;
import com.tencent.biz.qcircleshadow.lib.delegate.ILoadPluginDelegate;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.QCircleConfig;

final class QCirclePluginEnter$1
  implements Runnable
{
  QCirclePluginEnter$1(QCirclePluginInitBean paramQCirclePluginInitBean, Context paramContext) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    QLog.i("QCIRCLE_PLUGIN", 1, "enterQCirclePlugin():wait for thread cost:" + (l - this.val$bean.getStartTime()));
    if (QCircleConfig.isQCirclePluginDisable())
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "enterQCirclePlugin():QCircle plugin disable");
      return;
    }
    QCircleShadow.a();
    QCirclePluginEnterManger localQCirclePluginEnterManger = QCircleShadow.a().a();
    if ((localQCirclePluginEnterManger == null) || (localQCirclePluginEnterManger.getPluginInfo() == null))
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "enterQCirclePlugin():failed because no plugin info");
      ILoadPluginDelegate.disPatchCallback(6, "no plugin info");
      return;
    }
    QCirclePluginEnter.access$000(this.val$context, localQCirclePluginEnterManger, this.val$bean.getLoadAction(), this.val$bean);
    QLog.i("QCIRCLE_PLUGIN", 1, "enterQCirclePlugin(): load cost:" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCirclePluginEnter.1
 * JD-Core Version:    0.7.0.1
 */