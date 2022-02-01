package com.tencent.aelight.camera.aeeditor.manage;

import com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

class AEEditorResourceDownloader$2
  implements Runnable
{
  AEEditorResourceDownloader$2(AEEditorResourceDownloader paramAEEditorResourceDownloader) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    AEQLog.b(this.this$0.d, "preDownloadAllRes---BEGIN");
    this.this$0.b();
    AEQLog.b(this.this$0.d, "preDownloadAllRes---ensureSetupDownloadConfig finish");
    Object localObject1 = new ArrayList();
    this.this$0.a((List)localObject1);
    Object localObject2 = this.this$0.e.values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (AEEditorDownloadResBean)((Iterator)localObject2).next();
      if ((localObject3 != null) && (((AEEditorDownloadResBean)localObject3).getPreDownload() == 1) && (!this.this$0.b((AEEditorDownloadResBean)localObject3))) {
        ((List)localObject1).add(localObject3);
      }
    }
    this.this$0.b((List)localObject1);
    localObject2 = this.this$0.d;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("preDownloadAllRes---needDownloads size=");
    ((StringBuilder)localObject3).append(((List)localObject1).size());
    AEQLog.b((String)localObject2, ((StringBuilder)localObject3).toString());
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      int k = Math.min(this.this$0.c, ((List)localObject1).size() - i);
      localObject2 = new CountDownLatch(k);
      int j = 0;
      while (j < k)
      {
        localObject3 = (AEEditorDownloadResBean)((List)localObject1).get(i);
        String str = this.this$0.d;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("preDownloadAllRes---[begin] ");
        localStringBuilder2.append(i);
        localStringBuilder2.append(", id=");
        localStringBuilder2.append(((AEEditorDownloadResBean)localObject3).getId());
        AEQLog.b(str, localStringBuilder2.toString());
        this.this$0.a((AEEditorDownloadResBean)localObject3, new AEEditorResourceDownloader.2.1(this, i, (AEEditorDownloadResBean)localObject3, (CountDownLatch)localObject2));
        j += 1;
        i += 1;
      }
      try
      {
        ((CountDownLatch)localObject2).await();
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      AEQLog.b(this.this$0.d, "preDownloadAllRes--------------------finish a little group---------------------");
    }
    long l2 = System.currentTimeMillis();
    localObject1 = this.this$0.d;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("preDownloadAllRes---END cost=");
    localStringBuilder1.append(l2 - l1);
    AEQLog.b((String)localObject1, localStringBuilder1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.2
 * JD-Core Version:    0.7.0.1
 */