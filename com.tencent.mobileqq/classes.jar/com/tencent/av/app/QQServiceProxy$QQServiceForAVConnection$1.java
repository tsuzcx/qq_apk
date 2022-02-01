package com.tencent.av.app;

import android.os.IBinder.DeathRecipient;
import com.tencent.av.AVLog;

class QQServiceProxy$QQServiceForAVConnection$1
  implements IBinder.DeathRecipient
{
  QQServiceProxy$QQServiceForAVConnection$1(QQServiceProxy.QQServiceForAVConnection paramQQServiceForAVConnection) {}
  
  public void binderDied()
  {
    AVLog.printAllUserLog("QQServiceProxy", "QQServiceForAV mobileQQ process exited!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.QQServiceProxy.QQServiceForAVConnection.1
 * JD-Core Version:    0.7.0.1
 */