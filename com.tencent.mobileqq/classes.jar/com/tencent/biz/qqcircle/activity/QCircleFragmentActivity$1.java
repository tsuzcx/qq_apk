package com.tencent.biz.qqcircle.activity;

import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.qphone.base.util.QLog;

class QCircleFragmentActivity$1
  implements Runnable
{
  QCircleFragmentActivity$1(QCircleFragmentActivity paramQCircleFragmentActivity) {}
  
  public void run()
  {
    if (!QCirclePluginGlobalInfo.b(Integer.valueOf(this.this$0.hashCode())).booleanValue())
    {
      QLog.d("QCircleFragmentActivity", 1, "finish activity from init check runnable");
      if ((!this.this$0.isFinishing()) && (ASInject.g().getAsEngineDelegate() != null))
      {
        if (QCircleFragmentActivity.a(this.this$0)) {
          return;
        }
        QCircleFragmentActivity.b(this.this$0);
        this.this$0.finish();
        return;
      }
      return;
    }
    QLog.d("QCircleFragmentActivity", 1, "startActivityCheck for activity init success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.activity.QCircleFragmentActivity.1
 * JD-Core Version:    0.7.0.1
 */