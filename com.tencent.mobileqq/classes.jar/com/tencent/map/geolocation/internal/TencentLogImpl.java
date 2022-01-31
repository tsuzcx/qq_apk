package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.format.DateFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

public final class TencentLogImpl
  implements TencentLog
{
  private static boolean DEBUG = false;
  private static final String TAG = "TencentLogImpl";
  private final File mBackupDir;
  private Handler mHandler;
  private final Runnable mKiller;
  private boolean mPrepared;
  private HandlerThread mWorker;
  
  public TencentLogImpl(Context paramContext, @Nullable File paramFile)
  {
    this.mBackupDir = paramFile;
    if ((paramFile != null) && ((paramFile.exists()) || (paramFile.mkdirs()))) {}
    for (boolean bool = true;; bool = false)
    {
      this.mPrepared = bool;
      if (this.mPrepared)
      {
        this.mWorker = new HandlerThread("log_worker", 10);
        this.mWorker.start();
        this.mHandler = new TencentLogImpl.LogHandler(this, this.mWorker.getLooper(), null);
      }
      this.mKiller = new TencentLogImpl.1(this);
      if (DEBUG)
      {
        new StringBuilder("log dir=").append(this.mBackupDir);
        if (!this.mPrepared) {
          new StringBuilder("init failed: mPrepared=").append(this.mPrepared);
        }
      }
      return;
    }
  }
  
  private boolean _isPrepared()
  {
    return (this.mPrepared) && (this.mHandler != null);
  }
  
  public static boolean isDebugEnabled()
  {
    return DEBUG;
  }
  
  public static void setDebugEnabled(boolean paramBoolean)
  {
    DEBUG = paramBoolean;
  }
  
  public final String getDirString()
  {
    if (this.mBackupDir != null) {
      return this.mBackupDir.getName();
    }
    return null;
  }
  
  final boolean isPrepared()
  {
    return this.mPrepared;
  }
  
  public final void println(String paramString1, int paramInt, @NonNull String paramString2)
  {
    if (_isPrepared())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(DateFormat.format("yyyy-MM-dd kk:mm:ss", System.currentTimeMillis()));
      localStringBuilder.append(":").append(paramString1);
      localStringBuilder.append(":").append(paramString2).append("\n");
      this.mHandler.obtainMessage(1, localStringBuilder.toString()).sendToTarget();
    }
  }
  
  public final void shutdown(long paramLong)
  {
    if (_isPrepared())
    {
      this.mHandler.removeCallbacks(this.mKiller);
      this.mHandler.postDelayed(this.mKiller, paramLong);
    }
  }
  
  public final boolean tryRestart()
  {
    boolean bool = false;
    if (_isPrepared())
    {
      this.mHandler.removeCallbacks(this.mKiller);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.geolocation.internal.TencentLogImpl
 * JD-Core Version:    0.7.0.1
 */