package com.tencent.avgame.gameresult;

import com.tencent.common.app.business.BaseQQAppInterface;

class GameResultUploadMgrForRemote$2
  implements Runnable
{
  GameResultUploadMgrForRemote$2(GameResultUploadMgrForRemote paramGameResultUploadMgrForRemote, String paramString1, GameResultUploadMgrForRemote.UploadInfo paramUploadInfo, BaseQQAppInterface paramBaseQQAppInterface, String paramString2) {}
  
  public void run()
  {
    String str = this.a;
    if (str == null) {
      return;
    }
    this.b.c = true;
    GameResultUploadMgrForRemote.a(this.this$0, this.c, this.d, 0, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultUploadMgrForRemote.2
 * JD-Core Version:    0.7.0.1
 */