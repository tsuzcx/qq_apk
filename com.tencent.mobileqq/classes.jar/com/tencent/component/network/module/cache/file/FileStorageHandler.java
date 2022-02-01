package com.tencent.component.network.module.cache.file;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import java.util.concurrent.atomic.AtomicInteger;

public class FileStorageHandler
  implements FileCacheService.StorageHandler
{
  private static final int COUNT_OF_HALF_INTERVAL = 6;
  private static final int MAX_WARN_INTERVAL = 1800000;
  private static final int MINUTE = 60000;
  private static final float STORAGE_EXIST_PERCENTAGE_OFFSET = 0.02F;
  private static final int STORAGE_OP_INTERVAL = 2;
  private static final float STORAGE_REMAIN_PERCENTAGE = 0.1F;
  private static final float STORAGE_REMAIN_PERCENTAGE_EXTREME = 0.05F;
  private static final float STORAGE_WARNING_PERCENTAGE = 0.1F;
  private static final Handler sMainHandler = new Handler(Looper.getMainLooper());
  private final FileStorageHandler.Collector mCollector;
  private final AtomicInteger mCounter = new AtomicInteger(0);
  private long mLastWarnTime;
  private Future mPendingFuture;
  private int mWarnCount;
  
  public FileStorageHandler(FileStorageHandler.Collector paramCollector)
  {
    this.mCollector = paramCollector;
  }
  
  private int calculateRemainSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      return paramInt1;
    }
    float f1 = paramInt2;
    float f2 = paramInt1;
    if (f1 / f2 < 0.12F) {
      f1 = 0.05F;
    } else {
      f1 = 0.1F;
    }
    return (int)(f2 * f1);
  }
  
  private void notifyStorageWarning(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    if (!shouldShowWarning()) {}
  }
  
  private boolean shouldShowWarning()
  {
    long l1 = ((1.0F - 1.0F / (this.mWarnCount / 6.0F + 1.0F)) * 1800000.0F);
    long l2 = System.currentTimeMillis();
    boolean bool;
    if (l2 - this.mLastWarnTime >= l1) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      int i = this.mWarnCount;
      if (i < 2147483647) {
        this.mWarnCount = (i + 1);
      }
      this.mLastWarnTime = l2;
    }
    return bool;
  }
  
  public void onLowStorage(FileCacheService paramFileCacheService, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.mCounter.getAndIncrement() < 2) {
      return;
    }
    this.mCounter.set(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("low storage: totalSize=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", availableSize=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(", external=");
    localStringBuilder.append(paramBoolean);
    QDLog.w("downloader", localStringBuilder.toString());
    try
    {
      if ((this.mPendingFuture != null) && (!this.mPendingFuture.isDone())) {
        return;
      }
      paramFileCacheService = paramFileCacheService.getContext();
      this.mPendingFuture = PriorityThreadPool.getDefault().submit(new FileStorageHandler.1(this, paramBoolean, paramFileCacheService));
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.cache.file.FileStorageHandler
 * JD-Core Version:    0.7.0.1
 */