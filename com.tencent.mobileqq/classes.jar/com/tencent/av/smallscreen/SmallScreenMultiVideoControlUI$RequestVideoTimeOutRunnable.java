package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.tips.TipsUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class SmallScreenMultiVideoControlUI$RequestVideoTimeOutRunnable
  implements Runnable
{
  SmallScreenMultiVideoControlUI$RequestVideoTimeOutRunnable(SmallScreenMultiVideoControlUI paramSmallScreenMultiVideoControlUI) {}
  
  public void run()
  {
    if (this.this$0.z != null)
    {
      this.this$0.z.f("Small_RequestVideoTimeOutRunnable");
      TipsUtil.b(this.this$0.y, 1036);
      TipsUtil.b(this.this$0.y, 1037);
      TipsUtil.a(this.this$0.y, 1030, 2131893640);
      this.this$0.z.k().b(this.this$0.f, true, true);
      this.this$0.a(true, false, true);
      if (this.this$0.d == 2) {
        ReportController.b(null, "CliOper", "", "", "0X8004425", "0X8004425", 0, 0, "", "", "", "");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("SmallScreenMultiVideoControlUI", 2, "RequestVideoTimeOutRunnable, mVideoController = null!!!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI.RequestVideoTimeOutRunnable
 * JD-Core Version:    0.7.0.1
 */