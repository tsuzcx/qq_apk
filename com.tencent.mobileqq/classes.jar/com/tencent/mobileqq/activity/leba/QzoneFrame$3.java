package com.tencent.mobileqq.activity.leba;

import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.QZoneHelper;

class QzoneFrame$3
  implements Runnable
{
  QzoneFrame$3(QzoneFrame paramQzoneFrame) {}
  
  public void run()
  {
    QZoneHelper.preloadQzone((QQAppInterface)this.this$0.a, "Leba");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.QzoneFrame.3
 * JD-Core Version:    0.7.0.1
 */