package com.tencent.avgame.gameresult;

import com.tencent.mobileqq.utils.FileUtils;
import nho;

public class GameResultUploadMgrForRemote$4
  implements Runnable
{
  public GameResultUploadMgrForRemote$4(nho paramnho, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.a != null) {
      FileUtils.deleteFile(this.a);
    }
    if (this.b != null) {
      FileUtils.deleteFile(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultUploadMgrForRemote.4
 * JD-Core Version:    0.7.0.1
 */