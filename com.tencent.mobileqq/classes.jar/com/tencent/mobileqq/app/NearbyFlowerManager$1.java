package com.tencent.mobileqq.app;

import com.tencent.mobileqq.statistics.ReportController;

final class NearbyFlowerManager$1
  implements Runnable
{
  NearbyFlowerManager$1(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface == null) {
      return;
    }
    String str = this.b;
    ReportController.b(localQQAppInterface, "CliOper", "", "", str, str, 0, 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyFlowerManager.1
 * JD-Core Version:    0.7.0.1
 */