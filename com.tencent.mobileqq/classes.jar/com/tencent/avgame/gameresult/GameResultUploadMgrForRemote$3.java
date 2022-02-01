package com.tencent.avgame.gameresult;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.qphone.base.util.QLog;

class GameResultUploadMgrForRemote$3
  implements Runnable
{
  GameResultUploadMgrForRemote$3(GameResultUploadMgrForRemote paramGameResultUploadMgrForRemote, GameResultUploadMgrForRemote.UploadInfo paramUploadInfo, String paramString) {}
  
  public void run()
  {
    if (this.a.b == null) {
      return;
    }
    this.a.d = true;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(" upload video");
      QLog.i("GameResultUploadMgrForRemote_GameRC", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = GameResultUploadMgrForRemote.a(this.this$0);
    if (localObject != null) {
      GameResultUploadMgrForRemote.a(this.this$0, (BaseQQAppInterface)localObject, this.b, 1, this.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultUploadMgrForRemote.3
 * JD-Core Version:    0.7.0.1
 */