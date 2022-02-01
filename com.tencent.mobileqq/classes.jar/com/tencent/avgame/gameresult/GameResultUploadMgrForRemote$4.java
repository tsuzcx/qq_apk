package com.tencent.avgame.gameresult;

import com.tencent.mobileqq.utils.FileUtils;

class GameResultUploadMgrForRemote$4
  implements Runnable
{
  GameResultUploadMgrForRemote$4(GameResultUploadMgrForRemote paramGameResultUploadMgrForRemote, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.a != null) {
      FileUtils.e(this.a);
    }
    if (this.b != null) {
      FileUtils.e(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultUploadMgrForRemote.4
 * JD-Core Version:    0.7.0.1
 */