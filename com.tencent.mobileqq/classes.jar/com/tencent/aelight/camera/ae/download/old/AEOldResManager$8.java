package com.tencent.aelight.camera.ae.download.old;

import com.tencent.aelight.camera.download.old.api.AEOldResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.INet_ShortVideoResource;
import java.util.List;
import java.util.Map;

class AEOldResManager$8
  implements Runnable
{
  AEOldResManager$8(AEOldResManager paramAEOldResManager, AEOldResInfo paramAEOldResInfo, List paramList, AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[startPreDownLoad], preDownloadTask.run(), aeResInfo=");
    localStringBuilder.append(this.a);
    AEQLog.b("AEOldResManager", localStringBuilder.toString());
    AEOldResManager.a(this.this$0).put(this.a, Integer.valueOf(3));
    AEOldResManager.b(this.this$0).put(this.a, Long.valueOf(System.currentTimeMillis()));
    AEOldResDownload.a(this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.old.AEOldResManager.8
 * JD-Core Version:    0.7.0.1
 */