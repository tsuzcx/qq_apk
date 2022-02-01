package com.tencent.avgame.ui;

import android.text.TextUtils;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameSession.SessionStatus;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.qphone.base.util.QLog;
import ndt;

class AVGameActivity$3
  implements Runnable
{
  AVGameActivity$3(AVGameActivity paramAVGameActivity) {}
  
  public void run()
  {
    int i = 0;
    QLog.i("AVGameActivity", 1, "mEnterAvRoomRunnable begin isFinishing:" + this.this$0.isFinishing() + " mRoomId:" + AVGameActivity.a(this.this$0));
    String str = AVGameSession.a(11, Long.valueOf(AVGameActivity.a(this.this$0)).longValue());
    AVGameSession localAVGameSession = ndt.b().a();
    if ((localAVGameSession != null) && (localAVGameSession.a.equalsIgnoreCase(str))) {
      if (localAVGameSession.a() == AVGameSession.SessionStatus.ENTERED) {
        this.this$0.a(5);
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return;
        if (localAVGameSession.a() == AVGameSession.SessionStatus.ENTERING) {
          this.this$0.a(6);
        }
      }
      else
      {
        if (localAVGameSession != null)
        {
          ndt.b().e();
          if (QLog.isColorLevel()) {
            QLog.d("AVGameActivity", 2, "mEnterAvRoomRunnable exit old session");
          }
        }
        long l = System.currentTimeMillis();
        if (TextUtils.isEmpty(AVGameActivity.a(this.this$0)))
        {
          AVGameActivity.a(this.this$0, 1, 1);
          return;
        }
        if ((AVGameActivity.a(this.this$0) == null) || (AVGameActivity.a(this.this$0).length == 0))
        {
          AVGameActivity.a(this.this$0, 1, 2);
          return;
        }
        AVGameNodeReportUtil.b();
        i = ndt.b().a(AVGameActivity.a(this.this$0), AVGameActivity.a(this.this$0), 1, this.this$0);
        if (QLog.isColorLevel()) {
          QLog.d("AVGameActivity", 2, "mEnterAvRoomRunnable enterRoom coast " + (System.currentTimeMillis() - l) + " retCode=" + i);
        }
        if (i != 0)
        {
          AVGameActivity.a(this.this$0, 2, i);
          return;
        }
        if (ndt.b().a() == null)
        {
          AVGameActivity.a(this.this$0, 3, 1);
          return;
        }
        QLog.i("AVGameActivity", 1, "mEnterAvRoomRunnable end isFinishing:" + this.this$0.isFinishing());
        return;
      }
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameActivity.3
 * JD-Core Version:    0.7.0.1
 */