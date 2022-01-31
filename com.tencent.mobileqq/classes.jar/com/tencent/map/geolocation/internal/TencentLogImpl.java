package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.Log;
import c.t.m.g.f.a;
import c.t.m.g.p;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public final class TencentLogImpl
  implements TencentLog
{
  private static boolean DEBUG = false;
  private static final String TAG = "TencentLogImpl";
  private final File mBackupDir;
  private boolean mEncrypFlag = true;
  private Handler mHandler;
  private final Runnable mKiller;
  private boolean mPrepared;
  private HandlerThread mWorker;
  
  public TencentLogImpl(Context paramContext, @Nullable File paramFile)
  {
    this.mBackupDir = paramFile;
    if (paramFile != null)
    {
      bool1 = bool2;
      if (!paramFile.exists()) {
        if (!paramFile.mkdirs()) {
          break label171;
        }
      }
    }
    label171:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mPrepared = bool1;
      if (this.mPrepared)
      {
        this.mWorker = new HandlerThread("log_worker", 10);
        this.mWorker.start();
        this.mHandler = new LogHandler(this.mWorker.getLooper(), null);
      }
      this.mKiller = new Runnable()
      {
        public void run()
        {
          if (TencentLogImpl.this._isPrepared())
          {
            TencentLogImpl.access$202(TencentLogImpl.this, false);
            TencentLogImpl.this.mHandler.removeCallbacksAndMessages(null);
            TencentLogImpl.this.mWorker.quit();
          }
        }
      };
      if (DEBUG)
      {
        Log.i("TencentLogImpl", "log dir=" + this.mBackupDir);
        if (!this.mPrepared) {
          Log.e("TencentLogImpl", "init failed: mPrepared=" + this.mPrepared);
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
  
  public final void flush()
  {
    if (_isPrepared()) {
      this.mHandler.sendEmptyMessage(2);
    }
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
    if (DEBUG)
    {
      if (paramInt == 4) {
        Log.i(paramString1, paramString2);
      }
    }
    else {
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  public final void setEnCryp(boolean paramBoolean)
  {
    this.mEncrypFlag = paramBoolean;
  }
  
  public final void shutdown(long paramLong)
  {
    if (_isPrepared())
    {
      this.mHandler.sendEmptyMessage(2);
      this.mHandler.sendEmptyMessage(3);
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
  
  final class LogHandler
    extends Handler
  {
    private static final String TXWATCHDOG = "txwatchdog";
    private BufferedOutputStream mBos;
    private File mDest = makeSureDest();
    
    private LogHandler(Looper paramLooper)
    {
      super();
      try
      {
        this.mBos = new BufferedOutputStream(new FileOutputStream(this.mDest, true), 1024);
        return;
      }
      catch (Exception this$1)
      {
        TencentLogImpl.this.printStackTrace();
      }
    }
    
    private File makeSureDest()
    {
      File localFile = TencentLogImpl.this.mBackupDir;
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return new File(localFile, "txwatchdog");
    }
    
    public final void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      default: 
      case 1: 
        for (;;)
        {
          return;
          if ((this.mDest == null) || (!"txwatchdog".equals(this.mDest.getName()))) {
            this.mDest = makeSureDest();
          }
          try
          {
            if (TencentLogImpl.this.mEncrypFlag) {
              this.mBos.write(f.a.b(paramMessage.obj.toString().getBytes("GBK")));
            }
            for (;;)
            {
              paramMessage = TencentLogImpl.this.mBackupDir;
              File localFile = this.mDest;
              if ((paramMessage == null) || (localFile == null)) {
                break;
              }
              long l = System.currentTimeMillis();
              if (localFile.length() > 409600L) {
                localFile.renameTo(new File(paramMessage, "txwatchdog_" + l));
              }
              paramMessage = paramMessage.listFiles();
              if ((paramMessage == null) || (paramMessage.length <= 10)) {
                break;
              }
              int j = paramMessage.length;
              int i = 0;
              while (i < j)
              {
                localFile = paramMessage[i];
                if ((!"txwatchdog".equals(localFile.getName())) && (!localFile.isDirectory()) && (localFile.getName().startsWith("txwatchdog_")) && (l - localFile.lastModified() > -1702967296L)) {
                  localFile.delete();
                }
                i += 1;
              }
              this.mBos.write(paramMessage.obj.toString().getBytes("GBK"));
            }
            try
            {
              if (this.mBos != null)
              {
                this.mBos.flush();
                return;
              }
            }
            catch (IOException paramMessage)
            {
              paramMessage.printStackTrace();
              this.mDest = null;
              p.a(this.mBos);
              return;
              try
              {
                this.mDest = null;
                p.a(this.mBos);
                return;
              }
              catch (Exception paramMessage) {}
            }
            catch (Throwable paramMessage) {}
          }
          catch (Exception paramMessage)
          {
            this.mDest = null;
            p.a(this.mBos);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.geolocation.internal.TencentLogImpl
 * JD-Core Version:    0.7.0.1
 */