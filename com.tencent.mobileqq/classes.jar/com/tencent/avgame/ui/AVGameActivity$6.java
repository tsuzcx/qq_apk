package com.tencent.avgame.ui;

import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.avgame.report.exception.AVGameExceptionReporter;
import com.tencent.qphone.base.util.QLog;

class AVGameActivity$6
  implements Runnable
{
  AVGameActivity$6(AVGameActivity paramAVGameActivity, int paramInt) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoom run mGameExited:");
    localStringBuilder.append(AVGameActivity.access$300(this.this$0));
    localStringBuilder.append(" retCode:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" mRoomId:");
    localStringBuilder.append(AVGameActivity.access$000(this.this$0));
    QLog.i("AVGameActivity", 1, localStringBuilder.toString());
    if (AVGameActivity.access$300(this.this$0)) {
      return;
    }
    int i = this.a;
    if (i == 0)
    {
      if ((!TextUtils.isEmpty(AVGameActivity.access$000(this.this$0))) && (AVGameActivity.access$400(this.this$0) != null)) {
        AVGameActivity.access$400(this.this$0).a().b(1, AVGameActivity.access$000(this.this$0));
      }
    }
    else if (i != 5)
    {
      if (i == 6) {
        return;
      }
      if ((GameEngine.a().D()) && (GameEngine.a().B())) {
        AVGameExceptionReporter.a().a(8, null, String.valueOf(this.a), null);
      }
      AVGameActivity.access$100(this.this$0, 2, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameActivity.6
 * JD-Core Version:    0.7.0.1
 */