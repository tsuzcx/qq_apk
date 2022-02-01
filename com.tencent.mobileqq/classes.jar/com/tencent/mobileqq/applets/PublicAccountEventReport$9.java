package com.tencent.mobileqq.applets;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

final class PublicAccountEventReport$9
  implements Runnable
{
  PublicAccountEventReport$9(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, long paramLong) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = this.a;
    String str = this.b;
    int i = this.c;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.d);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e);
    localStringBuilder.append("");
    ReportController.b(localQQAppInterface, "dc00898", "", str, "0X8009EB5", "0X8009EB5", i, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.9
 * JD-Core Version:    0.7.0.1
 */