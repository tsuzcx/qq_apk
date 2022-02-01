package com.tencent.biz.troop.feeds;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class TroopNewGuidePopWindow$10
  extends Handler
{
  TroopNewGuidePopWindow$10(TroopNewGuidePopWindow paramTroopNewGuidePopWindow) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1001) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("MSG_SHOW_WINDOW mTroopNotify = ");
      paramMessage.append(this.a.B);
      paramMessage.append(", mTroopNotifyAd = ");
      paramMessage.append(this.a.C);
      QLog.d("TroopTipsPopWindow", 2, paramMessage.toString());
    }
    if (this.a.C != null)
    {
      paramMessage = this.a;
      paramMessage.a(paramMessage.C);
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow.10
 * JD-Core Version:    0.7.0.1
 */