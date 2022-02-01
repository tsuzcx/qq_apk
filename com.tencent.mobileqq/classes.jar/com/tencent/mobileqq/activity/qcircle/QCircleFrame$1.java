package com.tencent.mobileqq.activity.qcircle;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Handler;
import android.view.Window;
import com.tencent.mobileqq.qcircle.api.interfaces.QCircleHookPluginIntentCallBack;
import com.tencent.qphone.base.util.QLog;

class QCircleFrame$1
  implements QCircleHookPluginIntentCallBack
{
  QCircleFrame$1(QCircleFrame paramQCircleFrame) {}
  
  public void getPluginIntent(Intent paramIntent)
  {
    QCircleFrame localQCircleFrame = this.a;
    QCircleFrame.a(localQCircleFrame, QCircleFrame.a(localQCircleFrame).startActivity("QCircleTab", paramIntent).getDecorView());
    paramIntent = new StringBuilder();
    paramIntent.append("getPluginIntent : mQCircleTabView = ");
    paramIntent.append(QCircleFrame.a(this.a));
    QLog.d("QCircleFrame", 1, paramIntent.toString());
    QCircleFrame.a(this.a).post(new QCircleFrame.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleFrame.1
 * JD-Core Version:    0.7.0.1
 */