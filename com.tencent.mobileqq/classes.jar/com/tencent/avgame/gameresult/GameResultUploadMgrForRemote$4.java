package com.tencent.avgame.gameresult;

import com.tencent.mobileqq.utils.FileUtils;

class GameResultUploadMgrForRemote$4
  implements Runnable
{
  GameResultUploadMgrForRemote$4(GameResultUploadMgrForRemote paramGameResultUploadMgrForRemote, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = this.a;
    if (str != null) {
      FileUtils.deleteFile(str);
    }
    str = this.b;
    if (str != null) {
      FileUtils.deleteFile(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultUploadMgrForRemote.4
 * JD-Core Version:    0.7.0.1
 */