package com.tencent.avgame.ui;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.avgame.util.AVGamePerfReporter;
import com.tencent.qphone.base.util.QLog;

class AVGameActivity$3
  implements Runnable
{
  AVGameActivity$3(AVGameActivity paramAVGameActivity) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(AVGameActivity.a(this.this$0))) {}
    for (;;)
    {
      return;
      QLog.i("AVGameActivity", 1, "mEnterAvRoomRunnable begin isFinishing:" + this.this$0.isFinishing() + " mRoomId:" + AVGameActivity.a(this.this$0));
      String str = AVGameSession.a(11, Long.valueOf(AVGameActivity.a(this.this$0)).longValue());
      AVGameSession localAVGameSession = AVGameBusinessCtrl.b().a();
      int i;
      if ((localAVGameSession != null) && (localAVGameSession.a.equalsIgnoreCase(str))) {
        if (localAVGameSession.a() == 2)
        {
          this.this$0.a(5);
          i = 0;
        }
      }
      while (i != 0)
      {
        if (localAVGameSession != null)
        {
          l = System.currentTimeMillis();
          AVGamePerfReporter.a().a(0, GameEngine.a().a().a(), GameEngine.a().a().b(), 0L);
          AVGameHandler.a().a().post(new AVGameActivity.3.1(this, l));
          if (QLog.isColorLevel()) {
            QLog.d("AVGameActivity", 2, "mEnterAvRoomRunnable exit old session");
          }
        }
        long l = System.currentTimeMillis();
        if (TextUtils.isEmpty(AVGameActivity.a(this.this$0)))
        {
          AVGameActivity.a(this.this$0, 1, 1);
          return;
          if (localAVGameSession.a() == 1)
          {
            this.this$0.a(6);
            i = 0;
          }
        }
        else
        {
          if ((AVGameActivity.a(this.this$0) == null) || (AVGameActivity.a(this.this$0).length == 0))
          {
            AVGameActivity.a(this.this$0, 1, 2);
            return;
          }
          AVGameNodeReportUtil.b();
          if ((GameEngine.a().f()) && (GameEngine.a().i())) {}
          for (i = 4;; i = 2)
          {
            i = AVGameBusinessCtrl.b().a(AVGameActivity.a(this.this$0), AVGameActivity.a(this.this$0), 1, i, this.this$0);
            if (QLog.isColorLevel()) {
              QLog.d("AVGameActivity", 2, "mEnterAvRoomRunnable enterRoom coast " + (System.currentTimeMillis() - l) + " retCode=" + i);
            }
            if (i == 0) {
              break;
            }
            AVGameActivity.a(this.this$0, 2, i);
            return;
          }
          if (AVGameBusinessCtrl.b().a() == null)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameActivity.3
 * JD-Core Version:    0.7.0.1
 */