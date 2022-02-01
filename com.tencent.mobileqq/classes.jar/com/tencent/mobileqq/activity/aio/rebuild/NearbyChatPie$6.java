package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class NearbyChatPie$6
  implements Runnable
{
  NearbyChatPie$6(NearbyChatPie paramNearbyChatPie, String paramString) {}
  
  public void run()
  {
    String str;
    if (QLog.isDevelopLevel())
    {
      str = this.this$0.c;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0X80052C5, ");
      ((StringBuilder)localObject).append(this.a);
      QLog.i(str, 4, ((StringBuilder)localObject).toString());
    }
    ReportController.b(this.this$0.d, "CliOper", "", "", "0X80052C5", "0X80052C5", 0, 0, this.this$0.ah.b, "", this.a, "");
    Object localObject = this.this$0.d;
    if (this.this$0.ah.a == 1001) {
      str = "0";
    } else {
      str = "1";
    }
    ReportController.b((AppRuntime)localObject, "dc00899", "grp_lbs", "", "tmp_grey", "clk_send", 0, 0, str, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.6
 * JD-Core Version:    0.7.0.1
 */