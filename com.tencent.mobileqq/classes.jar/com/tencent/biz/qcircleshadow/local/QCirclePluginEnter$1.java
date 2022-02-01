package com.tencent.biz.qcircleshadow.local;

import android.content.Context;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitBean;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginTrace;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enterQCirclePlugin():wait for thread cost:");
    ((StringBuilder)localObject).append(l - this.val$bean.getStartTime());
    QLog.i("QCIRCLE_PLUGIN", 1, ((StringBuilder)localObject).toString());
    if (QCircleConfig.isQCirclePluginDisable())
    {
      QLog.i("QCIRCLE_PLUGIN", 1, "enterQCirclePlugin():QCircle plugin disable");
      return;
    }
    localObject = new QCirclePluginTrace();
    this.val$bean.setTrace((QCirclePluginTrace)localObject);
    ((QCirclePluginTrace)localObject).traceStart("qcircle_init_info");
    QCirclePluginEnterManger localQCirclePluginEnterManger = QCircleShadow.a().a();
    ((QCirclePluginTrace)localObject).traceEnd("qcircle_init_info");
    if ((localQCirclePluginEnterManger != null) && (localQCirclePluginEnterManger.getPluginInfo() != null))
    {
      QCirclePluginEnter.access$000(this.val$context, localQCirclePluginEnterManger, this.val$bean.getLoadAction(), this.val$bean);
      QCirclePluginEnter.access$100(localQCirclePluginEnterManger.getPluginInfo().b());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterQCirclePlugin(): load cost:");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.i("QCIRCLE_PLUGIN", 1, ((StringBuilder)localObject).toString());
      return;
    }
    QLog.i("QCIRCLE_PLUGIN", 1, "enterQCirclePlugin():failed because no plugin info");
    ILoadPluginDelegate.disPatchCallback(6, "no plugin info");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCirclePluginEnter.1
 * JD-Core Version:    0.7.0.1
 */