package com.tencent.aelight.camera.ae.download;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import java.util.List;
import java.util.Map;

class AEResManager$4
  implements Runnable
{
  AEResManager$4(AEResManager paramAEResManager, AEResInfo paramAEResInfo, List paramList, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[startPreDownLoad], preDownloadTask.run(), aeResInfo=");
    localStringBuilder.append(this.a);
    AEQLog.b("AEResManager", localStringBuilder.toString());
    AEResManager.a(this.this$0).put(this.a, Integer.valueOf(3));
    AEResManager.b(this.this$0).put(this.a, Long.valueOf(System.currentTimeMillis()));
    AEResDownload.a(this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.AEResManager.4
 * JD-Core Version:    0.7.0.1
 */