package com.tencent.biz.qqstory.base.preload;

import android.annotation.TargetApi;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

@TargetApi(14)
public class PreloadDownloaderManager$OnQueueStateChangeListener
  implements PreloadDownloaderManager.IOnQueueStateChangeListener
{
  public PreloadDownloaderManager$OnQueueStateChangeListener(PreloadDownloaderManager paramPreloadDownloaderManager) {}
  
  public void a(int paramInt)
  {
    int i = paramInt + 1;
    if (i < this.a.a.size())
    {
      PreloadQueue localPreloadQueue = (PreloadQueue)this.a.a.get(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queue ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" download completed , turn to ");
      localStringBuilder.append(localPreloadQueue.getId());
      SLog.b("Q.qqstory.download.preload.PreloadDownloaderManager", localStringBuilder.toString());
      this.a.b.a(localPreloadQueue);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager.OnQueueStateChangeListener
 * JD-Core Version:    0.7.0.1
 */