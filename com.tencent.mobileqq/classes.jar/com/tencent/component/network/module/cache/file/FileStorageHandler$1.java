package com.tencent.component.network.module.cache.file;

import android.content.Context;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.util.Collection;
import java.util.Iterator;

class FileStorageHandler$1
  implements ThreadPool.Job<Object>
{
  FileStorageHandler$1(FileStorageHandler paramFileStorageHandler, boolean paramBoolean, Context paramContext) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = FileStorageHandler.access$000(this.this$0).collect();
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      int i = 0;
      int j = 0;
      while (paramJobContext.hasNext())
      {
        FileCacheService localFileCacheService = (FileCacheService)paramJobContext.next();
        int k = localFileCacheService.getCapacity(this.val$externalStorage);
        int m = localFileCacheService.getSize(this.val$externalStorage);
        int n = FileStorageHandler.access$100(this.this$0, k, m);
        localFileCacheService.clear(this.val$externalStorage, n);
        if (QDLog.isInfoEnable())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("clear cache service:");
          localStringBuilder.append(localFileCacheService);
          localStringBuilder.append(": remain=");
          localStringBuilder.append(n);
          QDLog.i("downloader", localStringBuilder.toString());
        }
        j += m;
        i += k;
      }
      float f;
      if (i <= 0) {
        f = 3.4028235E+38F;
      } else {
        f = j / i;
      }
      if (f < 0.1F) {
        FileStorageHandler.access$200(this.this$0, this.val$context);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.cache.file.FileStorageHandler.1
 * JD-Core Version:    0.7.0.1
 */