package com.tencent.mobileqq.applets;

import com.tencent.mobileqq.statistics.ReportController;

final class PublicAccountEventReport$12
  implements Runnable
{
  PublicAccountEventReport$12(String paramString, long paramLong) {}
  
  public void run()
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append("");
    ReportController.b(null, "dc00898", "", str, "0X800A306", "0X800A306", 0, 0, "", "", localStringBuilder.toString(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.12
 * JD-Core Version:    0.7.0.1
 */