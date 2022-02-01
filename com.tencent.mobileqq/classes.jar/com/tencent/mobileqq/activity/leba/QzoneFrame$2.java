package com.tencent.mobileqq.activity.leba;

import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.QZoneHelper;

class QzoneFrame$2
  implements Runnable
{
  QzoneFrame$2(QzoneFrame paramQzoneFrame) {}
  
  public void run()
  {
    QZoneHelper.preloadQzone((QQAppInterface)this.this$0.aF, "Leba");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.QzoneFrame.2
 * JD-Core Version:    0.7.0.1
 */