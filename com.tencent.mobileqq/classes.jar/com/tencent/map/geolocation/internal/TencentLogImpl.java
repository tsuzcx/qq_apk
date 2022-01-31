package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.Log;
import java.io.File;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

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
  
  final class LogHandler
    extends Handler
  {
    private static final String TXWATCHDOG = "txwatchdog";
    private File mDest = makeSureDest();
    
    private LogHandler(Looper paramLooper)
    {
      super();
    }
    
    private File makeSureDest()
    {
      File localFile = TencentLogImpl.this.mBackupDir;
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return new File(localFile, "txwatchdog");
    }
    
    /* Error */
    public final void handleMessage(Message paramMessage)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 54	android/os/Handler:handleMessage	(Landroid/os/Message;)V
      //   5: aload_0
      //   6: getfield 28	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
      //   9: ifnull +18 -> 27
      //   12: ldc 11
      //   14: aload_0
      //   15: getfield 28	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
      //   18: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
      //   21: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   24: ifne +11 -> 35
      //   27: aload_0
      //   28: aload_0
      //   29: invokespecial 26	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:makeSureDest	()Ljava/io/File;
      //   32: putfield 28	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
      //   35: aload_1
      //   36: getfield 70	android/os/Message:obj	Ljava/lang/Object;
      //   39: invokevirtual 75	java/lang/Object:toString	()Ljava/lang/String;
      //   42: ldc 77
      //   44: invokevirtual 81	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   47: astore 5
      //   49: aload_0
      //   50: getfield 28	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
      //   53: astore_1
      //   54: new 83	java/io/BufferedOutputStream
      //   57: dup
      //   58: new 85	java/io/FileOutputStream
      //   61: dup
      //   62: aload_1
      //   63: iconst_1
      //   64: invokespecial 88	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   67: invokespecial 91	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   70: astore 4
      //   72: aload 4
      //   74: astore_1
      //   75: aload 4
      //   77: aload 5
      //   79: invokevirtual 95	java/io/BufferedOutputStream:write	([B)V
      //   82: aload 4
      //   84: astore_1
      //   85: aload 4
      //   87: invokevirtual 99	java/io/BufferedOutputStream:flush	()V
      //   90: aload 4
      //   92: invokestatic 105	c/t/m/g/ev:a	(Ljava/io/Closeable;)V
      //   95: aload_0
      //   96: getfield 19	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:this$0	Lcom/tencent/map/geolocation/internal/TencentLogImpl;
      //   99: invokestatic 36	com/tencent/map/geolocation/internal/TencentLogImpl:access$500	(Lcom/tencent/map/geolocation/internal/TencentLogImpl;)Ljava/io/File;
      //   102: astore_1
      //   103: aload_0
      //   104: getfield 28	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
      //   107: astore 4
      //   109: aload_1
      //   110: ifnull +8 -> 118
      //   113: aload 4
      //   115: ifnonnull +33 -> 148
      //   118: return
      //   119: astore 5
      //   121: aconst_null
      //   122: astore_1
      //   123: aload 5
      //   125: athrow
      //   126: astore 5
      //   128: aload_1
      //   129: astore 4
      //   131: aload 5
      //   133: astore_1
      //   134: aload 4
      //   136: invokestatic 105	c/t/m/g/ev:a	(Ljava/io/Closeable;)V
      //   139: aload_1
      //   140: athrow
      //   141: astore_1
      //   142: aload_0
      //   143: aconst_null
      //   144: putfield 28	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
      //   147: return
      //   148: invokestatic 111	java/lang/System:currentTimeMillis	()J
      //   151: lstore_2
      //   152: aload 4
      //   154: invokevirtual 114	java/io/File:length	()J
      //   157: ldc2_w 115
      //   160: lcmp
      //   161: ifle -43 -> 118
      //   164: aload 4
      //   166: new 38	java/io/File
      //   169: dup
      //   170: aload_1
      //   171: ldc 118
      //   173: lload_2
      //   174: invokestatic 122	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   177: invokevirtual 126	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   180: invokespecial 48	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   183: invokevirtual 130	java/io/File:renameTo	(Ljava/io/File;)Z
      //   186: pop
      //   187: return
      //   188: astore_1
      //   189: aconst_null
      //   190: astore 4
      //   192: goto -58 -> 134
      //   195: astore 5
      //   197: aload 4
      //   199: astore_1
      //   200: goto -77 -> 123
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	203	0	this	LogHandler
      //   0	203	1	paramMessage	Message
      //   151	23	2	l	long
      //   70	128	4	localObject1	Object
      //   47	31	5	arrayOfByte	byte[]
      //   119	5	5	localIOException1	java.io.IOException
      //   126	6	5	localObject2	Object
      //   195	1	5	localIOException2	java.io.IOException
      // Exception table:
      //   from	to	target	type
      //   54	72	119	java/io/IOException
      //   75	82	126	finally
      //   85	90	126	finally
      //   123	126	126	finally
      //   35	54	141	java/io/IOException
      //   90	95	141	java/io/IOException
      //   134	141	141	java/io/IOException
      //   54	72	188	finally
      //   75	82	195	java/io/IOException
      //   85	90	195	java/io/IOException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.geolocation.internal.TencentLogImpl
 * JD-Core Version:    0.7.0.1
 */