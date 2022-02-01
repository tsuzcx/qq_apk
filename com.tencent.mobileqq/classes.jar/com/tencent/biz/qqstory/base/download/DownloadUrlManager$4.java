package com.tencent.biz.qqstory.base.download;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.LruCache;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.DownloadingUrlEntry;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

class DownloadUrlManager$4
  extends SimpleJob<Void>
{
  DownloadUrlManager$4(DownloadUrlManager paramDownloadUrlManager, String paramString1, String paramString2, int paramInt)
  {
    super(paramString1);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    try
    {
      DownloadUrlManager.a(this.c).lock();
      paramJobContext = DownloadingUrlEntry.makeKey(this.a, this.b);
      DownloadUrlManager.b(this.c).remove(paramJobContext);
      paramJobContext = QQStoryContext.a().d().createEntityManager();
      paramVarArgs = StoryManager.a(paramJobContext, DownloadingUrlEntry.class, DownloadingUrlEntry.class.getSimpleName(), "key=?", new String[] { DownloadingUrlEntry.makeKey(this.a, this.b) });
      if ((paramVarArgs != null) && (paramVarArgs.size() > 0))
      {
        paramVarArgs = (DownloadingUrlEntry)paramVarArgs.get(0);
        paramVarArgs.setStatus(1000);
        paramVarArgs.bIsDownloadCompleted = 1;
        paramJobContext.persistOrReplace(paramVarArgs);
      }
      return null;
    }
    finally
    {
      DownloadUrlManager.a(this.c).unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.download.DownloadUrlManager.4
 * JD-Core Version:    0.7.0.1
 */