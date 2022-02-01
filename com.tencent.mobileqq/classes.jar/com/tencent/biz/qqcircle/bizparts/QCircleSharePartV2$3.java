package com.tencent.biz.qqcircle.bizparts;

import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qphone.base.util.QLog;

class QCircleSharePartV2$3
  implements Runnable
{
  QCircleSharePartV2$3(QCircleSharePartV2 paramQCircleSharePartV2) {}
  
  public void run()
  {
    HostUIHelper.closeHostEnvironment();
    QCircleSharePartV2.a(this.this$0, null);
    QLog.d("RHF-QCircleSharePart", 1, "delayedCloseHostEnvironment");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2.3
 * JD-Core Version:    0.7.0.1
 */