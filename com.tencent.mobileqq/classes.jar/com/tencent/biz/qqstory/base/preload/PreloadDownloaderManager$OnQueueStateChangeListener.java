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
    if (i < this.a.jdField_a_of_type_JavaUtilList.size())
    {
      PreloadQueue localPreloadQueue = (PreloadQueue)this.a.jdField_a_of_type_JavaUtilList.get(i);
      SLog.b("Q.qqstory.download.preload.PreloadDownloaderManager", "queue " + paramInt + " download completed , turn to " + localPreloadQueue.getId());
      this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPreloadDownloader.a(localPreloadQueue);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager.OnQueueStateChangeListener
 * JD-Core Version:    0.7.0.1
 */