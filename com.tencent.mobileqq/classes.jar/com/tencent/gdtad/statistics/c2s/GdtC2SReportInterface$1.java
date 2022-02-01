package com.tencent.gdtad.statistics.c2s;

import com.tencent.mobileqq.statistics.ReportController;

class GdtC2SReportInterface$1
  implements Runnable
{
  GdtC2SReportInterface$1(GdtC2SReportInterface paramGdtC2SReportInterface) {}
  
  public void run()
  {
    ReportController.a(null, "dc00898", "", "", "0X8009EBE", "0X8009EBE", this.this$0.a, 0, "", "", GdtC2SReportInterface.a(this.this$0), "");
    int i = this.this$0.a;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        localGdtC2SReportInterface = this.this$0;
        GdtC2SReportInterface.a(localGdtC2SReportInterface, GdtC2SReportInterface.d(localGdtC2SReportInterface));
        return;
      }
      localGdtC2SReportInterface = this.this$0;
      GdtC2SReportInterface.a(localGdtC2SReportInterface, GdtC2SReportInterface.c(localGdtC2SReportInterface));
      return;
    }
    GdtC2SReportInterface localGdtC2SReportInterface = this.this$0;
    GdtC2SReportInterface.a(localGdtC2SReportInterface, GdtC2SReportInterface.b(localGdtC2SReportInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.statistics.c2s.GdtC2SReportInterface.1
 * JD-Core Version:    0.7.0.1
 */