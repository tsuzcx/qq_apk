package com.tencent.mobileqq.applets;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

final class PublicAccountEventReport$8
  implements Runnable
{
  PublicAccountEventReport$8(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = this.a;
    String str = this.b;
    int i = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append("");
    ReportController.b(localQQAppInterface, "dc00898", "", str, "0X8009EB7", "0X8009EB7", i, 0, "", "", localStringBuilder.toString(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.8
 * JD-Core Version:    0.7.0.1
 */