package com.tencent.av.ui;

import android.app.Activity;
import com.tencent.mobileqq.qrscan.IToolProcStart.Callback;
import com.tencent.qphone.base.util.QLog;

class QavSharpnessSVIPHelper$2
  implements IToolProcStart.Callback
{
  QavSharpnessSVIPHelper$2(QavSharpnessSVIPHelper paramQavSharpnessSVIPHelper, Activity paramActivity, long paramLong) {}
  
  public void a()
  {
    this.c.b(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchQQPayFunction time end: ");
    localStringBuilder.append(System.currentTimeMillis() - this.b);
    QLog.d("QavSharpnessSVIPHelper", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavSharpnessSVIPHelper.2
 * JD-Core Version:    0.7.0.1
 */