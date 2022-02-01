package com.tencent.avgame.ui;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.report.AVGameNodeReportUtil;
import com.tencent.avgame.report.AVGamePerfReporter;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.qphone.base.util.QLog;

class AVGameActivity$3
  implements Runnable
{
  AVGameActivity$3(AVGameActivity paramAVGameActivity) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(AVGameActivity.access$000(this.this$0))) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mEnterAvRoomRunnable begin isFinishing:");
    ((StringBuilder)localObject).append(this.this$0.isFinishing());
    ((StringBuilder)localObject).append(" mRoomId:");
    ((StringBuilder)localObject).append(AVGameActivity.access$000(this.this$0));
    QLog.i("AVGameActivity", 1, ((StringBuilder)localObject).toString());
    localObject = AVGameSession.a(11, Long.valueOf(AVGameActivity.access$000(this.this$0)).longValue());
    AVGameSession localAVGameSession = AVGameBusinessCtrl.b().j();
    int i = 0;
    if ((localAVGameSession != null) && (localAVGameSession.b.equalsIgnoreCase((String)localObject)))
    {
      if (localAVGameSession.c() == 2)
      {
        this.this$0.onEnterRoom(5);
        break label167;
      }
      if (localAVGameSession.c() == 1)
      {
        this.this$0.onEnterRoom(6);
        break label167;
      }
    }
    i = 1;
    label167:
    if (i == 0) {
      return;
    }
    if (localAVGameSession != null)
    {
      l = System.currentTimeMillis();
      AVGamePerfReporter.a().a(0, GameEngine.a().s().i(), GameEngine.a().s().n(), 0L);
      AVGameHandler.a().b().post(new AVGameActivity.3.1(this, l));
      if (QLog.isColorLevel()) {
        QLog.d("AVGameActivity", 2, "mEnterAvRoomRunnable exit old session");
      }
    }
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(AVGameActivity.access$000(this.this$0)))
    {
      AVGameActivity.access$100(this.this$0, 1, 1);
      return;
    }
    if ((AVGameActivity.access$200(this.this$0) != null) && (AVGameActivity.access$200(this.this$0).length != 0))
    {
      AVGameNodeReportUtil.b();
      if ((GameEngine.a().A()) && (GameEngine.a().D())) {
        i = 4;
      } else {
        i = 2;
      }
      i = AVGameBusinessCtrl.b().a(AVGameActivity.access$000(this.this$0), AVGameActivity.access$200(this.this$0), 1, i, this.this$0);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mEnterAvRoomRunnable enterRoom coast ");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
        ((StringBuilder)localObject).append(" retCode=");
        ((StringBuilder)localObject).append(i);
        QLog.d("AVGameActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (i != 0)
      {
        AVGameActivity.access$100(this.this$0, 2, i);
        return;
      }
      if (AVGameBusinessCtrl.b().j() == null)
      {
        AVGameActivity.access$100(this.this$0, 3, 1);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mEnterAvRoomRunnable end isFinishing:");
      ((StringBuilder)localObject).append(this.this$0.isFinishing());
      QLog.i("AVGameActivity", 1, ((StringBuilder)localObject).toString());
      return;
    }
    AVGameActivity.access$100(this.this$0, 1, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameActivity.3
 * JD-Core Version:    0.7.0.1
 */