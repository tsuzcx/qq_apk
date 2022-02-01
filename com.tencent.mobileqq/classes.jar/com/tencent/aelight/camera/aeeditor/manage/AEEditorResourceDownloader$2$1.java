package com.tencent.aelight.camera.aeeditor.manage;

import com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.concurrent.CountDownLatch;

class AEEditorResourceDownloader$2$1
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  AEEditorResourceDownloader$2$1(AEEditorResourceDownloader.2 param2, int paramInt, AEEditorDownloadResBean paramAEEditorDownloadResBean, CountDownLatch paramCountDownLatch) {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    String str = this.d.this$0.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preDownloadAllRes---[finish] ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", id=");
    localStringBuilder.append(this.b.getId());
    AEQLog.b(str, localStringBuilder.toString());
    this.c.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.2.1
 * JD-Core Version:    0.7.0.1
 */