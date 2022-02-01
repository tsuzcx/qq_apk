package com.tencent.mobileqq.app.qqdaily;

import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xe27.oidb_cmd0xe27.RspBody;

class FrontBackReportManager$1
  implements QQDailyHandler.OnReceiveListener
{
  FrontBackReportManager$1(FrontBackReportManager paramFrontBackReportManager) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_cmd0xe27.RspBody paramRspBody)
  {
    long l = paramRspBody.uint32_test_keep_silence_sec.get();
    paramToServiceMsg = this.a;
    boolean bool;
    if (l <= 0L) {
      bool = true;
    } else {
      bool = false;
    }
    FrontBackReportManager.a(paramToServiceMsg, bool);
    if (l > 0L)
    {
      FrontBackReportManager.a(this.a).removeMessages(6);
      FrontBackReportManager.a(this.a).sendEmptyMessageDelayed(6, l);
      if (QLog.isColorLevel()) {
        QLog.d("FrontBackReportManager", 2, "receive keep silence");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.FrontBackReportManager.1
 * JD-Core Version:    0.7.0.1
 */