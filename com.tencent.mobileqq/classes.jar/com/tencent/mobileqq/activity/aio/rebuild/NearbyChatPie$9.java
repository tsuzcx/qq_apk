package com.tencent.mobileqq.activity.aio.rebuild;

import aidd;
import bdla;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class NearbyChatPie$9
  implements Runnable
{
  public NearbyChatPie$9(aidd paramaidd, String paramString) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.this$0.tag, 4, "0X80052C5, " + this.a);
    }
    bdla.b(this.this$0.app, "CliOper", "", "", "0X80052C5", "0X80052C5", 0, 0, this.this$0.sessionInfo.curFriendUin, "", this.a, "");
    QQAppInterface localQQAppInterface = this.this$0.app;
    if (this.this$0.sessionInfo.curType == 1001) {}
    for (String str = "0";; str = "1")
    {
      bdla.b(localQQAppInterface, "dc00899", "grp_lbs", "", "tmp_grey", "clk_send", 0, 0, str, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.9
 * JD-Core Version:    0.7.0.1
 */